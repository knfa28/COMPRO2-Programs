public class TempCalculator{
	private double tempVal;
	
	public TempCalculator(double tempVal){
		this.tempVal = tempVal;
	}
	
	public double convertCelToFah(){
		return tempVal * 9 / 5 + 32;
	}
	
	public double convertFahToCel(){
		return (tempVal - 32) * 5 / 9;
	}
	
	public String getTempForecast(char tempType){
		if(tempType == 'c' || tempType == 'C')
			if(tempVal <= 10)
				return "Freezing cold";
			else if(tempVal <= 15)
				return "Cold";
			else if(tempVal <= 20)
				return "Breezy";
			else if(tempVal <= 25)
				return "Just right!";
			else if(tempVal <= 30)
				return "Warm";
			return "Hot";
	}
}