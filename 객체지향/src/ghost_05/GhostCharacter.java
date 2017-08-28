package ghost_05;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;

public class GhostCharacter extends Thread{
	public static final int SPEED = 20;
	public static final int SLEEP_TIME = 10;
	
	public int x, y;
	
	private Image ghostBasicImage = new ImageIcon(Main.class.getResource("../images/testGhostCharacter.png")).getImage();
	private Image ghostBackImage = new ImageIcon(Main.class.getResource("../images/testGhostBack.png")).getImage();
	
	
	private boolean stop = false;
	
	public Rectangle2D ghostR;
	
	public GhostCharacter(int x, int y) {
		this.x = x;
		this.y = y;
		ghostR = new Rectangle2D.Double(x , y , 50, 50);
	}	
	
	public void run() {
		try{
			while(true){
				if(stop) break;
				Thread.sleep(SLEEP_TIME);
			}
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void screenDraw(Graphics2D g) {
		g.drawImage(ghostBasicImage, x, y, null);
		//g.drawImage(ghostBackImage, x - 1255, y - 695, null);
		
	}
	
	public void ghostCharacterStop() {
		stop = true;
	}
	
	public void pressUP() {
		boolean upGo = true;
		for(int i = 0; i < Ghost.game.monsterList.size(); i++) {
			if(Math.abs(x - Ghost.game.monsterList.get(i).x) < 50)
			if((y - Ghost.game.monsterList.get(i).y) > 0 && Math.abs(y - Ghost.game.monsterList.get(i).y) < 50 ) {
				upGo = false;
			}
		}
		if(y > 0 && upGo) { 
			y -= SPEED;
			ghostR.setRect(x , y , 50, 50);
		}
//		stop = false;
//		while(y > 0 && !stop){
//			try{
//					y -= 5;
//					Thread.sleep(SLEEP_TIME);
//				}
//			catch(Exception e) {
//				System.err.println(e.getMessage());
//			}
//		}
	}
	
	public void releaseUP() {
		stop = true;
	}
	
	public void pressDOWN() {
		boolean downGo = true;
		for(int i = 0; i < Ghost.game.monsterList.size(); i++) {
			if(Math.abs(x - Ghost.game.monsterList.get(i).x) < 50)
			if((y - Ghost.game.monsterList.get(i).y) < 0 && Math.abs(y - Ghost.game.monsterList.get(i).y) < 50 ) {
				downGo = false;
			}
		}
		if(y < 720 && downGo){
			y += SPEED;
			ghostR.setRect(x , y , 50, 50);
		}
	}
	
	public void releaseDOWN() {
		
	}
	
	public void pressLEFT() {
		boolean leftGo = true;
		for(int i = 0; i < Ghost.game.monsterList.size(); i++) {
			if(Math.abs(y - Ghost.game.monsterList.get(i).y) < 50)
			if((x - Ghost.game.monsterList.get(i).x) > 0 && Math.abs(x - Ghost.game.monsterList.get(i).x) < 50 ) {
				leftGo = false;
			}
		}
		if(x > 0 && leftGo){
			x -= SPEED;
			ghostR.setRect(x , y , 50, 50);
		}
	}
	public void releaseLEFT() {
	
	}
	
	public void pressRIGHT() {
		boolean rightGo = true;
		for(int i = 0; i < Ghost.game.monsterList.size(); i++) {
			if(Math.abs(y - Ghost.game.monsterList.get(i).y) < 50)
			if((x - Ghost.game.monsterList.get(i).x) < 0 && Math.abs(x - Ghost.game.monsterList.get(i).x) < 50 ) {
				rightGo = false;
			}
		}
		if(x < 1280 && rightGo){
			x += SPEED;
			ghostR.setRect(x , y , 50, 50);
		}
	}
	public void releaseRIGHT() {
	
	}

	public Image getGhostBasicImage() {
		return ghostBasicImage;
	}
	
}

