package Personajes;

import java.util.Random;

import Juego.Celda;
import Juego.Tablero;

public abstract class Enemigo extends Personaje {

	protected int puntaje;
	protected Random r;

	protected Enemigo (boolean modoDios, int vel, Celda c, Tablero t, int p) {

		super(modoDios, vel, c, t);
		r = new Random();
	}

	public int getPuntaje () {

		return puntaje;
	}

	public void mover (int dir) {
						
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
		//miGrafico.mover(dir);
		//miGrafico.changeIcon(dir);
		celdaSiguiente = miTablero.getCelda(xActual, yActual);

//		System.out.println("Soy " + this.getClass().getName() + ". Mi posicion antes de moverme es x: "
//				+ getCelda().getX() + " - y: " + getCelda().getY());
		celdaSiguiente.avanzar(this);
		System.out.println("Soy " + this.getClass().getName() + ". Mi posicion nueva es x: " + getCelda().getX()
				+ " - y: " + getCelda().getY() + ". Mi movimiento fue " + ultimoMovimiento);
	}

	public void run () {
 
		try {
			while (estoyVivo) {

				Thread.sleep(2000 / velocidad);
				
				this.mover(r.nextInt(4));
			}
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}
}
