import java.io.File;
import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

/**
 * Tests TextBook functionality. DO NOT MODIFY THIS TESTER - It is the
 * responsibility of your TextBook class to pass the tests as written by
 * functioning as defined in TextBookInterface.java.
 * 
 * @author mvail
 * @author marissa
 * @author lhindman
 * @author jerryfails
 */
public class TextBookUnitTester {
	private static final String ADA_POST_AUTHOR = "AdaLovelace";
	private static final String ADA_POST_TEXT = "I am much pleased to find how very well I stand work and how my powers of attention and continued effort increase.";
	private static final String ADA_POST_COMMENT1_AUTHOR = "GraceHopper";
	private static final String ADA_POST_COMMENT1_TEXT = "The only phrase I've ever disliked is, 'Why, we've always done it that way.' I always tell young people, 'Go ahead and do it. You can always apologize later.'";
	private static final String ADA_POST_COMMENT2_AUTHOR = "KatherineJones";
	private static final String ADA_POST_COMMENT2_TEXT = "I like to learn. That's an art and a science.";
	private static final String GRACE_POST_AUTHOR = "GraceHopper";
	private static final String GRACE_POST_TEXT = "One accurate measurement is worth a thousand expert opinions.";
	private static final String GRACE_POST_COMMENT1_AUTHOR = "AdaLovelace";
	private static final String GRACE_POST_COMMENT1_TEXT = "Thus not only the mental and the material but the theoretical and the practical in the mathematical world, are brought into more intimate and effective connection with each other.";
	private static final String KATHERINE_POST_AUTHOR = "KatherineJohnson";
	private static final String KATHERINE_POST_TEXT = "Girls are capable of doing everything men are capable of doing. Sometimes they have more imagination than men.";
	
	private static final int TOTAL_TESTS = 9;
	private static int testsPassed = 0;

	private static int status = 0;

	public static void main(String[] args) {
		testConstructor();
		testAddPost();
		testRemovePost();
		testAddComment();
		testLastID();
		testGetPostCount();
		testGetPostString();
		testToString();
		testGetPosts();

		System.out.println("\nPassed " + testsPassed + " of " + TOTAL_TESTS + " tests (" + (double)testsPassed*100/TOTAL_TESTS + "%)\n");

		System.exit(status);
	}

	/**
	 * Confirm that calling the TextBook constructor for a new empty TextBook does
	 * not result in a thrown Exception (and TextBook implements TextBookInterface
	 * as required). Also attempts to recover a TextBook from file and superficially
	 * checks that all Posts were recovered.
	 */
	private static void testConstructor() {
		String testName = "testConstructor";
		boolean testPassed = true;
		String testResults = "";
		String subtest = testName;
		try {
			subtest = testName + " - new TextBook(), no prior " + TextBookInterface.POST_LIST_FILENAME;
			File postFile = new File(TextBookInterface.POST_LIST_FILENAME);
			if (postFile.exists()) {
				postFile.delete();
			}
			TextBookInterface theTextBook = new TextBook(); //expecting no exceptions
			testResults += subTestPass(subtest);

			subtest = testName + " - recovering TextBook from file";
			theTextBook.addPost(ADA_POST_AUTHOR, ADA_POST_TEXT);
			theTextBook.addPost(KATHERINE_POST_AUTHOR, KATHERINE_POST_TEXT);
			theTextBook.addPost(GRACE_POST_AUTHOR, GRACE_POST_TEXT);
			theTextBook.addComment(0, ADA_POST_COMMENT1_AUTHOR, ADA_POST_COMMENT1_TEXT);
			theTextBook.addComment(0, ADA_POST_COMMENT2_AUTHOR, ADA_POST_COMMENT2_TEXT);
			theTextBook.addComment(2, GRACE_POST_COMMENT1_AUTHOR, GRACE_POST_COMMENT1_TEXT);		
			TextBookInterface recoveredTextBook = new TextBook();
			boolean subtestPassed = true;
			if (recoveredTextBook.getPostCount() != 3) {
				testResults += subTestFailure(subtest, "Post count == 3", Integer.toString(recoveredTextBook.getPostCount()));
				testPassed = false;
				subtestPassed = false;
			}
			if (recoveredTextBook.getLastID() != 3) {
				testResults += subTestFailure(subtest, "Last ID == 3", Integer.toString(recoveredTextBook.getLastID()));
				testPassed = false;
				subtestPassed = false;
			} 
			if (!recoveredTextBook.getPosts().get(0).getAuthor().equals(ADA_POST_AUTHOR)) { //incomplete confirmation, but at least author is there
				testResults += subTestFailure(subtest, "First Post recovered with author " + ADA_POST_AUTHOR, recoveredTextBook.getPosts().get(0).getAuthor());
				testPassed = false;
				subtestPassed = false;
			}
			if (!recoveredTextBook.getPosts().get(1).getAuthor().equals(KATHERINE_POST_AUTHOR)) { //incomplete confirmation, but at least author is there
				testResults += subTestFailure(subtest, "Second Post recovered with author " + KATHERINE_POST_AUTHOR, recoveredTextBook.getPosts().get(1).getAuthor());
				testPassed = false;
				subtestPassed = false;
			}
			if (!recoveredTextBook.getPosts().get(2).getAuthor().equals(GRACE_POST_AUTHOR)) { //incomplete confirmation, but at least author is there
				testResults += subTestFailure(subtest, "Third Post recovered with author " + GRACE_POST_AUTHOR, recoveredTextBook.getPosts().get(2).getAuthor());
				testPassed = false;
				subtestPassed = false;
			} 
			if (!recoveredTextBook.getPosts().get(0).toString().contains(ADA_POST_COMMENT1_AUTHOR)
					|| !recoveredTextBook.getPosts().get(0).toString().contains(ADA_POST_COMMENT1_TEXT)) { //incomplete confirmation, but at least author and text are there
				testResults += subTestFailure(subtest, "Missing first comment for first post", recoveredTextBook.getPosts().get(0).toString());
				testPassed = false;					
				subtestPassed = false;
			} 
			if (!recoveredTextBook.getPosts().get(0).toString().contains(ADA_POST_COMMENT2_AUTHOR)
					|| !recoveredTextBook.getPosts().get(0).toString().contains(ADA_POST_COMMENT2_TEXT)) { //incomplete confirmation, but at least author and text are there
				testResults += subTestFailure(subtest, "Missing second comment for first post", recoveredTextBook.getPosts().get(0).toString());
				testPassed = false;					
				subtestPassed = false;
			}
			if (!recoveredTextBook.getPosts().get(2).toString().contains(GRACE_POST_COMMENT1_AUTHOR)
					|| !recoveredTextBook.getPosts().get(2).toString().contains(GRACE_POST_COMMENT1_TEXT)) { //incomplete confirmation, but at least author and text are there
				testResults += subTestFailure(subtest, "Missing first comment for third post", recoveredTextBook.getPosts().get(2).toString());
				testPassed = false;					
			}
			if (subtestPassed) {
				testResults += subTestPass(subtest);
			}
		} catch (Exception e) {
			testResults += subTestFailure(subtest, "No exceptions.", "Exception thrown.");
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
	 * Confirms no exceptions are thrown when adding new posts.
	 */
	private static void testAddPost() {
		String testName = "testAddPost";
		boolean testPassed = true;
		String testResults = "";
		String subtest = testName;
		try {
			/* Set up new empty TextBook */
			File postFile = new File(TextBookInterface.POST_LIST_FILENAME);
			if (postFile.exists()) {
				postFile.delete();
			}
			TextBookInterface theTextBook = new TextBook();

			subtest = testName + " - first Post";
			theTextBook.addPost(ADA_POST_AUTHOR, ADA_POST_TEXT);
			testResults += subTestPass(subtest);

			subtest = testName + " - second Post";
			theTextBook.addPost(KATHERINE_POST_AUTHOR, KATHERINE_POST_TEXT);
			testResults += subTestPass(subtest);

			subtest = testName + " - third Post";
			theTextBook.addPost(GRACE_POST_AUTHOR, GRACE_POST_TEXT);
			testResults += subTestPass(subtest);

		} catch (Exception e) {
			testResults += subTestFailure(subtest, "No exceptions.", "Exception thrown.");
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
	 * Confirm that removePost() returns null for invalid indexes and the Post
	 * with expected values for valid indexes.
	 */
	private static void testRemovePost() {
		String testName = "testRemovePost";
		boolean testPassed = true;
		String testResults = "";
		String subtest = testName;
		try {
			/* Set up text book with 3 posts */
			File postFile = new File(TextBookInterface.POST_LIST_FILENAME);
			if (postFile.exists()) {
				postFile.delete();
			}
			TextBookInterface theTextBook = new TextBook();
			theTextBook.addPost(ADA_POST_AUTHOR, ADA_POST_TEXT);
			theTextBook.addPost(KATHERINE_POST_AUTHOR, KATHERINE_POST_TEXT);
			theTextBook.addPost(GRACE_POST_AUTHOR, GRACE_POST_TEXT);

			try {
				subtest = testName + " - invalid index -1";
				Post thePost = theTextBook.removePost(-1);
				if (thePost != null) {
					testResults += subTestFailure(subtest, "removePost() returns null", "removePost() returned non-null reference");
					testPassed = false;					
				} else {
					testResults += subTestPass(subtest);
				}
			} catch (Exception e) {
				testResults += subTestFailure(subtest, "No exceptions.", "Exception thrown.");
				testResults += e.toString();
				testPassed = false;
				e.printStackTrace();
			}

			try {
				subtest = testName + " - invalid index 3";
				Post thePost = theTextBook.removePost(3);
				if (thePost != null) {
					testResults += subTestFailure(subtest, "removePost(3) returns null", "removePost(3) returned non-null reference");
					testPassed = false;					
				} else {
					testResults += subTestPass(subtest);
				}
			} catch (Exception e) {
				testResults += subTestFailure(subtest, "No exceptions.", "Exception thrown.");
				testResults += e.toString();
				testPassed = false;
				e.printStackTrace();
			}

			try {
				subtest = testName + " - valid index 2 (last post)";
				Post thePost = theTextBook.removePost(2);
				boolean subtestPassed = true;
				if (thePost == null) {
					testResults += subTestFailure(subtest, "removePost(2) returns non-null reference", "removePost(2) returned null");
					testPassed = false;		
					subtestPassed = false;
				}
				if (!thePost.getAuthor().equals(GRACE_POST_AUTHOR)) {
					testResults += subTestFailure(subtest, "author of returned Post is " + GRACE_POST_AUTHOR, "author of returned Post is " + thePost.getAuthor());
					testPassed = false;		
					subtestPassed = false;					
				}
				if (!thePost.getText().equals(GRACE_POST_TEXT)) {
					testResults += subTestFailure(subtest, "text of returned Post is \"" + GRACE_POST_TEXT + "\"", "text of returned Post is \"" + thePost.getText() + "\"");
					testPassed = false;		
					subtestPassed = false;					
				}
				if (subtestPassed) {
					testResults += subTestPass(subtest);
				}
			} catch (Exception e) {
				testResults += subTestFailure(subtest, "No exceptions.", "Exception thrown.");
				testResults += e.toString();
				testPassed = false;
				e.printStackTrace();
			}

			try {
				subtest = testName + " - valid index 0 (first post)";
				Post thePost = theTextBook.removePost(0);
				boolean subtestPassed = true;
				if (thePost == null) {
					testResults += subTestFailure(subtest, "removePost(0) returns non-null reference", "removePost(0) returned null");
					testPassed = false;		
					subtestPassed = false;
				}
				if (!thePost.getAuthor().equals(ADA_POST_AUTHOR)) {
					testResults += subTestFailure(subtest, "author of returned Post is " + ADA_POST_AUTHOR, "author of returned Post is " + thePost.getAuthor());
					testPassed = false;		
					subtestPassed = false;					
				}
				if (!thePost.getText().equals(ADA_POST_TEXT)) {
					testResults += subTestFailure(subtest, "text of returned Post is \"" + ADA_POST_TEXT + "\"", "text of returned Post is \"" + thePost.getText() + "\"");
					testPassed = false;		
					subtestPassed = false;					
				}
				if (subtestPassed) {
					testResults += subTestPass(subtest);
				}
			} catch (Exception e) {
				testResults += subTestFailure(subtest, "No exceptions.", "Exception thrown.");
				testResults += e.toString();
				testPassed = false;
				e.printStackTrace();
			}

			try {
				subtest = testName + " - valid index 0 (last remaining post, originally second post)";
				Post thePost = theTextBook.removePost(0);
				boolean subtestPassed = true;
				if (thePost == null) {
					testResults += subTestFailure(subtest, "removePost(0) returns non-null reference", "removePost(0) returned null");
					testPassed = false;		
					subtestPassed = false;
				}
				if (!thePost.getAuthor().equals(KATHERINE_POST_AUTHOR)) {
					testResults += subTestFailure(subtest, "author of returned Post is " + KATHERINE_POST_AUTHOR, "author of returned Post is " + thePost.getAuthor());
					testPassed = false;		
					subtestPassed = false;					
				}
				if (!thePost.getText().equals(KATHERINE_POST_TEXT)) {
					testResults += subTestFailure(subtest, "text of returned Post is \"" + KATHERINE_POST_TEXT + "\"", "text of returned Post is \"" + thePost.getText() + "\"");
					testPassed = false;		
					subtestPassed = false;					
				}
				if (subtestPassed) {
					testResults += subTestPass(subtest);
				}
			} catch (Exception e) {
				testResults += subTestFailure(subtest, "No exceptions.", "Exception thrown.");
				testResults += e.toString();
				testPassed = false;
				e.printStackTrace();
			}
		} catch (Exception e) {
			testResults += subTestFailure(subtest, "No exceptions while populating TextBook.", "Exception thrown.");
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
	 * Confirm that addComment() returns false for invalid Post indexes and true
	 * for valid indexes.
	 */
	private static void testAddComment() {
		String testName = "testAddComment";
		boolean testPassed = true;
		String testResults = "";
		String subtest = testName;
		try {
			/* Set up text book with 3 posts */
			File postFile = new File(TextBookInterface.POST_LIST_FILENAME);
			if (postFile.exists()) {
				postFile.delete();
			}
			TextBookInterface theTextBook = new TextBook();
			theTextBook.addPost(ADA_POST_AUTHOR, ADA_POST_TEXT);
			theTextBook.addPost(KATHERINE_POST_AUTHOR, KATHERINE_POST_TEXT);
			theTextBook.addPost(GRACE_POST_AUTHOR, GRACE_POST_TEXT);

			try {
				subtest = testName + " - invalid index -1";
				boolean response = theTextBook.addComment(-1, ADA_POST_AUTHOR, ADA_POST_TEXT);
				if (response) {
					testResults += subTestFailure(subtest, "addComment(-1) returns false", "addComment(-1) returned true");
					testPassed = false;					
				} else {
					testResults += subTestPass(subtest);
				}
			} catch (Exception e) {
				testResults += subTestFailure(subtest, "No exceptions.", "Exception thrown.");
				testResults += e.toString();
				testPassed = false;
				e.printStackTrace();
			}

			try {
				subtest = testName + " - invalid index 3";
				boolean response = theTextBook.addComment(3, ADA_POST_AUTHOR, ADA_POST_TEXT);
				if (response) {
					testResults += subTestFailure(subtest, "addComment(3) returns false", "addComment(3) returned true");
					testPassed = false;					
				} else {
					testResults += subTestPass(subtest);
				}
			} catch (Exception e) {
				testResults += subTestFailure(subtest, "No exceptions.", "Exception thrown.");
				testResults += e.toString();
				testPassed = false;
				e.printStackTrace();
			}

			try {
				subtest = testName + " - valid index 0 (first post)";
				boolean response = theTextBook.addComment(0, ADA_POST_COMMENT1_AUTHOR, ADA_POST_COMMENT1_TEXT);
				boolean subtestPassed = true;
				if (!response) {
					testResults += subTestFailure(subtest, "first comment with addComment(0) returns true", "addComment(0) returned false");
					testPassed = false;		
					subtestPassed = false;
				}
				response = theTextBook.addComment(0, ADA_POST_COMMENT2_AUTHOR, ADA_POST_COMMENT2_TEXT);
				if (!response) {
					testResults += subTestFailure(subtest, "second comment with addComment(0) returns true", "addComment(0) returned false");
					testPassed = false;		
					subtestPassed = false;
				}
				if (subtestPassed) {
					testResults += subTestPass(subtest);
				}
			} catch (Exception e) {
				testResults += subTestFailure(subtest, "No exceptions.", "Exception thrown.");
				testResults += e.toString();
				testPassed = false;
				e.printStackTrace();
			}

			try {
				subtest = testName + " - valid index 2 (third post)";
				boolean response = theTextBook.addComment(2, GRACE_POST_COMMENT1_AUTHOR, GRACE_POST_COMMENT1_TEXT);
				boolean subtestPassed = true;
				if (!response) {
					testResults += subTestFailure(subtest, "first comment with addComment(2) returns true", "addComment(2) returned false");
					testPassed = false;		
					subtestPassed = false;
				}
				if (subtestPassed) {
					testResults += subTestPass(subtest);
				}
			} catch (Exception e) {
				testResults += subTestFailure(subtest, "No exceptions.", "Exception thrown.");
				testResults += e.toString();
				testPassed = false;
				e.printStackTrace();
			}
		} catch (Exception e) {
			testResults += subTestFailure(subtest, "No exceptions while populating TextBook.", "Exception thrown.");
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
	 * Confirm that removePost() returns null for invalid indexes and the Post
	 * with expected values for valid indexes.
	 */
	private static void testLastID() {
		String testName = "testGetLastID";
		boolean testPassed = true;
		String testResults = "";
		String subtest = testName;
		try {
			/* Construct a new empty TextBook */
			File postFile = new File(TextBookInterface.POST_LIST_FILENAME);
			if (postFile.exists()) {
				postFile.delete();
			}
			TextBookInterface theTextBook = new TextBook();

			subtest = testName + " - no pre-existing " + TextBookInterface.POST_LIST_FILENAME + " file";
			if (theTextBook.getLastID() != 0) {
				testResults += subTestFailure(subtest, "0", Integer.toString(theTextBook.getLastID()));
				testPassed = false;
			} else {
				testResults += subTestPass(subtest);
			}

			/* Add 3 Posts to TextBook */
			theTextBook.addPost(ADA_POST_AUTHOR, ADA_POST_TEXT);
			theTextBook.addPost(KATHERINE_POST_AUTHOR, KATHERINE_POST_TEXT);
			theTextBook.addPost(GRACE_POST_AUTHOR, GRACE_POST_TEXT);

			subtest = testName + " - after 3 Posts added";
			if (theTextBook.getLastID() != 3) {
				testResults += subTestFailure(subtest, "3", Integer.toString(theTextBook.getLastID()));
				testPassed = false;
			} else {
				testResults += subTestPass(subtest);
			}

			/* recover TextBook from file */
			theTextBook = new TextBook();

			subtest = testName + " - after recovering TextBook from file";
			if (theTextBook.getLastID() != 3) {
				testResults += subTestFailure(subtest, "3", Integer.toString(theTextBook.getLastID()));
				testPassed = false;
			} else {
				testResults += subTestPass(subtest);
			}
		} catch (Exception e) {
			testResults += subTestFailure(subtest, "No exceptions.", "Exception thrown.");
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
	 * Confirm that getPostCount() returns the expected count.
	 */
	private static void testGetPostCount() {
		String testName = "testGetPostCount";
		boolean testPassed = true;
		String testResults = "";
		String subtest = testName;
		try {
			/* Set up new empty text book */
			File postFile = new File(TextBookInterface.POST_LIST_FILENAME);
			if (postFile.exists()) {
				postFile.delete();
			}
			TextBookInterface theTextBook = new TextBook();

			subtest = testName + " - new empty TextBook";
			if (theTextBook.getPostCount() != 0) {
				testResults += subTestFailure(subtest, Integer.toString(0), Integer.toString(theTextBook.getPostCount()));
				testPassed = false;		
			} else {
				testResults += subTestPass(subtest);
			}

			subtest = testName + " - after adding one Post";
			theTextBook.addPost(ADA_POST_AUTHOR, ADA_POST_TEXT);
			if (theTextBook.getPostCount() != 1) {
				testResults += subTestFailure(subtest, Integer.toString(1), Integer.toString(theTextBook.getPostCount()));
				testPassed = false;		
			} else {
				testResults += subTestPass(subtest);
			}

			subtest = testName + " - after adding second Post";
			theTextBook.addPost(GRACE_POST_AUTHOR, GRACE_POST_TEXT);
			if (theTextBook.getPostCount() != 2) {
				testResults += subTestFailure(subtest, Integer.toString(2), Integer.toString(theTextBook.getPostCount()));
				testPassed = false;		
			} else {
				testResults += subTestPass(subtest);
			}

			subtest = testName + " - after removing second Post";
			theTextBook.removePost(1);
			if (theTextBook.getPostCount() != 1) {
				testResults += subTestFailure(subtest, Integer.toString(1), Integer.toString(theTextBook.getPostCount()));
				testPassed = false;		
			} else {
				testResults += subTestPass(subtest);
			}

			subtest = testName + " - after removing last remaining Post";
			theTextBook.removePost(0);
			if (theTextBook.getPostCount() != 0) {
				testResults += subTestFailure(subtest, Integer.toString(0), Integer.toString(theTextBook.getPostCount()));
				testPassed = false;		
			} else {
				testResults += subTestPass(subtest);
			}
		} catch (Exception e) {
			testResults += subTestFailure(subtest, "No exceptions.", "Exception thrown.");
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
	 * Confirm that getPostString() returns null for invalid indexes and a
	 * String including the Post and all comments for valid indexes.
	 */
	private static void testGetPostString() {
		String testName = "testGetPostString";
		boolean testPassed = true;
		String testResults = "";
		String subtest = testName;
		try {
			/* Set up text book with 3 posts and 3 comments */
			File postFile = new File(TextBookInterface.POST_LIST_FILENAME);
			if (postFile.exists()) {
				postFile.delete();
			}
			TextBookInterface theTextBook = new TextBook();
			theTextBook.addPost(ADA_POST_AUTHOR, ADA_POST_TEXT);
			theTextBook.addPost(KATHERINE_POST_AUTHOR, KATHERINE_POST_TEXT);
			theTextBook.addPost(GRACE_POST_AUTHOR, GRACE_POST_TEXT);
			theTextBook.addComment(0, ADA_POST_COMMENT1_AUTHOR, ADA_POST_COMMENT1_TEXT);
			theTextBook.addComment(0, ADA_POST_COMMENT2_AUTHOR, ADA_POST_COMMENT2_TEXT);
			theTextBook.addComment(2, GRACE_POST_COMMENT1_AUTHOR, GRACE_POST_COMMENT1_TEXT);		

			try {
				subtest = testName + " - invalid index -1";
				String postString = theTextBook.getPostString(-1);
				if (postString != null) {
					testResults += subTestFailure(subtest, "getPostString(-1) returns null", "getPostString(-1) returned non-null reference");
					testPassed = false;					
				} else {
					testResults += subTestPass(subtest);
				}
			} catch (Exception e) {
				testResults += subTestFailure(subtest, "No exceptions.", "Exception thrown.");
				testResults += e.toString();
				testPassed = false;
				e.printStackTrace();
			}

			try {
				subtest = testName + " - invalid index 3";
				String postString = theTextBook.getPostString(3);
				if (postString != null) {
					testResults += subTestFailure(subtest, "getPostString(3) returns null", "getPostString(3) returned non-null reference");
					testPassed = false;					
				} else {
					testResults += subTestPass(subtest);
				}
			} catch (Exception e) {
				testResults += subTestFailure(subtest, "No exceptions.", "Exception thrown.");
				testResults += e.toString();
				testPassed = false;
				e.printStackTrace();
			}

			try {
				subtest = testName + " - valid index 0 (first post)";
				boolean subtestPassed = true;
				String postString = theTextBook.getPostString(0);
				if (postString == null) {
					testResults += subTestFailure(subtest, "getPostString() returns non-null reference", "getPostString() returned null");
					testPassed = false;		
					subtestPassed = false;
				}
				String[] lines = postString.split("\n");
				if (lines.length != 5) {
					testResults += subTestFailure(subtest, "getPostString() has 5 lines - 2 headers, post, and two comments", postString);
					testPassed = false;		
					subtestPassed = false;					
				}
				if (!lines[1].contains(ADA_POST_AUTHOR)) {
					testResults += subTestFailure(subtest, "first line contains post author " + ADA_POST_AUTHOR, lines[1]);
					testPassed = false;		
					subtestPassed = false;					
				}
				if (!lines[1].contains(ADA_POST_TEXT)) {
					testResults += subTestFailure(subtest, "first line contains post text \"" + ADA_POST_TEXT + "\"", lines[1]);
					testPassed = false;		
					subtestPassed = false;					
				}
				if (!lines[3].contains(ADA_POST_COMMENT1_AUTHOR)) {
					testResults += subTestFailure(subtest, "second line contains comment author " + ADA_POST_COMMENT1_AUTHOR, lines[3]);
					testPassed = false;		
					subtestPassed = false;					
				}
				if (!lines[3].contains(ADA_POST_COMMENT1_TEXT)) {
					testResults += subTestFailure(subtest, "second line contains comment text \"" + ADA_POST_COMMENT1_TEXT + "\"", lines[3]);
					testPassed = false;		
					subtestPassed = false;					
				}
				if (!lines[4].contains(ADA_POST_COMMENT2_AUTHOR)) {
					testResults += subTestFailure(subtest, "third line contains comment author " + ADA_POST_COMMENT2_AUTHOR, lines[4]);
					testPassed = false;		
					subtestPassed = false;					
				}
				if (!lines[4].contains(ADA_POST_COMMENT2_TEXT)) {
					testResults += subTestFailure(subtest, "third line contains comment text \"" + ADA_POST_COMMENT2_TEXT + "\"", lines[4]);
					testPassed = false;		
					subtestPassed = false;					
				}
				if (subtestPassed) {
					testResults += subTestPass(subtest);
				}
			} catch (Exception e) {
				testResults += subTestFailure(subtest, "No exceptions.", "Exception thrown.");
				testResults += e.toString();
				testPassed = false;
				e.printStackTrace();
			}

			try {
				subtest = testName + " - valid index 1 (second post)";
				boolean subtestPassed = true;
				String postString = theTextBook.getPostString(1);
				if (postString == null) {
					testResults += subTestFailure(subtest, "getPostString() returns non-null reference", "getPostString() returned null");
					testPassed = false;		
					subtestPassed = false;
				}
				String[] lines = postString.split("\n");
				if (lines.length != 3) {
					testResults += subTestFailure(subtest, "getPostString() has 3 lines - post and 2 headers", postString);
					testPassed = false;		
					subtestPassed = false;					
				}
				if (!lines[1].contains(KATHERINE_POST_AUTHOR)) {
					testResults += subTestFailure(subtest, "first line contains post author " + KATHERINE_POST_AUTHOR, lines[1]);
					testPassed = false;		
					subtestPassed = false;					
				}
				if (!lines[1].contains(KATHERINE_POST_TEXT)) {
					testResults += subTestFailure(subtest, "first line contains post text \"" + KATHERINE_POST_TEXT + "\"", lines[1]);
					testPassed = false;		
					subtestPassed = false;					
				}
				if (subtestPassed) {
					testResults += subTestPass(subtest);
				}
			} catch (Exception e) {
				testResults += subTestFailure(subtest, "No exceptions while populating TextBook.", "Exception thrown.");
				testResults += e.toString();
				testPassed = false;
				e.printStackTrace();
			}

			try {
				subtest = testName + " - valid index 2 (third post)";
				boolean subtestPassed = true;
				String postString = theTextBook.getPostString(2);
				if (postString == null) {
					testResults += subTestFailure(subtest, "getPostString() returns non-null reference", "getPostString() returned null");
					testPassed = false;		
					subtestPassed = false;
				}
				String[] lines = postString.split("\n");
				if (lines.length != 4) {
					testResults += subTestFailure(subtest, "getPostString() has 4 lines - 2 headers, post, and one comment", postString);
					testPassed = false;		
					subtestPassed = false;					
				}
				if (!lines[1].contains(GRACE_POST_AUTHOR)) {
					testResults += subTestFailure(subtest, "first line contains post author " + GRACE_POST_AUTHOR, lines[1]);
					testPassed = false;		
					subtestPassed = false;					
				}
				if (!lines[1].contains(GRACE_POST_TEXT)) {
					testResults += subTestFailure(subtest, "first line contains post text \"" + GRACE_POST_TEXT + "\"", lines[1]);
					testPassed = false;		
					subtestPassed = false;					
				}
				if (!lines[3].contains(GRACE_POST_COMMENT1_AUTHOR)) {
					testResults += subTestFailure(subtest, "second line contains comment author " + GRACE_POST_COMMENT1_AUTHOR, lines[3]);
					testPassed = false;		
					subtestPassed = false;					
				}
				if (!lines[3].contains(GRACE_POST_COMMENT1_TEXT)) {
					testResults += subTestFailure(subtest, "second line contains comment text \"" + GRACE_POST_COMMENT1_TEXT + "\"", lines[3]);
					testPassed = false;		
					subtestPassed = false;					
				}
				if (subtestPassed) {
					testResults += subTestPass(subtest);
				}
			} catch (Exception e) {
				testResults += subTestFailure(subtest, "No exceptions.", "Exception thrown.");
				testResults += e.toString();
				testPassed = false;
				e.printStackTrace();
			}
		} catch (Exception e) {
			testResults += subTestFailure(subtest, "No exceptions while populating TextBook.", "Exception thrown.");
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
	 * Confirm getPosts() returns a list of all expected Posts and that TextBook
	 * encapsulation is preserved.
	 */
	private static void testGetPosts() {
		String testName = "testGetPosts";
		boolean testPassed = true;
		String testResults = "";
		String subtest = testName;
		try {
			/* Set up text book with 3 posts */
			File postFile = new File(TextBookInterface.POST_LIST_FILENAME);
			if (postFile.exists()) {
				postFile.delete();
			}
			TextBookInterface theTextBook = new TextBook();
			theTextBook.addPost(ADA_POST_AUTHOR, ADA_POST_TEXT);
			theTextBook.addPost(KATHERINE_POST_AUTHOR, KATHERINE_POST_TEXT);
			theTextBook.addPost(GRACE_POST_AUTHOR, GRACE_POST_TEXT);

			ArrayList<Post> returnedList = theTextBook.getPosts();

			subtest = testName + " - length of returned list";
			if (returnedList.size() == 3) {
				testResults += subTestPass(subtest);
			} else {
				testResults += subTestFailure(subtest, "3", Integer.toString(returnedList.size()));
				testPassed = false;
			}

			subtest = testName + " - all expected Posts included and in order";
			boolean allFound = true;
			if (!returnedList.get(0).getAuthor().equals(ADA_POST_AUTHOR)) {
				testResults += subTestFailure(subtest, "first returned Post author " + ADA_POST_AUTHOR, returnedList.get(0).getAuthor());
				testPassed = false;
				allFound = false;
			}
			if (!returnedList.get(1).getAuthor().equals(KATHERINE_POST_AUTHOR)) {
				testResults += subTestFailure(subtest, "second returned Post author " + KATHERINE_POST_AUTHOR, returnedList.get(1).getAuthor());
				testPassed = false;
				allFound = false;
			}
			if (!returnedList.get(2).getAuthor().equals(GRACE_POST_AUTHOR)) {
				testResults += subTestFailure(subtest, "third returned Post author " + GRACE_POST_AUTHOR, returnedList.get(2).getAuthor());
				testPassed = false;
				allFound = false;
			}
			if (allFound) {
				testResults += subTestPass(subtest);
			}

			/* Test that modifications to returned Posts ArrayList do not affect TextBook */
			subtest = testName + " - returning a copy of Posts list (preserving encapsulation)";
			returnedList.remove(0);
			returnedList = theTextBook.getPosts();
			if (returnedList.size() == 3) {
				testResults += subTestPass(subtest);
			} else {
				testResults += subTestFailure(subtest, "3", Integer.toString(returnedList.size()));
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
	 * Confirm expected markers of required output content and formatting from
	 * toString().
	 */
	private static void testToString() {
		String testName = "testToString";
		boolean testPassed = true;
		String testResults = "";
		try {
			/* Set up text book with 2 posts */
			File postFile = new File(TextBookInterface.POST_LIST_FILENAME);
			if (postFile.exists()) {
				postFile.delete();
			}
			TextBookInterface theTextBook = new TextBook();
			theTextBook.addPost(ADA_POST_AUTHOR, ADA_POST_TEXT);
			theTextBook.addPost(GRACE_POST_AUTHOR, GRACE_POST_TEXT);

			String returnedString = theTextBook.toString();
			String[] lines = returnedString.split("\n");

			String subtest = testName + " - output is expected number of lines";
			if (lines.length != 3) {
				testResults += subTestFailure(subtest, "number of lines is 3", Integer.toString(lines.length));
				testPassed = false;
			}

			subtest = testName + " - first line reports number of posts";
			boolean subtestPassed = true;
			if (!lines[0].contains("TextBook")) {
				testResults += subTestFailure(subtest, "first line contains 'TextBook'", lines[0]);
				testPassed = false;
				subtestPassed = false;
			}
			if (!lines[0].contains("posts") && !lines[0].contains("Posts")) {
				testResults += subTestFailure(subtest, "first line contains 'Posts' or 'posts'", lines[0]);
				testPassed = false;
				subtestPassed = false;				
			}
			if (!lines[0].contains("2")) {
				testResults += subTestFailure(subtest, "first line contains number 2", lines[0]);
				testPassed = false;
				subtestPassed = false;				
			}
			if (subtestPassed) {
				testResults += subTestPass(subtest);
			}

			subtest = testName + " - second line shows first Post at index 0";
			String[] lineTokens = lines[1].split("\\s+");
			subtestPassed = true;
			if (!lineTokens[0].equals("0")) {
				testResults += subTestFailure(subtest, "first post index is 0", lines[1]);
				testPassed = false;
				subtestPassed = false;				
			}
			if (lineTokens[2].length() != 5) {
				testResults += subTestFailure(subtest, "first post id formatted to 5 digits", lineTokens[2]);
				testPassed = false;
				subtestPassed = false;
			}
			try {
				@SuppressWarnings("unused")
				int id = Integer.parseInt(lineTokens[2]);
			} catch (NumberFormatException e) {
				testResults += subTestFailure(subtest, "first post id follows index", lines[1]);
				testPassed = false;
				subtestPassed = false;
			}
			try {
				@SuppressWarnings("unused")
				Instant timestamp = Instant.parse(lineTokens[3]);
			} catch (DateTimeParseException e) {
				testResults += subTestFailure(subtest, "first post timestamp follows post id", lines[1]);
				testPassed = false;
				subtestPassed = false;
			}
			if (!lineTokens[4].equals(ADA_POST_AUTHOR)) {
				testResults += subTestFailure(subtest, "first post author is " + ADA_POST_AUTHOR + " and follows timestamp", lines[1]);
				testPassed = false;
				subtestPassed = false;				
			}
			if (!lines[1].contains(ADA_POST_TEXT)) {
				testResults += subTestFailure(subtest, "first post text is \"" + ADA_POST_TEXT + "\"", lines[1]);
				testPassed = false;
				subtestPassed = false;				
			}
			if (!lineTokens[1].equals("-")) {
				testResults += subTestFailure(subtest, "dash ('-') between index and post", lines[2]);
				testPassed = false;
				subtestPassed = false;
			}
			if (subtestPassed) {
				testResults += subTestPass(subtest);
			}

			subtest = testName + " - third line shows second Post at index 1";
			lineTokens = lines[2].split("\\s+");
			subtestPassed = true;
			if (!lineTokens[0].equals("1")) {
				testResults += subTestFailure(subtest, "second post index is 1", lines[2]);
				testPassed = false;
				subtestPassed = false;				
			}
			if (lineTokens[2].length() != 5) {
				testResults += subTestFailure(subtest, "second post id formatted to 5 digits", lineTokens[2]);
				testPassed = false;
				subtestPassed = false;
			}
			try {
				@SuppressWarnings("unused")
				int id = Integer.parseInt(lineTokens[2]);
			} catch (NumberFormatException e) {
				testResults += subTestFailure(subtest, "second post id follows index", lines[2]);
				testPassed = false;
				subtestPassed = false;
			}
			try {
				@SuppressWarnings("unused")
				Instant timestamp = Instant.parse(lineTokens[3]);
			} catch (DateTimeParseException e) {
				testResults += subTestFailure(subtest, "second post timestamp follows post id", lines[2]);
				testPassed = false;
				subtestPassed = false;
			}
			if (!lineTokens[4].equals(GRACE_POST_AUTHOR)) {
				testResults += subTestFailure(subtest, "second post author is " + GRACE_POST_AUTHOR + " and follows timestamp", lines[2]);
				testPassed = false;
				subtestPassed = false;				
			}
			if (!lines[2].contains(GRACE_POST_TEXT)) {
				testResults += subTestFailure(subtest, "second post text is \"" + GRACE_POST_TEXT + "\"", lines[2]);
				testPassed = false;
				subtestPassed = false;				
			}
			if (!lineTokens[1].equals("-")) {
				testResults += subTestFailure(subtest, "dash ('-') between index and post", lines[2]);
				testPassed = false;
				subtestPassed = false;
			}
			if (subtestPassed) {
				testResults += subTestPass(subtest);
			}
		} catch (Exception e) {
			testResults += subTestFailure(testName, "No exceptions.", "Exception thrown. ");
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
		testsPassed++;
	}

}
