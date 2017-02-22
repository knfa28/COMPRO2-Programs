public class GoldCustomer extends Customer{
	public GoldCustomer(String name, int age){
		super(name, age);
		videosRented = new Video[10];
	}
	
	public double getDiscountRate(){
		return 30;
	}
}