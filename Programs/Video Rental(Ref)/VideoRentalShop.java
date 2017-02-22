/**
 * @(#)VideoRentalShop.java
 *
 *
 * @author 
 * @version 1.00 2014/2/9
 */

import java.util.List;
import java.util.ArrayList;

public class VideoRentalShop {

	private String name;
    private List<Customer> customers;
    private List<Video> videos;
    private List<Receipt> receipts;
    private int currReceiptNum = 0;
    
    public VideoRentalShop(String name){
    	this.name = name;
    	
    	//using an ArrayList object for unknown number of elements 
    	customers = new ArrayList<Customer>();
    	videos = new ArrayList<Video>();
		receipts = new ArrayList<Receipt>();
    }
    
    public void registerCustomer(String name, int age){
    	// this is how you add an element to an ArrayList
    	Customer newCustomer = new Customer(name, age);
    	customers.add(newCustomer);
    	/* note that you can only add objects of the type Customer
    	 * because it is the type specified inside the <> 
    	 * during instantiation of the ArrayList at Line 22. */
    }
    
    public void addVideo(String refID, String title){
    	Video newVideo = new Video(refID, title);
    	videos.add(newVideo);
    }
    
    // complete the following methods:
 	
    /* returns the customer record with the specified name */
    public Customer findCustomer(String name){
    	for(int i=0; i<customers.size(); i++){
			if(customers.get(i).getName().equalsIgnoreCase(name))
				return customers.get(i);
		}
		
		return null;
    }
    
    /* returns the video record with the specified reference ID */
    public Video findVideo(String refID){
    	for(int i=0; i<videos.size(); i++){
			if(videos.get(i).getRefID().equalsIgnoreCase(refID))
				return videos.get(i);
		}
		
		return null;
    }
    
    public Receipt findReceipt(int receiptNum){
    	for(int i=receipts.size() - 1; i>=0; i--)
    		if(receipts.get(i).getReceiptNum() == receiptNum)
    			return receipts.get(i);
    	
    	return null;
    }
    
    public Receipt findReceipt(Customer renter, Video returnedVid){
    	for(int i=receipts.size() - 1; i>=0; i--)
    		if(receipts.get(i).getRenter().getName().equals(renter.getName()) 
			&& receipts.get(i).getRentedVid().getRefID().equals(returnedVid.getRefID()))
    			return receipts.get(i);
    	
    	return null;
    }
	
    /* lends a video renter. adds the rentedVid to renter's 
     * rented videos. should also update the status of rented video. */
    public boolean lend(Customer renter, Video rentedVid){
    	boolean lendResult = renter.addRentedVideo(rentedVid);
    	if(lendResult){
    		rentedVid.setRented(true);
    		receipts.add(new Receipt(currReceiptNum, renter, rentedVid));
    		currReceiptNum++;
    	}
    	
    	return lendResult;
    }
    
    /* called when a rented video is returned. Should remove the returnedVid
     * from renter's rented videos. should also update returnedVid's status */
    public void receiveVideo(Customer renter, Video returnedVid){
		Receipt r = findReceipt(renter, returnedVid);
    	System.out.println("Amount due is: "+r.computeAmountDue());
    	r.setPaymentStatus(PaymentStatus.PAID);
    	r.getRenter().removeRentedVideo(r.getRentedVid().getRefID());
		r.getRentedVid().setRented(false);
    }
    
    public void receiveVideo(int receiptNum){
    	Receipt r = findReceipt(receiptNum);
    	System.out.println("Amount due is: "+r.computeAmountDue());
    	r.setPaymentStatus(PaymentStatus.PAID);
    	r.getRenter().removeRentedVideo(r.getRentedVid().getRefID());
		r.getRentedVid().setRented(false);
    }
    
    // Create the methods for the reports
    public void displayAllVideos(){
		for(int i=0; i<videos.size(); i++)
			System.out.println(videos.get(i).toString());
	}
	
	public void displayAllCustomerVideos(){
		for(int i=0; i<customers.size(); i++)
			System.out.println(customers.get(i).toString());
	}
	
	public void displayAllRentedVideos(){
		for(int i=0; i<videos.size(); i++)
			if(videos.get(i).isRented() == true)
				System.out.println(videos.get(i).toString());
	}
	
    public void displayAllAvailableVideos(){
		for(int i=0; i<videos.size(); i++)
			if(videos.get(i).isRented() == false)
				System.out.println(videos.get(i).toString());
	}
	
	public void displayAllRentalTransactions(){
		for(int i=0; i<receipts.size(); i++)
			System.out.println(receipts.get(i).toString());
	}
}