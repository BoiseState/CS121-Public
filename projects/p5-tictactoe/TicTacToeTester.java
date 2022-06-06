import java.awt.Point;

/**
 * A unit tester for classes that implement TicTacToe.  
 * 
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
	 *  -m : hide section summaries in output
	 * @param args not used
	 */
	public static void main(String[] args) {
		// to avoid every method being static
		TicTacToeTester tester = new TicTacToeTester(args);
		tester.runTests();
		
		/* Set a non-zero exit status if failures occurred during testing */
		if ( tester.getFailures() != 0 ) {
			System.exit(1);
		}
		
		System.exit(0);
	}

	/** tester constructor
	 * @param args command line args
	 */
	public TicTacToeTester(String[] args) {
		for (String arg : args) {
			if (arg.equalsIgnoreCase("-a")) printFailuresOnly = false;
			if (arg.equalsIgnoreCase("-m"))	printSectionSummaries = false;
		}
		EXPECTED_TOTAL_TESTS = 219;
		totalTests = 0;
	}

	/** Accessor method to check if failures
	 * occurred during testing.
	 * @return The total number of failures
	 */
	public int getFailures() {
		return this.failures;
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
		//last move (9th move) is a winning move
		testX01O12X00O02X10O20X11O21X22(); //X wins
		testO01X12O00X02O10X20O11X21O22(); //O wins
		//reset game
		testX00O10X11NewGame(); //new game after partial game
		testX01O12X00O02X10O20X11O21X22NewGame(); //new game after X win
		testO01X12O00X02O10X20O11X21O22NewGame(); //new game after O win
		//encapsulation tests
		testEncapsulation();

		// report final verdict
		printFinalSummary();
	}
	
	////////////////////////
	//XXX Scenario Tests
	////////////////////////
	
	private void testNewGame() {
		TicTacToe.BoardChoice[][] grid = {
				{TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN},
				{TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN},
				{TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN}
		};
		Point[] newGameMoves = new Point[0];
		TicTacToe.BoardChoice lastPlayer = TicTacToe.BoardChoice.OPEN;
		boolean gameOver = false;

		String scenarioName = "testNewGame";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 7;
		try {
			printTest("testNewGame", testNewGame(newGame()));
			printTest("testGameOver", testGameOver(newGame(), Result.False));
			printTest("testGameState", testGameState(newGame(), Result.InProgress));
			printTest("testGetGameGrid", testGetGameGrid(newGame(), grid));
			printTest("testGetMoves", testGetMoves(newGame(), newGameMoves));
			printTest("testChoicesX", testChoices(newGame, TicTacToe.BoardChoice.X, lastPlayer, gameOver, grid));
			printTest("testChoicesO", testChoices(newGame, TicTacToe.BoardChoice.O, lastPlayer, gameOver, grid));
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
		TicTacToe.BoardChoice[][] grid = {
				{TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN},
				{TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN},
				{TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN}
		};
		Point[] moves = {new Point(0,0)};
		TicTacToe.BoardChoice lastPlayer = TicTacToe.BoardChoice.X;
		boolean gameOver = false;

		String scenarioName = "testX00";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 7;
		try {
			printTest("testNewGame", testNewGame(gameX00()));
			printTest("testGameOver", testGameOver(gameX00(), Result.False));
			printTest("testGameState", testGameState(gameX00(), Result.InProgress));
			printTest("testGetGameGrid", testGetGameGrid(gameX00(), grid));
			printTest("testGetMoves", testGetMoves(gameX00(), moves));
			printTest("testChoicesX", testChoices(gameX00, TicTacToe.BoardChoice.X, lastPlayer, gameOver, grid));
			printTest("testChoicesO", testChoices(gameX00, TicTacToe.BoardChoice.O, lastPlayer, gameOver, grid));
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
		TicTacToe.BoardChoice[][] grid = {
				{TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN},
				{TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN},
				{TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN}
		};
		Point[] moves = {new Point(0,0), new Point(1,0)};
		TicTacToe.BoardChoice lastPlayer = TicTacToe.BoardChoice.O;
		boolean gameOver = false;

		String scenarioName = "testX00O10";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 7;
		try {
			printTest("testNewGame", testNewGame(gameX00O10()));
			printTest("testGameOver", testGameOver(gameX00O10(), Result.False));
			printTest("testGameState", testGameState(gameX00O10(), Result.InProgress));
			printTest("testGetGameGrid", testGetGameGrid(gameX00O10(), grid));
			printTest("testGetMoves", testGetMoves(gameX00O10(), moves));
			printTest("testChoicesX", testChoices(gameX00O10, TicTacToe.BoardChoice.X, lastPlayer, gameOver, grid));
			printTest("testChoicesO", testChoices(gameX00O10, TicTacToe.BoardChoice.O, lastPlayer, gameOver, grid));
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
		TicTacToe.BoardChoice[][] grid = {
				{TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN},
				{TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.OPEN},
				{TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN}
		};
		Point[] moves = {new Point(0,0), new Point(1,0), new Point(1,1)};
		TicTacToe.BoardChoice lastPlayer = TicTacToe.BoardChoice.X;
		boolean gameOver = false;

		String scenarioName = "testX00O10X11";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 7;
		try {
			printTest("testNewGame", testNewGame(gameX00O10X11()));
			printTest("testGameOver", testGameOver(gameX00O10X11(), Result.False));
			printTest("testGameState", testGameState(gameX00O10X11(), Result.InProgress));
			printTest("testGetGameGrid", testGetGameGrid(gameX00O10X11(), grid));
			printTest("testGetMoves", testGetMoves(gameX00O10X11(), moves));
			printTest("testChoicesX", testChoices(gameX00O10X11, TicTacToe.BoardChoice.X, lastPlayer, gameOver, grid));
			printTest("testChoicesO", testChoices(gameX00O10X11, TicTacToe.BoardChoice.O, lastPlayer, gameOver, grid));
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
		TicTacToe.BoardChoice[][] grid = {
				{TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN},
				{TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.OPEN},
				{TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.O}
		};
		Point[] moves = {new Point(0,0), new Point(1,0), new Point(1,1),
				new Point(2,2)};
		TicTacToe.BoardChoice lastPlayer = TicTacToe.BoardChoice.O;
		boolean gameOver = false;

		String scenarioName = "testX00O10X11O22";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 7;
		try {
			printTest("testNewGame", testNewGame(gameX00O10X11O22()));
			printTest("testGameOver", testGameOver(gameX00O10X11O22(), Result.False));
			printTest("testGameState", testGameState(gameX00O10X11O22(), Result.InProgress));
			printTest("testGetGameGrid", testGetGameGrid(gameX00O10X11O22(), grid));
			printTest("testGetMoves", testGetMoves(gameX00O10X11O22(), moves));
			printTest("testChoicesX", testChoices(gameX00O10X11O22, TicTacToe.BoardChoice.X, lastPlayer, gameOver, grid));
			printTest("testChoicesO", testChoices(gameX00O10X11O22, TicTacToe.BoardChoice.O, lastPlayer, gameOver, grid));
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
		TicTacToe.BoardChoice[][] grid = {
				{TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.X},
				{TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.OPEN},
				{TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.O}
		};
		Point[] moves = {new Point(0,0), new Point(1,0), new Point(1,1),
				new Point(2,2), new Point(0,2)};
		TicTacToe.BoardChoice lastPlayer = TicTacToe.BoardChoice.X;
		boolean gameOver = false;

		String scenarioName = "testX00O10X11O22X02";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 7;
		try {
			printTest("testNewGame", testNewGame(gameX00O10X11O22X02()));
			printTest("testGameOver", testGameOver(gameX00O10X11O22X02(), Result.False));
			printTest("testGameState", testGameState(gameX00O10X11O22X02(), Result.InProgress));
			printTest("testGetGameGrid", testGetGameGrid(gameX00O10X11O22X02(), grid));
			printTest("testGetMoves", testGetMoves(gameX00O10X11O22X02(), moves));
			printTest("testChoicesX", testChoices(gameX00O10X11O22X02, TicTacToe.BoardChoice.X, lastPlayer, gameOver, grid));
			printTest("testChoicesO", testChoices(gameX00O10X11O22X02, TicTacToe.BoardChoice.O, lastPlayer, gameOver, grid));
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
		TicTacToe.BoardChoice[][] grid = {
				{TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.X},
				{TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.OPEN},
				{TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.O}
		};
		Point[] moves = {new Point(0,0), new Point(1,0), new Point(1,1),
				new Point(2,2), new Point(0,2), new Point(0,1)};
		TicTacToe.BoardChoice lastPlayer = TicTacToe.BoardChoice.O;
		boolean gameOver = false;

		String scenarioName = "testX00O10X11O22X02O01";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 7;
		try {
			printTest("testNewGame", testNewGame(gameX00O10X11O22X02O01()));
			printTest("testGameOver", testGameOver(gameX00O10X11O22X02O01(), Result.False));
			printTest("testGameState", testGameState(gameX00O10X11O22X02O01(), Result.InProgress));
			printTest("testGetGameGrid", testGetGameGrid(gameX00O10X11O22X02O01(), grid));
			printTest("testGetMoves", testGetMoves(gameX00O10X11O22X02O01(), moves));
			printTest("testChoicesX", testChoices(gameX00O10X11O22X02O01, TicTacToe.BoardChoice.X, lastPlayer, gameOver, grid));
			printTest("testChoicesO", testChoices(gameX00O10X11O22X02O01, TicTacToe.BoardChoice.O, lastPlayer, gameOver, grid));
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
		TicTacToe.BoardChoice[][] grid = {
				{TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.X},
				{TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.OPEN},
				{TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.O}
		};
		Point[] moves = {new Point(0,0), new Point(1,0), new Point(1,1),
				new Point(2,2), new Point(0,2), new Point(0,1), new Point(2,1)};
		TicTacToe.BoardChoice lastPlayer = TicTacToe.BoardChoice.X;
		boolean gameOver = false;

		String scenarioName = "testX00O10X11O22X02O01X21";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 7;
		try {
			printTest("testNewGame", testNewGame(gameX00O10X11O22X02O01X21()));
			printTest("testGameOver", testGameOver(gameX00O10X11O22X02O01X21(), Result.False));
			printTest("testGameState", testGameState(gameX00O10X11O22X02O01X21(), Result.InProgress));
			printTest("testGetGameGrid", testGetGameGrid(gameX00O10X11O22X02O01X21(), grid));
			printTest("testGetMoves", testGetMoves(gameX00O10X11O22X02O01X21(), moves));
			printTest("testChoicesX", testChoices(gameX00O10X11O22X02O01X21, TicTacToe.BoardChoice.X, lastPlayer, gameOver, grid));
			printTest("testChoicesO", testChoices(gameX00O10X11O22X02O01X21, TicTacToe.BoardChoice.O, lastPlayer, gameOver, grid));
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
		TicTacToe.BoardChoice[][] grid = {
				{TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.X},
				{TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.OPEN},
				{TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.O}
		};
		Point[] moves = {new Point(0,0), new Point(1,0), new Point(1,1),
				new Point(2,2), new Point(0,2), new Point(0,1), new Point(2,1), new Point(2,0)};
		TicTacToe.BoardChoice lastPlayer = TicTacToe.BoardChoice.O;
		boolean gameOver = false;

		String scenarioName = "testX00O10X11O22X02O01X21O20";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 7;
		try {
			printTest("testNewGame", testNewGame(gameX00O10X11O22X02O01X21O20()));
			printTest("testGameOver", testGameOver(gameX00O10X11O22X02O01X21O20(), Result.False));
			printTest("testGameState", testGameState(gameX00O10X11O22X02O01X21O20(), Result.InProgress));
			printTest("testGetGameGrid", testGetGameGrid(gameX00O10X11O22X02O01X21O20(), grid));
			printTest("testGetMoves", testGetMoves(gameX00O10X11O22X02O01X21O20(), moves));
			printTest("testChoicesX", testChoices(gameX00O10X11O22X02O01X21O20, TicTacToe.BoardChoice.X, lastPlayer, gameOver, grid));
			printTest("testChoicesO", testChoices(gameX00O10X11O22X02O01X21O20, TicTacToe.BoardChoice.O, lastPlayer, gameOver, grid));
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
		TicTacToe.BoardChoice[][] grid = {
				{TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.X},
				{TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.X},
				{TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.O}
		};
		Point[] moves = {new Point(0,0), new Point(1,0), new Point(1,1),
				new Point(2,2), new Point(0,2), new Point(0,1), new Point(2,1), 
				new Point(2,0), new Point(1,2)};
		TicTacToe.BoardChoice lastPlayer = TicTacToe.BoardChoice.X;
		boolean gameOver = true;

		String scenarioName = "testX00O10X11O22X02O01X21O20X12";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 7;
		try {
			printTest("testNewGame", testNewGame(gameX00O10X11O22X02O01X21O20X12()));
			printTest("testGameOver", testGameOver(gameX00O10X11O22X02O01X21O20X12(), Result.True));
			printTest("testGameState", testGameState(gameX00O10X11O22X02O01X21O20X12(), Result.Tie));
			printTest("testGetGameGrid", testGetGameGrid(gameX00O10X11O22X02O01X21O20X12(), grid));
			printTest("testGetMoves", testGetMoves(gameX00O10X11O22X02O01X21O20X12(), moves));
			printTest("testChoicesX", testChoices(gameX00O10X11O22X02O01X21O20X12, TicTacToe.BoardChoice.X, lastPlayer, gameOver, grid));
			printTest("testChoicesO", testChoices(gameX00O10X11O22X02O01X21O20X12, TicTacToe.BoardChoice.O, lastPlayer, gameOver, grid));
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
		TicTacToe.BoardChoice[][] grid = {
				{TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.X},
				{TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN},
				{TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.O}
		};
		Point[] moves = {new Point(0,2), new Point(1,0), new Point(0,0),
				new Point(2,2), new Point(0,1)};
		TicTacToe.BoardChoice lastPlayer = TicTacToe.BoardChoice.X;
		boolean gameOver = true;

		String scenarioName = "testX02O10X00O22X01";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 7;
		try {
			printTest("testNewGame", testNewGame(gameX02O10X00O22X01()));
			printTest("testGameOver", testGameOver(gameX02O10X00O22X01(), Result.True));
			printTest("testGameState", testGameState(gameX02O10X00O22X01(), Result.X));
			printTest("testGetGameGrid", testGetGameGrid(gameX02O10X00O22X01(), grid));
			printTest("testGetMoves", testGetMoves(gameX02O10X00O22X01(), moves));
			printTest("testChoicesX", testChoices(gameX02O10X00O22X01, TicTacToe.BoardChoice.X, lastPlayer, gameOver, grid));
			printTest("testChoicesO", testChoices(gameX02O10X00O22X01, TicTacToe.BoardChoice.O, lastPlayer, gameOver, grid));
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
		TicTacToe.BoardChoice[][] grid = {
				{TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN},
				{TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.X},
				{TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.O}
		};
		Point[] moves = {new Point(1,1), new Point(0,0), new Point(1,0),
				new Point(2,2), new Point(1,2)};
		TicTacToe.BoardChoice lastPlayer = TicTacToe.BoardChoice.X;
		boolean gameOver = true;

		String scenarioName = "testX11O00X10O22X12";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 7;
		try {
			printTest("testNewGame", testNewGame(gameX11O00X10O22X12()));
			printTest("testGameOver", testGameOver(gameX11O00X10O22X12(), Result.True));
			printTest("testGameState", testGameState(gameX11O00X10O22X12(), Result.X));
			printTest("testGetGameGrid", testGetGameGrid(gameX11O00X10O22X12(), grid));
			printTest("testGetMoves", testGetMoves(gameX11O00X10O22X12(), moves));
			printTest("testChoicesX", testChoices(gameX11O00X10O22X12, TicTacToe.BoardChoice.X, lastPlayer, gameOver, grid));
			printTest("testChoicesO", testChoices(gameX11O00X10O22X12, TicTacToe.BoardChoice.O, lastPlayer, gameOver, grid));
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
		TicTacToe.BoardChoice[][] grid = {
				{TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN},
				{TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.O},
				{TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.X}
		};
		Point[] moves = {new Point(2,2), new Point(0,0), new Point(2,0),
				new Point(1,2), new Point(2,1)};
		TicTacToe.BoardChoice lastPlayer = TicTacToe.BoardChoice.X;
		boolean gameOver = true;

		String scenarioName = "testX22O00X20O12X21";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 7;
		try {
			printTest("testNewGame", testNewGame(gameX22O00X20O12X21()));
			printTest("testGameOver", testGameOver(gameX22O00X20O12X21(), Result.True));
			printTest("testGameState", testGameState(gameX22O00X20O12X21(), Result.X));
			printTest("testGetGameGrid", testGetGameGrid(gameX22O00X20O12X21(), grid));
			printTest("testGetMoves", testGetMoves(gameX22O00X20O12X21(), moves));
			printTest("testChoicesX", testChoices(gameX22O00X20O12X21, TicTacToe.BoardChoice.X, lastPlayer, gameOver, grid));
			printTest("testChoicesO", testChoices(gameX22O00X20O12X21, TicTacToe.BoardChoice.O, lastPlayer, gameOver, grid));
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
		TicTacToe.BoardChoice[][] grid = {
				{TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN},
				{TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.O},
				{TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN}
		};
		Point[] moves = {new Point(0,0), new Point(1,1), new Point(2,0),
				new Point(1,2), new Point(1,0)};
		TicTacToe.BoardChoice lastPlayer = TicTacToe.BoardChoice.X;
		boolean gameOver = true;

		String scenarioName = "testX00O11X20O12X10";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 7;
		try {
			printTest("testNewGame", testNewGame(gameX00O11X20O12X10()));
			printTest("testGameOver", testGameOver(gameX00O11X20O12X10(), Result.True));
			printTest("testGameState", testGameState(gameX00O11X20O12X10(), Result.X));
			printTest("testGetGameGrid", testGetGameGrid(gameX00O11X20O12X10(), grid));
			printTest("testGetMoves", testGetMoves(gameX00O11X20O12X10(), moves));
			printTest("testChoicesX", testChoices(gameX00O11X20O12X10, TicTacToe.BoardChoice.X, lastPlayer, gameOver, grid));
			printTest("testChoicesO", testChoices(gameX00O11X20O12X10, TicTacToe.BoardChoice.O, lastPlayer, gameOver, grid));
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
		TicTacToe.BoardChoice[][] grid = {
				{TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.OPEN},
				{TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.O},
				{TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.OPEN}
		};
		Point[] moves = {new Point(0,1), new Point(1,0), new Point(2,1),
				new Point(1,2), new Point(1,1)};
		TicTacToe.BoardChoice lastPlayer = TicTacToe.BoardChoice.X;
		boolean gameOver = true;

		String scenarioName = "testX01O10X21O12X11";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 7;
		try {
			printTest("testNewGame", testNewGame(gameX01O10X21O12X11()));
			printTest("testGameOver", testGameOver(gameX01O10X21O12X11(), Result.True));
			printTest("testGameState", testGameState(gameX01O10X21O12X11(), Result.X));
			printTest("testGetGameGrid", testGetGameGrid(gameX01O10X21O12X11(), grid));
			printTest("testGetMoves", testGetMoves(gameX01O10X21O12X11(), moves));
			printTest("testChoicesX", testChoices(gameX01O10X21O12X11, TicTacToe.BoardChoice.X, lastPlayer, gameOver, grid));
			printTest("testChoicesO", testChoices(gameX01O10X21O12X11, TicTacToe.BoardChoice.O, lastPlayer, gameOver, grid));
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
		TicTacToe.BoardChoice[][] grid = {
				{TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.X},
				{TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.X},
				{TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.X}
		};
		Point[] moves = {new Point(1,2), new Point(1,1), new Point(0,2),
				new Point(2,1), new Point(2,2)};
		TicTacToe.BoardChoice lastPlayer = TicTacToe.BoardChoice.X;
		boolean gameOver = true;

		String scenarioName = "testX12O11X02O21X22";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 7;
		try {
			printTest("testNewGame", testNewGame(gameX12O11X02O21X22()));
			printTest("testGameOver", testGameOver(gameX12O11X02O21X22(), Result.True));
			printTest("testGameState", testGameState(gameX12O11X02O21X22(), Result.X));
			printTest("testGetGameGrid", testGetGameGrid(gameX12O11X02O21X22(), grid));
			printTest("testGetMoves", testGetMoves(gameX12O11X02O21X22(), moves));
			printTest("testChoicesX", testChoices(gameX12O11X02O21X22, TicTacToe.BoardChoice.X, lastPlayer, gameOver, grid));
			printTest("testChoicesO", testChoices(gameX12O11X02O21X22, TicTacToe.BoardChoice.O, lastPlayer, gameOver, grid));
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
		TicTacToe.BoardChoice[][] grid = {
				{TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.O},
				{TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.O},
				{TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.X}
		};
		Point[] moves = {new Point(1,1), new Point(0,2), new Point(2,2),
				new Point(1,2), new Point(0,0)};
		TicTacToe.BoardChoice lastPlayer = TicTacToe.BoardChoice.X;
		boolean gameOver = true;

		String scenarioName = "testX11O02X22O12X00";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 7;
		try {
			printTest("testNewGame", testNewGame(gameX11O02X22O12X00()));
			printTest("testGameOver", testGameOver(gameX11O02X22O12X00(), Result.True));
			printTest("testGameState", testGameState(gameX11O02X22O12X00(), Result.X));
			printTest("testGetGameGrid", testGetGameGrid(gameX11O02X22O12X00(), grid));
			printTest("testGetMoves", testGetMoves(gameX11O02X22O12X00(), moves));
			printTest("testChoicesX", testChoices(gameX11O02X22O12X00, TicTacToe.BoardChoice.X, lastPlayer, gameOver, grid));
			printTest("testChoicesO", testChoices(gameX11O02X22O12X00, TicTacToe.BoardChoice.O, lastPlayer, gameOver, grid));
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
		TicTacToe.BoardChoice[][] grid = {
				{TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.X},
				{TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.OPEN},
				{TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN}
		};
		Point[] moves = {new Point(2,0), new Point(0,1), new Point(1,1),
				new Point(0,0), new Point(0,2)};
		TicTacToe.BoardChoice lastPlayer = TicTacToe.BoardChoice.X;
		boolean gameOver = true;

		String scenarioName = "testX20O01X11O00X02";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 7;
		try {
			printTest("testNewGame", testNewGame(gameX20O01X11O00X02()));
			printTest("testGameOver", testGameOver(gameX20O01X11O00X02(), Result.True));
			printTest("testGameState", testGameState(gameX20O01X11O00X02(), Result.X));
			printTest("testGetGameGrid", testGetGameGrid(gameX20O01X11O00X02(), grid));
			printTest("testGetMoves", testGetMoves(gameX20O01X11O00X02(), moves));
			printTest("testChoicesX", testChoices(gameX20O01X11O00X02, TicTacToe.BoardChoice.X, lastPlayer, gameOver, grid));
			printTest("testChoicesO", testChoices(gameX20O01X11O00X02, TicTacToe.BoardChoice.O, lastPlayer, gameOver, grid));
		} catch (Exception e) {
			System.out.printf("***UNABLE TO RUN/COMPLETE %s***\n", scenarioName + " TESTS");
			e.printStackTrace();
		} finally {
			if (printSectionSummaries) {
				printSectionSummary("Section");
			}
		}
	}
	
	// X wins in 9th move
	private void testX01O12X00O02X10O20X11O21X22() {
		TicTacToe.BoardChoice[][] grid = {
				{TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.O},
				{TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.O},
				{TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.X}
		};
		Point[] moves = {new Point(0,1), new Point(1,2), new Point(0,0),
				new Point(0,2), new Point(1,0), new Point(2,0),
				new Point(1,1), new Point(2,1), new Point(2,2)};
		TicTacToe.BoardChoice lastPlayer = TicTacToe.BoardChoice.X;
		boolean gameOver = true;

		String scenarioName = "testX01O12X00O02X10O20X11O21X22";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 7;
		try {
			printTest("testNewGame", testNewGame(gameX01O12X00O02X10O20X11O21X22()));
			printTest("testGameOver", testGameOver(gameX01O12X00O02X10O20X11O21X22(), Result.True));
			printTest("testGameState", testGameState(gameX01O12X00O02X10O20X11O21X22(), Result.X));
			printTest("testGetGameGrid", testGetGameGrid(gameX01O12X00O02X10O20X11O21X22(), grid));
			printTest("testGetMoves", testGetMoves(gameX01O12X00O02X10O20X11O21X22(), moves));
			printTest("testChoicesX", testChoices(gameX01O12X00O02X10O20X11O21X22, TicTacToe.BoardChoice.X, lastPlayer, gameOver, grid));
			printTest("testChoicesO", testChoices(gameX01O12X00O02X10O20X11O21X22, TicTacToe.BoardChoice.O, lastPlayer, gameOver, grid));
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
		TicTacToe.BoardChoice[][] grid = {
				{TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.O},
				{TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.OPEN},
				{TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN}
		};
		Point[] moves = {new Point(1,0), new Point(0,1), new Point(2,0),
				new Point(0,2), new Point(1,1), new Point(0,0)};
		TicTacToe.BoardChoice lastPlayer = TicTacToe.BoardChoice.O;
		boolean gameOver = true;

		String scenarioName = "testX10O01X20O02X11O00";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 7;
		try {
			printTest("testNewGame", testNewGame(gameX10O01X20O02X11O00()));
			printTest("testGameOver", testGameOver(gameX10O01X20O02X11O00(), Result.True));
			printTest("testGameState", testGameState(gameX10O01X20O02X11O00(), Result.O));
			printTest("testGetGameGrid", testGetGameGrid(gameX10O01X20O02X11O00(), grid));
			printTest("testGetMoves", testGetMoves(gameX10O01X20O02X11O00(), moves));
			printTest("testChoicesX", testChoices(gameX10O01X20O02X11O00, TicTacToe.BoardChoice.X, lastPlayer, gameOver, grid));
			printTest("testChoicesO", testChoices(gameX10O01X20O02X11O00, TicTacToe.BoardChoice.O, lastPlayer, gameOver, grid));
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
		TicTacToe.BoardChoice[][] grid = {
				{TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.OPEN},
				{TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.O},
				{TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN}
		};
		Point[] moves = {new Point(0,0), new Point(1,0), new Point(2,0),
				new Point(1,2), new Point(0,1), new Point(1,1)};
		TicTacToe.BoardChoice lastPlayer = TicTacToe.BoardChoice.O;
		boolean gameOver = true;

		String scenarioName = "testX00O10X20O12X01O11";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 7;
		try {
			printTest("testNewGame", testNewGame(gameX00O10X20O12X01O11()));
			printTest("testGameOver", testGameOver(gameX00O10X20O12X01O11(), Result.True));
			printTest("testGameState", testGameState(gameX00O10X20O12X01O11(), Result.O));
			printTest("testGetGameGrid", testGetGameGrid(gameX00O10X20O12X01O11(), grid));
			printTest("testGetMoves", testGetMoves(gameX00O10X20O12X01O11(), moves));
			printTest("testChoicesX", testChoices(gameX00O10X20O12X01O11, TicTacToe.BoardChoice.X, lastPlayer, gameOver, grid));
			printTest("testChoicesO", testChoices(gameX00O10X20O12X01O11, TicTacToe.BoardChoice.O, lastPlayer, gameOver, grid));
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
		TicTacToe.BoardChoice[][] grid = {
				{TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.OPEN},
				{TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN},
				{TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.O}
		};
		Point[] moves = {new Point(0,0), new Point(2,1), new Point(1,0),
				new Point(2,0), new Point(0,1), new Point(2,2)};
		TicTacToe.BoardChoice lastPlayer = TicTacToe.BoardChoice.O;
		boolean gameOver = true;

		String scenarioName = "testX00O21X10O20X01O22";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 7;
		try {
			printTest("testNewGame", testNewGame(gameX00O21X10O20X01O22()));
			printTest("testGameOver", testGameOver(gameX00O21X10O20X01O22(), Result.True));
			printTest("testGameState", testGameState(gameX00O21X10O20X01O22(), Result.O));
			printTest("testGetGameGrid", testGetGameGrid(gameX00O21X10O20X01O22(), grid));
			printTest("testGetMoves", testGetMoves(gameX00O21X10O20X01O22(), moves));
			printTest("testChoicesX", testChoices(gameX00O21X10O20X01O22, TicTacToe.BoardChoice.X, lastPlayer, gameOver, grid));
			printTest("testChoicesO", testChoices(gameX00O21X10O20X01O22, TicTacToe.BoardChoice.O, lastPlayer, gameOver, grid));
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
		TicTacToe.BoardChoice[][] grid = {
				{TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.OPEN},
				{TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.OPEN},
				{TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.X}
		};
		Point[] moves = {new Point(2,2), new Point(1,0), new Point(1,1),
				new Point(0,0), new Point(0,1), new Point(2,0)};
		TicTacToe.BoardChoice lastPlayer = TicTacToe.BoardChoice.O;
		boolean gameOver = true;

		String scenarioName = "testX22O10X11O00X01O20";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 7;
		try {
			printTest("testNewGame", testNewGame(gameX22O10X11O00X01O20()));
			printTest("testGameOver", testGameOver(gameX22O10X11O00X01O20(), Result.True));
			printTest("testGameState", testGameState(gameX22O10X11O00X01O20(), Result.O));
			printTest("testGetGameGrid", testGetGameGrid(gameX22O10X11O00X01O20(), grid));
			printTest("testGetMoves", testGetMoves(gameX22O10X11O00X01O20(), moves));
			printTest("testChoicesX", testChoices(gameX22O10X11O00X01O20, TicTacToe.BoardChoice.X, lastPlayer, gameOver, grid));
			printTest("testChoicesO", testChoices(gameX22O10X11O00X01O20, TicTacToe.BoardChoice.O, lastPlayer, gameOver, grid));
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
		TicTacToe.BoardChoice[][] grid = {
				{TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.OPEN},
				{TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.OPEN},
				{TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.X}
		};
		Point[] moves = {new Point(0,0), new Point(0,1), new Point(2,2),
				new Point(1,1), new Point(1,0), new Point(2,1)};
		TicTacToe.BoardChoice lastPlayer = TicTacToe.BoardChoice.O;
		boolean gameOver = true;

		String scenarioName = "testX00O01X22O11X10O21";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 7;
		try {
			printTest("testNewGame", testNewGame(gameX00O01X22O11X10O21()));
			printTest("testGameOver", testGameOver(gameX00O01X22O11X10O21(), Result.True));
			printTest("testGameState", testGameState(gameX00O01X22O11X10O21(), Result.O));
			printTest("testGetGameGrid", testGetGameGrid(gameX00O01X22O11X10O21(), grid));
			printTest("testGetMoves", testGetMoves(gameX00O01X22O11X10O21(), moves));
			printTest("testChoicesX", testChoices(gameX00O01X22O11X10O21, TicTacToe.BoardChoice.X, lastPlayer, gameOver, grid));
			printTest("testChoicesO", testChoices(gameX00O01X22O11X10O21, TicTacToe.BoardChoice.O, lastPlayer, gameOver, grid));
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
		TicTacToe.BoardChoice[][] grid = {
				{TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.O},
				{TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.O},
				{TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.O}
		};
		Point[] moves = {new Point(1,1), new Point(0,2), new Point(0,0),
				new Point(2,2), new Point(1,0), new Point(1,2)};
		TicTacToe.BoardChoice lastPlayer = TicTacToe.BoardChoice.O;
		boolean gameOver = true;

		String scenarioName = "testX11O02X00O22X10O12";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 7;
		try {
			printTest("testNewGame", testNewGame(gameX11O02X00O22X10O12()));
			printTest("testGameOver", testGameOver(gameX11O02X00O22X10O12(), Result.True));
			printTest("testGameState", testGameState(gameX11O02X00O22X10O12(), Result.O));
			printTest("testGetGameGrid", testGetGameGrid(gameX11O02X00O22X10O12(), grid));
			printTest("testGetMoves", testGetMoves(gameX11O02X00O22X10O12(), moves));
			printTest("testChoicesX", testChoices(gameX11O02X00O22X10O12, TicTacToe.BoardChoice.X, lastPlayer, gameOver, grid));
			printTest("testChoicesO", testChoices(gameX11O02X00O22X10O12, TicTacToe.BoardChoice.O, lastPlayer, gameOver, grid));
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
		TicTacToe.BoardChoice[][] grid = {
				{TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.OPEN},
				{TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.OPEN},
				{TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.O}
		};
		Point[] moves = {new Point(0,1), new Point(0,0), new Point(1,0),
				new Point(1,1), new Point(2,1), new Point(2,2)};
		TicTacToe.BoardChoice lastPlayer = TicTacToe.BoardChoice.O;
		boolean gameOver = true;

		String scenarioName = "testX01O00X10O11X21O22";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 7;
		try {
			printTest("testNewGame", testNewGame(gameX01O00X10O11X21O22()));
			printTest("testGameOver", testGameOver(gameX01O00X10O11X21O22(), Result.True));
			printTest("testGameState", testGameState(gameX01O00X10O11X21O22(), Result.O));
			printTest("testGetGameGrid", testGetGameGrid(gameX01O00X10O11X21O22(), grid));
			printTest("testGetMoves", testGetMoves(gameX01O00X10O11X21O22(), moves));
			printTest("testChoicesX", testChoices(gameX01O00X10O11X21O22, TicTacToe.BoardChoice.X, lastPlayer, gameOver, grid));
			printTest("testChoicesO", testChoices(gameX01O00X10O11X21O22, TicTacToe.BoardChoice.O, lastPlayer, gameOver, grid));
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
		TicTacToe.BoardChoice[][] grid = {
				{TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.O},
				{TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.OPEN},
				{TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.OPEN}
		};
		Point[] moves = {new Point(0,0), new Point(1,1), new Point(1,0),
				new Point(2,0), new Point(2,1), new Point(0,2)};
		TicTacToe.BoardChoice lastPlayer = TicTacToe.BoardChoice.O;
		boolean gameOver = true;

		String scenarioName = "testX00O11X10O20X21O02";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 7;
		try {
			printTest("testNewGame", testNewGame(gameX00O11X10O20X21O02()));
			printTest("testGameOver", testGameOver(gameX00O11X10O20X21O02(), Result.True));
			printTest("testGameState", testGameState(gameX00O11X10O20X21O02(), Result.O));
			printTest("testGetGameGrid", testGetGameGrid(gameX00O11X10O20X21O02(), grid));
			printTest("testGetMoves", testGetMoves(gameX00O11X10O20X21O02(), moves));
			printTest("testChoicesX", testChoices(gameX00O11X10O20X21O02, TicTacToe.BoardChoice.X, lastPlayer, gameOver, grid));
			printTest("testChoicesO", testChoices(gameX00O11X10O20X21O02, TicTacToe.BoardChoice.O, lastPlayer, gameOver, grid));
		} catch (Exception e) {
			System.out.printf("***UNABLE TO RUN/COMPLETE %s***\n", scenarioName + " TESTS");
			e.printStackTrace();
		} finally {
			if (printSectionSummaries) {
				printSectionSummary("Section");
			}
		}
	}
	
	// O wins in 9th move
	private void testO01X12O00X02O10X20O11X21O22() {
		TicTacToe.BoardChoice[][] grid = {
				{TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.X},
				{TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.O, TicTacToe.BoardChoice.X},
				{TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.X, TicTacToe.BoardChoice.O}
		};
		Point[] moves = {new Point(0,1), new Point(1,2), new Point(0,0),
				new Point(0,2), new Point(1,0), new Point(2,0),
				new Point(1,1), new Point(2,1), new Point(2,2)};
		TicTacToe.BoardChoice lastPlayer = TicTacToe.BoardChoice.O;
		boolean gameOver = true;

		String scenarioName = "testO01X12O00X02O10X20O11X21O22";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 7;
		try {
			printTest("testNewGame", testNewGame(gameO01X12O00X02O10X20O11X21O22()));
			printTest("testGameOver", testGameOver(gameO01X12O00X02O10X20O11X21O22(), Result.True));
			printTest("testGameState", testGameState(gameO01X12O00X02O10X20O11X21O22(), Result.O));
			printTest("testGetGameGrid", testGetGameGrid(gameO01X12O00X02O10X20O11X21O22(), grid));
			printTest("testGetMoves", testGetMoves(gameO01X12O00X02O10X20O11X21O22(), moves));
			printTest("testChoicesX", testChoices(gameO01X12O00X02O10X20O11X21O22, TicTacToe.BoardChoice.X, lastPlayer, gameOver, grid));
			printTest("testChoicesO", testChoices(gameO01X12O00X02O10X20O11X21O22, TicTacToe.BoardChoice.O, lastPlayer, gameOver, grid));
		} catch (Exception e) {
			System.out.printf("***UNABLE TO RUN/COMPLETE %s***\n", scenarioName + " TESTS");
			e.printStackTrace();
		} finally {
			if (printSectionSummaries) {
				printSectionSummary("Section");
			}
		}
		
	}
	
	/////////////////////////////
	// XXX Reset using New Game
	/////////////////////////////
	
	// newGame after partial game
	private void testX00O10X11NewGame() {
		TicTacToe.BoardChoice[][] grid = {
				{TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN},
				{TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN},
				{TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN}
		};
		Point[] moves = {};
		TicTacToe.BoardChoice lastPlayer = TicTacToe.BoardChoice.OPEN;
		boolean gameOver = false;

		String scenarioName = "testX00O10X11NewGame";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 7;
		try {
			printTest("testNewGame", testNewGame(gameX00O10X11NewGame()));
			printTest("testGameOver", testGameOver(gameX00O10X11NewGame(), Result.False));
			printTest("testGameState", testGameState(gameX00O10X11NewGame(), Result.InProgress));
			printTest("testGetGameGrid", testGetGameGrid(gameX00O10X11NewGame(), grid));
			printTest("testGetMoves", testGetMoves(gameX00O10X11NewGame(), moves));
			printTest("testChoicesX", testChoices(gameX00O10X11NewGame, TicTacToe.BoardChoice.X, lastPlayer, gameOver, grid));
			printTest("testChoicesO", testChoices(gameX00O10X11NewGame, TicTacToe.BoardChoice.O, lastPlayer, gameOver, grid));
		} catch (Exception e) {
			System.out.printf("***UNABLE TO RUN/COMPLETE %s***\n", scenarioName + " TESTS");
			e.printStackTrace();
		} finally {
			if (printSectionSummaries) {
				printSectionSummary("Section");
			}
		}
	}
	
	// newGame after X wins in 9th move
	private void testX01O12X00O02X10O20X11O21X22NewGame() {
		TicTacToe.BoardChoice[][] grid = {
				{TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN},
				{TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN},
				{TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN}
		};
		Point[] moves = {};
		TicTacToe.BoardChoice lastPlayer = TicTacToe.BoardChoice.OPEN;
		boolean gameOver = false;

		String scenarioName = "testX01O12X00O02X10O20X11O21X22NewGame";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 7;
		try {
			printTest("testNewGame", testNewGame(gameX01O12X00O02X10O20X11O21X22NewGame()));
			printTest("testGameOver", testGameOver(gameX01O12X00O02X10O20X11O21X22NewGame(), Result.False));
			printTest("testGameState", testGameState(gameX01O12X00O02X10O20X11O21X22NewGame(), Result.InProgress));
			printTest("testGetGameGrid", testGetGameGrid(gameX01O12X00O02X10O20X11O21X22NewGame(), grid));
			printTest("testGetMoves", testGetMoves(gameX01O12X00O02X10O20X11O21X22NewGame(), moves));
			printTest("testChoicesX", testChoices(gameX01O12X00O02X10O20X11O21X22NewGame, TicTacToe.BoardChoice.X, lastPlayer, gameOver, grid));
			printTest("testChoicesO", testChoices(gameX01O12X00O02X10O20X11O21X22NewGame, TicTacToe.BoardChoice.O, lastPlayer, gameOver, grid));
		} catch (Exception e) {
			System.out.printf("***UNABLE TO RUN/COMPLETE %s***\n", scenarioName + " TESTS");
			e.printStackTrace();
		} finally {
			if (printSectionSummaries) {
				printSectionSummary("Section");
			}
		}
	}

	// newGame after O wins in 9th move
	private void testO01X12O00X02O10X20O11X21O22NewGame() {
		TicTacToe.BoardChoice[][] grid = {
				{TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN},
				{TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN},
				{TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN}
		};
		Point[] moves = {};
		TicTacToe.BoardChoice lastPlayer = TicTacToe.BoardChoice.OPEN;
		boolean gameOver = false;

		String scenarioName = "testO01X12O00X02O10X20O11X21O22NewGame";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 7;
		try {
			printTest("testNewGame", testNewGame(gameO01X12O00X02O10X20O11X21O22NewGame()));
			printTest("testGameOver", testGameOver(gameO01X12O00X02O10X20O11X21O22NewGame(), Result.False));
			printTest("testGameState", testGameState(gameO01X12O00X02O10X20O11X21O22NewGame(), Result.InProgress));
			printTest("testGetGameGrid", testGetGameGrid(gameO01X12O00X02O10X20O11X21O22NewGame(), grid));
			printTest("testGetMoves", testGetMoves(gameO01X12O00X02O10X20O11X21O22NewGame(), moves));
			printTest("testChoicesX", testChoices(gameO01X12O00X02O10X20O11X21O22NewGame, TicTacToe.BoardChoice.X, lastPlayer, gameOver, grid));
			printTest("testChoicesO", testChoices(gameO01X12O00X02O10X20O11X21O22NewGame, TicTacToe.BoardChoice.O, lastPlayer, gameOver, grid));
		} catch (Exception e) {
			System.out.printf("***UNABLE TO RUN/COMPLETE %s***\n", scenarioName + " TESTS");
			e.printStackTrace();
		} finally {
			if (printSectionSummaries) {
				printSectionSummary("Section");
			}
		}
		
	}
	
	/////////////////////////////
	// XXX Encapsulation Tests
	/////////////////////////////
	
	private void testEncapsulation() {
		String scenarioName = "testEncapsulation";
		System.out.println("\nSCENARIO: " + scenarioName + "\n");
		totalTests += 2;
		try {
			printTest("testGetGameGridEncapsulation", testGetGameGridEncapsulation());
			printTest("testGetMovesEncapsulation", testGetMovesEncapsulation());			
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
	private Scenario newGame = () -> newGame();

	/**
	 * @return
	 * X--
	 * ---
	 * ---
	 */
	private TicTacToe gameX00() {
		TicTacToe game = newGame();
		game.choose(TicTacToe.BoardChoice.X, 0, 0);
		return game;
	}
	private Scenario gameX00 = () -> gameX00();

	/**
	 * @return
	 * X--
	 * O--
	 * ---
	 */
	private TicTacToe gameX00O10() {
		TicTacToe game = gameX00();
		game.choose(TicTacToe.BoardChoice.O, 1, 0);
		return game;
	}
	private Scenario gameX00O10 = () -> gameX00O10();

	/**
	 * @return
	 * X--
	 * OX-
	 * ---
	 */
	private TicTacToe gameX00O10X11() {
		TicTacToe game = gameX00O10();
		game.choose(TicTacToe.BoardChoice.X, 1, 1);
		return game;
	}
	private Scenario gameX00O10X11 = () -> gameX00O10X11();

	/** New Game resets a game in progress
	 * @return
	 * ---
	 * ---
	 * ---
	 */
	private TicTacToe gameX00O10X11NewGame() {
		TicTacToe game = gameX00O10X11();
		game.newGame();
		return game;
	}
	private Scenario gameX00O10X11NewGame = () -> gameX00O10X11NewGame();

	/**
	 * @return
	 * X--
	 * OX-
	 * --O
	 */
	private TicTacToe gameX00O10X11O22() {
		TicTacToe game = gameX00O10X11();
		game.choose(TicTacToe.BoardChoice.O, 2, 2);
		return game;
	}
	private Scenario gameX00O10X11O22 = () -> gameX00O10X11O22();

	/**
	 * @return
	 * X-X
	 * OX-
	 * --O
	 */
	private TicTacToe gameX00O10X11O22X02() {
		TicTacToe game = gameX00O10X11O22();
		game.choose(TicTacToe.BoardChoice.X, 0, 2);
		return game;
	}
	private Scenario gameX00O10X11O22X02 = () -> gameX00O10X11O22X02();

	/**
	 * @return
	 * XOX
	 * OX-
	 * --O
	 */
	private TicTacToe gameX00O10X11O22X02O01() {
		TicTacToe game = gameX00O10X11O22X02();
		game.choose(TicTacToe.BoardChoice.O, 0, 1);
		return game;
	}
	private Scenario gameX00O10X11O22X02O01 = () -> gameX00O10X11O22X02O01();

	/**
	 * @return
	 * XOX
	 * OX-
	 * -XO
	 */
	private TicTacToe gameX00O10X11O22X02O01X21() {
		TicTacToe game = gameX00O10X11O22X02O01();
		game.choose(TicTacToe.BoardChoice.X, 2, 1);
		return game;
	}
	private Scenario gameX00O10X11O22X02O01X21 = () -> gameX00O10X11O22X02O01X21();

	/**
	 * @return
	 * XOX
	 * OX-
	 * OXO
	 */
	private TicTacToe gameX00O10X11O22X02O01X21O20() {
		TicTacToe game = gameX00O10X11O22X02O01X21();
		game.choose(TicTacToe.BoardChoice.O, 2, 0);
		return game;
	}
	private Scenario gameX00O10X11O22X02O01X21O20 = () -> gameX00O10X11O22X02O01X21O20();

	// XXX Tie game
	
	/**
	 * @return
	 * XOX
	 * OXX
	 * OXO
	 */
	private TicTacToe gameX00O10X11O22X02O01X21O20X12() {
		TicTacToe game = gameX00O10X11O22X02O01X21O20();
		game.choose(TicTacToe.BoardChoice.X, 1, 2);
		return game;
	}
	private Scenario gameX00O10X11O22X02O01X21O20X12 = () -> gameX00O10X11O22X02O01X21O20X12();

	// XXX X wins
	
	/**
	 * @return
	 * X X X
	 * O - -
	 * - - O
	 */
	private TicTacToe gameX02O10X00O22X01() {
		TicTacToe game = newGame();
		game.choose(TicTacToe.BoardChoice.X, 0, 2);
		game.choose(TicTacToe.BoardChoice.O, 1, 0);
		game.choose(TicTacToe.BoardChoice.X, 0, 0);
		game.choose(TicTacToe.BoardChoice.O, 2, 2);
		game.choose(TicTacToe.BoardChoice.X, 0, 1);
		return game;
	}
	private Scenario gameX02O10X00O22X01 = () -> gameX02O10X00O22X01();
	
	/**
	 * @return
	 * O - -
	 * X X X
	 * - - O
	 */
	private TicTacToe gameX11O00X10O22X12() {
		TicTacToe game = newGame();
		game.choose(TicTacToe.BoardChoice.X, 1, 1);
		game.choose(TicTacToe.BoardChoice.O, 0, 0);
		game.choose(TicTacToe.BoardChoice.X, 1, 0);
		game.choose(TicTacToe.BoardChoice.O, 2, 2);
		game.choose(TicTacToe.BoardChoice.X, 1, 2);
		return game;
	}
	private Scenario gameX11O00X10O22X12 = () -> gameX11O00X10O22X12();
	
	/**
	 * @return
	 * O - -
	 * - - O
	 * X X X
	 */
	private TicTacToe gameX22O00X20O12X21() {
		TicTacToe game = newGame();
		game.choose(TicTacToe.BoardChoice.X, 2, 2);
		game.choose(TicTacToe.BoardChoice.O, 0, 0);
		game.choose(TicTacToe.BoardChoice.X, 2, 0);
		game.choose(TicTacToe.BoardChoice.O, 1, 2);
		game.choose(TicTacToe.BoardChoice.X, 2, 1);
		return game;
	}
	private Scenario gameX22O00X20O12X21 = () -> gameX22O00X20O12X21();
	
	/**
	 * @return
	 * X--
	 * XOO
	 * X--
	 */
	private TicTacToe gameX00O11X20O12X10() {
		TicTacToe game = newGame();
		game.choose(TicTacToe.BoardChoice.X, 0, 0);
		game.choose(TicTacToe.BoardChoice.O, 1, 1);
		game.choose(TicTacToe.BoardChoice.X, 2, 0);
		game.choose(TicTacToe.BoardChoice.O, 1, 2);
		game.choose(TicTacToe.BoardChoice.X, 1, 0);
		return game;
	}
	private Scenario gameX00O11X20O12X10 = () -> gameX00O11X20O12X10();
	
	/**
	 * @return
	 * -X-
	 * OXO
	 * -X-
	 */
	private TicTacToe gameX01O10X21O12X11() {
		TicTacToe game = newGame();
		game.choose(TicTacToe.BoardChoice.X, 0, 1);
		game.choose(TicTacToe.BoardChoice.O, 1, 0);
		game.choose(TicTacToe.BoardChoice.X, 2, 1);
		game.choose(TicTacToe.BoardChoice.O, 1, 2);
		game.choose(TicTacToe.BoardChoice.X, 1, 1);
		return game;
	}
	private Scenario gameX01O10X21O12X11 = () -> gameX01O10X21O12X11();
	
	/**
	 * @return
	 * --X
	 * -OX
	 * -OX
	 */
	private TicTacToe gameX12O11X02O21X22() {
		TicTacToe game = newGame();
		game.choose(TicTacToe.BoardChoice.X, 1, 2);
		game.choose(TicTacToe.BoardChoice.O, 1, 1);
		game.choose(TicTacToe.BoardChoice.X, 0, 2);
		game.choose(TicTacToe.BoardChoice.O, 2, 1);
		game.choose(TicTacToe.BoardChoice.X, 2, 2);
		return game;
	}
	private Scenario gameX12O11X02O21X22 = () -> gameX12O11X02O21X22();
	
	/**
	 * @return
	 * X-O
	 * -XO
	 * --X
	 */
	private TicTacToe gameX11O02X22O12X00() {
		TicTacToe game = newGame();
		game.choose(TicTacToe.BoardChoice.X, 1, 1);
		game.choose(TicTacToe.BoardChoice.O, 0, 2);
		game.choose(TicTacToe.BoardChoice.X, 2, 2);
		game.choose(TicTacToe.BoardChoice.O, 1, 2);
		game.choose(TicTacToe.BoardChoice.X, 0, 0);
		return game;
	}
	private Scenario gameX11O02X22O12X00 = () -> gameX11O02X22O12X00();
	
	/**
	 * @return
	 * OOX
	 * -X-
	 * X--
	 */
	private TicTacToe gameX20O01X11O00X02() {
		TicTacToe game = newGame();
		game.choose(TicTacToe.BoardChoice.X, 2, 0);
		game.choose(TicTacToe.BoardChoice.O, 0, 1);
		game.choose(TicTacToe.BoardChoice.X, 1, 1);
		game.choose(TicTacToe.BoardChoice.O, 0, 0);
		game.choose(TicTacToe.BoardChoice.X, 0, 2);
		return game;
	}
	private Scenario gameX20O01X11O00X02 = () -> gameX20O01X11O00X02();
		
	/**
	 * @return
	 * XXO 
	 * XXO
	 * OOX
	 */
	private TicTacToe gameX01O12X00O02X10O20X11O21X22() {
		TicTacToe game = newGame();
		game.choose(TicTacToe.BoardChoice.X, 0, 1);
		game.choose(TicTacToe.BoardChoice.O, 1, 2);
		game.choose(TicTacToe.BoardChoice.X, 0, 0);
		game.choose(TicTacToe.BoardChoice.O, 0, 2);
		game.choose(TicTacToe.BoardChoice.X, 1, 0);
		game.choose(TicTacToe.BoardChoice.O, 2, 0);
		game.choose(TicTacToe.BoardChoice.X, 1, 1);
		game.choose(TicTacToe.BoardChoice.O, 2, 1);
		game.choose(TicTacToe.BoardChoice.X, 2, 2);
		return game;
	}
	private Scenario gameX01O12X00O02X10O20X11O21X22 = () -> gameX01O12X00O02X10O20X11O21X22();
	
	/** New Game after X wins
	 * @return
	 * --- 
	 * ---
	 * ---
	 */
	private TicTacToe gameX01O12X00O02X10O20X11O21X22NewGame() {
		TicTacToe game = newGame();
		game.choose(TicTacToe.BoardChoice.X, 0, 1);
		game.choose(TicTacToe.BoardChoice.O, 1, 2);
		game.choose(TicTacToe.BoardChoice.X, 0, 0);
		game.choose(TicTacToe.BoardChoice.O, 0, 2);
		game.choose(TicTacToe.BoardChoice.X, 1, 0);
		game.choose(TicTacToe.BoardChoice.O, 2, 0);
		game.choose(TicTacToe.BoardChoice.X, 1, 1);
		game.choose(TicTacToe.BoardChoice.O, 2, 1);
		game.choose(TicTacToe.BoardChoice.X, 2, 2);
		game.newGame();
		return game;
	}
	private Scenario gameX01O12X00O02X10O20X11O21X22NewGame = () -> gameX01O12X00O02X10O20X11O21X22NewGame();

	// XXX O wins
	
	/**
	 * @return
	 * OOO
	 * XX-
	 * X--
	 */
	private TicTacToe gameX10O01X20O02X11O00() {
		TicTacToe game = newGame();
		game.choose(TicTacToe.BoardChoice.X, 1, 0);
		game.choose(TicTacToe.BoardChoice.O, 0, 1);
		game.choose(TicTacToe.BoardChoice.X, 2, 0);
		game.choose(TicTacToe.BoardChoice.O, 0, 2);
		game.choose(TicTacToe.BoardChoice.X, 1, 1);
		game.choose(TicTacToe.BoardChoice.O, 0, 0);
		return game;
	}
	private Scenario gameX10O01X20O02X11O00 = () -> gameX10O01X20O02X11O00();
	
	/**
	 * @return
	 * XX-
	 * OOO
	 * X--
	 */
	private TicTacToe gameX00O10X20O12X01O11() {
		TicTacToe game = newGame();
		game.choose(TicTacToe.BoardChoice.X, 0, 0);
		game.choose(TicTacToe.BoardChoice.O, 1, 0);
		game.choose(TicTacToe.BoardChoice.X, 2, 0);
		game.choose(TicTacToe.BoardChoice.O, 1, 2);
		game.choose(TicTacToe.BoardChoice.X, 0, 1);
		game.choose(TicTacToe.BoardChoice.O, 1, 1);
		return game;
	}
	private Scenario gameX00O10X20O12X01O11 = () -> gameX00O10X20O12X01O11();
	
	/**
	 * @return
	 * XX-
	 * X--
	 * OOO
	 */
	private TicTacToe gameX00O21X10O20X01O22() {
		TicTacToe game = newGame();
		game.choose(TicTacToe.BoardChoice.X, 0, 0);
		game.choose(TicTacToe.BoardChoice.O, 2, 1);
		game.choose(TicTacToe.BoardChoice.X, 1, 0);
		game.choose(TicTacToe.BoardChoice.O, 2, 0);
		game.choose(TicTacToe.BoardChoice.X, 0, 1);
		game.choose(TicTacToe.BoardChoice.O, 2, 2);
		return game;
	}
	private Scenario gameX00O21X10O20X01O22 = () -> gameX00O21X10O20X01O22();
	
	/**
	 * @return
	 * OX-
	 * OX-
	 * O-X
	 */
	private TicTacToe gameX22O10X11O00X01O20() {
		TicTacToe game = newGame();
		game.choose(TicTacToe.BoardChoice.X, 2, 2);
		game.choose(TicTacToe.BoardChoice.O, 1, 0);
		game.choose(TicTacToe.BoardChoice.X, 1, 1);
		game.choose(TicTacToe.BoardChoice.O, 0, 0);
		game.choose(TicTacToe.BoardChoice.X, 0, 1);
		game.choose(TicTacToe.BoardChoice.O, 2, 0);
		return game;
	}
	private Scenario gameX22O10X11O00X01O20 = () -> gameX22O10X11O00X01O20();
	
	/**
	 * @return
	 * XO-
	 * XO-
	 * -OX
	 */
	private TicTacToe gameX00O01X22O11X10O21() {
		TicTacToe game = newGame();
		game.choose(TicTacToe.BoardChoice.X, 0, 0);
		game.choose(TicTacToe.BoardChoice.O, 0, 1);
		game.choose(TicTacToe.BoardChoice.X, 2, 2);
		game.choose(TicTacToe.BoardChoice.O, 1, 1);
		game.choose(TicTacToe.BoardChoice.X, 1, 0);
		game.choose(TicTacToe.BoardChoice.O, 2, 1);
		return game;
	}
	private Scenario gameX00O01X22O11X10O21 = () -> gameX00O01X22O11X10O21();
	
	/**
	 * @return
	 * X-O
	 * XXO
	 * --O
	 */
	private TicTacToe gameX11O02X00O22X10O12() {
		TicTacToe game = newGame();
		game.choose(TicTacToe.BoardChoice.X, 1, 1);
		game.choose(TicTacToe.BoardChoice.O, 0, 2);
		game.choose(TicTacToe.BoardChoice.X, 0, 0);
		game.choose(TicTacToe.BoardChoice.O, 2, 2);
		game.choose(TicTacToe.BoardChoice.X, 1, 0);
		game.choose(TicTacToe.BoardChoice.O, 1, 2);
		return game;
	}
	private Scenario gameX11O02X00O22X10O12 = () -> gameX11O02X00O22X10O12();
	
	/**
	 * @return
	 * OX-
	 * XO-
	 * -XO
	 */
	private TicTacToe gameX01O00X10O11X21O22() {
		TicTacToe game = newGame();
		game.choose(TicTacToe.BoardChoice.X, 0, 1);
		game.choose(TicTacToe.BoardChoice.O, 0, 0);
		game.choose(TicTacToe.BoardChoice.X, 1, 0);
		game.choose(TicTacToe.BoardChoice.O, 1, 1);
		game.choose(TicTacToe.BoardChoice.X, 2, 1);
		game.choose(TicTacToe.BoardChoice.O, 2, 2);
		return game;
	}
	private Scenario gameX01O00X10O11X21O22 = () -> gameX01O00X10O11X21O22();
	
	/**
	 * @return
	 * X-O
	 * XO-
	 * OX-
	 */
	private TicTacToe gameX00O11X10O20X21O02() {
		TicTacToe game = newGame();
		game.choose(TicTacToe.BoardChoice.X, 0, 0);
		game.choose(TicTacToe.BoardChoice.O, 1, 1);
		game.choose(TicTacToe.BoardChoice.X, 1, 0);
		game.choose(TicTacToe.BoardChoice.O, 2, 0);
		game.choose(TicTacToe.BoardChoice.X, 2, 1);
		game.choose(TicTacToe.BoardChoice.O, 0, 2);
		return game;
	}
	private Scenario gameX00O11X10O20X21O02 = () -> gameX00O11X10O20X21O02();
		
	/**
	 * @return
	 * OOX 
	 * OOX
	 * XXO
	 */
	private TicTacToe gameO01X12O00X02O10X20O11X21O22() {
		TicTacToe game = newGame();
		game.choose(TicTacToe.BoardChoice.O, 0, 1);
		game.choose(TicTacToe.BoardChoice.X, 1, 2);
		game.choose(TicTacToe.BoardChoice.O, 0, 0);
		game.choose(TicTacToe.BoardChoice.X, 0, 2);
		game.choose(TicTacToe.BoardChoice.O, 1, 0);
		game.choose(TicTacToe.BoardChoice.X, 2, 0);
		game.choose(TicTacToe.BoardChoice.O, 1, 1);
		game.choose(TicTacToe.BoardChoice.X, 2, 1);
		game.choose(TicTacToe.BoardChoice.O, 2, 2);
		return game;
	}
	private Scenario gameO01X12O00X02O10X20O11X21O22 = () -> gameO01X12O00X02O10X20O11X21O22();

	/**
	 * @return
	 * OOX 
	 * OOX
	 * XXO
	 */
	private TicTacToe gameO01X12O00X02O10X20O11X21O22NewGame() {
		TicTacToe game = newGame();
		game.choose(TicTacToe.BoardChoice.O, 0, 1);
		game.choose(TicTacToe.BoardChoice.X, 1, 2);
		game.choose(TicTacToe.BoardChoice.O, 0, 0);
		game.choose(TicTacToe.BoardChoice.X, 0, 2);
		game.choose(TicTacToe.BoardChoice.O, 1, 0);
		game.choose(TicTacToe.BoardChoice.X, 2, 0);
		game.choose(TicTacToe.BoardChoice.O, 1, 1);
		game.choose(TicTacToe.BoardChoice.X, 2, 1);
		game.choose(TicTacToe.BoardChoice.O, 2, 2);
		game.newGame();
		return game;
	}
	private Scenario gameO01X12O00X02O10X20O11X21O22NewGame = () -> gameO01X12O00X02O10X20O11X21O22NewGame();

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
	 * Runs getGameState() method on a TicTacToe.
	 * @return test success
	 */
	private boolean testGameState(TicTacToe game, Result expectedResult) {
		Result result;
		try {
			if (game.getGameState() == TicTacToe.GameState.IN_PROGRESS) {
				result = Result.InProgress;
			} else if (game.getGameState() == TicTacToe.GameState.TIE) {
				result = Result.Tie;
			} else if (game.getGameState() == TicTacToe.GameState.X_WON) {
				result = Result.X;
			} else if (game.getGameState() == TicTacToe.GameState.O_WON) {
				result = Result.O;
			} else {
				result = Result.Fail;
			}
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testGameState", e.toString());
			e.printStackTrace();
			result = Result.UnexpectedException;
		}
		return result == expectedResult;
	}

	/**
	 * Runs getGameGrid() method on a TicTacToe.
	 * @return test success
	 */
	private boolean testGetGameGrid(TicTacToe game, TicTacToe.BoardChoice[][] expectedGrid) {
		Result result;
		try {
			TicTacToe.BoardChoice[][] returnedGrid = game.getGameGrid();
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
	 * Runs tests on choose() method on a TicTacToe for every position.
	 * @return test success
	 */
	private boolean testChoices(Scenario gameBuilder, TicTacToe.BoardChoice player, TicTacToe.BoardChoice lastPlayer, 
			boolean gameOver, TicTacToe.BoardChoice[][] grid) {
		boolean result = true;
		try {
			if (player == lastPlayer || gameOver) { //no positions are valid
				for (int row = 0; row < grid.length; row++) {
					for (int col = 0; col < grid[row].length; col++) {
						TicTacToe game = gameBuilder.setUpGame();
						if (game.choose(player, row, col)) {
							System.out.printf("\tchoose(%s, %d, %d) returned true, expected false\n", player, row, col);
							result = false;
						}
					}
				}
			} else { //only open positions are valid
				for (int row = 0; row < grid.length; row++) {
					for (int col = 0; col < grid[row].length; col++) {
						TicTacToe game = gameBuilder.setUpGame();
						if (grid[row][col] == TicTacToe.BoardChoice.OPEN) {
							if (game.choose(player, row, col) == false) {
								System.out.printf("\tchoose(%s, %d, %d) returned false, expected true\n", player, row, col);
								result = false;
							}
						} else if (game.choose(player, row, col) == true) {
							System.out.printf("\tchoose(%s, %d, %d) returned true, expected false\n", player, row, col);
							result = false;
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testChoices", e.toString());
			e.printStackTrace();
			result = false;
		}
		return result;
	}

//	/**
//	 * Runs choose() method on a TicTacToe. Replaced by superior testChoices() tests.
//	 * @return test success
//	 */
//	private boolean testChoose(TicTacToe game, TicTacToe.Player player, int row, int col, Result expectedResult) {
//		Result result;
//		try {
//			if (game.choose(player, row, col)) {
//				result = Result.True;
//			} else {
//				result = Result.False;
//			}
//		} catch (Exception e) {
//			System.out.printf("%s caught unexpected %s\n", "testChoose", e.toString());
//			e.printStackTrace();
//			result = Result.UnexpectedException;
//		}
//		return result == expectedResult;
//	}

	/** Confirm that the getGameGrid() method does not return a reference to instance data
	 * @return true if encapsulation has been preserved, else false
	 */
	private boolean testGetGameGridEncapsulation() {
		TicTacToe.BoardChoice[][] grid = {
				{TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN},
				{TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN},
				{TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN, TicTacToe.BoardChoice.OPEN}
		};
		boolean passed = false;
		try {
			TicTacToe game = newGame();			
			game.getGameGrid()[0][0] = TicTacToe.BoardChoice.X;
			passed = equivalentArrays(grid, game.getGameGrid());
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testGetGameGridEncapsulation", e.toString());
			e.printStackTrace();			
		}
		return passed;
	}
	
	/** Confirm that the getMoves() method does not return a reference to instance data
	 * @return true if encapsulation has been preserved, else false
	 */
	private boolean testGetMovesEncapsulation() {
		Point[] gameMoves = {new Point(0,0)};
		boolean passed = false;
		try {
			TicTacToe game = gameX00();
			game.getMoves()[0] = new Point(1,2);
			passed = equivalentArrays(gameMoves, game.getMoves());
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "testGetMovesEncapsulation", e.toString());
			e.printStackTrace();			
		}
		return passed;
	}
	
	//////////////////////////
	// XXX HELPER METHODS
	//////////////////////////

	/** Compare two two-dimensional double arrays for equivalence.
	 * @param a1 first Player[][]
	 * @param a2 second Player[][]
	 * @return true if all values in a1 and a2 are the same, else false
	 */
	private boolean equivalentArrays(TicTacToe.BoardChoice[][] a1, TicTacToe.BoardChoice[][] a2) {
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

	/** Interface for builder method Lambda references used above */
	private interface Scenario {
		TicTacToe setUpGame();
	}

}// end class TicTacToeTester
