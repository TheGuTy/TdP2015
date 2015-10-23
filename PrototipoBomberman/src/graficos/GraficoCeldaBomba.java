package graficos;

import javax.swing.ImageIcon;

import gui.Const;

/**
 * Clase que modela la gr�fica del estado de la celda en el cual se coloc� una bomba.
 * @author Asencio Victor, Gutierrez Gabriel, Iurchuk Joaqu�n
 */
public class GraficoCeldaBomba extends GraficoEstructuras {
	
	/**
	 * Constructor de clase.
	 * Crea la entidad gr�fica de la celda en la cual 
	 * se coloc� una bomba con una posici�n en el tablero.
	 * @param x Posicion l�gica horizontal de la celda.
	 * @param y Posicion l�gica vertical de la celda.
	 */
	public GraficoCeldaBomba(int x, int y) {
		super(x, y);

		getLabel().setBounds(x * Const.ANCHO_CELDA, y * Const.ALTO_CELDA, Const.ANCHO_CELDA, Const.ALTO_CELDA);
		imagenes[Const.MOVIMIENTO_ARRIBA] = new ImageIcon(this.getClass().getResource("/recursos/bomb.png"));
		this.label.setIcon(imagenes[Const.MOVIMIENTO_ARRIBA]);
	}
}