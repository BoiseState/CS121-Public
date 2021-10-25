/**
 * Lesson 16: Activity - BankAccount / Transactions
 * 
 * Interface for a financial Account
 * 
 * @author Jerry Fails
 * @version Fall 2021
 */
public interface AccountInterface {

	
	/**
	 * Returns the number of this account.
	 * @return the account number.
	 */
	public String getNumber();

	/**
	 * Returns the name of this account.
	 * @return the name.
	 */
	public String getName();

	/**
	 * Returns the balance of this account.
	 * @return the balance.
	 */
	public float getBalance();
	
	/**
	 * Withdraws the specified amount
	 * @param amount the amount to withdraw
	 * @return whether or not the withdrawal was successful
	 */
	public boolean withdraw(float amount);

	/**
	 * Deposits the specified amount in this account.
	 * @param amount the amount to deposit
	 * @return whether or not the deposit was successful
	 */
	public boolean deposit(float amount);

	/**
	 * Returns a string description of the account. 
	 * <pre>
	 * Account name: $balance
	 * </pre>
	 * @return a String representing the Account.
	 */
	public String toString();
}
