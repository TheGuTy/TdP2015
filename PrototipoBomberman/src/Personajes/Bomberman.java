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
		
		miTablero.colocarBomba(miCelda.getX(), miCelda.getY(), miAlcanceBomba);
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
		
		velocidad *= 2;
	}
	
	public void aumentarBombasDisponibles () {
	
		bombasDisponibles ++;
	}
	
	public void duplicarAlcance () {
		
		miAlcanceBomba *= 2;
	}
}
