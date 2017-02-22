import java.util.List;
import java.util.ArrayList;

public class PayrollMainPhase1 {
	public static void main(String[] args){
		List<Employee> employees = new ArrayList<Employee>();
	
		HourlyEmployee louis = new Janitor("Louis Litt", 70); // hourlyRate = 70
		HourlyEmployee harvey = new Lawyer("Harvey Specter", 750);
		HourlyEmployee mike = new Lawyer("Mike Ross", 400); // consultationFee = 400
		louis.addHoursWorked(217.5);
		harvey.addHoursWorked(100);
		mike.addHoursWorked(150);
		
		employees.add(new Accountant("Rachel Zane", 19500));
		employees.add(new Accountant("Donna Paulsen", 8000));
		employees.add(louis);
		employees.add(harvey);
		employees.add(mike);
		
		/* the for-each loop - iterates over a list and assigns an element
		 * to e for every iteration. You can read it as: 
		 * "for each employee e in the list employees" */ 
		for(Employee e: employees){ 
			System.out.println(e.toString());
			System.out.println("=====================================");
		}
		
	}
}
