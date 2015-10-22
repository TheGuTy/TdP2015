package graficos;

import javax.swing.ImageIcon;

import gui.Const;

public class GraficoCeldaBomba extends GraficoEstructuras {
	
	public GraficoCeldaBomba(int x, int y) {
		super(x, y);

		getLabel().setBounds(x * Const.ANCHO_CELDA, y * Const.ALTO_CELDA, Const.ANCHO_CELDA, Const.ALTO_CELDA);
		imagenes[Const.MOVIMIENTO_ARRIBA] = new ImageIcon(this.getClass().getResource("/recursos/bomb.png"));
		this.label.setIcon(imagenes[Const.MOVIMIENTO_ARRIBA]);
	}
}