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
	
	public final int monsterNum = 7;
	public final int barrierNum = 7;
	
	public Game() {
		playStop = true;
		gameMusic = new Music("gamePlayMusic.mp3", true);
		gameMusic.start();
		ghostCharacter = new GhostCharacter(100 , 100);
		
//		for(int i = 0; i < monsterNum; i++){
//			monsterList.add(new Monster(rd.nextInt(1200), rd.nextInt(620)));
//		}
		
//		for(int i = 0; i < barrierNum; i++) {
//			barrierList.add(new Barrier(rd.nextInt(1200), rd.nextInt(620)));
//		}
		
		for(int i = 0, addX = 150, addY; i < monsterNum; i++){
	         
	         if(i % 2 == 0){
	            addY = 300;
	         }   
	         else addY = 0;
	         
	         monsterList.add(new Monster(rd.nextInt(150) + addX, rd.nextInt(300) + addY));
	         
	         addX += 150;
	      }
	      
	      for(int i = 0, addX = 0, addY; i < barrierNum; i++) {
	         
	         if(i % 2 == 0)   addY = 300;
	         else addY = 0;
	         
	         barrierList.add(new Barrier(rd.nextInt(150) + addX, rd.nextInt(300)+addY));
	         
	         addX += 150;
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
//				System.out.println(this.getState());
//				System.out.println(ghostCharacter.getState());
//				System.out.println(monsterList.get(0).getState());
				boolean re = false;
				for(int i = 0; i < monsterList.size(); i++) {
//					System.out.println(ghostCharacter.ghostR + "     " + monsterList.get(i).monsterR);
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
		for(int i = 0; i < barrierList.size(); i++) {
			g.drawImage(barrierList.get(i).getBarrierImage(), barrierList.get(i).x, barrierList.get(i).y, null);
		}
		ghostCharacter.screenDraw(g);
	}
	
	public void endGame() {
		
	}
	
	
}
