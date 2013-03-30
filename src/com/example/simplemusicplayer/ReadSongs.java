package com.example.simplemusicplayer;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

import android.util.Log;

public class ReadSongs {
	final static String SDCARD_MUSIC_PATH = "/sdcard/Music";
	
	private String mediaPath;
	//final String MEDIA_PATH = new String("/sdcard/Music");
	private ArrayList<String> songList = new ArrayList<String>();
	
	public ReadSongs() {
		this.mediaPath = SDCARD_MUSIC_PATH;
	}
	public ReadSongs(String mediaPath) {
		this.mediaPath = mediaPath;
	}
	public ArrayList<String> getPlayList() {
		File homeDirectory = new File(mediaPath);
		
		for(File file : homeDirectory.listFiles(new FileExtensionFilter())) {
			String song = new String(file.getPath());
			songList.add(song);
			Log.d("ReadSongs", song);
		}
		
		return songList;
	}
	
    class FileExtensionFilter implements FilenameFilter {
        public boolean accept(File dir, String name) {
            return (name.endsWith(".mp3") || name.endsWith(".MP3") || name.endsWith(".wma") || name.endsWith(".m4a") || name.endsWith(".M4A"));
        }
    }
}

