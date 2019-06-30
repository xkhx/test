package xyz.minicold.nex.Bilibilis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Music {

	public  InputStream getmusicurl() {
		File f=new File(System.getProperty("user.dir")+"\\BGM.mp3");
		InputStream is=null;
		try {
			is=new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			Error.errors(e);
			e.printStackTrace();
		}
		return is;
	}
	public static Player loadMusic() {
		Music music=new Music();
		Player pl = null;
		try {
			pl = new Player(music.getmusicurl());
		} catch (JavaLayerException e) {
			// TODO Auto-generated catch block
			Error.errors(e);
			e.printStackTrace();
		}
		return pl;
	}
	public static Player pl=loadMusic();
	public static void plays() {
	Thread thr = new Thread() {

		@Override
		public void run() {
			try {
				pl.play();
			} catch (JavaLayerException e) {
				Error.errors(e);
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
	};
	thr.start();
	}
	
	public void waits() {
	Thread thr = new Thread() {

		@Override
		public void run() {
			pl.close();
			pl=loadMusic();
			}
	};
	thr.start();
	}
}
