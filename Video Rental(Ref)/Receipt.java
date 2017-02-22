/**
 * @(#)Receipt.java
 *
 *
 * @author 
 * @version 1.00 2014/2/12
 */
import java.util.Date;
import java.util.Calendar;

public class Receipt {
	private int receiptNum;
	private Customer renter;
	private Video rentedVid;
	private Date dateRented;
	private PaymentStatus status;
	
    public Receipt(int receiptNum, Customer renter, Video rentedVid) {
    	this.receiptNum = receiptNum;
    	this.renter = renter;
    	this.rentedVid = rentedVid;
    	
    	dateRented = new Date();
    	status = PaymentStatus.UNPAID;
    }
    
    public Customer getRenter(){
    	return renter;
    }
    
    public Video getRentedVid(){
    	return rentedVid;
    }
    
    public int getReceiptNum(){
    	return receiptNum;
    }
    
    public Date dateDue(){
    	Calendar c = Calendar.getInstance();
    	c.setTime(dateRented);
    	c.add(Calendar.DATE, 5);
    	return c.getTime();
    }
    
    private boolean checkIfLate(){
    	Date today = new Date();
    	return today.compareTo(dateDue()) > 0;
    }
    
    public double computeAmountDue(){
    	double discountRate = renter.getDiscountRate() / 100;
    	double amtDue = (1.0 - discountRate) * rentedVid.getRentalFee();
		
		if(checkIfLate())
			amtDue += 30;
			
		return amtDue;
    }
    
    public void setPaymentStatus(PaymentStatus status){
    	this.status = status;
    }
    
    public String toString(){
    	String s = "";
    	s+="Receipt Number: "+receiptNum+"\n";
    	s+="Date rented: "+dateRented+"\n";
    	s+="Date due: "+dateDue()+"\n";
    	s+="Customer name: "+renter.getName()+"\n";
    	s+="Video details: "+"\n";
    	s+="\t"+rentedVid.toString()+"\n";
    	s+="Status: "+status;
		
    	return s;
    }
}