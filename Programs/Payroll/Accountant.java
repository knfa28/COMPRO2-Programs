public class Accountant extends Employee{
    
	private double salary;
	
	public Accountant(String name, double salary){
		super(name);
		this.salary = salary;
	}
		
    public double computeSalary(){
    	return salary;
    }
    
    public String toString(){
    	return super.toString()+"\nSalary: "+computeSalary() + "\nTax: " + computeTax();
    }
}