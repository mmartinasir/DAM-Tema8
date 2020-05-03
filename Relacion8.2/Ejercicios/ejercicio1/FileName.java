package ejercicio1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FileName {

	protected static JFrame frame;
	private JTextField txtFileName;

	/**
	 * Launch the application.
	 */
	public static void FileNameWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileName window = new FileName();
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
	public FileName() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 378, 74);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblFileName = new JLabel("File name:");
		frame.getContentPane().add(lblFileName);
		
		txtFileName = new JTextField();
		frame.getContentPane().add(txtFileName);
		txtFileName.setColumns(10);
		
		JButton btnEnter = new JButton("Enter");

		frame.getContentPane().add(btnEnter);
		
		/*
		 * Action Listeners
		 */
		
		//Sends the text entered to the main window
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextEditor.fname = txtFileName.getText();
				frame.dispose();
			}
		});
	}

}
