package graficos;

import gui.Const;

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
	public GraficoCeldaTransitable(int x, int y) {
		super(x, y);

		getLabel().setBounds(x * Const.ANCHO_CELDA, y * Const.ALTO_CELDA, Const.ANCHO_CELDA, Const.ALTO_CELDA);
		//imagenes[Const.MOVIMIENTO_ARRIBA] = new ImageIcon(this.getClass().getResource("/recursos/transitable.png"));
		this.label.setIcon(imagenes[Const.MOVIMIENTO_ARRIBA]);
	}
}