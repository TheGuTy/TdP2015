package Juego;

import Personajes.Personaje;

public class EstadoNoDestruible extends EstadoCelda {

	@Override
	public void destruir(Celda c) {
		//No hacer nada
	}

	@Override
	public void avanzar(Personaje p, Celda c) {
		//No hacer nada
	}
}