public class Account {
	private int accountNumber;
	private double balance = 0.0;

	/*Account(){
		//this.accountNumber = 000;
		//this.balance = 00.00;
	}*/
	Account(int accountNum, double bal){
		this.accountNumber = accountNum;
		this.balance = bal;
	}
	Account(int accountNum){
		this.accountNumber = accountNum;
	}
	public int getAccountNumber(){
		return accountNumber;
	}
	public double getBalance(){
		return balance;
	}
	public void setBalance(double bal){
		this.balance = bal;
	}
	public void credit(double amount){
		if(this.balance >= 0 && amount >= 0){
			this.balance = amount + balance;
		}else 
			 throw new IllegalArgumentException("error line 29");
	}
	public void debit(double amount){
		if(amount<=balance && balance >= 0 && amount >= 0){
			 this.balance = balance - amount;
		}else
			throw new IllegalArgumentException("error line 35");

	}
	public String toString(){
		String transform = String.format("A/C no:%d, Balance=$%.02f",accountNumber,balance);
		return transform;
	}
}
