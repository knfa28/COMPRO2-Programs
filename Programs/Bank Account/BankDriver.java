public class BankDriver{
	public static void main(String[] args){
		BankAccount B1 = new BankAccount("11-00-22", "Jack Sparrow", 500, 223, 75);
		BankAccount B2 = new BankAccount("13-98-57", "Hector Barbosa", 300, 189, 300);
		BankAccount B3 = new BankAccount("98-43-21", "Will Turner", 450, 600, 18);
		
		B1.printDetails();
		B1.deposit(200, 0, 0);
		B1.printDetails();
		
		B2.printDetails();
		B2.withdraw(0, 100, 0);
		B2.printDetails();
	}
}