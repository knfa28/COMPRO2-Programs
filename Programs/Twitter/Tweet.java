import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

 class Tweet{
	private String tweet;
	private Date date;
	
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
	
	public Tweet(String tweet){
		this.tweet = tweet;
		date = new Date();
	}
	
	public String getTweet(){
		return tweet;
	}
	
	public Date getDate(){
		return date;
	}
	
	public void printTweet(){
		System.out.println(tweet);
		System.out.println(dateFormat.format(date));
	}
}
	
	