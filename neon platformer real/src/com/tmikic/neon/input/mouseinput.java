package com.tmikic.neon.input;


import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.image.BufferedImage;

import com.tmikic.neon.window.BufferedImageLoader;
import com.tmikic.neon.window.Handler;
import com.tmikic.neon.window.camera;
import com.tmikic.neon.window.game;
import com.tmikic.neon.window.levelselector;

public class mouseinput implements MouseListener {
	
	
	private BufferedImage level2 = null, level = null;
	
	
	
	private static MouseEvent mouseClicked;
	private static MouseEvent mousePressed;
	private static MouseEvent mouseReleased;
	private static MouseEvent mouseMoved;
	private static MouseEvent mouseDragged;
	private static MouseEvent mouseEntered;
	private static MouseEvent mouseExited;
	private static MouseWheelEvent mouseWheelMoved;
	Handler handler;
	camera cam;
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		mouseClicked = e;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		BufferedImageLoader loader = new BufferedImageLoader();
	   
		cam = new camera(0,0);
	handler = new Handler(cam);	
	
    if(game.State == game.State.MENU){
	  /*public Rectangle playButton = new Rectangle(game.WIDTH / 2 , 150, 100, 50);
		public Rectangle helpButton = new Rectangle(game.WIDTH / 2 , 250, 100, 50);
		public Rectangle quitButton = new Rectangle(game.WIDTH / 2 , 350, 100, 50);*/
		int mx = e.getX();
		int my = e.getY();
		 
		if (mx >= game.WIDTH / 2 && mx <= game.WIDTH / 2 + 100)
		{
		    if(my >= 150 && my <= 200)
		    {
		    	game.State = game.State.levelsel;
		   
		    }
		}
		 
		if (mx >= game.WIDTH / 2 && mx <= game.WIDTH / 2 + 100)
		{
		    if(my >= 350 && my <= 400)
		    {
		    	System.exit(1);
		    }
		}
    }else
    if(game.State == game.State.levelsel){
  	  /*public Rectangle level1Button = new Rectangle(game.WIDTH / 2 - 100 , 150, 200, 50);
	public Rectangle level2Button = new Rectangle(game.WIDTH / 2 - 100, 250, 200, 50);
	public Rectangle mainButton = new Rectangle(game.WIDTH / 2 - 100, 350, 200, 50);
	*/
  		int mx = e.getX();
  		int my = e.getY();
  		 
  		if (mx >= game.WIDTH / 2 - 100 && mx <= game.WIDTH / 2 + 100)
  		{
  		    if(my >= 150 && my <= 200)
  		    {
  		    	game.State = game.STATE.GAME;
  		    }
  		}
  		if (mx >= game.WIDTH / 2 - 350 && mx <= game.WIDTH / 2 - 150)
  		{
  		    if(my >= 250 && my <= 300)
  		    {
  		    	game.State = game.STATE.GAME;
  		    	game.llevel1 = 1;
  		    	handler.Level = 1;
  		    }
  		}
  		if (mx >= game.WIDTH / 2 - 350 && mx <= game.WIDTH / 2 - 150)
  		{
  		    if(my >= 350 && my <= 400)
  		    {
  		    	game.State = game.State.GAME;
  		    	game.llevel2 = 1;
  		    	handler.Level = 2;
  		    
  		    }
  		}
  		if (mx >= game.WIDTH / 2 - 100 && mx <= game.WIDTH / 2 + 100)
  		{
  		    if(my >= 250 && my <= 300)
  		    {
  		    	game.State = game.State.GAME;
  		    	game.llevel3 = 1;
  		    	handler.Level = 3;
  		   
  		    }
  		}if (mx >= game.WIDTH / 2 - 100 && mx <= game.WIDTH / 2 + 100)
  		{
  		    if(my >= 350 && my <= 400)
  		    {
  		    	game.State = game.State.GAME;
  		    	game.llevel4 = 1;
  		    	handler.Level = 4;
  		    	
  		    }
  		}if (mx >= game.WIDTH / 2 + 150 && mx <= game.WIDTH - 100)
  		{
  		    if(my >= 250 && my <= 300)
  		    {
  		    	game.State = game.State.GAME;
  		    	game.llevel5 = 1;
  		    	handler.Level = 5;
  		    	
  		    }
  		}

  		 
  		if (mx >= game.WIDTH / 2 - 100 && mx <= game.WIDTH / 2 + 100)
  		{
  		    if(my >= 450 && my <= 500)
  		    {
  		    	game.State = game.State.MENU;
  		    }
  		}
  		

  		 
  		if (mx >= game.WIDTH / 2 - 100 && mx <= game.WIDTH / 2 + 100)
  		{
  		    if(my >= 450 && my <= 500)
  		    {
  		    	game.State = game.State.MENU;
  		    }
  		}
      }
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		mouseReleased = e;
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		mouseEntered = e;
	}
	@Override
	public void mouseExited(MouseEvent e) {
		mouseExited = e;
	}
	public void mouseWheelMoved(MouseWheelEvent e) {
		mouseWheelMoved = e;
	}
	public void update(){
		 mouseClicked = null;
		 mousePressed = null;
		 mouseReleased= null;
		 mouseMoved = null;
		 mouseDragged = null;
		 mouseEntered = null;
		 mouseExited = null ;
		 mouseWheelMoved= null;
	}
	public static MouseEvent getMouseClicked() {
		return mouseClicked;
	}
	public static MouseEvent getMousePressed() {
		return mousePressed;
	}
	public static MouseEvent getMouseReleased() {
		return mouseReleased;
	}
	public static MouseEvent getMouseMoved() {
		return mouseMoved;
	}
	public static MouseEvent getMouseDragged() {
		return mouseDragged;
	}
	public static MouseEvent getMouseEntered() {
		return mouseEntered;
	}
	public static MouseEvent getMouseExited() {
		return mouseExited;
	}
	public static MouseWheelEvent getMouseWheelMoved() {
		return mouseWheelMoved;
	}
}
