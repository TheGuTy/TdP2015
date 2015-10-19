package Personajes;

import java.awt.event.KeyEvent;

import Juego.Celda;
import Juego.Tablero;

public class Bomberman extends Personaje {

	protected int bombasDisponibles;
	protected int miAlcanceBomba;
	
	public Bomberman (Celda c, Tablero t) {
		
		super(false, 1, c, t);
	}

	@Override
	public void matar() {
		
		
	}
	
	public void setModoDios (boolean b) {
		
		modoDios = b;
	}
	
	public void colocarBomba () {
		
		miTablero.colocarBomba(miCelda.getX(), miCelda.getY(), miAlcanceBomba);
	}
	
	public void mover (int dir) {
		
		int x = miCelda.getX();
		int y = miCelda.getY();
		Celda nueva = null;
		
		switch (dir){
		case KeyEvent.VK_UP : //Arriba
			nueva = miTablero.getCelda(x, y-1);
			break;
		case KeyEvent.VK_DOWN : //Abajo
			nueva = miTablero.getCelda(x, y+1);
			break;
		case KeyEvent.VK_LEFT : //Izquierda
			nueva = miTablero.getCelda(x-1, y);
			break;
		case KeyEvent.VK_RIGHT : //Derecha
			nueva = miTablero.getCelda(x+1, y);
			break;
		default: {
			this.setCelda(nueva);
		}
	}
	}
	
	private void moverArriba () {
		
	}
	
	private void moverAbajo () {
		
	}
	
	private void moverIzquierda () {
		
	}
	
	private void moverDerecha () {
		
	}
	
	public void duplicarVelocidad () {
		
		velocidad *= 2;
	}
	
	public void aumentarBombasDisponibles () {
	
		bombasDisponibles ++;
	}
	
	public void duplicarAlcance () {
		
		miAlcanceBomba *= 2;
	}
}
