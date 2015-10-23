package personajes;

import java.util.Random;

import gui.Const;
import juego.Celda;
import juego.Tablero;

public abstract class Enemigo extends Personaje {

	protected int puntaje;

	protected Enemigo (boolean modoAtravesar, int vel, Celda c, Tablero t, int p) {

		super(modoAtravesar, vel, c, t);
	}

	public int getPuntaje () {
		return puntaje;
	}

	public void mover () {
		int dir = new Random().nextInt(4);
		calcularCeldaSiguiente(dir).avanzar(this, dir);
		System.out.println("Soy " + this.getClass().getName() + ". Mi posicion nueva es x: " + getCelda().getX() + " - y: " + getCelda().getY());
	}
	
	@Override
	public void matar(){
		System.out.println("Murio " + this.getClass().getSimpleName());
		estoyVivo = false;
		
	}
	
	@Override
	public void moverGrafica(int dir) {

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
}