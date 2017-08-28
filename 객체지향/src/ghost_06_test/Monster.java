package ghost_06_test;

import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.ImageIcon;

public class Monster extends Thread {
	public static final int SPEED = 1;
	public static final int SLEEP_TIME = 10;

	public int x, y;
	private boolean stop = false;

	private Image monsterBasicImage = new ImageIcon(Main.class.getResource("../images/monster.png")).getImage();

	Random rd = new Random();

	public Rectangle2D monsterR;

	public Monster() {
		x = rd.nextInt(1250) / 10 * 10;
		y = rd.nextInt(700) / 10 * 10;
		monsterR = new Rectangle2D.Double(x, y, 50 ,50);
	}

	public void run() {
		try{
			while(true){
				if(stop) break;
				//				int chk = rd.nextInt(4);
				//				for(int i = 0; i < 60; i++){				
				//					move(chk, x, y);
				//					Thread.sleep(SLEEP_TIME);
				//				}
				followMove();
				Thread.sleep(SLEEP_TIME);
			}
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public void monsterStop() {
		stop = true;
	}

	public void move(int chk, int x, int y) {
		switch(chk){
		case 0: 
			if(x < 1230){
				this.x += SPEED;
				break;
			}
			else {
				this.x -= SPEED;
				break;
			}
		case 1: 
			if(x > 0){
				this.x -= SPEED;
				break;
			} 
			else {
				this.x += SPEED;
				break;
			}
		case 2: 
			if(y < 670){
				this.y += SPEED;
				break;
			}
			else {
				this.y -= SPEED;
				break;				
			}
		case 3: 
			if(y > 0){
				this.y -= SPEED;
				break;
			}
			else {
				this.y += SPEED;
				break;
			}
		}
	}

	public void followMove() {
		if((Ghost.game.ghostCharacter.x) > x) {
			boolean rightGo = true;
			if((Math.sqrt(Math.pow((x + 25) - (Ghost.game.ghostCharacter.x + 25), 2) +
					Math.pow((y + 25) - (Ghost.game.ghostCharacter.y + 25), 2))) < 50) {
				System.out.println("RSTOP");
				rightGo = false;
			}
			if(x < 1280 && rightGo){
				this.x += SPEED;
				monsterR.setRect(x, y, 50, 50);
			}
		}
		else {
			boolean leftGo = true;
			if((Math.sqrt(Math.pow((x + 25) - (Ghost.game.ghostCharacter.x + 25), 2) +
					Math.pow((y + 25) - (Ghost.game.ghostCharacter.y + 25), 2))) < 50) {
				System.out.println("LSTOP");
				leftGo = false;
			}
			if(x > 0 && leftGo){
				this.x -= SPEED;
				monsterR.setRect(x, y, 50, 50);
			}
		}
		if((Ghost.game.ghostCharacter.y) > y) {
			boolean downGo = true;
			if((Math.sqrt(Math.pow((x + 25) - (Ghost.game.ghostCharacter.x + 25), 2) +
					Math.pow((y + 25) - (Ghost.game.ghostCharacter.y + 25), 2))) < 50) {
				System.out.println("DSTOP");
				downGo = false;

			}
			if(y < 720 && downGo){
				this.y += SPEED;
				monsterR.setRect(x, y, 50, 50);
			}
		}
		else {
			boolean upGo = true;
			if((Math.sqrt(Math.pow((x + 25) - (Ghost.game.ghostCharacter.x + 25), 2) +
					Math.pow((y + 25) - (Ghost.game.ghostCharacter.y + 25), 2))) < 50) {
				System.out.println("USTOP");
				upGo = false;

			}
			if(y > 0 && upGo){
				this.y -= SPEED;
				monsterR.setRect(x, y, 50, 50);
			}
		}
	}

//	public boolean isGo() {
//		
//	}

	public Image getBasicImage() {
		return monsterBasicImage;
	}

}
