package threads;

import java.awt.Point;

import personajes.Enemigo;

public class EnemigoThread extends Thread {

	private Enemigo mLogica;
	public EnemigoThread(Enemigo logica){
		this.mLogica = logica;
	}
	
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
	
	public void detener(){
		mLogica.getLabel().setIcon(null);	
	}
	
	public Point getPosicionCelda(){
		Point pos = new Point();
		pos.x = mLogica.getCelda().getX();
		pos.y = mLogica.getCelda().getY();
		
		return pos;
	}
}
