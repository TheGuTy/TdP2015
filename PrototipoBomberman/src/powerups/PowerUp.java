package powerups;

import personajes.Bomberman;

public abstract class PowerUp {

	protected int puntaje;
	
	protected PowerUp (int p) {
		
	}
	
	public abstract void upgrade (Bomberman b);
	
	public int getPuntaje () {
		
		return puntaje;
	}
}
