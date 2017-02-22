/*IMPORTS*/
import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args){
		
		int nNum=7, nAns=0;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\n\tWelcome to the Guessing Game!\n");
		
		while(nAns!=nNum){
			
			System.out.print("\tGuess a number between 1 and 10. ");
			nAns=sc.nextInt();
			
			if (nAns>nNum){
				System.out.print("\tLower! ");
				if (nAns>10)
					System.out.print("Please input a number between 1 and 10 only!\n");
				else
					System.out.print("\n");
			}
			else if (nAns<nNum){
				System.out.print("\tHigher! ");
				if (nAns<1)
					System.out.print("Please input a number between 1 and 10 only!\n");
				else
					System.out.print("\n");
			}
			else 
				System.out.print("\tCorrect!\n");
		}				
	}    
}