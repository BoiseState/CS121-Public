/**
 * Demonstrates the use of an array of objects.
 * @author Java Foundations
 */
public class GradeRange
{
   /**
    * Creates an array of Grade objects and prints them.
    * @param args
    */
   public static void main(String[] args)
   {
      Grade[] grades =
      {
         new Grade("A", 95), new Grade("A-", 90),
         new Grade("B+", 87), new Grade("B", 85), new Grade("B-", 80),
         new Grade("C+", 77), new Grade("C", 75), new Grade("C-", 70),
         new Grade("D+", 67), new Grade("D", 65), new Grade("D-", 60),
         new Grade("F", 0)
      };

      for (Grade letterGrade : grades)
         System.out.println(letterGrade);
   }
}
