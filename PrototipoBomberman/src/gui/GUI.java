package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import juego.Juego;

/**
 * Clase encargada de dibujar los paneles y administrar las entradas por teclado
 * para movilizar al Bomberman.
 * 
 * @author Asencio Victor, Gutierrez Gabriel, Iurchuk Joaquín
 */

@SuppressWarnings("serial")
public class GUI extends JFrame {

	private static GUI g;
	private Juego miJuego;
	private JLabel labelPuntaje;
	private JLabel labelTiempo;
	private JPanel panelControl;
	private JLabel titulo;

	/**
	 * Metodo que da el puntapie inicial al juego.
	 * 
	 * @param args
	 *            String del metodo main.
	 */
	public static void main(String[] args) {
		g = new GUI("Bomberman");
		g.repaint();
	}

	/**
	 * Constructor que inicializa la GUI del juego.
	 * @param nombre Titulo que llevará el frame que contenga a la GUI
	 */
	private GUI(String nombre) {

		super(nombre);

		panelControl = new JPanel();
		panelControl.setLayout(null);
		panelControl.setSize(Const.ANCHO_GUI, Const.ALTO_ENCABEZADO);
		panelControl.setBackground(new Color(200, 200, 200, 200));

		titulo = new JLabel("BOMBERMAN");
		labelPuntaje = new JLabel("SCORE: 0");
		labelTiempo = new JLabel("TIME: " + "00:00");
		
		configurarJPanel(panelControl);
		configurarLabels(panelControl);

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

	private void configurarJPanel(JPanel panelControl) {
		setPreferredSize(new Dimension(Const.ANCHO_GUI, Const.ALTO_GUI + Const.ALTO_ENCABEZADO));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		getContentPane().setLayout(null);
		setBounds(0, 0, Const.ANCHO_GUI, Const.ALTO_GUI);
		panelControl.setBorder(new EmptyBorder(Const.EMPTY_BORDER, Const.EMPTY_BORDER, Const.EMPTY_BORDER, Const.EMPTY_BORDER));

		setContentPane(panelControl);

		panelControl.setLocation(0, 50);
		panelControl.setLayout(null);
		panelControl.setBackground(new Color(50, 175, 50, 255));

		this.pack();
		this.setLocationRelativeTo(null);
		
		
	}

	private void configurarLabels(JPanel panelControl) {
		

		titulo.setForeground(Color.WHITE);
		labelPuntaje.setForeground(Color.WHITE);
		labelTiempo.setForeground(Color.WHITE);

		titulo.setLocation(0, 0);
		labelPuntaje.setLocation((Const.ANCHO_GUI / 2), 0);
		labelTiempo.setLocation((Const.ANCHO_GUI / 4) * 3, 0);

		titulo.setSize(Const.ANCHO_GUI / 2, Const.ALTO_ENCABEZADO);
		labelPuntaje.setSize(Const.ANCHO_GUI / 4, Const.ALTO_ENCABEZADO);
		labelTiempo.setSize(Const.ANCHO_GUI / 4, Const.ALTO_ENCABEZADO);

		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelPuntaje.setHorizontalAlignment(SwingConstants.CENTER);
		labelTiempo.setHorizontalAlignment(SwingConstants.CENTER);

		Font customFont = loadArcadeFont();
		labelTiempo.setFont(customFont);
		titulo.setFont(customFont);
		labelPuntaje.setFont(customFont);
		
		titulo.setBackground(new Color(180, 180, 180));
		titulo.setOpaque(true);
		labelPuntaje.setBackground(new Color(180, 180, 180));
		labelPuntaje.setOpaque(true);
		labelTiempo.setBackground(new Color(180, 180, 180));
		labelTiempo.setOpaque(true);
		

		panelControl.add(titulo);
		panelControl.add(labelPuntaje);
		panelControl.add(labelTiempo);
	}

	private Font loadArcadeFont() {
		Font customFont = null;
		try {
			URL url = getClass().getResource("/Recursos/fonts/arcade.ttf");
			customFont = Font.createFont(Font.TRUETYPE_FONT, url.openStream()).deriveFont(20f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(customFont);
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
		}
		
		return customFont;
	}

	public void actualizarPuntaje(int puntaje) {
		labelPuntaje.setText("SCORE: " + puntaje);
		repaint();
	}

	public void actualizarTiempo(int minutos, int seg) {
		labelTiempo.setText("TIME: " + String.format("%02d", minutos) + ":" + String.format("%02d", seg));
		repaint();
	}

	/**
	 * Recibe un evento de teclado, identifica a que dirección corresponde y le
	 * avisa al juego que mueva a Bomberman apropiadamente.
	 * 
	 * @param keyEvent Evento de teclado recibido.
	 */
	private void mover(KeyEvent keyEvent) {

		if (keyEvent.getKeyCode() == KeyEvent.VK_SPACE) {
			miJuego.getBomberman().colocarBomba();

		} else {
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
	
	public void relanzarJuego(){

		System.out.println("Relanzar juego");
		panelControl = new JPanel();
		panelControl.setLayout(null);
		panelControl.setSize(Const.ANCHO_GUI, Const.ALTO_ENCABEZADO);
		panelControl.setBackground(new Color(200, 200, 200, 200));

		configurarLabels(panelControl);

		configurarJPanel(panelControl);

		miJuego = new Juego(this);
		miJuego.iniciarJuego();
		repaint();
	}
}