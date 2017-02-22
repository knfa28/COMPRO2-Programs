import java.util.Scanner;

public class StackDriver{
	
	public static void main(String args[]){
		
		int maxSize, nNum;
		char cChoice;
		Stack S1;
		Scanner input = new Scanner(System.in);
		
		System.out.print("\nEnter maximum number of elements: ");
		maxSize = input.nextInt();
		
		S1 = new Stack(maxSize);
		
		do{
			System.out.println("\nWhat do you wish to do now? ");
			System.out.println("Choose the appropriate letter of the next action");
			System.out.println("\n[P-Push, O-Pop, T-TopValue, S-ShowStack, E-Exit]");
			System.out.print("\nEnter choice: ");
			cChoice = input.next().charAt(0);
			
			switch(cChoice){
				case 'P':
				case 'p': System.out.print("\nEnter Value to Push: ");
						  nNum = input.nextInt();
						  S1.Push(nNum);
						  break;
				case 'O':
				case 'o': nNum = S1.Pop();
						  if(nNum != -999)
						      System.out.println("\nPopped " + nNum + " from the Stack");
						  else System.out.println("\nEMPTY LIST");
						  break;
				case 'T':
				case 't': System.out.println("\nTop value of the Stack is " + S1.getTop());
						  break;
				case 'S':
				case 's': S1.printStack();
						  break;
				case 'E':
				case 'e': System.out.println("\nClosing Program...You will lose all data stored in Stack.");
				          break;
				default: System.out.println("\nPlease enter a valid choice!");
			}
		}while(cChoice != 'e' && cChoice != 'E');
	}
}