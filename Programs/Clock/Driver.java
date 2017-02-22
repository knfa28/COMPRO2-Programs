public class Driver{
	public static void main(String[] args){
		Clock c = new Clock(11,5,0);
		Clock c2 = new Clock();
	
		System.out.println(c.getHours() + ":" + c.getMinutes() + ":" + c.getSeconds());
		//System.out.println(c2.getHours() + ":" + c2.getMinutes() + ":" + c2.getSeconds());
		
		c.setAlarm(11,5,50);
	
		System.out.println("After 50 seconds");
	
		for(int i = 0; i < 50; i++)
			c.secondElapsed();
		
	
		System.out.println(c.getHours() + ":" + c.getMinutes() + ":" + c.getSeconds());
	}
}