package new_ghost_01;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Game extends JPanel implements Runnable {
	
	private Image backGroundImage = new ImageIcon(getClass().getClassLoader().getResource("images/gameBackground.png")).getImage();
	
	private GhostCharacter ghostCharacter;
	private ArrayList<Monster> monsterList = new ArrayList<Monster>();
	private ArrayList<Barrier> barrierList = new ArrayList<Barrier>();

	private boolean playStop;

	Random rd = new Random();

	private Music gameMusic;

	private final int monsterNum = 2;
	private final int barrierNum = 5;

	private Thread game;
	
	private Main main;
	
	private KeyListener key;
	
	
	public Game(Main main) {
		this.main = main;
		setLayout(null);
		playStop = true;
		gameMusic = new Music("gamePlayMusic.mp3", true);
		gameMusic.start();
		ghostCharacter = new GhostCharacter(100 , 100, this);
		
		
		
		barrierList.add(new Barrier(320, 0, "B"));
		barrierList.add(new Barrier(640, 0, "B"));
		barrierList.add(new Barrier(960, 0, "B"));
		barrierList.add(new Barrier(160, 420, "B"));
		barrierList.add(new Barrier(480, 420, "B"));
		barrierList.add(new Barrier(800, 420, "B"));
		barrierList.add(new Barrier(1120, 420, "B"));

		for(int i = 0; i < monsterNum; i++){
			monsterList.add(new Monster(rd.nextInt(1200), rd.nextInt(620), this));
		}

		ghostCharacter.start();
		ghostCharacter.setGameStart(true);

		game = new Thread(this);
		game.start();
		
		setFocusable(true);
		key = new KeyListener();
		addKeyListener(key);
		
	}

	public void run() {
		System.out.println("GAME Start!");
		try{
			for(int i = 0; i < monsterList.size(); i++){
				monsterList.get(i).start();
			}
			while(playStop) {
				boolean stop = false;
				if(key.isUP() == true) {
					ghostCharacter.setX(ghostCharacter.getX() + ghostCharacter.getSpeed());
				}
				if(key.isDOWN() == true) {
					ghostCharacter.setX(ghostCharacter.getX() + ghostCharacter.getSpeed());
				}
				if(key.isLEFT() == true) {
					ghostCharacter.setX(ghostCharacter.getX() + ghostCharacter.getSpeed());
				}
				if(key.isRIGHT() == true) {
					ghostCharacter.setX(ghostCharacter.getX() + ghostCharacter.getSpeed());
				}
				for(int i = 0; i < monsterList.size(); i++) {
					if(getGhostCharacter().getGhostR().intersects(monsterList.get(i).getMonsterR())){
						stop = true;
						break;
					}
				}
				if(stop) break;
				
				Thread.sleep(5);
			}
			for(int j = 0; j < monsterList.size(); j++){
				monsterList.get(j).monsterStop();
			}
			getGhostCharacter().ghostCharacterStop();

			gameMusic.close(); 
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		paintComponent((Graphics2D)g);
	}
	
	public void paintComponent(Graphics2D g) {
		g.drawImage(backGroundImage, 0, 0, null);
		g.drawImage(ghostCharacter.getGhostBasicImage(), ghostCharacter.getX(), ghostCharacter.getY(), null);
		for(int i = 0; i < monsterList.size(); i++) {
			g.drawImage(monsterList.get(i).getMonsterBasicImage(), monsterList.get(i).getX(), monsterList.get(i).getY(), null);
		}
		for(int i = 0; i < barrierList.size(); i++) {
			g.drawImage(barrierList.get(i).getBarrierImage(), barrierList.get(i).getX(), barrierList.get(i).getY(), null);
		}
	}

	public ArrayList<Monster> getMonsterList() {
		return monsterList;
	}

	public void setMonsterList(ArrayList<Monster> monsterList) {
		this.monsterList = monsterList;
	}

	public GhostCharacter getGhostCharacter() {
		return ghostCharacter;
	}

	public void setGhostCharacter(GhostCharacter ghostCharacter) {
		this.ghostCharacter = ghostCharacter;
	}

	public ArrayList<Barrier> getBarrierList() {
		return barrierList;
	}

	public void setBarrierList(ArrayList<Barrier> barrierList) {
		this.barrierList = barrierList;
	}
		
}
