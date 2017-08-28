package new_ghost_01;

import java.awt.Image;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;

public class Barrier {

	private Image barrierImage;
	
	private int x, y;
	
	private Rectangle2D barrierR;
	
	public Barrier(int x, int y, String type){
		this.setX(x);
		this.setY(y);
		if(type.equals("S")) {
			barrierImage = new ImageIcon(Main.class.getResource("../images/barrier(SMALL).png")).getImage();
			setBarrierR(new Rectangle2D.Double(x, y, 60, 80));
		}
		if(type.equals("B")) {
			barrierImage = new ImageIcon(Main.class.getResource("../images/barrier(BIG).png")).getImage();
			setBarrierR(new Rectangle2D.Double(x, y, 60, 300));
		}
	}
	
	public Image getBasicImage(){
		return getBarrierImage();
	}


	public Image getBarrierImage() {
		return barrierImage;
	}


	public void setBarrierImage(Image barrierImage) {
		this.barrierImage = barrierImage;
	}

	public Rectangle2D getBarrierR() {
		return barrierR;
	}

	public void setBarrierR(Rectangle2D barrierR) {
		this.barrierR = barrierR;
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
}
