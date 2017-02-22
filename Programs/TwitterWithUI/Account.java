import java.util.ArrayList;
import java.util.Scanner;

public class Account {
	private Scanner sc = new Scanner(System.in);
	private String uname;
	private String pass;
	private String fName;
	private String lName;
	private ArrayList<Tweet> tweets;
	private ArrayList<Tweet> located;
	
	public Account(String uname, String pass, String fName, String lName){
		this.uname = uname;
		this.pass = pass;
		this.fName = fName;
		this.lName = lName;
		
		tweets = new ArrayList<Tweet>();
		located = new ArrayList<Tweet>();
	}
	
	public String getName(){
		return fName + " " + lName;
	}
	
	public String getUname(){
		return uname;
	}
	
	public String getPass(){
		return pass;
	}
	
	public int getTweetCnt(){
		return tweets.size();
	}
	
	public boolean postTweet(String post){
		Tweet newTweet = new Tweet(post);
		if(newTweet.setPost(post)){
			tweets.add(newTweet);
				
			return true;
		}
		else return false;
	}
	
	public boolean deleteTweet(int tweetNum){
		tweetNum--;
		if(tweetNum >= 0 && tweetNum < tweets.size()){
			tweets.remove(tweetNum);
			return true;
		}
		else {
			System.out.println("Invalid tweet index.");
			return false;
		}
		
	}
	
	public void displayAllTweets(){
		for(int i=0; i<tweets.size(); i++){
			System.out.print((i+1)+": ");
			System.out.println(tweets.get(i).toString());
		}
	}
	
	public ArrayList searchTweets(String key){
        located.clear();
		
		for(int i=0; i < tweets.size(); i++)
			if(tweets.get(i).getPost().toLowerCase().contains(key.toLowerCase()))
				located.add(tweets.get(i));
			
		return located;
	}
	
	public int getSearchCnt(){
		return located.size();
	}
	
	public String tweetString(int index){
		return tweets.get(index).toString();
	}
	
    public String searchTweetString(int index){
		return located.get(index).toString();
	}
	
	public void displayMenu(){
		String opt;
		do {
			System.out.println("Select an Action:");
			System.out.println("P - Post a tweet, V - View all tweets, S - Search tweets, D - Delete tweet, E - Exit");
			opt = sc.nextLine();
			
			System.out.println();
			if(opt.equalsIgnoreCase("P")){
				System.out.println("Enter tweet [1-140 chars.]: ");
				String post = sc.nextLine();
				postTweet(post);
			}
			else if(opt.equalsIgnoreCase("V")){
				displayAllTweets();
			}
			else if(opt.equalsIgnoreCase("S")){
				System.out.println("Enter search key: ");
				String key = sc.nextLine();
				searchTweets(key);
			}
			else if(opt.equalsIgnoreCase("D")){
				displayAllTweets();
				System.out.println("Enter tweet number: ");
				int num = sc.nextInt();
				deleteTweet(num);
			}
			System.out.println();
		} while(!opt.equalsIgnoreCase("E"));
	}
}