import java.awt.Point;

/**
 * A unit tester for classes that implement TicTacToe.  
 * @author mvail
 */
public class TicTacToeTester {

	// possible results expected in tests
	private static enum Result {
		True, False,
		X, O, Tie, InProgress,
		Pass, Fail,
		NoException, UnexpectedException
	};

	//tracking number of tests and test results
	private final int EXPECTED_TOTAL_TESTS;//initialized in constructor
	private int totalTests;
	private int passes = 0;
	private int failures = 0;
	private int totalRun = 0;
	private int secTotal = 0;
	private int secPasses = 0;
	private int secFails = 0;

	//control output - modified by command-line args
	private boolean printFailuresOnly = true;
	private boolean printSectionSummaries = true;

	/**
	 * Valid command line args include:
	 *  -a : print results from all tests (default is to print failed tests, only)
	 *  -s : hide Strings from toString() tests
	 *  -m : hide section summaries in output
	 * @param args not used
	 */
	public static void main(String[] args) {
		// to avoid every method being static
		TicTacToeTester tester = new TicTacToeTester(args);
		tester.runTests();
	}

	/** tester constructor
	 * @param args command line args
	 */
	public TicTacToeTester(String[] args) {
		for (String arg : args) {
			if (arg.equalsIgnoreCase("-a")) printFailuresOnly = false;
			if (arg.equalsIgnoreCase("-m"))	printSectionSummaries = false;
		}
		EXPECTED_TOTAL_TESTS = 598;
		totalTests = 0;
	}

	/** Print test results in a consistent format
	 * @param testDesc description of the test
	 * @param result indicates if the test passed or failed
	 */
	private void printTest(String testDesc, boolean result) {
		totalRun++;
		if (result) { passes++; }
		else { failures++; }
		if (!result || !printFailuresOnly) {
			System.out.printf("%-46s\t%s\n", testDesc, (result ? "   PASS" : "***FAIL***"));
		}
	}

	/** Print a final summary */
	private void printFinalSummary() {
		String verdict = String.format("\nTotal Tests Run: %d of %d,  Passed: %d (%.1f%%),  Failed: %d\n",
				totalRun, totalTests, passes, passes*100.0/totalTests, failures);
		String line = "";
		for (int i = 0; i < verdict.length(); i++) {
			line += "-";
		}
		System.out.println(line);
		System.out.println(verdict);
		if(totalTests != EXPECTED_TOTAL_TESTS) {
			System.out.printf("Expected %d total tests, but evaluated %d.\n",
					EXPECTED_TOTAL_TESTS, totalTests);
		}
	}

	/** Print a section summary */
	private void printSectionSummary(String secLabel) {
		secTotal = totalTests - secTotal;
		secPasses = passes - secPasses;
		secFails = failures - secFails;
		System.out.printf("\n%s Tests: %d,  Passed: %d,  Failed: %d\n", secLabel, secTotal, secPasses, secFails);
		secTotal = totalTests; //reset for next section
		secPasses = passes;
		secFails = failures;		
		System.out.printf("Tests Run So Far: %d of %d,  Passed: %d (%.1f%%),  Failed: %d\n",
				totalRun, EXPECTED_TOTAL_TESTS, passes, passes*100.0/EXPECTED_TOTAL_TESTS, failures);
	}

	// XXX runTests()
	//  see the blue box on the right of the scroll bar? the triple-X tag aids in navigating long files
	/** Run tests to confirm required functionality from list constructors and methods */
	private void runTests() {
		//brand new game
		testNewGame();
		//progress toward a tie game
		testX00();
		testX00O10();
		testX00O10X11();
		testX00O10X11O22();
		testX00O10X11O22X02();
		testX00O10X11O22X02O01();
		testX00O10X11O22X02O01X21();
		testX00O10X11O22X02O01X21O20();
		testX00O10X11O22X02O01X21O20X12(); //tie game
		testX02O10X00O22X01(); //X wins - first row
		testX11O00X10O22X12(); //X wins - second row
		testX22O00X20O12X21(); //X wins - third row
		testX00O11X20O12X10(); //X wins - first col
		testX01O10X21O12X11(); //X wins - second col
		testX12O11X02O21X22(); //X wins - third col
		testX11O02X22O12X00(); //X wins - first diagonal
		testX20O01X11O00X02(); //X wins - second diagonal
		testX10O01X20O02X11O00(); //O wins - first row
		testX00O10X20O12X01O11(); //O wins - second row
		testX00O21X10O20X01O22(); //O wins - third row
		testX22O10X11O00X01O20(); //O wins - first col
		testX00O01X22O11X10O21(); //O wins - second col
		testX11O02X00O22X10O12(); //O wins - third col
		testX01O00X10O11X21O22(); //O wins - first diagonal
		testX00O11X10O20X21O02(); //O wins - second diagonal

		// report final verdict
		printFinalSummary();
	}
	
	////////////////////////
	//XXX Scenario Tests
	////////////////////////
	
	private void testNewGame() {
		TicTacToe.Player[][] grid = {
				{TicTacToe.Player.OPEN, TicTacToe.Player.OPEN, TicTacToe.Player.OPEN},
				{TicTacToe.Player.OPEN, TicTacToe.Player.OPEN, TicTacToe.Player.OPEN},
				{TicTacToe.Player.OPEN, TicTacToe.Player.OPEN, TicTacToe.Player.OPEN}
		};
		Point[] newGameMoves = new Point[0];

		String scenarioName = "testNewGame";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 23;
		try {
			printTest("testNewGame", testNewGame(newGame()));
			printTest("testGameOver", testGameOver(newGame(), Result.False));
			printTest("testWinner", testWinner(newGame(), Result.InProgress));
			printTest("testGetGameGrid", testGetGameGrid(newGame(), grid));
			printTest("testGetMoves", testGetMoves(newGame(), newGameMoves));
			printTest("testChooseX00", testChoose(newGame(), TicTacToe.Player.X, 0, 0, Result.True));
			printTest("testChooseX01", testChoose(newGame(), TicTacToe.Player.X, 0, 1, Result.True));
			printTest("testChooseX02", testChoose(newGame(), TicTacToe.Player.X, 0, 2, Result.True));
			printTest("testChooseX10", testChoose(newGame(), TicTacToe.Player.X, 1, 0, Result.True));
			printTest("testChooseX11", testChoose(newGame(), TicTacToe.Player.X, 1, 1, Result.True));
			printTest("testChooseX12", testChoose(newGame(), TicTacToe.Player.X, 1, 2, Result.True));
			printTest("testChooseX20", testChoose(newGame(), TicTacToe.Player.X, 2, 0, Result.True));
			printTest("testChooseX21", testChoose(newGame(), TicTacToe.Player.X, 2, 1, Result.True));
			printTest("testChooseX22", testChoose(newGame(), TicTacToe.Player.X, 2, 2, Result.True));
			printTest("testChooseO00", testChoose(newGame(), TicTacToe.Player.O, 0, 0, Result.True));
			printTest("testChooseO01", testChoose(newGame(), TicTacToe.Player.O, 0, 1, Result.True));
			printTest("testChooseO02", testChoose(newGame(), TicTacToe.Player.O, 0, 2, Result.True));
			printTest("testChooseO10", testChoose(newGame(), TicTacToe.Player.O, 1, 0, Result.True));
			printTest("testChooseO11", testChoose(newGame(), TicTacToe.Player.O, 1, 1, Result.True));
			printTest("testChooseO12", testChoose(newGame(), TicTacToe.Player.O, 1, 2, Result.True));
			printTest("testChooseO20", testChoose(newGame(), TicTacToe.Player.O, 2, 0, Result.True));
			printTest("testChooseO21", testChoose(newGame(), TicTacToe.Player.O, 2, 1, Result.True));
			printTest("testChooseO22", testChoose(newGame(), TicTacToe.Player.O, 2, 2, Result.True));
		} catch (Exception e) {
			System.out.printf("***UNABLE TO RUN/COMPLETE %s***\n", scenarioName + " TESTS");
			e.printStackTrace();
		} finally {
			if (printSectionSummaries) {
				printSectionSummary("Section");
			}
		}
	}
	
	private void testX00() {
		TicTacToe.Player[][] grid = {
				{TicTacToe.Player.X, TicTacToe.Player.OPEN, TicTacToe.Player.OPEN},
				{TicTacToe.Player.OPEN, TicTacToe.Player.OPEN, TicTacToe.Player.OPEN},
				{TicTacToe.Player.OPEN, TicTacToe.Player.OPEN, TicTacToe.Player.OPEN}
		};
		Point[] moves = {new Point(0,0)};

		String scenarioName = "testX00";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 23;
		try {
			printTest("testNewGame", testNewGame(gameX00()));
			printTest("testGameOver", testGameOver(gameX00(), Result.False));
			printTest("testWinner", testWinner(gameX00(), Result.InProgress));
			printTest("testGetGameGrid", testGetGameGrid(gameX00(), grid));
			printTest("testGetMoves", testGetMoves(gameX00(), moves));
			printTest("testChooseX00", testChoose(gameX00(), TicTacToe.Player.X, 0, 0, Result.False));
			printTest("testChooseX01", testChoose(gameX00(), TicTacToe.Player.X, 0, 1, Result.True));
			printTest("testChooseX02", testChoose(gameX00(), TicTacToe.Player.X, 0, 2, Result.True));
			printTest("testChooseX10", testChoose(gameX00(), TicTacToe.Player.X, 1, 0, Result.True));
			printTest("testChooseX11", testChoose(gameX00(), TicTacToe.Player.X, 1, 1, Result.True));
			printTest("testChooseX12", testChoose(gameX00(), TicTacToe.Player.X, 1, 2, Result.True));
			printTest("testChooseX20", testChoose(gameX00(), TicTacToe.Player.X, 2, 0, Result.True));
			printTest("testChooseX21", testChoose(gameX00(), TicTacToe.Player.X, 2, 1, Result.True));
			printTest("testChooseX22", testChoose(gameX00(), TicTacToe.Player.X, 2, 2, Result.True));
			printTest("testChooseO00", testChoose(gameX00(), TicTacToe.Player.O, 0, 0, Result.False));
			printTest("testChooseO01", testChoose(gameX00(), TicTacToe.Player.O, 0, 1, Result.True));
			printTest("testChooseO02", testChoose(gameX00(), TicTacToe.Player.O, 0, 2, Result.True));
			printTest("testChooseO10", testChoose(gameX00(), TicTacToe.Player.O, 1, 0, Result.True));
			printTest("testChooseO11", testChoose(gameX00(), TicTacToe.Player.O, 1, 1, Result.True));
			printTest("testChooseO12", testChoose(gameX00(), TicTacToe.Player.O, 1, 2, Result.True));
			printTest("testChooseO20", testChoose(gameX00(), TicTacToe.Player.O, 2, 0, Result.True));
			printTest("testChooseO21", testChoose(gameX00(), TicTacToe.Player.O, 2, 1, Result.True));
			printTest("testChooseO22", testChoose(gameX00(), TicTacToe.Player.O, 2, 2, Result.True));
		} catch (Exception e) {
			System.out.printf("***UNABLE TO RUN/COMPLETE %s***\n", scenarioName + " TESTS");
			e.printStackTrace();
		} finally {
			if (printSectionSummaries) {
				printSectionSummary("Section");
			}
		}
	}
	
	private void testX00O10() {
		TicTacToe.Player[][] grid = {
				{TicTacToe.Player.X, TicTacToe.Player.OPEN, TicTacToe.Player.OPEN},
				{TicTacToe.Player.O, TicTacToe.Player.OPEN, TicTacToe.Player.OPEN},
				{TicTacToe.Player.OPEN, TicTacToe.Player.OPEN, TicTacToe.Player.OPEN}
		};
		Point[] moves = {new Point(0,0), new Point(1,0)};

		String scenarioName = "testX00O10";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 23;
		try {
			printTest("testNewGame", testNewGame(gameX00O10()));
			printTest("testGameOver", testGameOver(gameX00O10(), Result.False));
			printTest("testWinner", testWinner(gameX00O10(), Result.InProgress));
			printTest("testGetGameGrid", testGetGameGrid(gameX00O10(), grid));
			printTest("testGetMoves", testGetMoves(gameX00O10(), moves));
			printTest("testChooseX00", testChoose(gameX00O10(), TicTacToe.Player.X, 0, 0, Result.False));
			printTest("testChooseX01", testChoose(gameX00O10(), TicTacToe.Player.X, 0, 1, Result.True));
			printTest("testChooseX02", testChoose(gameX00O10(), TicTacToe.Player.X, 0, 2, Result.True));
			printTest("testChooseX10", testChoose(gameX00O10(), TicTacToe.Player.X, 1, 0, Result.False));
			printTest("testChooseX11", testChoose(gameX00O10(), TicTacToe.Player.X, 1, 1, Result.True));
			printTest("testChooseX12", testChoose(gameX00O10(), TicTacToe.Player.X, 1, 2, Result.True));
			printTest("testChooseX20", testChoose(gameX00O10(), TicTacToe.Player.X, 2, 0, Result.True));
			printTest("testChooseX21", testChoose(gameX00O10(), TicTacToe.Player.X, 2, 1, Result.True));
			printTest("testChooseX22", testChoose(gameX00O10(), TicTacToe.Player.X, 2, 2, Result.True));
			printTest("testChooseO00", testChoose(gameX00O10(), TicTacToe.Player.O, 0, 0, Result.False));
			printTest("testChooseO01", testChoose(gameX00O10(), TicTacToe.Player.O, 0, 1, Result.True));
			printTest("testChooseO02", testChoose(gameX00O10(), TicTacToe.Player.O, 0, 2, Result.True));
			printTest("testChooseO10", testChoose(gameX00O10(), TicTacToe.Player.O, 1, 0, Result.False));
			printTest("testChooseO11", testChoose(gameX00O10(), TicTacToe.Player.O, 1, 1, Result.True));
			printTest("testChooseO12", testChoose(gameX00O10(), TicTacToe.Player.O, 1, 2, Result.True));
			printTest("testChooseO20", testChoose(gameX00O10(), TicTacToe.Player.O, 2, 0, Result.True));
			printTest("testChooseO21", testChoose(gameX00O10(), TicTacToe.Player.O, 2, 1, Result.True));
			printTest("testChooseO22", testChoose(gameX00O10(), TicTacToe.Player.O, 2, 2, Result.True));
		} catch (Exception e) {
			System.out.printf("***UNABLE TO RUN/COMPLETE %s***\n", scenarioName + " TESTS");
			e.printStackTrace();
		} finally {
			if (printSectionSummaries) {
				printSectionSummary("Section");
			}
		}
	}

	private void testX00O10X11() {
		TicTacToe.Player[][] grid = {
				{TicTacToe.Player.X, TicTacToe.Player.OPEN, TicTacToe.Player.OPEN},
				{TicTacToe.Player.O, TicTacToe.Player.X, TicTacToe.Player.OPEN},
				{TicTacToe.Player.OPEN, TicTacToe.Player.OPEN, TicTacToe.Player.OPEN}
		};
		Point[] moves = {new Point(0,0), new Point(1,0), new Point(1,1)};

		String scenarioName = "testX00O10X11";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 23;
		try {
			printTest("testNewGame", testNewGame(gameX00O10X11()));
			printTest("testGameOver", testGameOver(gameX00O10X11(), Result.False));
			printTest("testWinner", testWinner(gameX00O10X11(), Result.InProgress));
			printTest("testGetGameGrid", testGetGameGrid(gameX00O10X11(), grid));
			printTest("testGetMoves", testGetMoves(gameX00O10X11(), moves));
			printTest("testChooseX00", testChoose(gameX00O10X11(), TicTacToe.Player.X, 0, 0, Result.False));
			printTest("testChooseX01", testChoose(gameX00O10X11(), TicTacToe.Player.X, 0, 1, Result.True));
			printTest("testChooseX02", testChoose(gameX00O10X11(), TicTacToe.Player.X, 0, 2, Result.True));
			printTest("testChooseX10", testChoose(gameX00O10X11(), TicTacToe.Player.X, 1, 0, Result.False));
			printTest("testChooseX11", testChoose(gameX00O10X11(), TicTacToe.Player.X, 1, 1, Result.False));
			printTest("testChooseX12", testChoose(gameX00O10X11(), TicTacToe.Player.X, 1, 2, Result.True));
			printTest("testChooseX20", testChoose(gameX00O10X11(), TicTacToe.Player.X, 2, 0, Result.True));
			printTest("testChooseX21", testChoose(gameX00O10X11(), TicTacToe.Player.X, 2, 1, Result.True));
			printTest("testChooseX22", testChoose(gameX00O10X11(), TicTacToe.Player.X, 2, 2, Result.True));
			printTest("testChooseO00", testChoose(gameX00O10X11(), TicTacToe.Player.O, 0, 0, Result.False));
			printTest("testChooseO01", testChoose(gameX00O10X11(), TicTacToe.Player.O, 0, 1, Result.True));
			printTest("testChooseO02", testChoose(gameX00O10X11(), TicTacToe.Player.O, 0, 2, Result.True));
			printTest("testChooseO10", testChoose(gameX00O10X11(), TicTacToe.Player.O, 1, 0, Result.False));
			printTest("testChooseO11", testChoose(gameX00O10X11(), TicTacToe.Player.O, 1, 1, Result.False));
			printTest("testChooseO12", testChoose(gameX00O10X11(), TicTacToe.Player.O, 1, 2, Result.True));
			printTest("testChooseO20", testChoose(gameX00O10X11(), TicTacToe.Player.O, 2, 0, Result.True));
			printTest("testChooseO21", testChoose(gameX00O10X11(), TicTacToe.Player.O, 2, 1, Result.True));
			printTest("testChooseO22", testChoose(gameX00O10X11(), TicTacToe.Player.O, 2, 2, Result.True));
		} catch (Exception e) {
			System.out.printf("***UNABLE TO RUN/COMPLETE %s***\n", scenarioName + " TESTS");
			e.printStackTrace();
		} finally {
			if (printSectionSummaries) {
				printSectionSummary("Section");
			}
		}
	}
	
	private void testX00O10X11O22() {
		TicTacToe.Player[][] grid = {
				{TicTacToe.Player.X, TicTacToe.Player.OPEN, TicTacToe.Player.OPEN},
				{TicTacToe.Player.O, TicTacToe.Player.X, TicTacToe.Player.OPEN},
				{TicTacToe.Player.OPEN, TicTacToe.Player.OPEN, TicTacToe.Player.O}
		};
		Point[] moves = {new Point(0,0), new Point(1,0), new Point(1,1),
				new Point(2,2)};

		String scenarioName = "testX00O10X11O22";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 23;
		try {
			printTest("testNewGame", testNewGame(gameX00O10X11O22()));
			printTest("testGameOver", testGameOver(gameX00O10X11O22(), Result.False));
			printTest("testWinner", testWinner(gameX00O10X11O22(), Result.InProgress));
			printTest("testGetGameGrid", testGetGameGrid(gameX00O10X11O22(), grid));
			printTest("testGetMoves", testGetMoves(gameX00O10X11O22(), moves));
			printTest("testChooseX00", testChoose(gameX00O10X11O22(), TicTacToe.Player.X, 0, 0, Result.False));
			printTest("testChooseX01", testChoose(gameX00O10X11O22(), TicTacToe.Player.X, 0, 1, Result.True));
			printTest("testChooseX02", testChoose(gameX00O10X11O22(), TicTacToe.Player.X, 0, 2, Result.True));
			printTest("testChooseX10", testChoose(gameX00O10X11O22(), TicTacToe.Player.X, 1, 0, Result.False));
			printTest("testChooseX11", testChoose(gameX00O10X11O22(), TicTacToe.Player.X, 1, 1, Result.False));
			printTest("testChooseX12", testChoose(gameX00O10X11O22(), TicTacToe.Player.X, 1, 2, Result.True));
			printTest("testChooseX20", testChoose(gameX00O10X11O22(), TicTacToe.Player.X, 2, 0, Result.True));
			printTest("testChooseX21", testChoose(gameX00O10X11O22(), TicTacToe.Player.X, 2, 1, Result.True));
			printTest("testChooseX22", testChoose(gameX00O10X11O22(), TicTacToe.Player.X, 2, 2, Result.False));
			printTest("testChooseO00", testChoose(gameX00O10X11O22(), TicTacToe.Player.O, 0, 0, Result.False));
			printTest("testChooseO01", testChoose(gameX00O10X11O22(), TicTacToe.Player.O, 0, 1, Result.True));
			printTest("testChooseO02", testChoose(gameX00O10X11O22(), TicTacToe.Player.O, 0, 2, Result.True));
			printTest("testChooseO10", testChoose(gameX00O10X11O22(), TicTacToe.Player.O, 1, 0, Result.False));
			printTest("testChooseO11", testChoose(gameX00O10X11O22(), TicTacToe.Player.O, 1, 1, Result.False));
			printTest("testChooseO12", testChoose(gameX00O10X11O22(), TicTacToe.Player.O, 1, 2, Result.True));
			printTest("testChooseO20", testChoose(gameX00O10X11O22(), TicTacToe.Player.O, 2, 0, Result.True));
			printTest("testChooseO21", testChoose(gameX00O10X11O22(), TicTacToe.Player.O, 2, 1, Result.True));
			printTest("testChooseO22", testChoose(gameX00O10X11O22(), TicTacToe.Player.O, 2, 2, Result.False));
		} catch (Exception e) {
			System.out.printf("***UNABLE TO RUN/COMPLETE %s***\n", scenarioName + " TESTS");
			e.printStackTrace();
		} finally {
			if (printSectionSummaries) {
				printSectionSummary("Section");
			}
		}
	}
	
	private void testX00O10X11O22X02() {
		TicTacToe.Player[][] grid = {
				{TicTacToe.Player.X, TicTacToe.Player.OPEN, TicTacToe.Player.X},
				{TicTacToe.Player.O, TicTacToe.Player.X, TicTacToe.Player.OPEN},
				{TicTacToe.Player.OPEN, TicTacToe.Player.OPEN, TicTacToe.Player.O}
		};
		Point[] moves = {new Point(0,0), new Point(1,0), new Point(1,1),
				new Point(2,2), new Point(0,2)};

		String scenarioName = "testX00O10X11O22X02";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 23;
		try {
			printTest("testNewGame", testNewGame(gameX00O10X11O22X02()));
			printTest("testGameOver", testGameOver(gameX00O10X11O22X02(), Result.False));
			printTest("testWinner", testWinner(gameX00O10X11O22X02(), Result.InProgress));
			printTest("testGetGameGrid", testGetGameGrid(gameX00O10X11O22X02(), grid));
			printTest("testGetMoves", testGetMoves(gameX00O10X11O22X02(), moves));
			printTest("testChooseX00", testChoose(gameX00O10X11O22X02(), TicTacToe.Player.X, 0, 0, Result.False));
			printTest("testChooseX01", testChoose(gameX00O10X11O22X02(), TicTacToe.Player.X, 0, 1, Result.True));
			printTest("testChooseX02", testChoose(gameX00O10X11O22X02(), TicTacToe.Player.X, 0, 2, Result.False));
			printTest("testChooseX10", testChoose(gameX00O10X11O22X02(), TicTacToe.Player.X, 1, 0, Result.False));
			printTest("testChooseX11", testChoose(gameX00O10X11O22X02(), TicTacToe.Player.X, 1, 1, Result.False));
			printTest("testChooseX12", testChoose(gameX00O10X11O22X02(), TicTacToe.Player.X, 1, 2, Result.True));
			printTest("testChooseX20", testChoose(gameX00O10X11O22X02(), TicTacToe.Player.X, 2, 0, Result.True));
			printTest("testChooseX21", testChoose(gameX00O10X11O22X02(), TicTacToe.Player.X, 2, 1, Result.True));
			printTest("testChooseX22", testChoose(gameX00O10X11O22X02(), TicTacToe.Player.X, 2, 2, Result.False));
			printTest("testChooseO00", testChoose(gameX00O10X11O22X02(), TicTacToe.Player.O, 0, 0, Result.False));
			printTest("testChooseO01", testChoose(gameX00O10X11O22X02(), TicTacToe.Player.O, 0, 1, Result.True));
			printTest("testChooseO02", testChoose(gameX00O10X11O22X02(), TicTacToe.Player.O, 0, 2, Result.False));
			printTest("testChooseO10", testChoose(gameX00O10X11O22X02(), TicTacToe.Player.O, 1, 0, Result.False));
			printTest("testChooseO11", testChoose(gameX00O10X11O22X02(), TicTacToe.Player.O, 1, 1, Result.False));
			printTest("testChooseO12", testChoose(gameX00O10X11O22X02(), TicTacToe.Player.O, 1, 2, Result.True));
			printTest("testChooseO20", testChoose(gameX00O10X11O22X02(), TicTacToe.Player.O, 2, 0, Result.True));
			printTest("testChooseO21", testChoose(gameX00O10X11O22X02(), TicTacToe.Player.O, 2, 1, Result.True));
			printTest("testChooseO22", testChoose(gameX00O10X11O22X02(), TicTacToe.Player.O, 2, 2, Result.False));
		} catch (Exception e) {
			System.out.printf("***UNABLE TO RUN/COMPLETE %s***\n", scenarioName + " TESTS");
			e.printStackTrace();
		} finally {
			if (printSectionSummaries) {
				printSectionSummary("Section");
			}
		}
	}
	
	private void testX00O10X11O22X02O01() {
		TicTacToe.Player[][] grid = {
				{TicTacToe.Player.X, TicTacToe.Player.O, TicTacToe.Player.X},
				{TicTacToe.Player.O, TicTacToe.Player.X, TicTacToe.Player.OPEN},
				{TicTacToe.Player.OPEN, TicTacToe.Player.OPEN, TicTacToe.Player.O}
		};
		Point[] moves = {new Point(0,0), new Point(1,0), new Point(1,1),
				new Point(2,2), new Point(0,2), new Point(0,1)};

		String scenarioName = "testX00O10X11O22X02O01";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 23;
		try {
			printTest("testNewGame", testNewGame(gameX00O10X11O22X02O01()));
			printTest("testGameOver", testGameOver(gameX00O10X11O22X02O01(), Result.False));
			printTest("testWinner", testWinner(gameX00O10X11O22X02O01(), Result.InProgress));
			printTest("testGetGameGrid", testGetGameGrid(gameX00O10X11O22X02O01(), grid));
			printTest("testGetMoves", testGetMoves(gameX00O10X11O22X02O01(), moves));
			printTest("testChooseX00", testChoose(gameX00O10X11O22X02O01(), TicTacToe.Player.X, 0, 0, Result.False));
			printTest("testChooseX01", testChoose(gameX00O10X11O22X02O01(), TicTacToe.Player.X, 0, 1, Result.False));
			printTest("testChooseX02", testChoose(gameX00O10X11O22X02O01(), TicTacToe.Player.X, 0, 2, Result.False));
			printTest("testChooseX10", testChoose(gameX00O10X11O22X02O01(), TicTacToe.Player.X, 1, 0, Result.False));
			printTest("testChooseX11", testChoose(gameX00O10X11O22X02O01(), TicTacToe.Player.X, 1, 1, Result.False));
			printTest("testChooseX12", testChoose(gameX00O10X11O22X02O01(), TicTacToe.Player.X, 1, 2, Result.True));
			printTest("testChooseX20", testChoose(gameX00O10X11O22X02O01(), TicTacToe.Player.X, 2, 0, Result.True));
			printTest("testChooseX21", testChoose(gameX00O10X11O22X02O01(), TicTacToe.Player.X, 2, 1, Result.True));
			printTest("testChooseX22", testChoose(gameX00O10X11O22X02O01(), TicTacToe.Player.X, 2, 2, Result.False));
			printTest("testChooseO00", testChoose(gameX00O10X11O22X02O01(), TicTacToe.Player.O, 0, 0, Result.False));
			printTest("testChooseO01", testChoose(gameX00O10X11O22X02O01(), TicTacToe.Player.O, 0, 1, Result.False));
			printTest("testChooseO02", testChoose(gameX00O10X11O22X02O01(), TicTacToe.Player.O, 0, 2, Result.False));
			printTest("testChooseO10", testChoose(gameX00O10X11O22X02O01(), TicTacToe.Player.O, 1, 0, Result.False));
			printTest("testChooseO11", testChoose(gameX00O10X11O22X02O01(), TicTacToe.Player.O, 1, 1, Result.False));
			printTest("testChooseO12", testChoose(gameX00O10X11O22X02O01(), TicTacToe.Player.O, 1, 2, Result.True));
			printTest("testChooseO20", testChoose(gameX00O10X11O22X02O01(), TicTacToe.Player.O, 2, 0, Result.True));
			printTest("testChooseO21", testChoose(gameX00O10X11O22X02O01(), TicTacToe.Player.O, 2, 1, Result.True));
			printTest("testChooseO22", testChoose(gameX00O10X11O22X02O01(), TicTacToe.Player.O, 2, 2, Result.False));
		} catch (Exception e) {
			System.out.printf("***UNABLE TO RUN/COMPLETE %s***\n", scenarioName + " TESTS");
			e.printStackTrace();
		} finally {
			if (printSectionSummaries) {
				printSectionSummary("Section");
			}
		}
	}
	
	private void testX00O10X11O22X02O01X21() {
		TicTacToe.Player[][] grid = {
				{TicTacToe.Player.X, TicTacToe.Player.O, TicTacToe.Player.X},
				{TicTacToe.Player.O, TicTacToe.Player.X, TicTacToe.Player.OPEN},
				{TicTacToe.Player.OPEN, TicTacToe.Player.X, TicTacToe.Player.O}
		};
		Point[] moves = {new Point(0,0), new Point(1,0), new Point(1,1),
				new Point(2,2), new Point(0,2), new Point(0,1), new Point(2,1)};

		String scenarioName = "testX00O10X11O22X02O01X21";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 23;
		try {
			printTest("testNewGame", testNewGame(gameX00O10X11O22X02O01X21()));
			printTest("testGameOver", testGameOver(gameX00O10X11O22X02O01X21(), Result.False));
			printTest("testWinner", testWinner(gameX00O10X11O22X02O01X21(), Result.InProgress));
			printTest("testGetGameGrid", testGetGameGrid(gameX00O10X11O22X02O01X21(), grid));
			printTest("testGetMoves", testGetMoves(gameX00O10X11O22X02O01X21(), moves));
			printTest("testChooseX00", testChoose(gameX00O10X11O22X02O01X21(), TicTacToe.Player.X, 0, 0, Result.False));
			printTest("testChooseX01", testChoose(gameX00O10X11O22X02O01X21(), TicTacToe.Player.X, 0, 1, Result.False));
			printTest("testChooseX02", testChoose(gameX00O10X11O22X02O01X21(), TicTacToe.Player.X, 0, 2, Result.False));
			printTest("testChooseX10", testChoose(gameX00O10X11O22X02O01X21(), TicTacToe.Player.X, 1, 0, Result.False));
			printTest("testChooseX11", testChoose(gameX00O10X11O22X02O01X21(), TicTacToe.Player.X, 1, 1, Result.False));
			printTest("testChooseX12", testChoose(gameX00O10X11O22X02O01X21(), TicTacToe.Player.X, 1, 2, Result.True));
			printTest("testChooseX20", testChoose(gameX00O10X11O22X02O01X21(), TicTacToe.Player.X, 2, 0, Result.True));
			printTest("testChooseX21", testChoose(gameX00O10X11O22X02O01X21(), TicTacToe.Player.X, 2, 1, Result.False));
			printTest("testChooseX22", testChoose(gameX00O10X11O22X02O01X21(), TicTacToe.Player.X, 2, 2, Result.False));
			printTest("testChooseO00", testChoose(gameX00O10X11O22X02O01X21(), TicTacToe.Player.O, 0, 0, Result.False));
			printTest("testChooseO01", testChoose(gameX00O10X11O22X02O01X21(), TicTacToe.Player.O, 0, 1, Result.False));
			printTest("testChooseO02", testChoose(gameX00O10X11O22X02O01X21(), TicTacToe.Player.O, 0, 2, Result.False));
			printTest("testChooseO10", testChoose(gameX00O10X11O22X02O01X21(), TicTacToe.Player.O, 1, 0, Result.False));
			printTest("testChooseO11", testChoose(gameX00O10X11O22X02O01X21(), TicTacToe.Player.O, 1, 1, Result.False));
			printTest("testChooseO12", testChoose(gameX00O10X11O22X02O01X21(), TicTacToe.Player.O, 1, 2, Result.True));
			printTest("testChooseO20", testChoose(gameX00O10X11O22X02O01X21(), TicTacToe.Player.O, 2, 0, Result.True));
			printTest("testChooseO21", testChoose(gameX00O10X11O22X02O01X21(), TicTacToe.Player.O, 2, 1, Result.False));
			printTest("testChooseO22", testChoose(gameX00O10X11O22X02O01X21(), TicTacToe.Player.O, 2, 2, Result.False));
		} catch (Exception e) {
			System.out.printf("***UNABLE TO RUN/COMPLETE %s***\n", scenarioName + " TESTS");
			e.printStackTrace();
		} finally {
			if (printSectionSummaries) {
				printSectionSummary("Section");
			}
		}
	}
	
	private void testX00O10X11O22X02O01X21O20() {
		TicTacToe.Player[][] grid = {
				{TicTacToe.Player.X, TicTacToe.Player.O, TicTacToe.Player.X},
				{TicTacToe.Player.O, TicTacToe.Player.X, TicTacToe.Player.OPEN},
				{TicTacToe.Player.O, TicTacToe.Player.X, TicTacToe.Player.O}
		};
		Point[] moves = {new Point(0,0), new Point(1,0), new Point(1,1),
				new Point(2,2), new Point(0,2), new Point(0,1), new Point(2,1), new Point(2,0)};

		String scenarioName = "testX00O10X11O22X02O01X21O20";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 23;
		try {
			printTest("testNewGame", testNewGame(gameX00O10X11O22X02O01X21O20()));
			printTest("testGameOver", testGameOver(gameX00O10X11O22X02O01X21O20(), Result.False));
			printTest("testWinner", testWinner(gameX00O10X11O22X02O01X21O20(), Result.InProgress));
			printTest("testGetGameGrid", testGetGameGrid(gameX00O10X11O22X02O01X21O20(), grid));
			printTest("testGetMoves", testGetMoves(gameX00O10X11O22X02O01X21O20(), moves));
			printTest("testChooseX00", testChoose(gameX00O10X11O22X02O01X21O20(), TicTacToe.Player.X, 0, 0, Result.False));
			printTest("testChooseX01", testChoose(gameX00O10X11O22X02O01X21O20(), TicTacToe.Player.X, 0, 1, Result.False));
			printTest("testChooseX02", testChoose(gameX00O10X11O22X02O01X21O20(), TicTacToe.Player.X, 0, 2, Result.False));
			printTest("testChooseX10", testChoose(gameX00O10X11O22X02O01X21O20(), TicTacToe.Player.X, 1, 0, Result.False));
			printTest("testChooseX11", testChoose(gameX00O10X11O22X02O01X21O20(), TicTacToe.Player.X, 1, 1, Result.False));
			printTest("testChooseX12", testChoose(gameX00O10X11O22X02O01X21O20(), TicTacToe.Player.X, 1, 2, Result.True));
			printTest("testChooseX20", testChoose(gameX00O10X11O22X02O01X21O20(), TicTacToe.Player.X, 2, 0, Result.False));
			printTest("testChooseX21", testChoose(gameX00O10X11O22X02O01X21O20(), TicTacToe.Player.X, 2, 1, Result.False));
			printTest("testChooseX22", testChoose(gameX00O10X11O22X02O01X21O20(), TicTacToe.Player.X, 2, 2, Result.False));
			printTest("testChooseO00", testChoose(gameX00O10X11O22X02O01X21O20(), TicTacToe.Player.O, 0, 0, Result.False));
			printTest("testChooseO01", testChoose(gameX00O10X11O22X02O01X21O20(), TicTacToe.Player.O, 0, 1, Result.False));
			printTest("testChooseO02", testChoose(gameX00O10X11O22X02O01X21O20(), TicTacToe.Player.O, 0, 2, Result.False));
			printTest("testChooseO10", testChoose(gameX00O10X11O22X02O01X21O20(), TicTacToe.Player.O, 1, 0, Result.False));
			printTest("testChooseO11", testChoose(gameX00O10X11O22X02O01X21O20(), TicTacToe.Player.O, 1, 1, Result.False));
			printTest("testChooseO12", testChoose(gameX00O10X11O22X02O01X21O20(), TicTacToe.Player.O, 1, 2, Result.True));
			printTest("testChooseO20", testChoose(gameX00O10X11O22X02O01X21O20(), TicTacToe.Player.O, 2, 0, Result.False));
			printTest("testChooseO21", testChoose(gameX00O10X11O22X02O01X21O20(), TicTacToe.Player.O, 2, 1, Result.False));
			printTest("testChooseO22", testChoose(gameX00O10X11O22X02O01X21O20(), TicTacToe.Player.O, 2, 2, Result.False));
		} catch (Exception e) {
			System.out.printf("***UNABLE TO RUN/COMPLETE %s***\n", scenarioName + " TESTS");
			e.printStackTrace();
		} finally {
			if (printSectionSummaries) {
				printSectionSummary("Section");
			}
		}
	}
	
	// complete tie game
	private void testX00O10X11O22X02O01X21O20X12() {
		TicTacToe.Player[][] grid = {
				{TicTacToe.Player.X, TicTacToe.Player.O, TicTacToe.Player.X},
				{TicTacToe.Player.O, TicTacToe.Player.X, TicTacToe.Player.X},
				{TicTacToe.Player.O, TicTacToe.Player.X, TicTacToe.Player.O}
		};
		Point[] moves = {new Point(0,0), new Point(1,0), new Point(1,1),
				new Point(2,2), new Point(0,2), new Point(0,1), new Point(2,1), 
				new Point(2,0), new Point(1,2)};

		String scenarioName = "testX00O10X11O22X02O01X21O20X12";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 23;
		try {
			printTest("testNewGame", testNewGame(gameX00O10X11O22X02O01X21O20X12()));
			printTest("testGameOver", testGameOver(gameX00O10X11O22X02O01X21O20X12(), Result.True));
			printTest("testWinner", testWinner(gameX00O10X11O22X02O01X21O20X12(), Result.Tie));
			printTest("testGetGameGrid", testGetGameGrid(gameX00O10X11O22X02O01X21O20X12(), grid));
			printTest("testGetMoves", testGetMoves(gameX00O10X11O22X02O01X21O20X12(), moves));
			printTest("testChooseX00", testChoose(gameX00O10X11O22X02O01X21O20X12(), TicTacToe.Player.X, 0, 0, Result.False));
			printTest("testChooseX01", testChoose(gameX00O10X11O22X02O01X21O20X12(), TicTacToe.Player.X, 0, 1, Result.False));
			printTest("testChooseX02", testChoose(gameX00O10X11O22X02O01X21O20X12(), TicTacToe.Player.X, 0, 2, Result.False));
			printTest("testChooseX10", testChoose(gameX00O10X11O22X02O01X21O20X12(), TicTacToe.Player.X, 1, 0, Result.False));
			printTest("testChooseX11", testChoose(gameX00O10X11O22X02O01X21O20X12(), TicTacToe.Player.X, 1, 1, Result.False));
			printTest("testChooseX12", testChoose(gameX00O10X11O22X02O01X21O20X12(), TicTacToe.Player.X, 1, 2, Result.False));
			printTest("testChooseX20", testChoose(gameX00O10X11O22X02O01X21O20X12(), TicTacToe.Player.X, 2, 0, Result.False));
			printTest("testChooseX21", testChoose(gameX00O10X11O22X02O01X21O20X12(), TicTacToe.Player.X, 2, 1, Result.False));
			printTest("testChooseX22", testChoose(gameX00O10X11O22X02O01X21O20X12(), TicTacToe.Player.X, 2, 2, Result.False));
			printTest("testChooseO00", testChoose(gameX00O10X11O22X02O01X21O20X12(), TicTacToe.Player.O, 0, 0, Result.False));
			printTest("testChooseO01", testChoose(gameX00O10X11O22X02O01X21O20X12(), TicTacToe.Player.O, 0, 1, Result.False));
			printTest("testChooseO02", testChoose(gameX00O10X11O22X02O01X21O20X12(), TicTacToe.Player.O, 0, 2, Result.False));
			printTest("testChooseO10", testChoose(gameX00O10X11O22X02O01X21O20X12(), TicTacToe.Player.O, 1, 0, Result.False));
			printTest("testChooseO11", testChoose(gameX00O10X11O22X02O01X21O20X12(), TicTacToe.Player.O, 1, 1, Result.False));
			printTest("testChooseO12", testChoose(gameX00O10X11O22X02O01X21O20X12(), TicTacToe.Player.O, 1, 2, Result.False));
			printTest("testChooseO20", testChoose(gameX00O10X11O22X02O01X21O20X12(), TicTacToe.Player.O, 2, 0, Result.False));
			printTest("testChooseO21", testChoose(gameX00O10X11O22X02O01X21O20X12(), TicTacToe.Player.O, 2, 1, Result.False));
			printTest("testChooseO22", testChoose(gameX00O10X11O22X02O01X21O20X12(), TicTacToe.Player.O, 2, 2, Result.False));
		} catch (Exception e) {
			System.out.printf("***UNABLE TO RUN/COMPLETE %s***\n", scenarioName + " TESTS");
			e.printStackTrace();
		} finally {
			if (printSectionSummaries) {
				printSectionSummary("Section");
			}
		}
	}
	
	//XXX X wins scenarios
	
	//X wins - first row
	private void testX02O10X00O22X01() {
		TicTacToe.Player[][] grid = {
				{TicTacToe.Player.X, TicTacToe.Player.X, TicTacToe.Player.X},
				{TicTacToe.Player.O, TicTacToe.Player.OPEN, TicTacToe.Player.OPEN},
				{TicTacToe.Player.OPEN, TicTacToe.Player.OPEN, TicTacToe.Player.O}
		};
		Point[] moves = {new Point(0,2), new Point(1,0), new Point(0,0),
				new Point(2,2), new Point(0,1)};

		String scenarioName = "testX02O10X00O22X01";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 23;
		try {
			printTest("testNewGame", testNewGame(gameX02O10X00O22X01()));
			printTest("testGameOver", testGameOver(gameX02O10X00O22X01(), Result.True));
			printTest("testWinner", testWinner(gameX02O10X00O22X01(), Result.X));
			printTest("testGetGameGrid", testGetGameGrid(gameX02O10X00O22X01(), grid));
			printTest("testGetMoves", testGetMoves(gameX02O10X00O22X01(), moves));
			printTest("testChooseX00", testChoose(gameX02O10X00O22X01(), TicTacToe.Player.X, 0, 0, Result.False));
			printTest("testChooseX01", testChoose(gameX02O10X00O22X01(), TicTacToe.Player.X, 0, 1, Result.False));
			printTest("testChooseX02", testChoose(gameX02O10X00O22X01(), TicTacToe.Player.X, 0, 2, Result.False));
			printTest("testChooseX10", testChoose(gameX02O10X00O22X01(), TicTacToe.Player.X, 1, 0, Result.False));
			printTest("testChooseX11", testChoose(gameX02O10X00O22X01(), TicTacToe.Player.X, 1, 1, Result.False));
			printTest("testChooseX12", testChoose(gameX02O10X00O22X01(), TicTacToe.Player.X, 1, 2, Result.False));
			printTest("testChooseX20", testChoose(gameX02O10X00O22X01(), TicTacToe.Player.X, 2, 0, Result.False));
			printTest("testChooseX21", testChoose(gameX02O10X00O22X01(), TicTacToe.Player.X, 2, 1, Result.False));
			printTest("testChooseX22", testChoose(gameX02O10X00O22X01(), TicTacToe.Player.X, 2, 2, Result.False));
			printTest("testChooseO00", testChoose(gameX02O10X00O22X01(), TicTacToe.Player.O, 0, 0, Result.False));
			printTest("testChooseO01", testChoose(gameX02O10X00O22X01(), TicTacToe.Player.O, 0, 1, Result.False));
			printTest("testChooseO02", testChoose(gameX02O10X00O22X01(), TicTacToe.Player.O, 0, 2, Result.False));
			printTest("testChooseO10", testChoose(gameX02O10X00O22X01(), TicTacToe.Player.O, 1, 0, Result.False));
			printTest("testChooseO11", testChoose(gameX02O10X00O22X01(), TicTacToe.Player.O, 1, 1, Result.False));
			printTest("testChooseO12", testChoose(gameX02O10X00O22X01(), TicTacToe.Player.O, 1, 2, Result.False));
			printTest("testChooseO20", testChoose(gameX02O10X00O22X01(), TicTacToe.Player.O, 2, 0, Result.False));
			printTest("testChooseO21", testChoose(gameX02O10X00O22X01(), TicTacToe.Player.O, 2, 1, Result.False));
			printTest("testChooseO22", testChoose(gameX02O10X00O22X01(), TicTacToe.Player.O, 2, 2, Result.False));
		} catch (Exception e) {
			System.out.printf("***UNABLE TO RUN/COMPLETE %s***\n", scenarioName + " TESTS");
			e.printStackTrace();
		} finally {
			if (printSectionSummaries) {
				printSectionSummary("Section");
			}
		}
	}
	
	//X wins - second row
	private void testX11O00X10O22X12() {
		TicTacToe.Player[][] grid = {
				{TicTacToe.Player.O, TicTacToe.Player.OPEN, TicTacToe.Player.OPEN},
				{TicTacToe.Player.X, TicTacToe.Player.X, TicTacToe.Player.X},
				{TicTacToe.Player.OPEN, TicTacToe.Player.OPEN, TicTacToe.Player.O}
		};
		Point[] moves = {new Point(1,1), new Point(0,0), new Point(1,0),
				new Point(2,2), new Point(1,2)};

		String scenarioName = "testX11O00X10O22X12";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 23;
		try {
			printTest("testNewGame", testNewGame(gameX11O00X10O22X12()));
			printTest("testGameOver", testGameOver(gameX11O00X10O22X12(), Result.True));
			printTest("testWinner", testWinner(gameX11O00X10O22X12(), Result.X));
			printTest("testGetGameGrid", testGetGameGrid(gameX11O00X10O22X12(), grid));
			printTest("testGetMoves", testGetMoves(gameX11O00X10O22X12(), moves));
			printTest("testChooseX00", testChoose(gameX11O00X10O22X12(), TicTacToe.Player.X, 0, 0, Result.False));
			printTest("testChooseX01", testChoose(gameX11O00X10O22X12(), TicTacToe.Player.X, 0, 1, Result.False));
			printTest("testChooseX02", testChoose(gameX11O00X10O22X12(), TicTacToe.Player.X, 0, 2, Result.False));
			printTest("testChooseX10", testChoose(gameX11O00X10O22X12(), TicTacToe.Player.X, 1, 0, Result.False));
			printTest("testChooseX11", testChoose(gameX11O00X10O22X12(), TicTacToe.Player.X, 1, 1, Result.False));
			printTest("testChooseX12", testChoose(gameX11O00X10O22X12(), TicTacToe.Player.X, 1, 2, Result.False));
			printTest("testChooseX20", testChoose(gameX11O00X10O22X12(), TicTacToe.Player.X, 2, 0, Result.False));
			printTest("testChooseX21", testChoose(gameX11O00X10O22X12(), TicTacToe.Player.X, 2, 1, Result.False));
			printTest("testChooseX22", testChoose(gameX11O00X10O22X12(), TicTacToe.Player.X, 2, 2, Result.False));
			printTest("testChooseO00", testChoose(gameX11O00X10O22X12(), TicTacToe.Player.O, 0, 0, Result.False));
			printTest("testChooseO01", testChoose(gameX11O00X10O22X12(), TicTacToe.Player.O, 0, 1, Result.False));
			printTest("testChooseO02", testChoose(gameX11O00X10O22X12(), TicTacToe.Player.O, 0, 2, Result.False));
			printTest("testChooseO10", testChoose(gameX11O00X10O22X12(), TicTacToe.Player.O, 1, 0, Result.False));
			printTest("testChooseO11", testChoose(gameX11O00X10O22X12(), TicTacToe.Player.O, 1, 1, Result.False));
			printTest("testChooseO12", testChoose(gameX11O00X10O22X12(), TicTacToe.Player.O, 1, 2, Result.False));
			printTest("testChooseO20", testChoose(gameX11O00X10O22X12(), TicTacToe.Player.O, 2, 0, Result.False));
			printTest("testChooseO21", testChoose(gameX11O00X10O22X12(), TicTacToe.Player.O, 2, 1, Result.False));
			printTest("testChooseO22", testChoose(gameX11O00X10O22X12(), TicTacToe.Player.O, 2, 2, Result.False));
		} catch (Exception e) {
			System.out.printf("***UNABLE TO RUN/COMPLETE %s***\n", scenarioName + " TESTS");
			e.printStackTrace();
		} finally {
			if (printSectionSummaries) {
				printSectionSummary("Section");
			}
		}		
	}

	//X wins - third row
	private void testX22O00X20O12X21() {
		TicTacToe.Player[][] grid = {
				{TicTacToe.Player.O, TicTacToe.Player.OPEN, TicTacToe.Player.OPEN},
				{TicTacToe.Player.OPEN, TicTacToe.Player.OPEN, TicTacToe.Player.O},
				{TicTacToe.Player.X, TicTacToe.Player.X, TicTacToe.Player.X}
		};
		Point[] moves = {new Point(2,2), new Point(0,0), new Point(2,0),
				new Point(1,2), new Point(2,1)};

		String scenarioName = "testX22O00X20O12X21";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 23;
		try {
			printTest("testNewGame", testNewGame(gameX22O00X20O12X21()));
			printTest("testGameOver", testGameOver(gameX22O00X20O12X21(), Result.True));
			printTest("testWinner", testWinner(gameX22O00X20O12X21(), Result.X));
			printTest("testGetGameGrid", testGetGameGrid(gameX22O00X20O12X21(), grid));
			printTest("testGetMoves", testGetMoves(gameX22O00X20O12X21(), moves));
			printTest("testChooseX00", testChoose(gameX22O00X20O12X21(), TicTacToe.Player.X, 0, 0, Result.False));
			printTest("testChooseX01", testChoose(gameX22O00X20O12X21(), TicTacToe.Player.X, 0, 1, Result.False));
			printTest("testChooseX02", testChoose(gameX22O00X20O12X21(), TicTacToe.Player.X, 0, 2, Result.False));
			printTest("testChooseX10", testChoose(gameX22O00X20O12X21(), TicTacToe.Player.X, 1, 0, Result.False));
			printTest("testChooseX11", testChoose(gameX22O00X20O12X21(), TicTacToe.Player.X, 1, 1, Result.False));
			printTest("testChooseX12", testChoose(gameX22O00X20O12X21(), TicTacToe.Player.X, 1, 2, Result.False));
			printTest("testChooseX20", testChoose(gameX22O00X20O12X21(), TicTacToe.Player.X, 2, 0, Result.False));
			printTest("testChooseX21", testChoose(gameX22O00X20O12X21(), TicTacToe.Player.X, 2, 1, Result.False));
			printTest("testChooseX22", testChoose(gameX22O00X20O12X21(), TicTacToe.Player.X, 2, 2, Result.False));
			printTest("testChooseO00", testChoose(gameX22O00X20O12X21(), TicTacToe.Player.O, 0, 0, Result.False));
			printTest("testChooseO01", testChoose(gameX22O00X20O12X21(), TicTacToe.Player.O, 0, 1, Result.False));
			printTest("testChooseO02", testChoose(gameX22O00X20O12X21(), TicTacToe.Player.O, 0, 2, Result.False));
			printTest("testChooseO10", testChoose(gameX22O00X20O12X21(), TicTacToe.Player.O, 1, 0, Result.False));
			printTest("testChooseO11", testChoose(gameX22O00X20O12X21(), TicTacToe.Player.O, 1, 1, Result.False));
			printTest("testChooseO12", testChoose(gameX22O00X20O12X21(), TicTacToe.Player.O, 1, 2, Result.False));
			printTest("testChooseO20", testChoose(gameX22O00X20O12X21(), TicTacToe.Player.O, 2, 0, Result.False));
			printTest("testChooseO21", testChoose(gameX22O00X20O12X21(), TicTacToe.Player.O, 2, 1, Result.False));
			printTest("testChooseO22", testChoose(gameX22O00X20O12X21(), TicTacToe.Player.O, 2, 2, Result.False));
		} catch (Exception e) {
			System.out.printf("***UNABLE TO RUN/COMPLETE %s***\n", scenarioName + " TESTS");
			e.printStackTrace();
		} finally {
			if (printSectionSummaries) {
				printSectionSummary("Section");
			}
		}
	}
	
	//X wins - first col
	private void testX00O11X20O12X10() {
		TicTacToe.Player[][] grid = {
				{TicTacToe.Player.X, TicTacToe.Player.OPEN, TicTacToe.Player.OPEN},
				{TicTacToe.Player.X, TicTacToe.Player.O, TicTacToe.Player.O},
				{TicTacToe.Player.X, TicTacToe.Player.OPEN, TicTacToe.Player.OPEN}
		};
		Point[] moves = {new Point(0,0), new Point(1,1), new Point(2,0),
				new Point(1,2), new Point(1,0)};

		String scenarioName = "testX00O11X20O12X10";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 23;
		try {
			printTest("testNewGame", testNewGame(gameX00O11X20O12X10()));
			printTest("testGameOver", testGameOver(gameX00O11X20O12X10(), Result.True));
			printTest("testWinner", testWinner(gameX00O11X20O12X10(), Result.X));
			printTest("testGetGameGrid", testGetGameGrid(gameX00O11X20O12X10(), grid));
			printTest("testGetMoves", testGetMoves(gameX00O11X20O12X10(), moves));
			printTest("testChooseX00", testChoose(gameX00O11X20O12X10(), TicTacToe.Player.X, 0, 0, Result.False));
			printTest("testChooseX01", testChoose(gameX00O11X20O12X10(), TicTacToe.Player.X, 0, 1, Result.False));
			printTest("testChooseX02", testChoose(gameX00O11X20O12X10(), TicTacToe.Player.X, 0, 2, Result.False));
			printTest("testChooseX10", testChoose(gameX00O11X20O12X10(), TicTacToe.Player.X, 1, 0, Result.False));
			printTest("testChooseX11", testChoose(gameX00O11X20O12X10(), TicTacToe.Player.X, 1, 1, Result.False));
			printTest("testChooseX12", testChoose(gameX00O11X20O12X10(), TicTacToe.Player.X, 1, 2, Result.False));
			printTest("testChooseX20", testChoose(gameX00O11X20O12X10(), TicTacToe.Player.X, 2, 0, Result.False));
			printTest("testChooseX21", testChoose(gameX00O11X20O12X10(), TicTacToe.Player.X, 2, 1, Result.False));
			printTest("testChooseX22", testChoose(gameX00O11X20O12X10(), TicTacToe.Player.X, 2, 2, Result.False));
			printTest("testChooseO00", testChoose(gameX00O11X20O12X10(), TicTacToe.Player.O, 0, 0, Result.False));
			printTest("testChooseO01", testChoose(gameX00O11X20O12X10(), TicTacToe.Player.O, 0, 1, Result.False));
			printTest("testChooseO02", testChoose(gameX00O11X20O12X10(), TicTacToe.Player.O, 0, 2, Result.False));
			printTest("testChooseO10", testChoose(gameX00O11X20O12X10(), TicTacToe.Player.O, 1, 0, Result.False));
			printTest("testChooseO11", testChoose(gameX00O11X20O12X10(), TicTacToe.Player.O, 1, 1, Result.False));
			printTest("testChooseO12", testChoose(gameX00O11X20O12X10(), TicTacToe.Player.O, 1, 2, Result.False));
			printTest("testChooseO20", testChoose(gameX00O11X20O12X10(), TicTacToe.Player.O, 2, 0, Result.False));
			printTest("testChooseO21", testChoose(gameX00O11X20O12X10(), TicTacToe.Player.O, 2, 1, Result.False));
			printTest("testChooseO22", testChoose(gameX00O11X20O12X10(), TicTacToe.Player.O, 2, 2, Result.False));
		} catch (Exception e) {
			System.out.printf("***UNABLE TO RUN/COMPLETE %s***\n", scenarioName + " TESTS");
			e.printStackTrace();
		} finally {
			if (printSectionSummaries) {
				printSectionSummary("Section");
			}
		}
	}
	
	//X wins - second col
	private void testX01O10X21O12X11() {
		TicTacToe.Player[][] grid = {
				{TicTacToe.Player.OPEN, TicTacToe.Player.X, TicTacToe.Player.OPEN},
				{TicTacToe.Player.O, TicTacToe.Player.X, TicTacToe.Player.O},
				{TicTacToe.Player.OPEN, TicTacToe.Player.X, TicTacToe.Player.OPEN}
		};
		Point[] moves = {new Point(0,1), new Point(1,0), new Point(2,1),
				new Point(1,2), new Point(1,1)};

		String scenarioName = "testX01O10X21O12X11";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 23;
		try {
			printTest("testNewGame", testNewGame(gameX01O10X21O12X11()));
			printTest("testGameOver", testGameOver(gameX01O10X21O12X11(), Result.True));
			printTest("testWinner", testWinner(gameX01O10X21O12X11(), Result.X));
			printTest("testGetGameGrid", testGetGameGrid(gameX01O10X21O12X11(), grid));
			printTest("testGetMoves", testGetMoves(gameX01O10X21O12X11(), moves));
			printTest("testChooseX00", testChoose(gameX01O10X21O12X11(), TicTacToe.Player.X, 0, 0, Result.False));
			printTest("testChooseX01", testChoose(gameX01O10X21O12X11(), TicTacToe.Player.X, 0, 1, Result.False));
			printTest("testChooseX02", testChoose(gameX01O10X21O12X11(), TicTacToe.Player.X, 0, 2, Result.False));
			printTest("testChooseX10", testChoose(gameX01O10X21O12X11(), TicTacToe.Player.X, 1, 0, Result.False));
			printTest("testChooseX11", testChoose(gameX01O10X21O12X11(), TicTacToe.Player.X, 1, 1, Result.False));
			printTest("testChooseX12", testChoose(gameX01O10X21O12X11(), TicTacToe.Player.X, 1, 2, Result.False));
			printTest("testChooseX20", testChoose(gameX01O10X21O12X11(), TicTacToe.Player.X, 2, 0, Result.False));
			printTest("testChooseX21", testChoose(gameX01O10X21O12X11(), TicTacToe.Player.X, 2, 1, Result.False));
			printTest("testChooseX22", testChoose(gameX01O10X21O12X11(), TicTacToe.Player.X, 2, 2, Result.False));
			printTest("testChooseO00", testChoose(gameX01O10X21O12X11(), TicTacToe.Player.O, 0, 0, Result.False));
			printTest("testChooseO01", testChoose(gameX01O10X21O12X11(), TicTacToe.Player.O, 0, 1, Result.False));
			printTest("testChooseO02", testChoose(gameX01O10X21O12X11(), TicTacToe.Player.O, 0, 2, Result.False));
			printTest("testChooseO10", testChoose(gameX01O10X21O12X11(), TicTacToe.Player.O, 1, 0, Result.False));
			printTest("testChooseO11", testChoose(gameX01O10X21O12X11(), TicTacToe.Player.O, 1, 1, Result.False));
			printTest("testChooseO12", testChoose(gameX01O10X21O12X11(), TicTacToe.Player.O, 1, 2, Result.False));
			printTest("testChooseO20", testChoose(gameX01O10X21O12X11(), TicTacToe.Player.O, 2, 0, Result.False));
			printTest("testChooseO21", testChoose(gameX01O10X21O12X11(), TicTacToe.Player.O, 2, 1, Result.False));
			printTest("testChooseO22", testChoose(gameX01O10X21O12X11(), TicTacToe.Player.O, 2, 2, Result.False));
		} catch (Exception e) {
			System.out.printf("***UNABLE TO RUN/COMPLETE %s***\n", scenarioName + " TESTS");
			e.printStackTrace();
		} finally {
			if (printSectionSummaries) {
				printSectionSummary("Section");
			}
		}
	}
	
	//X wins - third col
	private void testX12O11X02O21X22() {
		TicTacToe.Player[][] grid = {
				{TicTacToe.Player.OPEN, TicTacToe.Player.OPEN, TicTacToe.Player.X},
				{TicTacToe.Player.OPEN, TicTacToe.Player.O, TicTacToe.Player.X},
				{TicTacToe.Player.OPEN, TicTacToe.Player.O, TicTacToe.Player.X}
		};
		Point[] moves = {new Point(1,2), new Point(1,1), new Point(0,2),
				new Point(2,1), new Point(2,2)};

		String scenarioName = "testX12O11X02O21X22";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 23;
		try {
			printTest("testNewGame", testNewGame(gameX12O11X02O21X22()));
			printTest("testGameOver", testGameOver(gameX12O11X02O21X22(), Result.True));
			printTest("testWinner", testWinner(gameX12O11X02O21X22(), Result.X));
			printTest("testGetGameGrid", testGetGameGrid(gameX12O11X02O21X22(), grid));
			printTest("testGetMoves", testGetMoves(gameX12O11X02O21X22(), moves));
			printTest("testChooseX00", testChoose(gameX12O11X02O21X22(), TicTacToe.Player.X, 0, 0, Result.False));
			printTest("testChooseX01", testChoose(gameX12O11X02O21X22(), TicTacToe.Player.X, 0, 1, Result.False));
			printTest("testChooseX02", testChoose(gameX12O11X02O21X22(), TicTacToe.Player.X, 0, 2, Result.False));
			printTest("testChooseX10", testChoose(gameX12O11X02O21X22(), TicTacToe.Player.X, 1, 0, Result.False));
			printTest("testChooseX11", testChoose(gameX12O11X02O21X22(), TicTacToe.Player.X, 1, 1, Result.False));
			printTest("testChooseX12", testChoose(gameX12O11X02O21X22(), TicTacToe.Player.X, 1, 2, Result.False));
			printTest("testChooseX20", testChoose(gameX12O11X02O21X22(), TicTacToe.Player.X, 2, 0, Result.False));
			printTest("testChooseX21", testChoose(gameX12O11X02O21X22(), TicTacToe.Player.X, 2, 1, Result.False));
			printTest("testChooseX22", testChoose(gameX12O11X02O21X22(), TicTacToe.Player.X, 2, 2, Result.False));
			printTest("testChooseO00", testChoose(gameX12O11X02O21X22(), TicTacToe.Player.O, 0, 0, Result.False));
			printTest("testChooseO01", testChoose(gameX12O11X02O21X22(), TicTacToe.Player.O, 0, 1, Result.False));
			printTest("testChooseO02", testChoose(gameX12O11X02O21X22(), TicTacToe.Player.O, 0, 2, Result.False));
			printTest("testChooseO10", testChoose(gameX12O11X02O21X22(), TicTacToe.Player.O, 1, 0, Result.False));
			printTest("testChooseO11", testChoose(gameX12O11X02O21X22(), TicTacToe.Player.O, 1, 1, Result.False));
			printTest("testChooseO12", testChoose(gameX12O11X02O21X22(), TicTacToe.Player.O, 1, 2, Result.False));
			printTest("testChooseO20", testChoose(gameX12O11X02O21X22(), TicTacToe.Player.O, 2, 0, Result.False));
			printTest("testChooseO21", testChoose(gameX12O11X02O21X22(), TicTacToe.Player.O, 2, 1, Result.False));
			printTest("testChooseO22", testChoose(gameX12O11X02O21X22(), TicTacToe.Player.O, 2, 2, Result.False));
		} catch (Exception e) {
			System.out.printf("***UNABLE TO RUN/COMPLETE %s***\n", scenarioName + " TESTS");
			e.printStackTrace();
		} finally {
			if (printSectionSummaries) {
				printSectionSummary("Section");
			}
		}
	}
	
	//X wins - first diagonal
	private void testX11O02X22O12X00() {
		TicTacToe.Player[][] grid = {
				{TicTacToe.Player.X, TicTacToe.Player.OPEN, TicTacToe.Player.O},
				{TicTacToe.Player.OPEN, TicTacToe.Player.X, TicTacToe.Player.O},
				{TicTacToe.Player.OPEN, TicTacToe.Player.OPEN, TicTacToe.Player.X}
		};
		Point[] moves = {new Point(1,1), new Point(0,2), new Point(2,2),
				new Point(1,2), new Point(0,0)};

		String scenarioName = "testX11O02X22O12X00";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 23;
		try {
			printTest("testNewGame", testNewGame(gameX11O02X22O12X00()));
			printTest("testGameOver", testGameOver(gameX11O02X22O12X00(), Result.True));
			printTest("testWinner", testWinner(gameX11O02X22O12X00(), Result.X));
			printTest("testGetGameGrid", testGetGameGrid(gameX11O02X22O12X00(), grid));
			printTest("testGetMoves", testGetMoves(gameX11O02X22O12X00(), moves));
			printTest("testChooseX00", testChoose(gameX11O02X22O12X00(), TicTacToe.Player.X, 0, 0, Result.False));
			printTest("testChooseX01", testChoose(gameX11O02X22O12X00(), TicTacToe.Player.X, 0, 1, Result.False));
			printTest("testChooseX02", testChoose(gameX11O02X22O12X00(), TicTacToe.Player.X, 0, 2, Result.False));
			printTest("testChooseX10", testChoose(gameX11O02X22O12X00(), TicTacToe.Player.X, 1, 0, Result.False));
			printTest("testChooseX11", testChoose(gameX11O02X22O12X00(), TicTacToe.Player.X, 1, 1, Result.False));
			printTest("testChooseX12", testChoose(gameX11O02X22O12X00(), TicTacToe.Player.X, 1, 2, Result.False));
			printTest("testChooseX20", testChoose(gameX11O02X22O12X00(), TicTacToe.Player.X, 2, 0, Result.False));
			printTest("testChooseX21", testChoose(gameX11O02X22O12X00(), TicTacToe.Player.X, 2, 1, Result.False));
			printTest("testChooseX22", testChoose(gameX11O02X22O12X00(), TicTacToe.Player.X, 2, 2, Result.False));
			printTest("testChooseO00", testChoose(gameX11O02X22O12X00(), TicTacToe.Player.O, 0, 0, Result.False));
			printTest("testChooseO01", testChoose(gameX11O02X22O12X00(), TicTacToe.Player.O, 0, 1, Result.False));
			printTest("testChooseO02", testChoose(gameX11O02X22O12X00(), TicTacToe.Player.O, 0, 2, Result.False));
			printTest("testChooseO10", testChoose(gameX11O02X22O12X00(), TicTacToe.Player.O, 1, 0, Result.False));
			printTest("testChooseO11", testChoose(gameX11O02X22O12X00(), TicTacToe.Player.O, 1, 1, Result.False));
			printTest("testChooseO12", testChoose(gameX11O02X22O12X00(), TicTacToe.Player.O, 1, 2, Result.False));
			printTest("testChooseO20", testChoose(gameX11O02X22O12X00(), TicTacToe.Player.O, 2, 0, Result.False));
			printTest("testChooseO21", testChoose(gameX11O02X22O12X00(), TicTacToe.Player.O, 2, 1, Result.False));
			printTest("testChooseO22", testChoose(gameX11O02X22O12X00(), TicTacToe.Player.O, 2, 2, Result.False));
		} catch (Exception e) {
			System.out.printf("***UNABLE TO RUN/COMPLETE %s***\n", scenarioName + " TESTS");
			e.printStackTrace();
		} finally {
			if (printSectionSummaries) {
				printSectionSummary("Section");
			}
		}
	}
	
	//X wins - second diagonal
	private void testX20O01X11O00X02() {
		TicTacToe.Player[][] grid = {
				{TicTacToe.Player.O, TicTacToe.Player.O, TicTacToe.Player.X},
				{TicTacToe.Player.OPEN, TicTacToe.Player.X, TicTacToe.Player.OPEN},
				{TicTacToe.Player.X, TicTacToe.Player.OPEN, TicTacToe.Player.OPEN}
		};
		Point[] moves = {new Point(2,0), new Point(0,1), new Point(1,1),
				new Point(0,0), new Point(0,2)};

		String scenarioName = "testX20O01X11O00X02";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 23;
		try {
			printTest("testNewGame", testNewGame(gameX20O01X11O00X02()));
			printTest("testGameOver", testGameOver(gameX20O01X11O00X02(), Result.True));
			printTest("testWinner", testWinner(gameX20O01X11O00X02(), Result.X));
			printTest("testGetGameGrid", testGetGameGrid(gameX20O01X11O00X02(), grid));
			printTest("testGetMoves", testGetMoves(gameX20O01X11O00X02(), moves));
			printTest("testChooseX00", testChoose(gameX20O01X11O00X02(), TicTacToe.Player.X, 0, 0, Result.False));
			printTest("testChooseX01", testChoose(gameX20O01X11O00X02(), TicTacToe.Player.X, 0, 1, Result.False));
			printTest("testChooseX02", testChoose(gameX20O01X11O00X02(), TicTacToe.Player.X, 0, 2, Result.False));
			printTest("testChooseX10", testChoose(gameX20O01X11O00X02(), TicTacToe.Player.X, 1, 0, Result.False));
			printTest("testChooseX11", testChoose(gameX20O01X11O00X02(), TicTacToe.Player.X, 1, 1, Result.False));
			printTest("testChooseX12", testChoose(gameX20O01X11O00X02(), TicTacToe.Player.X, 1, 2, Result.False));
			printTest("testChooseX20", testChoose(gameX20O01X11O00X02(), TicTacToe.Player.X, 2, 0, Result.False));
			printTest("testChooseX21", testChoose(gameX20O01X11O00X02(), TicTacToe.Player.X, 2, 1, Result.False));
			printTest("testChooseX22", testChoose(gameX20O01X11O00X02(), TicTacToe.Player.X, 2, 2, Result.False));
			printTest("testChooseO00", testChoose(gameX20O01X11O00X02(), TicTacToe.Player.O, 0, 0, Result.False));
			printTest("testChooseO01", testChoose(gameX20O01X11O00X02(), TicTacToe.Player.O, 0, 1, Result.False));
			printTest("testChooseO02", testChoose(gameX20O01X11O00X02(), TicTacToe.Player.O, 0, 2, Result.False));
			printTest("testChooseO10", testChoose(gameX20O01X11O00X02(), TicTacToe.Player.O, 1, 0, Result.False));
			printTest("testChooseO11", testChoose(gameX20O01X11O00X02(), TicTacToe.Player.O, 1, 1, Result.False));
			printTest("testChooseO12", testChoose(gameX20O01X11O00X02(), TicTacToe.Player.O, 1, 2, Result.False));
			printTest("testChooseO20", testChoose(gameX20O01X11O00X02(), TicTacToe.Player.O, 2, 0, Result.False));
			printTest("testChooseO21", testChoose(gameX20O01X11O00X02(), TicTacToe.Player.O, 2, 1, Result.False));
			printTest("testChooseO22", testChoose(gameX20O01X11O00X02(), TicTacToe.Player.O, 2, 2, Result.False));
		} catch (Exception e) {
			System.out.printf("***UNABLE TO RUN/COMPLETE %s***\n", scenarioName + " TESTS");
			e.printStackTrace();
		} finally {
			if (printSectionSummaries) {
				printSectionSummary("Section");
			}
		}
	}
	
	//XXX O wins scenarios
	
	//O wins - first row
	private void testX10O01X20O02X11O00() {
		TicTacToe.Player[][] grid = {
				{TicTacToe.Player.O, TicTacToe.Player.O, TicTacToe.Player.O},
				{TicTacToe.Player.X, TicTacToe.Player.X, TicTacToe.Player.OPEN},
				{TicTacToe.Player.X, TicTacToe.Player.OPEN, TicTacToe.Player.OPEN}
		};
		Point[] moves = {new Point(1,0), new Point(0,1), new Point(2,0),
				new Point(0,2), new Point(1,1), new Point(0,0)};

		String scenarioName = "testX10O01X20O02X11O00";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 23;
		try {
			printTest("testNewGame", testNewGame(gameX10O01X20O02X11O00()));
			printTest("testGameOver", testGameOver(gameX10O01X20O02X11O00(), Result.True));
			printTest("testWinner", testWinner(gameX10O01X20O02X11O00(), Result.O));
			printTest("testGetGameGrid", testGetGameGrid(gameX10O01X20O02X11O00(), grid));
			printTest("testGetMoves", testGetMoves(gameX10O01X20O02X11O00(), moves));
			printTest("testChooseX00", testChoose(gameX10O01X20O02X11O00(), TicTacToe.Player.X, 0, 0, Result.False));
			printTest("testChooseX01", testChoose(gameX10O01X20O02X11O00(), TicTacToe.Player.X, 0, 1, Result.False));
			printTest("testChooseX02", testChoose(gameX10O01X20O02X11O00(), TicTacToe.Player.X, 0, 2, Result.False));
			printTest("testChooseX10", testChoose(gameX10O01X20O02X11O00(), TicTacToe.Player.X, 1, 0, Result.False));
			printTest("testChooseX11", testChoose(gameX10O01X20O02X11O00(), TicTacToe.Player.X, 1, 1, Result.False));
			printTest("testChooseX12", testChoose(gameX10O01X20O02X11O00(), TicTacToe.Player.X, 1, 2, Result.False));
			printTest("testChooseX20", testChoose(gameX10O01X20O02X11O00(), TicTacToe.Player.X, 2, 0, Result.False));
			printTest("testChooseX21", testChoose(gameX10O01X20O02X11O00(), TicTacToe.Player.X, 2, 1, Result.False));
			printTest("testChooseX22", testChoose(gameX10O01X20O02X11O00(), TicTacToe.Player.X, 2, 2, Result.False));
			printTest("testChooseO00", testChoose(gameX10O01X20O02X11O00(), TicTacToe.Player.O, 0, 0, Result.False));
			printTest("testChooseO01", testChoose(gameX10O01X20O02X11O00(), TicTacToe.Player.O, 0, 1, Result.False));
			printTest("testChooseO02", testChoose(gameX10O01X20O02X11O00(), TicTacToe.Player.O, 0, 2, Result.False));
			printTest("testChooseO10", testChoose(gameX10O01X20O02X11O00(), TicTacToe.Player.O, 1, 0, Result.False));
			printTest("testChooseO11", testChoose(gameX10O01X20O02X11O00(), TicTacToe.Player.O, 1, 1, Result.False));
			printTest("testChooseO12", testChoose(gameX10O01X20O02X11O00(), TicTacToe.Player.O, 1, 2, Result.False));
			printTest("testChooseO20", testChoose(gameX10O01X20O02X11O00(), TicTacToe.Player.O, 2, 0, Result.False));
			printTest("testChooseO21", testChoose(gameX10O01X20O02X11O00(), TicTacToe.Player.O, 2, 1, Result.False));
			printTest("testChooseO22", testChoose(gameX10O01X20O02X11O00(), TicTacToe.Player.O, 2, 2, Result.False));
		} catch (Exception e) {
			System.out.printf("***UNABLE TO RUN/COMPLETE %s***\n", scenarioName + " TESTS");
			e.printStackTrace();
		} finally {
			if (printSectionSummaries) {
				printSectionSummary("Section");
			}
		}
	}
	
	//O wins - second row
	private void testX00O10X20O12X01O11() {
		TicTacToe.Player[][] grid = {
				{TicTacToe.Player.X, TicTacToe.Player.X, TicTacToe.Player.OPEN},
				{TicTacToe.Player.O, TicTacToe.Player.O, TicTacToe.Player.O},
				{TicTacToe.Player.X, TicTacToe.Player.OPEN, TicTacToe.Player.OPEN}
		};
		Point[] moves = {new Point(0,0), new Point(1,0), new Point(2,0),
				new Point(1,2), new Point(0,1), new Point(1,1)};

		String scenarioName = "testX00O10X20O12X01O11";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 23;
		try {
			printTest("testNewGame", testNewGame(gameX00O10X20O12X01O11()));
			printTest("testGameOver", testGameOver(gameX00O10X20O12X01O11(), Result.True));
			printTest("testWinner", testWinner(gameX00O10X20O12X01O11(), Result.O));
			printTest("testGetGameGrid", testGetGameGrid(gameX00O10X20O12X01O11(), grid));
			printTest("testGetMoves", testGetMoves(gameX00O10X20O12X01O11(), moves));
			printTest("testChooseX00", testChoose(gameX00O10X20O12X01O11(), TicTacToe.Player.X, 0, 0, Result.False));
			printTest("testChooseX01", testChoose(gameX00O10X20O12X01O11(), TicTacToe.Player.X, 0, 1, Result.False));
			printTest("testChooseX02", testChoose(gameX00O10X20O12X01O11(), TicTacToe.Player.X, 0, 2, Result.False));
			printTest("testChooseX10", testChoose(gameX00O10X20O12X01O11(), TicTacToe.Player.X, 1, 0, Result.False));
			printTest("testChooseX11", testChoose(gameX00O10X20O12X01O11(), TicTacToe.Player.X, 1, 1, Result.False));
			printTest("testChooseX12", testChoose(gameX00O10X20O12X01O11(), TicTacToe.Player.X, 1, 2, Result.False));
			printTest("testChooseX20", testChoose(gameX00O10X20O12X01O11(), TicTacToe.Player.X, 2, 0, Result.False));
			printTest("testChooseX21", testChoose(gameX00O10X20O12X01O11(), TicTacToe.Player.X, 2, 1, Result.False));
			printTest("testChooseX22", testChoose(gameX00O10X20O12X01O11(), TicTacToe.Player.X, 2, 2, Result.False));
			printTest("testChooseO00", testChoose(gameX00O10X20O12X01O11(), TicTacToe.Player.O, 0, 0, Result.False));
			printTest("testChooseO01", testChoose(gameX00O10X20O12X01O11(), TicTacToe.Player.O, 0, 1, Result.False));
			printTest("testChooseO02", testChoose(gameX00O10X20O12X01O11(), TicTacToe.Player.O, 0, 2, Result.False));
			printTest("testChooseO10", testChoose(gameX00O10X20O12X01O11(), TicTacToe.Player.O, 1, 0, Result.False));
			printTest("testChooseO11", testChoose(gameX00O10X20O12X01O11(), TicTacToe.Player.O, 1, 1, Result.False));
			printTest("testChooseO12", testChoose(gameX00O10X20O12X01O11(), TicTacToe.Player.O, 1, 2, Result.False));
			printTest("testChooseO20", testChoose(gameX00O10X20O12X01O11(), TicTacToe.Player.O, 2, 0, Result.False));
			printTest("testChooseO21", testChoose(gameX00O10X20O12X01O11(), TicTacToe.Player.O, 2, 1, Result.False));
			printTest("testChooseO22", testChoose(gameX00O10X20O12X01O11(), TicTacToe.Player.O, 2, 2, Result.False));
		} catch (Exception e) {
			System.out.printf("***UNABLE TO RUN/COMPLETE %s***\n", scenarioName + " TESTS");
			e.printStackTrace();
		} finally {
			if (printSectionSummaries) {
				printSectionSummary("Section");
			}
		}
	}
	
	//O wins - third row
	private void testX00O21X10O20X01O22() {
		TicTacToe.Player[][] grid = {
				{TicTacToe.Player.X, TicTacToe.Player.X, TicTacToe.Player.OPEN},
				{TicTacToe.Player.X, TicTacToe.Player.OPEN, TicTacToe.Player.OPEN},
				{TicTacToe.Player.O, TicTacToe.Player.O, TicTacToe.Player.O}
		};
		Point[] moves = {new Point(0,0), new Point(2,1), new Point(1,0),
				new Point(2,0), new Point(0,1), new Point(2,2)};

		String scenarioName = "testX00O21X10O20X01O22";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 23;
		try {
			printTest("testNewGame", testNewGame(gameX00O21X10O20X01O22()));
			printTest("testGameOver", testGameOver(gameX00O21X10O20X01O22(), Result.True));
			printTest("testWinner", testWinner(gameX00O21X10O20X01O22(), Result.O));
			printTest("testGetGameGrid", testGetGameGrid(gameX00O21X10O20X01O22(), grid));
			printTest("testGetMoves", testGetMoves(gameX00O21X10O20X01O22(), moves));
			printTest("testChooseX00", testChoose(gameX00O21X10O20X01O22(), TicTacToe.Player.X, 0, 0, Result.False));
			printTest("testChooseX01", testChoose(gameX00O21X10O20X01O22(), TicTacToe.Player.X, 0, 1, Result.False));
			printTest("testChooseX02", testChoose(gameX00O21X10O20X01O22(), TicTacToe.Player.X, 0, 2, Result.False));
			printTest("testChooseX10", testChoose(gameX00O21X10O20X01O22(), TicTacToe.Player.X, 1, 0, Result.False));
			printTest("testChooseX11", testChoose(gameX00O21X10O20X01O22(), TicTacToe.Player.X, 1, 1, Result.False));
			printTest("testChooseX12", testChoose(gameX00O21X10O20X01O22(), TicTacToe.Player.X, 1, 2, Result.False));
			printTest("testChooseX20", testChoose(gameX00O21X10O20X01O22(), TicTacToe.Player.X, 2, 0, Result.False));
			printTest("testChooseX21", testChoose(gameX00O21X10O20X01O22(), TicTacToe.Player.X, 2, 1, Result.False));
			printTest("testChooseX22", testChoose(gameX00O21X10O20X01O22(), TicTacToe.Player.X, 2, 2, Result.False));
			printTest("testChooseO00", testChoose(gameX00O21X10O20X01O22(), TicTacToe.Player.O, 0, 0, Result.False));
			printTest("testChooseO01", testChoose(gameX00O21X10O20X01O22(), TicTacToe.Player.O, 0, 1, Result.False));
			printTest("testChooseO02", testChoose(gameX00O21X10O20X01O22(), TicTacToe.Player.O, 0, 2, Result.False));
			printTest("testChooseO10", testChoose(gameX00O21X10O20X01O22(), TicTacToe.Player.O, 1, 0, Result.False));
			printTest("testChooseO11", testChoose(gameX00O21X10O20X01O22(), TicTacToe.Player.O, 1, 1, Result.False));
			printTest("testChooseO12", testChoose(gameX00O21X10O20X01O22(), TicTacToe.Player.O, 1, 2, Result.False));
			printTest("testChooseO20", testChoose(gameX00O21X10O20X01O22(), TicTacToe.Player.O, 2, 0, Result.False));
			printTest("testChooseO21", testChoose(gameX00O21X10O20X01O22(), TicTacToe.Player.O, 2, 1, Result.False));
			printTest("testChooseO22", testChoose(gameX00O21X10O20X01O22(), TicTacToe.Player.O, 2, 2, Result.False));
		} catch (Exception e) {
			System.out.printf("***UNABLE TO RUN/COMPLETE %s***\n", scenarioName + " TESTS");
			e.printStackTrace();
		} finally {
			if (printSectionSummaries) {
				printSectionSummary("Section");
			}
		}
	}
	
	//O wins - first col
	private void testX22O10X11O00X01O20() {
		TicTacToe.Player[][] grid = {
				{TicTacToe.Player.O, TicTacToe.Player.X, TicTacToe.Player.OPEN},
				{TicTacToe.Player.O, TicTacToe.Player.X, TicTacToe.Player.OPEN},
				{TicTacToe.Player.O, TicTacToe.Player.OPEN, TicTacToe.Player.X}
		};
		Point[] moves = {new Point(2,2), new Point(1,0), new Point(1,1),
				new Point(0,0), new Point(0,1), new Point(2,0)};

		String scenarioName = "testX22O10X11O00X01O20";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 23;
		try {
			printTest("testNewGame", testNewGame(gameX22O10X11O00X01O20()));
			printTest("testGameOver", testGameOver(gameX22O10X11O00X01O20(), Result.True));
			printTest("testWinner", testWinner(gameX22O10X11O00X01O20(), Result.O));
			printTest("testGetGameGrid", testGetGameGrid(gameX22O10X11O00X01O20(), grid));
			printTest("testGetMoves", testGetMoves(gameX22O10X11O00X01O20(), moves));
			printTest("testChooseX00", testChoose(gameX22O10X11O00X01O20(), TicTacToe.Player.X, 0, 0, Result.False));
			printTest("testChooseX01", testChoose(gameX22O10X11O00X01O20(), TicTacToe.Player.X, 0, 1, Result.False));
			printTest("testChooseX02", testChoose(gameX22O10X11O00X01O20(), TicTacToe.Player.X, 0, 2, Result.False));
			printTest("testChooseX10", testChoose(gameX22O10X11O00X01O20(), TicTacToe.Player.X, 1, 0, Result.False));
			printTest("testChooseX11", testChoose(gameX22O10X11O00X01O20(), TicTacToe.Player.X, 1, 1, Result.False));
			printTest("testChooseX12", testChoose(gameX22O10X11O00X01O20(), TicTacToe.Player.X, 1, 2, Result.False));
			printTest("testChooseX20", testChoose(gameX22O10X11O00X01O20(), TicTacToe.Player.X, 2, 0, Result.False));
			printTest("testChooseX21", testChoose(gameX22O10X11O00X01O20(), TicTacToe.Player.X, 2, 1, Result.False));
			printTest("testChooseX22", testChoose(gameX22O10X11O00X01O20(), TicTacToe.Player.X, 2, 2, Result.False));
			printTest("testChooseO00", testChoose(gameX22O10X11O00X01O20(), TicTacToe.Player.O, 0, 0, Result.False));
			printTest("testChooseO01", testChoose(gameX22O10X11O00X01O20(), TicTacToe.Player.O, 0, 1, Result.False));
			printTest("testChooseO02", testChoose(gameX22O10X11O00X01O20(), TicTacToe.Player.O, 0, 2, Result.False));
			printTest("testChooseO10", testChoose(gameX22O10X11O00X01O20(), TicTacToe.Player.O, 1, 0, Result.False));
			printTest("testChooseO11", testChoose(gameX22O10X11O00X01O20(), TicTacToe.Player.O, 1, 1, Result.False));
			printTest("testChooseO12", testChoose(gameX22O10X11O00X01O20(), TicTacToe.Player.O, 1, 2, Result.False));
			printTest("testChooseO20", testChoose(gameX22O10X11O00X01O20(), TicTacToe.Player.O, 2, 0, Result.False));
			printTest("testChooseO21", testChoose(gameX22O10X11O00X01O20(), TicTacToe.Player.O, 2, 1, Result.False));
			printTest("testChooseO22", testChoose(gameX22O10X11O00X01O20(), TicTacToe.Player.O, 2, 2, Result.False));
		} catch (Exception e) {
			System.out.printf("***UNABLE TO RUN/COMPLETE %s***\n", scenarioName + " TESTS");
			e.printStackTrace();
		} finally {
			if (printSectionSummaries) {
				printSectionSummary("Section");
			}
		}
	}
	
	//O wins - second col
	private void testX00O01X22O11X10O21() {
		TicTacToe.Player[][] grid = {
				{TicTacToe.Player.X, TicTacToe.Player.O, TicTacToe.Player.OPEN},
				{TicTacToe.Player.X, TicTacToe.Player.O, TicTacToe.Player.OPEN},
				{TicTacToe.Player.OPEN, TicTacToe.Player.O, TicTacToe.Player.X}
		};
		Point[] moves = {new Point(0,0), new Point(0,1), new Point(2,2),
				new Point(1,1), new Point(1,0), new Point(2,1)};

		String scenarioName = "testX00O01X22O11X10O21";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 23;
		try {
			printTest("testNewGame", testNewGame(gameX00O01X22O11X10O21()));
			printTest("testGameOver", testGameOver(gameX00O01X22O11X10O21(), Result.True));
			printTest("testWinner", testWinner(gameX00O01X22O11X10O21(), Result.O));
			printTest("testGetGameGrid", testGetGameGrid(gameX00O01X22O11X10O21(), grid));
			printTest("testGetMoves", testGetMoves(gameX00O01X22O11X10O21(), moves));
			printTest("testChooseX00", testChoose(gameX00O01X22O11X10O21(), TicTacToe.Player.X, 0, 0, Result.False));
			printTest("testChooseX01", testChoose(gameX00O01X22O11X10O21(), TicTacToe.Player.X, 0, 1, Result.False));
			printTest("testChooseX02", testChoose(gameX00O01X22O11X10O21(), TicTacToe.Player.X, 0, 2, Result.False));
			printTest("testChooseX10", testChoose(gameX00O01X22O11X10O21(), TicTacToe.Player.X, 1, 0, Result.False));
			printTest("testChooseX11", testChoose(gameX00O01X22O11X10O21(), TicTacToe.Player.X, 1, 1, Result.False));
			printTest("testChooseX12", testChoose(gameX00O01X22O11X10O21(), TicTacToe.Player.X, 1, 2, Result.False));
			printTest("testChooseX20", testChoose(gameX00O01X22O11X10O21(), TicTacToe.Player.X, 2, 0, Result.False));
			printTest("testChooseX21", testChoose(gameX00O01X22O11X10O21(), TicTacToe.Player.X, 2, 1, Result.False));
			printTest("testChooseX22", testChoose(gameX00O01X22O11X10O21(), TicTacToe.Player.X, 2, 2, Result.False));
			printTest("testChooseO00", testChoose(gameX00O01X22O11X10O21(), TicTacToe.Player.O, 0, 0, Result.False));
			printTest("testChooseO01", testChoose(gameX00O01X22O11X10O21(), TicTacToe.Player.O, 0, 1, Result.False));
			printTest("testChooseO02", testChoose(gameX00O01X22O11X10O21(), TicTacToe.Player.O, 0, 2, Result.False));
			printTest("testChooseO10", testChoose(gameX00O01X22O11X10O21(), TicTacToe.Player.O, 1, 0, Result.False));
			printTest("testChooseO11", testChoose(gameX00O01X22O11X10O21(), TicTacToe.Player.O, 1, 1, Result.False));
			printTest("testChooseO12", testChoose(gameX00O01X22O11X10O21(), TicTacToe.Player.O, 1, 2, Result.False));
			printTest("testChooseO20", testChoose(gameX00O01X22O11X10O21(), TicTacToe.Player.O, 2, 0, Result.False));
			printTest("testChooseO21", testChoose(gameX00O01X22O11X10O21(), TicTacToe.Player.O, 2, 1, Result.False));
			printTest("testChooseO22", testChoose(gameX00O01X22O11X10O21(), TicTacToe.Player.O, 2, 2, Result.False));
		} catch (Exception e) {
			System.out.printf("***UNABLE TO RUN/COMPLETE %s***\n", scenarioName + " TESTS");
			e.printStackTrace();
		} finally {
			if (printSectionSummaries) {
				printSectionSummary("Section");
			}
		}
	}
	
	//O wins - third col
	private void testX11O02X00O22X10O12() {
		TicTacToe.Player[][] grid = {
				{TicTacToe.Player.X, TicTacToe.Player.OPEN, TicTacToe.Player.O},
				{TicTacToe.Player.X, TicTacToe.Player.X, TicTacToe.Player.O},
				{TicTacToe.Player.OPEN, TicTacToe.Player.OPEN, TicTacToe.Player.O}
		};
		Point[] moves = {new Point(1,1), new Point(0,2), new Point(0,0),
				new Point(2,2), new Point(1,0), new Point(1,2)};

		String scenarioName = "testX11O02X00O22X10O12";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 23;
		try {
			printTest("testNewGame", testNewGame(gameX11O02X00O22X10O12()));
			printTest("testGameOver", testGameOver(gameX11O02X00O22X10O12(), Result.True));
			printTest("testWinner", testWinner(gameX11O02X00O22X10O12(), Result.O));
			printTest("testGetGameGrid", testGetGameGrid(gameX11O02X00O22X10O12(), grid));
			printTest("testGetMoves", testGetMoves(gameX11O02X00O22X10O12(), moves));
			printTest("testChooseX00", testChoose(gameX11O02X00O22X10O12(), TicTacToe.Player.X, 0, 0, Result.False));
			printTest("testChooseX01", testChoose(gameX11O02X00O22X10O12(), TicTacToe.Player.X, 0, 1, Result.False));
			printTest("testChooseX02", testChoose(gameX11O02X00O22X10O12(), TicTacToe.Player.X, 0, 2, Result.False));
			printTest("testChooseX10", testChoose(gameX11O02X00O22X10O12(), TicTacToe.Player.X, 1, 0, Result.False));
			printTest("testChooseX11", testChoose(gameX11O02X00O22X10O12(), TicTacToe.Player.X, 1, 1, Result.False));
			printTest("testChooseX12", testChoose(gameX11O02X00O22X10O12(), TicTacToe.Player.X, 1, 2, Result.False));
			printTest("testChooseX20", testChoose(gameX11O02X00O22X10O12(), TicTacToe.Player.X, 2, 0, Result.False));
			printTest("testChooseX21", testChoose(gameX11O02X00O22X10O12(), TicTacToe.Player.X, 2, 1, Result.False));
			printTest("testChooseX22", testChoose(gameX11O02X00O22X10O12(), TicTacToe.Player.X, 2, 2, Result.False));
			printTest("testChooseO00", testChoose(gameX11O02X00O22X10O12(), TicTacToe.Player.O, 0, 0, Result.False));
			printTest("testChooseO01", testChoose(gameX11O02X00O22X10O12(), TicTacToe.Player.O, 0, 1, Result.False));
			printTest("testChooseO02", testChoose(gameX11O02X00O22X10O12(), TicTacToe.Player.O, 0, 2, Result.False));
			printTest("testChooseO10", testChoose(gameX11O02X00O22X10O12(), TicTacToe.Player.O, 1, 0, Result.False));
			printTest("testChooseO11", testChoose(gameX11O02X00O22X10O12(), TicTacToe.Player.O, 1, 1, Result.False));
			printTest("testChooseO12", testChoose(gameX11O02X00O22X10O12(), TicTacToe.Player.O, 1, 2, Result.False));
			printTest("testChooseO20", testChoose(gameX11O02X00O22X10O12(), TicTacToe.Player.O, 2, 0, Result.False));
			printTest("testChooseO21", testChoose(gameX11O02X00O22X10O12(), TicTacToe.Player.O, 2, 1, Result.False));
			printTest("testChooseO22", testChoose(gameX11O02X00O22X10O12(), TicTacToe.Player.O, 2, 2, Result.False));
		} catch (Exception e) {
			System.out.printf("***UNABLE TO RUN/COMPLETE %s***\n", scenarioName + " TESTS");
			e.printStackTrace();
		} finally {
			if (printSectionSummaries) {
				printSectionSummary("Section");
			}
		}
	}
	
	//O wins - first diagonal
	private void testX01O00X10O11X21O22() {
		TicTacToe.Player[][] grid = {
				{TicTacToe.Player.O, TicTacToe.Player.X, TicTacToe.Player.OPEN},
				{TicTacToe.Player.X, TicTacToe.Player.O, TicTacToe.Player.OPEN},
				{TicTacToe.Player.OPEN, TicTacToe.Player.X, TicTacToe.Player.O}
		};
		Point[] moves = {new Point(0,1), new Point(0,0), new Point(1,0),
				new Point(1,1), new Point(2,1), new Point(2,2)};

		String scenarioName = "testX01O00X10O11X21O22";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 23;
		try {
			printTest("testNewGame", testNewGame(gameX01O00X10O11X21O22()));
			printTest("testGameOver", testGameOver(gameX01O00X10O11X21O22(), Result.True));
			printTest("testWinner", testWinner(gameX01O00X10O11X21O22(), Result.O));
			printTest("testGetGameGrid", testGetGameGrid(gameX01O00X10O11X21O22(), grid));
			printTest("testGetMoves", testGetMoves(gameX01O00X10O11X21O22(), moves));
			printTest("testChooseX00", testChoose(gameX01O00X10O11X21O22(), TicTacToe.Player.X, 0, 0, Result.False));
			printTest("testChooseX01", testChoose(gameX01O00X10O11X21O22(), TicTacToe.Player.X, 0, 1, Result.False));
			printTest("testChooseX02", testChoose(gameX01O00X10O11X21O22(), TicTacToe.Player.X, 0, 2, Result.False));
			printTest("testChooseX10", testChoose(gameX01O00X10O11X21O22(), TicTacToe.Player.X, 1, 0, Result.False));
			printTest("testChooseX11", testChoose(gameX01O00X10O11X21O22(), TicTacToe.Player.X, 1, 1, Result.False));
			printTest("testChooseX12", testChoose(gameX01O00X10O11X21O22(), TicTacToe.Player.X, 1, 2, Result.False));
			printTest("testChooseX20", testChoose(gameX01O00X10O11X21O22(), TicTacToe.Player.X, 2, 0, Result.False));
			printTest("testChooseX21", testChoose(gameX01O00X10O11X21O22(), TicTacToe.Player.X, 2, 1, Result.False));
			printTest("testChooseX22", testChoose(gameX01O00X10O11X21O22(), TicTacToe.Player.X, 2, 2, Result.False));
			printTest("testChooseO00", testChoose(gameX01O00X10O11X21O22(), TicTacToe.Player.O, 0, 0, Result.False));
			printTest("testChooseO01", testChoose(gameX01O00X10O11X21O22(), TicTacToe.Player.O, 0, 1, Result.False));
			printTest("testChooseO02", testChoose(gameX01O00X10O11X21O22(), TicTacToe.Player.O, 0, 2, Result.False));
			printTest("testChooseO10", testChoose(gameX01O00X10O11X21O22(), TicTacToe.Player.O, 1, 0, Result.False));
			printTest("testChooseO11", testChoose(gameX01O00X10O11X21O22(), TicTacToe.Player.O, 1, 1, Result.False));
			printTest("testChooseO12", testChoose(gameX01O00X10O11X21O22(), TicTacToe.Player.O, 1, 2, Result.False));
			printTest("testChooseO20", testChoose(gameX01O00X10O11X21O22(), TicTacToe.Player.O, 2, 0, Result.False));
			printTest("testChooseO21", testChoose(gameX01O00X10O11X21O22(), TicTacToe.Player.O, 2, 1, Result.False));
			printTest("testChooseO22", testChoose(gameX01O00X10O11X21O22(), TicTacToe.Player.O, 2, 2, Result.False));
		} catch (Exception e) {
			System.out.printf("***UNABLE TO RUN/COMPLETE %s***\n", scenarioName + " TESTS");
			e.printStackTrace();
		} finally {
			if (printSectionSummaries) {
				printSectionSummary("Section");
			}
		}
	}
	
	//O wins - second diagonal
	private void testX00O11X10O20X21O02() {
		TicTacToe.Player[][] grid = {
				{TicTacToe.Player.X, TicTacToe.Player.OPEN, TicTacToe.Player.O},
				{TicTacToe.Player.X, TicTacToe.Player.O, TicTacToe.Player.OPEN},
				{TicTacToe.Player.O, TicTacToe.Player.X, TicTacToe.Player.OPEN}
		};
		Point[] moves = {new Point(0,0), new Point(1,1), new Point(1,0),
				new Point(2,0), new Point(2,1), new Point(0,2)};

		String scenarioName = "testX00O11X10O20X21O02";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 23;
		try {
			printTest("testNewGame", testNewGame(gameX00O11X10O20X21O02()));
			printTest("testGameOver", testGameOver(gameX00O11X10O20X21O02(), Result.True));
			printTest("testWinner", testWinner(gameX00O11X10O20X21O02(), Result.O));
			printTest("testGetGameGrid", testGetGameGrid(gameX00O11X10O20X21O02(), grid));
			printTest("testGetMoves", testGetMoves(gameX00O11X10O20X21O02(), moves));
			printTest("testChooseX00", testChoose(gameX00O11X10O20X21O02(), TicTacToe.Player.X, 0, 0, Result.False));
			printTest("testChooseX01", testChoose(gameX00O11X10O20X21O02(), TicTacToe.Player.X, 0, 1, Result.False));
			printTest("testChooseX02", testChoose(gameX00O11X10O20X21O02(), TicTacToe.Player.X, 0, 2, Result.False));
			printTest("testChooseX10", testChoose(gameX00O11X10O20X21O02(), TicTacToe.Player.X, 1, 0, Result.False));
			printTest("testChooseX11", testChoose(gameX00O11X10O20X21O02(), TicTacToe.Player.X, 1, 1, Result.False));
			printTest("testChooseX12", testChoose(gameX00O11X10O20X21O02(), TicTacToe.Player.X, 1, 2, Result.False));
			printTest("testChooseX20", testChoose(gameX00O11X10O20X21O02(), TicTacToe.Player.X, 2, 0, Result.False));
			printTest("testChooseX21", testChoose(gameX00O11X10O20X21O02(), TicTacToe.Player.X, 2, 1, Result.False));
			printTest("testChooseX22", testChoose(gameX00O11X10O20X21O02(), TicTacToe.Player.X, 2, 2, Result.False));
			printTest("testChooseO00", testChoose(gameX00O11X10O20X21O02(), TicTacToe.Player.O, 0, 0, Result.False));
			printTest("testChooseO01", testChoose(gameX00O11X10O20X21O02(), TicTacToe.Player.O, 0, 1, Result.False));
			printTest("testChooseO02", testChoose(gameX00O11X10O20X21O02(), TicTacToe.Player.O, 0, 2, Result.False));
			printTest("testChooseO10", testChoose(gameX00O11X10O20X21O02(), TicTacToe.Player.O, 1, 0, Result.False));
			printTest("testChooseO11", testChoose(gameX00O11X10O20X21O02(), TicTacToe.Player.O, 1, 1, Result.False));
			printTest("testChooseO12", testChoose(gameX00O11X10O20X21O02(), TicTacToe.Player.O, 1, 2, Result.False));
			printTest("testChooseO20", testChoose(gameX00O11X10O20X21O02(), TicTacToe.Player.O, 2, 0, Result.False));
			printTest("testChooseO21", testChoose(gameX00O11X10O20X21O02(), TicTacToe.Player.O, 2, 1, Result.False));
			printTest("testChooseO22", testChoose(gameX00O11X10O20X21O02(), TicTacToe.Player.O, 2, 2, Result.False));
		} catch (Exception e) {
			System.out.printf("***UNABLE TO RUN/COMPLETE %s***\n", scenarioName + " TESTS");
			e.printStackTrace();
		} finally {
			if (printSectionSummaries) {
				printSectionSummary("Section");
			}
		}
	}
	
	//////////////////////////
	// XXX Game Builders
	//////////////////////////

	/** Returns a new instance of the TicTacToe implementation to be tested.
	 * @return a new TicTacToe
	 */
	private TicTacToe newGame() {
		return (TicTacToe)(new TicTacToeGame());
	}

	/**
	 * @return
	 * X--
	 * ---
	 * ---
	 */
	private TicTacToe gameX00() {
		TicTacToe game = newGame();
		game.choose(TicTacToe.Player.X, 0, 0);
		return game;
	}

	/**
	 * @return
	 * X--
	 * O--
	 * ---
	 */
	private TicTacToe gameX00O10() {
		TicTacToe game = gameX00();
		game.choose(TicTacToe.Player.O, 1, 0);
		return game;
	}

	/**
	 * @return
	 * X--
	 * OX-
	 * ---
	 */
	private TicTacToe gameX00O10X11() {
		TicTacToe game = gameX00O10();
		game.choose(TicTacToe.Player.X, 1, 1);
		return game;
	}

	/**
	 * @return
	 * X--
	 * OX-
	 * --O
	 */
	private TicTacToe gameX00O10X11O22() {
		TicTacToe game = gameX00O10X11();
		game.choose(TicTacToe.Player.O, 2, 2);
		return game;
	}

	/**
	 * @return
	 * X-X
	 * OX-
	 * --O
	 */
	private TicTacToe gameX00O10X11O22X02() {
		TicTacToe game = gameX00O10X11O22();
		game.choose(TicTacToe.Player.X, 0, 2);
		return game;
	}

	/**
	 * @return
	 * XOX
	 * OX-
	 * --O
	 */
	private TicTacToe gameX00O10X11O22X02O01() {
		TicTacToe game = gameX00O10X11O22X02();
		game.choose(TicTacToe.Player.O, 0, 1);
		return game;
	}

	/**
	 * @return
	 * XOX
	 * OX-
	 * -XO
	 */
	private TicTacToe gameX00O10X11O22X02O01X21() {
		TicTacToe game = gameX00O10X11O22X02O01();
		game.choose(TicTacToe.Player.X, 2, 1);
		return game;
	}

	/**
	 * @return
	 * XOX
	 * OX-
	 * OXO
	 */
	private TicTacToe gameX00O10X11O22X02O01X21O20() {
		TicTacToe game = gameX00O10X11O22X02O01X21();
		game.choose(TicTacToe.Player.O, 2, 0);
		return game;
	}

	// XXX Tie game
	
	/**
	 * @return
	 * XOX
	 * OXX
	 * OXO
	 */
	private TicTacToe gameX00O10X11O22X02O01X21O20X12() {
		TicTacToe game = gameX00O10X11O22X02O01X21O20();
		game.choose(TicTacToe.Player.X, 1, 2);
		return game;
	}

	// XXX X wins
	
	/**
	 * @return
	 * X X X
	 * O - -
	 * - - O
	 */
	private TicTacToe gameX02O10X00O22X01() {
		TicTacToe game = newGame();
		game.choose(TicTacToe.Player.X, 0, 2);
		game.choose(TicTacToe.Player.O, 1, 0);
		game.choose(TicTacToe.Player.X, 0, 0);
		game.choose(TicTacToe.Player.O, 2, 2);
		game.choose(TicTacToe.Player.X, 0, 1);
		return game;
	}
	
	/**
	 * @return
	 * O - -
	 * X X X
	 * - - O
	 */
	private TicTacToe gameX11O00X10O22X12() {
		TicTacToe game = newGame();
		game.choose(TicTacToe.Player.X, 1, 1);
		game.choose(TicTacToe.Player.O, 0, 0);
		game.choose(TicTacToe.Player.X, 1, 0);
		game.choose(TicTacToe.Player.O, 2, 2);
		game.choose(TicTacToe.Player.X, 1, 2);
		return game;
	}
	
	/**
	 * @return
	 * O - -
	 * - - O
	 * X X X
	 */
	private TicTacToe gameX22O00X20O12X21() {
		TicTacToe game = newGame();
		game.choose(TicTacToe.Player.X, 2, 2);
		game.choose(TicTacToe.Player.O, 0, 0);
		game.choose(TicTacToe.Player.X, 2, 0);
		game.choose(TicTacToe.Player.O, 1, 2);
		game.choose(TicTacToe.Player.X, 2, 1);
		return game;
	}
	
	/**
	 * @return
	 * X--
	 * XOO
	 * X--
	 */
	private TicTacToe gameX00O11X20O12X10() {
		TicTacToe game = newGame();
		game.choose(TicTacToe.Player.X, 0, 0);
		game.choose(TicTacToe.Player.O, 1, 1);
		game.choose(TicTacToe.Player.X, 2, 0);
		game.choose(TicTacToe.Player.O, 1, 2);
		game.choose(TicTacToe.Player.X, 1, 0);
		return game;
	}
	
	/**
	 * @return
	 * -X-
	 * OXO
	 * -X-
	 */
	private TicTacToe gameX01O10X21O12X11() {
		TicTacToe game = newGame();
		game.choose(TicTacToe.Player.X, 0, 1);
		game.choose(TicTacToe.Player.O, 1, 0);
		game.choose(TicTacToe.Player.X, 2, 1);
		game.choose(TicTacToe.Player.O, 1, 2);
		game.choose(TicTacToe.Player.X, 1, 1);
		return game;
	}
	
	/**
	 * @return
	 * --X
	 * -OX
	 * -OX
	 */
	private TicTacToe gameX12O11X02O21X22() {
		TicTacToe game = newGame();
		game.choose(TicTacToe.Player.X, 1, 2);
		game.choose(TicTacToe.Player.O, 1, 1);
		game.choose(TicTacToe.Player.X, 0, 2);
		game.choose(TicTacToe.Player.O, 2, 1);
		game.choose(TicTacToe.Player.X, 2, 2);
		return game;
	}
	
	/**
	 * @return
	 * X-O
	 * -XO
	 * --X
	 */
	private TicTacToe gameX11O02X22O12X00() {
		TicTacToe game = newGame();
		game.choose(TicTacToe.Player.X, 1, 1);
		game.choose(TicTacToe.Player.O, 0, 2);
		game.choose(TicTacToe.Player.X, 2, 2);
		game.choose(TicTacToe.Player.O, 1, 2);
		game.choose(TicTacToe.Player.X, 0, 0);
		return game;
	}
	
	/**
	 * @return
	 * OOX
	 * -X-
	 * X--
	 */
	private TicTacToe gameX20O01X11O00X02() {
		TicTacToe game = newGame();
		game.choose(TicTacToe.Player.X, 2, 0);
		game.choose(TicTacToe.Player.O, 0, 1);
		game.choose(TicTacToe.Player.X, 1, 1);
		game.choose(TicTacToe.Player.O, 0, 0);
		game.choose(TicTacToe.Player.X, 0, 2);
		return game;
	}
	
	// XXX O wins
	
	/**
	 * @return
	 * OOO
	 * XX-
	 * X--
	 */
	private TicTacToe gameX10O01X20O02X11O00() {
		TicTacToe game = newGame();
		game.choose(TicTacToe.Player.X, 1, 0);
		game.choose(TicTacToe.Player.O, 0, 1);
		game.choose(TicTacToe.Player.X, 2, 0);
		game.choose(TicTacToe.Player.O, 0, 2);
		game.choose(TicTacToe.Player.X, 1, 1);
		game.choose(TicTacToe.Player.O, 0, 0);
		return game;
	}
	
	/**
	 * @return
	 * XX-
	 * OOO
	 * X--
	 */
	private TicTacToe gameX00O10X20O12X01O11() {
		TicTacToe game = newGame();
		game.choose(TicTacToe.Player.X, 0, 0);
		game.choose(TicTacToe.Player.O, 1, 0);
		game.choose(TicTacToe.Player.X, 2, 0);
		game.choose(TicTacToe.Player.O, 1, 2);
		game.choose(TicTacToe.Player.X, 0, 1);
		game.choose(TicTacToe.Player.O, 1, 1);
		return game;
	}
	
	/**
	 * @return
	 * XX-
	 * X--
	 * OOO
	 */
	private TicTacToe gameX00O21X10O20X01O22() {
		TicTacToe game = newGame();
		game.choose(TicTacToe.Player.X, 0, 0);
		game.choose(TicTacToe.Player.O, 2, 1);
		game.choose(TicTacToe.Player.X, 1, 0);
		game.choose(TicTacToe.Player.O, 2, 0);
		game.choose(TicTacToe.Player.X, 0, 1);
		game.choose(TicTacToe.Player.O, 2, 2);
		return game;
	}
	
	/**
	 * @return
	 * OX-
	 * OX-
	 * O-X
	 */
	private TicTacToe gameX22O10X11O00X01O20() {
		TicTacToe game = newGame();
		game.choose(TicTacToe.Player.X, 2, 2);
		game.choose(TicTacToe.Player.O, 1, 0);
		game.choose(TicTacToe.Player.X, 1, 1);
		game.choose(TicTacToe.Player.O, 0, 0);
		game.choose(TicTacToe.Player.X, 0, 1);
		game.choose(TicTacToe.Player.O, 2, 0);
		return game;
	}
	
	/**
	 * @return
	 * XO-
	 * XO-
	 * -OX
	 */
	private TicTacToe gameX00O01X22O11X10O21() {
		TicTacToe game = newGame();
		game.choose(TicTacToe.Player.X, 0, 0);
		game.choose(TicTacToe.Player.O, 0, 1);
		game.choose(TicTacToe.Player.X, 2, 2);
		game.choose(TicTacToe.Player.O, 1, 1);
		game.choose(TicTacToe.Player.X, 1, 0);
		game.choose(TicTacToe.Player.O, 2, 1);
		return game;
	}
	
	/**
	 * @return
	 * X-O
	 * XXO
	 * --O
	 */
	private TicTacToe gameX11O02X00O22X10O12() {
		TicTacToe game = newGame();
		game.choose(TicTacToe.Player.X, 1, 1);
		game.choose(TicTacToe.Player.O, 0, 2);
		game.choose(TicTacToe.Player.X, 0, 0);
		game.choose(TicTacToe.Player.O, 2, 2);
		game.choose(TicTacToe.Player.X, 1, 0);
		game.choose(TicTacToe.Player.O, 1, 2);
		return game;
	}
	
	/**
	 * @return
	 * OX-
	 * XO-
	 * -XO
	 */
	private TicTacToe gameX01O00X10O11X21O22() {
		TicTacToe game = newGame();
		game.choose(TicTacToe.Player.X, 0, 1);
		game.choose(TicTacToe.Player.O, 0, 0);
		game.choose(TicTacToe.Player.X, 1, 0);
		game.choose(TicTacToe.Player.O, 1, 1);
		game.choose(TicTacToe.Player.X, 2, 1);
		game.choose(TicTacToe.Player.O, 2, 2);
		return game;
	}
	
	/**
	 * @return
	 * X-O
	 * XO-
	 * OX-
	 */
	private TicTacToe gameX00O11X10O20X21O02() {
		TicTacToe game = newGame();
		game.choose(TicTacToe.Player.X, 0, 0);
		game.choose(TicTacToe.Player.O, 1, 1);
		game.choose(TicTacToe.Player.X, 1, 0);
		game.choose(TicTacToe.Player.O, 2, 0);
		game.choose(TicTacToe.Player.X, 2, 1);
		game.choose(TicTacToe.Player.O, 0, 2);
		return game;
	}
		
	// //////////////////////////
	// XXX TEST METHODS
	// //////////////////////////

	/**
	 * Runs newGame() method of a TicTacToe. No exceptions expected.
	 * @return test success
	 */
	private boolean testNewGame(TicTacToe game) {
		boolean success = true;
		try {
			game.newGame();
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testNewGame", e.toString());
			e.printStackTrace();
			success = false;
		}
		return success;
	}

	/**
	 * Runs gameOver() method on a newly created TicTacToe.
	 * @return test success
	 */
	private boolean testGameOver(TicTacToe game, Result expectedResult) {
		Result result;
		try {
			if (game.gameOver()) {
				result = Result.True;
			} else {
				result = Result.False;
			}
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testGameOver", e.toString());
			e.printStackTrace();
			result = Result.UnexpectedException;
		}
		return result == expectedResult;
	}

	/**
	 * Runs winner() method on a TicTacToe.
	 * @return test success
	 */
	private boolean testWinner(TicTacToe game, Result expectedResult) {
		Result result;
		try {
			if (game.winner() == TicTacToe.Winner.IN_PROGRESS) {
				result = Result.InProgress;
			} else if (game.winner() == TicTacToe.Winner.TIE) {
				result = Result.Tie;
			} else if (game.winner() == TicTacToe.Winner.X) {
				result = Result.X;
			} else if (game.winner() == TicTacToe.Winner.O) {
				result = Result.O;
			} else {
				result = Result.Fail;
			}
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testWinner", e.toString());
			e.printStackTrace();
			result = Result.UnexpectedException;
		}
		return result == expectedResult;
	}

	/**
	 * Runs getGameGrid() method on a TicTacToe.
	 * @return test success
	 */
	private boolean testGetGameGrid(TicTacToe game, TicTacToe.Player[][] expectedGrid) {
		Result result;
		try {
			TicTacToe.Player[][] returnedGrid = game.getGameGrid();
			if (equivalentArrays(returnedGrid, expectedGrid)) {
				result = Result.Pass;
			} else {
				result = Result.Fail;
			}
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testGetGameGrid", e.toString());
			e.printStackTrace();
			result = Result.UnexpectedException;
		}
		return result == Result.Pass;
	}

	/**
	 * Runs getMoves() method on a TicTacToe.
	 * @return test success
	 */
	private boolean testGetMoves(TicTacToe game, Point[] expectedMoves) {
		Result result;
		try {
			Point[] returnedMoves = game.getMoves();
			if (equivalentArrays(returnedMoves, expectedMoves)) {
				result = Result.Pass;
			} else {
				result = Result.Fail;
			}
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testGetMoves", e.toString());
			e.printStackTrace();
			result = Result.UnexpectedException;
		}
		return result == Result.Pass;
	}

	/**
	 * Runs choose() method on a TicTacToe.
	 * @return test success
	 */
	private boolean testChoose(TicTacToe game, TicTacToe.Player player, int row, int col, Result expectedResult) {
		Result result;
		try {
			if (game.choose(player, row, col)) {
				result = Result.True;
			} else {
				result = Result.False;
			}
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testChoose", e.toString());
			e.printStackTrace();
			result = Result.UnexpectedException;
		}
		return result == expectedResult;
	}

	//////////////////////////
	// XXX HELPER METHODS
	//////////////////////////

	/** Compare two two-dimensional double arrays for equivalence.
	 * @param a1 first Player[][]
	 * @param a2 second Player[][]
	 * @return true if all values in a1 and a2 are the same, else false
	 */
	private boolean equivalentArrays(TicTacToe.Player[][] a1, TicTacToe.Player[][] a2) {
		boolean equivalent = true;
		if (a1.length != a2.length || (a1.length > 1 && a1[0].length != a2[0].length)) {
			equivalent = false;
		} else {
			for (int row = 0; row < a1.length; row++) {
				for (int col = 0; col < a1[0].length; col++) {
					if (row >= a2.length || a1[row].length != a2[row].length) {
						equivalent = false;
					} else {
						if (a1[row][col] != a2[row][col]) {
							equivalent = false;
						}
					}
				}
			}
		}
		return equivalent;
	}

	/** Compare two one-dimensional Point arrays for equivalence.
	 * @param a1 first Point[]
	 * @param a2 second Point[]
	 * @return true if all values in a1 and a2 are the same, else false
	 */
	private boolean equivalentArrays(Point[] a1, Point[] a2) {
		boolean equivalent = true;
		if (a1.length != a2.length) {
			equivalent = false;
		} else {
			for (int row = 0; row < a1.length; row++) {
				if (!a1[row].equals(a2[row])) {
					equivalent = false;
				}
			}
		}
		return equivalent;
	}

}// end class TicTacToeTester
