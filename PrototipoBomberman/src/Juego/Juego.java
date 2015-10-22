package Juego;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.JLabel;

import Gui.Gui;
import Gui.Tiempo;
import Personajes.Altair;
import Personajes.Bomberman;
import Personajes.Enemigo;

public class Juego implements Runnable {

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
		
		Random r = new Random();
		Enemigo altair1 = new Altair(miTablero.getCelda(5, 5), miTablero);
		
		//Enemigo altair1 = new Altair(miTablero.getCelda(r.nextInt(miTablero.getAncho()), r.nextInt(miTablero.getAlto())), miTablero);
		//Enemigo e2 = new Rugulus(miTablero.getCelda(r.nextInt(31), r.nextInt(31)), miTablero);
		//Enemigo e3 = new Sirius(miTablero.getCelda(r.nextInt(31), r.nextInt(31)), miTablero);
		
		misEnemigos.add(altair1);
		//misEnemigos.add(e2);
		//misEnemigos.add(e3);		
		
	}				
		
	public Tiempo getMiTiempo() {
		return miTiempo;
	}

	public void iniciarJuego(){
		
		Thread t = new Thread(this);
		t.start();
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

	@Override
	public void run() {
		
		miBomberman.start();
		miTiempo.start();
		
		JLabel grafBomberman = miBomberman.getLabel();
		miBomberman.getGrafico().changeIcon(3);
		grafBomberman.setLocation(miBomberman.getPos());
		gui.add(grafBomberman);
		
		// Agrego todos los enemigos a la gui
		for (Enemigo e: misEnemigos) {
			e.getGrafico().changeIcon(3);
			e.getLabel().setLocation(e.getPos());
			gui.add(e.getLabel());
			e.start();
		}
		
		
		gui.repaint();
		try {					
			while (true) {
				grafBomberman.setLocation(miBomberman.getPos());
				for (Enemigo e: misEnemigos)
					e.getLabel().setLocation(e.getPos());
				gui.revalidate();
				Thread.sleep(50);
			}
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}
