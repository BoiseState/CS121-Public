import java.text.NumberFormat;

/**
 * Represents a collection of compact discs.
 * @author Java Foundations
 * ******************************************************************
 */
public class CDCollection
{
   private CD[] collection;
   private int count;
   private double totalCost;

   /**
    * Constructor: Creates an initially empty collection.
    */
   public CDCollection()
   {
      collection = new CD[100];
      count = 0;
      totalCost = 0.0;
   }

   /**
    * Adds a CD to the collection, increasing the size of the
    * collection if necessary.
    * @param title
    * @param artist
    * @param cost
    * @param tracks
    */
   public void addCD(String title, String artist, double cost,
                      int tracks)
   {
      if (count == collection.length)
         increaseSize();

      collection[count] = new CD(title, artist, cost, tracks);
      totalCost += cost;
      count++;
   }

   /**
    * Returns a report describing the CD collection.
    */
   public String toString()
   {
      NumberFormat fmt = NumberFormat.getCurrencyInstance();

      String report = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
      report += "My CD Collection\n\n";

      report += "Number of CDs: " + count + "\n";
      report += "Total cost: " + fmt.format(totalCost) + "\n";
      report += "Average cost: " + fmt.format(totalCost/count);

      report += "\n\nCD List:\n\n";

      for (int cd = 0; cd < count; cd++)
         report += collection[cd].toString() + "\n";

      return report;
   }

   /**
    * Increases the capacity of the collection by creating a
    * larger array and copying the existing collection into it.
    */
   private void increaseSize()
   {
      CD[] temp = new CD[collection.length * 2];

      for (int cd = 0; cd < collection.length; cd++)
         temp[cd] = collection[cd];

      collection = temp;
   }
}
