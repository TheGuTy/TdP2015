package Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Juego.Juego;
import Gui.Tiempo;

public class Gui extends JFrame {

	private Juego miJuego;
	private Tiempo miTiempo;
	private JPanel contentPane;
	
	private Gui (String nombre) {
		
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
		setLayout(new BorderLayout());				
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setFocusable(true);		
		getContentPane().setLayout(null);		
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.GREEN);		
				
		miJuego = new Juego();	
		miJuego.iniciarJuego();
	}
	
	private void mover (KeyEvent key) {
		miJuego.moverBomberman(key.getKeyCode());
		this.repaint();
	}
	
	public static void main(String[] args) {
		Gui g = new Gui("Bomberman");
	}
}