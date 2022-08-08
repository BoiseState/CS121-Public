import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a Kennel with several Dogs.
 * @author 
 */
public class Kennel {
	
	public static void howl(ArrayList<DogInterface> kennel) {
		for (DogInterface d: kennel) {
			System.out.println(d.bark());
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//make some dogs
		
		ArrayList<DogInterface> kennel = new ArrayList<DogInterface>();
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter data file name: ");
		String fileName = keyboard.nextLine();
		keyboard.close();
		
		File dataFile = new File(fileName);
		try {
			Scanner fileScan = new Scanner(dataFile);
			
			while (fileScan.hasNextLine()) {
				
				String line = fileScan.nextLine();
				Scanner lineScan = new Scanner(line);
				lineScan.useDelimiter(",");
				
				String name = lineScan.next();
				String breed = lineScan.next();
				int age = lineScan.nextInt();
				String gender = lineScan.next();
				Dog newDog = new Dog(name, age, breed, gender);
							
				kennel.add(newDog);
				System.out.println(newDog);
				
				lineScan.close();
			}
			fileScan.close();
		} catch (IOException e) {
			System.out.println("Error in processing date file" + fileName);
			System.out.println(e);
		}
		
		howl(kennel);
	}
}
