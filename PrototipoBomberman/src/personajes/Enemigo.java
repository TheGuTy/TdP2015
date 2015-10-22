package personajes;

import java.util.Random;

import juego.Celda;
import juego.Tablero;

public abstract class Enemigo extends Personaje {

	protected int puntaje;

	protected Enemigo (boolean modoDios, int vel, Celda c, Tablero t, int p) {

		super(modoDios, vel, c, t);
	}

	public int getPuntaje () {
		return puntaje;
	}

	public void mover () {
		int dir = new Random().nextInt(4);
		calcularCeldaSiguiente(dir).avanzar(this, dir);
		System.out.println("Soy " + this.getClass().getName() + ". Mi posicion nueva es x: " + getCelda().getX() + " - y: " + getCelda().getY());
	}
}