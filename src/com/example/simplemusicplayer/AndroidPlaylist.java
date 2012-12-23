package com.example.simplemusicplayer;

import java.util.ArrayList;

import playlist.Playlist;
import android.util.Log;

public class AndroidPlaylist extends Playlist {
	private ArrayList<String> songList = new ArrayList<String>();
	private ReadSongs readSong;
	
	public AndroidPlaylist() {
		
		readSong = new ReadSongs();
		songList = readSong.getPlayList();
		
		Log.d("AndroidPlaylist", "SongList size is " + songList.size());
		
		for(String song : songList) {
			Log.d("AndroidPlaylist",  "Song: " + song);
			
			append(song);
		}
		
	}
}
