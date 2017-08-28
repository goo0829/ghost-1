package test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class LPanel extends JPanel {
	
	
	
	 @Override
	    protected void paintComponent(Graphics g) {
	        paintComponent((Graphics2D) g);
	    }
	
	
	public void paintComponent(Graphics2D g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.drawRect(30, 30, 100, 100);
		
	}
}
