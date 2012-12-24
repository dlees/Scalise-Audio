// Package: Media Manager

//THIS IS A RANDOM COMMENT TO CHECK GIT

// TODO: Remember titles among songs aren't unique
// TODO: Find records by ID
// TODO: Search tools
// TODO: Add_member...
// TODO: ID is always even - i think making clones does this


import java.io.File;

import mediaManager.Manager;
import musicplayer.*;

/*
 * HelloWorldSwing.java requires no other files. 
 */
import javax.swing.*;        
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */


class Main
{
	

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Add the ubiquitous "Hello World" label.
        JLabel label = new JLabel("Hello Ken");
        frame.getContentPane().add(label);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
 
	public static void main(final String[] args) 
	{		
		//Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
        
		try
		{
	//		Model.get().play_new("C:\\Users\\Akira\\Music\\No Doubt - You Can Do It.mp3");
	//		Model.get().play_pause();
		
			
			Manager M = new Manager();
		
	//		M.print_library();
			
			M.add_record("Listen to Your Heart", "FS");				
			M.add_record("List to You", "FS");
			M.add_record("List Your Heart", "FS");
			M.add_record("Listen You Heat", "FS");
			M.add_record("Listen to Heart", "FS");

			M.print_record("Listen You Heat");
		//	M.delete_record("Listen You Heat");
//			M.print_record("Listen You Heat");
			
			
			M.print_library();
			
		}	
		catch(Exception e){
			e.printStackTrace();
	//	} catch (Exception e)
		//{
			System.out.println(e.getMessage());
		}
	
	}
}