public class Seat{
	private boolean available = true;
	private int seatnumber;
	private Customer reservedBy;
	
	public Seat(int nSeatNumber){
		seatnumber = nSeatNumber;
	}
	
	public void reserveSeat(){
		if(available)
			available = false;
	}
	
	public boolean isAvailable(){
		return available;
	}
	
	public int getSeatNumber(){
		return seatnumber;
	}

	public Customer getCustomer(){
		if(!available)
			return reservedBy;
		
		return null;
	}
}