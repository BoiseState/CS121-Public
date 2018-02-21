import java.util.Scanner;
/**
 * Demonstrates array index processing.
 * @author Java Foundations
 */
public class ReverseOrder
{
   /**
    * Reads a list of numbers from the user, storing them in an
    * array, then prints them in the opposite order.
    * @param args
    */
   public static void main(String[] args)
   {
      Scanner scan = new Scanner(System.in);

      double[] numbers = new double[10];

      System.out.println("The size of the array: " + numbers.length);

      for (int index = 0; index < numbers.length; index++)
      {
         System.out.print("Enter number " + (index+1) + ": ");
         numbers[index] = scan.nextDouble();
      }
      
      System.out.println("The numbers in reverse order:");

      for (int index = numbers.length-1; index >= 0; index--)
         System.out.print(numbers[index] + "  ");
      
      scan.close();
   }
}
