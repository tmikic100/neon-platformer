package com.tmikic.neon.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Random;

import com.tmikic.neon.framework.Gameobject;
import com.tmikic.neon.framework.Objectid;

public class block extends Gameobject{
	Random rand = new Random();
	int color = rand.nextInt(4);

	public block(float x, float y, Objectid id) {
		super(x, y, id);
		
	}

	
	
	public void tick(LinkedList<Gameobject> object) 
	{
		
	}

	
	public void render(Graphics g) 
	{
	   if (color == 0){
	   g.setColor(Color.blue);
	   g.drawRect((int)x,(int) y, 32, 32);
	   }else if (color == 1){
		   g.setColor(Color.red);
		   g.drawRect((int)x,(int) y, 32, 32);
	   }else if (color == 2){
		   g.setColor(Color.orange);
		   g.drawRect((int)x,(int) y, 32, 32);
	   }
	   else if (color == 3){
		   g.setColor(Color.yellow);
		   g.drawRect((int)x,(int) y, 32, 32);
	   }
	   
	   
	}


	public Rectangle getBounds() {
	return new Rectangle((int)x,(int)y,32,32);
	}
}
