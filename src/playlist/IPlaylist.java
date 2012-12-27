
package playlist;

import java.util.List;

public interface IPlaylist
{
	// return next song and move index
	String next();
	
	// return last song and move index
	String prev();

	String current();

	void goto_first();
	
	void append(String song);
	void prepend(String song);

	// inserts song after current song and increments index
	void insert(String song);

	void save(String filename);

	void shift_left();
	void shift_right();

	void remove_cur();
	
	List<String> get_list();
	
	void close();
}
