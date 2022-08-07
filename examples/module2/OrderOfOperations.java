/**
 * OrderOfOperations.java demonstrates the effect of order of operations
 * on the outcome of evaluating expressions
 * 
 * @author sfrost
 *
 */
public class OrderOfOperations {
	public static void main(String[] args) {
	
		int x = 0;
		int y = 1;
		int z = 2;
	
		double p = 3.0;
		double q = 4.0;
		double r = 5.0;
	
		// Order of operations makes a difference.  Try to determine before
		// running the program what the result of each expression is.
		// Remember - when in doubt, use parentheses!
		
		double out1 = z + x * y + q - -r / p * 2;
		double out2 = (z + x * y + q - -r) / (p * 2);
		double out3 = (z + x * y + q - -r / p) * 2;
		double out4 = (z + x) * (y + q) - -(r / p * 2);
		double out5 = z + (x * (y + q - -r / p * 2));
		double out6 = ((z + (x * y)) + q) - (((-r) / p) * 2);
		
		
		System.out.println("out1 = " + out1);
		System.out.println("out2 = " + out2);
		System.out.println("out3 = " + out3);
		System.out.println("out4 = " + out4);
		System.out.println("out5 = " + out5);
		System.out.println("out6 = " + out6);

		System.out.println("**********");
		// This section demonstrates how to use increment and decrement operators
		System.out.print("x = " + x);
		x +=1; // increment x by 1
		System.out.print(", x = " + x);
		//You can increment by any value
		x += 5;
		System.out.println(", x = " + x);
		
	
		System.out.print("p = " + p);
		p -=1; // decrement z by 1
		System.out.print(", p = " + p);
		// and you can decrement by any amount
		p -= 5.5;
		System.out.println(", p = " + p);
		
		//Question - what happens if you increment/decrement an integer
		// by a decimal amount?

	}	
	
}
