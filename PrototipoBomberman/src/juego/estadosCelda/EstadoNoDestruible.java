package juego.estadosCelda;

import graficos.GraficoParedNoDestruible;
import juego.Celda;
import personajes.Bomberman;
import personajes.Enemigo;

public class EstadoNoDestruible extends EstadoCelda {

	public EstadoNoDestruible(int x, int y) {
		super(new GraficoParedNoDestruible(x, y));
	}

	@Override
	public void destruir(Celda c) {
		//No hacer nada
	}

	@Override
	public void avanzar(Bomberman bomberman, Celda celdaSiguiente, int dir) {
		//No hacer nada
	}

	@Override
	public void avanzar(Enemigo enemigo, Celda celdaSiguiente, int dir) {
		//No hacer nada
	}
}