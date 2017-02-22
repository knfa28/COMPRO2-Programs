public class TwitterAcc{
	private String UserName;
	private String PassWord;
	private String firstName;
	private String lastName;
	private Tweet[] arrTweets;
	private int tweetCnt;
	
	public TwitterAcc(String user, String pass, String first, String last){
		this.UserName = user;
		this.PassWord = pass;
		this.firstName = first;
		this.lastName = last;
		arrTweets = new Tweet[20];
		tweetCnt = 0;
	}
	
	private boolean checkFull(){
		if(tweetCnt == 20)
			return true;
		else
			return false;
	}
	
	private boolean isValidTweet(String tweet){
		if(tweet.length() <= 140)
			return true;
		else
			return false;
	}
	
	public void postTweet(String tweet){
    	if(!checkFull() && isValidTweet(tweet)){
    		arrTweets[tweetCnt] = new Tweet(tweet);
    		tweetCnt++;
    	}
    	else if(checkFull())
    		System.out.println("\nMaximum number of tweets reached!");
		else
			System.out.println("\nMaximum number of characters reached!");
    }
	
	public void deleteTweet(int tweetIndex){
    	boolean found = false;
		
		if(tweetCnt == 0)
			System.out.println("\nNo tweets posted...");
		else{
			if(tweetIndex > 0 && tweetIndex <= tweetCnt){
				found = true;
				
				for(int i = tweetIndex - 1; i < tweetCnt - 1; i++)
					arrTweets[i] = arrTweets[i + 1];
						
				tweetCnt--;	
			}
			
			if(found)
				System.out.println("\nTweet has been successfully deleted!\n");
			else
				System.out.println("\nTweet does not exist!\n");
		}
    }
	
	public void searchTweet(String key){
		boolean found = false;
		
		if(tweetCnt == 0)
			System.out.println("\nNo tweets posted...");
		else{
			for(int i = 0; i < tweetCnt; i++)
				if(arrTweets[i].getTweet().toLowerCase().contains(key.toLowerCase())){
					found = true;
					arrTweets[i].printTweet();
					System.out.println();
				}
		
			if(!found)
				System.out.println("\nTweet not found!");
		}
	}
	
	public void displayAllTweets(){
		if(tweetCnt == 0)
			System.out.println("\nNo tweets posted...");
		else
			for(int i = 0; i < tweetCnt; i++){
				System.out.println("[" + (i + 1) + "]");
				arrTweets[i].printTweet();
				System.out.println();
			}
	}
	
	public void displayAccDetails(){
		System.out.println("User name  : " + UserName);
		System.out.println("First name : " + firstName);
		System.out.println("Last name  : " + lastName);
		System.out.println("Number of Tweets : " + tweetCnt + "\n");
	}
}
	