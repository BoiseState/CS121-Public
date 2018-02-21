/**
 * Represents a bank account with basic services such as deposit
 * and withdraw.
 *     
 * @author Java Foundations, amit
 */

import java.text.NumberFormat;

public class Account
{
   private String name;
   private long acctNumber;
   private double balance;
   private final double RATE = 0.035;  // interest rate of 3.5%

   /**
    * Sets up this account with the specified owner, account number,
    * and initial balance
    * @param owner
    * @param account
    * @param initial
    */
   public Account(String owner, long account, double initial)
   {
      name = owner;
      acctNumber = account;
      balance = initial;
   }

   /**
    * Deposits the specified amount into this account and returns
    * the new balance. The balance is not modified if the deposit
    * amount is invalid.
    * @param amount The amount to deposit.
    * @return The account balance after the deposit is made.
    */
   public double deposit(double amount)
   {
      if (amount > 0)
         balance = balance + amount;

      return balance;
   }

   /**
    * Withdraws the specified amount and fee from this account and
    * returns the new balance. The balance is not modified if the
    * withdraw amount is invalid or the balance is insufficient.
    * @param amount The amount to withdraw (positive value)
    * @param fee The fee to apply (positive value)
    * @return The account balance after the withdraw.
    */
   public double withdraw(double amount, double fee)
   {
      if (amount + fee > 0 && amount + fee < balance)
         balance = balance - amount - fee;

      return balance;
   }

   /**
    * Adds interest to this account and returns the new balance.
    * @return The new account balance.
    */
   public double addInterest()
   {
      balance += (balance * RATE);
      return balance;
   }

   /**
    * Returns the current balance of this account.
    * @return The balance.
    */
   public double getBalance()
   {
      return balance;
   }

   /**
    * Returns a one-line description of this account as a string.
    */
   public String toString()
   {
      return String.format("%-20s %8d $%.2f", name, acctNumber, balance);
   }
}
