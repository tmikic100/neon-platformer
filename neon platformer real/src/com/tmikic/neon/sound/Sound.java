package com.tmikic.neon.sound;

import java.applet.Applet;
import java.applet.AudioClip;

import javax.sound.sampled.Clip;

public class Sound {
	private AudioClip clip;
    public static final Sound snow = new Sound("/snow.wav");
    
public Sound (String filename){
	  
	  
	  try{
		  clip = Applet.newAudioClip(Sound.class.getResource(filename));
	  }catch(Exception e){
		  e.printStackTrace();
	  }
  }
  
  public void play(){
	  try{
		  new Thread(){
			  public void run(){
				  clip.play();
			  }
		  }.start();
	  }catch(Exception ex){
		  ex.printStackTrace();
	  }
  }
}
