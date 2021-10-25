import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Scanner;

public interface FileIOInterface
{
	public void save(PrintWriter fileWriter) throws FileNotFoundException;
	public void parse(Scanner fileScanner) throws FileNotFoundException, ParseException;
}
