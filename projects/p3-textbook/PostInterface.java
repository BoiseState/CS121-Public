import java.util.Date;

/**
 * This interface defines how a Post to TextBook works. 
 * Essentially, a Post stores its text, the author, when it was created,
 * and a unique ID. A getter method, getCommentFilename, returns the file 
 * location where comments are stored when it is added to this post.
 * It also provides a mechanism via getFileContents to read all of the comments
 * from that file.
 * 
 * @author jerryfails
 */ 
public interface PostInterface {
	
	/**
	 * Returns the text for this post.
	 * @return the text for this post.
	 */
	public String getText();
	
	/**
	 * Returns the date/time this post was created.
	 * @return the date/time this post was created.
	 */
	public Date getDate();
	
	/**
	 * Returns the author of this post.
	 * @return the author of this post.
	 */
	public String getAuthor();

	/**
	 * Returns the name of the file the comments are being stored in.
	 * For example this could be: "posts/Post-100100100.txt"
	 * @return
	 */

	public String getPostFilename();
	/**
	 * Gets the id of this post.
	 */
	public long getPostID();
	
	/**
	 * Adds a comment to this post by appending the comment
	 * to the posts comment file.
	 * @param author the author of the comment being added
	 * @param comment the text of the comment being added
	 */
	public void addComment(String author, String comment);
	
	/**
	 * Ensure all the attributes are set (not null) 
	 * and that the comments filename exists.
	 * @return true if valid, false if not.
	 */
	public boolean isValid();
	
	/**
	 * Return a String that contains the text contents of the 
	 * file referenced by the getFileContentsFilename method. Since this 
	 * method will need to open a file it will need to catch 
	 * the FileNotFoundException. If this Exception is raised, 
	 * simply return a String stating that the file was not able 
	 * to be opened.
	 * @return String containing text contents of post file
	 */
	public String getFileContents();
	
	/**
	 * Return a String containing the date, text, author, and file location for comments.
	 * For example: "2021-10-25 14:35:31 - CS 121 is the best class ever (even though it is challenging). (Jerry; posts/Post-100100200.txt)"
	 * @return String with post details
	 */
	public String toString();

}
