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
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter filename: ");
		String fileName = keyboard.next();
		keyboard.close();
	
		File file = new File(fileName);
		Scanner fileScan;
		try {
			fileScan = new Scanner(file);
			int count = 0;
			while (fileScan.hasNextLine()) {
				String line = fileScan.nextLine();
				System.out.println(line);
				count++;
			}
			fileScan.close();
			System.out.println(fileName +  " has " + count + " lines");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(fileName + ": File not found!");
			//e.printStackTrace();
		}

		
	}
}
