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
	 * @return String containing text contents of book
	 */
	public String getComments();
	
	/**
	 * Return a String containing the Title, Author and Genre of the book, 
	 *    but not the filepath.
	 * @return String with book details
	 */
	public String toString();

}
