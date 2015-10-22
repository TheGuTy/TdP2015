package juego;

import java.util.LinkedList;

import graficos.GraficoEstructuras;
import personajes.Bomberman;
import personajes.Enemigo;
import powerups.PowerUp;

public class Celda {

	protected int x;
	protected int y;
	protected Tablero miTablero;
	protected PowerUp miPowerUp;
	protected EstadoCelda miEstado;
	protected LinkedList<Enemigo> misEnemigos;
	protected Bomberman miBomberman;

	public Celda(int x, int y, Tablero t) {

		this.x = x;
		this.y = y;
		miTablero = t;
		miPowerUp = null;
		miEstado = null;
		misEnemigos = new LinkedList<Enemigo>();
		miBomberman = null;
	}

	public void avanzar(Bomberman bomberman, int dir) {
		miEstado.avanzar(bomberman, this, dir);
	}

	public void avanzar(Enemigo enemigo, int dir) {
		miEstado.avanzar(enemigo, this, dir);
	}

	public void setPowerUp(PowerUp powerup) {

	}

	public PowerUp getPowerUp() {

		return miPowerUp;
	}

	public void setEstado(EstadoCelda e) {

		miEstado = e;
	}

	public void destruirPersonajes() {

	}

	public void aumentarPuntaje(int p) {

		miTablero.aumentarPuntaje(p);
	}

	public void agregarEnemigo(Enemigo enemigo) {
		misEnemigos.add(enemigo);
	}

	public void eliminarEnemigo(Enemigo enemigo) {
		misEnemigos.remove(enemigo);
	}

	public void agregarBomberman(Bomberman b) {
		miBomberman = b;
	}

	public void eliminarBomberman() {
		miBomberman = null;
	}

	public int getX() {

		return x;
	}

	public int getY() {

		return y;
	}

	public boolean hayEnemigos() {

		return !misEnemigos.isEmpty();
	}

	public boolean hayBomberman() {

		return miBomberman != null;
	}

	public void matarBomberman() {

		if (miBomberman != null){
			miBomberman.matar();
		}
		// TODO Notificar al juego que murio bomberman. Desde aca el unico camino es usar el tablero y desde ahi obtener la referencia al juego 
	}

	public EstadoCelda getEstado() {
		return miEstado;
	}
	
	
}