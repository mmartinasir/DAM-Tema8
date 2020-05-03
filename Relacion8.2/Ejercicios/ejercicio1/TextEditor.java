package ejercicio1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Component;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class TextEditor {
	
	//Gets the name from FileName window
	protected static String fname = "";


	private JFrame frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TextEditor window = new TextEditor();
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
	public TextEditor() {
		initialize();
	}
	
	/*
	 * Variables
	 */

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setPreferredSize(new Dimension(10, 25));
		frame.getContentPane().add(panelMenu, BorderLayout.NORTH);
		panelMenu.setLayout(new GridLayout(0, 1, 0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelMenu.add(menuBar);
		
		JMenu mnMenuFile = new JMenu("File");
		menuBar.add(mnMenuFile);
		
		JMenuItem mntmNew = new JMenuItem("New");

		mnMenuFile.add(mntmNew);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mnMenuFile.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnMenuFile.add(mntmSave);
		
		JMenuItem mntmClose = new JMenuItem("Close");
		mnMenuFile.add(mntmClose);
		
		JMenu mnMenuEdit = new JMenu("Edit");
		menuBar.add(mnMenuEdit);
		
		JMenu mnFontSize = new JMenu("Font size");
		mnMenuEdit.add(mnFontSize);
		
		JMenuItem mntmBigger = new JMenuItem("Bigger");
		mnFontSize.add(mntmBigger);
		
		JMenuItem mntmSmaller = new JMenuItem("Smaller");
		mnFontSize.add(mntmSmaller);
		
		JMenu mnFontColor = new JMenu("Font color");
		mnMenuEdit.add(mnFontColor);
		
		JMenuItem mntmBlack = new JMenuItem("Black");
		mnFontColor.add(mntmBlack);
		
		JMenuItem mntmBlue = new JMenuItem("Blue");
		mnFontColor.add(mntmBlue);
		
		JMenuItem mntmRed = new JMenuItem("Red");
		mnFontColor.add(mntmRed);
		
		JMenu mnMenuHelp = new JMenu("Help");
		menuBar.add(mnMenuHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About TextEditor");
		mnMenuHelp.add(mntmAbout);
		
		JMenuItem mntmCredits = new JMenuItem("Credits");
		mnMenuHelp.add(mntmCredits);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 25));
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 198, 37, 0};
		gbl_panel.rowHeights = new int[]{14, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblName = new JLabel("No file open");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 0, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 0;
		panel.add(lblName, gbc_lblName);
		
		JTextArea textArea = new JTextArea();
		frame.getContentPane().add(textArea, BorderLayout.CENTER);
		
		/*
		 * Action Listeners
		 */
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File("textfile.txt");
				lblName.setText(file.getPath());
			}
		});
		
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileName fnOpen = new FileName();
				fnOpen.FileNameWindow();
				File file = new File(fname);
				lblName.setText(file.getPath());
			}
		});
	}

}
