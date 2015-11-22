package juego.estadosCelda;

import javax.swing.ImageIcon;

import graficos.GraficoCeldaTransitable;
import juego.Celda;
import personajes.Bomberman;
import personajes.Enemigo;

/**
 * Clase que modela un tipo de EstadoCelda efectivo: No transitable
 * @author Asencio Victor, Gutierrez Gabriel, Iurchuk Joaquín
 *
 */
public class EstadoTransitable extends EstadoCelda {

	/**
	 * Constructor de un EstadoTransitable
	 * Se utiliza para modelar el estado de una celda que es libremente transitable
	 * @param x posicion x dentro de la matriz de celdas 
	 * @param y posicion y dentro de la matriz de celdas
	 */
	public EstadoTransitable(int x, int y) {
		super(new GraficoCeldaTransitable(x, y));
	}

	@Override
	public void destruir(Celda c) {
		c.getLabel().setIcon(new ImageIcon(this.getClass().getResource("/Recursos/explosion.png")));
		new java.util.Timer().schedule(new java.util.TimerTask() {
			@Override
			public void run() {
				c.getLabel().setIcon(null);
			}
		}, 1500);
		
		c.matarBomberman();
		c.destruirEnemigos();
	}

	@Override
	public void avanzar(Bomberman bomberman, Celda celdaSiguiente, int dir) {
		
		
		if (celdaSiguiente.hayEnemigos()) {
			bomberman.matar();
			System.out.println("El bomberman colisiona con un enemigo");
		} else {
			if (bomberman.getLock() == false) {
				bomberman.lock();
				bomberman.getCelda().eliminarBomberman();
				bomberman.setCelda(celdaSiguiente);
				celdaSiguiente.agregarBomberman(bomberman);

				bomberman.moverGrafica(dir);
			} else
				System.out.println("Bomberman esta bloqueado");
		}
	}

	@Override
	public void avanzar(Enemigo enemigo, Celda celdaSiguiente, int dir) {

		if (celdaSiguiente.hayBomberman()) {
			if (enemigo.getLock() == false) {
				enemigo.lock();
				System.out.println("El enemigo colisiona con bomberman");
				celdaSiguiente.matarBomberman();
				enemigo.getCelda().eliminarEnemigo(enemigo);
				enemigo.setCelda(celdaSiguiente);
				celdaSiguiente.agregarEnemigo(enemigo);

				enemigo.moverGrafica(dir);
			}
		} else {
			if (enemigo.getLock() == false) {
				enemigo.lock();
				enemigo.getCelda().eliminarEnemigo(enemigo);
				enemigo.setCelda(celdaSiguiente);
				celdaSiguiente.agregarEnemigo(enemigo);

				enemigo.moverGrafica(dir);
			}
		}
	}
}
