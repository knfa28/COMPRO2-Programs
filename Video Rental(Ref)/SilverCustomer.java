public class SilverCustomer extends Customer{
	public SilverCustomer(String name, int age){
		super(name, age);
		videosRented = new Video[7];
	}
	
	public double getDiscountRate(){
		return 20;
	}
}