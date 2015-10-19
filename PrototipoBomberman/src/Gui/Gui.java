package Gui;

import javax.swing.JFrame;

import Juego.Juego;
import Juego.Tiempo;

public class Gui extends JFrame {

	private Juego miJuego;
	private Tiempo miTiempo;
	
	private Gui (Juego j) {
		
		miJuego = j;
		miTiempo = new Tiempo(j);
		miTiempo.start();
	}
	
	public static void main(String[] args) {
		
		Juego j = new Juego();
		Gui g = new Gui(j);

	}

}
