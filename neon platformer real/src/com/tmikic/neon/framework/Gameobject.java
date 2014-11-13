package com.tmikic.neon.framework;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public abstract class Gameobject 
{
	
	
	public float x;
	public float y;
	protected Objectid id;
	protected float velx = 0, vely = 0;
	protected boolean falling = true;
	protected boolean jumping = false;
	
	public Gameobject(float x, float y, Objectid id)
	{
		this.x = x;
		this.y = y;
		this.id = id;
	}
   
	public abstract void tick(LinkedList<Gameobject> object);
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	public float getx(){
		return x;
		
	}
	public float gety(){
		return y;
		
	}
	public void setx(float x){
		this.x = x;
	}
	public void sety(float y){
		this.y = y;
	}
	public float getvelx(){
		return velx;
	}
	public float getvely(){
		return vely;
		
	}
	public void setvelx(float velx){
		this.velx = velx;
	}
	public void setvely(float vely){
		this.vely = vely;
	}
	
	public Objectid getId(){
		return id;
	}
	public boolean isFalling() {
		return falling;
	}

	public void setFalling(boolean falling) {
		this.falling = falling;
	}

	public boolean isJumping() {
		return jumping;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}

}
