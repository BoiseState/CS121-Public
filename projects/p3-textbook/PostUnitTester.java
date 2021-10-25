import java.util.Scanner;

/**
 * Test Post functionality.
 * 
 * @author mvail
 * @author marissa
 * @author lhindman
 * @author jerryfails
 */
public class PostUnitTester
{	
	private static int status = 0;
	
	public static void main(String[] args)
	{
		testConstructor();
		testSettersAndGetters();
		testIsValidMethod();
		testToStringMethod();
		testGetCommentsMethod();
		
		System.exit(status);
	}
	
	private static void testConstructor()
	{
		String author = "Ada Lovelace";
		String text = "I've created something special";
		
		String testName = "testConstructor";
		
		boolean testPassed = true;
		String testResults = "";
		try
		{
			String subtest = testName + " - new Post(\"" + text +",\"" + author + "\")";
			PostInterface goodPost = new Post(text,author);

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
		String author = "Ada Lovelace";
		String text = "I am much pleased to find how very well I stand work and how my powers of attention and continued effort increase.";
		long   postID = 100100100;
		String filename = "posts/Post-100100100.txt";
		String testName = "testSettersAndGetters";
		
		boolean testPassed = true;
		String testResults = "";
		try
		{
			/* Create a new Post object */
			PostInterface goodPost = new Post(text,author);
			
			/* Test setAuthor() and getAuthor() */ 
			String subtest = testName + " - author";
			String value = goodPost.getAuthor();
			if (value.equals(author)){
				String newAuthor="Aviva CSStudent";
				goodPost.setAuthor(newAuthor);
				value = goodPost.getAuthor();
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
			
			/* Test setText() and getText() */
			subtest = testName + " - text";
			value = goodPost.getText();
			if (value.equals(text)){
				String newtext="I just went to the most amazing class!";
				goodPost.setText(newtext);
				value = goodPost.getText();
				if (value.equals(newtext)) {
					testResults += subTestPass(subtest);
				} else {
					testResults += subTestFailure(subtest,"text should be " + newtext, "text returned is " + value);
					testPassed = false;
				}			
			} else {
				testResults += subTestFailure(subtest,"text should be " + text, "text returned is " + value);
				testPassed = false;
			}
			
			/* Test setPostID() and getPostFilename() */
			subtest = testName + " - setPostID / getPostFilename";
			goodPost.setPostID(postID);
			value = goodPost.getCommentsFilename();
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
		String author = "Ada Lovelace";
		String text = "I am much pleased to find how very well I stand work and how my powers of attention and continued effort increase.";
		long   postID = 100100100;
		String filename = "posts/Post-100100100.txt";
		String testName = "testIsValidMethod";
		
		boolean testPassed = true;
		String testResults = "";
		try
		{
			String subtest = testName + " - Post is valid ";
			PostInterface goodPost = new Post(text,author);
			goodPost.setPostID(postID);
			if (goodPost.isValid()) {
				testResults += subTestPass(subtest);
			} else {
				testResults += subTestFailure(subtest, "isValid() == true", "isValid() == false");
				testPassed = false;
			}
			
			subtest = testName + " - Post not valid (author = null)";
			goodPost = new Post(text,null);
			goodPost.setPostID(postID);
			
			if (goodPost.isValid()) {
				testResults += subTestFailure(subtest, "isValid() == false", "isValid() == true");
				testPassed = false;
			} else {
				testResults += subTestPass(subtest);
			}
			
			subtest = testName + " - Post not valid (text = null)";
			goodPost = new Post(null,author);
			goodPost.setPostID(postID);
			
			if (goodPost.isValid()) {
				testResults += subTestFailure(subtest, "isValid() == false", "isValid() == true");
				testPassed = false;
			} else {
				testResults += subTestPass(subtest);
			}
			
			subtest = testName + " - Post not valid (invalid Post ID)";
			goodPost = new Post(text,author);
			goodPost.setPostID(0);
			
			if (goodPost.isValid()) {
				testResults += subTestFailure(subtest, "isValid() == false", "isValid() == true");
				testPassed = false;
			} else {
				testResults += subTestPass(subtest);
			}
			
			subtest = testName + " - Post not valid (file does not exist)";
			goodPost = new Post(text,author);
			goodPost.setPostID(1);
			
			if (goodPost.isValid()) {
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
		String author = "Ada Lovelace";
		String text = "I am much pleased to find how very well I stand work and how my powers of attention and continued effort increase.";
		long   postID = 100100100;
		String filename = "posts/Post-100100100.txt";
		String testName = "testToStringMethod";
		
		boolean testPassed = true;
		String testResults = "";
		try
		{
			String subtest = testName + " - toString() includes author ";
			PostInterface goodPost = new Post(text,author);
			goodPost.setPostID(postID);
			String value = goodPost.toString();
			if (value.contains(author)) {
				testResults += subTestPass(subtest);
			} else {
				testResults += subTestFailure(subtest, author, value);
				testPassed = false;
			}
			
			subtest = testName + " - toString() includes text ";
			if (value.contains(text)) {
				testResults += subTestPass(subtest);
			} else {
				testResults += subTestFailure(subtest, text, value);
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
	
	private static void testGetCommentsMethod()
	{
		/* Define variables for the test */
		String author = "Ada Lovelace";
		String text = "I am much pleased to find how very well I stand work and how my powers of attention and continued effort increase.";
		long   postID = 100100100;
		String filename = "posts/Post-100100100.txt";
		String testName = "testGetCommentsMethod";
		
		boolean testPassed = true;
		String testResults = "";
		try
		{
			String subtest = testName + " - Check line count";
			PostInterface goodPost = new Post(text,author);
			goodPost.setPostID(postID);
			
			String comments = goodPost.getComments();
			testResults += "Trying with file: " + goodPost.getCommentsFilename();
			Scanner postScanner = new Scanner(comments);
			int numLines = 0;
			while (postScanner.hasNext()) {
				postScanner.nextLine();
				numLines++;
			}
			
			postScanner.close();
			
			if (numLines == 4) {
				testResults += subTestPass(subtest);
			} else {
				testResults += subTestFailure(subtest, "4 lines of text", numLines + " lines of text");
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

