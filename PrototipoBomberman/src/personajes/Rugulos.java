package personajes;

import graficos.personajes.GraficoRugulos;
import juego.Celda;
import juego.Tablero;

/**
 * Clase que modela a un tipo efectivo de Enemigo
 * @author Asencio Victor, Gutierrez Gabriel, Iurchuk Joaquín
 *
 */
public class Rugulos extends Enemigo {

	private final static int VELOCIDAD_INICIAL = 1;
	private final static int PUNTAJE = 15;

	/**
	 * Constructor de enemigo Rugulus
	 * @param celda Celda inicial
	 * @param t referencia al tablero principal
	 */
	public Rugulos(Celda celda, Tablero t) {

		super(false, VELOCIDAD_INICIAL, celda, t, PUNTAJE);
		this.miGrafico = new GraficoRugulos(1, celda.getX(), celda.getY());
	}
}