package graficos.personajes;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.JLabel;

import gui.Const;

/**
 * Clase abstracta que encapsula los atributos y operaciones de las gráficas
 * que tienen en común todos personajes.
 * @author Asencio Victor, Gutierrez Gabriel, Iurchuk Joaquín
 */
public abstract class GraficoPersonaje {
	protected JLabel grafico;
	protected Icon imagenes[];
	protected final int ancho = Const.ANCHO_CELDA;
	protected final int alto = Const.ALTO_CELDA;
	protected int velocidad;
	protected Point pos;

	/**
	 * Constructor de clase abstracta.
	 * Inicializa los atributos en común de todas las entidades gráficas 
	 * pertenecientes a todos personajes.
	 * @param x Posición lógica horizontal del personaje.
	 * @param y Posición lógica vertical del personaje.
	 */
	protected GraficoPersonaje(int velocidad, int x, int y) {
		this.pos = new Point(x * this.ancho, y * this.alto+Const.ALTO_ENCABEZADO);
		this.velocidad = velocidad;
		this.imagenes = new Icon[8];
	}

	
	/**
	 * Getter para la posición del personaje en el panel.
	 * @return Posición del personaje en el panel.
	 */
	public Point getPos() {
		return pos;
	}
	
	/**
	 * Cambia la imagen del JLabel asociado al personaje según la dirección indicada.
	 * @param dir Indicador de direccón para la imagen.
	 */
	public void changeIcon(int dir) {
		this.grafico.setIcon(this.imagenes[dir]);
	}
	
	/**
	 * Getter para el label del personaje.
	 * @return JLabel asociado al personaje.
	 */
	public JLabel getLabel() {
		if (this.grafico == null) {
			this.grafico = new JLabel(imagenes[4]);
			this.grafico.setBounds(this.pos.x, this.pos.y, ancho, alto);
		}
		return this.grafico;
	}

	
}