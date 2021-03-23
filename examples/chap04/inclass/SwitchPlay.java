package inclass;

import java.util.Scanner;

public class SwitchPlay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter an option: ");
		int value = scan.nextInt();
		
//		if (value == 0) {
//			System.out.println("Found a zero: wait 300 minutes for a representative");
//		} else if (value == 1) {
//			System.out.println("You pressed 1");
//		} else if (value == 2) {
//			System.out.println("Hurray, you won a free prize!");
//		} else {
//			System.out.println("Please wait for an operator....<music>");
//		}
		
		switch (value) {
		case 0:
			System.out.println("Found a zero: wait 300 minutes for a representative");
			break;
		case 1:
			System.out.println("You pressed 1");
		case 2:
			System.out.println("Hurray, you won a free prize!");
		default:
			System.out.println("Please wait for an operator....<music>");
		}
	}
}
