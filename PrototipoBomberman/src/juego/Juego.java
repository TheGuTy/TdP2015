package juego;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.JLabel;

import gui.Const;
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
		misEnemigos = new LinkedList<EnemigoThread>();		
		miTablero = new Tablero(this, gui);
		miTiempo = new Tiempo(gui);
		miTiempo.iniciarReloj();

		miBomberman = new Bomberman(miTablero.getCelda(1, 1), miTablero);
	}				
	
	public int getPuntaje() {
		return puntaje;
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

		// Creacion del bomberman
		JLabel grafBomberman = miBomberman.getLabel();
		grafBomberman.setLocation(miBomberman.getPos());
		gui.add(grafBomberman);
		miTablero.getCelda(miBomberman.getCelda().getX(), miBomberman.getCelda().getY()).agregarBomberman(miBomberman);

		// Creando Enemigos
		int cantAltair = Const.CANT_ALTAIR;
		int cantRugulus = Const.CANT_RUGULUS;
		int cantSirius = Const.CANT_SIRIUS;

		boolean termine = false;

		Random rnd = new Random();

		while(!termine){
			Celda nueva = miTablero.getCelda(rnd.nextInt(Const.CANT_CELDAS_ANCHO),rnd.nextInt(Const.CANT_CELDAS_ALTO));

			if(miTablero.getMapeoControl().get(nueva)==null){

				if(cantAltair>=0){
					Enemigo alt1 = new Altair(nueva, miTablero);
					alt1.getLabel().setLocation(alt1.getPos());
					gui.add(alt1.getLabel());
					EnemigoThread altair1 = new EnemigoThread(alt1);
					misEnemigos.add(altair1);
					cantAltair--;
				}else
					termine = true;
				miTablero.getMapeoControl().put(nueva, true);
			}
		}

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
		gui.actualizarPuntaje(this.puntaje);
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

	public List<EnemigoThread> getMisEnemigos() {
		return misEnemigos;
	}

	public void notificarMuerteBomberman() {
		miTiempo.detenerTiempo();
	}
}
