package ejercicio2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ventana {

	protected static JFrame frame;
	protected static JLabel lblEtiquetaa;
	protected static JLabel lblEtiquetab;
	protected static JLabel lblPulsaUnaVocal;

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
		
		lblEtiquetaa = new JLabel("Etiqueta 2a");
		lblEtiquetaa.setBounds(101, 31, 79, 14);
		frame.getContentPane().add(lblEtiquetaa);
		
		lblEtiquetab = new JLabel("Etiqueta 2b");
		lblEtiquetab.setBounds(101, 56, 73, 14);
		frame.getContentPane().add(lblEtiquetab);
		
		lblPulsaUnaVocal = new JLabel("Pulsa una vocal");
		lblPulsaUnaVocal.setBounds(101, 78, 90, 14);
		frame.getContentPane().add(lblPulsaUnaVocal);
		frame.setFocusable(true);
		
		//Añado los listener de los ejercicios
		frame.addKeyListener(new Apartado2a());
		frame.addKeyListener(new Apartado2b());
		frame.addKeyListener(new Apartado2c());
		frame.addKeyListener(new Apartado2d());
	}
}
