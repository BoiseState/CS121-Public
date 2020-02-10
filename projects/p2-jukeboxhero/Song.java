/**
 * The <code>Song</code> class represents a song. Each song has a title, artist,
 * play time, and file path.
 *
 * Here is an example of how a song can be created.
 * 
 * <pre>
 * Song song = new Song("Amsterdam", "Paul Oakenfold", "A Lively Mind", 318);
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
 * @version Spring 2020
 */
public class Song
{
	private String title;
	private String artist;
	private String album;
	private int playTime; // in seconds
	
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

	 */
	public Song(String title, String artist, String album, int playTime)
	{
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.playTime = playTime;
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
				playTime);
		return output;
	}
}
