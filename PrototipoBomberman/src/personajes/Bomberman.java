package personajes;

import graficos.personajes.GraficoBomberman;
import gui.Const;
import gui.SoundPlayer;
import juego.Celda;
import juego.Tablero;

/**
 * Clase abstracta que a su vez es un Bomberman y refactoriza las habilidades esenciales del mismo.
 * @author Asencio Victor, Gutierrez Gabriel, Iurchuk Joaquín
 *
 */
public class Bomberman extends Personaje implements Runnable {

	protected int bombasDisponibles;
	protected int miAlcanceBomba;
	private int dir;
	private Thread t;
	private boolean modoDios;
	private boolean bombasInfinitas;
	

	/**
	 * Constructor de Bomberman
	 * @param c celda inicial
	 * @param tablero referencia al tablero principal
	 */
	public Bomberman(Celda c, Tablero tablero) {

		super(false, Const.VELOCIDAD_INICIAL_BMAN, c, tablero);
		this.miGrafico = new GraficoBomberman(Const.VELOCIDAD_INICIAL_BMAN, 1, 1);
		bombasDisponibles = 1;
		miAlcanceBomba = 1;
		this.dir=0;
		
		bombasInfinitas = false;
		modoAtravesar = false;
		modoDios = false;
	}

	@Override
	public void matar() {
		
		if (!modoDios){
			System.out.println("Murio bomberguy");
			
			estoyVivo = false;
			
			SoundPlayer.muerteBomberman();
			
			this.getGrafico().getLabel().setIcon(null);
			//TODO Parar el thread que mueve a Bomberman
			//TODO Notificar al juego que murio Bomberman! Traigan ambulancias
			miTablero.notificarMuerteBomberman();
		}
	}

	/**
	 * Permite setear si Bomberman puede atravesar paredes o no
	 * @param b true si Bomberman puede atravesar paredes, false en caso contrario
	 */
	public void setModoAtravesar(boolean b) {
		modoAtravesar = b;
	}

	/**
	 * Permite colocar una Bomba en la celda donde está parado actualmente Bomberman
	 */
	public void colocarBomba() {
		
		if (bombasInfinitas){
			miTablero.colocarBomba(miCelda.getX(), miCelda.getY(), miAlcanceBomba);
		}
		else if (bombasDisponibles > 0){
			bombasDisponibles--;
			miTablero.colocarBomba(miCelda.getX(), miCelda.getY(), miAlcanceBomba);
		}
		else{
			System.out.println("No hay bombas disponibles!");
		}
	}

	/**
	 * Recibe una dirección e intenta moverse hacia ella
	 * @param dir dirección a donde moverse
	 */
	public void mover(int dir) {
		
		calcularCeldaSiguiente(dir).avanzar(this, dir);
		
//		System.out.println("Soy " + this.getClass().getName() + ". Mi posicion nueva es x: " + getCelda().getX() + " - y: " + getCelda().getY());
	}
	
	/**
	 * Al ser invocado duplica la velocidad actual de Bomberman
	 */
	public void duplicarVelocidad() {

		velocidad *= 2;
	}

	/**
	 * Al ser invocado aumenta en 1 la cantidad de bombas disponibles
	 */
	public void aumentarBombasDisponibles() {

		bombasDisponibles++;
	}

	/**
	 * Al ser invocado duplica el alcance de las bombas que coloca Bomberman
	 */
	public void duplicarAlcance() {

		miAlcanceBomba *= 2;
	}


	/**
	 * Runnable que se encarga de mover de manera fluida la posicion gráfica de Bomberman
	 */
	@Override
	public void run() {
		
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
//				miGrafico.changeIcon(5);
				break;
			case Const.MOVIMIENTO_ABAJO:
				for (int i = 0; i < Const.ALTO_CELDA; i += velocidad) {
					miGrafico.getLabel().setBounds(miGrafico.getPos().x, miGrafico.getPos().y += velocidad,
							Const.ANCHO_CELDA, Const.ALTO_CELDA);
					Thread.sleep(10);
				}
//				miGrafico.changeIcon(6);
				break;
			case Const.MOVIMIENTO_IZQUIERDA:
				for (int i = 0; i < Const.ANCHO_CELDA; i += velocidad) {
					miGrafico.getLabel().setBounds(miGrafico.getPos().x -= velocidad, miGrafico.getPos().y,
							Const.ANCHO_CELDA, Const.ALTO_CELDA);
					Thread.sleep(10);
				}
//				miGrafico.changeIcon(7);
				break;
			case Const.MOVIMIENTO_DERECHA:
				for (int i = 0; i < Const.ANCHO_CELDA; i += velocidad) {
					miGrafico.getLabel().setBounds(miGrafico.getPos().x += velocidad, miGrafico.getPos().y,
							Const.ANCHO_CELDA, Const.ALTO_CELDA);
					Thread.sleep(10);
				}
//				miGrafico.changeIcon(8);
				break;
			}

		} catch (InterruptedException e) {
		}

		lock = false;
	}
	
	@Override
	public void moverGrafica(int dir) {
		this.dir = dir;
		t = new Thread(this);
		t.start();
	}

	public void activarModoMasacrality() {
		
		bombasInfinitas = true;
		modoAtravesar = true;
		modoDios = true;
		
		new java.util.Timer().schedule(new java.util.TimerTask() {
			@Override
			public void run() {
				bombasInfinitas = false;
				modoAtravesar = false;
				modoDios = false;
			}
		}, Const.DURACION_MASACRALITY);
		
		
	}
}
