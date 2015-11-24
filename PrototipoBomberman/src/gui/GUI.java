package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import juego.Juego;

/**
 * Clase encargada de dibujar los paneles y administrar las entradas por teclado
 * para movilizar al Bomberman.
 * @author Asencio Victor, Gutierrez Gabriel, Iurchuk Joaqu�n
 */

@SuppressWarnings("serial")
public class GUI extends JFrame {

	private Juego miJuego;
	private JPanel contentPane;

	/**
	 * Metodo que da el puntapie inicial al juego.
	 * @param args String del metodo main.
	 */
	public static void main(String[] args) {
		GUI g = new GUI("Bomberman");
		g.repaint();
	}
	
	/**
	 * Constructor impl�cito para inicializar el panel principal del juego.
	 * @param nombre Nombre correspondiente a la ventana principal.
	 */
	private GUI(String nombre) {
		
		super(nombre);

		JPanel panelControl = new JPanel();
		panelControl.setLayout(null);
		panelControl.setSize(Const.ANCHO_GUI, Const.ALTO_ENCABEZADO);
		panelControl.setBackground(new Color(200,200,200,200));
		
		JLabel titulo = new JLabel("BOMBERMAN");
		JLabel puntaje = new JLabel("MI PUNTAJE: ");
		JLabel tiempo = new JLabel("MI TIEMPO");
		
		
		titulo.setLocation(0, 0);
		puntaje.setLocation((Const.ANCHO_GUI/2), 0);
		tiempo.setLocation((Const.ANCHO_GUI/4)*3, 0);
		
		titulo.setSize(Const.ANCHO_GUI/2, Const.ALTO_ENCABEZADO);
		puntaje.setSize(Const.ANCHO_GUI/4, Const.ALTO_ENCABEZADO);
		tiempo.setSize(Const.ANCHO_GUI/4, Const.ALTO_ENCABEZADO);
		
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		puntaje.setHorizontalAlignment(SwingConstants.CENTER);
		tiempo.setHorizontalAlignment(SwingConstants.CENTER);
		
		titulo.setBackground(new Color(100,100,100,100)); titulo.setOpaque(true);
		puntaje.setBackground(new Color(0,0,0,0)); puntaje.setOpaque(true);
		tiempo.setBackground(new Color(200,200,200,200)); tiempo.setOpaque(true);
		
		panelControl.add(titulo);
		panelControl.add(puntaje); 
		panelControl.add(tiempo);
		
		setPreferredSize(new Dimension(Const.ANCHO_GUI, Const.ALTO_GUI+Const.ALTO_ENCABEZADO));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setLayout(null);
		getContentPane().setLayout(null);
		setBounds(0, 0, Const.ANCHO_GUI, Const.ALTO_GUI);
		contentPane = new JPanel();
		contentPane.setBorder( new EmptyBorder(Const.EMPTY_BORDER, Const.EMPTY_BORDER, Const.EMPTY_BORDER, Const.EMPTY_BORDER));
		
		
		contentPane.add(panelControl);

		setContentPane(contentPane);
		
		contentPane.setLocation(0, 50);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(50,175,50,255));
		
		
		
		// Con estas tres lineas podemos hacer que el JFrame se muestre
		// exactamente en el medio de la pantalla:
		this.pack();
		this.setLocationRelativeTo(null);		

		miJuego = new Juego(this);
		miJuego.iniciarJuego();

		// Oyente encargado de recibir el input desde el teclado del usuario y
		// reaccionar en consecuencia
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent keyEvent) {
				mover(keyEvent);
			}
		});
		
		this.setVisible(true);
	}

	/**
	 * Recibe un evento de teclado, identifica a que direcci�n corresponde y le
	 * avisa al juego que mueva a Bomberman apropiadamente.
	 * @param keyEvent Evento de teclado recibido.
	 */
	private void mover(KeyEvent keyEvent) {

		if (keyEvent.getKeyCode() == KeyEvent.VK_SPACE){
			miJuego.getBomberman().colocarBomba();

		}else {
			int direccion;
			switch (keyEvent.getKeyCode()) {
			case KeyEvent.VK_UP:
				direccion = Const.MOVIMIENTO_ARRIBA;
				break;
			case KeyEvent.VK_DOWN:
				direccion = Const.MOVIMIENTO_ABAJO;
				break;
			case KeyEvent.VK_LEFT:
				direccion = Const.MOVIMIENTO_IZQUIERDA;
				break;
			case KeyEvent.VK_RIGHT:
				direccion = Const.MOVIMIENTO_DERECHA;
				break;
			default:
				direccion = Const.MOVIMIENTO_ARRIBA;
				break;
			}

			miJuego.moverBomberman(direccion);
		}
	}
}