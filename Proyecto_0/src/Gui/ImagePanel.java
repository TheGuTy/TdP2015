package Gui;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

	private ImageIcon imagen;
	String nombre;
	
	public ImagePanel(String nombre) {
		
		this.nombre=nombre;
	}
	
	public void paint(Graphics g) {
		
		Dimension size=getSize();
		imagen=new ImageIcon(getClass().getResource(nombre));
		g.drawImage(imagen.getImage(), 0, 0, size.width,size.height,null);
		setOpaque(false);
		super.paint(g);
		
	}
}
