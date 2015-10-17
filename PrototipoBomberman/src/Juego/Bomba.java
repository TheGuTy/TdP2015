package Juego;

public class Bomba {

	protected int alcance;
	protected Tablero miTablero;
	protected Celda miCelda;
	
	public Bomba (Celda c, int alcance, Tablero t) {
		
		miCelda = c;
		this.alcance = alcance;
		miTablero = t;
	}
	
	public void comenzarDetonacion () {
		
	}
}
