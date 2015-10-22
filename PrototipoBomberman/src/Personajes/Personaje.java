package Personajes;

import java.awt.Point;

import javax.swing.JLabel;

import Graficos.GraficoPersonaje;
import Gui.Const;
import Juego.Celda;
import Juego.Tablero;

public abstract class Personaje {

	protected boolean modoDios;
	protected int velocidad;
	protected Celda miCelda;
	protected Tablero miTablero;
	protected volatile boolean estoyVivo;
	protected GraficoPersonaje miGrafico;
	protected boolean lock;

	public Personaje(boolean modoDios, int vel, Celda c, Tablero t) {
		this.modoDios = modoDios;
		velocidad = vel;
		miCelda = c;
		miTablero = t;
		estoyVivo = true;
		miGrafico = null;
		lock = false;
	}

	public abstract void matar();

	public boolean enModoDios() {
		return modoDios;
	}

	public void setCelda(Celda c) {
		miCelda = c;
	}

	public Celda getCelda() {
		return miCelda;
	}

	public JLabel getLabel() {
		return miGrafico.getGrafico();
	}

	public GraficoPersonaje getGrafico() {
		return miGrafico;
	}

	public Point getPos() {
		return miGrafico.getPos();
	}
	
	protected Celda calcularCeldaSiguiente(int dir){
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
	
public void moverGrafica(int dir) {
		
		lock = true;
		
		if (this.miGrafico != null) {
			
			miGrafico.changeIcon(dir);
			
			Thread t = new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						switch (dir) {
						case Const.MOVIMIENTO_ARRIBA:
							for (int i = 0; i < miGrafico.getAlto(); i += velocidad) {
								miGrafico.getGrafico().setBounds(miGrafico.getPos().x, miGrafico.getPos().y -= velocidad, miGrafico.getAncho(), miGrafico.getAlto());
								Thread.sleep(10);
							}
							break;
						case Const.MOVIMIENTO_ABAJO:
							for (int i = 0; i < miGrafico.getAlto(); i += velocidad) {
								miGrafico.getGrafico().setBounds(miGrafico.getPos().x, miGrafico.getPos().y += velocidad, miGrafico.getAncho(), miGrafico.getAlto());
								Thread.sleep(10);
							}
							break;
						case Const.MOVIMIENTO_IZQUIERDA:
							for (int i = 0; i < miGrafico.getAncho(); i += velocidad) {
								miGrafico.getGrafico().setBounds(miGrafico.getPos().x -= velocidad, miGrafico.getPos().y, miGrafico.getAncho(), miGrafico.getAlto());
								Thread.sleep(10);
							}
							break;
						case Const.MOVIMIENTO_DERECHA:
							for (int i = 0; i < miGrafico.getAncho(); i += velocidad) {
								miGrafico.getGrafico().setBounds(miGrafico.getPos().x += velocidad, miGrafico.getPos().y, miGrafico.getAncho(), miGrafico.getAlto());
								Thread.sleep(10);
							}
							break;
						}
		
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			t.start();
		}
		
		lock = false;
	}
	
	public boolean getLock() {
		return lock;
	}
	
	public void lock(){
		lock = true;
	}
}