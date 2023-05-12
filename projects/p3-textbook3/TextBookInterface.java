import java.util.ArrayList;

/**
 * DO NOT MODIFY THIS INTERFACE - It is the responsibility of your TextBook class
 * to provide methods that look and behave exactly as described in this interface.
 * 
 * A TextBook manages a collection of Posts for the TextBook social media site. 
 * All Post IDs are recorded in a file with the name specified in constant
 * POST_LIST_FILENAME. A TextBook must implement this interface as follows:
 *   public class TextBook implements TextBookInterface
 * 
 * In addition to the methods listed below, a TextBook is expected to have a single
 * constructor with no parameters. When instantiated, a TextBook attempts to restore 
 * the previous session from files. If it is unable to do so, it initiates a new 
 * empty list of Posts and sets the last post ID to zero. This constructor has
 * signature:
 *   public TextBook()
 * 
 * @author mvail, jerryfails
 */
public interface TextBookInterface {
	/** 
	 * This constant defines the expected name of the file that contains a
	 * list of all Post IDs in the TextBook, one ID per line.
	 */
	public static final String POST_LIST_FILENAME = "postIDs.txt";
	
	/**
	 * Return the last Post ID assigned to a Post in TextBook. If TextBook has
	 * just been loaded, this number corresponds to the last ID read from file 
	 * POST_LIST_FILENAME or 0 if the file was not found.
	 * 
	 * @return current value of lastID
	 */
	public int getLastID();
	
	/**
	 * Return the number of Posts currently in TextBook's collection.
	 * 
	 * @return current number of Posts
	 */
	public int getPostCount();
	
	/**
	 * Returns the String from the indexed Post's toString(), which includes the Post
	 * itself and its comments.
	 * 
	 * @param index index of Post
	 * @return toString() from Post at given index
	 */
	public String getPostString(int index);
	
	/**
	 * Increments the value of last ID. This becomes the ID for the new Post.
	 * Adds a new Post with the given author and text to the TextBook and appends
	 * the new ID to file POST_LIST_FILENAME.
	 * 
	 * @param author name of the new Post's author
	 * @param text text of the new Post
	 */
	public void addPost(String author, String text);
	
	/**
	 * Removes and returns the Post at the given index. Rewrites file 
	 * POST_LIST_FILENAME to include only the IDs of Posts still in the collection.
	 * 
	 * @param index the index of a Post in TextBook's collection
	 * @return removed Post
	 */
	public Post removePost(int index);
	
	/**
	 * Adds a new comment with the given author and text to the Post at the given
	 * index.
	 * 
	 * @param postIndex index of post targeted by this comment
	 * @param author name of comment's author
	 * @param text text of the comment
	 */
	public void addComment(int postIndex, String author, String text);
	
	/**
	 * Returns a well-formatted String with the current number of Posts and a list 
	 * of Posts where each Post's toStringPostOnly() is preceded by its index in the 
	 * collection and each Post is on its own line as shown in the example.
	 * Example:
	 *   "TextBook contains 2 posts:
	 *   0 - 00010 2021-11-02T12:20:59.122Z Mason Did stuff.
	 *   1 - 00011 2021-11-02T12:45:52.023Z Luke Heckled Mason."
	 * 
	 * @return well-formatted String with post count and indexed posts
	 */
	public String toString();	
	
	/**
	 * Returns a COPY of the posts list for testing. Make sure you are not violating
	 * encapsulation by directly returning the posts variable or an alias of the
	 * posts variable.
	 * (Note that a copy of the list still violates ideal encapsulation because we’re 
	 * not performing a ‘deep’ copy of the Post objects themselves. However, this is 
	 * adequate for testing purposes.)
	 * 
	 * @return copy of posts list
	 */
	public ArrayList<Post> getPosts();

}
