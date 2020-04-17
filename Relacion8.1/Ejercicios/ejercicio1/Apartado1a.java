package ejercicio1;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Apartado1a implements WindowListener {
	
	@Override
	public void windowActivated(WindowEvent e) {
		int num1 = (int)(Math.random()*5)+1;
		Color bgColor = Ventana.frame.getBackground();
		switch (num1) {
		case 1:
			bgColor = Color.red;
			break;
		case 2:
			bgColor = Color.blue;
			break;
		case 3:
			bgColor = Color.green;
			break;
		case 4:
			bgColor = Color.yellow;
			break;
		case 5:
			bgColor = Color.orange;
			break;
		}
		
		Ventana.frame.getContentPane().setBackground(bgColor);
	}


	@Override
	public void windowOpened(WindowEvent e) {		
	}

	@Override
	public void windowClosing(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

}
