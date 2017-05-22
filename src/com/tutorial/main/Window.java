package com.tutorial.main;

import java.awt.Canvas;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas{

	private static final long serialVersionUID = -240840600533728354L;

	public  Window(int width,int height, String title, Game game){
			JFrame frame = new JFrame(title);  //the frame of the window
			
			frame.setPreferredSize(new Dimension(width, height));//recalling or reffering
			frame.setMaximumSize(new Dimension(width, height));//back to JFrame
			frame.setMinimumSize(new Dimension(width, height));//call
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//working exit button
			frame.setResizable(false);// can you resize the window, NO,
			frame.setLocationRelativeTo(null);//null lets it start the middle of screen, not needed
			frame.add(game);// Adds game class into the frame
			frame.setVisible(true);//setting the frame to visible, we can see it
			game.start();// Running the start method
			
	
	}
}
