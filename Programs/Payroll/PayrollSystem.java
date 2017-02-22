import java.util.List;
import java.util.ArrayList;

 class PayrollSystem{
	private List<Employee> employees;
	private int employeeCnt;
	
	public PayrollSystem(){
		employees = new ArrayList<Employee>();
		employeeCnt = 0;
	}
	
	public void addEmployee(Employee newEmployee){
		employees.add(newEmployee);
		employeeCnt++;
	}
	
	/*
	public void removeEmployee(String name){
		for(int i = 0; i < employeeCnt; i++){
			if(employees.get(i).getName().equalsIgnoreCase(name)){
				for(int j = i; j < employeeCnt - 1; i++)
					employees.get(j) = employees.get(j+1);
				employeeCnt--;	
			}
		}
	}
	*/
	
	public void logHours(String name, double hours){
		for(int i = 0; i < employees.size(); i++){
			Employee e = employees.get(i);
			if(e.getName().equals(name) && e instanceof HourlyEmployee){
				HourlyEmployee he = (HourlyEmployee)e;
				he.addHoursWorked(hours);
				break;
			}
		}
	}
	
	public void displayAllEmployees(){
		for(int i = 0; i < employees.size(); i++){
			System.out.println((i + 1) + ".) " + employees.get(i).getName());
			System.out.println("=====================================");
		}
	}
	
	public void showAllSalaries(){
		for(int i = 0; i < employees.size(); i++){
			System.out.println((i + 1) + ".)");
			System.out.println(employees.get(i).toString());
			System.out.println("=====================================");
		}
	}			
}