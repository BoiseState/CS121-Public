import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Demonstrates file parsing.
 * 
 * @author marissa
 */
public class PigLatinFile {
	/**
	 * Reads sentences and translates them into Pig Latin.
	 * @param args (unused)
	 */
	public static void main(String[] args)
	{
		// Get the name of the file to translate.
		Scanner kbd = new Scanner(System.in);
		System.out.print("Enter the name of the file: ");
		String filename = kbd.nextLine().trim();
		
		// Create a scanner to read the file.
		File file = new File(filename);
		
		Scanner fileScan;
		try {
			fileScan = new Scanner(file);
			// Read the file line by line.
			// Translate each line and print result.
			String result;
			while(fileScan.hasNext())
			{
				String nextLine = fileScan.nextLine();
				result = PigLatinTranslator.translate (nextLine);
				System.out.println(result);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + filename);
		}
		kbd.close();
	}
}
