import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
	Demonstrates how to write a text file.
	@author amit
*/
public class FileWriting
{
	public static void main (String[] args) 
	{
		System.out.println();
		System.out.println("FileWriting: starting to write to file named out.txt");
		System.out.println();

		File file = new File("out.txt");
		PrintWriter fileWriter;
		try {
			fileWriter = new PrintWriter(file);
			double x = Math.PI;
			fileWriter.println("some random output");
			fileWriter.println(x);
			fileWriter.println();
			fileWriter.printf("double value z = %3.2f\n", x);
			fileWriter.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.err.println("FileWriting error:" + e);
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("FileWriting: finished writing to file named out.data ");
		System.out.println();
	}
}
