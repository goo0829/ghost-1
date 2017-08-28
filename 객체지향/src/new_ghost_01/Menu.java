package new_ghost_01;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu extends JPanel{
	
	private Image backGroundImage = new ImageIcon(getClass().getClassLoader().getResource("images/mainScreenResize.png")).getImage();
	
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
	
	private Music introMusic = new Music("mainScreenMusic.mp3", true);
	
	private Main main;
	
	
	
	public Menu(Main main) {
		this.main = main;
		setLayout(null);
		introMusic.start();
		// buttonSet �޼ҵ带 ���ؼ� ��ư���� �־��ش�
		buttonSet(startButton, 93, 250, 339, 123);
		buttonSet(helpButton, 93, 392, 339, 123);
		buttonSet(exitButton, 93, 546, 339, 123);
		
		// startButton �̺�Ʈó��
				startButton.addMouseListener(new MouseAdapter() {
					// ���콺�� ��ư�� �������� �̺�Ʈ ó��
					@Override
					public void mouseEntered(MouseEvent e) {
						// Entered�̹����� ���� �����ش�.
						startButton.setIcon(startButtonEntered);
						// Ŀ���� ����� �ٲ��ش�
						startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
						// ȿ���� ���
						Music menuEnteredMusic = new Music("menuEnteredMusic.mp3", false);
						menuEnteredMusic.start();
					}

					// ���콺�� ��ư�� �������� �̺�Ʈ ó��
					@Override
					public void mouseExited(MouseEvent e) {
						startButton.setIcon(startButtonBasic);
						// Ŀ���� ����� �ٲ��ش�
						startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}

					// ��ư�� Ŭ�������� �̺�Ʈ ó��
					@Override
					public void mousePressed(MouseEvent e) {
						// ȿ���� ���
						Music menuClickMusic = new Music("menuClickMusic.mp3", false);
						menuClickMusic.start();
						// ����ȭ�� ������ ���ְ� ���������� ư��.
						introMusic.close();
						// �ٸ� ȭ���� �Ⱥ��̰� �����Ų��.
						startButton.setVisible(false);
						helpButton.setVisible(false);
						exitButton.setVisible(false);
						main.gameStart();
						
					}
				});

				// helpButton �̺�Ʈó��
				helpButton.addMouseListener(new MouseAdapter() {
					// ���콺�� ��ư�� �������� �̺�Ʈ ó��
					@Override
					public void mouseEntered(MouseEvent e) {
						// Entered�̹����� ���� �����ش�.
						helpButton.setIcon(helpButtonEntered);
						// Ŀ���� ����� �ٲ��ش�
						helpButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
						// ȿ���� ���
						Music menuEnteredMusic = new Music("menuEnteredMusic.mp3", false);
						menuEnteredMusic.start();
					}

					// ���콺�� ��ư�� �������� �̺�Ʈ ó��
					@Override
					public void mouseExited(MouseEvent e) {
						helpButton.setIcon(helpButtonBasic);
						// Ŀ���� ����� �ٲ��ش�
						helpButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}

					// ��ư�� Ŭ�������� �̺�Ʈ ó��
					@Override
					public void mousePressed(MouseEvent e) {
						// ȿ���� ���
						Music menuClickMusic = new Music("menuClickMusic.mp3", false);
						menuClickMusic.start();
						// ���� ���� �̺�Ʈ
					}
				});

				// exitButton �̺�Ʈó��
				exitButton.addMouseListener(new MouseAdapter() {
					// ���콺�� ��ư�� �������� �̺�Ʈ ó��
					@Override
					public void mouseEntered(MouseEvent e) {
						// Entered�̹����� ���� �����ش�.
						exitButton.setIcon(exitButtonEntered);
						// Ŀ���� ����� �ٲ��ش�
						exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
						// ȿ���� ���
						Music menuEnteredMusic = new Music("menuEnteredMusic.mp3", false);
						menuEnteredMusic.start();
					}

					// ���콺�� ��ư�� �������� �̺�Ʈ ó��
					@Override
					public void mouseExited(MouseEvent e) {
						exitButton.setIcon(exitButtonBasic);
						// Ŀ���� ����� �ٲ��ش�
						exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}

					// ��ư�� Ŭ�������� �̺�Ʈ ó��
					@Override
					public void mousePressed(MouseEvent e) {
						// ȿ���� ���
						Music menuClickMusic = new Music("menuClickMusic.mp3", false);
						menuClickMusic.start();
						// ���α׷��� �ٷ� ������ �ʰ� 1������ �ִٰ� �����Ա� ����
						try {
							Thread.sleep(1000);
						} catch (InterruptedException ex) {
							ex.printStackTrace();
						}
						System.exit(0);
					}
				});
		
	}
	
	
	// ��ư ���� �޼ҵ� ��� ��ư���� �������� �ֱ� �������Ƿ� �޼ҵ�� �������.
	public void buttonSet(JButton button, int x, int y, int width, int height) {
		button.setBounds(x, y, width, height);
		// ��ư �׵θ� ����
		button.setBorderPainted(false);
		// ������ ���� ����
		button.setContentAreaFilled(false);
		// �۾� �׵θ� ����
		button.setFocusPainted(false);
		// ��ư �߰�
		add(button);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);		
		g.drawImage(backGroundImage, 0, 0, null);
		
//		paintComponent((Graphics2D)g);
	}
	
	public void paintComponent(Graphics2D g) {
		
	}
	
}
