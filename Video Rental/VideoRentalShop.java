import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class VideoRentalShop {

	private String name;
    private List<Customer> customers;
    private List<Video> videos;
	private List<Receipt> receipts;
    
    public VideoRentalShop(String name){
    	this.name = name;
    	
    	//using an ArrayList object for unknown number of elements 
    	customers = new ArrayList<Customer>();
    	videos = new ArrayList<Video>();
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
    public int findCustomer(String name){
    	// getting an element from list
		for( int i = 0; i < customers.size(); i++)
			if(customers.get(i).getName().equalsIgnoreCase(name))
				return i;
			
		return -999;
    }
    
    /* returns the video record with the specified reference ID */
    public int findVideo(String refID){
    	for( int i = 0; i < videos.size(); i++)
			if(videos.get(i).getRefID().equalsIgnoreCase(refID))
				return i;

		return -999;
    }
    
    /* lends a video renter. adds the rentedVid to renter's 
     * rented videos. should also update the status of rented video. */
    public boolean lendVideo(String customer, String RefID){
		boolean found = false;
		if(findCustomer(customer) != -999 && findVideo(RefID) != -999){
			if(videos.get(findVideo(RefID)).isRented() == false && customers.get(findCustomer(customer)).addRentedVideo(videos.get(findVideo(RefID)))){
				videos.get(findVideo(RefID)).rent();
				Date dateRented = new Date();
				Receipt newReceipt = new Receipt(customers.get(findCustomer(customer)), dateRented);
				receipts.add(newReceipt);
				found = true;
			}
		}
		return found;	
    }
    
    /* called when a rented video is returned. Should remove the returnedVid
            * from renter's rented videos. should also update returnedVid's status */
    public boolean receiveVideo(String customer, String RefID){
		boolean found = false;
		
		if(findCustomer(customer) != -999 && findVideo(RefID) != -999){
			if(videos.get(findVideo(RefID)).isRented() == true){
				customers.get(findCustomer(customer)).returnRentedVideo(videos.get(findVideo(RefID)));
				videos.get(findVideo(RefID)).returned();
				found = true;
			}
		}
		return found;
    }
    
    // Create the methods for the reports
    public void displayAllVids(){
		System.out.println("RefID\tTitle\n");
		for(int i = 0; i < videos.size(); i++)
			videos.get(i).displayVid();
	}
	
	public void displayAvailable(){
		System.out.println("RefID\tTitle\n");
		for(int i = 0; i < videos.size(); i++)
			if(videos.get(i).isRented() == false)
				videos.get(i).displayVid();
	}
	
	public void displayRented(){
		System.out.println("RefID\tTitle\n");
		for(int i = 0; i < videos.size(); i++)
			if(videos.get(i).isRented() == true)
				videos.get(i).displayVid();
	}
	
	public void displayCustomerVids(){
		for(int i = 0; i < customers.size(); i++)
			customers.get(i).displayCustomer();
	}
    
	public void displayTransactions(){
		for(int i = 0; i < receipts.size(); i++)
			receipts.get(i).displayReceipt();
	}
}