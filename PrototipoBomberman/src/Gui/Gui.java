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
import Gui.Tiempo;

public class Gui extends JFrame {

	private Juego miJuego;
	public JPanel contentPane;
	
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
		
		setFocusable(true);		
		getContentPane().setLayout(null);		
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		contentPane.setBackground(Color.GREEN);
		
			
		repaint();
		setVisible(true);
				
		
		miJuego = new Juego(this);		
	}
	
	private void mover (KeyEvent key) {
		miJuego.moverBomberman(key.getKeyCode());
		this.repaint();
	}
	
	private void iniciarJuego () {
		
		miJuego.iniciarJuego();
	}
	
	public static void main(String[] args) {
		Gui g = new Gui("Bomberman");
		g.iniciarJuego();
	}
}