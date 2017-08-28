package new_ghost_01;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class StartMenu extends JPanel {

	private Image background = new ImageIcon(getClass().getClassLoader().getResource("images/mainScreenResize.png")).getImage();


	private ImageIcon startButtonBasic = new ImageIcon(getClass().getClassLoader().getResource("images/startButton.png"));
	private ImageIcon startButtonEntered = new ImageIcon(getClass().getClassLoader().getResource("images/startButtonEntered.png"));
	private ImageIcon helpButtonBasic = new ImageIcon(getClass().getClassLoader().getResource("images/helpButton.png"));
	private ImageIcon helpButtonEntered = new ImageIcon(getClass().getClassLoader().getResource("images/helpButtonEntered.png"));
	private ImageIcon exitButtonBasic = new ImageIcon(getClass().getClassLoader().getResource("images/exitButton.png"));
	private ImageIcon exitButtonEntered = new ImageIcon(
			getClass().getClassLoader().getResource("images/exitButtonEntered.png"));

	private JButton startButton = new JButton(startButtonBasic);
	private JButton helpButton = new JButton(helpButtonBasic);
	private JButton exitButton = new JButton(exitButtonBasic);






	// 음악 객체
	Music introMusic = new Music("mainScreenMusic.mp3", true);

//	public StartMenu() {
//		setLayout(null);
//		JLabel jl = new JLabel("TEST");
//		add(jl);
//		setVisible(true);
//	}

	public void buttonSet(JButton button, int x, int y, int width, int height) {
		button.setBounds(x, y, width, height);
		// 버튼 테두리 제거
		button.setBorderPainted(false);
		// 누르는 느낌 제거
		button.setContentAreaFilled(false);
		// 글씨 테두리 제거
		button.setFocusPainted(false);
		// 버튼 추가
		add(button);
	}

	 @Override
	    protected void paintComponent(Graphics g) {
	        paintComponent((Graphics2D) g);
	    }
	
	public void paintComponent(Graphics2D g) {
		super.paintComponent(g);
//		g.drawImage(background, 0, 0, null);
		
		g.setColor(Color.black);
		g.drawRect(50, 50, 100, 100);
		g.drawRect(150, 150, 100, 100);
		g.drawRect(250, 250, 100, 100);
	}
	
//	public void screenDraw(Graphics2D g) {
//		g.drawImage(background, 0, 30, null);
//	}


}
