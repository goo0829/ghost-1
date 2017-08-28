package test;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class Main extends JFrame {
	
	Container contentPane;
	
	public Main() {
		setTitle("Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		
		LPanel lp = new LPanel();
		contentPane.add(lp, BorderLayout.CENTER);
		setSize(250, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Main();

	}

}
