package threads;

import java.awt.Point;

import personajes.Enemigo;

public class EnemigoThread extends Thread {

	private Enemigo mLogica;
	private volatile boolean mDetener; //Volatile: Tells the compiler that this variable can be changed unexpectedly by other parts of the program
	
	public EnemigoThread(Enemigo logica){
		this.mLogica = logica;
		this.mDetener = false;
	}
	
	@Override
	public void run() {
		while (mLogica.estoyVivo()){
			try{
				Thread.sleep(1000);
				mLogica.mover();
			}
			catch(InterruptedException e){
				//e.printStackTrace();
			}
		}
	}
	
	public void detener(){
		mLogica.getLabel().setIcon(null);
		this.mDetener = true;
		this.interrupt();
	}
	
	public Point getPosicionCelda(){
		Point p = new Point();
		p.x = mLogica.getCelda().getX();
		p.y = mLogica.getCelda().getY();
		
		return p;
	}
}
