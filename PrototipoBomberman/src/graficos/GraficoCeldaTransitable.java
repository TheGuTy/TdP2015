package graficos;

import javax.swing.ImageIcon;

import gui.Const;

public class GraficoCeldaTransitable extends GraficoEstructuras {

	public GraficoCeldaTransitable(int x, int y) {
		super(x, y);
		
		getLabel().setBounds(x * Const.ANCHO_CELDA, y * Const.ALTO_CELDA, Const.ANCHO_CELDA, Const.ALTO_CELDA);
		imagenes[Const.MOVIMIENTO_ARRIBA] = new ImageIcon(this.getClass().getResource("/recursos/transitable.png"));		
		this.label.setIcon(imagenes[Const.MOVIMIENTO_ARRIBA]);
	}	
}