package juego;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JLabel;

import gui.Const;
import gui.GUI;
import gui.Tiempo;
import personajes.Altair;
import personajes.Bomberman;
import personajes.Enemigo;
import threads.EnemigoThread;

public class Juego {

	private int puntaje;
	private Tablero miTablero;
	private Bomberman miBomberman;
	private List<EnemigoThread> misEnemigos;
	private Tiempo miTiempo;
	private GUI gui;
	
	public Juego (GUI gui) {
		
		this.gui = gui;
		puntaje = 0;
		miTablero = new Tablero(50, this, Const.CANT_CELDAS_ANCHO, Const.CANT_CELDAS_ALTO);
		miTiempo = new Tiempo();
		
		miBomberman = new Bomberman(miTablero.getCelda(1, 1), miTablero);
		
		misEnemigos = new LinkedList<EnemigoThread>();
		
		Enemigo alt1 = new Altair(miTablero.getCelda(5, 5), miTablero);
		alt1.getLabel().setLocation(alt1.getPos());
		gui.add(alt1.getLabel());
		EnemigoThread altair1 = new EnemigoThread(alt1);
		
		misEnemigos.add(altair1);
	}				
		
	public Tiempo getMiTiempo() {
		return miTiempo;
	}

	public void iniciarJuego(){

		miTiempo.start();
		
		JLabel grafBomberman = miBomberman.getLabel();
		grafBomberman.setLocation(miBomberman.getPos());
		gui.add(grafBomberman);
		
		// Agrego todos los enemigos a la GUI
		for (EnemigoThread e: misEnemigos) {
			e.start();
		}
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
