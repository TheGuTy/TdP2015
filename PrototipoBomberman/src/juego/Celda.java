package juego;

import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import graficos.GraficoCeldaTransitable;
import graficos.GraficoEstructuras;
import gui.Const;
import juego.estadosCelda.EstadoCelda;
import personajes.Bomberman;
import personajes.Enemigo;

/**
 * Clase encargada de modelar la celda correspondiente a cada posicion lógica.
 * @author Asencio Victor, Gutierrez Gabriel, Iurchuk Joaquín
 */
public class Celda {

	protected int x;
	protected int y;
	protected Tablero miTablero;
	protected EstadoCelda miEstado;
	protected List<Enemigo> misEnemigos;
	protected Bomberman miBomberman;
	protected GraficoEstructuras miGrafico;
	protected JLabel miLabel;
	

	/**
	 * Constructor de clase.
	 * Crea una celda en una posición lógica indicada.
	 * @param x Posicion lógica horizontal de la celda.
	 * @param y Posicion lógica vertical de la celda.
	 * @param t Referencia al tablero de juego.
	 */
	public Celda(int x, int y, Tablero t) {

		this.x = x;
		this.y = y;
		miTablero = t;
		miEstado = null;
		misEnemigos = new LinkedList<Enemigo>();
		miBomberman = null;
//		miGrafico = new GraficoCeldaTransitable(x, y);
		miLabel = new JLabel();
		miLabel.setBounds(x * Const.ANCHO_CELDA, y * Const.ALTO_CELDA, Const.ANCHO_CELDA, Const.ALTO_CELDA);

	}
	
	/**
	 * Metodo que le indica al estado actual de la celda que mueva
	 * al bomberman en una dirección indicada.
	 * @param bomberman Referencia a Bomberman.
	 * @param dir Dirección de movimiento.
	 */
	public void avanzar(Bomberman bomberman, int dir) {
		miEstado.avanzar(bomberman, this, dir);
	}

	/**
	 * Metodo que le indica al estado actual de la celda que mueva
	 * al enemigo en una dirección indicada.
	 * @param enemigo Referencia al enemigo.
	 * @param dir Dirección de movimiento.
	 */
	public void avanzar(Enemigo enemigo, int dir) {
		miEstado.avanzar(enemigo, this, dir);
	}
	
	
	
	/**
	 * Setter para cambiar el estado actual de la celda.
	 * @param e Estado al cual pasará la celda.
	 */
	public void setEstado(EstadoCelda e) {
		
		miEstado = e;		
		miLabel.setIcon(e.getGrafico().getIcon());		
		
	}
	
	/**
	 * Elimina todos los enemigos ubicados en ésta celda.
	 */
	public void destruirEnemigos() {
		
		List<Enemigo> aMatar = new LinkedList<Enemigo>();
		
		for (Enemigo e : misEnemigos){
			aMatar.add(e);
			e.matar();
		}
		
		for (Enemigo e : aMatar)
			misEnemigos.remove(e);
		
		miTablero.getJuego().matarEnemigo(this);
	}
	
	/**
	 * Incrementa el puntaje del juego en una cantidad indicada.
	 * @param p Cantidad de puntaje a incrementar.
	 */
	public void aumentarPuntaje(int p) {

		miTablero.aumentarPuntaje(p);
	}

	/**
	 * Agrega un enemigo a la lista de enemigos perteneciente a la celda.
	 * @param enemigo Enemigo a agregar a la lista.
	 */
	public void agregarEnemigo(Enemigo enemigo) {
		misEnemigos.add(enemigo);
	}

	/**
	 * Elimina un enemigo de la lista de enemigos perteneciente a la celda.
	 * @param enemigo Enemigo a eliminar de la lista.
	 */
	public void eliminarEnemigo(Enemigo enemigo) {
		misEnemigos.remove(enemigo);
	}

	/**
	 * Agrega a Bomberman a ésta celda.
	 * @param b Referencia a Bomberman.
	 */
	public void agregarBomberman(Bomberman b) {
		miBomberman = b;
	}

	/**
	 * Quita a Bomberman de ésta celda.
	 */
	public void eliminarBomberman() {
		miBomberman = null;
	}

	/**
	 * Retorna la posición lógica horizontal de la celda.
	 * @return Posición horizontal.
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Retorna la posición lógica vertical de la celda.
	 * @return Posición vertical.
	 */
	public int getY() {

		return y;
	}

	/**
	 * Chequea si hay enemigos actualmente en ésta celda.
	 * @return true si hay enemigos, false en caso contrario.
	 */
	public boolean hayEnemigos() {

		return !misEnemigos.isEmpty();
	}

	/**
	 * Chequea si el Bomberman se encuentra en ésta celda.
	 * @return true si el Bomberman está en ésta celda, false en caso contrario.
	 */
	public boolean hayBomberman() {

		return miBomberman != null;
	}

	/**
	 * Método que le indica a la lógica del juego que el Bomberman ha muerto.
	 */
	public void matarBomberman() {

		if (miBomberman != null){
			miBomberman.matar();
		}
		// TODO Notificar al juego que murio bomberman. Desde aca el unico camino es usar el tablero y desde ahi obtener la referencia al juego 
	}
	
	/**
	 * Método que retorna el estado actual de la celda.
	 * @return Estado actual de la celda.
	 */
	public EstadoCelda getEstado() {
		return miEstado;
	}

	/**
	 * Metodo que le indica al estado actual de la celda que 
	 * una bomba afectó a ésta celda y hay que modificar su contenido.
	 */
	public void detonar() {
		miEstado.destruir(this);
	}
	
	public JLabel getLabel() {
		
		return miLabel;
	}
}