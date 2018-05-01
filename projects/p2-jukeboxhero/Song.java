import java.applet.AudioClip;
import java.applet.Applet;
import java.io.File;
import java.net.URL;

/**
 * The <code>Song</code> class represents a song. Each song has a title, artist,
 * play time, and file path.
 *
 * Here is an example of how a song can be created.
 * 
 * <pre>
 * Song song = new Song("Amsterdam", "Paul Oakenfold", 318, "sounds/Amsterdam.mp3");
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
	private AudioClip clip; // Used to play the song.

	private String title;
	private String artist;
	private int playTime; // in seconds
	private String filePath;
	private int playCount;
	private String album;
	private boolean metadataOnly;

	/**
	 * Constructor: Builds a metadata only song using the given parameters.
	 * 
	 * @param title
	 *            song's title
	 * @param artist
	 *            song's artist
	 * @param filePath
	 *            song's album
	 * @param playTime
	 *            song's length in seconds

	 */
	public Song(String title, String artist, String album, int playTime)
	{
		this(title,artist,album,playTime,null);
	}
	
	/**
	 * Constructor: Builds a song using the given parameters.
	 * 
	 * @param title
	 *            song's title
	 * @param artist
	 *            song's artist
	 * @param playTime
	 *            song's length in seconds
	 * @param filePath
	 *            song file to load
	 */
	public Song(String title, String artist, int playTime, String filePath)
	{
		this(title,artist,null,playTime,filePath);
	}
	
	/**
	 * Constructor: Builds a song using the given parameters.
	 * 
	 * @param title
	 *            song's title
	 * @param artist
	 *            song's artist
	 * @param album
	 *            song's album
	 * @param playTime
	 *            song's length in seconds
	 * @param filePath
	 *            song file to load
	 */
	public Song(String title, String artist, String album, int playTime, String filePath)
	{
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.playTime = playTime;
		this.filePath = filePath;
		this.playCount = 0;

		/* Use a private helper method to load 
		 * the clip and set the metadataOnly flag
		 * if an invalid filename is specified.
		 */
		this.loadClip();
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
	public String getAlbum() {
		return album;
	}

	/**
	 * Sets the album of this <code>Song</code>.
	 * 
	 * @param album the album to set
	 */
	public void setAlbum(String album) {
		this.album = album;
	}

	/**
	 * Returns the play time of this <code>Song</code> in seconds.
	 * 
	 * @return the playTime
	 */
	public int getPlayTime()
	{
		return playTime;
	}
	
	/**
	 * Sets the play time of this <code>Song</code>.
	 * 
	 * @param seconds The new play time of the song in seconds.
	 */
	public void setPlayTime(int seconds)
	{
		this.playTime = seconds;
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
	 * Sets the file path of this <code>Song</code>.
	 * 
	 * @param path The new path of the song.
	 */
	public void setFilePath(String path)
	{
		this.filePath = path;
		/* Use a private helper method to load 
		 * the clip and set the metadataOnly flag
		 * if an invalid filename is specified.
		 */
		this.loadClip();
	}

	/**
	 * Returns the number of times this song has been played.
	 * 
	 * @return the count
	 */
	public int getPlayCount()
	{
		return playCount;
	}
	
	/**
	 * Plays this song asynchronously.
	 */
	public void play()
	{
		if (clip != null)
		{
			clip.play();
			playCount++;
		}
	}

	/**
	 * Stops this song from playing.
	 */
	public void stop()
	{
		if (clip != null)
		{
			clip.stop();
		}
	}
	
	/**
	 * Private helper method
	 * Load the song file and create clip. If file does not exist or an error
	 *    occurs, revert to metadata only.
	 */
	
	private void loadClip() {
		this.metadataOnly = false;
		
		if (filePath == null) {
			this.metadataOnly = true;
		} else {
			String fullPath = new File(filePath).getAbsolutePath();
			try
			{
				this.clip = Applet.newAudioClip(new URL("file:" + fullPath));
			}
			catch (Exception e)
			{
				System.out.println("Error loading sound clip for " + fullPath);
				System.out.println(e.getMessage());
				this.metadataOnly = true;
			}
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
		String output = "";
		if (this.metadataOnly) {
			output = String.format("%-30s %-20s %-30s %5d", (title.length()<30?title:title.substring(0, 27) + "..."),
					(artist.length()<20?artist:artist.substring(0, 17) + "..."),
					(album.length()<30?album:album.substring(0, 27) + "..."), 
					playTime);
		} else {
			output = String.format("%-20s %-20s %-25s %10d", title, artist, filePath, playTime);
		}
		
		return output;
	}
}
