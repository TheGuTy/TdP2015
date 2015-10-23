package graficos;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.JLabel;

import gui.Const;

/**
 * Clase abstracta que encapsula los atributos y operaciones de las gráficas
 * que tienen en común todas las estructuras.
 * @author Asencio Victor, Gutierrez Gabriel, Iurchuk Joaquín
 */

public abstract class GraficoEstructuras {
	protected JLabel label;
	protected Icon imagenes[];
	protected final int ancho = Const.ANCHO_CELDA;
	protected final int alto = Const.ALTO_CELDA;
	protected Point pos;

	/**
	 * Constructor de clase abstracta.
	 * Inicializa los atributos en común de todas las entidades gráficas 
	 * pertenecientes a las estructuras.
	 * @param x Posición lógica horizontal de la celda.
	 * @param y Posición lógica vertical de la celda.
	 */
	protected GraficoEstructuras(int x, int y) {
		this.pos = new Point(x * this.ancho, y * this.alto);
		this.imagenes = new Icon[1];
		label = null;
	}

	/**
	 * Getter para la posición de la estructura en el panel.
	 * @return Posición en el panel.
	 */
	public Point getPos() {
		return pos;
	}

	/**
	 * Cambia la imagen del JLabel asociado a la estructura según la dirección indicada.
	 * @param dir Indicador de direccón para la imagen.
	 */
	public void changeIcon(int dir) {
		this.label.setIcon(this.imagenes[dir]);
	}
	
	/**
	 * Getter para el label de la estructura.
	 * @return JLabel asociado a la estructura.
	 */
	public JLabel getLabel() {
		if (this.label == null) {
			this.label = new JLabel(imagenes[0]);
			this.label.setBounds(this.pos.x, this.pos.y, ancho, alto);
		}
		return this.label;
	}
	
}