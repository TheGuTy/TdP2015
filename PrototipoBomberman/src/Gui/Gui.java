package Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Juego.Juego;

public class Gui extends JFrame {

	private Juego miJuego;
	public JPanel contentPane;
	private boolean lock;

	private Gui(String nombre) {

		super(nombre);

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				mover(arg0);
			}
		});

		setPreferredSize(new Dimension(800, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		pack();
		setLocationRelativeTo(null);

		setFocusable(true);
		getContentPane().setLayout(null);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.GREEN);

		setVisible(true);

		miJuego = new Juego(this);
	}

	private void mover(KeyEvent key) {
		if (!lock) {
			lock = true;
			
			int direccion = 0;
			switch (key.getKeyCode()) {
			case 38: // Arriba
				direccion = 0;
				break;
			case 40: // Abajo
				direccion = 1;
				break;
			case 37: // Izquierda
				direccion = 2;
				break;
			case 39: // Derecha
				direccion = 3;
				break;
			}

			miJuego.moverBomberman(direccion);
			this.revalidate();
		}
		lock = !lock;
	}

	private void iniciarJuego() {

		miJuego.iniciarJuego();
	}

	public static void main(String[] args) {
		Gui g = new Gui("Bomberman");
		g.iniciarJuego();
	}
}