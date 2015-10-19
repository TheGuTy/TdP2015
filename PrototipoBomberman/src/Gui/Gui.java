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
				//mover(arg0);
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
				
		miJuego = new Juego();
		miTiempo = new Tiempo(miJuego);
		miTiempo.start();
	}
	
	private void mover (int dir) {
		
		
	}
	
	public static void main(String[] args) {
		
		Gui g = new Gui("Bomberman");		

	}

}
