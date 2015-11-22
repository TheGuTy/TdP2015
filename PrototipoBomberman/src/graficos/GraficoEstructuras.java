package graficos;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import gui.Const;

/**
 * Clase abstracta que encapsula los atributos y operaciones de las gráficas
 * que tienen en común todas las estructuras.
 * @author Asencio Victor, Gutierrez Gabriel, Iurchuk Joaquín
 */

public abstract class GraficoEstructuras {
	protected Icon imagen;
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
		this.imagen = new ImageIcon();
		
	}

	/**
	 * Getter para la posición de la estructura en el panel.
	 * @return Posición en el panel.
	 */
	public Point getPos() {
		return pos;
	}	
	
	/**
	 * Getter para el label de la estructura.
	 * @return JLabel asociado a la estructura.
	 */
	public Icon getIcon() {
		
		return this.imagen;
	}	
}