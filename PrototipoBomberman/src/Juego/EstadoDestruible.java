package Juego;

import Personajes.Personaje;

public class EstadoDestruible extends EstadoCelda {

	@Override
	public void destruir(Celda c) {
		c.destruirPersonajes();
		c.setEstado(new EstadoTransitable());
	}	

	@Override
	public void avanzar(Personaje p, Celda c) {
		if (p.enModoDios()){
			p.getCelda().eliminarPersonaje(p);
			p.setCelda(c);
			c.agregarPersonaje(p);
		}
	}
}
