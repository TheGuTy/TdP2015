package juego;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JLabel;

import gui.Const;
import gui.GUI;
import gui.Tiempo;
import personajes.Altair;
import personajes.Bomberman;
import personajes.Enemigo;
import threads.EnemigoThread;

public class Juego {

	private int puntaje;
	private Tablero miTablero;
	private Bomberman miBomberman;
	private List<EnemigoThread> misEnemigos;
	private Tiempo miTiempo;
	private GUI gui;

	public Juego (GUI gui) {

		this.gui = gui;
		puntaje = 0;
		miTablero = new Tablero(Const.PORCENTAJE_DESTRUIBLES, this, gui);
		miTiempo = new Tiempo();

		miBomberman = new Bomberman(miTablero.getCelda(1, 1), miTablero);
		misEnemigos = new LinkedList<EnemigoThread>();		
	}				

	public Tiempo getMiTiempo() {
		return miTiempo;
	}

	public void iniciarJuego(){

		miTiempo.start();

		JLabel grafBomberman = miBomberman.getLabel();
		grafBomberman.setLocation(miBomberman.getPos());
		gui.add(grafBomberman);
		
		Enemigo alt1 = new Altair(miTablero.getCelda(5, 5), miTablero);
		alt1.getLabel().setLocation(alt1.getPos());
		gui.add(alt1.getLabel());
		EnemigoThread altair1 = new EnemigoThread(alt1);
		misEnemigos.add(altair1);

		Enemigo alt2 = new Altair(miTablero.getCelda(3, 3), miTablero);
		alt2.getLabel().setLocation(alt2.getPos());
		gui.add(alt2.getLabel());
		EnemigoThread altair2 = new EnemigoThread(alt2);
		misEnemigos.add(altair2);


		// Inicio el hilo de todos los enemigos
		for (EnemigoThread e: misEnemigos) 
			e.start();

	}

	public void aumentarPuntaje (int puntaje) {

		this.puntaje += puntaje;
	}

	public Bomberman getBomberman () {

		return miBomberman;
	}	

	public void finalizarJuego () {
		miTiempo.detener();
	}	

	public void moverBomberman (int dir) {

		miBomberman.mover(dir);
	}

	/**
	 * Si hay un thread con un personaje en la celda recibida por parametro, entonces detiene su thread y elimina de la lista
	 * @param celda celda que se
	 */
	public void matarEnemigo(Celda celda){
		
		Point p = new Point(celda.getX(), celda.getY());

		List<EnemigoThread> aEliminar = new LinkedList<EnemigoThread>();

		for (EnemigoThread t : misEnemigos){
			if (t.getPosicionCelda().equals(p)){
				t.detener();
				aEliminar.add(t);
			}
		}

		for (EnemigoThread t : aEliminar)
			misEnemigos.remove(t);
	}
}
