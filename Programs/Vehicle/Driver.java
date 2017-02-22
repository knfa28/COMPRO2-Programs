import java.util.List;
import java.util.ArrayList;

public class Driver {
	public static void main(String[] args){
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		
		Vehicle v = new Bike("MyBike");
		vehicles.add(v);
		
		Vehicle v2 = new Car("Car");
		vehicles.add(v2);
		
		Vehicle v3 = new Plane("Plane");
		vehicles.add(v3);
		
		for(int i=0; i<vehicles.size(); i++)
			vehicles.get(i).move();
		
	}
}