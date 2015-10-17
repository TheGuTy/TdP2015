package Personajes;

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
		
	}
	
	public void moverArriba () {
		
	}
	
	public void moverAbajo () {
		
	}
	
	public void moverIzquierda () {
		
	}
	
	public void moverDerecha () {
		
	}
	
	public void duplicarVelocidad () {
		
	}
	
	public void aumentarBombasDisponibles () {
		
	}
	
	public void duplicarAlcance () {
		
	}
}
