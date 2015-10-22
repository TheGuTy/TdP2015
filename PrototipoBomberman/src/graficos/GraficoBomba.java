package graficos;

import javax.swing.ImageIcon;

import gui.Const;

public class GraficoBomba extends GraficoEstructuras {

	public GraficoBomba(int x, int y) {
		super(x, y);
		
		getGrafico().setBounds(x * Const.ANCHO_PERSONAJE, y * Const.ALTO_PERSONAJE, Const.ANCHO_PERSONAJE, Const.ALTO_PERSONAJE);
		imagenes[Const.MOVIMIENTO_ARRIBA] = new ImageIcon(this.getClass().getResource("/Recursos/bomb.png"));		
		grafico.setIcon(imagenes[0]);
	}	
}