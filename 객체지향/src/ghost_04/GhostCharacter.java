package ghost_04;

import java.awt.Image;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;

public class GhostCharacter extends Thread{
	public static final int SPEED = 20;
	public static final int SLEEP_TIME = 10;
	
	public int x, y;
	
	private Image ghostBasicImage = new ImageIcon(Main.class.getResource("../images/testGhostCharacter(test).png")).getImage();
	
	
	boolean stop = false;
	
	public Rectangle2D ghostR;
	
	public GhostCharacter(int x, int y) {
		this.x = x;
		this.y = y;
		ghostR = new Rectangle2D.Double(x + 1280, y + 720, 50, 50);
	}	
	
	public void run() {
		try{
			while(true){
				
				Thread.sleep(SLEEP_TIME);
			}
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void pressUP() {
		if(y > -690){ 
			y -= SPEED;
			ghostR.setRect(x + 1280, y + 720, 50, 50);
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
		if(y < -30){
			y += SPEED;
			ghostR.setRect(x + 1280, y + 720, 50, 50);
		}
	}
	
	public void releaseDOWN() {
		
	}
	
	public void pressLEFT() {
		if(x > -1250){
			x -= SPEED;
			ghostR.setRect(x + 1280, y + 720, 50, 50);
		}
	}
	public void releaseLEFT() {
	
	}
	
	public void pressRIGHT() {
		if(x < -30){
			x += SPEED;
			ghostR.setRect(x + 1280, y + 720, 50, 50);
		}
	}
	public void releaseRIGHT() {
	
	}

	public Image getGhostBasicImage() {
		return ghostBasicImage;
	}
	
}

