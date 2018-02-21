import java.util.ArrayList;
import java.util.Collections;

public class ShoppingCart
{
	public static void main(String[] args)
	{
		ArrayList<Product> cart = new ArrayList<Product>();
		
		cart.add(new Product("Toothbrush", 2.59));
		cart.add(new Product("Hairbrush", 2.59));
		cart.add(new Product("Trident Gum", 1.99));
		cart.add(new Product("Pop Tarts", 3.99));

		System.out.println("=====================");
		System.out.println("Unsorted");
		System.out.println("=====================");
		for(Product item : cart)
		{
			System.out.println(item);
		}

		Collections.sort(cart);

		System.out.println("=====================");
		System.out.println("Sorted");
		System.out.println("=====================");
		for(Product item : cart)
		{
			System.out.println(item);
		}
	}
}
