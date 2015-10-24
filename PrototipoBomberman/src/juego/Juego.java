package juego;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JLabel;

import gui.GUI;
import gui.Tiempo;
import personajes.Altair;
import personajes.Bomberman;
import personajes.Enemigo;
import threads.EnemigoThread;

/**
 * Clase encargada de modelar la instancia de un juego, 
 * el cual posee enemigos y un personaje principal.
 * @author Asencio Victor, Gutierrez Gabriel, Iurchuk Joaquín
 */
public class Juego {

	private int puntaje;
	private Tablero miTablero;
	private Bomberman miBomberman;
	private List<EnemigoThread> misEnemigos;
	private Tiempo miTiempo;
	private GUI gui;

	/**
	 * Crea el juego e inicializa los componentes principal de taal juego.
	 * @param gui Referencia a la GUI del juego.
	 */
	public Juego (GUI gui) {

		this.gui = gui;
		puntaje = 0;
		miTablero = new Tablero(this, gui);
		miTiempo = new Tiempo();

		miBomberman = new Bomberman(miTablero.getCelda(1, 1), miTablero);
		misEnemigos = new LinkedList<EnemigoThread>();		
	}				

	/**
	 * Getter para obtener el tiempo trascurrido de juego.
	 * @return Tiempo actual trascurrido.
	 */
	public Tiempo getMiTiempo() {
		return miTiempo;
	}

	/**
	 * Método encargado de inicializar los personajes incluidos en el juego.
	 */
	public void iniciarJuego(){

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
	
	/**
	 * Método encargado de aumentar el puntaje actual del juego 
	 * en una cantidad indicada.
	 * @param puntaje Cantidad a aumentar.
	 */
	public void aumentarPuntaje (int puntaje) {

		this.puntaje += puntaje;
	}

	/**
	 * Getter para el personaje principal del juego.
	 * @return Devuelo el personaje principal.
	 */
	public Bomberman getBomberman () {

		return miBomberman;
	}	

	/**
	 * Método que le indica a Bomberman que se mueva en una dirección indicada 
	 * @param dir Dirección de movimiento.
	 */
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
				t.interrupt();
				aEliminar.add(t);
			}
		}

		for (EnemigoThread t : aEliminar)
			misEnemigos.remove(t);
	}
}
