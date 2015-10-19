package Juego;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import Personajes.Altair;
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
		misEnemigos = new LinkedList<Enemigo>();
		
		Random r = new Random();
		int rnd = r.nextInt(31);
		for (int i = 0; i < 1; i++) {
			int rx = r.nextInt(31), ry = r.nextInt(31);
			Enemigo e = new Altair(miTablero.getCelda(rx, ry), miTablero);
			e.start();
			misEnemigos.add(e);			
		}				
		
	}
	
	public void aumentarPuntaje (int p) {
		
		puntaje += p;
	}
	
	public Bomberman getBomberman () {
		
		return miBomberman;
	}	
	
	public void finalizarJuego () {
		
	}
	
	public void eliminarEnemigo (Enemigo e) {
		
	}	
	
	
	public void moverBomberman (int dir) {
		
		miBomberman.mover(dir);
	}
}
