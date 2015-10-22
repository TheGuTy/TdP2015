package Personajes;

import Graficos.GraficoBomberman;
import Juego.Celda;
import Juego.Tablero;

public class Bomberman extends Personaje {

	protected int bombasDisponibles;
	protected int miAlcanceBomba;
	protected boolean lock;

	public Bomberman(Celda c, Tablero tablero) {

		super(false, 2, c, tablero);
		this.miGrafico = new GraficoBomberman(2, 1, 1);
		lock = false;
	}

	@Override
	public void matar() {
		
		this.miGrafico.getGrafico().setIcon(null);
	}

	public void setModoDios(boolean b) {

		modoDios = b;
	}

	public void colocarBomba() {

		miTablero.colocarBomba(miCelda.getX(), miCelda.getY(), miAlcanceBomba);
	}

	public void mover(int dir) {

		int xActual = miCelda.getX();
		int yActual = miCelda.getY();
		Celda celdaSiguiente;
		String ultimoMovimiento = "";

		switch (dir) {
			case 0: { // arriba
				yActual--;
				if (yActual < 0)
					yActual = 0;
				ultimoMovimiento = "arriba";
				break;
			}
			case 1: { // abajo
				yActual++;
				if (yActual >= miTablero.getAlto())
					yActual = miTablero.getAlto() - 1;
	
				ultimoMovimiento = "abajo";
				break;
			}
			case 2: { // izquierda
				xActual--;
				if (xActual <= 0)
					xActual = 0;
				ultimoMovimiento = "izquierda";
				break;
			}
			case 3: { // derecha
				xActual++;
				if (xActual >= miTablero.getAncho())
					xActual = miTablero.getAncho() - 1;
				ultimoMovimiento = "derecha";
				break;
			}
		}
		
		//miGrafico.mover(dir);
		//miGrafico.changeIcon(dir);
		celdaSiguiente = miTablero.getCelda(xActual, yActual);

//		System.out.println("Soy " + this.getClass().getName() + ". Mi posicion antes de moverme es x: "
//				+ getCelda().getX() + " - y: " + getCelda().getY());
		celdaSiguiente.avanzar(this,dir);
		System.out.println("Soy " + this.getClass().getName() + ". Mi posicion nueva es x: " + getCelda().getX()
				+ " - y: " + getCelda().getY() + ". Mi movimiento fue " + ultimoMovimiento);
	}
	
	public void moverGrafica(int dir) {
		lock = true;
		if (this.miGrafico != null) {
			
			miGrafico.changeIcon(dir);

			try {
				//						System.out.println("Soy " + this.getClass().getName() + ". Mi POINT vieja es x: " + getPos().getX() + " - y: " + getPos().getY() );
				switch (dir) {
				case 0: // Arriba
					for (int i = 0; i < miGrafico.getAlto(); i += velocidad) {
						miGrafico.getGrafico().setBounds(miGrafico.getPos().x, miGrafico.getPos().y -= velocidad, miGrafico.getAncho(), miGrafico.getAlto());
						Thread.sleep(10);
					}
					//							System.out.println("Soy " + this.getClass().getName() + ". Mi POINT nueva es x: " + getPos().getX() + " - y: " + getPos().getY() );
					break;
				case 1: // Abajo
					for (int i = 0; i < miGrafico.getAlto(); i += velocidad) {
						miGrafico.getGrafico().setBounds(miGrafico.getPos().x, miGrafico.getPos().y += velocidad, miGrafico.getAncho(), miGrafico.getAlto());
						Thread.sleep(10);
					}
					//							System.out.println("Soy " + this.getClass().getName() + ". Mi POINT nueva es x: " + getPos().getX() + " - y: " + getPos().getY() );
					break;
				case 3: // Derecha
					for (int i = 0; i < miGrafico.getAncho(); i += velocidad) {
						miGrafico.getGrafico().setBounds(miGrafico.getPos().x += velocidad, miGrafico.getPos().y, miGrafico.getAncho(), miGrafico.getAlto());
						Thread.sleep(10);
					}
					//							System.out.println("Soy " + this.getClass().getName() + ". Mi POINT nueva es x: " + getPos().getX() + " - y: " + getPos().getY() );
					break;
				case 2: // Izquierda
					for (int i = 0; i < miGrafico.getAncho(); i += velocidad) {
						miGrafico.getGrafico().setBounds(miGrafico.getPos().x -= velocidad, miGrafico.getPos().y, miGrafico.getAncho(), miGrafico.getAlto());
						Thread.sleep(10);
					}
					//							System.out.println("Soy " + this.getClass().getName() + ". Mi POINT nueva es x: " + getPos().getX() + " - y: " + getPos().getY() );
					break;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		lock = false;
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

	public boolean getLock() {
		
		return lock;
	}
	
	
	
}
