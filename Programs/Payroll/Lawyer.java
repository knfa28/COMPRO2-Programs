public class Lawyer extends HourlyEmployee{
	private double consultationFee;
	
	public Lawyer(String name, double consultationFee){
		super(name);
		this.consultationFee = consultationFee;
	}
	
	public double getConsultationFee(){
		return consultationFee;
	}
	
	public double computeSalary(){
		return getHoursWorked() * consultationFee;
	}
	
	public String toString(){
    	return super.toString() + "\nHours worked: " + getHoursWorked() + "\nConsultation fee: " + getConsultationFee() +"\nSalary: "+computeSalary() + "\nTax: " + computeTax();
    }
}