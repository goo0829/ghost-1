package new_ghost_01;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;

public class GhostCharacter extends Thread{
	private static final int SPEED = 3;
	private static final int SLEEP_TIME = 10;
	
	private int x, y;
	
	private Image ghostBasicImage = new ImageIcon(Main.class.getResource("../images/testGhostCharacter.png")).getImage();
	private Image ghostBackImage = new ImageIcon(Main.class.getResource("../images/testGhostBack.png")).getImage();
	
	private boolean gameStart = false;
	private boolean stop = false;
	
	private boolean ispressUP = false;
	private boolean ispressDOWN = false;
	private boolean ispressLEFT = false;
	private boolean ispressRIGHT = false;
	
	private Rectangle2D ghostR;
	private Game game;
	
	public GhostCharacter(int x, int y, Game game) {
		this.game = game;
		this.setX(x);
		this.setY(y);
		setGhostR(new Rectangle2D.Double(x , y , 50, 50));
	}	
	
	public void run() {
		try{
			while(true){
				int tempX = getX();
				int tempY = getY();
				pressKey();
				getGhostR().setRect(getX() , getY() , 50, 50);
				for(int i = 0; i < game.getBarrierList().size(); i++) {
					for(int j = 0; j < game.getMonsterList().size(); j++) {
						if(isGameStart() && (getGhostR().intersects(game.getMonsterList().get(j).getMonsterR()) || getGhostR().intersects(game.getBarrierList().get(i).getBarrierR()))) {
							setX(tempX);
							setY(tempY);
						}
					}
				}
				getGhostR().setRect(getX() , getY() , 50, 50);
				if(stop) break;
//				System.out.println(x + "         " + y);
				Thread.sleep(SLEEP_TIME);
			}
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void screenDraw(Graphics2D g) {
		g.drawImage(ghostBasicImage, getX(), getY(), null);
		//g.drawImage(ghostBackImage, x - 1255, y - 695, null);

	}

	public void ghostCharacterStop() {
		stop = true;
	}

	public void pressKey() {
		if(ispressUP && getY() > 0) {
			setY(getY() - getSpeed());
		}
		else if(ispressDOWN && getY() < 670) {
			setY(getY() + getSpeed());
		}
		else if(ispressRIGHT && getX() < 1230) {
			setX(getX() + getSpeed());
		}
		else if(ispressLEFT && getX() > 0) {
			setX(getX() - getSpeed());
		}

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
		if(ispressUP && getY() > 0) {
			setY(getY() - getSpeed());
		}

//		if(gameStart && (ghostR.intersects(Ghost.game.monsterList.get(0).monsterR) || ghostR.intersects(Ghost.game.barrier.barrierR))) {
//			System.out.println("000000");
//			y = temp;
//		}
//		ghostR.setRect(x , y , 50, 50);

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
		if(ispressDOWN && getY() < 670) {
			setY(getY() + getSpeed());
		}

//		if(gameStart && (ghostR.intersects(Ghost.game.monsterList.get(0).monsterR) || ghostR.intersects(Ghost.game.barrier.barrierR))) {
//			y -= SPEED;
//		}
//		ghostR.setRect(x , y , 50, 50);

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
		if(ispressLEFT && getX() > 0) {
			setX(getX() - getSpeed());
		}

//		if(gameStart && (ghostR.intersects(Ghost.game.monsterList.get(0).monsterR) || ghostR.intersects(Ghost.game.barrier.barrierR))) {
//			x += SPEED;
//		}
//		ghostR.setRect(x , y , 50, 50);

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
		if(ispressRIGHT && getX() < 1230) {
			setX(getX() + getSpeed());
		}
		
//		if(gameStart && (ghostR.intersects(Ghost.game.monsterList.get(0).monsterR) || ghostR.intersects(Ghost.game.barrier.barrierR))) {
//			x -= SPEED;
//		}
//		ghostR.setRect(x , y , 50, 50);

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

	public boolean isGameStart() {
		return gameStart;
	}

	public void setGameStart(boolean gameStart) {
		this.gameStart = gameStart;
	}

	public Rectangle2D getGhostR() {
		return ghostR;
	}

	public void setGhostR(Rectangle2D ghostR) {
		this.ghostR = ghostR;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public static int getSpeed() {
		return SPEED;
	}
	
}

