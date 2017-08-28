package ghost_03;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class GhostCharacter extends Thread{
	public static final int SPEED = 50;
	public static final int SLEEP_TIME = 10;
	
	public int x, y;
	
	private Image ghostBasicImage = new ImageIcon(Main.class.getResource("../images/ghostCharacter.png")).getImage();
	
	boolean stop = false;
	
	public GhostCharacter(int x, int y) {
		this.x = x;
		this.y = y;
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
		if(y > 0) y -= 50;
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
		if(y < 700)
		y += 50;
	}
	
	public void releaseDOWN() {
		
	}
	
	public void pressLEFT() {
		if(x > 0)
		x -= 50;
	}
	public void releaseLEFT() {
	
	}
	
	public void pressRIGHT() {
		if(x < 1250)
		x += 50;
	}
	public void releaseRIGHT() {
	
	}

	public Image getGhostBasicImage() {
		return ghostBasicImage;
	}

	public void setGhostBasicImage(Image ghostBasicImage) {
		this.ghostBasicImage = ghostBasicImage;
	}
	
}
