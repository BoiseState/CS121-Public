import java.text.NumberFormat;

public class Product implements Comparable<Product>
{
	private static final NumberFormat COST_FMT = NumberFormat.getCurrencyInstance();
	private String name;
	private double cost;

	/**
	 * Creates a new Product.
	 * @param name The product name.
	 * @param cost The cost of the product.
	 */
	public Product(String name, double cost)
	{
		this.name = name;
		this.cost = cost;
	}

	/**
	 * Returns the name of the product.
	 * @return The name.
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Sets the name of the product.
	 * @param name The name.
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Returns the cost of the product.
	 * @return cost The cost.
	 */
	public double getCost()
	{
		return cost;
	}

	/**
	 * Updates the cost of the product.
	 * @param cost The cost.
	 */
	public void setCost(double cost)
	{
		this.cost = cost;
	}

	@Override
	public String toString()
	{
		return name + "(" + COST_FMT.format(cost) + ")";
	}

	@Override
	public int compareTo(Product other)
	{
		if(this.cost > other.getCost()) {
			return 1; // this one is greater than the other
		} else if(this.cost < other.getCost()) {
			return -1; // this one is less than the other
		} else {
			return 0; // they are equal
		}
	}
}
