package ghost_07;

import java.awt.Image;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;

public class Barrier {

	private Image barrierImage = new ImageIcon(Main.class.getResource("../images/barrier.png")).getImage();
	
	public int x, y;
	
	public Rectangle2D barrierR;
	
	public Barrier(int x, int y){
		this.x = x;
		this.y = y;
		barrierR = new Rectangle2D.Double(x, y, 70, 100);
		System.out.println("Barrier Start!###########################################");
	}
	
	
	public void run(){
		try{
			
		}catch(Exception e){
			System.out.println(e.getMessage());
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
