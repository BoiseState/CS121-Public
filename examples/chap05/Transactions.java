/**
 * Demonstrates the creation and use of multiple Account objects.
 * 
 * @author Java Foundations
 */

public class Transactions
{
	/**
	 * Creates some bank accounts and requests various services.
	 */
   public static void main (String[] args)
   {
      Account acct1 = new Account("Elizabeth Browning", 93757, 769.32);
      Account acct2 = new Account("Mary Oliver", 72354, 725.59);
      Account acct3 = new Account("Bob Dylan", 69713, 750.00);

      acct1.deposit(44.10);  //return value is ignored

      double balance = acct2.deposit(75.25);
      System.out.println("Mary's balance after deposit: " + balance);

      System.out.println("Mary's balance after withdrawal: " + acct2.withdraw(480, 1.50));

      acct3.withdraw(-100.00, 1.50);  //invalid transaction

      acct1.addInterest();
      acct2.addInterest();
      acct3.addInterest();

      System.out.println();
      System.out.println(acct1);
      System.out.println(acct2);
      System.out.println(acct3);
   }
}
