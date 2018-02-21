import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * An example of reading a text file line by line.
 * @author amit
 *
 */
public class FileReading
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter filename: ");
		String fileName = keyboard.next();
		keyboard.close();
	
		File file = new File(fileName);
		Scanner fileScan = new Scanner(file);

		int count = 0;
		while (fileScan.hasNextLine()) {
			String line = fileScan.nextLine();
			//System.out.printf("line %3d: %s\n", count, line);
			Scanner lineScan = new Scanner(line);
			while (lineScan.hasNext()) {
				String token = lineScan.next();
				System.out.println(token);
			}
			count++;
		}
		fileScan.close();
	}
}
