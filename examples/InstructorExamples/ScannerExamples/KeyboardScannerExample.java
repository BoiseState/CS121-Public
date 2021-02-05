import java.util.Scanner;

/**
 * Demonstration of the preferred way to use a Scanner.
 * This example is reading from the keyboard, but the
 * same concepts will apply when we begin reading from
 * files.
 * 
 * Scanners are extremely useful for reading data from
 * text sources including the keyboard, Strings, and
 * text files. You can have multiple Scanners working at
 * the same time in a program, but there should never be
 * more than one Scanner connected to the same source.
 * e.g. There should only be one Scanner connected to the
 * keyboard.
 * When you are done with a Scanner, you should close it.
 * 
 * @author mvail
 */
public class KeyboardScannerExample {

	public static void main(String[] args) {
		//Create a new Scanner connected to the keyboard - System.in
		//Note that Scanner must be imported from the java.util package
		//before it can be used. (See the import at the top of the file.)
		Scanner kbd = new Scanner(System.in);
		
		//The only way a user is going to know what they are supposed
		//to type is if you tell them. Print a good prompt for what
		//you expect. Note that I'm using the print() method to stay
		//on the same line.
		System.out.print("Enter your age in years: ");
		
		//Here is the very important part: ALWAYS read a whole line
		//at a time from the keyboard or from a file using the nextLine()
		//method. Only the Scanner's nextLine() method consumes the newline
		//character that ends a line. If you use any of the other next___()
		//methods to read directly from the keyboard or file, you will lose
		//the ability to recognize how many lines of input have been read or
		//use the nextLine() method again because unconsumed newlines will 
		//have stacked up at the front of the input stream.
		//Save yourself untold frustration by ALWAYS reading from the
		//keyboard or file with nextLine().
		String input = kbd.nextLine();
		
		//nextLine() returns a String, but we can use the "wrapper classes"
		//associated with each primitive data type to "parse", or interpret,
		//a String to get a primitive type.
		int age = Integer.parseInt(input);
		
		//What if you have multiple pieces of data in the same line of input?
		//You can use a second Scanner to break a String into "tokens". By
		//default, Scanners split Strings using whitespace "delimiters" - any
		//spaces, tabs, or newlines. When parsing a String that you got from
		//nextLine(), you are free to use the next___() methods to get data
		//because you are only looking at one line with no newlines.
		System.out.print("Enter your first name and as many digits of PI as you remember: ");
		input = kbd.nextLine();
		Scanner lineScan = new Scanner(input); //second Scanner to read the line
		String name = lineScan.next();
		double pi = lineScan.nextDouble();
		//or
		//double pi = Double.parseDouble(lineScan.next());
		
		//We are finished with lineScan, so close it.
		lineScan.close();
		//We are also finished with kbd, so close it, also.
		kbd.close();
		
		//Finally, we will print a parting message.
		System.out.println("Oh, " + name + ". By age " + age +
				", shouldn't you know more of pi than " + pi + "?");
	}

}
