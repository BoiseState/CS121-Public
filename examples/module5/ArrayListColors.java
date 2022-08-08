
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Demonstrates the use of an ArrayList object with Color objects.
 * 
 * @author CS 121 Instructors
 * 
 */
public class ArrayListColors 
{
	/**
	 * Randomly generates and stores a list of Color objects, and
	 * then finds the color with the greatest red value.
	 * 
	 * @param args
	 */
	public static void main(String [] args)
	{
		ArrayList<Color> myColors = new ArrayList<Color>();
		Random generator = new Random();
		final int MAX_NUM_COLORS = 100;
		final int MAX_COLOR_VALUE = 256;
		
		/* Randomly generate 100 colors, then add to array list */
		for(int i = 0; i < MAX_NUM_COLORS; i++)
		{
			int r = generator.nextInt(MAX_COLOR_VALUE);
			int g = generator.nextInt(MAX_COLOR_VALUE);
			int b = generator.nextInt(MAX_COLOR_VALUE);
			
			Color tempColor = new Color(r, g, b);
			myColors.add(tempColor);
			//System.out.printf("Added color with values (%d, %d, %d)\n", r, g, b);
		}
		
		Color maxBlue = myColors.get(0);
		for (Color c: myColors) {
			if (c.getBlue() > maxBlue.getBlue())
				maxBlue = c;
		}
		System.out.println("Bluest random color: " + maxBlue);
		
		maxBlue = myColors.get(0);
		for (int i = 1; i < myColors.size(); i++) {
			if (myColors.get(i).getBlue() > maxBlue.getBlue())
				maxBlue = myColors.get(i);
		}
		System.out.println("Bluest random color: " + maxBlue);
		
		maxBlue = myColors.get(0);
		Iterator<Color> iter = myColors.iterator();
		while (iter.hasNext()) {
			Color c = iter.next();
			if (c.getBlue() > maxBlue.getBlue())
				maxBlue = c;
		}
		System.out.println("Bluest random color: " + maxBlue);

		
//		for (Color c: myColors) {
//			System.out.println(c);
//		}
		
		/* Find the color with the biggest red value and print it */
		
	}
}
