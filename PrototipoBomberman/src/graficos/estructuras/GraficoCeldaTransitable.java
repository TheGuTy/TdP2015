package graficos.estructuras;

import javax.swing.ImageIcon;

/**
 * Clase que modela la gráfica del estado de una celda transitable.
 * @author Asencio Victor, Gutierrez Gabriel, Iurchuk Joaquín
 */
public class GraficoCeldaTransitable extends GraficoEstructuras {

	/**
	 * Constructor de clase.
	 * Crea la entidad gráfica de una celda transitable con una posición en el tablero.
	 * @param x Posicion lógica horizontal de la celda.
	 * @param y Posicion lógica vertical de la celda.
	 */
	public GraficoCeldaTransitable() {
		super();

		imagen = new ImageIcon();		
	}
}