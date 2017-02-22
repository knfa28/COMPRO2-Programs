public class Flight{
	private String flightno;
	private Seat[] seats = new Seat[5];
	
	public Flight(String flightno, Seat[] aSeats){
		this.flightno = flightno;
		seats = aSeats;
	}
	
	public Seat getAvailableSeat(){
		for(int i = 0; i < seats.length; i++)
			if(seats[i].isAvailable())
				return seats[i];
		return null;
	}
	
	public void showAvailableSeats(){
		for(int i = 0; i < seats.length; i++)
			if(seats[i].isAvailable())
				System.out.println("Seat Num: " + seats[i].getSeatNumber());
	}
	
	public int countAvailableSeats(){
		int seatCnt = 0;
		
		for(int i = 0; i < 5; i++)
			if(seats[i].isAvailable())
				seatCnt++;
				
		return seatCnt;
	}
	
	public String getFlightNo(){
		return flightno;
	}
}