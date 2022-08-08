import java.util.ArrayList;

public class Rookery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Penguin penguin1 = new Penguin("Danny", 53, 54);
		Penguin penguin2 = new Penguin("Lovelace", 38, 5);
		Penguin penguin3 = new Penguin("Zeke", 70, 20);
		Penguin penguin4 = new Penguin("Linooks", 17);
		Penguin penguin5 = new Penguin("Linooks", 18);
		Penguin penguin6 = penguin4;
		
		
//		System.out.println(penguin1);
//		System.out.println(penguin2);
//		System.out.println(penguin3);
//		System.out.println(penguin4);
//		System.out.println();
		
		ArrayList<Penguin> rookery = new ArrayList<Penguin>();
		rookery.add(penguin1);
		rookery.add(penguin2);
		rookery.add(penguin3);
		rookery.add(penguin4);
		
		for (Penguin p: rookery) {
			System.out.println(p);
		}
		
//		for (int i = 0; i < rookery.size(); i++) {
//			System.out.println(rookery.get(i));
//		}
		
		Penguin max = penguin1;;
		for (Penguin p: rookery) {
			if (max.getHeight() < p.getHeight())
				max = p;
		}
		System.out.println("Tallest penguin = " + max);


		if (penguin4.equals(penguin5)) {
			System.out.println("Penguin4 and Penguin5 are equal");
		}
		
		if (penguin4.equals(penguin6)) {
			System.out.println("Penguin4 and Penguin6 are equal");
		}
		
		if (penguin4.equals(penguin1)) {
			System.out.println("Penguin4 and Penguin1 are equal");
		} else {
			System.out.println("Penguin4 and Penguin1 are not equal");
		}
		
		if (penguin2.compareTo(penguin1) < 0) {
			System.out.println("Penguin2 is shorter than Penguin1");
		}
		
		penguin1.waddle();
		penguin2.swim();

	}

}
