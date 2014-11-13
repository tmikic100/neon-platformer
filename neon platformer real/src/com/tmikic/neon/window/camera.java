package com.tmikic.neon.window;

import com.tmikic.neon.framework.Gameobject;

public class camera{

	float x;
	float y;
	
	public camera(float x, float y){
		this.x = x;
		this.y = y;
	}
	public void tick(Gameobject player){
		x = -player.getx() + game.WIDTH/2;
		y = -player.gety() + game.HEIGHT/2-100;
	}
	public void setx(float x){
		this.x = x;
	}
	public void sety(float y){
		this.y = y;
	}
	public float getx(){
		return x;
	}
	public float gety(){
		return y;
	}
	
}
