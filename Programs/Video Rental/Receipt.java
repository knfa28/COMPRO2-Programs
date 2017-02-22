import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Receipt{
	
	private Date dateRented;
	private Video rentedVid;
	private Customer renter;
	
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
	
	public Receipt(Customer renter, Video rentedVid){
		this.rentedVid = rentedVid;
		this.renter = renter;
		dateRented = new Date();
	}
	
	public Customer getRenter(){
    	return renter;
    }
    
    public Video getRentedVid(){
    	return rentedVid;
    }
	
	public Date dateDue(){
		Calendar c = Calendar.getInstance();
		c.setTime(dateRented);
		c.add(Calendar.DATE, 5);
		Date dateDue = c.getTime();
		
		return dateDue;
    }
	
	private boolean checkIfLate(){
		Date today = new Date();
    	return today.after(dateDue());
	}	
	
	public double computeAmountDue(){
		double fPrice = 50;
		
		if(checkIfLate())
			fPrice += 30;
		
		return fPrice;	
	}
	
	public void displayReceipt(){
		System.out.println(renter.getName() + "\n");
		rentedVid.displayVid();
		System.out.print("\nRented on: ");
		System.out.println(dateFormat.format(dateRented) + "\n");
		System.out.print("Due date : ");
		System.out.println(dateFormat.format(dateDue()) + "\n");
	}
}