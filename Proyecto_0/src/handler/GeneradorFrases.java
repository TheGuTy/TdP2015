package handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneradorFrases {

	private List<String> frases;
	
	public GeneradorFrases() {
		
		frases=new ArrayList<String>();
		frases.add("a");
		frases.add("b");
		frases.add("c");
		frases.add("d");
		frases.add("e");
		frases.add("f");
		frases.add("g");
	}
	
	public String getFrase() {
		
		Random rnd=new Random();
		return frases.get(rnd.nextInt(frases.size()));
	}
}
