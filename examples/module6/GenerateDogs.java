import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author amit
 *
 */
public class GenerateDogs {

	private static final int RANGE = 10;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int count = 10;
		
		System.out.println("How many dogs do you want? ");
		Scanner keyboard = new Scanner(System.in);
		count = keyboard.nextInt();
		keyboard.close();
		
		ArrayList<String> nameList = new ArrayList<>();
		nameList.add("Quentin Quarantino");
		nameList.add("Bosco");
		nameList.add("Billy Bob Joe");
		nameList.add("Gary");
		nameList.add("Fido");
		nameList.add("Shasta");
		nameList.add("Spark");
		
		ArrayList<String> breedList = new ArrayList<String>();
		breedList.add("Red Doberman");
		breedList.add("Retriever");
		breedList.add("Husky");
		breedList.add("German Shepherd");
		breedList.add("Poodle");
		
		
		Random generator = new Random();
			
		File dataFile = new File("dogs.csv");
		try {
			PrintWriter out = new PrintWriter(dataFile);
			
			System.out.println("GenerateDogs: starting to generate random dogs");
			for (int i = 0; i < count; i++) {
				int index = generator.nextInt(nameList.size());
				String name = nameList.get(index);

				index = generator.nextInt(breedList.size());
				String breed = breedList.get(index);

				int age = generator.nextInt(RANGE) + 1; // 1 to 10

				String gender;
				boolean female = generator.nextBoolean();
				if (female)
					gender = "female";
				else
					gender = "male";

				out.println(name + "," + breed + "," + age + "," + gender);
				System.out.println("GenerateDogs: generated random dog# " + (i+1));
			}
			out.close();
			System.out.println("GenerateDogs: Output file is dogs.csv");
			System.out.println("GenerateDogs: done");

		} catch (IOException e) {
			System.err.println("FileWriting error:" + e);
			e.printStackTrace();
		}

	}
}
