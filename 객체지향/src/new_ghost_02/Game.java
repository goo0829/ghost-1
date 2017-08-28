package new_ghost_02;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import ghost_08.KeyListener;

public class Game extends JPanel implements Runnable {
	
	private Image backGroundImage;
	
	private Music gameMusic;
	
	private Main main;
	
	private Character character;
	private Monster monster;
	private ArrayList<Barrier> barrierList = new ArrayList<Barrier>();
	private ArrayList<Monster> monsterList = new ArrayList<Monster>();
	
	public Game(Main main) {
		this.main = main;
		setLayout(null);
		gameMusic = new Music("gamePlayMusic.mp3", true);
		gameMusic.start();
		backGroundImage = new ImageIcon(getClass().getClassLoader().getResource("images/gameBackground.png")).getImage();
		character = new Character(100, 100);
		add(character);
		monsterList.add(new Monster(500, 500));
		add(monsterList.get(0));
		
		barrierList.add(new Barrier(500, 0, "B"));
		barrierList.add(new Barrier(600, 0, "B"));
		barrierList.add(new Barrier(700, 0, "B"));
		add(barrierList.get(0));
		add(barrierList.get(1));
		add(barrierList.get(2));
		barrierList.get(0).setBounds(barrierList.get(0).x, barrierList.get(0).y, 60, 300);
		barrierList.get(1).setBounds(barrierList.get(1).x, barrierList.get(1).y, 60, 300);
		barrierList.get(2).setBounds(barrierList.get(2).x, barrierList.get(2).y, 60, 300);
		
		
		
		Thread thread = new Thread(this);
		thread.start();
		character.charThread.start();
		monsterList.get(0).thread.start();
		
		setFocusable(true);
		addKeyListener(new KeyListener());
		
	}
	
	public void run() {
		try {
			while(true) {
				character.setBounds(character.x, character.y, 50, 50);
				monsterList.get(0).setBounds(monsterList.get(0).x, monsterList.get(0).y, 50, 50);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backGroundImage, 0, 0, null);
	}
}
