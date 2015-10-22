package graficos;

import javax.swing.ImageIcon;

import gui.Const;

public class GraficoBomberman extends GraficoPersonaje {

	public GraficoBomberman(int velocidad, int x, int y) {
		super(velocidad, x, y);
		
		getGrafico().setBounds(x * Const.ANCHO_CELDA, y * Const.ALTO_CELDA, Const.ANCHO_CELDA, Const.ALTO_CELDA);
		
		imagenes[Const.MOVIMIENTO_ARRIBA] = new ImageIcon(this.getClass().getResource("/Recursos/arr.png"));		
		imagenes[Const.MOVIMIENTO_ABAJO] = new ImageIcon(this.getClass().getResource("/Recursos/aba.png"));
		imagenes[Const.MOVIMIENTO_IZQUIERDA] = new ImageIcon(this.getClass().getResource("/Recursos/izq.png"));
		imagenes[Const.MOVIMIENTO_DERECHA] = new ImageIcon(this.getClass().getResource("/Recursos/der.png"));
		grafico.setIcon(imagenes[3]);
	}	
}