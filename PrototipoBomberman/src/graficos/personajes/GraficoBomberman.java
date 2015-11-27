package graficos.personajes;

import javax.swing.ImageIcon;

import gui.Const;

/**
 * Clase que modela la gráfica del Bomberman.
 * @author Asencio Victor, Gutierrez Gabriel, Iurchuk Joaquín
 */
public class GraficoBomberman extends GraficoPersonaje {

	/**
	 * Constructor de clase.
	 * Crea la entidad gráfica de Bomberman con una posición en el tablero.
	 * @param velocidad Velocidad de Bomberman.
	 * @param x Posicion lógica horizontal del Bomberman.
	 * @param y Posicion lógica vertical del Bomberman.
	 */
	public GraficoBomberman(int velocidad, int x, int y) {
		super(velocidad, x, y);
		
		getLabel().setBounds(x * Const.ANCHO_CELDA, (y * Const.ALTO_CELDA)+Const.ALTO_ENCABEZADO, Const.ANCHO_CELDA, Const.ALTO_CELDA);
		
		imagenes[Const.MOVIMIENTO_ARRIBA] = new ImageIcon(this.getClass().getResource("/recursos/BupGif.gif"));		
		imagenes[Const.MOVIMIENTO_ABAJO] = new ImageIcon(this.getClass().getResource("/recursos/BdownGif.gif"));
		imagenes[Const.MOVIMIENTO_IZQUIERDA] = new ImageIcon(this.getClass().getResource("/recursos/BleftGif.gif"));
		imagenes[Const.MOVIMIENTO_DERECHA] = new ImageIcon(this.getClass().getResource("/recursos/BrightGif.gif"));
		imagenes[4] = new ImageIcon(this.getClass().getResource("/recursos/Bup.png"));		
		imagenes[5] = new ImageIcon(this.getClass().getResource("/recursos/Bdown.png"));
		imagenes[6] = new ImageIcon(this.getClass().getResource("/recursos/Bleft.png"));
		imagenes[7] = new ImageIcon(this.getClass().getResource("/recursos/Bright.png"));
		grafico.setIcon(imagenes[7]);
	}	
}