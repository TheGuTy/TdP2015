package Juego;

import Personajes.Bomberman;
import Personajes.Enemigo;

public abstract class EstadoCelda {

	public abstract void destruir (Celda c);
	
	public abstract void avanzar (Bomberman bomberman, Celda c, int dir);
	
	public abstract void avanzar (Enemigo enemigo, Celda c, int dir);
}
