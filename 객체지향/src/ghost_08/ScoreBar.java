package ghost_08;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScoreBar extends JPanel implements Runnable {
	
	private Image scoreBack = new ImageIcon(getClass().getClassLoader().getResource("images/scoreBar.png")).getImage();
	
	private JLabel gTime;
	
	private int sec = 0;
	
	private Thread gameTime;
	
	
	public ScoreBar() {
		setLayout(null);
		setOpaque(false);
		gTime = new JLabel("0");
		gTime.setBounds(10, 100, 30, 30);
		add(gTime);
		gameTime = new Thread(this);
		gameTime.start();
	}
	
	
	
	@Override
	public void run() {
		
		try {
			while(Ghost.game.playStop) {
								
				Thread.sleep(1000);
				
				sec += 1;
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
