package ejercicio2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Apartado2d implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyChar() == '+') {
			Ventana.frame.setSize(Ventana.frame.getSize().width+5, Ventana.frame.getSize().height+5);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
