package juego.estadosCelda;

import javax.swing.ImageIcon;

import graficos.estructuras.GraficoParedDestruible;
import gui.SoundPlayer;
import juego.Celda;
import personajes.Bomberman;
import personajes.Enemigo;

/**
 * Clase que modela un tipo de EstadoCelda efectivo: Destruible
 * @author Asencio Victor, Gutierrez Gabriel, Iurchuk Joaquín
 *
 */
public class EstadoDestruible extends EstadoCelda {

	private final static int PUNTAJE=10;
	protected EstadoCelda miProximoEstado;
	
	/**
	 * Constructor de un EstadoDestruible
	 * Se utiliza para modelar el estado de una celda que posee una pared destruible
	 */
	public EstadoDestruible() {
		super(new GraficoParedDestruible());
		miProximoEstado = new EstadoTransitable();
	}
	
	/**
	 * Constructor de un EstadoDestruible
	 * Se utiliza para modelar el estado de una celda que posee una pared destruible pero que al destruirse se volvera un PowerUp
	 * @param miProximoEstado Estado proximo al que se cambiara una vez que esta celda destruible sea destruida
	 */
	public EstadoDestruible(EstadoCelda miProximoEstado) {
		super(new GraficoParedDestruible());
		this.miProximoEstado = miProximoEstado;
	}

	@Override
	public int destruir(Celda celda) {
		
		SoundPlayer.destroyedWall();
		
		celda.getLabel().setIcon(new ImageIcon(this.getClass().getResource("/Recursos/explosion.png")));

		celda.getMiTablero().getMisParedesDestruibles().remove(celda);
		
		celda.matarBomberman();
		int aux = 0;
		aux = celda.destruirEnemigos();

		new java.util.Timer().schedule(new java.util.TimerTask() {
			@Override
			public void run() {				
				celda.setEstado(miProximoEstado);
			}
		}, 1500);
		
		return PUNTAJE+aux;
	}

	@Override
	public void avanzar(Bomberman bomberman, Celda celdaSiguiente, int dir) {

		if (bomberman.enModoAtravesar()) {
			if (celdaSiguiente.hayEnemigos()) {
				bomberman.matar();
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
