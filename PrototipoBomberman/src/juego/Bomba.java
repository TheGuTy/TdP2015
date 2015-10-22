package juego;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import graficos.GraficoBomba;
import graficos.GraficoEstructuras;
import gui.Const;

public class Bomba {

	protected int alcance;
	protected Tablero miTablero;
	protected Celda miCelda;
	protected GraficoEstructuras miGrafico;

	public Bomba(Celda c, int alcance, Tablero t) {
		miCelda = c;
		this.alcance = alcance;
		miTablero = t;
		miGrafico = new GraficoBomba(c.getX(), c.getY());
	}

	public void comenzarDetonacion() {

		new java.util.Timer().schedule(new java.util.TimerTask() {
			@Override
			public void run() {
				System.out.println("Explotó la bomba");
				// TODO Cambiar la imagen por un humito o algo asi. Quizas
				// convenga que tenga varias imagenes la bomba y las recorremos
				// con un for. Estamos dentro de un thread, asi que podemos llamar
				// a Thread.sleep entre cada imagen y asi lograr el efecto.
				
				miGrafico.getLabel().setIcon(null);
				List<Celda> celdasAfectadas = calcularCeldasAfectadas();
				
				for (Celda c : celdasAfectadas)
					c.detonar();
				
				miTablero.devolverBomba();
			}
		}, Const.TIEMPO_DETONACION);
	}
	
	protected List<Celda> calcularCeldasAfectadas() {
		List<Celda> celdasAf = new ArrayList<Celda>();
		celdasAf.add(miCelda);
		for (int i = 1; i <= 7; i++) {
			if(miCelda.getY()-i>=0){
				celdasAf.add(miTablero.getCelda(miCelda.getX(), miCelda.getY()-i));
			}
			if(miCelda.getY()+i<Const.CANT_CELDAS_ALTO){
				celdasAf.add(miTablero.getCelda(miCelda.getX(), miCelda.getY()+i));
			}
			if(miCelda.getX()-i>=0){
				celdasAf.add(miTablero.getCelda(miCelda.getX()-i, miCelda.getY()));
			}
			if(miCelda.getX()+i<Const.CANT_CELDAS_ANCHO){ 
				celdasAf.add(miTablero.getCelda(miCelda.getX()+i, miCelda.getY())); 
			}
		}
		
		return celdasAf;
	}

	public GraficoEstructuras getGrafico() {
		return miGrafico;
	}
}
