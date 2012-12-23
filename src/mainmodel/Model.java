package mainmodel;


import musicplayer.IPlayingSong;
import playlist.IPlaylist;

import com.example.simplemusicplayer.AndroidPlayingSong;
import com.example.simplemusicplayer.AndroidPlaylist;



abstract public class Model
{
	protected IPlayingSong player;
	protected IPlaylist playlist;	
	
	private static Model instance = null;
	
	public static void create_android_model()
	{
		if (instance == null)
			instance = new AndroidModel();
		else 
			throw new Error("Model Already Created!");
	}
	
	public static void create_windows_model()
	{
		if (instance == null)
			instance = new WindowsModel();
		else 
			throw new Error("Model Already Created!");
	}
	
	public static Model get()
	{
		if (instance == null)
			throw new Error("Model Not Created!");
		
		return instance;
	}
	
	protected Model()
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

class AndroidModel extends Model
{
	protected AndroidModel()
	{
		player = new AndroidPlayingSong();	
		playlist = new AndroidPlaylist();
	}
	
}


class WindowsModel extends Model
{
	protected WindowsModel()
	{
//		player = new WinPlayingSong();	
		//playlist = new Playlist();
	}
	
}


