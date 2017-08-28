package new_ghost_02;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Character extends JLabel implements Runnable {
	private final int SPEED = 3;
	private final int SLEEP = 10;
	
	public int x, y;
	
	private Image ghostBasicImage = new ImageIcon(Main.class.getResource("../images/testGhostCharacter.png")).getImage();
	private Image ghostBackImage = new ImageIcon(Main.class.getResource("../images/testGhostBack.png")).getImage();
	
	private Rectangle2D charR;
	
	public Thread charThread;
	
	public Character(int x, int y) {
		this.x = x;
		this.y = y;
		charR = new Rectangle2D.Double(x, y, 50, 50);
		charThread = new Thread(this);
	}
	
	public void run() {
		try {
			while(true) {
//				pressKey();
				for(int i = 0; i < 100; i++) {
					x += SPEED;
					Thread.sleep(SLEEP);
				}
				Thread.sleep(SLEEP);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(ghostBasicImage, 0, 0, null);
	}
}
