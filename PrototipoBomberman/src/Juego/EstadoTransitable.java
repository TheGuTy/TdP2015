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
				bomberman.lock();
				bomberman.getCelda().eliminarBomberman();
				bomberman.setCelda(celdaSiguiente);
				celdaSiguiente.agregarBomberman(bomberman);
				
				bomberman.moverGrafica(dir);
			}
			else
				System.out.println("Bomberman esta bloqueado");
		}		
	}

	@Override
	public void avanzar(Enemigo enemigo, Celda celdaSiguiente, int dir) {
		
		if (celdaSiguiente.hayBomberman()) {
			if (enemigo.getLock() == false) {
				enemigo.lock();
				System.out.println("El enemigo colisiona con bomberman");
				celdaSiguiente.matarBomberman();
				enemigo.getCelda().eliminarEnemigo(enemigo);
				enemigo.setCelda(celdaSiguiente);
				celdaSiguiente.agregarEnemigo(enemigo);
				
				enemigo.moverGrafica(dir);
			}
		} else {
			if (enemigo.getLock() == false) {
				enemigo.lock();
				enemigo.getCelda().eliminarEnemigo(enemigo);
				enemigo.setCelda(celdaSiguiente);
				celdaSiguiente.agregarEnemigo(enemigo);
				
				enemigo.moverGrafica(dir);
			}
		}
	}
}
