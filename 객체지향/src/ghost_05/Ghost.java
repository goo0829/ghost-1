package ghost_05;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.lang.Thread.State;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ghost extends JFrame {

	// 더블 버퍼링을 위해서 전체 화면을 담는 필드값이다.
	private Image screenImage;
	private Graphics screenGraphic;

	// Main 클래스의 위치를 기반으로 해서 Resource를 얻어서 그것의 이미지값을 변수에 대입시켜준다.
	private Image backGroundImage = new ImageIcon(getClass().getClassLoader().getResource("images/mainScreenResize.png")).getImage();

	// 메뉴바 종료버튼 이미지 필드값을 만들어준다.
	private ImageIcon menuExitButtonBasic = new ImageIcon(getClass().getClassLoader().getResource("images/menuExitButton.png"));
	private ImageIcon menuExitButtonEntered = new ImageIcon(
			getClass().getClassLoader().getResource("images/menuExitButtonEntered.png"));
	private ImageIcon startButtonBasic = new ImageIcon(getClass().getClassLoader().getResource("images/startButton.png"));
	private ImageIcon startButtonEntered = new ImageIcon(getClass().getClassLoader().getResource("images/startButtonEntered.png"));
	private ImageIcon helpButtonBasic = new ImageIcon(getClass().getClassLoader().getResource("images/helpButton.png"));
	private ImageIcon helpButtonEntered = new ImageIcon(getClass().getClassLoader().getResource("images/helpButtonEntered.png"));
	private ImageIcon exitButtonBasic = new ImageIcon(getClass().getClassLoader().getResource("images/exitButton.png"));
	private ImageIcon exitButtonEntered = new ImageIcon(
			getClass().getClassLoader().getResource("images/exitButtonEntered.png"));
	// 종료버튼을 만들어준다.

	private ImageIcon backButtonBasic = new ImageIcon(getClass().getClassLoader().getResource("images/backButton.png"));
	private ImageIcon backButtonEntered = new ImageIcon(getClass().getClassLoader().getResource("images/backButtonEntered.png"));
	
	private ImageIcon test1ButtonBasic = new ImageIcon(getClass().getClassLoader().getResource("images/test1Button.png"));
	private ImageIcon test1ButtonEntered = new ImageIcon(getClass().getClassLoader().getResource("images/test1ButtonEntered.png"));
	private ImageIcon test2ButtonBasic = new ImageIcon(getClass().getClassLoader().getResource("images/test2Button.png"));
	private ImageIcon test2ButtonEntered = new ImageIcon(getClass().getClassLoader().getResource("images/test2ButtonEntered.png"));	

	private JButton startButton = new JButton(startButtonBasic);
	private JButton helpButton = new JButton(helpButtonBasic);
	private JButton exitButton = new JButton(exitButtonBasic);
	private JButton menuExitButton = new JButton(menuExitButtonBasic);
	
	private JButton backButton = new JButton(backButtonBasic);
	
	private JButton test1Button = new JButton(test1ButtonBasic);
	private JButton test2Button = new JButton(test2ButtonBasic);

	// 메뉴바를 만들어준다.
	private JLabel menuBar = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("images/menuBar.png")));

	// 음악 객체
	Music introMusic = new Music("mainScreenMusic.mp3", true);

	// 현재 프로그램내에서 마우스의 X와 Y좌표를 받을수 있는 필드를 만든다.
	private int mouseX, mouseY;
	
	public static Game game;
	
	boolean isMainScreen = true;
	boolean isGameScreen = false;

	public Ghost() {
		// 배경음악 실행
		introMusic.start();
		// 메뉴바가 보이지 않게끔 설정
		setUndecorated(true);
		// 게임 이름 설정
		setTitle("Ghost");
		// 게임 창 크기 설정
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		// 창크기 변경 불가능 설정
		setResizable(false);
		// 게임 실행시 화면 정중앙에 뜨게끔 설정
		setLocationRelativeTo(null);
		// 게임 종료시 프로그램 종료가 되게끔 설정, 미설정시 게임이 종료되도 프로그램을 계속 실행된다.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 화면 출력, 기본값은 false 이므로 설정 해줘야한다.
		setVisible(true);
		// paintComponent로 그릴때 배경색을 회색으로 지정
		setBackground(new Color(0, 0, 0, 0));
		// 컨테이너의 크기가 변경될때 컴포넌트들의 크기와 위치가 자동적으로 변경되는데 그걸 해제한다.
		setLayout(null);

		// buttonSet 메소드를 통해서 버튼들을 넣어준다
		buttonSet(startButton, 93, 250, 339, 123);
		buttonSet(helpButton, 93, 392, 339, 123);
		buttonSet(exitButton, 93, 546, 339, 123);
		buttonSet(menuExitButton, 1215, 5, 50, 20);
		
		setFocusable(true);
		addKeyListener(new KeyListener());

		// startButton 이벤트처리
		startButton.addMouseListener(new MouseAdapter() {
			// 마우스가 버튼에 들어왓을때 이벤트 처리
			@Override
			public void mouseEntered(MouseEvent e) {
				// Entered이미지로 변경 시켜준다.
				startButton.setIcon(startButtonEntered);
				// 커서의 모양을 바꿔준다
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				// 효과음 재생
				Music menuEnteredMusic = new Music("menuEnteredMusic.mp3", false);
				menuEnteredMusic.start();
			}

			// 마우스가 버튼에 나갔을때 이벤트 처리
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasic);
				// 커서의 모양을 바꿔준다
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			// 버튼을 클릭했을때 이벤트 처리
			@Override
			public void mousePressed(MouseEvent e) {
				// 효과음 재생
				Music menuClickMusic = new Music("menuClickMusic.mp3", false);
				menuClickMusic.start();
				// 메인화면 음악은 꺼주고 게임음악을 튼다.
//				introMusic.close();
//				introMusic = new Music("gamePlayMusic.mp3", true);
//				introMusic.start();
				// 다른 화면은 안보이게 변경시킨다.
				startButton.setVisible(false);
				helpButton.setVisible(false);
				exitButton.setVisible(false);
				enterStart();
			}
		});

		// helpButton 이벤트처리
		helpButton.addMouseListener(new MouseAdapter() {
			// 마우스가 버튼에 들어왓을때 이벤트 처리
			@Override
			public void mouseEntered(MouseEvent e) {
				// Entered이미지로 변경 시켜준다.
				helpButton.setIcon(helpButtonEntered);
				// 커서의 모양을 바꿔준다
				helpButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				// 효과음 재생
				Music menuEnteredMusic = new Music("menuEnteredMusic.mp3", false);
				menuEnteredMusic.start();
			}

			// 마우스가 버튼에 나갔을때 이벤트 처리
			@Override
			public void mouseExited(MouseEvent e) {
				helpButton.setIcon(helpButtonBasic);
				// 커서의 모양을 바꿔준다
				helpButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			// 버튼을 클릭했을때 이벤트 처리
			@Override
			public void mousePressed(MouseEvent e) {
				// 효과음 재생
				Music menuClickMusic = new Music("menuClickMusic.mp3", false);
				menuClickMusic.start();
				// 게임 도움말 이벤트
			}
		});

		// exitButton 이벤트처리
		exitButton.addMouseListener(new MouseAdapter() {
			// 마우스가 버튼에 들어왓을때 이벤트 처리
			@Override
			public void mouseEntered(MouseEvent e) {
				// Entered이미지로 변경 시켜준다.
				exitButton.setIcon(exitButtonEntered);
				// 커서의 모양을 바꿔준다
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				// 효과음 재생
				Music menuEnteredMusic = new Music("menuEnteredMusic.mp3", false);
				menuEnteredMusic.start();
			}

			// 마우스가 버튼에 나갔을때 이벤트 처리
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasic);
				// 커서의 모양을 바꿔준다
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			// 버튼을 클릭했을때 이벤트 처리
			@Override
			public void mousePressed(MouseEvent e) {
				// 효과음 재생
				Music menuClickMusic = new Music("menuClickMusic.mp3", false);
				menuClickMusic.start();
				// 프로그램이 바로 꺼지지 않고 1초정도 있다가 꺼지게금 설정
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});

		// exitMenuButton 이벤트 처리
		menuExitButton.addMouseListener(new MouseAdapter() {
			// 마우스가 버튼에 들어왓을때 이벤트 처리
			@Override
			public void mouseEntered(MouseEvent e) {
				// Entered이미지로 변경 시켜준다.
				menuExitButton.setIcon(menuExitButtonEntered);
				// 커서의 모양을 바꿔준다
				menuExitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				// 효과음 재생
				Music menuEnteredMusic = new Music("menuEnteredMusic.mp3", false);
				menuEnteredMusic.start();
			}

			// 마우스가 버튼에 나갔을때 이벤트 처리
			@Override
			public void mouseExited(MouseEvent e) {
				menuExitButton.setIcon(menuExitButtonBasic);
				// 커서의 모양을 바꿔준다
				menuExitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			// 버튼을 클릭했을때 이벤트 처리
			@Override
			public void mousePressed(MouseEvent e) {
				// 효과음 재생
				Music menuClickMusic = new Music("menuClickMusic.mp3", false);
				menuClickMusic.start();
				// 프로그램이 바로 꺼지지 않고 1초정도 있다가 꺼지게금 설정
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});

		// backButton 이벤트처리
		backButton.addMouseListener(new MouseAdapter() {
			// 마우스가 버튼에 들어왓을때 이벤트 처리
			@Override
			public void mouseEntered(MouseEvent e) {
				// Entered이미지로 변경 시켜준다.
				backButton.setIcon(backButtonEntered);
				// 커서의 모양을 바꿔준다
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				// 효과음 재생
				Music menuEnteredMusic = new Music("menuEnteredMusic.mp3", false);
				menuEnteredMusic.start();
			}

			// 마우스가 버튼에 나갔을때 이벤트 처리
			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(backButtonBasic);
				// 커서의 모양을 바꿔준다
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			// 버튼을 클릭했을때 이벤트 처리
			@Override
			public void mousePressed(MouseEvent e) {
				// 효과음 재생
				Music menuClickMusic = new Music("menuClickMusic.mp3", false);
				menuClickMusic.start();
				introMusic.close();
				// 게임 도움말 이벤트
				if(game.getState() == State.RUNNABLE)
					game.interrupt();
				backMain();
			}
		});

		// test1Button 이벤트처리
		test1Button.addMouseListener(new MouseAdapter() {
			// 마우스가 버튼에 들어왓을때 이벤트 처리
			@Override
			public void mouseEntered(MouseEvent e) {
				// Entered이미지로 변경 시켜준다.
				test1Button.setIcon(test1ButtonEntered);
				// 커서의 모양을 바꿔준다
				test1Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
				// 효과음 재생
				Music menuEnteredMusic = new Music("menuEnteredMusic.mp3", false);
				menuEnteredMusic.start();
			}

			// 마우스가 버튼에 나갔을때 이벤트 처리
			@Override
			public void mouseExited(MouseEvent e) {
				test1Button.setIcon(test1ButtonBasic);
				// 커서의 모양을 바꿔준다
				test1Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			// 버튼을 클릭했을때 이벤트 처리
			@Override
			public void mousePressed(MouseEvent e) {
				// 효과음 재생
				Music menuClickMusic = new Music("menuClickMusic.mp3", false);
				menuClickMusic.start();
				gameStart();
			}
		});

		// test2Button 이벤트처리
		test2Button.addMouseListener(new MouseAdapter() {
			// 마우스가 버튼에 들어왓을때 이벤트 처리
			@Override
			public void mouseEntered(MouseEvent e) {
				// Entered이미지로 변경 시켜준다.
				test2Button.setIcon(test2ButtonEntered);
				// 커서의 모양을 바꿔준다
				test2Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
				// 효과음 재생
				Music menuEnteredMusic = new Music("menuEnteredMusic.mp3", false);
				menuEnteredMusic.start();
			}

			// 마우스가 버튼에 나갔을때 이벤트 처리
			@Override
			public void mouseExited(MouseEvent e) {
				test2Button.setIcon(test2ButtonBasic);
				// 커서의 모양을 바꿔준다
				test2Button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			// 버튼을 클릭했을때 이벤트 처리
			@Override
			public void mousePressed(MouseEvent e) {
				// 효과음 재생
				Music menuClickMusic = new Music("menuClickMusic.mp3", false);
				menuClickMusic.start();
				backGroundImage = new ImageIcon(getClass().getClassLoader().getResource("images/gameBackground.png")).getImage();
				// 메인화면 음악은 꺼주고 게임음악을 튼다.
				introMusic.close();
				introMusic = new Music("gamePlayMusic.mp3", true);
				introMusic.start();
				backButton.setVisible(false);
				test1Button.setVisible(false);
				test2Button.setVisible(false);

			}
		});



		// setBounds를 통해 위치와 크기를 지정해준다.
		menuBar.setBounds(0, 0, 1280, 30);
		// add를 하면 paintComponetns를 통해서 그려진다.
		add(menuBar);
		// menuBar를 마우스를 통해서 조작할수 있도록 이벤트처리를 해준다.
		menuBar.addMouseListener(new MouseAdapter() {
			// 마우스를 입력했을때 컴포넌트내의 마우스의 x좌표와 y좌표를 가져온다
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		// menuBar를 드래그 했을때 이벤트 처리를 해준다.
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			// 마우스를 입력했을때 스크린(모니터)내의 마우스의 x좌표와 y좌표를 가져온다
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				// 스크린내의 마우스의 좌표와 컴포넌트내의 마우스의 좌표의 차가 게임창의 위치이다.
				setLocation(x - mouseX, y - mouseY);
			}
		});
	}

	// 버튼 셋팅 메소드 모든 버튼마다 설정값을 넣기 귀찮으므로 메소드로 만들었다.
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

	// 하나의 약속된 즉 정의되어 있는 메소드이다.
	// paint 메소드는 JFrame을 상속한 클래스에서 가장 첫번째로 화면을 그려주는 메소드이다.
	public void paint(Graphics g) {
		// 1280 * 720 만큼의 이미지를 만들어서 변수에 대입
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		// screenImage 에서 그래픽값을 얻어서 변수에 대입
		screenGraphic = screenImage.getGraphics();
		// screenDraw 함수를 통해서 그래픽 값을 screenGraphic에 그린다.
		screenDraw((Graphics2D)screenGraphic);
		// screenImage 즉 screenDraw에서 그린 이미지를 화면에 띄워준다.
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics2D g) {
		// mainScreen을 0,0에 그려준다.
		g.drawImage(backGroundImage, 0, 0, null);
		if(isMainScreen){
			
		}
		if(isGameScreen) {
			game.screenDraw(g);
		}
		// g.drawImage는 역동적인 그림을 그릴때 사용하고
		// 항상 존재해야하는 그림은 paintComponents를 이용해서 그린다.
		paintComponents(g);
		// 다시 paint메소드를 호출한다
		this.repaint();
	}
	
	public void enterStart() {
		backGroundImage = new ImageIcon(getClass().getClassLoader().getResource("images/gamePlayImage.png")).getImage();
		buttonSet(backButton, 10, 30, 100, 40);
		buttonSet(test1Button, 460, 200, 350, 150);
		buttonSet(test2Button, 460, 450, 350, 150);
		backButton.setVisible(true);
		test1Button.setVisible(true);
		test2Button.setVisible(true);
		
	}

	public void backMain() {
		isMainScreen = true;
		backButton.setVisible(false);
		test1Button.setVisible(false);
		test2Button.setVisible(false);
		backGroundImage = new ImageIcon(getClass().getClassLoader().getResource("images/mainScreenResize.png")).getImage();
		startButton.setVisible(true);
		helpButton.setVisible(true);
		exitButton.setVisible(true);
		menuExitButton.setVisible(true);
		introMusic = new Music("mainScreenMusic.mp3", true);
		introMusic.start();
		isGameScreen = false;
	}
	
	public void gameStart() {
		isMainScreen = false;
		// 메인화면 음악은 꺼주고 게임음악을 튼다.
		introMusic.close();
		backButton.setVisible(true);
		test1Button.setVisible(false);
		test2Button.setVisible(false);
		backGroundImage = new ImageIcon(getClass().getClassLoader().getResource("images/gameBackground.png")).getImage();
		isGameScreen = true;
		game = new Game();
	}
}
