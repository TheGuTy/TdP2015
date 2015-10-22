package juego;

import graficos.GraficoParedNoDestruible;
import gui.GUI;
import personajes.Enemigo;

public class Tablero {

	protected int porcentajeDestruibles;
	protected Juego miJuego;
	protected Celda [][] misCeldas;
	protected int ancho, alto;
	protected GUI gui;
	
	public Tablero (int porcentaje, Juego juego, int ancho, int alto, GUI gui) {
		porcentajeDestruibles = porcentaje;
		miJuego = juego;
		this.ancho = ancho;
		this.alto = alto;
		misCeldas = new Celda[this.ancho][this.alto];
		this.gui = gui;
		
		for (int i = 0; i < this.ancho; i++) {
			for (int j = 0; j < this.alto; j++) {
				misCeldas [i][j] = new Celda(i, j, this);
				//TODO crear todas las celdas con sus graficas. Patron builder? Factory?
				misCeldas [i][j].setEstado(new EstadoTransitable(i, j));	//Al crear todas las celdas asumo que todas son transitables
			}
		}
		
		crearNoDestruibles();
		distribuirDestruibles();
	}
	
	public void colocarBomba (int x, int y, int alcance) {
		Celda c = getCelda(x, y);
		Bomba b = new Bomba(c, 1, this);
		b.comenzarDetonacion();
	}
	
	public Celda getCelda (int x, int y) {
		return misCeldas[x][y];
	}
	
	private void crearNoDestruibles () {
		
		Celda c;
		
		for (int i = 0; i < this.alto; i++) {
			c = misCeldas[0][i];
			c.setEstado(new EstadoNoDestruible(0, i));
			gui.add(c.getEstado().miGrafico.getGrafico());
			c = misCeldas[ancho-1][i];
			c.setEstado(new EstadoNoDestruible(ancho-1, i));
			gui.add(c.getEstado().miGrafico.getGrafico());
		}
		
		for (int i = 0; i < this.ancho; i++){
			c = misCeldas[i][0];
			c.setEstado(new EstadoNoDestruible(i, 0));
			gui.add(c.getEstado().miGrafico.getGrafico());
			c = misCeldas[i][alto-20];
			c.setEstado(new EstadoNoDestruible(i, alto-20));
			gui.add(c.getEstado().miGrafico.getGrafico());
		}
	}
	
	private void distribuirDestruibles () {
		
	}
	
	public void aumentarPuntaje (int p) {
		miJuego.aumentarPuntaje(p);
	}
	
	public void eliminarEnemigo (Enemigo e) {
		
	}
	
	public int getAncho () {
		return ancho;
	}
	
	public int getAlto () {
		return alto;
	}
}