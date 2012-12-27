package musicplayer;

import mediaManager.Record;

public interface IPlayingSong
{
	String get_cur_song();
	
	// throws an Error if cant play the song
	void play();

	void pause();

	// changes the curSong to the song
	// does not play
	void replace_song(String string);

	// throws error if past total duration
	void change_position(int new_pos);
	void change_pos_relative(int relative_pos);

	void set_hs();
	void next_hs();
	void prev_hs();
	void remove_hs();

	boolean is_paused(); // true if paused
	
	boolean is_finished();	// return true if the song ended
		
	void vol_up();	
	void vol_down();
	void set_volume_percent(int percent);
	int get_volume_percent();
	
	void close();
}
