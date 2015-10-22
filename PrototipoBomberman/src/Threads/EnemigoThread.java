package Threads;

import Personajes.Enemigo;

public class EnemigoThread extends Thread {

	private Enemigo mLogica;
	private volatile boolean mDetener; //Volatile: Tells the compiler that this variable can be changed unexpectedly by other parts of the program
	
	public EnemigoThread(Enemigo logica){
		this.mLogica = logica;
		this.mDetener = false;
	}
	
	@Override
	public void run() {
		while (!this.mDetener){
			try{
				Thread.sleep(1000);
				mLogica.mover();
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	
	public void detener(){
		this.interrupt();
		
		this.mDetener = true;
	}
}
