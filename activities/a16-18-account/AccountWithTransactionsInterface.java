import java.util.ArrayList;

/**
 * Lesson 16: Activity - BankAccount / Transactions
 * 
 * Interface for a financial Account that keeps a history and record of transactions
 * 
 * @author Jerry Fails
 * @version Fall 2021
 */
public interface AccountWithTransactionsInterface {


	/**
	 * Withdraws the specified amount
	 * @param amount the amount to withdraw
	 * @param description a description/reason for the withdrawal
	 * @return whether or not the withdrawal was successful
	 */
	public boolean withdraw(float amount, String description);
	
	/**
	 * Deposits the specified amount in this account.
	 * @param amount the amount to deposit
	 * @param description a description/reason for the deposit
	 * @return whether or not the deposit was successful
	 */
	public boolean deposit(float amount, String description);
	
	/**
	 * Returns a copy of the tasks ArrayList, not a reference to the internal
	 *    list of tasks.
	 * @return a copy of the tasks ArrayList.
	 */
	public ArrayList<TransactionInterface> getTransactions();
	
	/**
	 * Returns a string description of the account with 
	 * all the transactions in the list, one per line. 
	 * <pre>
	 * --------------------------------
	 * Account name: $balance
	 * --------------------------------
	 * transaction 1
	 * transaction 2
	 * transaction 3
	 * etc...
	 * </pre>
	 * @return a String representing the Account.
	 */
	public String toString();
	
}
