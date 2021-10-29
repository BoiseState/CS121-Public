import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Tests Posts general functionality.
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
		checkPostFolder();
		
		testConstructor();
		testSettersAndGetters();
		testIsValidMethod();
		testToStringMethod();
		testAddAndGetCommentsMethods();
		
		System.exit(status);
	}
	
	private static void checkPostFolder()
	{
		File f = new File("./posts/");
		if (!f.exists())
			f.mkdirs();
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
		String testName = "testSettersAndGetters";
		
		boolean testPassed = true;
		String testResults = "";
		try
		{
			/* Create a new Post object */
			PostInterface goodPost = new Post(text,author);
			
			/* Test getAuthor() */ 
			String subtest = testName + " - getAuthor";
			String value = goodPost.getAuthor();
			if (value.equals(author)){
				testResults += subTestPass(subtest);
			} else {
				testResults += subTestFailure(subtest,"Author should be " + author, "Author returned is " + value);
				testPassed = false;
			}
			
			/* Test getText() */
			subtest = testName + " - getText";
			value = goodPost.getText();
			if (value.equals(text)){
				value = goodPost.getText();
			} else {
				testResults += subTestFailure(subtest,"text should be " + text, "text returned is " + value);
				testPassed = false;
			}
			
			/* Test getPostID() and getPostFilename() */
			subtest = testName + " - getPostID / getPostFilename";
			value = goodPost.getPostFilename();
			String postIDStr = Long.toString(goodPost.getPostID());
			if (value.contains(postIDStr)){
				testResults += subTestPass(subtest);		
			} else {
				testResults += subTestFailure(subtest, "Filename should have " + postIDStr, "Filename returned is " + value);
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
		String testName = "testIsValidMethod";
		
		boolean testPassed = true;
		String testResults = "";
		try
		{
			String subtest = testName + " - Post is valid ";
			PostInterface goodPost = new Post(text,author);
			String filenameStr = goodPost.getPostFilename();
			// creating directory and file to test isValid is true
			File f = new File(filenameStr);
			f.mkdirs();
			try {
				PrintWriter pw = new PrintWriter(f);
				pw.close();
			} catch (FileNotFoundException fnfe) { }
			if (goodPost.isValid()) {
				testResults += subTestPass(subtest);
			} else {
				testResults += subTestFailure(subtest, "isValid() == true", "isValid() == false");
				testPassed = false;
			}
			
			subtest = testName + " - Post not valid (author = null)";
			goodPost = new Post(text,null);
			
			if (goodPost.isValid()) {
				testResults += subTestFailure(subtest, "isValid() == false", "isValid() == true");
				testPassed = false;
			} else {
				testResults += subTestPass(subtest);
			}
			
			subtest = testName + " - Post not valid (text = null)";
			goodPost = new Post(null,author);
			
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
		String testName = "testToStringMethod";
		
		boolean testPassed = true;
		String testResults = "";
		try
		{
			String subtest = testName + " - toString() includes author ";
			PostInterface goodPost = new Post(text,author);
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

			subtest = testName + " - toString() includes postID ";
			if (value.contains(Long.toString(goodPost.getPostID()))) {
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
	
	private static void testAddAndGetCommentsMethods()
	{
		/* Define variables for the test */
		String author = "Ada Lovelace";
		String text = "I am much pleased to find how very well I stand work and how my powers of attention and continued effort increase.";
		String testName = "testGetCommentsMethod";

		String comment1 = "Like what you do, and then you will do your best.";
		String comment2 = "I don't have a feeling of inferiority. Never had. I'm as good as anybody, but no better.";
		String comment3 = "You are no better than anyone else, and no one is better than you.";
		String comment4 = "I like to learn. That�s an art and a science.";
		
		boolean testPassed = true;
		String testResults = "";
		try
		{
			// add comments
			String subtest = testName + " - addComment & Check line count";
			PostInterface goodPost = new Post(text,author);

			testResults += "FILE="+goodPost.getPostFilename();
			goodPost.addComment("Katherine Johnson", comment1);
			goodPost.addComment("Katherine Johnson", comment2);
			goodPost.addComment("Katherine Johnson", comment3);
			goodPost.addComment("Katherine Johnson", comment4);
			
			String comments = goodPost.getComments();
			testResults += "Trying with file: " + goodPost.getPostFilename();
			Scanner postScanner = new Scanner(comments);
			int numLinesComments = 0;
			while (postScanner.hasNextLine()) {
				postScanner.nextLine();
				numLinesComments++;
			}
			postScanner.close();
			
			postScanner = new Scanner(new File(goodPost.getPostFilename()));
			int numLinesFile = 0;
			while (postScanner.hasNextLine()) {
				postScanner.nextLine();
				numLinesFile++;
			}

			if (numLinesComments == numLinesFile) {
				testResults += subTestPass(subtest);
			} else {
				testResults += subTestFailure(subtest, "Comment lines ("+numLinesComments+") == File line (" + numLinesFile + ")", "Comment lines ("+numLinesComments+") == File line (" + numLinesFile + ")");
				testPassed = false;
			}
			
			subtest = testName + " - original comments included in what was read from file";
			if (comments.contains(comment1) && comments.contains(comment2) && comments.contains(comment3) && comments.contains(comment4)) {
				testResults += subTestPass(subtest);
			} else {
				testResults += subTestFailure(subtest, "All comments to be in the comments", "Not all comments were in the retrieved info from the file");
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

