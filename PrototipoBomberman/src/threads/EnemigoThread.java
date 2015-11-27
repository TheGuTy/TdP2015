package threads;

import java.awt.Point;

import personajes.Enemigo;

/**
 * Clase encargada de generar los movimientos y el ciclo de vida de un Enemigo.
 * Funciona como un wrapper para un Enemigo.
 * @author Asencio Victor, Gutierrez Gabriel, Iurchuk Joaquín
 *
 */
public class EnemigoThread extends Thread {

	private Enemigo mLogica;
	
	/**
	 * Constructor de clase.
	 * Recibe un Enemigo logica y lo setea como variable 
	 * @param logica Objeto que contendra tanto los datos logicos como graficos relacionados a este thread, para permitir ser dibujado
	 */
	public EnemigoThread(Enemigo logica){
		this.mLogica = logica;
	}
	
	/**
	 *  Encargado de calcular el movimiento siguiente y moverlo hacia esa direccion
	 */
	@Override
	public void run() {
		while (mLogica.estoyVivo()){
			try{
				Thread.sleep(1000);
				mLogica.mover();
			}
			catch(InterruptedException e){}
		}
	}
	
	
	
	/**
	 * Cuando es invocado detiene por completo la ejecucion de este thread.
	 */
	public void detener(){
		mLogica.matar();
		interrupt();
	}
	
	/**
	 * Devuelve la posicion de la celda dentro de la matriz donde esta parado este Enemigo
	 * @return Un punto que contiene las coordenadas enteras x, y que corresponden a la posicion en la matriz de este Enemigo 
	 */
	public Point getPosicionCelda(){
		Point pos = new Point();
		pos.x = mLogica.getCelda().getX();
		pos.y = mLogica.getCelda().getY();
		
		return pos;
	}
}
