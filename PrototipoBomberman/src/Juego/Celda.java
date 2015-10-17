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
		
	}
	
	public void agregarPersonaje (Personaje p) {
		
	}
	
	public void eliminarPersonaje (Personaje p) {
		
	}
	
}
