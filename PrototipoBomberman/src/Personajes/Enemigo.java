package Personajes;

import java.util.Random;

import Juego.Celda;
import Juego.Tablero;

public abstract class Enemigo extends Personaje {

	protected int puntaje;
	protected Random r = new Random();

	protected Enemigo (boolean modoDios, int vel, Celda c, Tablero t, int p) {

		super(modoDios, vel, c, t);
	}

	public int getPuntaje () {

		return puntaje;
	}

	public void mover () {
		
		int random = r.nextInt(4);
		super.mover(random);
	}

	public void run () {
 
		try {
			while (estoyVivo) {

				Thread.sleep(2000 / velocidad);
				this.mover();
			}
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}
}
