package com.example.simplemusicplayer;

import java.io.IOException;

import database.Database;

import musicplayer.PlayingSong;
import android.media.AudioManager;
import android.media.MediaPlayer;

public class AndroidPlayingSong extends PlayingSong
{
	private MediaPlayer mp;
	
	public AndroidPlayingSong(Database DB_) {
		super(DB_);
		mp = new MediaPlayer();
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
	}
	@Override
	protected float get_duration() {
		// TODO Auto-generated method stub
		return 100;
	}

	@Override
	protected void play_song() {
		try {
	        
	        
	        mp.start();
		} catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	protected void put_volume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean cant_play() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void pause_song() {
		
		mp.pause();
	}

	@Override
	protected void remove_song() {
		
		mp.stop();mp.reset();
	}

	@Override
	protected void move_to(int new_pos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void change_volume(int percent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int get_volume_percent() {
		// TODO Auto-generated method stub
		return 0;
	}
	protected void set_song(String filename) {
		try {
			
			mp.setDataSource(filename);
			mp.prepare();
		} catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	public void close() {
		if(mp != null) {
			if(mp.isPlaying()) {
				mp.stop();
			}
			mp.release();
			mp = null;
		}
			
		
	}

}
