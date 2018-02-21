import java.util.Scanner;

/**
 * Demonstrates the use of nested while loops.
 * @author Java Foundations
 */
public class PalindromeTester
{
   /**
    * Tests strings to see if they are palindromes.
    * @param args
    */
   public static void main (String[] args)
   {
      String str, another = "y";
      int left, right;

      Scanner scan = new Scanner (System.in);

      while (another.equalsIgnoreCase("y")) // allows y or Y
      {
         System.out.println ("Enter a potential palindrome:");
         str = scan.nextLine();
         str = str.toLowerCase();

         left = 0;
         right = str.length() - 1;

         while (str.charAt(left) == str.charAt(right) && left < right)
         {
            left++;
            right--;
         }

         System.out.println();

         if (left < right)
            System.out.println ("That string is NOT a palindrome.");
         else
            System.out.println ("That string IS a palindrome.");

         System.out.println();
         System.out.print ("Test another palindrome (y/n)? ");
         another = scan.nextLine();
      }
      scan.close();
   }
}
