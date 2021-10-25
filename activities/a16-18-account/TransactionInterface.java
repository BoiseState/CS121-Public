import java.util.Date;

public interface TransactionInterface 
{
	enum Type {Withdraw, Deposit, Debit, None};

	public Date getDate();
	public float getAmount();
	public Type getType();
	public String getDescription();
	
	public String toString();
	
}
