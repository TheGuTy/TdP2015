package Juego;

public class Tiempo extends Thread {

	protected Juego miJuego;	
	
	public Tiempo (Juego j) {
		
		miJuego = j;
	}
	
	public void comenzar () {
		
	}
	
	public void detener () {
		
	}
	
	public long tiempoTranscurrido () {
		
		return 0;
	}
	
	public void run () {
		
		while (true) {
			try {
				Thread.sleep(1000);
				miJuego.moverEnemigos();				

			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
	}
}
