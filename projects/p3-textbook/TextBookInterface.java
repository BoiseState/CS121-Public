import java.util.ArrayList;

/**
 * This interface defines how the TextBook social media site works for text
 * posts and comments.
 * 
 * @author jerryfails
 */
public interface TextBookInterface {
	
	/**
	 * Get a copy of the posts ArrayList, not a reference to the internal
	 *    post instance variable itself.
	 * @return Copy of the post ArrayList
	 */
	public ArrayList<Post> getPosts();
	
	/**
	 * Takes a Post object as a parameter and adds it to the internal 
	 * ArrayList of posts.
	 * @param newPost Post to add to TextBook
	 */
	public void addPost(Post newPost);
	
	/**
	 * Remove the Post at the specified index from the ArrayList of Posts.
	 * Checks the index to make sure it is valid (>=0 and <size).
	 * @param index Index of post to remove from the social media site
	 */
	public void removePost(int index);
	
	/**
	 * Return a reference to the post at the specified index.
	 * Checks the index to make sure it is valid (>=0 and <size).
	 * @param index Index of post to retrieve from social media site 
	 * @return Reference to the specified post, null if index is out of bounds.
	 */
	public Post getPost(int index);
	
	/**
	 * Return string containing a list of the posts on the social media site
	 *    including their corresponding index position within the
	 *    ArrayList.
	 * @return String with indexed post list
	 */
	public String toString();

}
