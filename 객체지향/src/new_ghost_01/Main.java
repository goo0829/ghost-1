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
	
	// 메뉴바 종료버튼 이미지 필드값을 만들어준다.
	private ImageIcon menuExitButtonBasic = new ImageIcon(getClass().getClassLoader().getResource("images/menuExitButton.png"));
	private ImageIcon menuExitButtonEntered = new ImageIcon(
			getClass().getClassLoader().getResource("images/menuExitButtonEntered.png"));
	
	private JButton menuExitButton = new JButton(menuExitButtonBasic);

	// 메뉴바를 만들어준다.
	private JLabel menuBar = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("images/menuBar.png")));

	// 현재 프로그램내에서 마우스의 X와 Y좌표를 받을수 있는 필드를 만든다.
	private int mouseX, mouseY;
	
	public Main() {
		// 메뉴바가 보이지 않게끔 설정
//		setUndecorated(true);
		// 게임 이름 설정
		setTitle("Ghost");
		// 게임 창 크기 설정
		setSize(WIDTH, HEIGHT);
		// 창크기 변경 불가능 설정
		setResizable(false);
		// 게임 실행시 화면 정중앙에 뜨게끔 설정
		setLocationRelativeTo(null);
		// 게임 종료시 프로그램 종료가 되게끔 설정, 미설정시 게임이 종료되도 프로그램을 계속 실행된다.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 화면 출력, 기본값은 false 이므로 설정 해줘야한다.
		setVisible(true);
		// paintComponent로 그릴때 배경색을 회색으로 지정
		getContentPane().setBackground(new Color(0, 0, 0, 0));
		// 컨테이너의 크기가 변경될때 컴포넌트들의 크기와 위치가 자동적으로 변경되는데 그걸 해제한다.
		setLayout(null);
		setFocusable(true);
//		addKeyListener(new KeyListener());
		
//		menuExitButton.setBounds(1215, 5, 50, 20);
//		// 버튼 테두리 제거
//		menuExitButton.setBorderPainted(false);
//		// 누르는 느낌 제거
//		menuExitButton.setContentAreaFilled(false);
//		// 글씨 테두리 제거
//		menuExitButton.setFocusPainted(false);
//		// 버튼 추가
//		getContentPane().add(menuExitButton);
//		
//		// setBounds를 통해 위치와 크기를 지정해준다.
//				menuBar.setBounds(0, 0, 1280, 30);
//				// add를 하면 paintComponetns를 통해서 그려진다.
//				getContentPane().add(menuBar);
//				// menuBar를 마우스를 통해서 조작할수 있도록 이벤트처리를 해준다.
//				menuBar.addMouseListener(new MouseAdapter() {
//					// 마우스를 입력했을때 컴포넌트내의 마우스의 x좌표와 y좌표를 가져온다
//					@Override
//					public void mousePressed(MouseEvent e) {
//						mouseX = e.getX();
//						mouseY = e.getY();
//					}
//				});
//				// menuBar를 드래그 했을때 이벤트 처리를 해준다.
//				menuBar.addMouseMotionListener(new MouseMotionAdapter() {
//					// 마우스를 입력했을때 스크린(모니터)내의 마우스의 x좌표와 y좌표를 가져온다
//					@Override
//					public void mouseDragged(MouseEvent e) {
//						int x = e.getXOnScreen();
//						int y = e.getYOnScreen();
//						// 스크린내의 마우스의 좌표와 컴포넌트내의 마우스의 좌표의 차가 게임창의 위치이다.
//						setLocation(x - mouseX, y - mouseY);
//					}
//				});
//				
//				// exitMenuButton 이벤트 처리
//				menuExitButton.addMouseListener(new MouseAdapter() {
//					// 마우스가 버튼에 들어왓을때 이벤트 처리
//					@Override
//					public void mouseEntered(MouseEvent e) {
//						// Entered이미지로 변경 시켜준다.
//						menuExitButton.setIcon(menuExitButtonEntered);
//						// 커서의 모양을 바꿔준다
//						menuExitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
//						// 효과음 재생
//						Music menuEnteredMusic = new Music("menuEnteredMusic.mp3", false);
//						menuEnteredMusic.start();
//					}
//
//					// 마우스가 버튼에 나갔을때 이벤트 처리
//					@Override
//					public void mouseExited(MouseEvent e) {
//						menuExitButton.setIcon(menuExitButtonBasic);
//						// 커서의 모양을 바꿔준다
//						menuExitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
//					}
//
//					// 버튼을 클릭했을때 이벤트 처리
//					@Override
//					public void mousePressed(MouseEvent e) {
//						// 효과음 재생
//						Music menuClickMusic = new Music("menuClickMusic.mp3", false);
//						menuClickMusic.start();
//						// 프로그램이 바로 꺼지지 않고 1초정도 있다가 꺼지게금 설정
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
		// 버튼 테두리 제거
		button.setBorderPainted(false);
		// 누르는 느낌 제거
		button.setContentAreaFilled(false);
		// 글씨 테두리 제거
		button.setFocusPainted(false);
		// 버튼 추가
		add(button);
	}

	
//	public void paint(Graphics g) {
//		// 1280 * 720 만큼의 이미지를 만들어서 변수에 대입
//		screenImage = createImage(WIDTH, HEIGHT);
//		// screenImage 에서 그래픽값을 얻어서 변수에 대입
//		screenGraphic = screenImage.getGraphics();
//		// screenDraw 함수를 통해서 그래픽 값을 screenGraphic에 그린다.
//		screenDraw((Graphics2D)screenGraphic);
//		// screenImage 즉 screenDraw에서 그린 이미지를 화면에 띄워준다.
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
//		// 다시 paint메소드를 호출한다
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
