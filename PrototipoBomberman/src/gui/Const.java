package gui;

import java.util.Date;

public class Const {

	public static final int MOVIMIENTO_ARRIBA    = 0;
	public static final int MOVIMIENTO_ABAJO     = 1;
	public static final int MOVIMIENTO_IZQUIERDA = 2;
	public static final int MOVIMIENTO_DERECHA   = 3;
	
	public static final int EMPTY_BORDER = 5;
	
	public static final int CANT_CELDAS_ANCHO = 31;
	public static final int CANT_CELDAS_ALTO = 13;	
	
	public static final int ANCHO_CELDA = 32;
	public static final int ALTO_CELDA = 32;
	
	public static final int ANCHO_GUI = ANCHO_CELDA * CANT_CELDAS_ANCHO;
	public static final int ALTO_GUI = ALTO_CELDA * CANT_CELDAS_ALTO;
	
	public static final int PORCENTAJE_DESTRUIBLES = 50;
	public static final int TIEMPO_DETONACION = 1000;
}