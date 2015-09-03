package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

import handler.Handler;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class maingui {

	
	private Handler handler;
	private JFrame frmFrasesDeHomero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					maingui window = new maingui();
					window.frmFrasesDeHomero.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public maingui() {
		handler=new Handler();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFrasesDeHomero = new JFrame();
		frmFrasesDeHomero.setTitle("Frases de Homero - Proyecto 0 -  TDP");
		frmFrasesDeHomero.setResizable(false);
		frmFrasesDeHomero.setBounds(100, 100, 536, 338);
		frmFrasesDeHomero.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFrasesDeHomero.getContentPane().setLayout(null);
		
		ImagePanel panel = new ImagePanel(handler.getImagen());
		
		panel.setBounds(10, 11, 263, 212);
		frmFrasesDeHomero.getContentPane().add(panel);
		
		JLabel lblPresionarBoton = new JLabel("");
		lblPresionarBoton.setHorizontalAlignment(SwingConstants.LEFT);
		lblPresionarBoton.setVerticalAlignment(SwingConstants.TOP);
		lblPresionarBoton.setBounds(295, 11, 223, 212);
		frmFrasesDeHomero.getContentPane().add(lblPresionarBoton);		
		
		JButton btnNewButton = new JButton("Presione Aqui");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblPresionarBoton.setText(handler.getFrase());
				panel.actualizarImagen(handler.getImagen());
			}
		});
		btnNewButton.setBounds(206, 251, 122, 28);
		frmFrasesDeHomero.getContentPane().add(btnNewButton);
		
		
	}
}
