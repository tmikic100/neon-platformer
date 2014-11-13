package com.tmikic.neon.objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.tmikic.neon.framework.Gameobject;
import com.tmikic.neon.framework.Objectid;
import com.tmikic.neon.textures.texture;
import com.tmikic.neon.window.game;

public class door extends Gameobject{
	texture tex = game.getInstance();
	public door(float x, float y, Objectid id) {
		super(x, y, id);
		
	}

	@Override
	public void tick(LinkedList<Gameobject> object) {
		
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(tex.Door[0], (int)x,(int) y, null);;
	}

	@Override
	public Rectangle getBounds() {
		
		return new Rectangle((int)x,(int)y,32,32);
	}

}
