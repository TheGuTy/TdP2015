package Juego;

import Personajes.Enemigo;

public class Tablero {

	protected int porcentajeDestruibles;
	protected Juego miJuego;
	protected Celda [][] misCeldas;
	protected int ancho, alto;
	
	public Tablero (int porcentaje, Juego juego, int ancho, int alto) {
		
		porcentajeDestruibles = porcentaje;
		miJuego = juego;
		this.ancho = ancho;
		this.alto = alto;
		
		for (int i = 0; i < ancho; i++) {
			for (int j = 0; j < alto; j++) {
				misCeldas [i][j] = new Celda(i, j, this);
			}
		}
		
		crearNoDestruibles();
		distribuirDestruibles();
	}
	
	public void colocarBomba (int x, int y, int alcance) {
		
	}
	
	public Celda getCelda (int x, int y) {
		
		return null;
	}
	
	private void crearNoDestruibles () {
		
		for (int i = 0; i < ancho; i++) {
			misCeldas[i][0].setEstado(new EstadoNoDestruible());
			misCeldas[i][alto-1].setEstado(new EstadoNoDestruible());
		}
		
		for (int i = 0; i < alto; i++) {
			misCeldas[0][i].setEstado(new EstadoNoDestruible());
			misCeldas[ancho-1][i].setEstado(new EstadoNoDestruible());
		}			
		
	}
	
	private void distribuirDestruibles () {
		
	}
	
	public void aumentarPuntaje (int p) {
		
		
	}
	
	public void eliminarEnemigo (Enemigo e) {
		
	}
}
