package Juego;

import java.util.List;

import Personajes.Bomberman;
import Personajes.Enemigo;

public class Juego {

	private int puntaje;
	private Tablero miTablero;
	private Bomberman miBomberman;
	private List<Enemigo> misEnemigos;
	
	public Juego () {
		
		puntaje = 0;
		miTablero = new Tablero(50, this, 31, 31);
		miBomberman = new Bomberman(miTablero.getCelda(0, 0), miTablero);
	}
	
	public void aumentarPuntaje (int p) {
		
		puntaje += p;
	}
	
	public Bomberman getBomberman () {
		
		return miBomberman;
	}
	
	public void iniciarJuego () {
		
	}
	
	public void finalizarJuego () {
		
	}
	
	public void eliminarEnemigo (Enemigo e) {
		
	}
	
	public void moverEnemigos () {
		
		for (Enemigo e : misEnemigos) {
			e.mover();
		}
	}
}
