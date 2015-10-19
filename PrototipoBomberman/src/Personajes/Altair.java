package Personajes;

import java.util.Random;

import Juego.Celda;
import Juego.Tablero;

public class Altair extends Enemigo {

	public Altair (Celda c, Tablero t) {
		
		super(true, 1, c, t, 20);
	}

	@Override
	public void mover() {
		
		super.mover();
	}

	@Override
	public void matar() {
		
		
	}
}
