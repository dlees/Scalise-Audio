
import playlist.IPlaylist;
import playlist.Playlist;

import musicplayer.IPlayingSong;
import musicplayer.WinPlayingSong;


public class Model
{
	private IPlayingSong player;
	private static Model instance = null;
	
	public static Model get()
	{
		if (instance == null)
			instance = new Model();
		return instance;
	}
	
	private Model()
	{
		player = new WinPlayingSong();		
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
	
	void first()
	{
		playlist.goto_first();

		player.replace_song(playlist.next());

		player.play();
					
	//	cursong = playlist->current();
	}



	void prev()
	{
		player.replace_song(playlist.prev());
	
		player.play();
	
		//cursong = playlist->current();
	}


	void next()
	{			
		player.replace_song(playlist.next());
										
		player.play();
						
//		cursong = playlist->current();					
	}

	
	
	private IPlaylist playlist = new Playlist();	
	
}
