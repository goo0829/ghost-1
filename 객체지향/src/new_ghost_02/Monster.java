package new_ghost_02;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import new_ghost_01.Main;

public class Monster extends JLabel implements Runnable {
	private final int SPEED = 1;
	private final int SLEEP = 10;
	
	public int x, y;
	
	private Image monsterBasicImage = new ImageIcon(Main.class.getResource("../images/monster.png")).getImage();
	
	
	private Rectangle2D monsterR;
	
	public Thread thread;
	
	public Monster(int x, int y) {
		this.x = x;
		this.y = y;
		monsterR = new Rectangle2D.Double(x, y, 50, 50);
		thread = new Thread(this);
	}
	
	public void run() {
		try {
			while(true) {
				
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(monsterBasicImage, 0, 0, null);
	}
}
