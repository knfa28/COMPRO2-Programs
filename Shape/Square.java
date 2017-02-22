import java.lang.Math;

public class Square extends Shape{
	private double side;
	
    public Square(String color, double side){
        super(color);
        this.side = side;
    }

    public double getSide() {
        return side;
    }
    
    public double getArea(){
        return Math.pow(side, 2);
    }
    
    public double getPerimeter(){
        return 4 * side;
    }
	
    public String toString(){
        return super.toString()+", Side: "+ side;
    } 
}