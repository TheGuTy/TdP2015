package graficos;

import javax.swing.ImageIcon;

import gui.Const;

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
	public GraficoParedNoDestruible(int x, int y) {
		super(x, y);
		
		imagen = new ImageIcon(this.getClass().getResource("/Recursos/muroindestructible2.png"));			
	}	
}