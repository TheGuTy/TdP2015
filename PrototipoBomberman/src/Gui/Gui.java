package Gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Juego.Juego;

@SuppressWarnings("serial")
public class Gui extends JFrame {

	private Juego miJuego;
	public JPanel contentPane;

	/**
	 * Metodo que da el puntapie inicial al juego.
	 * @param args
	 */
	public static void main(String[] args) {
		Gui g = new Gui("Bomberman");
		g.iniciarJuego();

		try {
			while (true) {
				Thread.sleep(17); //Da la sensacion de 60fps : 60 x 17 ~ 1000
				g.repaint();
				g.revalidate();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private Gui(String nombre) {

		super(nombre);
		setPreferredSize(new Dimension(Const.ANCHO_GUI, Const.ALTO_GUI));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		getContentPane().setLayout(null);
		setBounds(100, 100, Const.ANCHO_GUI, Const.ALTO_GUI);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(Const.EMPTY_BORDER, Const.EMPTY_BORDER, Const.EMPTY_BORDER, Const.EMPTY_BORDER));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.GREEN);
		setVisible(true);

		
		miJuego = new Juego(this);

		
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

		int direccion = Const.MOVIMIENTO_ARRIBA; //por defecto
		
		switch (keyEvent.getKeyCode()) {
		case 38:
			direccion = Const.MOVIMIENTO_ARRIBA;
			break;
		case 40:
			direccion = Const.MOVIMIENTO_ABAJO;
			break;
		case 37:
			direccion = Const.MOVIMIENTO_IZQUIERDA;
			break;
		case 39:
			direccion = Const.MOVIMIENTO_DERECHA;
			break;
		}

		miJuego.moverBomberman(direccion);
	}

	private void iniciarJuego() {

		miJuego.iniciarJuego();
	}
}