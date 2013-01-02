
package playlist;

import java.util.ArrayList;
import java.util.List;

public class Playlist implements IPlaylist
{
	public Playlist()
	{
				
	}
	
	// return next song and move index
	public String next()
	{
		++curSong;
		
		if (curSong >= playlist.size())
			curSong = 0;
		
		return current();
	}

	// return last song and move index
	public String prev()
	{
		--curSong;
		
		if (curSong < 0)
			curSong = playlist.size()-1;
		
		return current();
	}

	public String current()
	{
		return playlist.get(curSong);
	}

	public void goto_first()
	{
		curSong = -1;
	}

	public void append(String song)
	{
		playlist.add(song);
	}

	public void prepend(String song)
	{
		playlist.add(0, song);
	}

	public void insert(String song)
	{
		playlist.add(curSong, song);
	}

	public void save(String filename)
	{
		
	}

	public void shift_left()
	{
		String cur = current();
		
		playlist.set(curSong, prev());
		
		playlist.set(curSong, cur);		
	}

	public void shift_right()
	{
		String cur = current();
		
		playlist.set(curSong, next());
		
		playlist.set(curSong, cur);
	}

	public void remove_cur()
	{
		playlist.remove(current());		
	}

	public void close()
	{
		save(name);		
	}
	//I removed final. Why
	public List<String> get_list()
	{
		return playlist;		
	}
	
	private String name;

	private int curSong = -1; 

	private List<String> playlist = new ArrayList<String>();
	
	//private boolean auto_save = true;
	
}
