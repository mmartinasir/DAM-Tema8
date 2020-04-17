package ejercicio2;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Apartado2c implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		char k = e.getKeyChar();
		int red = (int)(Math.random()*255);
		int blue = (int)(Math.random()*255);
		int green = (int)(Math.random()*255);
		Color bgColor = new Color(red, green, blue);
		k = Character.toLowerCase(k);
		switch (k) {
		case 'a':
			Ventana.lblPulsaUnaVocal.setForeground(bgColor);
			break;
		case 'e':
			Ventana.lblPulsaUnaVocal.setForeground(bgColor);
			break;
		case 'i':
			Ventana.lblPulsaUnaVocal.setForeground(bgColor);
			break;
		case 'o':
			Ventana.lblPulsaUnaVocal.setForeground(bgColor);
			break;
		case 'u':
			Ventana.lblPulsaUnaVocal.setForeground(bgColor);
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
