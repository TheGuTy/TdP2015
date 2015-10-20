package Gui;

import Juego.Juego;

public class Tiempo extends Thread {

	private long horaInicioEnMillis;

	public Tiempo() {
		this.horaInicioEnMillis = System.currentTimeMillis();
	}
	
	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public long getHoraInicioEnMillis() {
		return horaInicioEnMillis;
	}
	
	public long tiempoTranscurrido (){
		return System.currentTimeMillis() - horaInicioEnMillis;
	}
}