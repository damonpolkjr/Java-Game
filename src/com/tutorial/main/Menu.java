package com.tutorial.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.tutorial.main.Game.STATE;

public class Menu extends MouseAdapter{
	
	private static final GameObject MenuParticle = null;
	private Game game;
	private Handler handler;
	private Random r = new Random();
	private HUD hud;
	
	public Menu(Game game, Handler handler, HUD hud){
		this.game = game;
		this.hud = hud;
		this.handler = handler;
	}
	
	
	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		
		
		if(game.gameState == STATE.Menu){
			
			//Play Button
			if(mouseOver(mx, my, 210 , 150 , 200 , 64 )){
			 game.gameState = STATE.Game;
			 handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
			 handler.clearEnemys();
	         handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
			}
			
			//help button
			if(mouseOver(mx , my , 210 , 250 , 200 , 64)){
				game.gameState = STATE.Help;
		
		}
			
			//Quit Button
			if(mouseOver(mx , my, 210 , 350 , 200 , 64)){
				System.exit(1);
			}
			
		}
		
	
		//back button for help 
				if(game.gameState == STATE.Help){
					if(mouseOver(mx , my , 210 , 350 , 200 , 64)){
						game.gameState = STATE.Menu;
						return;
			
			
				}
				
		}
					//Try again button
				if(game.gameState == STATE.End){
					if(mouseOver(mx , my , 210 , 350 , 200 , 64)){
						game.gameState = STATE.Game;
						 hud.setLevel(1);
                    	 hud.setScore(0);
						 handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
						 handler.clearEnemys();
				         handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
				
					
				}
						
			
			}
	
	}
		
	public void mouseReleased(MouseEvent e){
		
	}
	
	private boolean mouseOver(int mx, int my,int x, int y, int width, int height){
		if(mx > x && mx < x + width){
			if(my > y && my < y + height){
				return true;
			}else return false;
			
		}else return false;
	}
	
	public void tick(){
		
	}

	
	public void render(Graphics g){
		if(game.gameState == STATE.Menu){
			Font fnt = new Font("arial" , 1 , 50);
			Font fnt2 = new Font("arial", 1 , 50);
			
			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.drawString("Survival", 210, 70);
			
			g.setFont(fnt2);
			g.drawRect(210, 150, 200, 64);
			g.drawString("Play", 260, 200);

			g.drawRect(210, 250, 200, 64);
			g.drawString("Help", 260, 300);
			
			
			g.drawString("Quit", 260, 390);
			g.drawRect(210, 340, 200, 64);
			
			
		}else if (game.gameState == STATE.Help){
			
			Font fnt = new Font("arial" , 1 , 50);
			Font fnt2 = new Font("arial", 1 , 50);
			Font fnt3 = new Font("TimeNewRoman", 1, 30);
			
			g.setFont(fnt);
			
			g.setColor(Color.WHITE);
			g.drawString("Help", 250, 70);
			
			g.setFont(fnt2);
			g.drawString("W", 280, 120);
			g.setFont(fnt3);
			g.drawString("Press W to go forward", 170, 150);
			
			g.setFont(fnt2);
			g.drawString("S", 290, 340);
			g.setFont(fnt3);
			g.drawString("Press S to go down", 180, 300);

			
			g.setFont(fnt2);
			g.drawString("A", 100, 200);
			g.setFont(fnt3);
			g.drawString("Press A to go left", 10, 230);

			
			g.setFont(fnt2);
			g.drawString("D", 485, 210);
			g.setFont(fnt3);
			g.drawString("Press D to go to right", 330, 240);

			
			g.setFont(fnt2);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Back", 250, 400);
			
			
		}else if (game.gameState == STATE.End){
			
			Font fnt = new Font("arial" , 1 , 20);
			Font fnt2 = new Font("arial", 1 , 20);
			
			
			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.drawString("Game Over", 250, 70);
			
			g.setFont(fnt);
			g.drawString("You lost with a score of: " + hud.getScore(), 170, 200);
			
			g.setFont(fnt2);
			g.drawRect(250, 360, 130 , 50);
			g.drawString("Try Again", 270 , 390 );
		}
	}
}
