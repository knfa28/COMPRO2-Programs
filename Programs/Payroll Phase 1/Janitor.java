public class Janitor extends HourlyEmployee{
	private double hourlyRate = 0;
	
	public Janitor(String name, double hourlyRate){
		super(name);
		this.hourlyRate = hourlyRate;
	}
	
	public double getHourlyRate(){
		return hourlyRate;
	}
	
	public double computeSalary(){
		return getHoursWorked() * hourlyRate;
	}
	
	public String toString(){
    	return super.toString()+"\nSalary: "+computeSalary();
    }
}