package new_ghost_02;

import java.awt.event.KeyEvent;

public class KeyListener {
	private boolean isUP = false;
	private boolean isDOWN = false;
	private boolean isLEFT = false;
	private boolean isRIGHT = false;
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			isUP = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			isDOWN = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			isLEFT = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			isRIGHT = true;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			isUP = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			isDOWN = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			isLEFT = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			isRIGHT = false;
		}
	}
}
