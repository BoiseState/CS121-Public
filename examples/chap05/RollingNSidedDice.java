/**
  RollingNSidedDice.java       Author: amit

  Demonstrates the creation and use of n-sided dice.
*/

public class RollingNSidedDice
{
	/**
	  Creates two Die objects and rolls them several times.
	*/
	public static void main (String[] args)
	{
		NSidedDie die1, die2;
		int sum;

		die1 = new NSidedDie(); //default is 6-sided die
		die2 = new NSidedDie(1000000); //a 20-sided die, try a 1000000!
		System.out.println("Die 1: " + die1);
		System.out.println("Die 2: " + die2);

		die1.roll(); die2.roll();
		System.out.println ("Die 1: " + die1.getFaceValue() + ", Die 2: " + die2.getFaceValue());

		die1.roll(); die2.roll();
		System.out.println ("Die 1: " + die1.getFaceValue() + ", Die 2: " + die2.getFaceValue());

		die1.roll(); die2.roll();
		System.out.println ("Die 1: " + die1.getFaceValue() + ", Die 2: " + die2.getFaceValue());

		die1.roll();
		die2.setFaceValue(4);
		System.out.println ("Die 1: " + die1.getFaceValue() + ", Die 2: " + die2.getFaceValue());

		sum = die1.getFaceValue() + die2.getFaceValue();
		System.out.println ("Sum: " + sum);

		sum = die1.roll() + die2.roll();
		System.out.println ("Die 1: " + die1.getFaceValue() + ", Die 2: " + die2.getFaceValue());
		System.out.println ("New sum: " + sum);
	}
}
