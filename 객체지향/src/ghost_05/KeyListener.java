package ghost_05;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(Ghost.game == null) {
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			Ghost.game.ghostCharacter.pressUP();
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			Ghost.game.ghostCharacter.pressDOWN();
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			Ghost.game.ghostCharacter.pressLEFT();
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Ghost.game.ghostCharacter.pressRIGHT();
		}
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(Ghost.game == null) {
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			Ghost.game.ghostCharacter.releaseUP();
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			Ghost.game.ghostCharacter.releaseDOWN();
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			Ghost.game.ghostCharacter.releaseLEFT();
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Ghost.game.ghostCharacter.releaseRIGHT();
		}
	}
	
}
