package gui;

/**
 * Clase encargada de llevar un control sobre el tiempo de juego.
 * Funciona como un wrapper para el tiempo.
 * @author Asencio Victor, Gutierrez Gabriel, Iurchuk Joaquín
 */

public class Tiempo {

	private long horaInicioEnMillis;
	
	/**
	 * Constructor de clase.
	 * Setea la variable de clase con la hora actual del sistema.
	 */
	public Tiempo() {
		this.horaInicioEnMillis = System.currentTimeMillis();
	}
	
	/**
	 * Método encargado de calcular el tiempo transcurrido de juego.
	 * @return Tiempo transcurrido de juego.
	 */
	public long tiempoTranscurrido (){
		return System.currentTimeMillis() - horaInicioEnMillis;
	}
	
}