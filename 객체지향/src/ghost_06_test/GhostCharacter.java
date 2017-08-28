package ghost_06_test;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;

public class GhostCharacter extends Thread{
	public static final int SPEED = 3;
	public static final int SLEEP_TIME = 10;
	
	public int x, y;
	
	private Image ghostBasicImage = new ImageIcon(Main.class.getResource("../images/testGhostCharacter.png")).getImage();
	private Image ghostBackImage = new ImageIcon(Main.class.getResource("../images/testGhostBack.png")).getImage();
	
	public boolean gameStart = false;
	private boolean stop = false;
	
	public boolean ispressUP = false;
	public boolean ispressDOWN = false;
	public boolean ispressLEFT = false;
	public boolean ispressRIGHT = false;
	
	public Rectangle2D ghostR;
	
	public GhostCharacter(int x, int y) {
		this.x = x;
		this.y = y;
		ghostR = new Rectangle2D.Double(x , y , 50, 50);
	}	
	
	public void run() {
		try{
			while(true){
				pressUP();
				pressDOWN();
				pressLEFT();
				pressRIGHT();
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

	public void pressKey() {
		pressUP();
		pressDOWN();
		pressLEFT();
		pressRIGHT();

		//		if(ispressUP) {
		//			y -= SPEED;
		//			ghostR.setRect(x , y , 50, 50);
		//		}
		//		if(ispressDOWN) {
		//			y += SPEED;
		//			ghostR.setRect(x , y , 50, 50);
		//		}
		//		if(ispressRIGHT) {
		//			x += SPEED;
		//			ghostR.setRect(x , y , 50, 50);
		//		}
		//		if(ispressLEFT) {
		//			x -= SPEED;
		//			ghostR.setRect(x , y , 50, 50);
		//		}

	}

	public void pressUP() {
		if(ispressUP) {
			y -= SPEED;
		}

		if(gameStart && ghostR.intersects(Ghost.game.monsterList.get(0).monsterR)) {
			y += SPEED;
		}
		ghostR.setRect(x , y , 50, 50);

		//		boolean upGo = true;
		//		for(int i = 0; i < Ghost.game.monsterList.size(); i++) {
		//			if((Math.sqrt(Math.pow((x + 25) - (Ghost.game.monsterList.get(i).x + 25), 2) +
		//					 Math.pow((y + 25) - (Ghost.game.monsterList.get(i).y + 25), 2))) < 50
		//					&& (Ghost.game.monsterList.get(i).y + 50 < y)
		//					&& ((x > Ghost.game.monsterList.get(i).x - 50) && x < Ghost.game.monsterList.get(i).x + 50)) { 
		//				upGo = false;
		//			}
		//		}
		//		if(y > 0 && upGo) { 
		//			y -= SPEED;
		//			ghostR.setRect(x , y , 50, 50);
		//		}
	}

	public void releaseUP() {
		stop = true;
	}

	public void pressDOWN() {
		if(ispressDOWN) {
			y += SPEED;
		}

		if(gameStart && ghostR.intersects(Ghost.game.monsterList.get(0).monsterR)) {
			y -= SPEED;
		}
		ghostR.setRect(x , y , 50, 50);

		//		boolean downGo = true;
		//		for(int i = 0; i < Ghost.game.monsterList.size(); i++) {
		//			if((Math.sqrt(Math.pow((x + 25) - (Ghost.game.monsterList.get(i).x + 25), 2) +
		//					 Math.pow((y + 25) - (Ghost.game.monsterList.get(i).y + 25), 2))) < 50
		//					&& (Ghost.game.monsterList.get(i).y - 50 > y)
		//					&& ((x > Ghost.game.monsterList.get(i).x - 50) && x < Ghost.game.monsterList.get(i).x + 50)) {
		//				downGo = false;
		//			}
		//		}
		//		if(y < 720 && downGo){
		//			y += SPEED;
		//			ghostR.setRect(x , y , 50, 50);
		//		}
	}

	public void releaseDOWN() {

	}

	public void pressLEFT() {
		if(ispressLEFT) {
			x -= SPEED;
		}

		if(gameStart && ghostR.intersects(Ghost.game.monsterList.get(0).monsterR)) {
			x += SPEED;
		}
		ghostR.setRect(x , y , 50, 50);

		//		boolean leftGo = true;
		//		for(int i = 0; i < Ghost.game.monsterList.size(); i++) {
		//			if((Math.sqrt(Math.pow((x + 25) - (Ghost.game.monsterList.get(i).x + 25), 2) +
		//					 Math.pow((y + 25) - (Ghost.game.monsterList.get(i).y + 25), 2))) < 50) {
		//				leftGo = false;
		//			}
		//		}
		//		if(x > 0 && leftGo){
		//			x -= SPEED;
		//			ghostR.setRect(x , y , 50, 50);
		//		}
	}
	public void releaseLEFT() {

	}

	public void pressRIGHT() {
		if(ispressRIGHT) {
			x += SPEED;
		}

		if(gameStart && ghostR.intersects(Ghost.game.monsterList.get(0).monsterR)) {
			x -= SPEED;
		}
		ghostR.setRect(x , y , 50, 50);

		//		boolean rightGo = true;
		//		for(int i = 0; i < Ghost.game.monsterList.size(); i++) {
		//				if((Math.sqrt(Math.pow((x + 25) - (Ghost.game.monsterList.get(i).x + 25), 2) +
		//				 Math.pow((y + 25) - (Ghost.game.monsterList.get(i).y + 25), 2))) < 50) { 
		//				rightGo = false;
		//			}
		//		}
		//		if(x < 1280 && rightGo){
		//			x += SPEED;
		//			ghostR.setRect(x , y , 50, 50);
		//		}
	}


	public void releaseRIGHT() {
	
	}

	public Image getGhostBasicImage() {
		return ghostBasicImage;
	}
	
}

