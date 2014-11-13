package com.tmikic.neon.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class keyinput extends KeyAdapter{

	private static ArrayList<KeyEvent> keyspressed = new ArrayList<KeyEvent>();
	private static ArrayList<KeyEvent> keysreleased = new ArrayList<KeyEvent>();
	private static ArrayList<KeyEvent> keystyped = new ArrayList<KeyEvent>();
	
	@Override
	public void keyPressed(KeyEvent e) {
	    if (!keyspressed.contains(e)) {
	    	keyspressed.remove(e);
	    }
	    if (!keysreleased.contains(e)) {
	    	keysreleased.add(e);
	    }
	    if (!keystyped.contains(e)) {
	    	keystyped.remove(e);
	    }
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
	
		if (!keyspressed.contains(e)) {
	    	keyspressed.remove(e);
	    }
	    if (!keysreleased.contains(e)) {
	    	keysreleased.remove(e);
	    }
	    if (!keystyped.contains(e)) {
	    	keystyped.add(e);
	    }
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	 
		if (!keyspressed.contains(e)) {
	    	keyspressed.add(e);
	    }
	    if (!keysreleased.contains(e)) {
	    	keysreleased.remove(e);
	    }
	    if (!keystyped.contains(e)) {
	    	keystyped.remove(e);
	    }
	}
	
	public void update() {
		keyspressed.clear();
		keysreleased.clear();
		keystyped.clear();
	}
	
	public static ArrayList<KeyEvent> getKeyspressed() {
		return keyspressed;
	}
	
	public static ArrayList<KeyEvent> getKeysreleased() {
		return keysreleased;
	}
	
	public static ArrayList<KeyEvent> getKeystyped() {
		return keystyped;
	}
}
