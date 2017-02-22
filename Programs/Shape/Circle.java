import java.lang.Math; 

public class Circle extends Shape {
    private double radius;
    
    public Circle(String color, double radius){
        super(color);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
    
    public double getArea(){
        return Math.PI * radius * radius;
    }
    
    public double getCircumference(){
        return 2 * Math.PI * radius;
    }

    public String toString(){
        return super.toString()+", Radius: " + radius;
    } 
}
