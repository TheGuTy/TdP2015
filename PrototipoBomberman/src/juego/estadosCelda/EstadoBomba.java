package juego.estadosCelda;

import javax.swing.ImageIcon;

import graficos.estructuras.GraficoBomba;
import gui.Const;
import juego.Celda;
import personajes.Bomberman;
import personajes.Enemigo;

/**
 * Clase que modela un tipo de EstadoCelda efectivo: Celda con Bomba
 * @author Asencio Victor, Gutierrez Gabriel, Iurchuk Joaquín
 *
 */
public class EstadoBomba extends EstadoCelda {

	/**
	 * Constructor de un EstadoBomba
	 * Se utiliza para modelar el estado de una celda que contiene una bomba
	 * @param x posicion x dentro de la matriz de celdas 
	 * @param y posicion y dentro de la matriz de celdas
	 */
	public EstadoBomba() {
		super(new GraficoBomba());

	}

	@Override
	public int destruir(Celda celda) {

		celda.getLabel().setIcon(new ImageIcon(this.getClass().getResource("/Recursos/ExplosionGif2.gif")));
		
		celda.matarBomberman();
		int puntaje = celda.destruirEnemigos();

		new java.util.Timer().schedule(new java.util.TimerTask() {
			@Override
			public void run() {
				celda.setEstado(new EstadoTransitable());
			}
		}, Const.COUNTDOWN_EXPLOSION);
		
		return puntaje;
	}



	@Override
	public void avanzar(Bomberman bomberman, Celda celdaSiguiente, int dir) {
		System.out.println("AVANZAR BOMBERMAN DESDE ESTADO BOMBA");

		if (bomberman.enModoAtravesar()) {
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
				}
			}
		}
	}

	@Override
	public void avanzar(Enemigo enemigo, Celda celdaSiguiente, int dir) {

		System.out.println("AVANZAR ENEMIGO DESDE ESTADO BOMBA");
		if (enemigo.enModoAtravesar()) {
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
}