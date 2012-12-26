package mainmodel;


import database.Database;

import musicplayer.IPlayingSong;
import playlist.IPlaylist;


public class Model
{
	protected IPlayingSong player;
	protected IPlaylist playlist;	
	protected Database database;
	
	private static Model instance = null;
	
	
	public static Model get()
	{
		if (instance == null)
			throw new Error("Model Not Created Yet");
		
		return instance;
	}
	
	public static void create(IPlayingSong ps, IPlaylist pl, Database db)
	{
		if (instance != null) {
			throw new Error("Model Already Created");
		}
		
		instance = new Model(ps, pl, db);
	}
	
	protected Model(IPlayingSong ps, IPlaylist pl, Database db)
	{
		database = db;
		
		player = ps;
		
		playlist = pl;		
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


