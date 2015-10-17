package Personajes;

import Juego.Celda;
import Juego.Tablero;

public abstract class Personaje {

	protected boolean modoDios;
	protected int velocidad;
	protected Celda miCelda;
	protected Tablero miTablero;
	
	protected Personaje (boolean modoDios, int vel, Celda c, Tablero t) {
		
		this.modoDios = modoDios;
		velocidad = vel;
		miCelda = c;
		miTablero = t;
	}
	
	public abstract void matar ();
	
	public boolean enModoDios () {
		
		return modoDios;
	}
	
	public void setCelda (Celda c) {
		
	}
}
