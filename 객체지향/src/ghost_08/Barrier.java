package ghost_08;

import java.awt.Image;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;

public class Barrier {

	private Image barrierImage;
	
	public int x, y;
	
	public Rectangle2D barrierR;
	
	public Barrier(int x, int y, String type){
		this.x = x;
		this.y = y;
		if(type.equals("S")) {
			barrierImage = new ImageIcon(Main.class.getResource("../images/barrier(SMALL).png")).getImage();
			barrierR = new Rectangle2D.Double(x, y, 60, 80);
		}
		if(type.equals("B")) {
			barrierImage = new ImageIcon(Main.class.getResource("../images/barrier(BIG).png")).getImage();
			barrierR = new Rectangle2D.Double(x, y, 60, 300);
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
}
