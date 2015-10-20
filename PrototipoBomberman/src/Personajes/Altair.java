package Personajes;

import Juego.Celda;
import Juego.Tablero;

public class Altair extends Enemigo {

	private final static int VELOCIDAD_INICIAL = 1;
	private final static int PUNTAJE = 20;
	
	public Altair (Celda celda, Tablero t) {
		
		super(false, VELOCIDAD_INICIAL, celda, t, PUNTAJE);
	}

	@Override
	public void mover() {
		
		super.mover();
	}

	@Override
	public void matar() {
		
		
	}
}
