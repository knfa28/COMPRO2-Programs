public class Customer{
	private String name;
	private Seat[] reserved;
	private int seatCnt = 0;
	
	public Customer(String name){
		this.name = name;
		reserved = new Seat[5];
	}
	
	public String getName(){
		return name;
	}
	
	public void reserve(Flight flight){
		if(flight.countAvailableSeats() > 0){
			reserved[seatCnt] = flight.getAvailableSeat();
			reserved[seatCnt].reserveSeat();
			seatCnt++;
		}
		
		else
			System.out.println("\nNo available seat!\n");
	}
	
	public void reserve(Flight flight, int seatCount){
		if(flight.countAvailableSeats() < seatCount)
			System.out.println("\nNo more available seats!\n");
		else{
			while(flight.countAvailableSeats() > 0 && seatCount > 0){
				reserved[seatCnt] = flight.getAvailableSeat();
				reserved[seatCnt].reserveSeat();
				seatCnt++;
				seatCount--;
			}
		}
	}
	
	public void showAllReservations(){
		if(seatCnt == 0)
			System.out.println("\nNo reserved seats!\n");
		else
			for(int i = 0; i < seatCnt; i++)
				System.out.println("Seat Num: " + reserved[i].getSeatNumber());
	}
}

		