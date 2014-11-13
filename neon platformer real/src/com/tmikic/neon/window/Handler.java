package com.tmikic.neon.window;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Random;

import com.tmikic.neon.framework.Gameobject;
import com.tmikic.neon.framework.Objectid;
import com.tmikic.neon.objects.block;
import com.tmikic.neon.objects.door;
import com.tmikic.neon.objects.flag;
import com.tmikic.neon.objects.key;
import com.tmikic.neon.objects.player;
import com.tmikic.neon.objects.snow;
import com.tmikic.neon.objects.spike;


public class Handler 
{

	public LinkedList<Gameobject> object = new LinkedList<Gameobject>();
	
	private Gameobject tempObject;
	
	private camera cam;
	public static int Level = 1;
	
	
	
	private BufferedImage level2 = null, level = null,level3 = null,level4 = null,level5 = null;
	private player player;
	Random r = new Random();
	public Handler(camera cam){
		this.cam = cam;
		BufferedImageLoader loader = new BufferedImageLoader();
	    level =loader.loadImage("/level_1.png");
	    level2 = loader.loadImage("/level_2.png");
	    level3 =loader.loadImage("/level_3.png");
	    level4 =loader.loadImage("/level_4.png");
	    level5 =loader.loadImage("/level_5.png");
	}
	
	public void tick()
	{
	     for(int i = 0; i < object.size(); i++)
	     {
	    	 tempObject = object.get(i);
	    	 
	    	 tempObject.tick(object);
	     }	
	}

	public void render(Graphics g)
	{
	     for(int i = 0; i < object.size(); i++)
	     {
	    	 tempObject = object.get(i);
	    	 
	    	 tempObject.render(g);
	     }	
	}
	public void spawnsnow(int snow_count, int blocks){
		addobject(new snow(r.nextInt(32 * (blocks * 2)),-64,Objectid.Snow));
		
	}
	public void  clearlevel(){
		object.clear();
	}
	
	public void addobject(Gameobject object){
		this.object.add(object);
	}
	
	public void removeobject(Gameobject object){
		this.object.remove(object);
	}
	public void LoadImagelevel(BufferedImage image){
		int w = image.getWidth();
		int h = image.getHeight();
		
		System.out.println("width, height: " + w + " " + h);
		
		for(int xx = 0; xx < h;xx++){
			for(int yy = 0;yy < w; yy++){
				int pixel = image.getRGB(xx, yy);
				int red = (pixel >> 16)& 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				

				if(red == 255 && green == 255 & blue == 255) addobject(new block(xx*32, yy*32, Objectid.block)); 
				if(red == 128 && green == 128 & blue == 128) addobject(new spike(xx*32, yy*32, Objectid.Spike));
				if(red == 128 && green == 128 & blue == 131) addobject(new spike(xx*32, yy*32, Objectid.Spike2));
				if(red == 128 && green == 128 & blue == 132) addobject(new spike(xx*32, yy*32, Objectid.Spike3)); 
			    if(red == 0 && green == 0 & blue == 255) addobject(new player(xx*32, yy*32, this,cam, Objectid.player));
			    if(red == 255 && green == 255 & blue == 0) addobject(new flag(xx*32, yy*32, Objectid.flag));
			    if(red == 110 && green == 110 & blue == 0) addobject(new key(xx*32, yy*32, Objectid.Key));
			    if(red == 128 && green == 50 & blue == 0) addobject(new door(xx*32, yy*32, Objectid.Door));
			    if(red == 255 && green == 0 & blue == 0) addobject(new block(xx*32, yy*32, Objectid.block));
			   
              }
		}
}
	public void switchlevel(){
		clearlevel();
		cam.setx(0);
		
		
		
		
		switch(game.Level){
		    case 1:
			    LoadImagelevel(level2);
			    Level = 2;
			    break;
		    case 2:
		    	LoadImagelevel(level3);
		    	Level = 3;
		    	break;
		    case 3:
		    	
		    	LoadImagelevel(level4);
		    	Level = 4;
		    	break;
		    case 4:
		    	LoadImagelevel(level5);
		    	Level = 5;
		    	break;
		    case 5:	
		    	game.State = game.State.MENU;
                break;
				
		}
		game.Level ++;
	    game.snow_count = 1;
		
	
	
}
public void restartlevel(int Level){
		
		
		
		if(Level == 1){
			clearlevel();
		    LoadImagelevel(level);
		}else if(Level == 2){
			clearlevel();
			LoadImagelevel(level2);
		}else if(Level == 3){
			clearlevel();
			LoadImagelevel(level3);
		}else if(Level == 4){
			clearlevel();
			LoadImagelevel(level4);
		}else if(Level == 5){
			clearlevel();
			LoadImagelevel(level5);
		}
		
	}


	
	public void cleardoor(Gameobject object){
		removeobject(object);
	}

		
}

