import java.io.BufferedReader;

/**
 * 
 */

/**
 * @author Luke Hindman
 *
 */
public interface BookReaderInterface {
	
	/**
	 * This method provide a more efficient way to read the book's text
	 *    content than the getText() method. Use the Java API for the 
	 *    BufferedReader class to learn how to open the book txt file and
	 *    create a new BufferedReader instance. 
	 * @return Returns a new BufferedReader instance that is associated with the text
	 *    filename specified in the Book object. If the text filename is not set 
	 *    or if the text file does not exit, return null
	 */
	public BufferedReader getReader();
	

}
