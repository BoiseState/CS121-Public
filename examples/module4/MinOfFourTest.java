/**
 * Test driver for MinOfFour class.
 * Equivalent to the shell script testMinOfFour.sh
 * 
 * @author amit
*/
public class MinOfFourTest {
	
	public static final int NUM = 4;

	/**
	 * Run one test.
	 * @param num1 The first number.
	 * @param num2 The second number.
	 * @param num3 The third number.
	 * @param num4 The fourth number.
	 * @return the min of the four input numbers.
	 */
	public static boolean runOneTest(int num1, int num2, int num3, int num4)
	{
		int answerA = MinOfFour.minA(num1, num2, num3, num4);
		int answerB = MinOfFour.minB(num1, num2, num3, num4);
		int answerC = MinOfFour.minC(num1, num2, num3, num4);
		int answerD = MinOfFour.minD(num1, num2, num3, num4);
		int answerE = MinOfFour.minE(num1, num2, num3, num4);
		int answerF = MinOfFour.minF(num1, num2, num3, num4);
		int answer = Math.min(Math.min(num1, num2), Math.min(num3, num4));

		return ((answerA == answerB) && (answerB == answerC) && (answerC == answerD)
		        && (answerD == answerE) && (answerE == answerF) && (answerF == answer));
	}

	/**
	 * Run all possible tests on combinations of 1..NUM
	 */
	public static void runAllTests()
	{
		for (int i=1; i<=NUM; i++)
			for (int j=1; j<=NUM; j++)
				for (int k=1; k<=NUM; k++)
					for (int l=1; l<=NUM; l++)
					{
						System.out.print("Testing "+i+" "+j+" "+k+" "+l);
						if (runOneTest(i, j, k, l)) 
							System.out.println(" PASSED");
						else
							System.out.println(" FAILED");
					}
	}

	/**
	 * Runs the tests.
	 * @param args
	 */
	public static void main(String [] args)
	{
		runAllTests();
	}

}
