package graficos.estructuras;

import javax.swing.ImageIcon;

/**
 * Clase que modela la gráfica de la bomba.
 * @author Asencio Victor, Gutierrez Gabriel, Iurchuk Joaquín
 */
public class GraficoBomba extends GraficoEstructuras {
	
	/**
	 * Constructor de clase.
	 * Crea la entidad gráfica de la bomba con una posición en el tablero.
	 * @param x Posicion lógica horizontal de la bomba.
	 * @param y Posicion lógica vertical de la bomba.
	 */
	public GraficoBomba() {
		super();		
		
		imagen = new ImageIcon(this.getClass().getResource("/recursos/bomb.png"));	
		
	}	
}