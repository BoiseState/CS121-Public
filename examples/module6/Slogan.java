/**
 * Represents a single slogan or motto.
 * @author Java Foundations
 */
public class Slogan
{
   private String phrase;
   private static int count = 0;

   /**
    * Constructor: Sets up the slogan and increments the number of
    * instances created.
    * @param str
    */
   public Slogan(String str)
   {
      phrase = str;
      count++;
   }

   /**
    * Returns the number of instances of this class that have been
    * created.
    * @return
    */
   public static int getCount()
   {
      return count;
   }
   
   /**
    * Returns this slogan as a string.
    * @return the string representation.
    */
   public String toString()
   {
      return phrase;
   }
}
