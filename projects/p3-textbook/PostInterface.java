import java.util.Date;

/**
 * @author jerryfails
 */
public interface PostInterface {
	
	public String getText();
	public void setText(String text);
	
	public Date getDate();
	
	public String getAuthor();
	public void setAuthor(String author);

	public String getCommentsFilename();
	public void setPostID(long postID);
	
	public void addComment(String author, String comment);
	
	/**
	 * Ensure all the attributes are set (not null) 
	 * and that the comments filename exists.
	 * @return true if valid, false if not.
	 */
	public boolean isValid();
	
	/**
	 * Return a String that contains the text contents of the 
	 * file referenced by the Filename attribute. Since this 
	 * method will need to open a file it will need to catch 
	 * the FileNotFoundException. If this Exception is raised, 
	 * simply return a String stating that the file was not able 
	 * to be opened.
	 * @return String containing text contents of post
	 */
	public String getComments();
	
	/**
	 * Return a String containing the Text, Author, Date, and ID of the post, 
	 *    but not the filepath.
	 * @return String with post details
	 */
	public String toString();

}
