package juego;

import java.util.LinkedList;
import java.util.List;

import gui.GUI;

public class Tablero {

	protected int porcentajeDestruibles;
	protected Juego miJuego;
	protected Celda [][] misCeldas;
	protected int ancho, alto;
	protected GUI gui;
	protected List<Bomba> misBombas;
	
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
		
		//luego de setear todos los estados a la celda, agrego el JLabel de cada celda a la gui
		for (int i = 0; i < this.ancho; i++)
			for (int j = 0; j < this.alto; j++)				 
				gui.add(misCeldas[i][j].getEstado().miGrafico.getLabel());
		
		misBombas = new LinkedList<Bomba>();
	}
	
	public Celda getCelda (int x, int y) {
		return misCeldas[x][y];
	}
	
	private void crearNoDestruibles () {
		
		//lado superior
		for (int i = 0; i < this.ancho; i++)
			misCeldas[i][0].setEstado(new EstadoNoDestruible(i, 0));
		
		//lado inferior
		for (int i = 0; i < this.ancho; i++)
			misCeldas[i][this.alto-2].setEstado(new EstadoNoDestruible(i, this.alto-2));
		
		//lado izquierdo
		for (int i = 0; i < this.alto; i++)
			misCeldas[0][i].setEstado(new EstadoNoDestruible(0, i));
		
		//lado derecho
		for (int i = 0; i < this.alto; i++)
			misCeldas[this.ancho-1][i].setEstado(new EstadoNoDestruible(this.ancho-1, i));
	}
	
	private void distribuirDestruibles () {
		
		//crear paredes destruibles segun algun porcentaje. el inicial es 50%
	}
	
	public void aumentarPuntaje (int p) {
		
		miJuego.aumentarPuntaje(p);
	}	
	
	
	public int getAncho () {
		
		return this.ancho;
	}
	
	public int getAlto () {
		
		return this.alto;
	}

	public Juego getJuego() {
		return miJuego;
	}

	/**
	 * Metodo llamado al finalizar una explosion por la bomba
	 */
	public void devolverBombaABomberman() {
		miJuego.getBomberman().aumentarBombasDisponibles();
	}

	public void colocarBomba (int x, int y, int alcance) {
		
		Celda c = getCelda(x, y);
		Bomba b = new Bomba(c, alcance, this);
		
		gui.add(b.getGrafico().getLabel());
		misBombas.add(b);
		b.comenzarDetonacion();
	}

	public void eliminarDeListaBombas(Celda miCelda) {
		misBombas.remove(miCelda);
	}

	public boolean hayBomba(Celda celdaSiguiente) {
		for (Bomba b : misBombas)
			if (b.getCelda() == celdaSiguiente)
				return true;
		
		return false;
	}
}