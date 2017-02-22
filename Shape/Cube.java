import java.lang.Math;

public class Cube extends Square { 
    public Cube(String color, double side){
        super(color, side);
    }
    
    public double getArea(){
        return 4 * super.getArea();
    }
    
    public double getVolume(){
        return Math.pow(getSide(), 3);
    }
    
    public String toString(){
        return super.toString();
    }    
}
