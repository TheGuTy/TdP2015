package graficos;

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
		
		getLabel().setBounds(x * Const.ANCHO_CELDA, y * Const.ALTO_CELDA, Const.ANCHO_CELDA, Const.ALTO_CELDA);
		
		imagenes[Const.MOVIMIENTO_ARRIBA] = new ImageIcon(this.getClass().getResource("/Recursos/meme1.png"));		
		imagenes[Const.MOVIMIENTO_ABAJO] = new ImageIcon(this.getClass().getResource("/Recursos/meme2.png"));
		imagenes[Const.MOVIMIENTO_IZQUIERDA] = new ImageIcon(this.getClass().getResource("/Recursos/meme1.png"));
		imagenes[Const.MOVIMIENTO_DERECHA] = new ImageIcon(this.getClass().getResource("/Recursos/meme2.png"));
		grafico.setIcon(imagenes[3]);
	}	
}