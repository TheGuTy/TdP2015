package Juego;

import java.util.LinkedList;

import Personajes.Bomberman;
import Personajes.Enemigo;

public class Juego {

	protected int puntaje;
	protected Tablero miTablero;
	protected Bomberman miBomberman;
	protected LinkedList<Enemigo> misEnemigos;
	
	public Juego () {
		
		puntaje = 0;
	}
	
	public void aumentarPuntaje (int p) {
		
		puntaje += p;
	}
	
	public void iniciarJuego () {
		
	}
	
	public void finalizarJuego () {
		
	}
	
	public void eliminarEnemigo (Enemigo e) {
		
	}
}
