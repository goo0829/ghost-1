package ghost_06_test;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(Ghost.game == null) {
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			Ghost.game.ghostCharacter.ispressUP = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			Ghost.game.ghostCharacter.ispressDOWN = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			Ghost.game.ghostCharacter.ispressLEFT = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Ghost.game.ghostCharacter.ispressRIGHT = true;
		}
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(Ghost.game == null) {
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			Ghost.game.ghostCharacter.ispressUP = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			Ghost.game.ghostCharacter.ispressDOWN = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			Ghost.game.ghostCharacter.ispressLEFT = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Ghost.game.ghostCharacter.ispressRIGHT = false;
		}
	}
	
}
