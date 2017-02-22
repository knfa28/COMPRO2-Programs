public class PremiumVid extends Video{
	public PremiumVid(String refID, String Title){
		super(refID, Title);
	}
	
	public double getRentalFee(){
		return super.getRentalFee() * 1.5;
	}
}
	
	