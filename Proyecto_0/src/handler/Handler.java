package handler;

public class Handler {

	private GeneradorFrases gen;
	private GeneradorImagen genImg;
	
	public Handler() {
		
		gen=new GeneradorFrases();
		genImg = new GeneradorImagen();
	}
	
	public String getFrase() {
		return gen.getFrase();
	}
	
	public String getImagen(){
		return genImg.getImagen();
	}
}