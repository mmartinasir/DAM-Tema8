package ejercicio3;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Apartado3c implements MouseMotionListener {

	@Override
	public void mouseDragged(MouseEvent e) {
		Ventana.btnBotn.setLocation(e.getPoint().x+Ventana.btnBotn.getX(), e.getPoint().y+Ventana.btnBotn.getY());		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
