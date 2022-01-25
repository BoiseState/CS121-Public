import java.util.ArrayList;

/**
 * Test TextBook functionality.
 * 
 * @author mvail
 * @author marissa
 * @author lhindman
 * @author jerryfails
 */
public class TextBookUnitTester {
	
	private static int status = 0;
	
	public static void main(String[] args) {
		testConstructor();
		testAddGetPostMethods();
		testGetPostsMethod();
		testAddRemovePostMethods();
		testToStringMethod();
		
		System.exit(status);
	}
	
	
	private static void testConstructor()
	{
		String testName = "testConstructor";
		boolean testPassed = true;
		String testResults = "";
		try
		{
			String subtest = testName + " - new TextBook()";
			TextBookInterface littleTextBook = new TextBook();
			
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
	
	private static void testAddGetPostMethods()
	{
		/* Define variables for the test */
		Post adaPost = getAdaPost();
		Post gracePost = getGracePost();
		Post katherinePost = getKatherinePost();		

		String testName = "testAddGetPostMethods";		
		boolean testPassed = true;
		String testResults = "";
		try
		{
			/* Create a new Post object */
			TextBookInterface littleTextBook = new TextBook();
			
			/* Test add/get single Post */ 
			String subtest = testName + " - add/get single Post";
			littleTextBook.addPost(adaPost);
			Post value = littleTextBook.getPost(0);
			if (value.equals(adaPost)){
					testResults += subTestPass(subtest);		
			} else {
				testResults += subTestFailure(subtest, adaPost.toString(), value.toString());
				testPassed = false;
			}
			
			/* Test add/get second Post */
			subtest = testName + " - add/get second Post";
			littleTextBook.addPost(katherinePost);
			value = littleTextBook.getPost(1);
			if (value.equals(katherinePost)){
				value = littleTextBook.getPost(0);
				if(value.equals(adaPost)) {
					testResults += subTestPass(subtest);
				} else {
					testResults += subTestFailure(subtest, adaPost.toString(), value.toString());
					testPassed = false;
				}
			} else {
				testResults += subTestFailure(subtest, katherinePost.toString(), value.toString());
				testPassed = false;
			}
			
			/* Test get invalid index */ 
			subtest = testName + " - Get invalid index";
			littleTextBook = new TextBook();
			littleTextBook.addPost(adaPost);
			
			value = littleTextBook.getPost(1);
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
	
	private static void testAddRemovePostMethods()
	{
		/* Define variables for the test */
		Post alice = getAdaPost();
		Post gettysburg = getGracePost();
		Post leaves = getKatherinePost();		

		String testName = "testAddRemovePostMethods";		
		boolean testPassed = true;
		String testResults = "";
		try
		{
			/* Create a new Post object */
			TextBookInterface littleTextBook = new TextBook();
			
			/* Test add/get single Post */ 
			String subtest = testName + " - Remove multiple Posts";
			littleTextBook.addPost(alice);
			littleTextBook.addPost(gettysburg);
			littleTextBook.addPost(leaves);
			
			Post value = littleTextBook.getPost(0);
			if (value.equals(alice)){
				/* Remove first Post - alice */
				littleTextBook.removePost(0);
				value = littleTextBook.getPost(0);
				if (value.equals(gettysburg)) {
					/* Remove end Post - leaves */
					littleTextBook.removePost(1);
					value = littleTextBook.getPost(0);
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
			
			littleTextBook = new TextBook();
			
			/* Test remove invalid index */ 
			subtest = testName + " - Remove invalid index";
			littleTextBook.addPost(alice);
			
			littleTextBook.removePost(1);
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
	
	private static void testGetPostsMethod()
	{
		/* Define variables for the test */
		Post alice = getAdaPost();
		Post gettysburg = getGracePost();
		Post leaves = getKatherinePost();		

		String testName = "testGetPostsMethod";		
		boolean testPassed = true;
		String testResults = "";
		try
		{
			/* Create a new Post object */
			TextBookInterface littleTextBook = new TextBook();
			
			/* Test adding 3 Posts and check number of Posts is 3 */ 
			String subtest = testName + " - Number of Posts";
			littleTextBook.addPost(alice);
			littleTextBook.addPost(gettysburg);
			littleTextBook.addPost(leaves);
			
			ArrayList<Post> value = littleTextBook.getPosts();
			
			if (value.size() == 3){
					testResults += subTestPass(subtest);		
			} else {
				testResults += subTestFailure(subtest, "3", Integer.toString(value.size()));
				testPassed = false;
			}
			
			/* Test that modifications to returned Posts ArrayList do not affect TextBook */
			subtest = testName + " - Copy of Posts array (Encapsulation)";
			value.remove(0);
			value = littleTextBook.getPosts();
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
		Post adaPost = getAdaPost();
		Post gracePost = getGracePost();
		Post katherinePost = getKatherinePost();		

		String testName = "testToStringMethod";		
		boolean testPassed = true;
		String testResults = "";
		try
		{
			/* Create a new Post object */
			TextBookInterface littleTextBook = new TextBook();
			
			/* Test adding 3 Posts and check number of Posts is 3 */ 
			
			littleTextBook.addPost(adaPost);
			littleTextBook.addPost(gracePost);
			littleTextBook.addPost(katherinePost);
			
			String value = littleTextBook.toString();
			String subtest = testName + " - toString() includes first Post";
			if (value.contains(adaPost.toString())){
					testResults += subTestPass(subtest);		
			} else {
				testResults += subTestFailure(subtest, adaPost.toString(), value);
				testPassed = false;
			}
			
			subtest = testName + " - toString() includes second Post";
			if (value.contains(gracePost.toString())){
					testResults += subTestPass(subtest);		
			} else {
				testResults += subTestFailure(subtest, gracePost.toString(), value);
				testPassed = false;
			}
			
			subtest = testName + " - toString() includes third Post";
			if (value.contains(katherinePost.toString())){
					testResults += subTestPass(subtest);		
			} else {
				testResults += subTestFailure(subtest, katherinePost.toString(), value);
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
	
	
	
	private static Post getAdaPost() {
		String author = "Ada Lovelace";
		String text = "I am much pleased to find how very well I stand work and how my powers of attention and continued effort increase.";
		Post goodPost = new Post(text,author);
		goodPost.addComment("Grace Hopper", "The only phrase I've ever disliked is, 'Why, we've always done it that way.' I always tell young people, 'Go ahead and do it. You can always apologize later.'");
		goodPost.addComment("Katherine Jones", "I like to learn. That's an art and a science.");

		return goodPost;
	}
	
	private static Post getGracePost() {
		String author = "Grace Hopper";
		String text = "One accurate measurement is worth a thousand expert opinions.";
		Post goodPost = new Post(text,author);
		goodPost.addComment("Ada Lovelace", "Thus not only the mental and the material but the theoretical and the practical in the mathematical world, are brought into more intimate and effective connection with each other.");
		
		return goodPost;
	}
	
	private static Post getKatherinePost() {
		String author = "Katherine Johnson";
		String text = "Girls are capable of doing everything men are capable of doing. Sometimes they have more imagination than men.";
		Post goodPost = new Post(text,author);
		
		return goodPost;
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
