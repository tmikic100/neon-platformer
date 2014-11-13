package com.tmikic.neon.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.tmikic.neon.framework.Gameobject;
import com.tmikic.neon.framework.Objectid;

public class flag extends Gameobject{

	public flag(float x, float y, Objectid id) {
		super(x, y, id);
		
	}

	
	public void tick(LinkedList<Gameobject> object) 
	{
		
	}

	
	public void render(Graphics g) 
	{
	   g.setColor(Color.white);
	   g.drawRect((int)x,(int) y, 32, 32);
	}


	public Rectangle getBounds() {
	return new Rectangle((int)x,(int)y,32,32);
	}
}


