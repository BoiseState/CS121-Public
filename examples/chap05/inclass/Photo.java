package inclass;

/**
 * Represents a photo.
 * 
 * @author CS121 Instructors
 */
public class Photo
{
	private final int MAX_RATING = 5;
	private final int MIN_RATING = 1;
	private String description;
	private String file;
	private int rating;

	/**
	 * Creates a new Photo with the given description, file, and rating.
	 *
	 * To create a new photo, use the constructor as follows:
	 *
	 * Photo photo = new Photo(description, file, rating);
	 * 
	 * @param description The description of the photo.
	 * @param file The file name/path of the photo.
	 * @param rating The rating of the photo. Must be between 1 and 5.
	 */
	public Photo(String description, String file, int rating)
	{
		this.description = description;
		this.file = file;

		/* make sure rating is within valid bounds. */
		if(rating > MAX_RATING) {
			System.out.println("Rating too high. Setting to MAX (" + MAX_RATING + ")");
			this.rating = MAX_RATING;
		} else if(rating < MIN_RATING) {
			System.out.println("Rating too low. Setting to MIN (" + MIN_RATING + ")");
			this.rating = MIN_RATING;
		} else {
			this.rating = rating;
		}
	}

	/**
	 * Returns the description of this photo.
	 * @return the description.
	 */
	public String getDescription()
	{
		return this.description;
	}

	/**
	 * Returns the file of this photo.
	 * @return the file.
	 */
	public String getFile()
	{
		return this.file;
	}

	/**
	 * Returns the rating of this photo.
	 * @return the rating.
	 */
	public int getRating()
	{
		return this.rating;
	}

	@Override
	public String toString()
	{
		return "[File: " + file + ", Description: " + description + ", Rating: " + rating + "]";
	}
}