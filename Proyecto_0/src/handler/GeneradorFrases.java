package handler;

import java.util.ArrayList;
import java.util.List;

public class GeneradorFrases {

	private List<String> frases;
	private int position;
	
	public GeneradorFrases() {
		
		position=0;
		frases=new ArrayList<String>();
		frases.add("<html>¿Qué sentido tiene salir afuera?<br>Si vamos a volver aquí de todas maneras</html>");
		frases.add("<html>He aprendido que la vida<br>no es más que una devastadora <br> derrota tras otra,<br>hasta que simplemente deseas<br>que Flanders muera</html>");
		frases.add("<html>Durante toda mi vida<br>he tenido un solo sueño:<br>alcanzar todas mis metas</html>");
		frases.add("<html>Chicos, lo intentaron<br>con la mejor de sus intenciones<br>y fracasaron.<br>La lección es:<br>Nunca lo intenten</html>");
		frases.add("<html>No soy de los que rezan<br>oraciones regularmente,<br>pero si estás ahí,<br>por favor ayúdame Superman</html>");
		frases.add("<html>Los hechos no significan nada.<br>Puedes usar los hechos<br>para probar cualquier<br>cosa que no sea<br>ni remotamente cierta</html>");
		frases.add("<html>¡Oh dios mío,<br>aliens del espacio!<br>Por favor no me coman,<br>tengo esposa e hijos.<br>¡Comanlos a ellos!</html>");
		frases.add("<html>Lisa, si no te gusta<br>tu trabajo no haces huelga.<br>Simplemente vas cada día<br>y lo haces de muy mala gana.<br>Así se hace en América</html>");
		frases.add("<html>Hijo, si realmente<br>deseas algo en esta vida,<br>tienes que luchar por ello.<br>¡Ahora silencio! Van a anunciar<br>los números ganadores<br>de la lotería</html>");
	}
	
	public String getFrase() {
		
		return frases.get((position++)%frases.size());
	}
}
