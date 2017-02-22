public class Cylinder extends Circle {
    private double height;
    
    public Cylinder(String color, double radius, double height){
        super(color, radius);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }
    
    public double getArea(){
        return getCircumference() * (height + getRadius());
    }
    
    public double getVolume(){
        return super.getArea() * height;
    }
    
    public String toString(){
        return super.toString()+", Height: " + height;
    }
}
