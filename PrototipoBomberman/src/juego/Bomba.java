package juego;

import java.util.ArrayList;
import java.util.List;

import gui.Const;

public class Bomba {

	protected int alcance;
	protected Tablero miTablero;
	protected Celda miCelda;

	public Bomba(Celda c, int alcance, Tablero t) {
		miCelda = c;
		this.alcance = alcance;
		miTablero = t;
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
				
				//TODO la explosion de la bomba se saltea las paredes noDestruibles cuando el alcance es grande #viti
				List<Celda> celdasAfectadas = calcularCeldasAfectadas();
				
				for (Celda c : celdasAfectadas){
					c.detonar();
				}
				
				miTablero.devolverBombaABomberman();
				miTablero.restaurarCelda(miCelda);
			}
		}, Const.TIEMPO_DETONACION);
	}
	
	protected List<Celda> calcularCeldasAfectadas() {
		List<Celda> celdasAf = new ArrayList<Celda>();
		celdasAf.add(miCelda);
		for (int i = 1; i <= this.alcance; i++) {
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

	public Celda getCelda() {
		return miCelda;
	}
}
