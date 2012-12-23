package com.example.simplemusicplayer;

import java.util.ArrayList;

import musicplayer.IPlayingSong;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
//	private ArrayList<String> songList = new ArrayList<String>();
//	private ReadSongs readSong;
	//List (interface) = ArrayList (impl)
	//private IPlayingSong player = new AndroidPlayingSong();
	
	
	private Button buttonRemove;
	private Button buttonPlay;
	private Button buttonPause;
	private Button buttonVolume;
	private TextView textSongTitle;
	private Button buttonNext;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        buttonPlay = (Button) findViewById(R.id.buttonPlay);
        buttonPause = (Button) findViewById(R.id.buttonPause);
        buttonVolume = (Button) findViewById(R.id.buttonVolume);
        buttonNext = (Button) findViewById(R.id.buttonNext);
        buttonPlay.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
               // Perform action on click
        	   play_song();
           }
        });
        buttonPause.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		pause_song();
        	}
        });
        buttonVolume.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		playOtherSong();
        	}
        });
        buttonNext.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		playNext();
        	}
        });
        //readSong = new ReadSongs();
        //songList = readSong.getPlayList();
        
        
        //Log.d("MainActivity", "SongList size is " + songList.size());	
        
        /*
        for(String str : songList) {
        	Log.d("MainActivity", "Song file path: " + str);	
        }
        */
              
    //    playlist = new AndroidPlaylist();
        
    }
    
    public void play_song() {
    	Log.d("MainActivity", "Called play song");
    	
    	//Model.get().play_new("sdcard/Music/Country.wma");
    	Model.get().first();
    }
    public void pause_song() {
    	Model.get().play_pause();
    	
    	
    }
    public void playOtherSong() {
    	Log.d("MainActivity", "Called play song");
    	//Model.get().first();
    	
    	Model.get().play_new("sdcard/Music/Sleep Away.mp3");
    }
    public void playNext() {
    	Model.get().next();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    @Override
    protected void onDestroy() {
    	super.onDestroy();
    	Model.get().close();
    }
    
}