package Juego;

import Personajes.Bomberman;
import Personajes.Enemigo;

public class EstadoNoDestruible extends EstadoCelda {

	@Override
	public void destruir(Celda c) {
		//No hacer nada
	}

	@Override
	public void avanzar(Bomberman bomberman, Celda celdaSiguiente, int dir) {
		//No hacer nada
	}

	@Override
	public void avanzar(Enemigo enemigo, Celda celdaSiguiente, int dir) {
		//No hacer nada
	}
}