package mainmodel;


import database.Database;

import mediaManager.Manager;
import mediaManager.Record;
import musicplayer.IPlayingSong;
import playlist.IPlaylist;

public class Model
{
	protected IPlayingSong player;
	protected IPlaylist playlist;	
	protected Database database;
	
	private static Model instance = null;
	
	private Manager media;
	
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
		convert_playlist();
	}
	
	private void convert_playlist()
	{
		for (String song : playlist.get_list())
		{
			try {
				media.add_record(song, song);
			} catch(Error e){}
		}
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
		// add the song to the media player 
		// unless its already in there
		try {
			media.add_record(filename, filename);
		}catch(Error e){}
		
		player.replace_song(media.find_record(filename));
		
		player.play();
		
//		curSong = 
	}
	
	public void first()
	{
		playlist.goto_first();

		
		player.replace_song(media.find_record(playlist.next()));

		player.play();
					
	//	cursong = playlist->current();
	}

	public void prev()
	{
		player.replace_song(media.find_record(playlist.prev()));
	
		player.play();
	
		//cursong = playlist->current();
	}


	public void next()
	{			
		player.replace_song(media.find_record(playlist.next()));
										
		player.play();
						
//		cursong = playlist->current();					
	}
	
	public void next_hotspot()
	{
		player.next_hs();
	}
	
	public void prev_hotspot()
	{
		player.prev_hs();		
	}
	
	
	public void close()
	{
		player.close();
		
	}
	
	
}


