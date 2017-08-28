package ghost_07;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

public class Game extends Thread{

	public GhostCharacter ghostCharacter;
	public ArrayList<Monster> monsterList = new ArrayList<Monster>();
	public ArrayList<Barrier> barrierList = new ArrayList<Barrier>();

	public boolean playStop;

	Random rd = new Random();

	public Music gameMusic;

	public final int monsterNum = 2;
	public final int barrierNum = 5;

	public Game() {
		playStop = true;
		gameMusic = new Music("gamePlayMusic.mp3", true);
		gameMusic.start();
		ghostCharacter = new GhostCharacter(100 , 100);

		barrierList.add(new Barrier(320, 0, "B"));
		barrierList.add(new Barrier(640, 0, "B"));
		barrierList.add(new Barrier(960, 0, "B"));
		barrierList.add(new Barrier(160, 420, "B"));
		barrierList.add(new Barrier(480, 420, "B"));
		barrierList.add(new Barrier(800, 420, "B"));
		barrierList.add(new Barrier(1120, 420, "B"));

		for(int i = 0; i < monsterNum; i++){
			monsterList.add(new Monster(rd.nextInt(1200), rd.nextInt(620)));
		}

		ghostCharacter.start();
		ghostCharacter.gameStart = true;

		this.start();
		

	}

	public void run() {
		try{
			for(int i = 0; i < monsterList.size(); i++){
				monsterList.get(i).start();
			}
			while(playStop) {
				boolean stop = false;
				for(int i = 0; i < monsterList.size(); i++) {
					if(ghostCharacter.ghostR.intersects(monsterList.get(i).monsterR)){
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
			ghostCharacter.ghostCharacterStop();

			gameMusic.close(); 
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}


	public void screenDraw(Graphics2D g) {

		for(int i = 0; i < monsterList.size(); i++){
			g.drawImage(monsterList.get(i).getBasicImage(), monsterList.get(i).x, monsterList.get(i).y, null);
		}
		for(int i = 0; i < barrierList.size(); i++) {
			g.drawImage(barrierList.get(i).getBarrierImage(), barrierList.get(i).x, barrierList.get(i).y, null);
		}
		ghostCharacter.screenDraw(g);
	}

	public void endGame() {

	}


}
