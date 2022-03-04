import java.util.ArrayList;

/**
 * DO NOT MODIFY THIS INTERFACE - It is the responsibility of your TextBook class
 * to provide methods that look and behave exactly as described in this interface.
 * 
 * A TextBook manages the posts of the TextBook social media site. When instantiated,
 * a TextBook attempts to restore the previous session from files. If it is unable
 * to do so, it initiates a new empty list of posts and resets the last post ID to 
 * zero.
 * 
 * @author mvail
 * @author jerryfails
 */
public interface TextBookInterface {
	/** 
	 * This constant defines the expected name of the file that contains a
	 * list of all Post IDs in the TextBook, one ID per line.
	 */
	public static final String POST_LIST_FILENAME = "posts.txt";
	
	/**
	 * Return the last post ID assigned to a Post in TextBook. If TextBook has
	 * just been loaded, this number corresponds to the last ID read from the 
	 * posts file named POST_LIST_FILENAME or 0 if the file contained no IDs or
	 * is not found.
	 * @return current value of lastID
	 */
	public int getLastID();
	
	/**
	 * Return the number of Posts currently in TextBook's collection.
	 * @return current number of Posts
	 */
	public int getPostCount();
	
	/**
	 * Returns the String from the indexed Post's toString(), which includes the Post
	 * itself and its comments. Returns null if the index is invalid.
	 * @param index index of Post
	 * @return toString() from Post at given index or null if invalid index
	 */
	public String getPostString(int index);
	
	/**
	 * Adds a new Post with the given author and text to the collection of Posts.
	 * Updates the file with name POST_LIST_FILENAME to include the new Post ID.
	 * Updates the value of last ID.
	 * @param author name of the new Post's author
	 * @param text text of the new Post
	 * @return true if successful, else false
	 */
	public boolean addPost(String author, String text);
	
	/**
	 * Remove and return Post at given index or return null if invalid index.
	 * Updates file with name POST_LIST_FILENAME if index was valid to no longer
	 * include removed Post ID.
	 * @param index the index of a Post in TextBook's collection
	 * @return removed Post or null if index was invalid
	 */
	public Post removePost(int index);
	
	/**
	 * Adds a new comment with the given author and text to the Post at the given
	 * index if valid. If the given index is invalid, return false.
	 * @param postIndex index of post targeted by this comment
	 * @param author name of comment's author
	 * @param text text of the comment
	 * @return true if index is valid, else false
	 */
	public boolean addComment(int postIndex, String author, String text);
	
	/**
	 * Returns a well-formatted String with number of Posts and a list of Posts 
	 * where each Post's toString() is preceded by its index in the collection 
	 * and each post is on its own line as shown in the example.
	 * Example:
	 *  	"TextBook contains 2 posts:
	 *		0 - 00010 2021-11-02T12:20:59.122Z Mason Did stuff.
	 *		1 - 00011 2021-11-02T12:45:52.023Z Luke Heckled Mason."
	 * @return well-formatted String with post count and indexed posts
	 */
	public String toString();	
	
	/**
	 * Returns a COPY of the posts list for testing. Make sure you are not violating
	 * encapsulation by returning your posts variable or an alias.
	 * @return copy of posts list
	 */
	public ArrayList<Post> getPosts();

}
