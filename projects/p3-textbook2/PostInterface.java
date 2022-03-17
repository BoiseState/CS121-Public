import java.time.Instant;

/**
 * DO NOT MODIFY THIS INTERFACE - It is the responsibility of your Post class to
 * provide methods that look and behave exactly as defined in this interface.
 * 
 * A Post represents a single text post in a TextBook social media site along with
 * its associated comments. A Post must implement this interface as follows:
 * 	public class Post implements PostInterface
 * 
 * In addition to the methods listed for this interface, a Post is expected to have
 * two constructors. The first is used to create a new Post from user input and
 * must have the following signature:
 * 	public Post(int id, String author, String text)
 * The second constructor is used to restore a Post from the data stored in its
 * associated text file and must have the following signature:
 * 	public Post(int id)
 * 
 * @author mvail
 * @author jerryfails
 */
public interface PostInterface {
	
	/**
	 * Adds a comment with the given values and the current timestamp to this Post.
	 * Appends comment timestamp, author, and text to Post's associated file.
	 * (Optionally adds new Comment object to a comments list.)
	 *
	 * @param author one-word username of the author, e.g. "AdaLovelace"
	 * @param text complete post text
	 */
	public void addComment(String author, String text);

	/**
	 * Returns true if no instance variables are null and a readable file with 
	 * name matching getFilename() exists, else false.
	 * 
	 * @return true if no instance variables are null and a readable file with name matching getFilename() exists, else false
	 */
	public boolean isValid();
	
	/**
	 * Returns a well-formatted String including the original post and all comments, 
	 * each on their own lines. Intended for use when a specific post and all of its 
	 * associated comments should be printed to console. Note that post ID should
	 * be formatted to 5-digits as shown in the example. The timestamp conforms to
	 * ISO-8601 standard as returned by an Instant's toString(). Comment lines
	 * should be indented with a tab.
	 * Example:
	 * 	"00010 2021-11-30T23:38:23.085Z Mason Did stuff.
	 * 		2021-12-01T08:18:21.055Z Luke It's late...
	 * 		2021-12-01T09:22:03.142Z Kathryn And it wasn't the right stuff." 
	 * 
	 * @return a well-formatted String including post and all comments 
	 */
	public String toString();
	
	/**
	 * Returns a well-formatted String including post ID, date, author, and text of 
	 * the original post, exactly as shown in the first line of toString() output.
	 * Intended for use when a list of posts is printed to console.
	 * Example:
	 * 	"00010 2021-11-30T23:38:23.085Z Mason Did stuff"
	 * 
	 * @return well-formatted String including id, date, author, and post text only
	 */
	public String toStringPostOnly();
	
	/**
	 * Return associated filename with format: Post-<postID>.txt
	 * where postID is formatted to 5 digits as shown in the example.
	 * Example:
	 * 	Post-00010.txt
	 * 
	 * @return filename associated with post ID
	 */
	public String getFilename();
	
	/**
	 * Return post ID.
	 * 
	 * @return post ID
	 */
	public int getPostID();
	
	/**
	 * Return text of original post.
	 * 
	 * @return text of original post
	 */
	public String getText();
	
	/**
	 * Return timestamp of original Post as Instant.
	 * 
	 * @return Instant of original post
	 */
	public Instant getTimestamp();
	
	/**
	 * Return author of original Post.
	 * 
	 * @return author of original post
	 */
	public String getAuthor();

}
