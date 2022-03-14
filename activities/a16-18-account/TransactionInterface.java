import java.time.Instant;

public interface TransactionInterface 
{
	enum Type {Withdraw, Deposit, Debit, None};

	public Instant getDate();
	public float getAmount();
	public Type getType();
	public String getDescription();
	
	public String toString();
	
}
