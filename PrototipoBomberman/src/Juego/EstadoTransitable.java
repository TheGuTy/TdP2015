package Juego;

import Personajes.Bomberman;
import Personajes.Enemigo;

public class EstadoTransitable extends EstadoCelda {

	@Override
	public void destruir(Celda c) {
		//No hacer nada
	}
	

	@Override
	public void avanzar(Bomberman bomberman, Celda celdaSiguiente, int dir) {
		
		if (celdaSiguiente.hayEnemigos()) {
			bomberman.matar();
			System.out.println("El bomberman colisiona con un enemigo");			
		} else {
			if (bomberman.getLock() == false) {
				bomberman.getCelda().eliminarBomberman();
				bomberman.setCelda(celdaSiguiente);
				celdaSiguiente.agregarBomberman(bomberman);
				
				bomberman.moverGrafica(dir);
			}			
		}		
	}

	@Override
	public void avanzar(Enemigo enemigo, Celda celdaSiguiente) {
		
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
