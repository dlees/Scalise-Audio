package database;


/* constructor should init all things needed to store every
 * type of data
 * 
 * 
 * */
public interface Database {

	// Stores the second count. Saves the song, 
	// the second of the song started and stopped playing at
			// If whole song numbers would be 0 and song.length
	// stores the time this insert was recorded
	// end_sec - start_sec = number of seconds played since last insert
	
	/*	---Text file example---
	 * 	C:/.../Settle Down.mp3
	 * 	0	17
	 * 	Tue Sep 25 00:11:34 2012
	 * 	|~|
	 */
	
	void insert_sec_count(String filename, long start_sec, long end_sec);
}
