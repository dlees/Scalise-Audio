package windowsonly;

import java.io.FileInputStream;

import database.Database;

import musicplayer.PlayingSong;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;



public class WinPlayingSong extends PlayingSong
{
	private Player player = null;
	
	public WinPlayingSong(Database DB_)
	{
		super(DB_);
	}	
	
	@Override
	protected void set_song(String filename)
	{
		// TODO Auto-generated method stub

		try
		{

			FileInputStream f = new FileInputStream(filename);
			player = new Player(f);
			failed = false;
		
		} catch (Exception e)
		{
			
			failed = true;
			
			e.printStackTrace();
		}
		
	}

	
	@Override
	protected float get_duration()
	{
		// TODO Auto-generated method stub
		return 1000;
	}

	@Override
	protected void play_song()
	{		
		try
		{
			player.play();
		} catch (JavaLayerException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void put_volume()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean cant_play()
	{
		return failed;
	}

	@Override
	protected void pause_song()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void remove_song()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void move_to(int new_pos)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void change_volume(int percent)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public int get_volume_percent()
	{
		// TODO Auto-generated method stub
		return 0;
	}


	private boolean failed = false;

	@Override
	public void close()
	{
		// TODO Auto-generated method stub
		
	}
}
