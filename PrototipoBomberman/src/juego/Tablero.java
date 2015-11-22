package juego;

import java.util.Random;

import gui.Const;
import gui.GUI;
import juego.estadosCelda.EstadoBomba;
import juego.estadosCelda.EstadoDestruible;
import juego.estadosCelda.EstadoNoDestruible;
import juego.estadosCelda.EstadoTransitable;

/**
 * Clase que se encarga de modelar el tablero de juego, con todos sus atributos
 * @author Asencio Victor, Gutierrez Gabriel, Iurchuk Joaquín
 *
 */
public class Tablero {

	protected Juego miJuego;
	protected Celda [][] misCeldas;	
	protected GUI gui;
	
	/**
	 * Constructor que inicializa un tablero de juego
	 * @param juego referencia al juego principal
	 * @param gui referencia a la clase que maneja la interfaz grafica
	 */
	public Tablero (Juego juego, GUI gui) {
		miJuego = juego;
		
		misCeldas = new Celda[Const.CANT_CELDAS_ANCHO][Const.CANT_CELDAS_ALTO];
		this.gui = gui;
		
		for (int i = 0; i < Const.CANT_CELDAS_ANCHO; i++) {
			for (int j = 0; j < Const.CANT_CELDAS_ALTO	; j++) {
				misCeldas[i][j] = new Celda(i, j, this);				
				misCeldas[i][j].setEstado(new EstadoTransitable());	//Al crear todas las celdas asumo que todas son transitables				
			}
		}
				
		distribuirDestruibles();
		
		crearNoDestruibles();
		
		//luego de setear todos los estados a la celda, agrego el JLabel de cada celda a la gui
		for (int i = 0; i < Const.CANT_CELDAS_ANCHO; i++)
			for (int j = 0; j < Const.CANT_CELDAS_ALTO; j++){			 
				gui.add(misCeldas[i][j].getLabel());		
			}
		
		misCeldas[1][1].setEstado(new EstadoTransitable());
		misCeldas[1][2].setEstado(new EstadoTransitable());
		misCeldas[2][1].setEstado(new EstadoTransitable());
	}
	
	/**
	 * Devuelve la celda que está ubicada en las coordenadas recibidas 
	 * @param x coordenada x de la celda a devolver
	 * @param y coordenada y de la celda a devolver
	 * @return la celda que está ubicada en las coordenadas recibidas
	 */
	public Celda getCelda (int x, int y) {
		return misCeldas[x][y];
	}
	
	/**
	 * Se encarga de recorrer la matriz de celdas y configurarles en ellas el estado no destruible segun corresponda
	 */
	private void crearNoDestruibles () {
		
		for(int i=0 ; i<Const.CANT_CELDAS_ANCHO;i++){
			for(int j=0 ; j<Const.CANT_CELDAS_ALTO;j++){
				if(i==0) misCeldas[i][j].setEstado(new EstadoNoDestruible(i, j));
				if(j==0) misCeldas[i][j].setEstado(new EstadoNoDestruible(i, j));
				if(i==Const.CANT_CELDAS_ANCHO-1) misCeldas[i][j].setEstado(new EstadoNoDestruible(i, j));
				if(j==Const.CANT_CELDAS_ALTO-2) misCeldas[i][j].setEstado(new EstadoNoDestruible(i, j));
				if((i%2==0)&&(j%2==0)) misCeldas[i][j].setEstado(new EstadoNoDestruible(i, j));
			}
		}
	}
	
	/**
	 * Se encarga de recorrer la matriz de celdas y configurarles en ellas el estado destruible segun corresponda
	 */
	private void distribuirDestruibles () {
		
		Random rnd = new Random();
		for(int i=0; i<(Const.CANT_CELDAS_ANCHO * Const.CANT_CELDAS_ALTO) * Const.PORCENTAJE_DESTRUIBLES ; i++){
			misCeldas[rnd.nextInt(Const.CANT_CELDAS_ANCHO)][rnd.nextInt(Const.CANT_CELDAS_ALTO)].setEstado(new EstadoDestruible());
		}
	}
	
	/**
	 * Recibe un entero que determina cuánto puntaje se debe sumar
	 * @param p puntaje que se debe sumar
	 */
	public void aumentarPuntaje (int p) {
		
		miJuego.aumentarPuntaje(p);
	}	

	/**
	 * Devuelve una referencia al juego principal
	 * @return referencia al juego principal
	 */
	public Juego getJuego() {
		return miJuego;
	}

	/**
	 * Metodo llamado al finalizar una explosion por la bomba.
	 * Le devuelve la posibilidad de colocar una bomba mas a bomberman
	 */
	public void devolverBombaABomberman() {
		miJuego.getBomberman().aumentarBombasDisponibles();
	}

	/**
	 * Método invocado por un personaje para colocar una Bomba en el tablero
	 * @param x coordenada x de la celda donde debe ser colocada la bomba
	 * @param y coordenada x de la celda donde debe ser colocada la bomba
	 * @param alcance alcance de la bomba que sera colocada en esta celda
	 */
	public void colocarBomba (int x, int y, int alcance) {
		System.out.println("poner bomba en " + x + " " + y);
		
		Celda celda = getCelda(x, y);
		Bomba bomba = new Bomba(celda, alcance, this);
		celda.setEstado(new EstadoBomba());		
		
		bomba.comenzarDetonacion();
	
	}

//	/**
//	 * Metodo que recibe una celda que acaba de ser explotada y se encarga de setearle su nuevo estado
//	 * @param celda celda que acaba de ser explotada y se encarga de setearle su nuevo estado
//	 */
//	public void restaurarCelda(Celda celda) {
//		
//		int x = celda.getX();
//		int y = celda.getY();
//		gui.repaint();
//		gui.add(misCeldas[x][y].getEstado().getGrafico().getLabel());
//	}
	
	//TODO Comprobar este metodo
	//Si no se agrega el JLabel del nuevo estado a la GUI entonces la proxima explosion de esa bomba no afecta a la celda
//	public void agregarEnGUI(JLabel panel){
//		gui.add(panel);
//	}
}