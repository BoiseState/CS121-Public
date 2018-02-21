package inclass;

import java.util.Scanner;

/**
 * Demonstrates how to compare double values within a specified 
 * tolerance.
 * 
 * @author CS121 Instructors
 */
public class DoubleCompareWithTolerance
{
	public static void main(String[] args)
	{
		final double EXPECTED_LENGTH = 80.50; //mm
		final double TOLERANCE = 0.5; //mm
		
		Scanner kbd = new Scanner(System.in);
		
		System.out.print("Enter measured bolt length (mm): ");
		double measured = kbd.nextDouble();
		
		System.out.println("---- Compare using == ----");
		if(measured == EXPECTED_LENGTH) {
			System.out.println("Good bolt. Okay to distribute.");
		} else {
			System.out.println("Bad bolt. Please discard and re-calibrate.");
		}
		
		System.out.println("---- Compare using tolerance ----");
		if(Math.abs(measured - EXPECTED_LENGTH) < TOLERANCE) {
			System.out.println("Good bolt. Okay to distribute.");
		} else {
			System.out.println("Bad bolt. Please discard and re-calibrate.");
		}
		
		kbd.close();
	}
}
