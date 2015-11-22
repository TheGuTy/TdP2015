package graficos;

import javax.swing.ImageIcon;

import gui.Const;

/**
 * Clase que modela la gráfica del estado de la celda en el cual se colocó una bomba.
 * @author Asencio Victor, Gutierrez Gabriel, Iurchuk Joaquín
 */
public class GraficoCeldaBomba extends GraficoEstructuras {
	
	/**
	 * Constructor de clase.
	 * Crea la entidad gráfica de la celda en la cual 
	 * se colocó una bomba con una posición en el tablero.
	 * @param x Posicion lógica horizontal de la celda.
	 * @param y Posicion lógica vertical de la celda.
	 */
	public GraficoCeldaBomba(int x, int y) {
		super(x, y);

		imagen = new ImageIcon(this.getClass().getResource("/Recursos/bomb.png"));	
	
	}
}