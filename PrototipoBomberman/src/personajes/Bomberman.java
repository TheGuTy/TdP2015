package personajes;

import graficos.GraficoBomberman;
import gui.Const;
import juego.Celda;
import juego.Tablero;

public class Bomberman extends Personaje implements Runnable {

	protected int bombasDisponibles;
	protected int miAlcanceBomba;
	private int dir;
	private Thread t;

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


	@Override
	public void run() {
		
		lock = true;
		miGrafico.changeIcon(dir);
		
		try {
			switch (dir) {
			case Const.MOVIMIENTO_ARRIBA:
				for (int i = 0; i < miGrafico.getAlto(); i += velocidad) {
					miGrafico.getLabel().setBounds(miGrafico.getPos().x, miGrafico.getPos().y -= velocidad,
							miGrafico.getAncho(), miGrafico.getAlto());
					Thread.sleep(10);
				}
				break;
			case Const.MOVIMIENTO_ABAJO:
				for (int i = 0; i < miGrafico.getAlto(); i += velocidad) {
					miGrafico.getLabel().setBounds(miGrafico.getPos().x, miGrafico.getPos().y += velocidad,
							miGrafico.getAncho(), miGrafico.getAlto());
					Thread.sleep(10);
				}
				break;
			case Const.MOVIMIENTO_IZQUIERDA:
				for (int i = 0; i < miGrafico.getAncho(); i += velocidad) {
					miGrafico.getLabel().setBounds(miGrafico.getPos().x -= velocidad, miGrafico.getPos().y,
							miGrafico.getAncho(), miGrafico.getAlto());
					Thread.sleep(10);
				}
				break;
			case Const.MOVIMIENTO_DERECHA:
				for (int i = 0; i < miGrafico.getAncho(); i += velocidad) {
					miGrafico.getLabel().setBounds(miGrafico.getPos().x += velocidad, miGrafico.getPos().y,
							miGrafico.getAncho(), miGrafico.getAlto());
					Thread.sleep(10);
				}
				break;
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		lock = false;
	}
	
	@Override
	public void moverGrafica(int dir) {
		this.dir = dir;
		t = new Thread(this);
		t.start();
	}
}
