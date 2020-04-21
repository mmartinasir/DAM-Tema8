package ejercicio3;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Apartado3b implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == e.BUTTON3) {
			Ventana.clicks2 = Ventana.clicks2 + 1;
			Ventana.lblClick2.setText(""+Ventana.clicks2);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
