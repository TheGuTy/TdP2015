package graficos;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.JLabel;

import gui.Const;

public abstract class GraficoEstructuras {
	protected JLabel label;
	protected Icon imagenes[];
	protected final int ancho = Const.ANCHO_CELDA;
	protected final int alto = Const.ALTO_CELDA;

	protected Point pos;

	protected GraficoEstructuras(int x, int y) {
		this.pos = new Point(x * this.ancho, y * this.alto);
		this.imagenes = new Icon[1];
		label = null;
	}

	public Point getPos() {
		return pos;
	}

	public void changeIcon(int dir) {
		this.label.setIcon(this.imagenes[dir]);
	}

	public JLabel getLabel() {
		if (this.label == null) {
			this.label = new JLabel(imagenes[0]);
			this.label.setBounds(this.pos.x, this.pos.y, ancho, alto);
		}
		return this.label;
	}
	
	public int getAlto() {
		return alto;
	}
	
	public int getAncho() {
		return ancho;
	}
}