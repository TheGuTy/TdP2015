package juego.estadosCelda;

import graficos.GraficoParedNoDestruible;
import juego.Celda;
import personajes.Bomberman;
import personajes.Enemigo;

/**
 * Clase que modela un tipo de EstadoCelda efectivo: No destruible
 * @author Asencio Victor, Gutierrez Gabriel, Iurchuk Joaquín
 *
 */
public class EstadoNoDestruible extends EstadoCelda {

	/**
	 * Constructor de un EstadoNoDestruible
	 * Se utiliza para modelar el estado de una celda que posee una pared no destruible
	 * @param x posicion x dentro de la matriz de celdas 
	 * @param y posicion y dentro de la matriz de celdas
	 */
	public EstadoNoDestruible(int x, int y) {
		super(new GraficoParedNoDestruible(x, y));
	}

	@Override
	public void destruir(Celda c) {
		//No hacer nada
	}

	@Override
	public void avanzar(Bomberman bomberman, Celda celdaSiguiente, int dir) {
		//No hacer nada
	}

	@Override
	public void avanzar(Enemigo enemigo, Celda celdaSiguiente, int dir) {
		//No hacer nada
	}
}