import java.text.NumberFormat;

/**
 * Represents a collection of DVD movies.
 * 
 * @author Lewis/Loftus/amit
 * 
 */
public class DVDCollection
{
	private DVD[] collection;
	private int count;
	private double totalCost;
	private final int USER_DEFINED_INITIAL_SIZE = 100;

	/**
	 * Constructor: Creates an initially empty collection.
	 */
	public DVDCollection()
	{
		collection = new DVD[USER_DEFINED_INITIAL_SIZE];
		count = 0;
		totalCost = 0.0;
	}

	/**
	 * Adds a DVD to the collection, increasing the size of the collection array
	 * if necessary.
	 * 
	 * @param title
	 * @param director
	 * @param year
	 * @param cost
	 * @param bluRay
	 */
	public void addDVD(String title, String director, int year, double cost,
			boolean bluRay)
	{
		if (count == collection.length)
			increaseSize();

		collection[count] = new DVD(title, director, year, cost, bluRay);
		totalCost += cost;
		count++;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		NumberFormat fmt = NumberFormat.getCurrencyInstance();

		String report = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
		report += "My DVD Collection\n\n";

		report += "Number of DVDs: " + count + "\n";
		report += "Total cost: " + fmt.format(totalCost) + "\n";
		report += "Average cost: " + fmt.format(totalCost / count);

		report += "\n\nDVD List:\n\n";

		for (int dvd = 0; dvd < count; dvd++)
			report += collection[dvd].toString() + "\n";

		return report;
	}


	/**
	 * Increases the capacity of the collection by creating a 
	 * larger array and copying the existing collection into it.
	 */
	private void increaseSize()
	{
		DVD[] temp = new DVD[collection.length * 2];

		for (int dvd = 0; dvd < collection.length; dvd++)
			temp[dvd] = collection[dvd];

		collection = temp;
	}
}
