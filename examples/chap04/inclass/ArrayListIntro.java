package inclass;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * Introduction to ArrayLists through annotated code.
 * 
 * @author mvail
 */
public class ArrayListIntro {

	/** @param args unused */
	public static void main(String[] args) {
		//A list holds multiple object references
		// of a specified type, declared when you
		// create the list.
		//You can think of it as a collection of
		// multiple numbered variables of the same
		// type.
		//You do not need to know in advance how
		// many references you will need. The list
		// will manage the collection for you.
		
		//declares a reference to a list of Colors,
		// but there is no list, yet
		ArrayList<Color> rainbow;
		
		//actually creates a list and stores its
		// location in the reference
		rainbow = new ArrayList<Color>();
		
		//the add(E element) method adds an element 
		// to the end of the list
		Color myColor = new Color(63, 127, 255);
		rainbow.add(myColor); //add an existing Color
		rainbow.add(new Color(255, 127, 63)); //add a new Color
		
		//you can always ask a list for its current
		// size and whether or not it is empty
		System.out.println("Current size: " + rainbow.size());
		System.out.println("Is it empty? " + rainbow.isEmpty());
		
		System.out.println(); //blank line for output

		//elements in a list can be accessed by their
		// index positions, beginning with the first
		// element at index 0
		//the last valid index is size() - 1
		Color first = rainbow.get(0);
		Color last = rainbow.get(rainbow.size() - 1);
		System.out.println("first color: " + first);
		System.out.println("last color: " + last);
		
		System.out.println(); //blank line for output
		
		//it is common to work with lists in loops,
		// both for adding elements and for accessing
		// them again later
		Random rand = new Random();
		for (int i = 0; i < 3; i++) { //add 3 random Colors
			int red = rand.nextInt(256);
			int green = rand.nextInt(256);
			int blue = rand.nextInt(256);
			rainbow.add(new Color(red, green, blue));
		}
		System.out.println("After adding several random colors:");
		for (int i = 0; i < rainbow.size(); i++) { //print all colors
			System.out.println(rainbow.get(i));
		}

		System.out.println(); //blank line for output

		//lists, like other Java collections, are
		// "Iterable", which makes them usable in
		// a special kind of loop called a for-each
		// loop
		System.out.println("Same list accessed in a for-each loop:");
		for (Color c : rainbow) { //read "for each Color in rainbow"
			System.out.println(c);
		}
	}

}
