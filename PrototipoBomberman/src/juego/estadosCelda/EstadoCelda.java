package juego.estadosCelda;

import graficos.estructuras.GraficoEstructuras;
import juego.Celda;
import personajes.Bomberman;
import personajes.Enemigo;

/**
 * Clase abstracta que modela el estado de una celda
 * @author Asencio Victor, Gutierrez Gabriel, Iurchuk Joaquín
 *
 */
public abstract class EstadoCelda {

	protected GraficoEstructuras miGrafico;
	
	/**
	 * Constructor de una celda.
	 * @param miGrafico grafico asociado al estado de una celda
	 */
	protected EstadoCelda(GraficoEstructuras miGrafico){
		this.miGrafico = miGrafico;
	}
	
	/**
	 * Método invocado cuando se quiere destruir a la celda asociada a este estado. La misma se encarga de su propia destruccion 
	 * @param c celda a destruir
	 */
	public abstract int destruir (Celda c);
	
	/**
	 * Método que se invoca cuando Bomberman quiere posicionarse sobre la celda que posee este estado.
	 * Se encarga de asignar su posicion basada en si este estado le permite avanzar o no
	 * @param bomberman bomberman que se quiere posicionar sobre la celda que posee este estado
	 * @param c celda a la cual desea avanzar bomberman
	 * @param dir direccion en que se movio bomberman
	 */
	public abstract void avanzar (Bomberman bomberman, Celda c, int dir);
	
	/**
	 * Método que se invoca cuando un Enemigo quiere posicionarse sobre la celda que posee este estado.
	 * Se encarga de asignar su posicion basada en si este estado le permite avanzar o no
	 * @param enemigo enemigo que se quiere posicionar sobre la celda que posee este estado
	 * @param c celda a la cual desea avanzar el enemigo recibido
	 * @param dir direccion en que se movio el enemigo recibido
	 */
	public abstract void avanzar (Enemigo enemigo, Celda c, int dir);
	
	/**
	 * Devuelve el GraficoEstructuras asociado a este estado
	 * @return el GraficoEstructuras asociado a este estado
	 */
	public GraficoEstructuras getGrafico(){
		return miGrafico;
	}
}