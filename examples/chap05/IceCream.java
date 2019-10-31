/**
 * Demonstrates the use of enumerated types.
 *
 * @author Java Foundations
 */
public class IceCream
{
	public enum Flavor
	{
		VANILLA,
		CHOCOLATE,
		STRAWBERRY,
		FUDGE_RIPPLE,
		COFFEE,
		ROCKY_ROAD,
		MINT_CHOCOLATE_CHIP,
		COOKIE_DOUGH
	}

	/**
	 * Creates and uses variables of the Flavor type.
	 */
	public static void main(String[] args) {

		Flavor cone1, cone2, cone3;

		cone1 = Flavor.ROCKY_ROAD;
		cone2 = Flavor.CHOCOLATE;

		System.out.println("cone1 value: " + cone1);
		System.out.println("cone1 ordinal: " + cone1.ordinal());
		System.out.println("cone1 name: " + cone1.name());

		System.out.println();
		System.out.println("cone2 value: " + cone2);
		System.out.println("cone2 ordinal: " + cone2.ordinal());
		System.out.println("cone2 name: " + cone2.name());

		cone3 = cone1;

		System.out.println();
		System.out.println("cone3 value: " + cone3);
		System.out.println("cone3 ordinal: " + cone3.ordinal());
		System.out.println("cone3 name: " + cone3.name());
	}
}
