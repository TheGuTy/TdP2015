package Personajes;

import java.awt.Point;

import javax.swing.JLabel;

import Graficos.GraficoPersonaje;
import Juego.Celda;
import Juego.Tablero;

public abstract class Personaje extends Thread {

	protected boolean modoDios;
	protected int velocidad;
	protected Celda miCelda;
	protected Tablero miTablero;
	protected volatile boolean estoyVivo;
	protected GraficoPersonaje miGrafico;
	
	public Personaje (boolean modoDios, int vel, Celda c, Tablero t) {
		
		this.modoDios = modoDios;
		velocidad = vel;
		miCelda = c;		
		miTablero = t;
		estoyVivo = true;
		miGrafico = null;
	}
	
	public abstract void matar ();
	
	public boolean enModoDios () {
		
		return modoDios;
	}
	
	public void setCelda (Celda c) {
		
		miCelda = c;
	}

	public Celda getCelda() {
		return miCelda;
	}
	
	public JLabel getLabel () {		
		
		return miGrafico.getGrafico();
	}
	
	public GraficoPersonaje getGrafico() {
		
		return miGrafico;
	}
	
	public Point getPos(){
		return miGrafico.getPos();
	}
	
	public void mover(int dir){
		int xActual = miCelda.getX();
		int yActual = miCelda.getY();
		Celda celdaSiguiente;
		String ultimoMovimiento = "";
		
		switch (dir) {
		case 0: {	//arriba					
			yActual--;
			if (yActual < 0)
				yActual = 0;			
			ultimoMovimiento = "arriba";			
			break;
		}
		case 1: {	//abajo
			yActual++;
			if (yActual >= miTablero.getAlto())
				yActual = miTablero.getAlto() - 1;
			
			ultimoMovimiento = "abajo";
			break;
		}
		case 2: {	//izquierda
			xActual--;
			if (xActual <= 0)
				xActual = 0;		
			ultimoMovimiento = "izquierda";
			break;
		}
		case 3: {	//derecha
			xActual++;
			if (xActual >= miTablero.getAncho())
				xActual = miTablero.getAncho() - 1;		
			ultimoMovimiento = "derecha";
			break;
		}		
		}
		miGrafico.mover(dir);
		miGrafico.changeIcon(dir);
		celdaSiguiente = miTablero.getCelda(xActual, yActual);
		
		System.out.println("Soy " + this.getClass().getName() + ". Mi posicion antes de moverme es x: " + getCelda().getX() + " - y: " + getCelda().getY());
		celdaSiguiente.avanzar(this);
		System.out.println("Soy " + this.getClass().getName() + ". Mi posicion nueva es x: " + getCelda().getX() + " - y: " + getCelda().getY() + ". Mi movimiento fue " + ultimoMovimiento);
	}
}