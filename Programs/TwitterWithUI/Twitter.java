import java.util.ArrayList;
import java.util.Scanner;

public class Twitter {
	public static void main(String[] args){
		Account model = new Account("TonyStark", "hi1234", "Tony", "Stark");
		
		model.postTweet("Please don't tell me there's a twelve year old kid waiting in the car, that I have never met. #playboy #PogiProblems");
		model.postTweet("Pepper: Am I going to be alright? Iron Man: Baby, you're in a relationship with me. Nothing is ever going to be alright. #pogiproblems");
		model.postTweet("You can take screwdriver or any toys, but it's something no one will ever take me.I am Iron Man!");
		
		TwitterView view = new TwitterView(model);
		
		view.setVisible(true);
	}
}