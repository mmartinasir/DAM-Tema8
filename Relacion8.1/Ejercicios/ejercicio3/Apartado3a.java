package ejercicio3;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Apartado3a implements MouseListener {
	
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == e.BUTTON1) {
			Ventana.clicks1 = Ventana.clicks1 + 1;
			Ventana.lblClick1.setText(""+Ventana.clicks1);
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
