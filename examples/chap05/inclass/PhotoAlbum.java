package inclass;

import java.util.ArrayList;

/**
 * The PhotoAlbum class has a list of Photos. It is an aggregate class.
 * 
 * @author CS121 Instructors
 */
public class PhotoAlbum
{
	private String name;
	private ArrayList<Photo> photos;

	/**
	 * Creates a new photo album with the given name. The album will be empty.
	 * @param name The name of the album.
	 */
	public PhotoAlbum(String name)
	{
		this.name = name;
		this.photos = new ArrayList<Photo>();
	}
	
	/**
	 * Adds the photo to this album.
	 * @param p The photo to add.
	 */
	public void addPhoto(Photo p)
	{
		this.photos.add(p);
	}
	
	/**
	 * Returns a reference to the photo at the specified index.
	 * @param i The index of the photo.
	 * @return The photo (or null if none exists).
	 */
	public Photo getPhoto(int i)
	{
		if(i >= 0 && i < photos.size())
		{
			return photos.get(i);
		}
		return null;
	}
	
	/**
	 * Removes the photo at the specified index from this album and returns it.
	 * @param i The index of the photo to remove.
	 * @return The removed photo or null if not found.
	 */
	public Photo removePhoto(int i)
	{
		if(i >= 0 && i < photos.size())
		{
			return photos.remove(i);
		}
		return null;
	}

	/**
	 * Returns the number of photos in this album.
	 * @return the number of photos in this album.
	 */
	public int getNumPhotos()
	{
		return photos.size();
	}

	/**
	 * Returns a copy of the photos list as an array of Photos.
	 * @return an array of Photos in the album.
	 */
	public Photo[] getPhotoArray()
	{
		Photo[] copy = new Photo[photos.size()];

		// TODO: Use a for-loop to copy the contents from the photos ArrayList to
		// a new Photo[] and return the copied array.

		return copy;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("------ " + name + " ------\n");
		for(int i = 0; i < photos.size(); i++) {
			builder.append(i + ": " + photos.get(i) + "\n");
		}
		return builder.toString();
	}
}