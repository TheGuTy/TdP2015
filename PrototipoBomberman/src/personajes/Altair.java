package personajes;

import graficos.GraficoAltair;
import graficos.GraficoBomberman;
import juego.Celda;
import juego.Tablero;

public class Altair extends Enemigo {

	private final static int VELOCIDAD_INICIAL = 1;
	private final static int PUNTAJE = 20;
	
	public Altair (Celda celda, Tablero t) {
		
		super(false, VELOCIDAD_INICIAL, celda, t, PUNTAJE);
		this.miGrafico = new GraficoAltair(1, celda.getX(), celda.getY());
	}
}
