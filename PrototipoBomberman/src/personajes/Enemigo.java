package personajes;

import java.util.Random;

import juego.Celda;
import juego.Tablero;

public abstract class Enemigo extends Personaje {

	protected int puntaje;

	protected Enemigo (boolean modoAtravesar, int vel, Celda c, Tablero t, int p) {

		super(modoAtravesar, vel, c, t);
	}

	public int getPuntaje () {
		return puntaje;
	}

	public void mover () {
		int dir = new Random().nextInt(4);
		calcularCeldaSiguiente(dir).avanzar(this, dir);
		System.out.println("Soy " + this.getClass().getName() + ". Mi posicion nueva es x: " + getCelda().getX() + " - y: " + getCelda().getY());
	}
	
	@Override
	public void matar(){
		System.out.println("Murio " + this.getClass().getSimpleName());
		estoyVivo = false;
		//TODO Eliminar/Detener el thread que contiene a este Enemigo
	}
}