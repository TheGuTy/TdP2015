package Juego;

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
	
	public Celda (int x, int y, Tablero t) {
		
		this.x = x;
		this.y = y;
		miTablero = t;
		miPowerUp = null;
		miEstado = null;
		misPersonajes = new LinkedList<Personaje>();
	}
	
	public void avanzar (Personaje p) {
		
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
