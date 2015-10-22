package graficos;

import javax.swing.ImageIcon;

import gui.Const;

public class GraficoBomba extends GraficoEstructuras {

	public GraficoBomba(int x, int y) {
		super(x, y);
		
		getLabel().setBounds(x * Const.ANCHO_CELDA, y * Const.ALTO_CELDA, Const.ANCHO_CELDA, Const.ALTO_CELDA);
		imagenes[0] = new ImageIcon(this.getClass().getResource("/Recursos/bomb.png"));		
		getLabel().setIcon(imagenes[0]);
	}	
}