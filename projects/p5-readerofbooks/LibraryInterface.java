import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Luke Hindman
 *
 */
public interface LibraryInterface {
	
	/**
	 * Get a copy of the books ArrayList, not a reference to the internal
	 *    books instance variable itself.
	 * @return Copy of the books ArrayList
	 */
	public ArrayList<Book> getBooks();
	
	/**
	 * Takes a Book object as a parameter and adds it to the internal 
	 * ArrayList of Books.
	 * @param newBook Book to add to Library
	 */
	public void addBook(Book newBook);
	
	/**
	 * Remove the Book at the specified index with the ArrayList of Books
	 * @param index Index of book to remove from Library
	 */
	public void removeBook(int index);
	
	/**
	 * Return a reference to the Book at the specified index.
	 * @param index Index of Book to retrieve from Library 
	 * @return Reference to the specified Book, null if index is out of bounds.
	 */
	public Book getBook(int index);
	
	/**
	 * Return string containing a list of the books in the library
	 *    including their cooresponding index position within the
	 *    ArrayList.
	 * @return String with indexed booklist
	 */
	public String toString();
	
	/**
	 * Populate the library with books from the specified CSV formated text file
	 * Format:
	 *     title, author, genre, filepath
	 * @param csvFilename Text file with CSV formated book data
	 */
	public void loadLibraryFromCSV(String csvFilename);	
		

}
