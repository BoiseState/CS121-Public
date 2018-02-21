/**
 * Demonstrates formatting decimal values and creating
 * an output table using printf.
 *
 * @author Java Foundations, modified by marissa
 */
public class CircleStatsPrintfTable
{
	/**
	 * Calculates the area and circumference of a circle given its
	 * radius.
	 */
	public static void main(String[] args)
	{
		double radius1, area1, circumference1;
		double radius2, area2, circumference2;
		double radius3, area3, circumference3;

		radius1 = 1.8;
		area1 = Math.PI * Math.pow(radius1, 2);
		circumference1 = 2 * Math.PI * radius1;

		radius2 = 8.4;
		area2 = Math.PI * Math.pow(radius2, 2);
		circumference2 = 2 * Math.PI * radius2;

		radius3 = .2;
		area3 = Math.PI * Math.pow(radius3, 2);
		circumference3 = 2 * Math.PI * radius3;

		// A nicely formatted table using printf.

		// Right aligned columns (default)
		System.out.printf("Results (right aligned)\n");
		System.out.printf("--------------------------------------\n");
		System.out.printf("%4s %8s %8s %15s\n", "num", "radius", "area", "circumference");
		System.out.printf("--------------------------------------\n");
		System.out.printf("%4d %8.2f %8.2f %15.2f\n", 1, radius1, area1, circumference1);
		System.out.printf("%4d %8.2f %8.2f %15.2f\n", 2, radius2, area2, circumference2);
		System.out.printf("%4d %8.2f %8.2f %15.2f\n", 3, radius3, area3, circumference3);
		System.out.printf("\n");

		// Left aligned columns (use - sign)
//		System.out.printf("Results (left aligned)\n");
//		System.out.printf("--------------------------------------\n");
//		System.out.printf("%-4s %-8s %-8s %-15s\n", "num", "radius", "area", "circumference");
//		System.out.printf("--------------------------------------\n");
//		System.out.printf("%-4d %-8.2f %-8.2f %-15.2f\n", 1, radius1, area1, circumference1);
//		System.out.printf("%-4d %-8.2f %-8.2f %-15.2f\n", 2, radius2, area2, circumference2);
//		System.out.printf("%-4d %-8.2f %-8.2f %-15.2f\n", 3, radius3, area3, circumference3);
//		System.out.printf("\n");
	}
}
