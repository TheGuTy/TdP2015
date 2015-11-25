package graficos.estructuras;

import javax.swing.ImageIcon;

/**
* Clase que modela la gráfica de la pared no destruible.
* @author Asencio Victor, Gutierrez Gabriel, Iurchuk Joaquín
*/

public class GraficoParedNoDestruible extends GraficoEstructuras {

	/**
	 * Constructor de clase.
	 * Crea la entidad gráfica de una pared no destruible en una posición en el tablero.
	 * @param x Posicion lógica horizontal de la pared.
	 * @param y Posicion lógica vertical de la pared.
	 */
	public GraficoParedNoDestruible() {
		super();
		
		imagen = new ImageIcon(this.getClass().getResource("/Recursos/muroindestructible2.png"));			
	}	
}