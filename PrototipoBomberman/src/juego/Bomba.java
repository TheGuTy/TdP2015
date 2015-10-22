package juego;

public class Bomba{

	protected int alcance;
	protected Tablero miTablero;
	protected Celda miCelda;
	
	public Bomba (Celda c, int alcance, Tablero t) {
		miCelda = c;
		this.alcance = alcance;
		miTablero = t;
	}
	
	public void comenzarDetonacion () {
		new java.util.Timer().schedule( 
		        new java.util.TimerTask() {
		            @Override
		            public void run() {
		                System.out.println("Explotó la bomba");
		            }
		        },
		        5000
		);
	}
}
