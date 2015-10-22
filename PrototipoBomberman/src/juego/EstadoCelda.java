package juego;

import personajes.Bomberman;
import personajes.Enemigo;

public abstract class EstadoCelda {

	public abstract void destruir (Celda c);
	
	public abstract void avanzar (Bomberman bomberman, Celda c, int dir);
	
	public abstract void avanzar (Enemigo enemigo, Celda c, int dir);
}
