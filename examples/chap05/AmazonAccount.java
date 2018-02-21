import java.util.ArrayList;

/**
 * Uses the address in an account.
 *
 * @author CS121 Instructors
 */
public class AmazonAccount
{
	private String userName;
	private String email;
	private String password;
	private ArrayList<AmazonAddress> addresses;

	/**
	 * Creates a new account with the given values.
	 * @param userName
	 * @param email
	 * @param password
	 */
	public AmazonAccount(String userName, String email, String password)
	{
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.addresses = new ArrayList<AmazonAddress>();
	}

	/**
	 * (Overloaded constructor) Creates a new account with the given
	 * userName and password.  Email is empty.
	 * @param userName
	 * @param email
	 * @param password
	 */
	public AmazonAccount(String userName, String password)
	{
		this.userName = userName;
		this.email = "";
		this.password = password;
		this.addresses = new ArrayList<AmazonAddress>();
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param the index of the address to remove
	 */
	public void removeAddress(int index) {
		//TODO remove the address
	}

	/**
	 * @param address the address to add
	 */
	public void addAddress(AmazonAddress address) {
		addresses.add(address);
	}

	/**
	 * @return the address at the given index
	 */
	public AmazonAddress getAddress(int index) {
		//TODO return the address instead of null
		return null;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String result = "AmazonAccount [userName=" + userName + ", email=" + email
				+ ", password=" + password + " addresses=[";
		for(AmazonAddress a : addresses) {
			result += "[" + a + "]";
		}
		result += "]]";
		return result;
	}
}
