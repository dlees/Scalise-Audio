package mainmodel;


import com.example.simplemusicplayer.AndroidDatabase;
import com.example.simplemusicplayer.AndroidPlayingSong;
import com.example.simplemusicplayer.AndroidPlaylist;

import musicplayer.IPlayingSong;
import playlist.IPlaylist;
import android.content.Context;
import android.database.SQLException;
import android.util.Log;



public class Model
{
	protected IPlayingSong player;
	protected IPlaylist playlist;	
	protected AndroidDatabase database;
	private static Model instance = null;
	
	protected static Context mContext;
	
	
	public static Model get()
	{
		if (instance == null)
			instance = new Model();
		
		return instance;
	}
	
	public static Model get(Context context)
	{
		if (instance == null) {
			mContext = context;
			instance = new Model();
			
		}
		return instance;
	}
	protected Model()
	{
		database = new AndroidDatabase(mContext);
		try {
			database.open();	
		} catch(SQLException e) {
			e.printStackTrace();
			Log.e("Model", "Error in open");
		}
		
		player = new AndroidPlayingSong(database);
		playlist = new AndroidPlaylist();
		
	}
	
	public void play_pause()
	{
		if (player.is_paused())
			player.play();
		
		else
			player.pause();
		
	}
	
	public void play_new(String filename)
	{
		player.replace_song(filename);
		
		player.play();
		
//		curSong = 
	}
	
	public void first()
	{
		playlist.goto_first();

		player.replace_song(playlist.next());

		player.play();
					
	//	cursong = playlist->current();
	}



	public void prev()
	{
		player.replace_song(playlist.prev());
	
		player.play();
	
		//cursong = playlist->current();
	}


	public void next()
	{			
		player.replace_song(playlist.next());
										
		player.play();
						
//		cursong = playlist->current();					
	}
	
	public void close()
	{
		player.close();
		
	}
	
	
}


