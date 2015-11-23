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
		
		getLabel().setBounds(x * Const.ANCHO_CELDA, y * Const.ALTO_CELDA, Const.ANCHO_CELDA, Const.ALTO_CELDA);
		
		imagenes[Const.MOVIMIENTO_ARRIBA] = new ImageIcon(this.getClass().getResource("/Recursos/arr2.png"));		
		imagenes[Const.MOVIMIENTO_ABAJO] = new ImageIcon(this.getClass().getResource("/Recursos/aba2.png"));
		imagenes[Const.MOVIMIENTO_IZQUIERDA] = new ImageIcon(this.getClass().getResource("/Recursos/izq2.png"));
		imagenes[Const.MOVIMIENTO_DERECHA] = new ImageIcon(this.getClass().getResource("/Recursos/der2.png"));
		grafico.setIcon(imagenes[3]);
	}	
}