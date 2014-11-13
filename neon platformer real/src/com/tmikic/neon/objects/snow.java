package com.tmikic.neon.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Random;

import com.tmikic.neon.framework.Gameobject;
import com.tmikic.neon.framework.Objectid;
import com.tmikic.neon.window.game;


public class snow extends Gameobject{
	private float gravity = 0.5f;
	
	Random r =new Random();
	private final float MAX_SPEED = (float) (r.nextInt((int) 2.5)+1);
	public snow(float x, float y, Objectid id) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick(LinkedList<Gameobject> object) {
		// TODO Auto-generated method stub
		y += vely;
		x += velx;
		
		if(falling || jumping)
		{
		     vely += gravity;
		     
		     if(vely > MAX_SPEED){
		    	 vely=MAX_SPEED;
		     }
		     if(y > game.HEIGHT){
		    	 x =  x = r.nextInt(game.WIDTH);
		    	 y = 0;
		     }
		}
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int)x+16,(int) y, 8, 8);
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x,(int)y,8,8);
	}

}
