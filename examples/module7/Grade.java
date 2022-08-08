/**
 * Represents a school grade.
 * @author Java Foundations
 */
public class Grade
{
   private String name;
   private int lowerBound;

   /**
    * Constructor: Sets up this Grade object with the specified
    * grade name and numeric lower bound.
    * @param grade
    * @param cutoff
    */
   public Grade(String grade, int cutoff)
   {
      name = grade;
      lowerBound = cutoff;
   }

   /**
    * Returns a string representation of this grade.
    */
   public String toString()
   {
      return name + "\t" + lowerBound;
   }

   /**
    * Sets the name of the grade.
    * @param grade
    */
   public void setName(String grade)
   {
      name = grade;
   }

   /**
    * Sets the lower bound cutoff
    * @param cutoff
    */
   public void setLowerBound(int cutoff)
   {
      lowerBound = cutoff;
   }

   /**
    * Returns the name.
    * @return
    */
   public String getName()
   {
      return name;
   }

   /**
    * Returns the lower bound.
    * @return
    */
   public int getLowerBound()
   {
      return lowerBound;
   }
}
