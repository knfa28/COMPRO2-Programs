import java.util.Scanner;

public class TwitterDriver{
	public static void main(String[] args){
	
		TwitterAcc IronMan = new TwitterAcc("IronMan", "Jarvis", "Tony", "Stark");
		
		IronMan.postTweet("Genius, billionaire, playboy, philanthropist, #badass");
		IronMan.postTweet("The Avengers. It's what we call ourselves, sort of \nlike a team. \42Earth's Mightiest #Heroes\42 type thing.\n#BADASS");
		IronMan.postTweet("There's a shawarma joint about two blocks from here.\nI don't know what it is, but I wanna try it.\n#avengers #foodTrip");
		
		System.out.println("#1 - Display account details\n");
		IronMan.displayAccDetails();
		
		System.out.println("#2 - Display all tweets\n");
		IronMan.displayAllTweets();
		
		System.out.println("#3 & #4 - search \42#badass\42 & \42avengers\42\n");
		IronMan.searchTweet("#badass");
		IronMan.searchTweet("avengers");
		
		System.out.println("#5 - Delete tweets #2 & #3\n");
		IronMan.deleteTweet(2);
		IronMan.deleteTweet(2);
		
		IronMan.displayAllTweets();
	}
}