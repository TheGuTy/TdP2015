package graficos.personajes;

import javax.swing.ImageIcon;

import gui.Const;

/**
 * Clase que modela la gráfica del enemigo Altair.
 * @author Asencio Victor, Gutierrez Gabriel, Iurchuk Joaquín
 */
public class GraficoSirius extends GraficoPersonaje {

	/**
	 * Constructor de clase.
	 * Crea la entidad gráfica del enemigo con una posición en el tablero
	 * y una velocidad determinada.
	 * @param velocidad Velocidad del enemigo.
	 * @param x Posicion lógica horizontal del enemigo.
	 * @param y Posicion lógica vertical del enemigo.
	 */
	public GraficoSirius(int velocidad, int x, int y) {
		super(velocidad, x, y);
		
		getLabel().setBounds(x * Const.ANCHO_CELDA, y * Const.ALTO_CELDA+Const.ALTO_ENCABEZADO, Const.ANCHO_CELDA, Const.ALTO_CELDA);
		
		imagenes[Const.MOVIMIENTO_ARRIBA] = new ImageIcon(this.getClass().getResource("/recursos/SupGif.gif"));		
		imagenes[Const.MOVIMIENTO_ABAJO] = new ImageIcon(this.getClass().getResource("/recursos/SdownGif.gif"));
		imagenes[Const.MOVIMIENTO_IZQUIERDA] = new ImageIcon(this.getClass().getResource("/recursos/SleftGif.gif"));
		imagenes[Const.MOVIMIENTO_DERECHA] = new ImageIcon(this.getClass().getResource("/recursos/SrightGif.gif"));
		imagenes[4] = new ImageIcon(this.getClass().getResource("/recursos/Sup.png"));		
		imagenes[5] = new ImageIcon(this.getClass().getResource("/recursos/Sdown.png"));
		imagenes[6] = new ImageIcon(this.getClass().getResource("/recursos/Sleft.png"));
		imagenes[7] = new ImageIcon(this.getClass().getResource("/recursos/Sright.png"));
		grafico.setIcon(imagenes[7]);
	}	
}