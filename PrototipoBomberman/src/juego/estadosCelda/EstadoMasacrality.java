package juego.estadosCelda;

import graficos.powerups.GraficoMasacrality;
import gui.SoundPlayer;
import juego.Celda;
import personajes.Bomberman;
import personajes.Enemigo;

/**
 * Clase que modela un tipo de EstadoCelda efectivo: Celda con PowerUp Speed Up
 * @author Asencio Victor, Gutierrez Gabriel, Iurchuk Joaquín
 *
 */
public class EstadoMasacrality extends EstadoCelda {

	private final static int PUNTAJE=30;
	
	/**
	 * Constructor de un EstadoSpeedUp
	 * Se utiliza para modelar el estado de una celda que contiene una celda con Power Up Speed Up
	 * @param x posicion x dentro de la matriz de celdas 
	 * @param y posicion y dentro de la matriz de celdas
	 */
	public EstadoMasacrality() {
		super(new GraficoMasacrality());
		
	}

	@Override
	public int destruir(Celda celda) {
		return 0;
	}



	@Override
	public void avanzar(Bomberman bomberman, Celda celdaSiguiente, int dir) {
		System.out.println("AVANZAR BOMBERMAN DESDE ESTADO spped up");

		if (bomberman.getLock() == false) {
			
			SoundPlayer.powerUp();
			
			bomberman.lock();
			bomberman.getCelda().eliminarBomberman();
			bomberman.setCelda(celdaSiguiente);
			celdaSiguiente.agregarBomberman(bomberman);

			bomberman.activarModoMasacrality();
			
			bomberman.moverGrafica(dir);
			
			
			
			celdaSiguiente.getLabel().setIcon(null);
			celdaSiguiente.setEstado(new EstadoTransitable());
			
			celdaSiguiente.getMiTablero().getJuego().aumentarPuntaje(PUNTAJE);
			
			System.out.println("BOMBERMAN SE FUMO EL MASCARLAITY, BUENO ESO");
			
		} else
			System.out.println("Bomberman esta bloqueado");
	}
		
	@Override
	public void avanzar(Enemigo enemigo, Celda celdaSiguiente, int dir) {

		System.out.println("AVANZAR ENEMIGO DESDE ESTADO speed up");
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