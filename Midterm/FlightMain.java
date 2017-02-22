public class FlightMain {
	public static void main(String args[]) {
		Seat[] s1 = new Seat[5];
		Seat[] s2 = new Seat[5];
		int i=0;
		for(i=0;i<s1.length;i++) {
			s1[i] = new Seat(i+101);
			s2[i] = new Seat(i+201);
		}
		
		Flight f1 = new Flight("Flight 1", s1);
		Flight f2 = new Flight("Flight 2", s2);
		
		Customer joe = new Customer("Joe");
		Customer john = new Customer("John");
		
		System.out.println("\nAvailable seats at f1:");
		f1.showAvailableSeats();
		
		System.out.println("\nAvailable seats at f2:");
		f2.showAvailableSeats();
		
		System.out.println("--------------------");
		
		System.out.println("\nJoe reserves 1 seat from f1 and 3 seats from f2");
		joe.reserve(f1);    //f1: 2,3,4,5
		joe.reserve(f2,3);  //f2: 4,5
		
		System.out.println("\nAvailable seats at f1:");
		f1.showAvailableSeats();
		
		System.out.println("\nAvailable seats at f2:");
		f2.showAvailableSeats();
		
		System.out.println("--------------------");
		
		System.out.println("\nJohn reserves 1 seat from f2 and 3 seats from f1");		
		john.reserve(f2);   //f2: 5
		john.reserve(f1,3); //f1: 5
		
		System.out.println("\nAvailable seats at f1:");
		f1.showAvailableSeats();
		
		System.out.println("\nAvailable seats at f2:");
		f2.showAvailableSeats();
		
		System.out.println("--------------------");
		
		System.out.println("\nAll reservations of joe:");
		joe.showAllReservations();
		
		System.out.println("\nAll reservations of john:");
		john.showAllReservations();
		
		System.out.println("--------------------");
		System.out.println("\nAvailable seats at f1:");
		System.out.println(f1.getFlightNo() + ":" + f1.countAvailableSeats());
		System.out.println("\nAvailable seats at f2:");
		System.out.println(f2.getFlightNo() + ":" + f2.countAvailableSeats());
	}
}