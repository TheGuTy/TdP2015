package Personajes;

import Juego.Celda;
import Juego.Tablero;

public class Bomberman extends Personaje {

	protected int bombasDisponibles;
	protected int miAlcanceBomba;

	public Bomberman(Celda c, Tablero tablero) {

		super(false, 1, c, tablero);
//		this.miGrafico = new GraficoBomberman(1, 1, 1);
	}

	@Override
	public void matar() {

	}

	public void setModoDios(boolean b) {

		modoDios = b;
	}

	public void colocarBomba() {

		miTablero.colocarBomba(miCelda.getX(), miCelda.getY(), miAlcanceBomba);
	}

	public void mover(int dir) {

		switch (dir) {
		case 38: // Arriba
			super.mover(0);
			break;
		case 40: // Abajo
			super.mover(1);
			break;
		case 37: // Izquierda
			super.mover(2);
			break;
		case 39: // Derecha
			super.mover(3);
			break;
		}
	}

	public void duplicarVelocidad() {

		velocidad *= 2;
	}

	public void aumentarBombasDisponibles() {

		bombasDisponibles++;
	}

	public void duplicarAlcance() {

		miAlcanceBomba *= 2;
	}
}
