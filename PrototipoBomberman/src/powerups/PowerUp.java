package powerups;

import personajes.Bomberman;

/**
 * Clase que modela a un PowerUp que al ejecutarse afectará a Bomberman
 * @author Asencio Victor, Gutierrez Gabriel, Iurchuk Joaquín
 *
 */
public abstract class PowerUp {

	protected int puntaje;
	
	/**
	 * Constructor de la clase.
	 * Crea un PowerUp con un puntaje predefinido.
	 */
	protected PowerUp (int p) {
		this.puntaje = p;
	}
	
	/**
	 * Al ejecutarse afecta directamente a Bomberman 
	 * @param b Bomberman a afectar
	 */
	public abstract void upgrade (Bomberman b);
	
	/**
	 * Devuelve el puntaje de este PowerUp
	 * @return
	 */
	public int getPuntaje () {
		
		return puntaje;
	}
}
