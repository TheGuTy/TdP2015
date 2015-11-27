package graficos.personajes;

import javax.swing.ImageIcon;

import gui.Const;

/**
 * Clase que modela la gráfica del enemigo Altair.
 * @author Asencio Victor, Gutierrez Gabriel, Iurchuk Joaquín
 */
public class GraficoAltair extends GraficoPersonaje {

	/**
	 * Constructor de clase.
	 * Crea la entidad gráfica del enemigo con una posición en el tablero
	 * y una velocidad determinada.
	 * @param velocidad Velocidad del enemigo.
	 * @param x Posicion lógica horizontal del enemigo.
	 * @param y Posicion lógica vertical del enemigo.
	 */
	public GraficoAltair(int velocidad, int x, int y) {
		super(velocidad, x, y);
		
		getLabel().setBounds(x * Const.ANCHO_CELDA, y * Const.ALTO_CELDA+Const.ALTO_ENCABEZADO, Const.ANCHO_CELDA, Const.ALTO_CELDA);
		
		imagenes[Const.MOVIMIENTO_ARRIBA] = imagenes[4] = imagenes[5] = imagenes[6] = imagenes[7] = imagenes[Const.MOVIMIENTO_DERECHA] = imagenes[Const.MOVIMIENTO_IZQUIERDA] = imagenes[Const.MOVIMIENTO_ABAJO] = new ImageIcon(this.getClass().getResource("/Recursos/AGif.gif"));		
		grafico.setIcon(imagenes[0]);
	}	
}