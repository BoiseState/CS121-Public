import java.io.File;
import java.util.ArrayList;



/**
 * An empty collection of Books for use with the menu demo program.
 * @author amit
 *
 */
public class Library
{
	private ArrayList<Book> library;
	private boolean debug = false;
	
	/**
	 * Constructor: a stub that needs to be completed
	 */
	public Library(File booklist, boolean debug)
	{
		this.debug = debug;
	}


	/**
	 * Accessor for library.
	 * @return the library
	 */
	public ArrayList<Book> getLibrary()
	{
		return library;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		// stub method: needs to be completed
		// return a list of books printed out nicely using the toString from the Book class
		return null;
	}


	/**
	 * Mutator for library.
	 * @param library the library to set
	 */
	public void setLibrary(ArrayList<Book> library)
	{
		this.library = library;
	}


	/**
	 * Search for books by publication year.
	 * @return
	 */
	public Book[] findByYear()
	{
		if (debug) System.out.println("Library: invoked findByYear method");
		return null;
	}


	/**
	 * Search for books by author name.
	 * @return
	 */
	public Book[] findByAuthor()
	{
		if (debug) System.out.println("Library: invoked findByAuthor method");
		return null;
	}


	/**
	 * Search for books by title.
	 * @return
	 */
	public Book[] findByTitle()
	{
		if (debug) System.out.println("Library: invoked findByTitle method");
		return null;
	}
	
	
	/**
	 * Save the library file to disk
	 */
	public void saveBookLibrary() {
		// save the library to a file on disk
		if (debug) System.out.println("Library: invoked saveBookLibrary method");
	}
}
