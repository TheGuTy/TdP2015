package personajes;

import graficos.personajes.GraficoSirius;
import juego.Celda;
import juego.Tablero;

/**
 * Clase que modela a un tipo efectivo de Enemigo
 * @author Asencio Victor, Gutierrez Gabriel, Iurchuk Joaquín
 *
 */
public class Sirius extends Enemigo {

	private Bomberman miBomberman;
	private final static int VELOCIDAD_INICIAL = 3;
	private final static int PUNTAJE = 50;

	/**
	 * Constructor de enemigo Sirius
	 * @param celda Celda inicial
	 * @param t referencia al tablero principal
	 */
	public Sirius (Celda celda, Tablero t) {
		super(false, VELOCIDAD_INICIAL, celda, t, PUNTAJE);
		miBomberman = miTablero.getJuego().getBomberman();
		this.miGrafico = new GraficoSirius(1, celda.getX(), celda.getY());
	}

	public void mover() {

		int horizontal = 1;
		int vertical = 1;
		int dir=0;

		if(miBomberman.getCelda().getX()<miCelda.getX()){
			horizontal=2;
		}else
			horizontal=3;

		if(miBomberman.getCelda().getY()<miCelda.getY())
			vertical=0;
		else
			vertical=1;
		
		if(Math.abs(miBomberman.getCelda().getX()-miCelda.getX())<Math.abs(miBomberman.getCelda().getY()-miCelda.getY()))
			dir = vertical;
		else
			dir = horizontal;
			
		calcularCeldaSiguiente(dir).avanzar(this, dir);

	}

}
