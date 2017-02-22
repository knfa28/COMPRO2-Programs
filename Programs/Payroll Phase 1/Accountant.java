public class Accountant extends HourlyEmployee{
    
	private double salary;
	
	public Accountant(String name, double salary){
		super(name);
		this.salary = salary;
	}
		
    public double computeSalary(){
    	return salary;
    }
    
    public String toString(){
    	return super.toString()+"\nSalary: "+computeSalary();
    }
}