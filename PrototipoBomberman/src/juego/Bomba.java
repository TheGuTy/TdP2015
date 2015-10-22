package juego;

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
			}
		}, Const.TIEMPO_DETONACION);
	}
}
