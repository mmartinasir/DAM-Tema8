package ejercicio1;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class TextEditor {
	
	/*
	 * Variables
	 */
	//Variable that saves the text for printing
	String textToArea = "";
	
	//Variable File ready for use
	File file;
	
	//Variable that checks if the user wants to save its work
	protected static boolean yesOrNo;


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
		
		//Creates a new file
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfNew = new JFileChooser();
				jfNew.setCurrentDirectory(new java.io.File("."));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Only .txt files", "txt");
				jfNew.setFileFilter(filter);
				jfNew.setDialogTitle("Create new text file");
				if (jfNew.showSaveDialog(mntmOpen) == JFileChooser.APPROVE_OPTION) {
					if (!jfNew.getSelectedFile().toString().endsWith(".txt")) {
						file = new File(jfNew.getSelectedFile().getAbsolutePath()+".txt");
					} else {
						file = new File(jfNew.getSelectedFile().getAbsolutePath());
					}
					lblName.setText(file.getAbsolutePath());
					textArea.setText("");
				}
			}
		});
		
		//Opens an existing file
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textToArea = "";
				JFileChooser jfOpen = new JFileChooser();
				jfOpen.setCurrentDirectory(new java.io.File("."));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Only .txt files", "txt");
				jfOpen.setFileFilter(filter);
				if (jfOpen.showOpenDialog(mntmOpen) == JFileChooser.APPROVE_OPTION && jfOpen.getSelectedFile().exists()) {
					file = new File(jfOpen.getSelectedFile().getAbsolutePath());
					lblName.setText(file.getAbsolutePath());
					//Writes the file's text on the application window
					try {
						Scanner input = new Scanner(file);
						while (input.hasNext()) {
							textToArea = textToArea+input.nextLine()+"\n";
						}
						textArea.setText(textToArea);
						input.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					textArea.setText("");
					lblName.setText("No file open");
				}
				
			}
		});
		
		//Saves the text
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textToArea = "";
				file = new File(lblName.getText());
				//Checks if there's a file open
				if (file.exists() || lblName.getText() != "No file open") {
					try {
						Scanner input = new Scanner(textArea.getText());
						while (input.hasNext()) {
							textToArea = textToArea+input.nextLine()+"\n";
						}
						input.close();
						PrintWriter output = new PrintWriter(file);
						output.print(textToArea);
						output.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					//If it doesn't exist, creates a new file
					JFileChooser jfSaveNew = new JFileChooser();
					jfSaveNew.setCurrentDirectory(new java.io.File("."));
					FileNameExtensionFilter filter = new FileNameExtensionFilter("Only .txt files", "txt");
					jfSaveNew.setFileFilter(filter);
					jfSaveNew.setDialogTitle("Create new text file");
					jfSaveNew.setDialogType(JFileChooser.SAVE_DIALOG);
					if (jfSaveNew.showSaveDialog(mntmOpen) == JFileChooser.APPROVE_OPTION) {
						if (!jfSaveNew.getSelectedFile().toString().endsWith(".txt")) {
							file = new File(jfSaveNew.getSelectedFile().getAbsolutePath()+".txt");
						} else {
							file = new File(jfSaveNew.getSelectedFile().getAbsolutePath());
						}
						lblName.setText(file.getAbsolutePath());
						try {
							Scanner input = new Scanner(textArea.getText());
							while (input.hasNext()) {
								textToArea = textToArea+input.nextLine()+"\n";
							}
							input.close();
							PrintWriter output = new PrintWriter(file);
							output.print(textToArea);
							output.close();
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}

				}
			}
		});
		
		//Closes the app
		mntmClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmSave = JOptionPane.showConfirmDialog(null, "Do you want to save your work?");
				//0 == Yes. 1 == No. 2 == Cancel
				if (confirmSave == 0) {
					textToArea = "";
					file = new File(lblName.getText());
					//Checks if there's a file open
					if (file.exists() || lblName.getText() != "No file open") {
						try {
							Scanner input = new Scanner(textArea.getText());
							while (input.hasNext()) {
								textToArea = textToArea+input.nextLine()+"\n";
							}
							input.close();
							PrintWriter output = new PrintWriter(file);
							output.print(textToArea);
							output.close();
							System.exit(0);
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else {
						//If it doesn't exist, creates a new file
						JFileChooser jfSaveNew = new JFileChooser();
						jfSaveNew.setCurrentDirectory(new java.io.File("."));
						FileNameExtensionFilter filter = new FileNameExtensionFilter("Only .txt files", "txt");
						jfSaveNew.setFileFilter(filter);
						jfSaveNew.setDialogTitle("Create new text file");
						jfSaveNew.setDialogType(JFileChooser.SAVE_DIALOG);
						if (jfSaveNew.showSaveDialog(mntmOpen) == JFileChooser.APPROVE_OPTION) {
							if (!jfSaveNew.getSelectedFile().toString().endsWith(".txt")) {
								file = new File(jfSaveNew.getSelectedFile().getAbsolutePath()+".txt");
							} else {
								file = new File(jfSaveNew.getSelectedFile().getAbsolutePath());
							}
							lblName.setText(file.getAbsolutePath());
							try {
								Scanner input = new Scanner(textArea.getText());
								while (input.hasNext()) {
									textToArea = textToArea+input.nextLine()+"\n";
								}
								input.close();
								PrintWriter output = new PrintWriter(file);
								output.print(textToArea);
								output.close();
								System.exit(0);
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

						}

					}

				} else {
					if (confirmSave == 1) {
						System.exit(0);
					}
				}
			}
		});
		
		//Bigger font
		mntmBigger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setFont(new Font(textArea.getFont().getFontName(), textArea.getFont().getStyle(), textArea.getFont().getSize()+3));
			}
		});
		
		//Smaller font
		mntmSmaller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setFont(new Font(textArea.getFont().getFontName(), textArea.getFont().getStyle(), textArea.getFont().getSize()-3));
			}
		});
		
		//Color black
		mntmBlack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setForeground(Color.BLACK);
				
			}
		});
		
		//Color blue
		mntmBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setForeground(Color.BLUE);
			}
		});
		
		//Color red
		mntmRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setForeground(Color.RED);
			}
		});
		
		//About text editor window
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String aboutMessage = "";
				aboutMessage = aboutMessage+"TextEditor is a simple text application for editing txt files."+"\n";
				Object[] options = {"Ok"};
				int aboutPane = new JOptionPane().showOptionDialog(null, aboutMessage, "About TextEditor", JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				
				
			}
		});
		
		//About the creator
		mntmCredits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String creditsMessage = "";
				creditsMessage = creditsMessage+"TextEditor version 1.0"+"\n";
				creditsMessage = creditsMessage+"Created by Manuel Martin Gimeno"+"\n";
				creditsMessage = creditsMessage+"With the help of professor Mariano Delgado"+"\n";
				Object[] options = {"Ok"};
				int aboutPane = new JOptionPane().showOptionDialog(null, creditsMessage, "About TextEditor", JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				
				
			}
		});


	}

}
