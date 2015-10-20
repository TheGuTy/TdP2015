package Personajes;

import Graficos.GraficoBomberman;
import Juego.Celda;
import Juego.Tablero;

public class Bomberman extends Personaje {

	protected int bombasDisponibles;
	protected int miAlcanceBomba;

	public Bomberman(Celda c, Tablero tablero) {

		super(false, 8, c, tablero);
		this.miGrafico = new GraficoBomberman(8, 1, 1);
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

		super.mover(dir);
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
