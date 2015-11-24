package gui;

/**
 * Clase encargada de llevar un control sobre el tiempo de juego.
 * Funciona como un wrapper para el tiempo.
 * @author Asencio Victor, Gutierrez Gabriel, Iurchuk Joaquín
 */

public class Tiempo implements Runnable {

//	private long horaInicioEnMillis;
	private int segundos;
	private Thread t;
	private GUI gui;
	
	/**
	 * Constructor de clase.
	 * Setea la variable de clase con la hora actual del sistema.
	 */
	public Tiempo(GUI gui) {
//		this.horaInicioEnMillis = System.currentTimeMillis();
		segundos=0;
		this.gui = gui;
	}
	
//	/**
//	 * Método encargado de calcular el tiempo transcurrido de juego.
//	 * @return Tiempo transcurrido de juego.
//	 */
//	public long tiempoTranscurrido (){
//		return System.currentTimeMillis() - horaInicioEnMillis;
//	}

	public void iniciar(){
		t = new Thread(this);
		t.start();
	}
	
	@Override
	public void run() {
		try {
			
			while(true){
			t.sleep(1000);
			segundos++;
			gui.actualizarTiempo(segundos);
			}
			
		} catch (InterruptedException e) { e.printStackTrace(); }
		
		
	}
	
}