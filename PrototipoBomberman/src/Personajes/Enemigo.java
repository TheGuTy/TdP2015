package Personajes;

import java.util.Random;

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
	
	public void mover () {
		
		Random r = new Random();
		int random = r.nextInt(4);
		
		switch (random) {
		case 0: {	//arriba
			Celda c = miTablero.getCelda(miCelda.getX(), miCelda.getY() - 1);
			this.setCelda(c);
		}
		case 1: {	//abajo
			Celda c = miTablero.getCelda(miCelda.getX(), miCelda.getY() + 1);
			this.setCelda(c);
		}
		case 2: {	//izquierda
			Celda c = miTablero.getCelda(miCelda.getX() - 1, miCelda.getY());
			this.setCelda(c);
		}
		case 3: {	//derecha
			Celda c = miTablero.getCelda(miCelda.getX() + 1, miCelda.getY());
			this.setCelda(c);
		}
		}
	}
}
