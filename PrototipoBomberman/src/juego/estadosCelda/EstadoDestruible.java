package juego.estadosCelda;

import javax.swing.ImageIcon;

import graficos.GraficoEstructuras;
import juego.Celda;
import personajes.Bomberman;
import personajes.Enemigo;

/**
 * Clase que modela un tipo de EstadoCelda efectivo: Destruible
 * @author Asencio Victor, Gutierrez Gabriel, Iurchuk Joaquín
 *
 */
public class EstadoDestruible extends EstadoCelda {

	/**
	 * Constructor de un EstadoDestruible
	 * Se utiliza para modelar el estado de una celda que posee una pared destruible
	 * @param x posicion x dentro de la matriz de celdas 
	 * @param y posicion y dentro de la matriz de celdas
	 */
	public EstadoDestruible(GraficoEstructuras miGrafico) {
		super(miGrafico);
	}

	@Override
	public void destruir(Celda c) {
		c.getEstado().getGrafico().getLabel().setIcon(new ImageIcon(this.getClass().getResource("/Recursos/explosion.png")));
		c.matarBomberman();
		c.destruirEnemigos();
		
		
		new java.util.Timer().schedule(new java.util.TimerTask() {
			@Override
			public void run() {
				c.getEstado().getGrafico().getLabel().setIcon(null);
				c.setEstado(new EstadoTransitable(c.getX(), c.getY()));
			}
		}, 1500);
		
//		c.getEstado().getGrafico().getLabel().setIcon(null);
	}

	@Override
	public void avanzar(Bomberman bomberman, Celda celdaSiguiente, int dir) {

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
				} else
					System.out.println("Bomberman esta bloqueado");
			}
		}
	}

	@Override
	public void avanzar(Enemigo enemigo, Celda celdaSiguiente, int dir) {

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
