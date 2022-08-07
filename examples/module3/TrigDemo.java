import java.util.Scanner;

/**
 * Demonstrates the use of some trigonometric functions in the Math class.
 *
 * @author amit
 */
public class TrigDemo
{
	public static void main(String[] args)
	{
		double x, y, z;

		Scanner scan = new Scanner(System.in);

		System.out.println(" degrees \t radians");
		System.out.println(" 0 \t " + Math.toRadians(0));
		System.out.println(" 45 \t " + Math.toRadians(45));
		System.out.println(" 90 \t " + Math.toRadians(90));
		System.out.println(" 180 \t " + Math.toRadians(180));
		System.out.println(" 270 \t " + Math.toRadians(270));
		System.out.println(" 360 \t " + Math.toRadians(360));

		System.out.print("\nEnter the angle (in degrees): ");
		x = scan.nextInt();
		System.out.println();

		System.out.println("sin(" + x + ") = " + Math.sin(Math.toRadians(x)));
		System.out.println("cos(" + x + ") = " + Math.cos(Math.toRadians(x)));
		System.out.println("tan(" + x + ") = " + Math.tan(Math.toRadians(x)));

		System.out.println("\nFormatted output using printf\n");

		System.out.printf("sin(" + x + ") =  %3.1f \n", Math.sin(Math.toRadians(x)));
		System.out.printf("cos(" + x + ") =  %3.1f \n", Math.cos(Math.toRadians(x)));
		System.out.printf("tan(" + x + ") =  %3.1f \n", Math.tan(Math.toRadians(x)));

		scan.close();
	}
}
