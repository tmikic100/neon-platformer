package com.tmikic.neon.window;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class menu {
	
	Handler handler ;
	camera cam;

	public Rectangle playButton = new Rectangle(game.WIDTH / 2 , 150, 100, 50);
	public Rectangle helpButton = new Rectangle(game.WIDTH / 2 , 250, 100, 50);
	public Rectangle quitButton = new Rectangle(game.WIDTH / 2 , 350, 100, 50);
	
	

	public void render(Graphics g){
		cam = new camera(0, 0);
		handler = new Handler(cam);
		Graphics2D g2d = (Graphics2D) g;
		Font fnt0 = new Font("arial", Font.BOLD, 50);
		g.setFont(fnt0);
		g.setColor(Color.white);
		g.drawString("NEON PLATFORMER", game.WIDTH / 2 /2 , 100);
		g.setColor(Color.yellow);
		g2d.fill(playButton);
		g2d.fill(helpButton);
		g2d.fill(quitButton);
		
		
		Font fnt1 =new Font("arial", Font.BOLD, 30);
		g.setFont(fnt1);
		g.setColor(Color.red);
		g.drawString("play", playButton.x + 19, playButton.y + 30);
		g.setColor(Color.blue);
		g.drawString("help", helpButton.x + 19, helpButton.y + 30);
		g.setColor(Color.magenta);
		g.drawString("quit", quitButton.x + 19, quitButton.y + 30);
		g.setColor(Color.white);
		
		
	}
	
}
