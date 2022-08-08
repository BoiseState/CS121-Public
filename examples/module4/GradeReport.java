import java.util.Scanner;

/**
 * Demonstrates the use of a switch statement.
 * 
 * @author Java Foundations
 */
public class GradeReport
{
   /**
    * Reads a grade from the user and prints comments accordingly.
    * @param args
    */
   public static void main (String[] args)
   {
      int grade, category;

      Scanner scan = new Scanner (System.in);

      System.out.print ("Enter a numeric grade (0 to 100): ");
      grade = scan.nextInt();
   
      category = grade / 10;

      System.out.print ("That grade is ");
      
      switch (category)
      {
         case 10:
         case 9:
            System.out.println ("well above average. Excellent.");
            break;
         case 8:
            System.out.println ("above average. Nice job.");
            break;
         case 7:
            System.out.println ("average.");
            break;
         case 6:
            System.out.println ("below average. Please see the "
            		+ "instructor for assistance.");
            break;
         default:
            System.out.println ("not passing. Please see the "
            		+ "instructor for assistance.");
      }
      

      scan.close();
   }
}
