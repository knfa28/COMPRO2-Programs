import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class Tweet {
	private static DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
	private String post;
	private Date date;
	
	public Tweet(String text){
		setPost(text);
		setCurrDate();
	}
	
	public Tweet(){
		setCurrDate();
	}
	
	public boolean setPost(String text){
		if(!(text.length() > 140)){
			post = text;
			return true;
		}
		else {
			System.out.println("Character limit exceeded.");
			return false;
		}
	}
	
	public void setCurrDate(){
		date = new Date();
	}
	
	public String getPost(){
		return post;
	}
	
	public Date getDate(){
		return date;
	}
	
	public String getDateString(){
		return dateFormat.format(date);
	}
	
	public String toString(){
		return "<html>" + this.post + "<br/>" + getDateString() + "<br/> <br/> </html>";
	}
}
	
	
	
	