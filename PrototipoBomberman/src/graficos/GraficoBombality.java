package graficos;

import javax.swing.ImageIcon;

import gui.Const;

/**
 * Clase que modela la gráfica de la bomba.
 * @author Asencio Victor, Gutierrez Gabriel, Iurchuk Joaquín
 */
public class GraficoBombality extends GraficoEstructuras {
	
	/**
	 * Constructor de clase.
	 * Crea la entidad gráfica de la bomba con una posición en el tablero.
	 * @param x Posicion lógica horizontal de la bomba.
	 * @param y Posicion lógica vertical de la bomba.
	 */
	public GraficoBombality(int x, int y) {
		super(x, y);
		
		imagen = new ImageIcon(this.getClass().getResource("/Recursos/bombality.png"));	
		
	}	
}