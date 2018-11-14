/**
 * 
 */

/**
 * @author Luke Hindman
 *
 */
public interface BookInterface {
	
	public String getTitle();
	
	public void setTitle(String title);
	
	public String getAuthor();
	
	public void setAuthor(String author);
	
	public String getGenre();
	
	public void setGenre(String genre);

	public String getFilename();
	
	public void setFilename(String filename);
	
	/**
	 * Ensure all the attributes are set (not null) 
	 * and that the referenced Filename exists.
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
	public String getText();
	
	/**
	 * Return a String containing the Title, Author and Genre of the book, 
	 *    but not the filepath.
	 * @return String with book details
	 */
	public String toString();

}
