package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

import handler.Handler;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class maingui {

	
	private Handler handler;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					maingui window = new maingui();
					window.frame.setVisible(true);
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
		initialize();
		handler=new Handler();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new ImagePanel("/imagen/Simpson.jpg");
		
		
		panel.setBounds(22, 11, 225, 251);
		frame.getContentPane().add(panel);
		
		JLabel lblPresionarBoton = new JLabel("");
		lblPresionarBoton.setBounds(257, 22, 175, 81);
		frame.getContentPane().add(lblPresionarBoton);		
		
		JButton btnNewButton = new JButton("Presione Aqui");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblPresionarBoton.setText(handler.getFrase());
			}
		});
		btnNewButton.setBounds(286, 173, 122, 59);
		frame.getContentPane().add(btnNewButton);
		
		
	}
}
