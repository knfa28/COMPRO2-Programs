
public class PayrollMainPhase2 {
	public static void main(String[] args){
		PayrollSystem ps = new PayrollSystem();
		
		ps.addEmployee(new Accountant("Rachel Zane", 19500));
		ps.addEmployee(new Accountant("Donna Paulsen", 8000));
		ps.addEmployee(new Janitor("Louis Litt", 70)); // hourlyRate = 70
		ps.addEmployee(new Lawyer("Harvey Specter", 750));
		ps.addEmployee(new Lawyer("Mike Ross", 400)); // consultationFee = 400
		
		// increments Louis’ hours by 217.5, and Harvey's by 100, etc.
		ps.logHours("Louis Litt", 217.5);
		ps.logHours("Harvey Specter", 100);
		ps.logHours("Mike Ross", 150);
		
		System.out.println("Employee names: ");
		ps.displayAllEmployees();
		System.out.println();
		
		/* Fire Mike Ross
		ps.removeEmployee("Mike Ross");
		System.out.println("Mike Ross was fired\n");
		*/
		
		System.out.println("Employee Salaries: ");
		ps.showAllSalaries();
	}
}
