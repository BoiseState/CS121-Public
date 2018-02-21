package inclass;

import java.awt.Color;

/**
 * Demonstrates == equality operator vs equals.
 * 
 * @author CS121 Instructors
 */
public class ColorCompare
{
	public static void main(String[] args)
	{
		Color turtleGreen = new Color(63, 163, 44);
		Color grassGreen = turtleGreen;
		System.out.println(turtleGreen == grassGreen); // true
		
		Color treeGreen = new Color(63, 163, 44);
		System.out.println(turtleGreen == treeGreen); // false
		
		System.out.println(turtleGreen.equals(treeGreen)); // false
	}
}
