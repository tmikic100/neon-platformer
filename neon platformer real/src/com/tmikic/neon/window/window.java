package com.tmikic.neon.window;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.tmikic.neon.framework.Gameobject;
import com.tmikic.neon.framework.Objectid;
import com.tmikic.neon.objects.block;
import com.tmikic.neon.objects.flag;
import com.tmikic.neon.objects.player;


public class window 
{
	Handler handler;
	camera cam;
	
	private BufferedImage level_2 = null, level = null;

	public window (int w,int h,String title, game game)
	{
		
		handler = new Handler(cam);
		BufferedImageLoader loader = new BufferedImageLoader();
	    level_2 = loader.loadImage("/level_2.png");
	    level = loader.loadImage("/level_1.png");
		game.setPreferredSize(new Dimension(w,h));
		game.setMaximumSize(new Dimension(w,h));
		game.setMinimumSize(new Dimension(w,h));
		
		JFrame frame = new JFrame(title);
	    /*JMenuBar menubar = new JMenuBar();
	    frame.setJMenuBar(menubar);
		JMenu levels = new JMenu("levels");
		menubar.add(levels);
		JMenuItem level1 = new JMenuItem("level 1");
		levels.add(level1);
		JMenuItem level2 = new JMenuItem("level 2");
		levels.add(level2);*/
		
		frame.add(game);
		frame.pack();
		
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		/*class level1 implements ActionListener{

			
			public void actionPerformed(ActionEvent e) {
				game.loadlevel = 1;
				handler.clearlevel();
				if(game.State == game.State.MENU){
				game.State = game.State.GAME;
				handler.LoadImagelevel(level);
				}else{
					handler.LoadImagelevel(level);
				}
				
				
			}
			
			
		}
        class level2 implements ActionListener{

			
			public void actionPerformed(ActionEvent e) {
				game.loadlevel = 1;
				handler.clearlevel();
				if(game.State == game.State.MENU){
				   game.State = game.State.GAME;
				   handler.LoadImagelevel(level_2);
				}else{
					handler.LoadImagelevel(level_2);
				}
				
				
			}
			
			
		}
		level1.addActionListener(new level1());
		level2.addActionListener(new level2());*/
		game.start();
	}
	
	
}

