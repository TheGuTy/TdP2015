package handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneradorImagen {

	private List<String> images;
	
	public GeneradorImagen() {
		
		images=new ArrayList<String>();
		images.add("/imagen/Simpsons1.jpg");
		images.add("/imagen/Simpsons2.jpg");
		images.add("/imagen/Simpsons3.jpg");
		images.add("/imagen/Simpsons4.jpg");
	}
	
	public String getImagen() {
		
		Random rnd=new Random();
		return images.get(rnd.nextInt(images.size()));
	}
}
