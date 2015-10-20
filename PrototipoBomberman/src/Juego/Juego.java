package Juego;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Gui.Gui;
import Gui.Tiempo;
import Personajes.Altair;
import Personajes.Bomberman;
import Personajes.Enemigo;
import Personajes.Rugulus;
import Personajes.Sirius;

public class Juego {

	private int puntaje;
	private Tablero miTablero;
	private Bomberman miBomberman;
	private List<Enemigo> misEnemigos;
	private Tiempo miTiempo;
	private Gui gui;
	
	public Juego (Gui gui) {
		
		this.gui = gui;
		puntaje = 0;
		miTablero = new Tablero(50, this, 31, 31);
		miTiempo = new Tiempo();
		miBomberman = new Bomberman(miTablero.getCelda(1, 1), miTablero);
		misEnemigos = new LinkedList<Enemigo>();
		miTiempo = new Tiempo();
		
		gui.add(new JLabel(new ImageIcon(this.getClass().getResource("/Recursos/arr.png"))));
		gui.revalidate();

		Random r = new Random();
		Enemigo e1 = new Altair(miTablero.getCelda(r.nextInt(31), r.nextInt(31)), miTablero);
		//Enemigo e2 = new Rugulus(miTablero.getCelda(r.nextInt(31), r.nextInt(31)), miTablero);
		//Enemigo e3 = new Sirius(miTablero.getCelda(r.nextInt(31), r.nextInt(31)), miTablero);
		
		misEnemigos.add(e1);
		//misEnemigos.add(e2);
		//misEnemigos.add(e3);		
		
		
	}				
		
	public Tiempo getMiTiempo() {
		return miTiempo;
	}

	public void iniciarJuego(){
		
		miBomberman.start();
		for (Enemigo e : misEnemigos)
			e.start();
		
		miTiempo.start();
	}
	
	public void aumentarPuntaje (int p) {
		
		puntaje += p;
	}
	
	public Bomberman getBomberman () {
		
		return miBomberman;
	}	
	
	public void finalizarJuego () {
		miTiempo.detener();
	}
	
	public void eliminarEnemigo (Enemigo e) {
		
	}	
	
	
	public void moverBomberman (int dir) {
		
		miBomberman.mover(dir);
	}
}
