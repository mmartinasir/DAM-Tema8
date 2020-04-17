package ejercicio2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Apartado2b implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		Ventana.lblEtiquetab.setText(""+e.getKeyCode());

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
