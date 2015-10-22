package juego;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import gui.Const;
import gui.GUI;
import juego.estadosCelda.EstadoBomba;
import juego.estadosCelda.EstadoNoDestruible;
import juego.estadosCelda.EstadoTransitable;

public class Tablero {

	protected int porcentajeDestruibles;
	protected Juego miJuego;
	protected Celda [][] misCeldas;	
	protected GUI gui;
	
	public Tablero (int porcentaje, Juego juego, GUI gui) {
		porcentajeDestruibles = porcentaje;
		miJuego = juego;
		
		misCeldas = new Celda[Const.CANT_CELDAS_ANCHO][Const.CANT_CELDAS_ALTO];
		this.gui = gui;
		
		for (int i = 0; i < Const.CANT_CELDAS_ANCHO; i++) {
			for (int j = 0; j < Const.CANT_CELDAS_ALTO	; j++) {
				misCeldas[i][j] = new Celda(i, j, this);
				//TODO crear todas las celdas con sus graficas. Patron builder? Factory?
				misCeldas[i][j].setEstado(new EstadoTransitable(i, j));	//Al crear todas las celdas asumo que todas son transitables				
			}
		}
		
		crearNoDestruibles();
		distribuirDestruibles();
		
		//luego de setear todos los estados a la celda, agrego el JLabel de cada celda a la gui
		for (int i = 0; i < Const.CANT_CELDAS_ANCHO; i++)
			for (int j = 0; j < Const.CANT_CELDAS_ALTO; j++)				 
				gui.add(misCeldas[i][j].getEstado().getGrafico().getLabel());
		
	}
	
	public Celda getCelda (int x, int y) {
		return misCeldas[x][y];
	}
	
	private void crearNoDestruibles () {
		
		for(int i=0 ; i<Const.CANT_CELDAS_ANCHO;i++){
			for(int j=0 ; j<Const.CANT_CELDAS_ALTO;j++){
				if(i==0) misCeldas[i][j].setEstado(new EstadoNoDestruible(i, j));
				if(j==0) misCeldas[i][j].setEstado(new EstadoNoDestruible(i, j));
				if(i==Const.CANT_CELDAS_ANCHO-1) misCeldas[i][j].setEstado(new EstadoNoDestruible(i, j));
				if(j==Const.CANT_CELDAS_ALTO-2) misCeldas[i][j].setEstado(new EstadoNoDestruible(i, j));
				if((i%2==0)&&(j%2==0)) misCeldas[i][j].setEstado(new EstadoNoDestruible(i, j));
			}
		}
	}
	
	private void distribuirDestruibles () {
		
		//crear paredes destruibles segun algun porcentaje. el inicial es 50%
	}
	
	public void aumentarPuntaje (int p) {
		
		miJuego.aumentarPuntaje(p);
	}	
	
	
	public int getAncho () {
		
		return Const.CANT_CELDAS_ANCHO;
	}
	
	public int getAlto () {
		
		return Const.CANT_CELDAS_ANCHO;
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
		gui.remove(c.getEstado().getGrafico().getLabel());
		c.setEstado(new EstadoBomba(x, y));
		gui.add(c.getEstado().getGrafico().getLabel());
		System.out.println("cambio a estado bomba la celda " + x + " " + y);
		Bomba b = new Bomba(c, alcance, this);
		
		b.comenzarDetonacion();
	}

	public void restaurarCelda(Celda c) {
		gui.remove(c.getEstado().getGrafico().getLabel());
		c.getEstado().getGrafico().getLabel().setIcon(null);
		c.getEstado().getGrafico().getLabel().repaint();
		gui.repaint();
		c.getEstado().getGrafico().getLabel().setIcon(null);
		c.setEstado(new EstadoTransitable(c.getX(), c.getY()));
		gui.add(c.getEstado().getGrafico().getLabel());
		gui.repaint();
	}
}