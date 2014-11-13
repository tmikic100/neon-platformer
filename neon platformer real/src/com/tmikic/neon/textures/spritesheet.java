package com.tmikic.neon.textures;

import java.awt.image.BufferedImage;

public class spritesheet {

	private BufferedImage image;
	
	public spritesheet(BufferedImage image){
		this.image = image;
	}
	
	public BufferedImage grabImage(int width, int height){
		BufferedImage img = image.getSubimage(0, 0, width, height);
		return img;
	}
	
}
