import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Prompt for a file to read. Read the file one line at a time, break each line into 
 * individual tokens (words), and output all tokens to the console, one token per output line.
 * 
 * @author mvail
 */
public class ListFileWords {

	public static final int ERROR_CODE = 1;

	/**
	 * @param args unused
	 */
	public static void main(String[] args) {

		//create a keyboard Scanner
		//Note - there should only be ONE Scanner connected to any one source in any program
		
		Scanner kbd = new Scanner(System.in);
		
		System.out.print("Enter a filename: ");
		String filename = kbd.nextLine().trim(); //trim removes extra whitespace
		kbd.close(); // we are done reading from user.
		
		//create a File object
		//Note - this will not throw an Exception if the file doesn't exist, 
		//because you may be wanting to create a new file!

		File file = new File(filename);
		
		//open the file in a Scanner
		//Note - opening a File has the potential to fail (the file might not exist, you might not have permission
		// to read the file, etc.) so Java requires you to deal with the FileNotFoundException that could be thrown
		// if you can't open the File for any reason. We are demonstrating the try-catch way of handling Exceptions
		// here, because it allows you to print a helpful message before exiting rather than letting the program crash.

		try {
			Scanner fileScan = new Scanner(file);

			//if we succeeded in opening the File in fileScan, we can continue, here - otherwise we will catch the
			// FileNotFoundException in the catch block, below
			
			System.out.println("\nContents of \"" + filename + "\":\n");
			
			//read in each line of the file with fileScan until we run out of lines
			//Note - if our intent is to read whole lines, it is important that we use the hasNextLine() and nextLine()
			//methods rather than the hasNext() and next() methods, // which give us only one token (word) at a time - 
			//mixing these kinds of methods with a single Scanner leads to trouble

			while (fileScan.hasNextLine()) {
				//read one line
				String line = fileScan.nextLine();
				
				//create an additional Scanner to break the current line into individual tokens (words) 
				//separated by whitespace
				
				Scanner lineScan = new Scanner(line);
				
				//read each token from the line until we run out of tokens

				while (lineScan.hasNext()) {
					//read the next token/word
					String token = lineScan.next();
					
					//print the token/word to the console
					System.out.println(token);
				}
				
				// We are done reading the line, so close the scanner.
				lineScan.close();
			}
			// We are done reading the file, so close the scanner.
			fileScan.close();
		} catch (FileNotFoundException errorObject) {

			//print a helpful message before exiting
			//Note - we only get into this block of code if a FileNotFoundException was thrown while trying to open
			// the file in fileScan, above

			System.out.println("File \"" + filename + "\" could not be opened.");
			System.out.println(errorObject.getMessage());
			System.exit(ERROR_CODE); // exit the program with an error status
		}
	}
}
