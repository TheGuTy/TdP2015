package graficos;

import javax.swing.ImageIcon;

import gui.Const;

/**
 * Clase que modela la gr�fica de la bomba.
 * @author Asencio Victor, Gutierrez Gabriel, Iurchuk Joaqu�n
 */
public class GraficoSpeedUp extends GraficoEstructuras {
	
	/**
	 * Constructor de clase.
	 * Crea la entidad gr�fica de la bomba con una posici�n en el tablero.
	 * @param x Posicion l�gica horizontal de la bomba.
	 * @param y Posicion l�gica vertical de la bomba.
	 */
	public GraficoSpeedUp(int x, int y) {
		super(x, y);
		
		getLabel().setBounds(x * Const.ANCHO_CELDA, y * Const.ALTO_CELDA, Const.ANCHO_CELDA, Const.ALTO_CELDA);
		imagenes[0] = new ImageIcon(this.getClass().getResource("/Recursos/arr.png"));		
		getLabel().setIcon(imagenes[0]);
	}	
}