package Juego;

import Personajes.Bomberman;
import Personajes.Enemigo;

public class EstadoDestruible extends EstadoCelda {

	@Override
	public void destruir(Celda c) {
		c.destruirPersonajes();
		c.setEstado(new EstadoTransitable());
	}	

	@Override
	public void avanzar(Bomberman bomberman, Celda celdaSiguiente, int dir) {

		if (bomberman.enModoDios()){
			if (celdaSiguiente.hayEnemigos()) {
				bomberman.matar();
				System.out.println("El bomberman colisiona con un enemigo");			
			}else{
				if (bomberman.getLock() == false) {
					bomberman.getCelda().eliminarBomberman();
					bomberman.setCelda(celdaSiguiente);
					celdaSiguiente.agregarBomberman(bomberman);					
					bomberman.moverGrafica(dir);
				}					
			}
		}
	}

	@Override
	public void avanzar(Enemigo enemigo, Celda celdaSiguiente) {

		if (enemigo.enModoDios()){
			if (celdaSiguiente.hayBomberman()) {			
				System.out.println("El enemigo colisiona con bomberman");
				celdaSiguiente.matarBomberman();	
				enemigo.getCelda().eliminarEnemigo(enemigo);
				enemigo.setCelda(celdaSiguiente);
				celdaSiguiente.agregarEnemigo(enemigo); //TODO Notitificar que murio bomberman y la logica sigue
			} else {
				enemigo.getCelda().eliminarEnemigo(enemigo);
				enemigo.setCelda(celdaSiguiente);
				celdaSiguiente.agregarEnemigo(enemigo);
			}
		}
	}
}
