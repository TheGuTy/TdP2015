package Juego;

import Personajes.Personaje;

public abstract class EstadoCelda {

	public abstract void destruir (Celda c);
	
	public abstract void avanzar (Personaje p, Celda c);
}
