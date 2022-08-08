import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * PP 4.18. Compare two text files line by line and print the differences.
 * @author amit
 *
 */
public class FileDiff
{
	Scanner s1;
	Scanner s2;

	/**
	 * Constructor: Create file diff using two scanners
	 * @param s1
	 * @param s2
	 */
	public FileDiff(Scanner s1, Scanner s2)
	{
		this.s1 = s1;
		this.s2 = s2;
	}
	
	/**
	 *  Compare two files line by line
	 */
	public void compareFiles() 
	{	
		int count1 = 0;
		int count2 = 0;
		
		// while we have lines left in both files, compare and 
		// print the lines that don't match
		while (s1.hasNextLine() && s2.hasNextLine()) {
			String line1 = s1.nextLine().trim(); count1++;
			String line2 = s2.nextLine().trim(); count2++;
			if (!line1.equalsIgnoreCase(line2)) {
				System.out.println("Line " + count1 + " differs.");
				System.out.println("< " + line1);
				System.out.println("> " + line2);
			} else {
				//System.out.println("Line " + count1 + " matches.");
			}
		}
		
		// any leftover lines in file1 all count as differences
		while (s1.hasNextLine()) {
			String line1 = s1.nextLine(); count1++;
			System.out.println("Line " + count1 + " differs.");
			System.out.println("< " + line1);
			System.out.println("> " );
		}
		
		// any leftover lines in file2 all count as differences
		while (s2.hasNextLine()) {
			String line2 = s2.nextLine(); count2++;
			System.out.println("Line " + count2 + " differs.");
			System.out.println("< ");
			System.out.println("> " + line2);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter filename1: ");
		String filename1 = keyboard.nextLine();
		System.out.print("Enter filename2: ");
		String filename2 = keyboard.nextLine();
		keyboard.close();
		
		File file1 = new File(filename1);
		File file2 = new File(filename2);	
		
		try {
			Scanner s1 = new Scanner(file1);
			Scanner s2 = new Scanner(file2);
			FileDiff tester = new FileDiff(s1, s2);
			tester.compareFiles();
		} 
		catch (FileNotFoundException e) 
		{
			System.err.println(e);
			System.exit(1);
		}
	}
}
