public class ShapeDriver {
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Shape Object:");
        
		Shape s1 = new Shape("Blue");
		System.out.println("ToString method = "+s1.toString()+"\n\n");
        
        System.out.println("Circle Object:");
        Circle circ = new Circle("Red", 30);
        System.out.println("ToString method = "+circ.toString());
        System.out.println("Color = "+circ.getColor());
        System.out.println("Area = "+circ.getArea());
        System.out.println("Circumference = "+circ.getCircumference()+"\n\n"); 
        
        System.out.println("Cylinder Object:");
        Cylinder cyl = new Cylinder("Violet", 11, 23);
        System.out.println("ToString method = "+cyl.toString());
        System.out.println("Color = "+cyl.getColor());
        System.out.println("Area ="+cyl.getArea());
        System.out.println("Volume = "+cyl.getVolume());
		
		Shape s2 = new Shape("Pink");
		System.out.println("ToString method = "+s2.toString()+"\n\n");
        
        System.out.println("Square Object:");
        Square sqr = new Square("Black", 5);
        System.out.println("ToString method = "+sqr.toString());
        System.out.println("Color = "+sqr.getColor());
        System.out.println("Area = "+sqr.getArea());
        System.out.println("Perimeter = "+sqr.getPerimeter()+"\n\n"); 
        
        System.out.println("Cube Object:");
        Cube cb = new Cube("Purple", 3);
        System.out.println("ToString method = "+cb.toString());
        System.out.println("Color = "+cb.getColor());
        System.out.println("Area ="+cb.getArea());
        System.out.println("Volume = "+cb.getVolume()); 
    }
}
