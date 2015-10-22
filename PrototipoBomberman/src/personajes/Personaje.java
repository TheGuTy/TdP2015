package personajes;

import java.awt.Point;

import javax.swing.JLabel;

import graficos.GraficoPersonaje;
import gui.Const;
import juego.Celda;
import juego.Tablero;

public abstract class Personaje {

	protected boolean modoAtravesar;
	protected int velocidad;
	protected Celda miCelda;
	protected Tablero miTablero;
	protected boolean estoyVivo;
	protected GraficoPersonaje miGrafico;
	protected boolean lock;

	public Personaje(boolean modoAtravesar, int vel, Celda c, Tablero t) {
		this.modoAtravesar = modoAtravesar;
		velocidad = vel;
		miCelda = c;
		miTablero = t;
		estoyVivo = true;
		miGrafico = null;
		lock = false;
	}

	public abstract void matar();
	
	public boolean enModoAtravesar() {
		return modoAtravesar;
	}

	public void setCelda(Celda c) {
		miCelda = c;
	}

	public Celda getCelda() {
		return miCelda;
	}

	public JLabel getLabel() {
		return miGrafico.getLabel();
	}

	public GraficoPersonaje getGrafico() {
		return miGrafico;
	}

	public Point getPos() {
		return miGrafico.getPos();
	}

	/**
	 * Basandose en la celda/posicion actual se calcula la que deberia ser la
	 * siguiente segun la direccion recibida
	 * 
	 * @param dir
	 *            direccion hacia donde se desea avanzar a este personaje
	 * @return la celda que deberia ser la siguiente segun la direccion recibida
	 */
	protected Celda calcularCeldaSiguiente(int dir) {
		int xActual = miCelda.getX();
		int yActual = miCelda.getY();

		switch (dir) {
		case 0: { // arriba
			yActual--;
			if (yActual < 0)
				yActual = 0;
			break;
		}
		case 1: { // abajo
			yActual++;
			if (yActual >= miTablero.getAlto())
				yActual = miTablero.getAlto() - 1;
			break;
		}
		case 2: { // izquierda
			xActual--;
			if (xActual <= 0)
				xActual = 0;
			break;
		}
		case 3: { // derecha
			xActual++;
			if (xActual >= miTablero.getAncho())
				xActual = miTablero.getAncho() - 1;
			break;
		}
		}

		return miTablero.getCelda(xActual, yActual);
	}

	public abstract void moverGrafica(int dir);
	
	public boolean getLock() {
		return lock;
	}

	public void lock() {
		lock = true;
	}
	
	public boolean estoyVivo() {
		return estoyVivo;
	}
}