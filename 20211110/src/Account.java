
public class Account {
	String accountNo;
	String owner;
	int balance;
	public Account() {}
	public Account(String accounNo, String owner,
			int balance) {
		this.accountNo = accounNo;
		this.owner = owner;
		this.balance = balance;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
}
