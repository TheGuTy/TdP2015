package Juego;

import Personajes.Personaje;

public class EstadoTransitable extends EstadoCelda {

	@Override
	public void destruir(Celda c) {
		//No hacer nada
	}

	@Override
	public void avanzar(Personaje p, Celda c) {
		p.getCelda().eliminarPersonaje(p);
		p.setCelda(c);
		c.agregarPersonaje(p);
	}
}
