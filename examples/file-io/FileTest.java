import java.io.File;
import java.io.IOException;

/**
 * Shows how to create a File object for given filename and to check if it
 * exists. Note that we can create a File object for a filename that doesn't
 * exist.
 * 
 * @author amit
 */
public class FileTest
{

	/**
	 * Create and return a File object for given filename.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) 
	{
		String name = "input1.txt";
		File file = new File(name);
		if (file.exists()) {
			System.out.println(file + " found!");
			System.out.println("Size (in bytes) of file " + file + " is " + file.length());
		} else {
			System.out.println(file + " not found!");
		}

	}
}
