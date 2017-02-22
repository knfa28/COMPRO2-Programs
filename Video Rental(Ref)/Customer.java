/**
 * @(#)Customer.java
 *
 *
 * @author 
 * @version 1.00 2014/2/9
 */


public class Customer {

	private String name;
	private int age;
	protected Video[] videosRented;
	private int videoCnt = 0;

    public Customer(String name, int age) {
    	this.name = name;
    	this.age = age;
    	videosRented = new Video[5];
    }
    
    public int getVideoCnt(){
    	return videoCnt;
    }
    
    public int getVideoRentLimit(){
    	return videosRented.length;
    }
    
    private boolean hasReachedLimit(){
    	if(videoCnt == videosRented.length)
    		return true;
    	else
    		return false;
    }
    
    public boolean addRentedVideo(Video v){
    	if(!hasReachedLimit()){
    		videosRented[videoCnt] = v;
    		videoCnt++;
    		return true;
    	}
    	else {
    		System.out.println("Customer "+name+" cannot rent more videos!");
    		return false;
    	}
    }
    
    public void removeRentedVideo(String refID){
    	boolean found = false;
    	for(int i=0; i<videoCnt && !found; i++)
    		if(videosRented[i].getRefID().equalsIgnoreCase(refID)){
    			found = true;
    			videosRented[i] = null;
    			for(int j=i; j<videoCnt - 1; j++)
    				videosRented[i] = videosRented[i+1];
    				
    		}
    			
    }
    
    public String toString(){
    	String str = "Name: "+name+"\t Age: "+age+"\n";
		str += "Rented Videos:\n";
		for(int i=0; i<videoCnt; i++)
			str += videosRented[i].toString()+"\n";
		str += "Max Videos: " + getVideoRentLimit() + "\n";
		str += "Discount Rate: " + getDiscountRate() + "\n";
			
		return str;
    }
    
    public String getName(){
    	return name;
    }
    
    public int getAge(){
    	return age;
    }
    
    public Video[] getVideosRented(){
    	return videosRented;
    }
    
    public double getDiscountRate(){
    	return 0;
    }
}