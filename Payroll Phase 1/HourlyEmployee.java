public abstract class HourlyEmployee extends Employee{
	private double hoursWorked = 0;
	
	public HourlyEmployee(String name){
		super(name);
	}
	
	public double getHoursWorked(){
		return hoursWorked;
	}
	
	public void addHoursWorked(double hoursWorked){
		this.hoursWorked += hoursWorked;
	}
}