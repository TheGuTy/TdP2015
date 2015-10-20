package Personajes;

import java.awt.event.KeyEvent;

import Graficos.GraficoBomberman;
import Juego.Celda;
import Juego.Tablero;

public class Bomberman extends Personaje {

	protected int bombasDisponibles;
	protected int miAlcanceBomba;

	public Bomberman(Celda c, Tablero tablero) {

		super(false, 1, c, tablero);
		this.miGrafico = new GraficoBomberman(1, 1, 1);
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

		int xActual = miCelda.getX();
		int yActual = miCelda.getY();
		Celda nueva = null;		

		switch (dir) {
		case 38: // Arriba
			yActual--;
			if (yActual <= 0)
				yActual = 0;
			nueva = miTablero.getCelda(xActual, yActual);			
			break;
		case 40: // Abajo
			yActual++;
			if (yActual >= miTablero.getAlto())
				yActual = miTablero.getAlto() - 1;
			nueva = miTablero.getCelda(xActual, yActual);

			break;
		case 37: // Izquierda
			xActual--;
			if (xActual <= 0)
				xActual = 0;
			nueva = miTablero.getCelda(xActual, yActual);

			break;
		case 39: // Derecha
			xActual++;
			
			if (xActual == miTablero.getAncho())
				xActual = miTablero.getAncho();
			nueva = miTablero.getCelda(xActual, yActual);	
		}
		this.setCelda(nueva);		

	}

	private void moverArriba() {

	}

	private void moverAbajo() {

	}

	private void moverIzquierda() {

	}

	private void moverDerecha() {

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
