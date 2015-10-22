package personajes;

import graficos.GraficoBomberman;
import gui.Const;
import juego.Celda;
import juego.Tablero;

public class Bomberman extends Personaje {

	protected int bombasDisponibles;
	protected int miAlcanceBomba;

	public Bomberman(Celda c, Tablero tablero) {

		super(false, 8, c, tablero);
		this.miGrafico = new GraficoBomberman(8, 1, 1);
		bombasDisponibles = 1;
		miAlcanceBomba = 1;
	}

	@Override
	public void matar() {
		System.out.println("Murio bommberguy");
		estoyVivo = false;
	}

	public void setModoAtravesar(boolean b) {
		modoAtravesar = b;
	}

	public void colocarBomba() {
		if (bombasDisponibles > 0){
			bombasDisponibles--;
			miTablero.colocarBomba(miCelda.getX(), miCelda.getY(), miAlcanceBomba);
		}
		else{
			System.out.println("No hay bombas disponibles!");
		}
	}

	public void mover(int dir) {

		calcularCeldaSiguiente(dir).avanzar(this, dir);
		
		System.out.println("Soy " + this.getClass().getName() + ". Mi posicion nueva es x: " + getCelda().getX() + " - y: " + getCelda().getY());
	}
	
	public void duplicarVelocidad() {

		velocidad *= 2;
	}

	public void aumentarBombasDisponibles() {

		bombasDisponibles++;
	}

	public void duplicarAlcance() {

		miAlcanceBomba *= 2;
	}
}
