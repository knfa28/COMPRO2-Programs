public class Video {

	private String refID;
	private String title;
	private boolean isRented;
	
    public Video(String refID, String title) {
    	this.refID = refID;
    	this.title = title;
    	isRented = false;
    }
    
    public String getRefID(){
    	return refID;
    }
    
    public String getTitle(){
    	return title;
    }
    
    public boolean isRented(){
    	return isRented;
    }
    
    public boolean rent(){
    	if(isRented)
    		return false;
    	else {
    		isRented = true;
    		return true;
    	}
    }
    
    public void returned(){
    	isRented = false;
    }
	
	public void displayVid(){
		System.out.println(refID + "\t" + title);
	}
}