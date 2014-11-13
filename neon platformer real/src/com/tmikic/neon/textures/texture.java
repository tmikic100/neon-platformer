package com.tmikic.neon.textures;

import java.awt.image.BufferedImage;

import com.tmikic.neon.window.BufferedImageLoader;

public class texture {

	spritesheet ss;
	spritesheet ds;
	spritesheet ks;
	private BufferedImage spike = null;
	private BufferedImage door = null;
	private BufferedImage key = null;
	
	public BufferedImage[] Spike = new BufferedImage[1];
	public BufferedImage[] Door = new BufferedImage[1];
	public BufferedImage[] Key = new BufferedImage[1];
	public texture(){
		BufferedImageLoader loader = new BufferedImageLoader(); 
		try{
			spike = loader.loadImage("/spikes.png");
			door = loader.loadImage("/door.png");
			key = loader.loadImage("/key.png");
		}catch(Exception e){
			e.printStackTrace();
		}
		ss = new spritesheet(spike);
		ds = new spritesheet(door);
		ks = new spritesheet(key);
		getTextures();
	}

	private void getTextures() {
		
		Spike[0] = ss.grabImage(32, 32);
		Door[0] = ds.grabImage(32, 32);
		Key[0] = ks.grabImage(32, 32);
	}
	
}
