package graficos;

import javax.swing.ImageIcon;

import gui.Const;

public class GraficoAltair extends GraficoPersonaje {

	public GraficoAltair(int velocidad, int x, int y) {
		super(velocidad, x, y);
		
		getGrafico().setBounds(x * Const.ANCHO_PERSONAJE, y * Const.ALTO_PERSONAJE, Const.ANCHO_PERSONAJE, Const.ALTO_PERSONAJE);
		
		imagenes[Const.MOVIMIENTO_ARRIBA] = new ImageIcon(this.getClass().getResource("/Recursos/arr2.png"));		
		imagenes[Const.MOVIMIENTO_ABAJO] = new ImageIcon(this.getClass().getResource("/Recursos/aba2.png"));
		imagenes[Const.MOVIMIENTO_IZQUIERDA] = new ImageIcon(this.getClass().getResource("/Recursos/izq2.png"));
		imagenes[Const.MOVIMIENTO_DERECHA] = new ImageIcon(this.getClass().getResource("/Recursos/der2.png"));
		grafico.setIcon(imagenes[3]);
	}	
}