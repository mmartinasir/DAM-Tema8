package ejercicio3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Ventana {

	protected static JFrame frame;
	protected static JLabel lblClick1;
	protected static JLabel lblClick2;
	protected static int clicks1 = 0;
	protected static int clicks2 = 0;
	protected static JButton btnBotn;


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
		
		JLabel lblElRatnSe = new JLabel("Clicks del botón 1:");
		lblElRatnSe.setBounds(17, 25, 114, 14);
		frame.getContentPane().add(lblElRatnSe);
		
		lblClick1 = new JLabel("0");
		lblClick1.setBounds(124, 25, 24, 14);
		frame.getContentPane().add(lblClick1);
		
		JLabel lblClicksDelBotn = new JLabel("Clicks del botón 2:");
		lblClicksDelBotn.setBounds(17, 44, 131, 14);
		frame.getContentPane().add(lblClicksDelBotn);
		
		lblClick2 = new JLabel("0");
		lblClick2.setBounds(124, 44, 46, 14);
		frame.getContentPane().add(lblClick2);
		
		btnBotn = new JButton("Botón");
		btnBotn.setBounds(17, 71, 95, 25);
		frame.getContentPane().add(btnBotn);
		
		//Listener del ejercicio 3
		frame.addMouseListener(new Apartado3a());
		frame.addMouseListener(new Apartado3b());
		btnBotn.addMouseMotionListener(new Apartado3c());
	}
}
