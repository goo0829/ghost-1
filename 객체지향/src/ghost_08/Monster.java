package ghost_08;

import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.ImageIcon;



public class Monster extends Thread {
	public static final int SPEED = 1;
	public static final int SLEEP_TIME = 10;

	public int x, y;
	private boolean stop;

	private Image monsterBasicImage = new ImageIcon(Main.class.getResource("../images/monster.png")).getImage();

	Random rd = new Random();

	public Rectangle2D monsterR;

	public Monster(int x, int y) {
		this.x = x;
		this.y = y;
		monsterR = new Rectangle2D.Double(x, y, 50 ,50);
		stop = false;
		//		this.start();
	}

	public void run() {
		try{
			while(!stop){
				//				if(stop) break;
				System.out.println(monsterR);
				int tempX = x;
				int tempY = y;
				
				for(int j = 0; j < Ghost.game.monsterList.size(); j++) {
					if(this == Ghost.game.monsterList.get(j)) continue;
					if(monsterR.intersects(Ghost.game.monsterList.get(j).monsterR)) {
						x = tempX;
						y = tempY;
						monsterR.setRect(x, y, 50, 50);
					}
				}
				
				if(Ghost.game.ghostCharacter.x > x) {
					if(Ghost.game.ghostCharacter.y > y) {
						x += SPEED;
						y += SPEED;
						monsterR.setRect(x, y, 50, 50);
						
						for(int i = 0; i < Ghost.game.barrierList.size(); i++) {
							if(monsterR.intersects(Ghost.game.barrierList.get(i).barrierR)) {
								x = tempX + SPEED;
								y = tempY;
								monsterR.setRect(x, y, 50, 50);
							}
							if(monsterR.intersects(Ghost.game.barrierList.get(i).barrierR)) {
								x = tempX;
								y = tempY + SPEED;
								monsterR.setRect(x, y, 50, 50);
							}
						}
					} else {
						x += SPEED;
						y -= SPEED;
						monsterR.setRect(x, y, 50, 50);
						
						for(int i = 0; i < Ghost.game.barrierList.size(); i++) {
							if(monsterR.intersects(Ghost.game.barrierList.get(i).barrierR)) {
								x = tempX + SPEED;
								y = tempY;
								monsterR.setRect(x, y, 50, 50);
							}
							if(monsterR.intersects(Ghost.game.barrierList.get(i).barrierR)) {
								x = tempX;
								y = tempY - SPEED;
								monsterR.setRect(x, y, 50, 50);
							}
						}
					}
				} else {
					if(Ghost.game.ghostCharacter.y > y) {
						x -= SPEED;
						y += SPEED;
						monsterR.setRect(x, y, 50, 50);
						
						for(int i = 0; i < Ghost.game.barrierList.size(); i++) {
							if(monsterR.intersects(Ghost.game.barrierList.get(i).barrierR)) {
								x = tempX - SPEED;
								y = tempY;
								monsterR.setRect(x, y, 50, 50);
							}
							if(monsterR.intersects(Ghost.game.barrierList.get(i).barrierR)) {
								x = tempX;
								y = tempY + SPEED;
								monsterR.setRect(x, y, 50, 50);
							}
						}
					} else {
						x -= SPEED;
						y -= SPEED;
						monsterR.setRect(x, y, 50, 50);
						
						for(int i = 0; i < Ghost.game.barrierList.size(); i++) {
							if(monsterR.intersects(Ghost.game.barrierList.get(i).barrierR)) {
								x = tempX - SPEED;
								y = tempY;
								monsterR.setRect(x, y, 50, 50);
							}
							if(monsterR.intersects(Ghost.game.barrierList.get(i).barrierR)) {
								x = tempX;
								y = tempY - SPEED;
								monsterR.setRect(x, y, 50, 50);
							}
						}
					}
				}
				
				
				
				
				
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
			this.x += SPEED;
			monsterR.setRect(x, y, 50, 50);
		}
		else if((Ghost.game.ghostCharacter.x) < x){
			this.x -= SPEED;
			monsterR.setRect(x, y, 50, 50);
		}
		else if((Ghost.game.ghostCharacter.y) > y) {
			this.y += SPEED;
			monsterR.setRect(x, y, 50, 50);
		}
		else if((Ghost.game.ghostCharacter.y) < y){
			this.y -= SPEED;
			monsterR.setRect(x, y, 50, 50);
		}
	}

	//	public boolean isGo() {
	//		
	//	}

	public Image getBasicImage() {
		return monsterBasicImage;
	}

}
