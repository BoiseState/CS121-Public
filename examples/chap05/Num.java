/**
 * Represents a single integer as an object.
 * 
 * @author Java Foundations
 */
public class Num
{
   private int value;

   /**
    * Sets up the new Num object, storing an initial value.
    * @param update
    */
   public Num (int update)
   {
      value = update;
   }

   /**
    * Sets the stored value to the newly specified value.
    * @param update
    */
   public void setValue (int update)
   {
      value = update;
   }

   /**
    * Returns the stored integer value as a string.
    */
   public String toString ()
   {
      return value + "";
   }
}
