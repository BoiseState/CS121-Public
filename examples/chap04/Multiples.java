import java.util.Scanner;

/**
 * Demonstrates the use of a for loop.
 * 
 * @author Java Foundations
 */
public class Multiples
{
   /**
    * Prints multiples of a user-specified number up to a user-specified limit.
    * @param args
    */
   public static void main (String[] args)
   {
      final int PER_LINE = 8;
      int value, limit, count = 0;

      Scanner scan = new Scanner (System.in);
      System.out.print("Enter a positive value: ");
      value = scan.nextInt();

      System.out.print("Enter an upper limit: ");
      limit = scan.nextInt();

      System.out.println();
      System.out.println("The multiples of " + value + " between " +
                       value + " and " + limit + " (inclusive) are:");
      for (int multiplier = value; multiplier <= limit; multiplier += value)
      {
         System.out.print(multiplier + "\t");

         // Print a specific number of values per line of output
         count++;
         if (count % PER_LINE == 0)
            System.out.println();
      }
      System.out.println();
      scan.close();
   }
}
