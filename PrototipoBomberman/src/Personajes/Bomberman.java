package Personajes;

import java.awt.event.KeyEvent;

import Juego.Celda;
import Juego.Tablero;

public class Bomberman extends Personaje {

	protected int bombasDisponibles;
	protected int miAlcanceBomba;

	public Bomberman(Celda c, Tablero t) {

		super(false, 1, c, t);
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

		int x = miCelda.getX();
		int y = miCelda.getY();
		Celda nueva = null;

		switch (dir) {
		case KeyEvent.VK_UP: // Arriba
			y--;
			if (y <= 0)
				y = 0;
			nueva = miTablero.getCelda(x, y);
			System.out.println("ARRIBA");
			break;
		case KeyEvent.VK_DOWN: // Abajo
			y++;
			if (y >= miTablero.getAlto())
				y = miTablero.getAlto() - 1;
			nueva = miTablero.getCelda(x, y + 1);
			System.out.println("ABAJO");
			break;
		case KeyEvent.VK_LEFT: // Izquierda
			x--;
			if (x <= 0)
				x = 0;
			nueva = miTablero.getCelda(x, y);
			System.out.println("IZQUIERDA");
			break;
		case KeyEvent.VK_RIGHT: // Derecha
			x++;
			if (x == miTablero.getAncho())
				x = miTablero.getAncho();
			nueva = miTablero.getCelda(x, y);
			System.out.println("DERECHA");
			break;
		default: {
			this.setCelda(nueva);
		}
		}

		System.out.println("Soy bomberman. Mi pos actual es x: " + x + " - y: " + y);
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
