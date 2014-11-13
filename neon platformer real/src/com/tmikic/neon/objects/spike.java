package com.tmikic.neon.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Random;

import com.tmikic.neon.framework.Gameobject;
import com.tmikic.neon.framework.Objectid;
import com.tmikic.neon.textures.texture;
import com.tmikic.neon.window.BufferedImageLoader;
import com.tmikic.neon.window.Handler;
import com.tmikic.neon.window.camera;
import com.tmikic.neon.window.game;

public class spike extends Gameobject{
	texture tex = game.getInstance();
	Random rand = new Random();
	int color = rand.nextInt(4);
	private Handler handler;
	private camera cam;
	private BufferedImage level2 = null, level = null,level3 = null,level4 = null;
	

	public spike(float x, float y,Objectid id) {
		super(x, y, id);
		
		
	}

	
	
	public void tick(LinkedList<Gameobject> object) 
	{
		
	}

	
	public void render(Graphics g) 
	{
		g.drawImage(tex.Spike[0], (int)x,(int) y, null);
	    
	}


	public Rectangle getBounds() {
	return new Rectangle((int)x,(int)y,32,32);
	}
}

