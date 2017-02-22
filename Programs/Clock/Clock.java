public class Clock{

	private int hours, minutes, seconds;
	private int Ahours, Aminutes, Aseconds;
	
	public Clock(int hours, int minutes, int seconds){
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}
	
	public Clock(){
		this.hours = 0;
		this.minutes = 0;
		this.seconds = 0;
	}
	
	public void secondElapsed(){
		if(seconds > 59){
			seconds = 0;
			if(minutes > 59){
				minutes = 0;
				if(hours > 12)
					hours = 1;
				else
					hours++;
			}
			else
				minutes++;
		}
		else
			seconds++;
		
		if(hours == Ahours && minutes == Aminutes && seconds == Aseconds)
			alarm();	
	}
	
	public void setAlarm(int hours, int minutes, int seconds){
		this.Ahours = hours;
		this.Aminutes = minutes;
		this.Aseconds = seconds;
	}
	
	private void alarm(){
		System.out.println("Alarm!");
	}
	
	public int getHours(){
		return hours;
	}
	
	public int getMinutes(){
		return minutes;
	}
	
	public int getSeconds(){
		return seconds;
	}
	
	public void setTime(int hours, int minutes, int seconds){
		if(hours > 0 && hours <= 12)
			this.hours = hours;
		if(minutes > 0 && minutes < 60)
			this.minutes = minutes;
		if(seconds > 0 && seconds < 60)
			this.seconds = seconds;
	}
}