import java.util.Scanner;

/**
 * Test Book functionality.
 * 
 * @author mvail
 * @author marissa
 * @author Luke Hindman
 */
public class BookUnitTester
{	
	private static int status = 0;
	
	/**
	 * @param args required int gridSize
	 */
	public static void main(String[] args)
	{
		
		
		testConstructor();
		
		testSettersAndGetters();
		
		testIsValidMethod();
		
		testToStringMethod();
		
		testGetTextMethod();

		
		System.exit(status);
	}
	
	private static void testConstructor()
	{
		String author = "Lewis Carroll";
		String title = "ALICE'S ADVENTURES IN WONDERLAND";

		
		String testName = "testConstructor";
		
		boolean testPassed = true;
		String testResults = "";
		try
		{
			String subtest = testName + " - new Book(\"" + title +",\"" + author + "\")";
			BookInterface goodBook = new Book(title,author);

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
	
	private static void testSettersAndGetters()
	{
		/* Define variables for the test */
		String author = "Lewis Carroll";
		String title = "ALICE'S ADVENTURES IN WONDERLAND";
		String genre = "nonfiction";
		String filename = "etext/Alice-in-Wonderland.txt";
		String testName = "testSettersAndGetters";
		
		boolean testPassed = true;
		String testResults = "";
		try
		{
			/* Create a new book object */
			BookInterface goodBook = new Book(title,author);
			
			/* Test setAuthor() and getAuthor() */ 
			String subtest = testName + " - author";
			String value = goodBook.getAuthor();
			if (value.equals(author)){
				String newAuthor="Mark Twain";
				goodBook.setAuthor(newAuthor);
				value = goodBook.getAuthor();
				if (value.equals(newAuthor)) {
					testResults += subTestPass(subtest);
				} else {
					testResults += subTestFailure(subtest,"Author should be " + newAuthor, "Author returned is " + value);
					testPassed = false;
				}			
			} else {
				testResults += subTestFailure(subtest,"Author should be " + author, "Author returned is " + value);
				testPassed = false;
			}
			
			/* Test setTitle() and getTitle() */
			subtest = testName + " - title";
			value = goodBook.getTitle();
			if (value.equals(title)){
				String newTitle="Adventures of Huck Finn";
				goodBook.setTitle(newTitle);
				value = goodBook.getTitle();
				if (value.equals(newTitle)) {
					testResults += subTestPass(subtest);
				} else {
					testResults += subTestFailure(subtest,"Title should be " + newTitle, "Title returned is " + value);
					testPassed = false;
				}			
			} else {
				testResults += subTestFailure(subtest,"Title should be " + title, "Title returned is " + value);
				testPassed = false;
			}
			
			/* Test setGenre() and getGenre() */
			subtest = testName + " - genre";
			goodBook.setGenre(genre);
			value = goodBook.getGenre();
			if (value.equals(genre)){
				testResults += subTestPass(subtest);		
			} else {
				testResults += subTestFailure(subtest,"Genre should be " + genre, "Genre returned is " + value);
				testPassed = false;
			}
			
			/* Test setFilename() and getFilename() */
			subtest = testName + " - filename";
			goodBook.setFilename(filename);
			value = goodBook.getFilename();
			if (value.equals(filename)){
				testResults += subTestPass(subtest);		
			} else {
				testResults += subTestFailure(subtest,"Filename should be " + filename, "Filename returned is " + value);
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

	private static void testIsValidMethod()
	{
		/* Define variables for the test */
		String author = "Lewis Carroll";
		String title = "ALICE'S ADVENTURES IN WONDERLAND";
		String genre = "nonfiction";
		String filename = "etext/Alice-in-Wonderland.txt";
		String testName = "testIsValidMethod";
		
		boolean testPassed = true;
		String testResults = "";
		try
		{
			String subtest = testName + " - Book is valid ";
			BookInterface goodBook = new Book(title,author);
			goodBook.setGenre(genre);
			goodBook.setFilename(filename);
			if (goodBook.isValid()) {
				testResults += subTestPass(subtest);
			} else {
				testResults += subTestFailure(subtest, "isValid() == true", "isValid() == false");
				testPassed = false;
			}
			
			subtest = testName + " - Book not valid (author = null)";
			goodBook = new Book(title,null);
			goodBook.setGenre(genre);
			goodBook.setFilename(filename);
			
			if (goodBook.isValid()) {
				testResults += subTestFailure(subtest, "isValid() == false", "isValid() == true");
				testPassed = false;
			} else {
				testResults += subTestPass(subtest);
			}
			
			subtest = testName + " - Book not valid (title = null)";
			goodBook = new Book(null,author);
			goodBook.setGenre(genre);
			goodBook.setFilename(filename);
			
			if (goodBook.isValid()) {
				testResults += subTestFailure(subtest, "isValid() == false", "isValid() == true");
				testPassed = false;
			} else {
				testResults += subTestPass(subtest);
			}
			
			subtest = testName + " - Book not valid (genre = null)";
			goodBook = new Book(title,author);
			goodBook.setGenre(null);
			goodBook.setFilename(filename);
			
			if (goodBook.isValid()) {
				testResults += subTestFailure(subtest, "isValid() == false", "isValid() == true");
				testPassed = false;
			} else {
				testResults += subTestPass(subtest);
			}
			
			subtest = testName + " - Book not valid (filename = null)";
			goodBook = new Book(title,author);
			goodBook.setGenre(genre);
			goodBook.setFilename(null);
			
			if (goodBook.isValid()) {
				testResults += subTestFailure(subtest, "isValid() == false", "isValid() == true");
				testPassed = false;
			} else {
				testResults += subTestPass(subtest);
			}
			
			subtest = testName + " - Book not valid (file does not exist)";
			goodBook = new Book(title,author);
			goodBook.setGenre(genre);
			goodBook.setFilename("does not exist.txt");
			
			if (goodBook.isValid()) {
				testResults += subTestFailure(subtest, "isValid() == false", "isValid() == true");
				testPassed = false;
			} else {
				testResults += subTestPass(subtest);
			}
			
			
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
	
	private static void testToStringMethod()
	{
		/* Define variables for the test */
		String author = "Lewis Carroll";
		String title = "ALICE'S ADVENTURES IN WONDERLAND";
		String genre = "nonfiction";
		String filename = "etext/Alice-in-Wonderland.txt";
		String testName = "testToStringMethod";
		
		boolean testPassed = true;
		String testResults = "";
		try
		{
			String subtest = testName + " - toString() includes author ";
			BookInterface goodBook = new Book(title,author);
			goodBook.setGenre(genre);
			goodBook.setFilename(filename);
			String value = goodBook.toString();
			if (value.contains(author)) {
				testResults += subTestPass(subtest);
			} else {
				testResults += subTestFailure(subtest, author, value);
				testPassed = false;
			}
			
			subtest = testName + " - toString() includes title ";
			if (value.contains(title)) {
				testResults += subTestPass(subtest);
			} else {
				testResults += subTestFailure(subtest, title, value);
				testPassed = false;
			}
			
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
	
	private static void testGetTextMethod()
	{
		/* Define variables for the test */
		String author = "Lewis Carroll";
		String title = "ALICE'S ADVENTURES IN WONDERLAND";
		String genre = "nonfiction";
		String filename = "etext/Alice-in-Wonderland.txt";
		String testName = "testGetTextMethod";
		
		boolean testPassed = true;
		String testResults = "";
		try
		{
			String subtest = testName + " - Check line count ";
			BookInterface goodBook = new Book(title,author);
			goodBook.setGenre(genre);
			goodBook.setFilename(filename);
			
			String text = goodBook.getText();
			Scanner bookScanner = new Scanner(text);
			int numLines = 0;
			while (bookScanner.hasNext()) {
				bookScanner.nextLine();
				numLines++;
			}
			
			bookScanner.close();
			
			if (numLines == 3609) {
				testResults += subTestPass(subtest);
			} else {
				testResults += subTestFailure(subtest, "3609 lines of text", numLines + " lines of text");
				testPassed = false;
			}
			
			
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

