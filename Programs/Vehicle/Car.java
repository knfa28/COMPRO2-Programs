/**
 * @(#)Car.java
 *
 *
 * @author 
 * @version 1.00 2014/3/4
 */


public class Car extends GasedVehicle {

    public Car(String name) {
    	super(name);
    }
    
    public void move(){
    	System.out.println("Car is moving yeah!");
    }
    
}