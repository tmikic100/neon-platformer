package com.tmikic.neon.window;

import java.applet.AudioClip;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import com.tmikic.neon.framework.Gameobject;
import com.tmikic.neon.framework.Objectid;
import com.tmikic.neon.input.mouseinput;
import com.tmikic.neon.objects.player;
import com.tmikic.neon.sound.Sound;
import com.tmikic.neon.textures.texture;
 




public class game extends Canvas implements Runnable
{
	
	
	
	
	private static final long serialVersionUID = 9050717834283562499L;
    public int loadlevel = 0;
	private boolean running = false;
	private Thread thread;
	private int update = 0;
	private int run = 1;
	private int spawn = 1;
	
	public static int playsound = 0;
	
	
	
	
	public static int WIDTH, HEIGHT;
	
	
	public BufferedImage level = null,level2 = null,level3 = null,level4 = null,level5 = null;
	
	
	Gameobject object;
	STATE state;
	private menu menu;
	private levelselector levelsel;
	public static int Level = 1;
	public static int llevel1 = 0;
	public static int llevel2 = 0;
	public static int llevel3 = 0;
	public static int llevel4 = 0;
	public static int llevel5 = 0;
	public static int snow_count = 1;
	
	public int getSnow_count() {
		return snow_count;
	}
	public void setSnow_count(int snow_count) {
		this.snow_count = snow_count;
	}

	// object
	Handler handler;
	camera cam;
	static texture tex;
	
	public enum STATE {
	    MENU,
	    GAME,
	    levelsel;
	}

	public static STATE State = STATE.MENU;

	
	private void init(){
		WIDTH = getWidth();
		HEIGHT = getHeight();
		
		tex = new texture();
		
		BufferedImageLoader loader = new BufferedImageLoader();
		level =loader.loadImage("/level_1.png");
		level2 =loader.loadImage("/level_2.png");
		level3 =loader.loadImage("/level_3.png");
		level4 =loader.loadImage("/level_4.png");
		level5 =loader.loadImage("/level_5.png");
		cam = new camera(0, 0);
	handler = new Handler(cam);
	
	   menu = new menu();
	   levelsel = new levelselector();
	   Sound.snow.play();
		this.addKeyListener(new keyinput(handler));
		this.addMouseListener(new mouseinput());
		
		
	}
	public synchronized void start()
	{
		if(running)
			return;
			
		running = true;	
		thread = new Thread(this);
		thread.start();
		
	}
	
	public void run()
	{
		if(run == 1){
			player.key = false;
		}
		init();
		loadlevel();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				updates++;
				delta--;
			}
			
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
				if(State == State.GAME){
					
				
				if(snow_count <= 16){
					handler.spawnsnow(snow_count,19);
					snow_count ++;
					
				}
				}
				loadlevel();
				
						
			llevel1 = 0;
			llevel2 = 0;
			llevel3 = 0;
			llevel4 = 0;
			llevel5 = 0;
			if(update == 0){
				
			update = 1;
			
			}
			}
		}
	}
	public static void music()
	{
		
	}
	private void loadlevel() {
		snow_count = 1;
		if(llevel1 == 1){
			handler.clearlevel();
			handler.LoadImagelevel(level);
			
			
			
		}else if(llevel2 == 1){
			handler.clearlevel();
			handler.LoadImagelevel(level2);
			
		}else if(llevel3 == 1){
			handler.clearlevel();
			handler.LoadImagelevel(level3);
			
		}else if(llevel4 == 1){
			handler.clearlevel();
			handler.LoadImagelevel(level4);
			
		}else if(llevel5 == 1){
			handler.clearlevel();
			handler.LoadImagelevel(level5);
			
		}
		playsound = 1;
		
	}
	private void tick()
	{
		if (State == STATE.GAME){
		handler.tick();
		for(int i = 0; i < handler.object.size(); i++){
			if(handler.object.get(i).getId() == Objectid.player){
				cam.tick(handler.object.get(i));
			}
			}
		}
	}
	private void render()
	{
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		/////////////////////////////////////////////////////
		
		//draw scren
		g.setColor(Color.black);
		g.fillRect(0, 0,getWidth(),getHeight());
		//draw gui
		
	    //draw game 
		if (State == STATE.GAME){
		g2d.translate(cam.getx(), cam.gety());//begin of cam
		
		handler.render(g);
		
		
		g2d.translate(-cam.getx(), -cam.gety());//end of cam
		
		}else if (State == STATE.MENU){
        g2d.translate(cam.getx(), cam.gety());//begin of cam
		cam.sety(0);
		menu.render(g);
		
		g2d.translate(-cam.getx(), -cam.gety());//end of cam

		}else if(State == State.levelsel){
			 g2d.translate(cam.getx(), cam.gety());//begin of cam
			 cam.sety(0);
			 levelsel.render(g);
				
			 g2d.translate(-cam.getx(), -cam.gety());//end of cam
		}
		
		////////////////////////////////////////////////////
		g.dispose();
		bs.show();
	}
	
	
	
	public class keyinput extends KeyAdapter
	{
		Handler handler;
		public keyinput(Handler handler){
			this.handler = handler;
		}
	 
		public void keyPressed(KeyEvent e){
		 int key = e.getKeyCode();
		
		 if (State == State.GAME){
				 
		 for(int i = 0; i < handler.object.size(); i++)
		 {
			  Gameobject tempObject = handler.object.get(i);
			  
			  if (tempObject.getId() == Objectid.player)
			  {
				  if(key == KeyEvent.VK_D) tempObject.setvelx(5);
				  if(key == KeyEvent.VK_A) tempObject.setvelx(-5);
				  if(key == KeyEvent.VK_SPACE && !tempObject.isJumping()) 
				  {
					  tempObject.setJumping(true);
					  tempObject.setvely(-15);
				  }
			  }
		 }
		 if(key == KeyEvent.VK_ESCAPE){
			 game.State = game.STATE.MENU; cam.setx(0); 	
			 playsound = 0;		 	
		 }
		 }
		
		}
	    public void keyReleased(KeyEvent e){
	    	 int key = e.getKeyCode();
	    	 
	    	 for(int i = 0; i < handler.object.size(); i++)
	    	 {
	    		  Gameobject tempObject = handler.object.get(i);
	    		  
	    		  if (tempObject.getId() == Objectid.player)
	    		  {
	    			  if(key == KeyEvent.VK_D) tempObject.setvelx(0);
	    			  if(key == KeyEvent.VK_A) tempObject.setvelx(0);
	    		  }
	    	 }
		}
	}
	public static texture getInstance(){
		return tex;
	}

	public static void main(String args[]){
		
		new window(800, 600, "neon platform Game prototype", new game());
	}
	
	

}
