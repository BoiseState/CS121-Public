import java.awt.Point;
import java.text.DecimalFormat;
import java.util.Random;

/**
 * Using the Point class from java.awt
 * 
 * @author tcole
 * 
 */
public class UsePoint
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Point pt1, pt2;
		DecimalFormat df = new DecimalFormat("0.0");
		int dx, dy;
		double distance;

		Random rg = new Random();

		pt1 = new Point(rg.nextInt(21), rg.nextInt(21));
		pt2 = new Point();

		System.out.println("Point 1 = " + pt1);
		System.out.println("Point 2 = " + pt2);

		do {
			pt2.x = rg.nextInt(21);
			pt2.y = rg.nextInt(21);
			dx = pt1.x - pt2.x;
			dy = pt1.y - pt2.y;
			distance = Math.hypot(dx, dy);
			System.out.println("Point 2 = " + pt2 + " is "
					+ df.format(distance) + " from Point 1");
		} while (distance > 5);

	}

}
