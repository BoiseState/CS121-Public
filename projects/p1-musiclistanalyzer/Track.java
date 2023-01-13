/**
 * The <code>Track</code> class represents a track. Each track has a title, artist,
 * play time, and file path.
 *
 * Here is an example of how a track can be created.
 * 
 * <pre>
 * Track track = new Track("Holiday", "Green Day", "American Idiot", 232);
 * </pre>
 *
 * Here is an example of how a track can be used.
 * 
 * <pre>
 * System.out.println("Artist: " + track.getArtist());
 * System.out.println(track);
 * </pre>
 *
 * @author CS121 Instructors
 * @version Spring 2023
 */
public class Track
{
    private String title;
    private String artist;
    private String album;
    private int playTime; // in seconds

    /**
     * Constructor: Builds a track using the given parameters.
     * 
     * @param title
     *            track's title
     * @param artist
     *            track's artist
     * @param album
     *            track's album
     * @param playTime
     *            track's length in seconds

     */
    public Track(String title, String artist, String album, int playTime)
    {
	this.title = title;
	this.artist = artist;
	this.album = album;
	this.playTime = playTime;
    }

    /**
     * Returns the title of this <code>Track</code>.
     * 
     * @return the title
     */
    public String getTitle()
    {
	return title;
    }

    /**
     * Sets the title of this <code>Track</code>.
     * 
     * @param title The new title of the track.
     */
    public void setTitle(String title)
    {
	this.title = title;
    }

    /**
     * Returns the artist of this <code>Track</code>.
     * 
     * @return the artist
     */
    public String getArtist()
    {
	return artist;
    }

    /**
     * Sets the artist of this <code>Track</code>.
     * 
     * @param artist The new artist of the track.
     */
    public void setArtist(String artist)
    {
	this.artist = artist;
    }

    /**
     * Returns the album of this <code>Track</code>.
     * 
     * @return the album
     */
    public String getAlbum() {
	return album;
    }

    /**
     * Sets the album of this <code>Track</code>.
     * 
     * @param album the album to set
     */
    public void setAlbum(String album) {
	this.album = album;
    }

    /**
     * Returns the play time of this <code>Track</code> in seconds.
     * 
     * @return the playTime
     */
    public int getPlayTime()
    {
	return playTime;
    }

    /**
     * Sets the play time of this <code>Track</code>.
     * 
     * @param seconds The new play time of the track in seconds.
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

