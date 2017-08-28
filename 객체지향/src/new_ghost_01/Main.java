package new_ghost_01;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main extends JFrame {

	public final static int WIDTH = 1280;
	public final static int HEIGHT = 720;
	
	private Image background = new ImageIcon(getClass().getClassLoader().getResource("images/mainScreenResize.png")).getImage();
	
	private StartMenu startMenu;
	
	private Image screenImage;
	private Graphics screenGraphic;
	
	// �޴��� �����ư �̹��� �ʵ尪�� ������ش�.
	private ImageIcon menuExitButtonBasic = new ImageIcon(getClass().getClassLoader().getResource("images/menuExitButton.png"));
	private ImageIcon menuExitButtonEntered = new ImageIcon(
			getClass().getClassLoader().getResource("images/menuExitButtonEntered.png"));
	
	private JButton menuExitButton = new JButton(menuExitButtonBasic);

	// �޴��ٸ� ������ش�.
	private JLabel menuBar = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("images/menuBar.png")));

	// ���� ���α׷������� ���콺�� X�� Y��ǥ�� ������ �ִ� �ʵ带 �����.
	private int mouseX, mouseY;
	
	public Main() {
		// �޴��ٰ� ������ �ʰԲ� ����
//		setUndecorated(true);
		// ���� �̸� ����
		setTitle("Ghost");
		// ���� â ũ�� ����
		setSize(WIDTH, HEIGHT);
		// âũ�� ���� �Ұ��� ����
		setResizable(false);
		// ���� ����� ȭ�� ���߾ӿ� �߰Բ� ����
		setLocationRelativeTo(null);
		// ���� ����� ���α׷� ���ᰡ �ǰԲ� ����, �̼����� ������ ����ǵ� ���α׷��� ��� ����ȴ�.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ȭ�� ���, �⺻���� false �̹Ƿ� ���� ������Ѵ�.
		setVisible(true);
		// paintComponent�� �׸��� ������ ȸ������ ����
		getContentPane().setBackground(new Color(0, 0, 0, 0));
		// �����̳��� ũ�Ⱑ ����ɶ� ������Ʈ���� ũ��� ��ġ�� �ڵ������� ����Ǵµ� �װ� �����Ѵ�.
		setLayout(null);
		setFocusable(true);
//		addKeyListener(new KeyListener());
		
//		menuExitButton.setBounds(1215, 5, 50, 20);
//		// ��ư �׵θ� ����
//		menuExitButton.setBorderPainted(false);
//		// ������ ���� ����
//		menuExitButton.setContentAreaFilled(false);
//		// �۾� �׵θ� ����
//		menuExitButton.setFocusPainted(false);
//		// ��ư �߰�
//		getContentPane().add(menuExitButton);
//		
//		// setBounds�� ���� ��ġ�� ũ�⸦ �������ش�.
//				menuBar.setBounds(0, 0, 1280, 30);
//				// add�� �ϸ� paintComponetns�� ���ؼ� �׷�����.
//				getContentPane().add(menuBar);
//				// menuBar�� ���콺�� ���ؼ� �����Ҽ� �ֵ��� �̺�Ʈó���� ���ش�.
//				menuBar.addMouseListener(new MouseAdapter() {
//					// ���콺�� �Է������� ������Ʈ���� ���콺�� x��ǥ�� y��ǥ�� �����´�
//					@Override
//					public void mousePressed(MouseEvent e) {
//						mouseX = e.getX();
//						mouseY = e.getY();
//					}
//				});
//				// menuBar�� �巡�� ������ �̺�Ʈ ó���� ���ش�.
//				menuBar.addMouseMotionListener(new MouseMotionAdapter() {
//					// ���콺�� �Է������� ��ũ��(�����)���� ���콺�� x��ǥ�� y��ǥ�� �����´�
//					@Override
//					public void mouseDragged(MouseEvent e) {
//						int x = e.getXOnScreen();
//						int y = e.getYOnScreen();
//						// ��ũ������ ���콺�� ��ǥ�� ������Ʈ���� ���콺�� ��ǥ�� ���� ����â�� ��ġ�̴�.
//						setLocation(x - mouseX, y - mouseY);
//					}
//				});
//				
//				// exitMenuButton �̺�Ʈ ó��
//				menuExitButton.addMouseListener(new MouseAdapter() {
//					// ���콺�� ��ư�� �������� �̺�Ʈ ó��
//					@Override
//					public void mouseEntered(MouseEvent e) {
//						// Entered�̹����� ���� �����ش�.
//						menuExitButton.setIcon(menuExitButtonEntered);
//						// Ŀ���� ����� �ٲ��ش�
//						menuExitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
//						// ȿ���� ���
//						Music menuEnteredMusic = new Music("menuEnteredMusic.mp3", false);
//						menuEnteredMusic.start();
//					}
//
//					// ���콺�� ��ư�� �������� �̺�Ʈ ó��
//					@Override
//					public void mouseExited(MouseEvent e) {
//						menuExitButton.setIcon(menuExitButtonBasic);
//						// Ŀ���� ����� �ٲ��ش�
//						menuExitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
//					}
//
//					// ��ư�� Ŭ�������� �̺�Ʈ ó��
//					@Override
//					public void mousePressed(MouseEvent e) {
//						// ȿ���� ���
//						Music menuClickMusic = new Music("menuClickMusic.mp3", false);
//						menuClickMusic.start();
//						// ���α׷��� �ٷ� ������ �ʰ� 1������ �ִٰ� �����Ա� ����
//						try {
//							Thread.sleep(1000);
//						} catch (InterruptedException ex) {
//							ex.printStackTrace();
//						}
//						System.exit(0);
//					}
//				});
		
		startProgram();
	}
	
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

	
//	public void paint(Graphics g) {
//		// 1280 * 720 ��ŭ�� �̹����� ���� ������ ����
//		screenImage = createImage(WIDTH, HEIGHT);
//		// screenImage ���� �׷��Ȱ��� �� ������ ����
//		screenGraphic = screenImage.getGraphics();
//		// screenDraw �Լ��� ���ؼ� �׷��� ���� screenGraphic�� �׸���.
//		screenDraw((Graphics2D)screenGraphic);
//		// screenImage �� screenDraw���� �׸� �̹����� ȭ�鿡 ����ش�.
//		g.drawImage(screenImage, 0, 0, null);
//	}
//
//	public void screenDraw(Graphics2D g) {
//		g.drawImage(background, 0, 0, null);
//		
//		if(startMenu != null)
//		startMenu.screenDraw(g);
//		
//		paintComponents(g);
//		// �ٽ� paint�޼ҵ带 ȣ���Ѵ�
//		this.repaint();
//	}
	
	 protected void paintComponent(Graphics g) {
	        paintComponent((Graphics2D) g);
	    }
	
	public void paintComponent(Graphics2D g) {
		super.paintComponents(g);
	}
	
	public void startProgram() {
		getContentPane().removeAll();
		startMenu = new StartMenu();
		getContentPane().add(startMenu, null);
				
	}
	
	
	public static void main(String[] args) {
		Main main = new Main();

	}

}
