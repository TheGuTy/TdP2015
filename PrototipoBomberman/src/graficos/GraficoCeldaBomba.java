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

		getLabel().setBounds(x * Const.ANCHO_CELDA, y * Const.ALTO_CELDA, Const.ANCHO_CELDA, Const.ALTO_CELDA);
		imagenes[Const.MOVIMIENTO_ARRIBA] = new ImageIcon(this.getClass().getResource("/recursos/bomb.png"));
		this.label.setIcon(imagenes[Const.MOVIMIENTO_ARRIBA]);
	}
}