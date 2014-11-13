package com.tmikic.neon.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import com.tmikic.neon.framework.Gameobject;
import com.tmikic.neon.framework.Objectid;
import com.tmikic.neon.window.BufferedImageLoader;
import com.tmikic.neon.window.Handler;
import com.tmikic.neon.window.camera;

public class player extends Gameobject{
	
	private float width = 32, height = 64;
	private float gravity = 0.5f;
	private final float MAX_SPEED = 10;
	private Handler Handler;
	private camera cam;
	private int load = 0;
    private spike spike;
	

	private BufferedImage level2 = null, level = null,level3 = null;
	public static Boolean key = false;
	public int lkey = 0;
	
	public player(float x, float y, Handler handler,camera cam, Objectid id) {
		super(x, y, id);
		this.Handler = handler;
		this.cam = cam;
	}

	
	public void tick(LinkedList<Gameobject> object) {
		y += vely;
		x += velx;
		
		if(falling || jumping)
		{
		     vely += gravity;
		     
		     if(vely > MAX_SPEED){
		    	 vely=MAX_SPEED;
		     }
		}
		
		collision(object);
	}
	
	private void collision(LinkedList<Gameobject> object)
	{
	    spike = new spike(x,y,Objectid.Spike);
		BufferedImageLoader loader = new BufferedImageLoader();
		if(load == 0){
	    level =loader.loadImage("/level_1.png");
	    level2 = loader.loadImage("/level_2.png");
	    level3 =loader.loadImage("/level_3.png");
	    load = 1;
		}
		for(int i = 0;i < Handler.object.size(); i++)
		{
			Gameobject tempObject = Handler.object.get(i);
			
			if(tempObject.getId() == Objectid.block)
			{

				if(getBoundstop().intersects(tempObject.getBounds())){
					y = tempObject.gety() + 32;
					vely = 0;
				}
				if(getBounds().intersects(tempObject.getBounds())){
					y = tempObject.gety() - height;
					vely = 0;
					falling = false;
					jumping = false;
				}else 
					falling = true;
				//right
				if(getBoundsright().intersects(tempObject.getBounds())){
					x = tempObject.getx() - width;
				}
				//left
				if(getBoundsleft().intersects(tempObject.getBounds())){
					x = tempObject.getx() + 34;
				}
			}else 
				if(tempObject.getId() == Objectid.block)
				{

					if(getBoundstop().intersects(tempObject.getBounds())){
						y = tempObject.gety() + 32;
						vely = 0;
					}
					if(getBounds().intersects(tempObject.getBounds())){
						y = tempObject.gety() - height;
						vely = 0;
						falling = false;
						jumping = false;
					}else 
						falling = true;
					//right
					if(getBoundsright().intersects(tempObject.getBounds())){
						x = tempObject.getx() - width;
					}
					//left
					if(getBoundsleft().intersects(tempObject.getBounds())){
						x = tempObject.getx() + 34;
					}
				}else if(tempObject.getId() == Objectid.flag)
				{
					if(getBounds().intersects(tempObject.getBounds())){
						Handler.switchlevel();
						cam.setx(0);
				}
					}else if(tempObject.getId() == Objectid.Spike)
					{
						if(getBounds().intersects(tempObject.getBounds())){
							Handler.restartlevel(1);
							cam.setx(0);
					}
						}else if(tempObject.getId() == Objectid.Door)
						{
						if(key = false){	
						if(getBounds().intersects(tempObject.getBounds())){
							y = tempObject.gety() - height;
							vely = 0;
							falling = false;
							jumping = false;
						}else 
							falling = true;
						//right
						if(getBoundsright().intersects(tempObject.getBounds())){
							x = tempObject.getx() - width;
						}
						//left
						if(getBoundsleft().intersects(tempObject.getBounds())){
							x = tempObject.getx() + 34;
						}
					}else 
						if(tempObject.getId() == Objectid.Door)
						{
                            
							if(getBoundstop().intersects(tempObject.getBounds())){
								y = tempObject.gety() + 32;
								vely = 0;
							}
							if(getBounds().intersects(tempObject.getBounds())){
								y = tempObject.gety() - height;
								vely = 0;
								falling = false;
								jumping = false;
							}else 
								falling = true;
							//right
							if(getBoundsright().intersects(tempObject.getBounds())){
								x = tempObject.getx() - width;
							}
							//left
							if(getBoundsleft().intersects(tempObject.getBounds())){
								x = tempObject.getx() + 34;
							}
							if(key = true ){
                         
								
								if(lkey == 1){
								Handler.removeobject(tempObject);
								}
							  
						}
						}
						
							}
						else if(tempObject.getId() == Objectid.Key)
						{
							if(getBounds().intersects(tempObject.getBounds())){
								
								
								Handler.removeobject(tempObject);
								key = true;
								lkey = 1;
							  
						}}else if(tempObject.getId() == Objectid.Spike2)
						{
							if(getBounds().intersects(tempObject.getBounds())){
								Handler.restartlevel(4);
								cam.setx(0);
						}}else if(tempObject.getId() == Objectid.Spike3)
						{
							if(getBounds().intersects(tempObject.getBounds())){
								Handler.restartlevel(5);
								cam.setx(0);
						}
							
								}}}
		
					
			
	

	
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect((int)x,(int)y,(int)width,(int)height);
		
		Graphics2D g2d =(Graphics2D) g;
		g2d.draw(getBounds());
		g2d.draw(getBoundsright());
		g2d.draw(getBoundsleft());
		g2d.draw(getBoundstop());
		g.setColor(Color.red);
		g2d.fill(eyeleft());
		g2d.fill(eyeright());
		g2d.fill(mouth());
	}

	
	public Rectangle getBounds() {
		
		return new Rectangle((int) ((int)x+(width/2)-((width/2)/2)),(int) ((int)y+(height/2)) ,(int)width/2,(int)height/2);
	}
	public Rectangle getBoundstop() {
		
		return new Rectangle((int) ((int)x+(width/2)-((width/2)/2)),(int)y,(int)width/2,(int)height/2);
	}

public Rectangle getBoundsright() {
	
	return new Rectangle((int) ((int)x+width-6),(int)y+5,(int)5,(int)height-10);
}
public Rectangle getBoundsleft() {
	
	return new Rectangle((int)x,(int)y+5,(int)5,(int)height-10);
}
public Rectangle eyeleft() {
	
	return new Rectangle((int) ((int) ((int)x+width-12)),(int)y+5,(int)5,(int)5);
}
public Rectangle eyeright() {
	
	return new Rectangle((int) ((int)x+(width/2)-((width/2)/2)),(int)y+5,(int)5,(int)5);
}
public Rectangle mouth() {
	
	return new Rectangle((int) ((int)x+width/2/2-4),(int)y+15,(int)25,(int)5);
}

}
