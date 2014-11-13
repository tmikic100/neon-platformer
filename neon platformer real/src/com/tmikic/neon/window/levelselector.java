package com.tmikic.neon.window;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class levelselector {
	public static int llevel1 = 0;
	public static int llevel2 = 0;
	
	public Rectangle cButton = new Rectangle(game.WIDTH / 2 - 100, 150, 200, 50);
	public Rectangle level1Button = new Rectangle(game.WIDTH / 2 -350 , 250, 200, 50);
	public Rectangle level2Button = new Rectangle(game.WIDTH / 2 - 350, 350, 200, 50);
	public Rectangle level3Button = new Rectangle(game.WIDTH / 2 - 100, 250, 200, 50);
	public Rectangle level4Button = new Rectangle(game.WIDTH / 2 - 100, 350, 200, 50);
	public Rectangle level5Button = new Rectangle(game.WIDTH / 2 + 150, 250, 200, 50);
	public Rectangle mainButton = new Rectangle(game.WIDTH / 2 - 100, 450, 200, 50);
	
	
	

	public void render(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		Font fnt0 = new Font("arial", Font.BOLD, 50);
		g.setFont(fnt0);
		g.setColor(Color.white);
		g.drawString("level selector", game.WIDTH / 2 - 150 , 100);
		g.setColor(Color.YELLOW);
		g2d.fill(cButton);
		g2d.fill(level1Button);
		g2d.fill(level2Button);
		g2d.fill(level3Button);
		g2d.fill(level4Button);
		g2d.fill(level5Button);
		g2d.fill(mainButton);
		
		
		Font fnt1 =new Font("arial", Font.BOLD, 30);
		g.setFont(fnt1);
		g.setColor(Color.red);
		g.drawString("continue", cButton.x + 35, cButton.y + 30);
		g.drawString("level 1", level1Button.x + 19 + 35, level1Button.y + 30);
		
		g.drawString("level 2", level2Button.x + 19 + 35, level2Button.y + 30);
		g.drawString("level 3", level3Button.x + 19 + 35, level3Button.y + 30);
		g.drawString("level 4", level4Button.x + 19 + 35, level4Button.y + 30);
		g.drawString("level 5", level5Button.x + 19 + 35, level5Button.y + 30);
		g.drawString("main menu", mainButton.x + 19, mainButton.y + 30);
		g.setColor(Color.white);
		
	}
	
}
