package Personajes;

import Graficos.GraficoPersonaje;
import Juego.Celda;
import Juego.Tablero;

public abstract class Personaje extends Thread {

	protected boolean modoDios;
	protected int velocidad;
	protected Celda miCelda;
	protected Tablero miTablero;
	protected volatile boolean estoyVivo;
	protected GraficoPersonaje miGrafico;
	
	protected Personaje (boolean modoDios, int vel, Celda c, Tablero t) {
		
		this.modoDios = modoDios;
		velocidad = vel;
		miCelda = c;		
		miTablero = t;
		estoyVivo = true;
		miGrafico = null;
	}
	
	public abstract void matar ();
	
	public boolean enModoDios () {
		
		return modoDios;
	}
	
	public void setCelda (Celda c) {
		
		miCelda = c;
	}

	public Celda getCelda() {
		return miCelda;
	}
}