package personajes;

import juego.Celda;
import juego.Tablero;

/**
 * Clase que modela a un tipo efectivo de Enemigo
 * @author Asencio Victor, Gutierrez Gabriel, Iurchuk Joaquín
 *
 */
public class Sirius extends Enemigo {

	private final static int VELOCIDAD_INICIAL = 3;
	private final static int PUNTAJE = 50;
	
	/**
	 * Constructor de enemigo Sirius
	 * @param celda Celda inicial
	 * @param t referencia al tablero principal
	 */
	public Sirius (Celda celda, Tablero t) {
		
		super(false, VELOCIDAD_INICIAL, celda, t, PUNTAJE);
	}
}
