package Juego;

import java.awt.event.KeyEvent;
import java.util.LinkedList;

import Personajes.Personaje;
import PowerUps.PowerUp;

public class Celda {

	protected int x;
	protected int y;
	protected Tablero miTablero;
	protected PowerUp miPowerUp;
	protected EstadoCelda miEstado;
	protected LinkedList<Personaje> misPersonajes;
	
	public static final int LEFT = KeyEvent.VK_LEFT;
	public static final int RIGHT = KeyEvent.VK_RIGHT;
	public static final int UP = KeyEvent.VK_UP;
	public static final int DOWN = KeyEvent.VK_DOWN;
	
	public Celda (int x, int y, Tablero t) {
		
		this.x = x;
		this.y = y;
		miTablero = t;
		miPowerUp = null;
		miEstado = null;
		misPersonajes = new LinkedList<Personaje>();
	}
	
	public void avanzar (Personaje p) {		
		miEstado.avanzar(p, this);
	}
	
	public void setPowerUp (PowerUp p) {
		
	}
	
	public PowerUp getPowerUp () {
		
		return miPowerUp;
	}
	
	public void setEstado (EstadoCelda e) {
		
		miEstado = e;
	}
	
	public void destruirPersonajes () {
		
	}
	
	public void aumentarPuntaje (int p) {
		
		miTablero.aumentarPuntaje(p);
	}
	
	public void agregarPersonaje (Personaje p) {
		
		misPersonajes.add(p);
	}
	
	public void eliminarPersonaje (Personaje p) {
		
		
	}
	
	public int getX () {
		
		return x;
	}
	
	public int getY() {
		
		return y;
	}
}
