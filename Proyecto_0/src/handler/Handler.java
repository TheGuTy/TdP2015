package handler;

public class Handler {

	private GeneradorFrases gen;
	
	public Handler() {
		
		gen=new GeneradorFrases();		
	}
	
	public String getFrase() {
		
		return gen.getFrase();
	}
}
