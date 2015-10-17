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
				Celda c = misCeldas [i][j];
				c = new Celda(i, j, this);
				c.setEstado(new EstadoTransitable());	//Al crear todas las celdas asumo que todas son transitables
			}
		}
		
		crearNoDestruibles();
		distribuirDestruibles();
	}
	
	public void colocarBomba (int x, int y, int alcance) {
		
	}
	
	public Celda getCelda (int x, int y) {
		
		return misCeldas[x][y];
	}
	
	private void crearNoDestruibles () {
		
		Celda c;
		for (int i = 0; i < ancho; i++) {
			c = misCeldas[i][0];
			c.setEstado(new EstadoNoDestruible());
			c = misCeldas[i][alto-1];
			c.setEstado(new EstadoNoDestruible());			
		}
		
		for (int i = 0; i < alto; i++) {
			c = misCeldas[0][i];
			c.setEstado(new EstadoNoDestruible());
			c = misCeldas[ancho-1][i];
			c.setEstado(new EstadoNoDestruible());			
		}			
		
	}
	
	private void distribuirDestruibles () {
		
	}
	
	public void aumentarPuntaje (int p) {
		
		miJuego.aumentarPuntaje(p);
	}
	
	public void eliminarEnemigo (Enemigo e) {
		
	}
}
