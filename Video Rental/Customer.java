public class Customer {

	private String name;
	private int age;
	private Video[] videosRented;
	private int videoCnt = 0;

    public Customer(String name, int age){
    	this.name = name;
    	this.age = age;
    	
    	videosRented = new Video[5];
    }
    
	public String getName(){
		return name;
	}
	
    public int getVideoCnt(){
    	return videoCnt;
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
	
	public void returnRentedVideo(Video returnedVid){
		if(videoCnt == 0){
			System.out.println("\nNo videos rented...");
			return false;
		}
		else{
			for(int i = 0; i < 5; i++)
				if(videosRented[i] == returnedVid){
					for(int j = i; j < videoCnt - 1; j++)
						videosRented[j] = videosRented[j + 1];
							
					videoCnt--;	
					return true;
				}
			}
		return false;
	}
    
    public String toString(){
    	return "Name: "+name+", Age: "+age;
    }
	
	public void displayCustomer(){
		System.out.println("Name: " + name);
		System.out.println("Number of Videos borrowed: " + videoCnt + "\n");
		System.out.println("Rented Videos:");
		for(int i = 0; i < videoCnt; i++)
			videosRented[i].displayVid();
		System.out.println();
	}
}