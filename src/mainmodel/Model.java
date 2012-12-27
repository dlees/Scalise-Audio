package mainmodel;


import mediaManager.Manager;
import musicplayer.IPlayingSong;
import playlist.IPlaylist;
import database.Database;

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
//		convert_playlist();
	}
	
	private void convert_playlist()
	{

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

		player.replace_song(filename);
		
		player.play();
		
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
		player.replace_song((playlist.next()));
										
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


