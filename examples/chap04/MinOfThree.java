import java.util.Scanner;

/**
 * Demonstrates the use of nested if statements.
 * 
 * @author Java Foundations, marissa, mvail
 */
public class MinOfThree 
{
	/**
	 * Reads three integers from the user and determines the smallest value.
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		int num1, num2, num3, min = 0;

		Scanner scan = new Scanner(System.in);

		System.out.print("Enter three integers: ");
		num1 = scan.nextInt();
		num2 = scan.nextInt();
		num3 = scan.nextInt();
		scan.close();

		// technique 1
		min = Integer.MAX_VALUE;
		if (num1 < num2)
			if (num1 < num3)
				min = num1;
			else
				min = num3;
		else if (num2 < num3)
			min = num2;
		else
			min = num3;
		System.out.println("Technique 1 - Minimum value: " + min);

		// technique 2 (which has a sneaky bug - 
		// what if you entered 3 3 4, for example?)
		min = Integer.MAX_VALUE;
		if ((num1 < num2) && (num1 < num3)) {
			min = num1;
		}
		if ((num2 < num3) && (num2 < num1)) {
			min = num2;
		}
		if ((num3 < num2) && (num3 < num1)) {
			min = num3;
		}
		System.out.println("Technique 2 - Minimum value: " + min);
		
		// technique 3 (using conditional operator)
		min = Integer.MAX_VALUE;
		min = ((num1 < num2) ? num1 : num2);
		min = ((min < num3) ? min : num3);
		System.out.println("Technique 3 - Minimum value: " + min);

		// technique 4
		min = Math.min(num1, num2);
		min = Math.min(min, num3);
		System.out.println("Technique 4 - Minimum value: " + min);
	}
}
