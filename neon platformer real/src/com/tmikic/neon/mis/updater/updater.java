package com.tmikic.neon.mis.updater;

import com.tmikic.neon.mis.files.Textfile;

public class updater {
    private static String currentversion, newversion;
    public static int update = 0;
    
    public static void checkforupdate(boolean isAuto){
    	currentversion = Textfile.readfile("/version.txt");
    }
    
}
