/**
 * @(#)GasedVehicle.java
 *
 *
 * @author 
 * @version 1.00 2014/3/4
 */


public abstract class GasedVehicle extends Vehicle {
	private double fuelLevel;
	
    public GasedVehicle(String name) {
    	super(name);
    	fuelLevel = 0;
    }
    
    public void addFuel(double f){
    	fuelLevel += f;
    }
    
    // I inherited the abstract move method BUT...
    // I did not implement the move method here yet
}