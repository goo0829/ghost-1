package new_ghost_01;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
	
	private boolean isUP = false;
	private boolean isDOWN = false;
	private boolean isLEFT = false;
	private boolean isRIGHT = false;
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			setUP(true);
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			setDOWN(true);
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			setLEFT(true);
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			setRIGHT(true);
		}
	}
	
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			setUP(false);
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			setDOWN(false);
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			setLEFT(false);
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			setRIGHT(false);
		}
	}

	public boolean isUP() {
		return isUP;
	}

	public void setUP(boolean isUP) {
		this.isUP = isUP;
	}

	public boolean isDOWN() {
		return isDOWN;
	}

	public void setDOWN(boolean isDOWN) {
		this.isDOWN = isDOWN;
	}

	public boolean isLEFT() {
		return isLEFT;
	}

	public void setLEFT(boolean isLEFT) {
		this.isLEFT = isLEFT;
	}

	public boolean isRIGHT() {
		return isRIGHT;
	}

	public void setRIGHT(boolean isRIGHT) {
		this.isRIGHT = isRIGHT;
	}
}
