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
		
		this.miGrafico.getGrafico().setIcon(null);
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
		Celda celdaSiguiente;
		String ultimoMovimiento = "";

		switch (dir) {
			case 0: { // arriba
				yActual--;
				if (yActual < 0)
					yActual = 0;
				ultimoMovimiento = "arriba";
				break;
			}
			case 1: { // abajo
				yActual++;
				if (yActual >= miTablero.getAlto())
					yActual = miTablero.getAlto() - 1;
	
				ultimoMovimiento = "abajo";
				break;
			}
			case 2: { // izquierda
				xActual--;
				if (xActual <= 0)
					xActual = 0;
				ultimoMovimiento = "izquierda";
				break;
			}
			case 3: { // derecha
				xActual++;
				if (xActual >= miTablero.getAncho())
					xActual = miTablero.getAncho() - 1;
				ultimoMovimiento = "derecha";
				break;
			}
		}
		miGrafico.mover(dir);
		miGrafico.changeIcon(dir);
		celdaSiguiente = miTablero.getCelda(xActual, yActual);

//		System.out.println("Soy " + this.getClass().getName() + ". Mi posicion antes de moverme es x: "
//				+ getCelda().getX() + " - y: " + getCelda().getY());
		celdaSiguiente.avanzar(this);
		System.out.println("Soy " + this.getClass().getName() + ". Mi posicion nueva es x: " + getCelda().getX()
				+ " - y: " + getCelda().getY() + ". Mi movimiento fue " + ultimoMovimiento);
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
