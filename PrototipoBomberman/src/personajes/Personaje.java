package personajes;

import java.awt.Point;

import javax.swing.JLabel;

import graficos.GraficoPersonaje;
import gui.Const;
import juego.Celda;
import juego.Tablero;

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

	/**
	 * Clase encargada de mover el grafico del personaje segun la direccion
	 * recibida. Se utiliza un Thread como recurso para emular la transicion del
	 * personaje de una celda a la otra. Sin este thread no se podria lograr
	 * este efecto.
	 * 
	 * @param dir direccion donde el personaje debe dirigirse
	 */
	public void moverGrafica(int dir) {

			lock = true;
			
				miGrafico.changeIcon(dir);
				Thread t = new Thread(new Runnable() {

					@Override
					public void run() {
						try {
							switch (dir) {
							case Const.MOVIMIENTO_ARRIBA:
								for (int i = 0; i < miGrafico.getAlto(); i += velocidad) {
									miGrafico.getGrafico().setBounds(miGrafico.getPos().x,
											miGrafico.getPos().y -= velocidad, miGrafico.getAncho(),
											miGrafico.getAlto());
									Thread.sleep(10);
								}
								break;
							case Const.MOVIMIENTO_ABAJO:
								for (int i = 0; i < miGrafico.getAlto(); i += velocidad) {
									miGrafico.getGrafico().setBounds(miGrafico.getPos().x,
											miGrafico.getPos().y += velocidad, miGrafico.getAncho(),
											miGrafico.getAlto());
									Thread.sleep(10);
								}
								break;
							case Const.MOVIMIENTO_IZQUIERDA:
								for (int i = 0; i < miGrafico.getAncho(); i += velocidad) {
									miGrafico.getGrafico().setBounds(miGrafico.getPos().x -= velocidad,
											miGrafico.getPos().y, miGrafico.getAncho(), miGrafico.getAlto());
									Thread.sleep(10);
								}
								break;
							case Const.MOVIMIENTO_DERECHA:
								for (int i = 0; i < miGrafico.getAncho(); i += velocidad) {
									miGrafico.getGrafico().setBounds(miGrafico.getPos().x += velocidad,
											miGrafico.getPos().y, miGrafico.getAncho(), miGrafico.getAlto());
									Thread.sleep(10);
								}
								break;
							}
							

						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
						lock = false;
					}
				});
				
				t.start();
//			}
			
//		}
//		else
//			System.out.println("estoy lock");

	}

	public boolean getLock() {
		return lock;
	}

	public void lock() {
		lock = true;
	}
}