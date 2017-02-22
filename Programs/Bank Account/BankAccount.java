public class BankAccount{
	
	private String accNum;
	private String accName;
	private int gold, silver, copper;
	
	public BankAccount(String accNum, String accName, int gold, int silver, int copper){
		this.accNum = accNum;
		this.accName = accName;
		this.gold = gold;
		this.silver = silver;
		this.copper = copper;
	}
	
	public int getGoldInterest(){
		return gold / 100;
	}
	
	public int getSilverInterest(){
		return silver / 100 * 5;
	}
	
	public int getCopperInterest(){
		return copper / 100;
	}
	
	public void deposit(int gold, int silver, int copper){
		this.gold += gold;
		this.silver += silver;
		this.copper += copper;
	}
	
	public void withdraw(int gold, int silver, int copper){
		this.gold -= gold;
		this.silver -= silver;
		this.copper -= copper;
	}
	
	public void printDetails(){
		System.out.println("\nAccount Number         : " + accNum);
		System.out.println("Account Name           : " + accName);
		System.out.println("Balance                : " + gold + " gold, " + silver + " silver, " + copper + " copper");
		System.out.println("Interest at year's end : " + getGoldInterest() + " gold, " + getSilverInterest() + " silver, " + getCopperInterest() + " copper");
		System.out.println("Balance at year's end  : " + (gold + getGoldInterest()) + " gold, " + (silver + getSilverInterest()) + " silver, " + (copper + getCopperInterest()) + " copper");
		System.out.print("\n");
	}
}	