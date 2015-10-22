package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import juego.Juego;

@SuppressWarnings("serial")
public class GUI extends JFrame {

	private Juego miJuego;
	private JPanel contentPane;

	/**
	 * Metodo que da el puntapie inicial al juego.
	 * @param args
	 */
	public static void main(String[] args) {
		GUI g = new GUI("Bomberman");
		g.repaint();
	}

	private GUI(String nombre) {

		super(nombre);
		setPreferredSize(new Dimension(Const.ANCHO_GUI, Const.ALTO_GUI));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		getContentPane().setLayout(null);
		setBounds(100, 100, Const.ANCHO_GUI, Const.ALTO_GUI);
		contentPane = new JPanel();
		contentPane.setBorder(
				new EmptyBorder(Const.EMPTY_BORDER, Const.EMPTY_BORDER, Const.EMPTY_BORDER, Const.EMPTY_BORDER));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(50,175,50,255));

		// Con estas tres lineas podemos hacer que el JFrame se muestre
		// exactamente en el medio de la pantalla:
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);

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
	}

	/**
	 * Recibe un evento de teclado, identifica a que direccion corresponde y le
	 * avisa al juego que mueva a Bomberman apropiadamente
	 * 
	 * @param keyEvent evento de teclado recibido
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