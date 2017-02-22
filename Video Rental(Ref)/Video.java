/**
 * @(#)Video.java
 *
 *
 * @author 
 * @version 1.00 2014/2/9
 */


public class Video {

	private final double RENTAL_FEE = 50;

	private String refID;
	private String title;
	private boolean isRented;

	
    public Video(String refID, String title) {
    	this.refID = refID;
    	this.title = title;
    	isRented = false;
    }
    
    public String getRefID(){
    	return refID;
    }
    
    public String getTitle(){
    	return title;
    }
    
    public boolean isRented(){
    	return isRented;
    }
	
	public String getRentalStatus(){
		if(isRented)
			return "Rented";
		else
			return "Available";
	}
    
    public void setRented(boolean status){
    	isRented = status;
    }
    
    public double getRentalFee(){
    	return RENTAL_FEE;
    }
    
	public String toString(){
		return "Reference ID: "+refID+"\tTitle: "+title+"\tStatus: "+getRentalStatus();
	}
}