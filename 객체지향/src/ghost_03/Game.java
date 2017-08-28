package ghost_03;

import java.awt.Graphics2D;

public class Game extends Thread{
	
	public GhostCharacter ghostCharacter;
	
	private Music gameMusic;
	
	public Game() {
		gameMusic = new Music("gamePlayMusic.mp3", true);
		gameMusic.start();
		ghostCharacter = new GhostCharacter(100 , 100);
		ghostCharacter.start();
	}
	
	public void screenDraw(Graphics2D g) {
		g.drawImage(ghostCharacter.getGhostBasicImage(), ghostCharacter.x, ghostCharacter.y, null);
	}
	
	
	
}
