
import java.awt.Color;
import java.util.ArrayList;
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
			System.out.printf("Added color with values (%d, %d, %d)\n", r, g, b);
		}
		
		/* Find the color with the biggest red value and print it */
		int maxRed = 0;
		for(Color colorIndex : myColors)
		{
			if(colorIndex.getRed() > maxRed)
			{
				maxRed = colorIndex.getRed();
				System.out.println("Updating max red value to: " + maxRed);
			}
		}
		
		System.out.println("Maximum red color is: " + maxRed);
	}
}
