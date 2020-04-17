package ejercicio1;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Apartado1b implements WindowListener {
	
	@Override
	public void windowIconified(WindowEvent e) {
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
		
		Ventana.btnBotonb.setBackground(bgColor);

	}


	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
