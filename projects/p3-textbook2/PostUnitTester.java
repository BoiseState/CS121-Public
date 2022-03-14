import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * Tests Post class functionality.
 * DO NOT MODIFY THIS TESTER - It is the responsibility of your Post class to
 * pass the tests as written by functioning as defined in PostInterface.java.
 * 
 * @author mvail
 * @author marissa
 * @author lhindman
 * @author jerryfails
 */
public class PostUnitTester {
	private static int status = 0;

	public static void main(String[] args) {
		testConstructors();
		testGetFilename();
		testGetPostID();
		testGetAuthor();
		testGetText();
		testGetTimestamp();
		testIsValidMethod();
		testAddComment();
		testToStringPostOnly();
		testToString();

		System.exit(status);
	}

	/**
	 * Simple constructor tests pass as long as constructors do not throw any
	 * exceptions and expected file is created by new Post constructor.
	 */
	private static void testConstructors() {
		String author = "AdaLovelace";
		String text = "I've created something special";
		int id = 42;

		String testName = "testConstructorNewPost";

		boolean testPassed = true;
		String testResults = "";
		try {
			//Create a new Post with given id, author, and text.
			String subtest = testName + " - new Post(" + id + ",\"" + author + "\",\"" + text + "\")";
			boolean subtestPassed = true;
			String filenameStr = "Post-00042.txt";
			File file = new File(filenameStr); //delete any prior file with same ID
			if (file.exists()) {
				file.delete();
			}
			PostInterface newPost = new Post(id, author, text);
			//A well-formatted Post-00042.txt file should have been written when
			//Post's new post constructor was used.
			file = new File(filenameStr);
			if (!file.exists()) {
				testResults += subTestFailure(subtest, filenameStr + " exists after constructor", filenameStr + "does not exist");
				testPassed = false;
				subtestPassed = false;
			}
			Scanner fileScan = new Scanner(file);
			String line = fileScan.nextLine();
			String[] lineTokens = line.split("\\s+");
			try {
				Instant time = Instant.parse(lineTokens[0]);
			} catch (DateTimeParseException e) {
				testResults += subTestFailure(subtest, filenameStr + " 1st token is a valid timestamp", line);
				testPassed = false;
				subtestPassed = false;				
			}
			if (!lineTokens[1].equals(author)) {
				testResults += subTestFailure(subtest, filenameStr + " 2nd token author " + author, line);
				testPassed = false;
				subtestPassed = false;				
			}
			if (!line.contains(text)) {
				testResults += subTestFailure(subtest, filenameStr + " contains text \"" + text + "\"", line);
				testPassed = false;
				subtestPassed = false;				
			}
			if (fileScan.hasNextLine()) {
				testResults += subTestFailure(subtest, filenameStr + " contains only 1 line with Post data", filenameStr + " contains more than 1 line");
				testPassed = false;
				subtestPassed = false;								
			}
			if (subtestPassed) {
				testResults += subTestPass(subtest);
			}
			fileScan.close();
			
			//Attempt to recreate that Post from file.
			subtest = testName + " - recover valid Post(" + id + ")";
			PostInterface recoveredPost = new Post(id);
			if (newPost.getPostID() != recoveredPost.getPostID()) {
				testResults += subTestFailure(subtest, "recovered post id " + newPost.getPostID(), "recovered post id " + recoveredPost.getPostID());
				testPassed = false;
				subtestPassed = false;
			} else if (!newPost.getAuthor().equals(recoveredPost.getAuthor())) {
				testResults += subTestFailure(subtest, "recovered author " + newPost.getAuthor(), "recovered author " + recoveredPost.getAuthor());
				testPassed = false;
				subtestPassed = false;
			} else if (!newPost.getFilename().equals(recoveredPost.getFilename())) {
				testResults += subTestFailure(subtest, "recovered filename " + newPost.getFilename(), "recovered filename " + recoveredPost.getFilename());
				testPassed = false;
				subtestPassed = false;
			} else if (!newPost.getTimestamp().equals(recoveredPost.getTimestamp())) {
				testResults += subTestFailure(subtest, "recovered timestamp " + newPost.getTimestamp(), "recovered timestamp " + recoveredPost.getTimestamp());
				testPassed = false;
				subtestPassed = false;
			} else if (!newPost.getText().equals(recoveredPost.getText())) {
				testResults += subTestFailure(subtest, "recovered text " + newPost.getText(), "recovered text " + recoveredPost.getText());
				testPassed = false;
				subtestPassed = false;
			} else {
				testResults += subTestPass(subtest);
			}
			
			//Recovery constructor should not throw an exception if given ID is
			//invalid. Expectation is that isValid() will return false, tested
			//elsewhere.
			subtest = testName + " - recover invalid Post(" + Integer.MAX_VALUE + ")";
			recoveredPost = new Post(Integer.MAX_VALUE);
			testResults += subTestPass(subtest);
		} catch (Exception e) {
			testResults += subTestFailure(testName, "Test Execution", "Exception thrown.");
			testResults += e.toString();
			testPassed = false;
			e.printStackTrace();
		}

		if (testPassed) {
			pass(testName, testResults);
		} else {
			fail(testName, testResults);
		}
	}
	
	/**
	 * Confirms that a Post returns the expected associated filename.
	 */
	private static void testGetFilename() {
		/* Define variables for the test */
		String author = "AdaLovelace";
		String text = "I am much pleased to find how very well I stand work and how my powers of attention and continued effort increase.";
		int id = 42;
		String testName = "testGetFilename";

		boolean testPassed = true;
		String testResults = "";
		try {
			String subtest = testName + " - matches expected filename";
			String expectedFilename = "Post-00042.txt";
			PostInterface thePost = new Post(id, author, text);
			String filename = thePost.getFilename();
			if (filename.equals(expectedFilename)) {
				testResults += subTestPass(subtest);
			} else {
				testResults += subTestFailure(subtest, "Expected filename: " + expectedFilename,
				"Returned filename: " + filename);
				testPassed = false;				
			}
		} catch (Exception e) {
			testResults += subTestFailure(testName, "No exceptions.", "Exception thrown.");
			testResults += e.toString();
			testPassed = false;
			e.printStackTrace();
		}

		if (testPassed) {
			pass(testName, testResults);
		} else {
			fail(testName, testResults);
		}		
	}

	/**
	 * Confirms that a Post returns its expected ID.
	 */
	private static void testGetPostID() {
		/* Define variables for the test */
		String author = "AdaLovelace";
		String text = "I am much pleased to find how very well I stand work and how my powers of attention and continued effort increase.";
		int id = 42;
		String testName = "testGetPostID";

		boolean testPassed = true;
		String testResults = "";
		try {
			String subtest = testName + " - matches post ID";
			PostInterface thePost = new Post(id, author, text);
			int returnedID = thePost.getPostID();
			if (id == returnedID) {
				testResults += subTestPass(subtest);
			} else {
				testResults += subTestFailure(subtest, "Expected ID: " + id,
				"Returned ID: " + returnedID);
				testPassed = false;				
			}
		} catch (Exception e) {
			testResults += subTestFailure(testName, "No exceptions.", "Exception thrown.");
			testResults += e.toString();
			testPassed = false;
			e.printStackTrace();
		}

		if (testPassed) {
			pass(testName, testResults);
		} else {
			fail(testName, testResults);
		}		
	}

	/**
	 * Confirms that a Post returns its expected author.
	 */
	private static void testGetAuthor() {
		/* Define variables for the test */
		String author = "AdaLovelace";
		String text = "I am much pleased to find how very well I stand work and how my powers of attention and continued effort increase.";
		int id = 42;
		String testName = "testGetAuthor";

		boolean testPassed = true;
		String testResults = "";
		try {
			String subtest = testName + " - matches post author";
			PostInterface thePost = new Post(id, author, text);
			String returnedAuthor = thePost.getAuthor();
			if (author.equals(returnedAuthor)) {
				testResults += subTestPass(subtest);
			} else {
				testResults += subTestFailure(subtest, "Expected author: " + author,
				"Returned author: " + returnedAuthor);
				testPassed = false;				
			}
		} catch (Exception e) {
			testResults += subTestFailure(testName, "No exceptions.", "Exception thrown.");
			testResults += e.toString();
			testPassed = false;
			e.printStackTrace();
		}

		if (testPassed) {
			pass(testName, testResults);
		} else {
			fail(testName, testResults);
		}		
	}

	/**
	 * Confirms that a Post returns its expected text.
	 */
	private static void testGetText() {
		/* Define variables for the test */
		String author = "AdaLovelace";
		String text = "I am much pleased to find how very well I stand work and how my powers of attention and continued effort increase.";
		int id = 42;
		String testName = "testGetText";

		boolean testPassed = true;
		String testResults = "";
		try {
			String subtest = testName + " - matches post text";
			PostInterface thePost = new Post(id, author, text);
			String returnedText = thePost.getText();
			if (text.equals(returnedText)) {
				testResults += subTestPass(subtest);
			} else {
				testResults += subTestFailure(subtest, "Expected text: " + text,
				"Returned text: " + returnedText);
				testPassed = false;				
			}
		} catch (Exception e) {
			testResults += subTestFailure(testName, "No exceptions.", "Exception thrown.");
			testResults += e.toString();
			testPassed = false;
			e.printStackTrace();
		}

		if (testPassed) {
			pass(testName, testResults);
		} else {
			fail(testName, testResults);
		}		
	}

	/**
	 * Confirms that a valid Instant is returned and attempts to confirm that
	 * the returned timestamp is very close to the expected timestamp.
	 */
	private static void testGetTimestamp() {
		/* Define variables for the test */
		String author = "AdaLovelace";
		String text = "I am much pleased to find how very well I stand work and how my powers of attention and continued effort increase.";
		int id = 42;
		String testName = "testGetTimestamp";

		boolean testPassed = true;
		String testResults = "";
		try {
			String subtest = testName + " - valid ISO-8601 timestamp";
			Instant now = Instant.now();
			PostInterface thePost = new Post(id, author, text);
			Instant returnedTimestamp = thePost.getTimestamp();
			//within 2 seconds?
			if (Math.abs(returnedTimestamp.getEpochSecond() - now.getEpochSecond()) < 2) {
				testResults += subTestPass(subtest);
			} else {
				testResults += subTestFailure(subtest, "Timestamp within 2 seconds of calling constructor.",
				"Reference timestamp: " + now + ", Returned timestamp: " + returnedTimestamp);
				testPassed = false;				
			}
		} catch (Exception e) {
			testResults += subTestFailure(testName, "No exceptions.", "Exception thrown.");
			testResults += e.toString();
			testPassed = false;
			e.printStackTrace();
		}

		if (testPassed) {
			pass(testName, testResults);
		} else {
			fail(testName, testResults);
		}		
	}

	/**
	 * Confirms that isValid() returns true when a Post has been initialized with
	 * author, text, and ID. Confirms that isValid() returns false when Post was
	 * missing values during instantiation.
	 */
	private static void testIsValidMethod() {
		/* Define variables for the test */
		String author = "AdaLovelace";
		String text = "I am much pleased to find how very well I stand work and how my powers of attention and continued effort increase.";
		int id = 42;
		String filename = "Post-00042.txt";
		String testName = "testIsValid";

		boolean testPassed = true;
		String testResults = "";
		try {
			//testing where isValid() is expected to be true
			String subtest = testName + " - Post is valid";
			File file = new File(filename); //delete any prior file with same ID
			if (file.exists()) {
				file.delete();
			}
			PostInterface thePost = new Post(id, author, text);
			if (thePost.isValid()) {
				testResults += subTestPass(subtest);
			} else {
				testResults += subTestFailure(subtest, "isValid() == true", "isValid() == false");
				testPassed = false;
			}			
			//testing where isValid() is expected to be false, author == null
			subtest = testName + " - Post not valid when author = null";
			thePost = new Post(id, null, text);
			if (thePost.isValid()) {
				testResults += subTestFailure(subtest, "isValid() == false", "isValid() == true");
				testPassed = false;
			} else {
				testResults += subTestPass(subtest);
			}
			//testing where isValid() is expected to be false, text == null
			subtest = testName + " - Post not valid when text = null";
			file = new File(filename); //delete any prior file with same ID
			if (file.exists()) {
				file.delete();
			}
			thePost = new Post(id, author, null);
			if (thePost.isValid()) {
				testResults += subTestFailure(subtest, "isValid() == false", "isValid() == true");
				testPassed = false;
			} else {
				testResults += subTestPass(subtest);
			}
			//testing where isValid() is expected to be false after failure to
			//recover a Post from an invalid ID.
			subtest = testName + " - Post not valid when recovered from invalid ID";
			file = new File(filename); //delete any prior file with same ID
			if (file.exists()) {
				file.delete();
			}
			thePost = new Post(Integer.MAX_VALUE);
			if (thePost.isValid()) {
				testResults += subTestFailure(subtest, "isValid() == false", "isValid() == true");
				testPassed = false;
			} else {
				testResults += subTestPass(subtest);
			}
		} catch (Exception e) {
			testResults += subTestFailure(testName, "No exceptions.", "Exception thrown.");
			testResults += e.toString();
			testPassed = false;
			e.printStackTrace();
		}

		if (testPassed) {
			pass(testName, testResults);
		} else {
			fail(testName, testResults);
		}
	}

	/**
	 * Confirms that no exceptions are thrown when addComment() is called and
	 * all comments appear in Post file.
	 * Evidence of successfully-added comments is also tested with toString().
	 */
	private static void testAddComment() {
		String author = "AdaLovelace";
		String text = "I am much pleased to find how very well I stand work and how my powers of attention and continued effort increase.";
		int id = 42;
		String filename = "Post-00042.txt";
		String author2 = "KatherineJohnson";
		String comment1 = "Like what you do, and then you will do your best.";
		String comment2 = "I don't have a feeling of inferiority. Never had. I'm as good as anybody, but no better.";
		String comment3 = "You are no better than anyone else, and no one is better than you.";
		String comment4 = "I like to learn. That's an art and a science.";

		String testName = "testAddComment";

		boolean testPassed = true;
		String testResults = "";
		try {
			String subtest = testName + " - no exceptions when adding comments";
			File file = new File(filename); //delete any prior file with same ID
			if (file.exists()) {
				file.delete();
			}
			PostInterface thePost = new Post(id, author, text);
			thePost.addComment(author2, comment1);
			thePost.addComment(author2, comment2);
			thePost.addComment(author2, comment3);
			thePost.addComment(author2, comment4);
			testResults += subTestPass(subtest);

			subtest = testName + " - comments appear in Post file";
			boolean subtestPassed = true;
			Scanner fileScan = new Scanner(new File(filename));
			String line = fileScan.nextLine(); //post line
			line = fileScan.nextLine(); //should be first comment line
			String[] lineTokens = line.split("\\s+");
			try {
				Instant time = Instant.parse(lineTokens[0]);
			} catch (DateTimeParseException e) {
				testResults += subTestFailure(subtest, "First comment line in " + filename + " begins with valid timestamp", line);
				testPassed = false;
				subtestPassed = false;
			}
			if (!lineTokens[1].equals(author2)) {
				testResults += subTestFailure(subtest, "First comment line in " + filename + " has second value " + author2, line);
				testPassed = false;
				subtestPassed = false;
			}
			if (!line.contains(comment1)) {
				testResults += subTestFailure(subtest, "First comment line in " + filename + " contains \"" + comment1 + "\"", line);
				testPassed = false;
				subtestPassed = false;
			}
			line = fileScan.nextLine(); //should be second comment line
			lineTokens = line.split("\\s+");
			try {
				Instant time = Instant.parse(lineTokens[0]);
			} catch (DateTimeParseException e) {
				testResults += subTestFailure(subtest, "Second comment line in " + filename + " begins with valid timestamp", line);
				testPassed = false;
				subtestPassed = false;
			}			
			if (!lineTokens[1].equals(author2)) {
				testResults += subTestFailure(subtest, "Second comment line in " + filename + " has second value " + author2, line);
				testPassed = false;
				subtestPassed = false;
			}
			if (!line.contains(comment2)) {
				testResults += subTestFailure(subtest, "Second comment line in " + filename + " contains \"" + comment2 + "\"", line);
				testPassed = false;
				subtestPassed = false;
			}
			line = fileScan.nextLine(); //should be third comment line
			lineTokens = line.split("\\s+");
			try {
				Instant time = Instant.parse(lineTokens[0]);
			} catch (DateTimeParseException e) {
				testResults += subTestFailure(subtest, "Third comment line in " + filename + " begins with valid timestamp", line);
				testPassed = false;
				subtestPassed = false;
			}			
			if (!lineTokens[1].equals(author2)) {
				testResults += subTestFailure(subtest, "Third comment line in " + filename + " has second value " + author2, line);
				testPassed = false;
				subtestPassed = false;
			}
			if (!line.contains(comment3)) {
				testResults += subTestFailure(subtest, "Third comment line in " + filename + " contains \"" + comment3 + "\"", line);
				testPassed = false;
				subtestPassed = false;
			}
			line = fileScan.nextLine(); //should be fourth comment line
			lineTokens = line.split("\\s+");
			try {
				Instant time = Instant.parse(lineTokens[0]);
			} catch (DateTimeParseException e) {
				testResults += subTestFailure(subtest, "Fourth comment line in " + filename + " begins with valid timestamp", line);
				testPassed = false;
				subtestPassed = false;
			}			
			if (!lineTokens[1].equals(author2)) {
				testResults += subTestFailure(subtest, "Fourth comment line in " + filename + " has second value " + author2, line);
				testPassed = false;
				subtestPassed = false;
			}
			if (!line.contains(comment4)) {
				testResults += subTestFailure(subtest, "Fourth comment line in " + filename + " contains \"" + comment4 + "\"", line);
				testPassed = false;
				subtestPassed = false;
			}
			fileScan.close();
			if (subtestPassed) {
				testResults += subTestPass(subtest);
			}
		} catch (Exception e) {
			testResults += subTestFailure(testName, "No exceptions.", "Exception thrown.");
			testResults += e.toString();
			testPassed = false;
			e.printStackTrace();
		}

		if (testPassed) {
			pass(testName, testResults);
		} else {
			fail(testName, testResults);
		}
	}

	/**
	 * Confirms expected post format and content from toStringPostOnly().
	 */
	private static void testToStringPostOnly() {
		String author = "AdaLovelace";
		String text = "I am much pleased to find how very well I stand work and how my powers of attention and continued effort increase.";
		int id = 42;
		String testName = "testToStringPostOnly";

		boolean testPassed = true;
		String testResults = "";
		try {
			PostInterface thePost = new Post(id, author, text);
			String returnedString = thePost.toStringPostOnly();
			String[] lines = returnedString.split("\n");
			String[] tokens = returnedString.split("\\s+");

			String subtest = testName + " - returns a single line";
			if (lines.length != 1) {
				testResults += subTestFailure(subtest, "Lines returned: 1", "Lines returned: " + lines.length);
				testPassed = false;
			} else {
				testResults += subTestPass(subtest);
			}
			
			subtest = testName + " - includes postID as first value";
			try {
				if (tokens[0].length() != 5) {
					testResults += subTestFailure(subtest, "post ID formatted to 5 digits", tokens[0]);
					testPassed = false;					
				} else if (Integer.parseInt(tokens[0]) != id) {
					testResults += subTestFailure(subtest, Integer.toString(id), Integer.toString(Integer.parseInt(tokens[0])));
					testPassed = false;
				} else {
					testResults += subTestPass(subtest);
				}
			} catch (NumberFormatException e) {
				testResults += subTestFailure(subtest, "First value can be read as an integer matching " + id, tokens[0]);
				testPassed = false;				
			}

			subtest = testName + " - includes ISO-8601 timestamp as second value";
			try {
				Instant timestamp = Instant.parse(tokens[1]);
				testResults += subTestPass(subtest);
			} catch (DateTimeParseException e) {
				testResults += subTestFailure(subtest, "ISO-8601 formatted timestamp", tokens[1]);
				testPassed = false;
			}
			
			subtest = testName + " - includes author as third value";
			if (tokens[2].equals(author)) {
				testResults += subTestPass(subtest);
			} else {
				testResults += subTestFailure(subtest, author, tokens[2]);
				testPassed = false;
			}

			subtest = testName + " - includes post text";
			if (returnedString.contains(text)) { //can't use tokens because words are separated
				testResults += subTestPass(subtest);
			} else {
				testResults += subTestFailure(subtest, "Includes \"" + text + "\"", returnedString);
				testPassed = false;
			}			
		} catch (Exception e) {
			testResults += subTestFailure(testName, "No exceptions.", "Exception thrown.");
			testResults += e.toString();
			testPassed = false;
			e.printStackTrace();
		}

		if (testPassed) {
			pass(testName, testResults);
		} else {
			fail(testName, testResults);
		}
	}

	/**
	 * Confirms expected post and comment formatting and content from toString().
	 */
	private static void testToString() {
		String author = "AdaLovelace";
		String text = "I am much pleased to find how very well I stand work and how my powers of attention and continued effort increase.";
		int id = 42;
		String author2 = "KatherineJohnson";
		String comment1 = "Like what you do, and then you will do your best.";
		String comment2 = "I don't have a feeling of inferiority. Never had. I'm as good as anybody, but no better.";
		String comment3 = "You are no better than anyone else, and no one is better than you.";
		String comment4 = "I like to learn. That's an art and a science.";

		String testName = "testToString";

		boolean testPassed = true;
		String testResults = "";
		try {
			PostInterface thePost = new Post(id, author, text);
			thePost.addComment(author2, comment1);
			thePost.addComment(author2, comment2);
			thePost.addComment(author2, comment3);
			thePost.addComment(author2, comment4);

			String retString = thePost.toString();
			String[] lines = retString.split("\n");

			String subtest = testName + " - expected line count";
			if (lines.length != 5) {
				testResults += subTestFailure(subtest, "Lines returned: 5", "Lines returned: " + lines.length);
				testPassed = false;
			} else {
				testResults += subTestPass(subtest);
			}
			
			subtest = testName + " - first line contains well-formmated whitespace-separated post values";
			String[] tokens = lines[0].split("\\s+"); 
			boolean subtestResult = true;
			if (tokens[0].length() != 5) {
				testResults += subTestFailure(subtest, "First post value formatted to 5 digits", tokens[0]);
				testPassed = false;
				subtestResult = false;
			}
			try {
				if (Integer.parseInt(tokens[0]) != id) {
					testResults += subTestFailure(subtest, "First post value matches postID " + id, tokens[0]);
					testPassed = false;
					subtestResult = false;
				}
			} catch (NumberFormatException e) {
				testResults += subTestFailure(subtest, "First post value matches integer " + id, tokens[0]);
				testPassed = false;
				subtestResult = false;
			}
			try {
				Instant timestamp = Instant.parse(tokens[1]);
			} catch (DateTimeParseException e) {
				testResults += subTestFailure(subtest, "Second post value ISO-8601 timestamp", tokens[1]);
				testPassed = false;
				subtestResult = false;				
			}
			if (!tokens[2].equals(author)) {
				testResults += subTestFailure(subtest, "Third post value matches " + author, tokens[2]);
				testPassed = false;
				subtestResult = false;				
			}
			if (!lines[0].contains(text)) {
				testResults += subTestFailure(subtest, "Post line contains \"" + text + "\"", lines[0]);
				testPassed = false;
				subtestResult = false;				
			}
			if (subtestResult) {
				testResults += subTestPass(subtest);
			}
			
			// first comment
			subtest = testName + " - second line matches first comment";
			tokens = lines[1].trim().split("\\s+");
			subtestResult = true;
			if (lines[1].charAt(0) != '\t') {
				testResults += subTestFailure(subtest, "Comment line starts with tab", "No leading tab");
				testPassed = false;
				subtestResult = false;
			}
			try {
				Instant timestamp = Instant.parse(tokens[0]);
			} catch (DateTimeParseException e) {
				testResults += subTestFailure(subtest, "First comment ISO-8601 timestamp", tokens[0]);
				testPassed = false;
				subtestResult = false;
			}
			if (!tokens[1].equals(author2)) {
				testResults += subTestFailure(subtest, "First comment author " + author2, tokens[1]);
				testPassed = false;
				subtestResult = false;
			}
			if (!lines[1].contains(comment1)) {
				testResults += subTestFailure(subtest, "First comment contains \"" + comment1 + "\"", lines[1].trim());
				testPassed = false;
				subtestResult = false;
			}
			if (subtestResult) {
				testResults += subTestPass(subtest);
			}
			
			// second comment
			subtest = testName + " - third line matches second comment";
			tokens = lines[2].trim().split("\\s+");
			subtestResult = true;
			if (lines[2].charAt(0) != '\t') {
				testResults += subTestFailure(subtest, "Comment line starts with tab", "No leading tab");
				testPassed = false;
				subtestResult = false;
			}
			try {
				Instant timestamp = Instant.parse(tokens[0]);
			} catch (DateTimeParseException e) {
				testResults += subTestFailure(subtest, "Second comment ISO-8601 timestamp", tokens[0]);
				testPassed = false;
				subtestResult = false;
			}
			if (!tokens[1].equals(author2)) {
				testResults += subTestFailure(subtest, "Second comment author " + author2, tokens[1]);
				testPassed = false;
				subtestResult = false;
			}
			if (!lines[2].contains(comment2)) {
				testResults += subTestFailure(subtest, "Second comment contains \"" + comment2 + "\"", lines[2].trim());
				testPassed = false;
				subtestResult = false;
			}
			if (subtestResult) {
				testResults += subTestPass(subtest);
			}
			
			// third comment
			subtest = testName + " - fourth line matches third comment";
			tokens = lines[3].trim().split("\\s+");
			subtestResult = true;
			if (lines[3].charAt(0) != '\t') {
				testResults += subTestFailure(subtest, "Comment line starts with tab", "No leading tab");
				testPassed = false;
				subtestResult = false;
			}
			try {
				Instant timestamp = Instant.parse(tokens[0]);
			} catch (DateTimeParseException e) {
				testResults += subTestFailure(subtest, "Third comment ISO-8601 timestamp", tokens[0]);
				testPassed = false;
				subtestResult = false;
			}
			if (!tokens[1].equals(author2)) {
				testResults += subTestFailure(subtest, "Third comment author " + author2, tokens[1]);
				testPassed = false;
				subtestResult = false;
			}
			if (!lines[3].contains(comment3)) {
				testResults += subTestFailure(subtest, "Third comment contains \"" + comment3 + "\"", lines[3].trim());
				testPassed = false;
				subtestResult = false;
			}
			if (subtestResult) {
				testResults += subTestPass(subtest);
			}

			// fourth comment
			subtest = testName + " - fifth line matches fourth comment";
			tokens = lines[4].trim().split("\\s+");
			subtestResult = true;
			if (lines[4].charAt(0) != '\t') {
				testResults += subTestFailure(subtest, "Comment line starts with tab", "No leading tab");
				testPassed = false;
				subtestResult = false;
			}
			try {
				Instant timestamp = Instant.parse(tokens[0]);
			} catch (DateTimeParseException e) {
				testResults += subTestFailure(subtest, "Fourth comment ISO-8601 timestamp", tokens[0]);
				testPassed = false;
				subtestResult = false;
			}
			if (!tokens[1].equals(author2)) {
				testResults += subTestFailure(subtest, "Fourth comment value author " + author2, tokens[1]);
				testPassed = false;
				subtestResult = false;
			}
			if (!lines[4].contains(comment4)) {
				testResults += subTestFailure(subtest, "Fourth comment contains \"" + comment4 + "\"", lines[4].trim());
				testPassed = false;
				subtestResult = false;
			}
			if (subtestResult) {
				testResults += subTestPass(subtest);
			}
		} catch (Exception e) {
			testResults += subTestFailure(testName, "No exceptions.", "Exception thrown.");
			testResults += e.toString();
			testPassed = false;
			e.printStackTrace();
		}

		if (testPassed) {
			pass(testName, testResults);
		} else {
			fail(testName, testResults);
		}
	}

	/**
	 * Format test output for a failed subtest.
	 * @param testName name of failed subtest
	 * @param expected description of expected result
	 * @param actual description of actual result
	 * @return formatted String with test output
	 */
	private static String subTestFailure(String testName, String expected, String actual) {
		String output = "    (error): " + testName + "\n";
		output += "        --> expected: " + expected + "\n";
		output += "        -->   actual: " + actual + "\n";

		return output;
	}

	/**
	 * Format test output for a passed subtest.
	 * @param testName name of passed subtest
	 * @return formatted String with test output
	 */
	private static String subTestPass(String testName) {
		return "    " + testName + "\n";
	}

	/**
	 * Format test output for a failed test.
	 * @param testName name of failed test
	 * @param message description of the cause of test failure
	 */
	private static void fail(String testName, String message) {
		System.err.println("FAILED: " + testName);
		System.err.println("    " + message.trim());
		status = 1;
	}

	/**
	 * Format test output for a passed test.
	 * @param testName name of passed test
	 * @param message description to elaborate on test result
	 */
	private static void pass(String testName, String message) {
		System.out.println("PASSED: " + testName);
		System.out.println("    " + message.trim());
	}

}
