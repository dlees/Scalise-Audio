package mediaManager;

import java.util.ArrayList;
import java.util.List;


public class Record implements Composite
{
	static private int ID_counter = 0;
	static private int max_rating_c = 10;
	static private int min_rating_c = 1;
	
	private	int ID;
	private String title;
	private int rating;
	private List<String> filenames;
	
	public Record(String title_, String filename)
	{
		title = title_;
		rating = 0;
		ID = ++ID_counter;	
		filenames = new ArrayList<String>();
		filenames.add(filename);
	}
	
	// Probe constructors
	public Record(String title_)
	{title = title_;}
	public Record(int id)
	{ID = id;}
	
	
	public int get_ID()
	{
		return ID;
	}
	
	public String get_title()
	{
		return title;
	}
	
	public void set_rating(int rate) throws Exception
	{
		if (rate > max_rating_c || rate < min_rating_c)
			throw new Exception("Rating out of range!");
			
		rating = rate;
	}
	
	public void print()
	{
		System.out.println(ID + ": " + rating + " " + title);
	}

	@Override
	public boolean equals(Object e)
	{
		if (e instanceof Record)
			return this.equals((Record)e);
		
		return false;
	}	
	
	public boolean equals(Record that)
	{
		return title == that.title;
	}
	
	public String get_main_filename()
	{
		return filenames.get(0);
	}
	
	public void add_filename(String filename)
	{
		filenames.add(filename);
	}
	// need set main filename

}