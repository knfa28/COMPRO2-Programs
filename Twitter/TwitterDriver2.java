import java.util.Scanner;

public class TwitterDriver2{
	
	public static void main(String args[]){
		
		int nChoice;
		char cChoice;
		String userName, passWord, firstName, lastName, text;
		Scanner input = new Scanner(System.in);
		
		System.out.print("\nEnter username   : ");
		userName = input.nextLine();
		System.out.print("Enter password   : ");
		passWord = input.nextLine();
		System.out.print("Enter first name : ");
		firstName = input.nextLine();
		System.out.print("Enter last name  : ");
		lastName = input.nextLine();
		System.out.println();
		
		TwitterAcc user = new TwitterAcc(userName, passWord, firstName, lastName);
		
		user.displayAccDetails();
		
		do{
			System.out.println("\nWhat do you wish to do now? ");
			System.out.println("Choose the appropriate letter of the next action");
			System.out.println("[P]-Post tweet");
			System.out.println("[V]-View all tweets");
			System.out.println("[S]-Search for a tweet");
			System.out.println("[D]-Delete a tweet");
			System.out.println("[E]-Exit");
			System.out.print("\nEnter choice: ");
			cChoice = input.next().charAt(0);
			input.nextLine();
			
			switch(cChoice){
				case 'P':
				case 'p': System.out.println("\nCompose new Tweet...\n");
						  text = input.nextLine();
						  user.postTweet(text);
						  break;
				case 'V':
				case 'v': System.out.println("\nTweets\n");
						  user.displayAllTweets();
						  break;
				case 'S':
				case 's': System.out.print("\nSearch: ");
						  text = input.nextLine();
						  System.out.println();
						  user.searchTweet(text);
						  break;
				case 'D':
				case 'd': System.out.println("\nDelete tweet\n");
						  user.displayAllTweets();
						  System.out.print("\nWhich tweet would you like to delete: ");
						  nChoice = input.nextInt();
						  input.nextLine();
						  user.deleteTweet(nChoice);
						  break;
				case 'E':
				case 'e': System.out.println("\nClosing Program...");
				          break;
				default: System.out.println("\nPlease enter a valid choice!");
			}
		}while(cChoice != 'e' && cChoice != 'E');
	}
}