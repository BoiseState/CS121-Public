import java.util.Scanner;
import java.io.*;

/**
 * Demonstrates the use of Scanner to read file input and parse it 
 * using alternative delimiters.
 * 
 * @author Java Foundations
 */
public class URLDissector
{
   /**
    * Reads urls from a file and prints their path components.
    * @param args
    * @throws IOException
    */
   public static void main (String[] args) throws IOException
   {
      String url;
      Scanner fileScan, urlScan;

      fileScan = new Scanner (new File("websites.txt"));

      // Read and process each line of the file
      while (fileScan.hasNextLine())
      {
         url = fileScan.nextLine();
         System.out.println ("URL: " + url);

         urlScan = new Scanner (url);
         urlScan.useDelimiter("/");

       //doesn't work because Scanners are Iterators, but not Iterable
//         for (String s : urlScan) {
//        	 System.out.println(s);
//         }

         //  Print each part of the url
         while (urlScan.hasNext())
            System.out.println ("   " + urlScan.next());

         System.out.println();
         
      }
      fileScan.close();
   }
}
