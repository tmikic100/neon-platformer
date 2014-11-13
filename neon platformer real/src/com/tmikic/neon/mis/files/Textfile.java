package com.tmikic.neon.mis.files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Textfile {
	
	private static String line;
	
	public static String readfile(String path){
		BufferedReader file;
		try {
			file = new BufferedReader(new FileReader(path));
			line = file.readLine();
			file.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return line;
		
	}
	
	public static void writeFile(String path, String text){

		try {
			FileWriter file = new FileWriter(path);
			file.write(text);
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	

}
