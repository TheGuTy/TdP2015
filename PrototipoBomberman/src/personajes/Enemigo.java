package personajes;

import java.util.Random;

import gui.Const;
import gui.SoundPlayer;
import juego.Celda;
import juego.Tablero;

/**
 * Clase abstracta que a su vez es un Personaje y refactoriza las habilidades esenciales de ellos.
 * @author Asencio Victor, Gutierrez Gabriel, Iurchuk Joaquín
 *
 */
public abstract class Enemigo extends Personaje {

	protected int puntaje;

	/**
	 * Construye un Enemigo.
	 * @param modoAtravesar true si este Enemigo es capaz de atravesar paredes, false en caso contrario
	 * @param vel velocidad inicial
	 * @param c Celda inicial
	 * @param t Referencia al tablero principal
	 * @param p puntaje
	 */
	protected Enemigo (boolean modoAtravesar, int vel, Celda c, Tablero t, int p) {
		super(modoAtravesar, vel, c, t);
		this.puntaje = p;
	}

	/**
	 * Devuelve el puntaje de este Enemigo
	 * @return el puntaje de este Enemigo
	 */
	public int getPuntaje () {
		return puntaje;
	}

	/**
	 * Calcula una direccion al azar e intenta moverse hacia ella
	 */
	public void mover () {
		int dir = new Random().nextInt(4);
		calcularCeldaSiguiente(dir).avanzar(this, dir);
//		System.out.println("Soy " + this.getClass().getName() + ". Mi posicion nueva es x: " + getCelda().getX() + " - y: " + getCelda().getY());
	}
	
	@Override
	public void matar(){
		getLabel().setIcon(null);
		
		System.out.println("Murio " + this.getClass().getSimpleName());
		
		SoundPlayer.muerteEnemigo();
		
		estoyVivo = false;
		
	}
	
	@Override
	public void moverGrafica(int dir) {

		lock = true;

		miGrafico.changeIcon(dir);
		try {
			switch (dir) {
			case Const.MOVIMIENTO_ARRIBA:
				for (int i = 0; i < Const.ALTO_CELDA; i += velocidad) {
					miGrafico.getLabel().setBounds(miGrafico.getPos().x, miGrafico.getPos().y -= velocidad,
							Const.ANCHO_CELDA, Const.ALTO_CELDA);
					Thread.sleep(10);
				}
				break;
			case Const.MOVIMIENTO_ABAJO:
				for (int i = 0; i < Const.ALTO_CELDA; i += velocidad) {
					miGrafico.getLabel().setBounds(miGrafico.getPos().x, miGrafico.getPos().y += velocidad,
							Const.ANCHO_CELDA, Const.ALTO_CELDA);
					Thread.sleep(10);
				}
				break;
			case Const.MOVIMIENTO_IZQUIERDA:
				for (int i = 0; i < Const.ANCHO_CELDA; i += velocidad) {
					miGrafico.getLabel().setBounds(miGrafico.getPos().x -= velocidad, miGrafico.getPos().y,
							Const.ANCHO_CELDA, Const.ALTO_CELDA);
					Thread.sleep(10);
				}
				break;
			case Const.MOVIMIENTO_DERECHA:
				for (int i = 0; i < Const.ANCHO_CELDA; i += velocidad) {
					miGrafico.getLabel().setBounds(miGrafico.getPos().x += velocidad, miGrafico.getPos().y,
							Const.ANCHO_CELDA, Const.ALTO_CELDA);
					Thread.sleep(10);
				}
				break;
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		lock = false;
	}
}