package Graficos;

import java.awt.Color;
import java.awt.Point;

import javax.swing.Icon;
import javax.swing.JLabel;

import Juego.Celda;

public abstract class GraficoPersonaje {
	protected JLabel grafico;
	protected Icon imagenes[];
	protected final int ancho = 32;
	protected final int alto = 32;
	
	protected int velocidad;
	
	protected Point pos;
	
	protected GraficoPersonaje(int velocidad, int x, int y) {
		this.pos = new Point(x * this.ancho, y * this.alto);
		this.velocidad = velocidad;
		
		this.imagenes = new Icon[4];
	}
	
	public int getVelocidad() {
		return velocidad;
	}

	public Point getPos() {
		return pos;
	}
	
	public void changeIcon(int dir){
				
		this.grafico.setIcon(this.imagenes[dir]);		
	}
	
	public void mover(int dir){
		if(this.grafico != null){
			this.changeIcon(dir);
			
			try {
				switch (dir){
					case 0 : // Arriba
						for(int i = 0; i < this.alto; i += this.velocidad){
							this.grafico.setBounds(this.pos.x, this.pos.y -= this.velocidad, ancho, alto);
//							Thread.sleep(100);
						}
						break;
					case 1 : // Abajo
						for(int i = 0; i < this.alto; i += this.velocidad){
							this.grafico.setBounds(this.pos.x, this.pos.y += this.velocidad, ancho, alto);
//							Thread.sleep(100);
						}
						break;
					case 3 : // Derecha
						for(int i = 0; i < this.ancho; i += this.velocidad){
							this.grafico.setBounds(this.pos.x += this.velocidad, this.pos.y, ancho, alto);
//							Thread.sleep(100);
						}
						break;
					case 2 : // Izquierda
						for(int i = 0; i < this.ancho; i += this.velocidad){
							this.grafico.setBounds(this.pos.x -= this.velocidad, this.pos.y, ancho, alto);
//							Thread.sleep(100);
						}
						break;
				}
			} catch (Exception e) {				
				e.printStackTrace();
			}
		}
	}
	
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(imagenes[0]);
			this.grafico.setBounds(this.pos.x, this.pos.y, ancho, alto);
		}		
		return this.grafico;
	}
}
