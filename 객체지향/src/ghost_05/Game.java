package ghost_05;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class Game extends Thread{
	
	public GhostCharacter ghostCharacter;
	
	
	ArrayList<Monster> monsterList = new ArrayList<Monster>();
	
	private Music gameMusic;
	
	public final int monsterNum = 1;
	
	public Game() {
		gameMusic = new Music("gamePlayMusic.mp3", true);
		gameMusic.start();
		ghostCharacter = new GhostCharacter(100 , 100);
		ghostCharacter.start();
		
		for(int i = 0; i < monsterNum; i++){
			monsterList.add(new Monster());
		}
		for(int i = 0; i < monsterList.size(); i++){
			monsterList.get(i).start();
		}
		
		this.start();
		
	}
	
	public void run() {
		try{
			while(true) {
				System.out.println(this.getState());
				System.out.println(ghostCharacter.getState());
				System.out.println(monsterList.get(0).getState());
				boolean re = false;
				for(int i = 0; i < monsterList.size(); i++) {
					System.out.println(ghostCharacter.ghostR + "     " + monsterList.get(i).monsterR);
					if(ghostCharacter.ghostR.intersects(monsterList.get(i).monsterR)){
						for(int j = 0; j < monsterList.size(); j++){
							monsterList.get(j).monsterStop();
						}
						ghostCharacter.ghostCharacterStop();
						if(this.getState() == Thread.State.TERMINATED)
							System.out.println("Bye");
						re = true;
						
						break;
					}
				}
				
				if(re) {
					gameMusic.close();
					break; 
				}
				Thread.sleep(5);
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	

	public void screenDraw(Graphics2D g) {
		
		for(int i = 0; i < monsterList.size(); i++){
			g.drawImage(monsterList.get(i).getBasicImage(), monsterList.get(i).x, monsterList.get(i).y, null);
		}
		ghostCharacter.screenDraw(g);
	}
	
	public void endGame() {
		
	}
	
	
}
