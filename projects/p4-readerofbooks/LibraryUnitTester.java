import java.util.ArrayList;

/**
 * Test Library functionality.
 * 
 * @author mvail
 * @author marissa
 * @author Luke Hindman
 */
public class LibraryUnitTester {
	
	private static int status = 0;
	
	public static void main(String[] args) {
		
		testConstructor();
		
		testAddGetBookMethods();
		
		testGetBooksMethod();
		
		testAddRemoveBookMethods();
		
		testToStringMethod();
		
		testLoadLibraryFromCSVMethod();
		
		System.exit(status);
	}
	
	
	private static void testConstructor()
	{


		
		String testName = "testConstructor";
		boolean testPassed = true;
		String testResults = "";
		try
		{
			String subtest = testName + " - new Library()";
			LibraryInterface littleLibrary = new Library();
			
			testResults += subTestPass(subtest);

		} catch (Exception e)
		{
			testResults += subTestFailure(testName, "Test Execution", "Exception thrown. ");
			testResults += e.toString();
			testPassed = false;
			e.printStackTrace();
		}
		
		if (testPassed) {
			pass(testName,testResults);
		} else {
			fail(testName,testResults);
		}
	}
	
	private static void testAddGetBookMethods()
	{
		/* Define variables for the test */
		Book alice = getAliceInWonderland();
		Book gettysburg = getGettysburgAddress();
		Book leaves = getLeavesOfGrass();		

		String testName = "testAddGetBookMethods";		
		boolean testPassed = true;
		String testResults = "";
		try
		{
			/* Create a new book object */
			LibraryInterface littleLibrary = new Library();
			
			/* Test add/get single book */ 
			String subtest = testName + " - add/get single book";
			littleLibrary.addBook(alice);
			Book value = littleLibrary.getBook(0);
			if (value.equals(alice)){
					testResults += subTestPass(subtest);		
			} else {
				testResults += subTestFailure(subtest, alice.toString(), value.toString());
				testPassed = false;
			}
			
			/* Test add/get second book */
			subtest = testName + " - add/get second book";
			littleLibrary.addBook(leaves);
			value = littleLibrary.getBook(1);
			if (value.equals(leaves)){
				value = littleLibrary.getBook(0);
				if(value.equals(alice)) {
					testResults += subTestPass(subtest);
				} else {
					testResults += subTestFailure(subtest, alice.toString(), value.toString());
					testPassed = false;
				}
			} else {
				testResults += subTestFailure(subtest, leaves.toString(), value.toString());
				testPassed = false;
			}
			
			/* Test get invalid index */ 
			subtest = testName + " - Get invalid index";
			littleLibrary = new Library();
			littleLibrary.addBook(alice);
			
			value = littleLibrary.getBook(1);
			if (value == null) {
				testResults += subTestPass(subtest); 
			} else {
				testResults += subTestFailure(subtest, null, value.toString());
				testPassed = false;
			}

		}
		catch (Exception e)
		{
			testResults += subTestFailure(testName, "Test Execution", "Exception thrown. ");
			testResults += e.toString();
			testPassed = false;
			e.printStackTrace();
		}
		
		if (testPassed) {
			pass(testName,testResults);
		} else {
			fail(testName,testResults);
		}
	}
	
	private static void testAddRemoveBookMethods()
	{
		/* Define variables for the test */
		Book alice = getAliceInWonderland();
		Book gettysburg = getGettysburgAddress();
		Book leaves = getLeavesOfGrass();		

		String testName = "testAddRemoveBookMethods";		
		boolean testPassed = true;
		String testResults = "";
		try
		{
			/* Create a new book object */
			LibraryInterface littleLibrary = new Library();
			
			/* Test add/get single book */ 
			String subtest = testName + " - Remove multiple books";
			littleLibrary.addBook(alice);
			littleLibrary.addBook(gettysburg);
			littleLibrary.addBook(leaves);
			
			Book value = littleLibrary.getBook(0);
			if (value.equals(alice)){
				/* Remove first book - alice */
				littleLibrary.removeBook(0);
				value = littleLibrary.getBook(0);
				if (value.equals(gettysburg)) {
					/* Remove end book - leaves */
					littleLibrary.removeBook(1);
					value = littleLibrary.getBook(0);
					if (value.equals(gettysburg)) {
						testResults += subTestPass(subtest); 
					} else {
						testResults += subTestFailure(subtest, gettysburg.toString(), value.toString());
						testPassed = false;
					}
				} else {
					testResults += subTestFailure(subtest, gettysburg.toString(), value.toString());
					testPassed = false;
				}				
			} else {
				testResults += subTestFailure(subtest, alice.toString(), value.toString());
				testPassed = false;
			}
			
			littleLibrary = new Library();
			
			/* Test remove invalid index */ 
			subtest = testName + " - Remove invalid index";
			littleLibrary.addBook(alice);
			
			littleLibrary.removeBook(1);
			testResults += subTestPass(subtest); 
			

		}
		catch (Exception e)
		{
			testResults += subTestFailure(testName, "Test Execution", "Exception thrown. ");
			testResults += e.toString();
			testPassed = false;
			e.printStackTrace();
		}
		
		if (testPassed) {
			pass(testName,testResults);
		} else {
			fail(testName,testResults);
		}
	}
	
	private static void testGetBooksMethod()
	{
		/* Define variables for the test */
		Book alice = getAliceInWonderland();
		Book gettysburg = getGettysburgAddress();
		Book leaves = getLeavesOfGrass();		

		String testName = "testGetBooksMethod";		
		boolean testPassed = true;
		String testResults = "";
		try
		{
			/* Create a new book object */
			LibraryInterface littleLibrary = new Library();
			
			/* Test adding 3 books and check number of books is 3 */ 
			String subtest = testName + " - Number of books";
			littleLibrary.addBook(alice);
			littleLibrary.addBook(gettysburg);
			littleLibrary.addBook(leaves);
			
			ArrayList<Book> value = littleLibrary.getBooks();
			
			if (value.size() == 3){
					testResults += subTestPass(subtest);		
			} else {
				testResults += subTestFailure(subtest, "3", Integer.toString(value.size()));
				testPassed = false;
			}
			
			/* Test that modifications to returned books ArrayList do not affect Library */
			subtest = testName + " - Copy of books array (Encapsulation)";
			value.remove(0);
			value = littleLibrary.getBooks();
			if (value.size() == 3){
				testResults += subTestPass(subtest);		
			} else {
				testResults += subTestFailure(subtest, "3", Integer.toString(value.size()));
				testPassed = false;
			}
			

		}
		catch (Exception e)
		{
			testResults += subTestFailure(testName, "Test Execution", "Exception thrown. ");
			testResults += e.toString();
			testPassed = false;
			e.printStackTrace();
		}
		
		if (testPassed) {
			pass(testName,testResults);
		} else {
			fail(testName,testResults);
		}
	}
	
	private static void testToStringMethod()
	{
		/* Define variables for the test */
		Book alice = getAliceInWonderland();
		Book gettysburg = getGettysburgAddress();
		Book leaves = getLeavesOfGrass();		

		String testName = "testToStringMethod";		
		boolean testPassed = true;
		String testResults = "";
		try
		{
			/* Create a new book object */
			LibraryInterface littleLibrary = new Library();
			
			/* Test adding 3 books and check number of books is 3 */ 
			
			littleLibrary.addBook(alice);
			littleLibrary.addBook(gettysburg);
			
			String value = littleLibrary.toString();
			String subtest = testName + " - toString() includes first book";
			if (value.contains(alice.toString())){
					testResults += subTestPass(subtest);		
			} else {
				testResults += subTestFailure(subtest, alice.toString(), value);
				testPassed = false;
			}
			
			subtest = testName + " - toString() includes second book";
			if (value.contains(gettysburg.toString())){
					testResults += subTestPass(subtest);		
			} else {
				testResults += subTestFailure(subtest, gettysburg.toString(), value);
				testPassed = false;
			}
			

		}
		catch (Exception e)
		{
			testResults += subTestFailure(testName, "Test Execution", "Exception thrown. ");
			testResults += e.toString();
			testPassed = false;
			e.printStackTrace();
		}
		
		if (testPassed) {
			pass(testName,testResults);
		} else {
			fail(testName,testResults);
		}
	}
	
	
	private static void testLoadLibraryFromCSVMethod()
	{
		/* Define variables for the test */
		
		String csvImportFile = "etext/booklist.csv";

		String testName = "testLoadLibraryFromCSVMethod";		
		boolean testPassed = true;
		String testResults = "";
		try
		{
			/* Create a new book object */
			LibraryInterface littleLibrary = new Library();
			
			/* Test loading 3 books from csv file*/ 
			String subtest = testName + " - Load three books";
			
			littleLibrary.loadLibraryFromCSV(csvImportFile);
			
			ArrayList<Book> value = littleLibrary.getBooks();
			
			if (value.size() == 3){
					testResults += subTestPass(subtest);		
			} else {
				testResults += subTestFailure(subtest, "3", Integer.toString(value.size()));
				testPassed = false;
			}
			
			/* Test that all books are loaded completely (are valid) */
			subtest = testName + " - Validate books are complete";
			boolean booksAreValid = true;
			for (Book b: littleLibrary.getBooks()) {
				if (! b.isValid() ) {
					booksAreValid = false;
				}
			}
			if (booksAreValid) {
				testResults += subTestPass(subtest);
			} else {
				testResults += subTestFailure(subtest,"All loaded books are valid", "One or more loaded books are not valid");
				testPassed = false;
			}
		}
		catch (Exception e)
		{
			testResults += subTestFailure(testName, "Test Execution", "Exception thrown. ");
			testResults += e.toString();
			testPassed = false;
			e.printStackTrace();
		}
		
		if (testPassed) {
			pass(testName,testResults);
		} else {
			fail(testName,testResults);
		}
	}
	
	
	private static Book getAliceInWonderland() {
		String author = "Lewis Carroll";
		String title = "ALICE'S ADVENTURES IN WONDERLAND";
		String genre = "nonfiction";
		String filename = "etext/Alice-in-Wonderland.txt";
		
		Book goodBook = new Book(title,author);
		goodBook.setGenre(genre);
		goodBook.setFilename(filename);
		
		return goodBook;
	}
	
	private static Book getGettysburgAddress() {
		String author = "Abraham Lincoln";
		String title = "Gettysburg Address";
		String genre = "nonfiction";
		String filename = "etext/Gettysburg-Address.txt";
		
		Book goodBook = new Book(title,author);
		goodBook.setGenre(genre);
		goodBook.setFilename(filename);
		
		return goodBook;
	}
	
	private static Book getLeavesOfGrass() {
		String author = "Walt Whitman";
		String title = "Leaves of Grass";
		String genre = "fiction";
		String filename = "etext/Leaves-of-Grass.txt";
		
		Book goodBook = new Book(title,author);
		goodBook.setGenre(genre);
		goodBook.setFilename(filename);
		
		return goodBook;
	}
	
	
	private static String subTestFailure(String testName, String expected, String actual)
	{
		String output = "    (error): " + testName + "\n";
		output += "        --> expected: " + expected + "\n";
		output += "        -->   actual: " + actual + "\n";
		
		return output;
	}
	
	private static String subTestPass(String testName) {
		return "    " + testName + "\n";
	}
	
	private static void fail(String testName, String message)
	{
		System.err.println("FAILED: " + testName);
		System.err.println("    " + message.trim());
		status = 1;
	}

	private static void pass(String testName, String message)
	{
		System.out.println("PASSED: " + testName);
		System.out.println("    " + message.trim());
	}

}
