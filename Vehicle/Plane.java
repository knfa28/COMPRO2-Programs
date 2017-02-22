/**
 * @(#)Plane.java
 *
 *
 * @author 
 * @version 1.00 2014/3/4
 */


public class Plane extends GasedVehicle {

    public Plane(String name) {
    	super(name);
    }
    
    public void move(){
    	System.out.println("Plane is flying!");
    }
    
    
}