import java.util.Scanner;
/**
 * Demonstrates the use of an if statement.
 * 
 * @author Java Foundations, marissa
 */
public class AgePhrases
{
   /**
    * Reads the user's age and prints comments accordingly.
    * @param args
    */
   public static void main (String[] args)
   {
      final int MINOR = 21;

      Scanner scan = new Scanner (System.in);

      System.out.print ("Enter your age: ");
      int age = scan.nextInt();
      
      scan.close(); // Close the scanner because we are done reading input.
      
      System.out.print ("You are " + age + ". ");
      
      if (age < MINOR) // <21
      {
         System.out.println ("Youth is a wonderful thing. Enjoy.");
      }
      else if ( age == MINOR ) // 21
      {
    	  System.out.println ("Make sure you are doing your homework!"); 
      }
      else // >21
      {
    	  System.out.println ("Age is a state of mind.");
      }
      
      // Always printed because outside of conditional statement.
      System.out.println ("It doesn't matter how old you are.");
   }
}
