
public class SavingsAcc {
	private double bal;
	
	SavingsAcc(double bankbal) {
		super();
		this.bal=bankbal;	
	}

	void withdraw(double amounttowithdraw)
	{
		System.out.println("withdrawing");
		bal=bal-amounttowithdraw;
		//bal=bal-20;
	}
	public double getBalance()
	{
		return bal;
	}
	@Override public String toString()
	{
		return "savingsAccount [BankBalance = " + bal +"]";
	}

}
