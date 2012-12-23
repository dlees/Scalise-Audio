package windowsonly;

import musicplayer.IPlayingSong;
import playlist.IPlaylist;

import windowsonly.WinPlayingSong;

public class Model
{
	protected IPlayingSong player;
	protected IPlaylist playlist;	
	
	private static Model instance = null;
	
	public static Model get()
	{
		if (instance == null)
			instance = new Model();
		
		return instance;
	}
	
	protected Model()
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


