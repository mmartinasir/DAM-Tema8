package ejercicio1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

public class Ventana {

	protected static JFrame frame;
	protected static JButton btnBotonb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
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
	public Ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnBotonb = new JButton("Boton 1b");
		btnBotonb.setBounds(90, 57, 89, 23);
		frame.getContentPane().add(btnBotonb);
		
		//Poniendo los listener de los ejercicios
		frame.addWindowListener(new Apartado1a());
		frame.addWindowListener(new Apartado1b());
		frame.addWindowListener(new Apartado1c());
		frame.addWindowListener(new Apartado1d());
	}
}
