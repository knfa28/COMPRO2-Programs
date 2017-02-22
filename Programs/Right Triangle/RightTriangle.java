public class RightTriangle{

	private double base;
	private double height;
	
	public RightTriangle(double base, double height){
		this.base = base;
		this.height = height;
	}
	
	public double getHyp(){
		return Math.sqrt((Math.pow(base , 2) + Math.pow(height, 2)));
	}
	
	public double getArea(){
		return base / 2 * height;
	}
	
	public double getPerimeter(){
		return base + height + getHyp();
	}
	
	public double getAngleA(){
		return Math.toDegrees(Math.asin(height / getHyp()));
	}
	
	public double getAngleB(){
		return Math.toDegrees(Math.asin(base / getHyp()));
	}
	
	public int getAngleC(){
		return 90;
	}
	
	public void printDetails(){
		System.out.println("Base       : " + base);
		System.out.println("Height     : " + height);
		System.out.println("Area       : " + (Math.round(getArea() * 100.00) / 100));
		System.out.println("Perimeter  : " + (Math.round(getPerimeter() * 100.00) / 100));
		System.out.println("Hypotenuse : " + (Math.round(getHyp() * 100.00) / 100));
		System.out.println("Angle A    : " + (Math.round(getAngleA() * 100.00) / 100.00) + " deg");
		System.out.println("Angle B    : " + (Math.round(getAngleB() * 100.00) / 100.00) + " deg");
		System.out.println("Angle C    : " + getAngleC() + " deg");
	}
}
	
	