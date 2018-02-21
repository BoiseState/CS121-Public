import java.io.File;
import java.util.Scanner;

/**
 * A class that demonstrates a console menu. It is incomplete in functionality. 
 * @author amit
 */
public class LibraryMenu
{
	private Scanner input;
	private boolean debug = false;
	private Library library;
	
	/**
	 * Stub method. Needs to be completed.
	 * @param filename The name of the file containing library data
	 */
	public LibraryMenu(String filename, boolean debug)
	{
		this.debug = debug;
		File bookFile = new File(filename);
		// read data and create a Library
		library = new Library(bookFile, debug);
	}


	/**
	 * Runs the main menu for the application
	 */
	private void runMainMenu() 
	{
		System.out.println();
		System.out.println("LibraryMenu: starting program...");
		input = new Scanner(System.in);
		String choice;
		do {
			showMainMenu();
			System.out.print("Enter your choice:");
			choice = input.next().toLowerCase();
			if (debug) System.out.println("You chose " + choice);
			switch (choice.charAt(0)) {
			case 'f':
				runFindMenu();	
				break;
			case 'a':
				runAddMenu();
				break;
			case 's':
				saveBookLibrary();
				break;
			case 'q':
				System.out.println();
				System.out.println("LibraryMenu: exiting program...");
				System.out.println();
				break;
			default:
					System.err.println("LibraryMenu: invalid choice. Please try again!");
			}
		} while (choice.charAt(0) != 'q');
	}
	
	

	/**
	 * Stub method. Needs to be completed.
	 */
	private void saveBookLibrary()
	{
		if (debug) System.out.println("LibraryMenu: invoked saveBookLibrary method");
		library.saveBookLibrary();
		// other things related to saving can be done here
	}



	/**
	 * Stub method. Needs to be completed.
	 */
	private void runAddMenu()
	{
		if (debug) System.out.println("LibraryMenu: invoked runAddMenu method");
	}



	/**
	 * Run the find menu 
	 */
	private void runFindMenu()
	{
		if (debug) System.out.println("LibraryMenu: invoked runFindMenu method");
		Book[] results = null;
		String choice;
		do {
			showFindMenu();
			System.out.print("Enter your choice:");
			choice = input.next().toLowerCase();
			if (debug) System.out.println("You chose " + choice);
			switch (choice.charAt(0)) {
			case '1':
				results = library.findByTitle();
				displayResults(results);
				break;
			case '2':
				results = library.findByAuthor();
				displayResults(results);
				break;
			case '3':
				results = library.findByYear();
				displayResults(results);
				break;
			case 'q':
				System.out.println("LibraryMenu: returning to main menu...");
				break;
			default:
				System.err.println("LibraryMenu: invalidate choice. Please try again!");
			}
		} while (choice.charAt(0) != 'q');
		
	}





	/**
	 * Stub method. Needs to be completed.
	 * @param results
	 */
	private void displayResults(Book[] results)
	{
		
	}



	/**
	 * Display the find sub-menu
	 */
	private void showFindMenu() {
		System.out.println();
		System.out.println("\tPlease choose one the following:");
		System.out.println("\t\t 1  --> find by title.");
		System.out.println("\t\t 2  --> find by author.");
		System.out.println("\t\t 3  --> find by year of publication.");
		System.out.println("\t\t q  --> quit and return to main menu.");
		System.out.println();

	}

	/**
	 * Display the main menu
	 */
	private void showMainMenu() {
		System.out.println();
		System.out.println("Please choose one of the following options:");
		System.out.println("\t f  --> Find a book ");
		System.out.println("\t a  --> Add a new book ");
		System.out.println("\t s  --> Save the current library");
		System.out.println("\t q  --> quit");
		System.out.println();
	}
	
	

	/**
	 * Starts the main application
	 * @param args Pass in a filename and debug option
	 */
	public static void main(String[] args)
	{
		if (args.length != 2) {
			System.err.println("Usage: java LibraryMenu <booklist file> <debug>");
			System.exit(1);
		}
		
		boolean debug = false;
		if (args[1].equals("debug")) {
			debug = true;
		}
		LibraryMenu app = new LibraryMenu(args[0], debug);
		
		app.runMainMenu();
	}

}
