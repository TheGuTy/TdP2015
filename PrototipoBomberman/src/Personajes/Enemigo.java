package Personajes;

import Juego.Celda;
import Juego.Tablero;

public abstract class Enemigo extends Personaje {

	protected int puntaje;
	
	protected Enemigo (boolean modoDios, int vel, Celda c, Tablero t, int p) {
		
		super(modoDios, vel, c, t);
	}
	
	public int getPuntaje () {
		
		return puntaje;
	}
	
	public abstract void mover ();
}
