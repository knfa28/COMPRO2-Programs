public abstract class Employee {
	private String name;
	
    public Employee(String name) {
		this.name = name;
    }
    
    public String getName(){
    	return name;
    }
    
    public double computeTax(){
    	double salary = computeSalary();
		double tax = 0;
		
		if(salary >= 3200){
			tax += 3200 * 0.03;
			salary -= 3200;
			
			if(salary >= 8800){
				tax += 8800 * 0.065;
				salary -= 8800;
				
				if(salary > 0)
					tax += salary * 0.135;
			} 
			else tax += salary * 0.065;
		}
    	else tax += salary * 0.03;
		
    	return tax;
    }
    
    public abstract double computeSalary();
    
    public String toString(){
    	return "Name: "+name;
    }
}