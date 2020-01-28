import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * The <code>Song</code> class represents a song. Each song has a title, artist,
 * album, and file path.
 *
 * Here is an example of how a song can be created.
 * 
 * <pre>
 * Song song = new Song("Amsterdam", "Paul Oakenfold", "Under the Sun");
 * </pre>
 *
 * Here is an example of how a song can be used.
 * 
 * <pre>
 * System.out.println("Artist: " + song.getArtist());
 * System.out.println(song);
 * </pre>
 *
 * @author CS121 Instructors
 */
public class Song
{
	// Song metadata
	private String title;
	private String artist;
	private String album;
	private String filePath;
	
	// Variables needed to play the song
	private Clip clip;
	private AudioInputStream audioInputStream;
	private Timer timer;
	
	/**
	 * Constructor: Builds a song using the given parameters.
	 * 
	 * @param title Song's title
	 * @param artist Song's artist
	 * @param album Song's album
	 */
	public Song(String title, String artist, String album)
	{
		this.title = title;
		this.artist = artist;
		this.album = album;

		this.timer = new Timer();
		timer.schedule(new PrintStatus(), 0, 5000); // print status every 5 seconds
	}
	
	/**
	 * Returns the title of this <code>Song</code>.
	 * 
	 * @return the title
	 */
	public String getTitle()
	{
		return title;
	}
	
	/**
	 * Sets the title of this <code>Song</code>.
	 * 
	 * @param title The new title of the song.
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}

	/**
	 * Returns the artist of this <code>Song</code>.
	 * 
	 * @return the artist
	 */
	public String getArtist()
	{
		return artist;
	}
	
	/**
	 * Sets the artist of this <code>Song</code>.
	 * 
	 * @param artist The new artist of the song.
	 */
	public void setArtist(String artist)
	{
		this.artist = artist;
	}

	/**
	 * Returns the album of this <code>Song</code>.
	 * 
	 * @return the album
	 */
	public String getAlbum()
	{
		return album;
	}
	
	/**
	 * Sets the album of this <code>Song</code>.
	 * 
	 * @param album The new album of the song.
	 */
	public void setAlbum(String album)
	{
		this.album = album;
	}
	
	/**
	 * Returns the play time of this <code>Song</code> in seconds.
	 * 
	 * @return the playTime
	 */
	public int getPlayTime()
	{
		return (int)(clip.getMicrosecondLength()/1E6); // convert from microseconds to seconds
	}
	
	/**
	 * Returns the file path of this <code>Song</code>.
	 * 
	 * @return the filePath
	 */
	public String getFilePath()
	{
		return filePath;
	}
	
	/**
	 * Sets the file path of this <code>Song</code>. Resets the audio stream to ensure fresh start after
	 * file path is changed.
	 * 
	 * @param path The new path of the song.
	 */
	public void setFilePath(String path)
	{
		this.filePath = path;
		resetAudioStream();
	}
	
	/**
	 * Plays this song asynchronously. 
	 */
	public void play()
	{
		if(clip != null)
		{
			clip.start();
			System.out.println("Started playing at: " + clip.getMicrosecondPosition()/1E6);
		}
	}
	
	/**
	 * Plays this song asynchronously.
	 * @param offset Position to start playing song (in seconds).
	 */
	public void play(int offset)
	{
		if (offset > 0 && offset < getPlayTime() && clip != null)
		{
			clip.setMicrosecondPosition((long)(offset * 1E6));
			play();
		}
	}

	/**
	 * Stops this song from playing.
	 */
	public void stop()
	{
		clip.stop();
		clip.close();
	}
	
	private void resetAudioStream()
	{
		if(clip != null) {
			clip.stop();
			clip.close();
		}
		String fullPath = new File(filePath).getAbsolutePath();
		try
		{
			audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
		}
		catch (Exception e)
		{
			System.out.println("Error loading sound clip for " + fullPath);
			System.out.println(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		String output = String.format("%-30s %-20s %-30s %5d", (title.length()<30?title:title.substring(0, 27) + "..."),
		         (artist.length()<20?artist:artist.substring(0, 17) + "..."),
		         (album.length()<30?album:album.substring(0, 27) + "..."),
		         getPlayTime());
		return output;
	}
	
	private class PrintStatus extends TimerTask {
	    public void run() {
	       if(clip != null && clip.isActive()) {
	    	   System.out.println("Play offset: " + clip.getMicrosecondPosition()/1E6);
	       }
	    }
	}
}
