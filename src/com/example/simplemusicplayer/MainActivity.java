package com.example.simplemusicplayer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import mainmodel.Model;
import musicplayer.IPlayingSong;
import playlist.IPlaylist;
import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	//I just inserted this comment to make sure it pushed
//	private ArrayList<String> songList = new ArrayList<String>();
//	private ReadSongs readSong;
	//List (interface) = ArrayList (impl)
	//private IPlayingSong player = new AndroidPlayingSong();
	
	private TextView textDatabaseContents;
	//private Button buttonRemove;
	private Button buttonPlay;
	private Button buttonPause;
	private Button buttonPort;
	//private Button buttonVolume;
	//private TextView textSongTitle;
	private Button buttonNext;
	private Button buttonPrev;
	private Button buttonDB;
	private ListView listviewSongs;
	private ListView listviewDB;
	
	private AndroidDatabase db;
    private IPlayingSong ps;
    private IPlaylist pl; 
	
    private List<String> playlist;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        db = new AndroidDatabase(this);
        
        ps = new AndroidPlayingSong(db);
        pl = new AndroidPlaylist();
        db.open();
        Model.create(ps, pl, db);
        
        playlist = pl.get_list();
        

        listviewSongs = (ListView) findViewById(R.id.listSongs);
        listviewDB = (ListView) findViewById(R.id.listviewDB);
        
        // Define a new Adapter
		// First parameter - Context
		// Second parameter - Layout for the row
		// Third parameter - ID of the TextView to which the data is written
		// Forth - the Array of data

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		  android.R.layout.simple_list_item_1, android.R.id.text1, playlist);

		// Assign adapter to ListView
		listviewSongs.setAdapter(adapter); 

        
      //  textDatabaseContents = (TextView) findViewById(R.id.textDatabaseContents);
        buttonPlay = (Button) findViewById(R.id.buttonPlay);
        buttonDB = (Button) findViewById(R.id.buttonDB);
        buttonPause = (Button) findViewById(R.id.buttonPause);
        buttonNext = (Button) findViewById(R.id.buttonNext);
        buttonPrev = (Button) findViewById(R.id.buttonPrev);
       // buttonPort = (Button) findViewById(R.id.buttonPort);
        
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

        buttonNext.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		playNext();
        	}
        });
        buttonPrev.setOnClickListener(new View.OnClickListener(){
        	public void onClick(View v)
        	{
        		playPrev();
        	}
        });
        /*buttonDB.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		 //fillDataText();
        	}
        });
        */
       buttonDB.setOnClickListener(new View.OnClickListener() {
    	   public void onClick(View v) {
    		
    		   portToText(fillDataText());
    	   }
       });   
        
        //readSong = new ReadSongs();
        //songList = readSong.getPlayList();
        
        
        //Log.d("MainActivity", "SongList size is " + songList.size());	
        
       
              
    //    playlist = new AndroidPlaylist();
        
    }
    
    public void play_song() {
    	Log.d("MainActivity", "Called play song");
    	
    	Model.get().first();
    }
    public void pause_song() {
    	Model.get().play_pause();
    	
    	
    }
    public void playNext() {
    	Model.get().next();
    }
    public void playPrev() {
    	Model.get().prev();
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
    
    private String fillDataText() {
    	AndroidDatabase mDbHelper = new AndroidDatabase(this);
    	mDbHelper.open();
        Cursor c = mDbHelper.getAll();
        startManagingCursor(c);        
        //c.moveToLast();
        c.moveToFirst();
    	List<String> dbContents = new ArrayList<String>();
    	dbContents.add("Total Entries in DB: " + c.getCount());
    	
    	StringBuilder str = new StringBuilder();
    	str.append("\nBREAK");
    	//while(!c.isBeforeFirst()) {
    		
    	while(!c.isLast()) {
        	//str.append("\n\nIndex: ");
        	//str.append(c.getInt(c.getColumnIndexOrThrow(AndroidDatabase.COLUMN_ID)));
        	
        	//str.append("\nFilename: ");
        	str.append("\n" + c.getString(c.getColumnIndexOrThrow(AndroidDatabase.COLUMN_FILENAME)));
        
        	//str.append("\nStartSec: ");
        	str.append("\n" + c.getLong(c.getColumnIndexOrThrow(AndroidDatabase.COLUMN_STARTSEC)));
        	
        	//str.append("\nEndSec: ");
        	str.append("\t" + c.getLong(c.getColumnIndexOrThrow(AndroidDatabase.COLUMN_ENDSEC)));
        	
        	//str.append("\nTimestamp: ");
        	str.append("\n" + c.getString(c.getColumnIndexOrThrow(AndroidDatabase.COLUMN_TIMESTAMP)));
        	
        	str.append("\n|~|");
        	//str.append("\n\n");
        	
        	dbContents.add(str.toString());
 //       	textDatabaseContents.setText(str.toString());
        	
        	
        	//c.moveToPrevious();
        	c.moveToNext();
        }
    	
    	ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
    			  android.R.layout.simple_list_item_1, android.R.id.text1, dbContents);
    			listviewSongs.setVisibility(View.GONE);
    			listviewDB.setVisibility(View.VISIBLE);
    			// Assign adapter to ListView
    			listviewDB.setAdapter(adapter); 

        mDbHelper.close();
        return str.toString();
    }
    private void portToText(String text) {
       File logFile = new File(ReadSongs.SDCARD_MUSIC_PATH + "log.txt");
	   if (!logFile.exists())
	   {
	      try
	      {
	         logFile.createNewFile();
	      } 
	      catch (IOException e)
	      {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	   }
	   try
	   {
	      //BufferedWriter for performance, true to set append to file flag
	      BufferedWriter buf = new BufferedWriter(new FileWriter(logFile, true)); 
	      buf.append(text);
	      buf.newLine();
	      buf.close();
	   }
	   catch (IOException e)
	   {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	   }
	   System.out.println("Done");
    }
    
}