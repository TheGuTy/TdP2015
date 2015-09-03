package handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneradorImagen {

	private int position;
	private List<String> images;
	
	public GeneradorImagen() {
		
		position=0;
		images=new ArrayList<String>();
		images.add("/imagen/Simpsons1.jpg");
		images.add("/imagen/Simpsons2.jpg");
		images.add("/imagen/Simpsons3.jpg");
		images.add("/imagen/Simpsons4.jpg");
	}
	
	public String getImagen() {
		
		return images.get((position++)%images.size());
	}
}
