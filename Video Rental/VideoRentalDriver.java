import java.util.Scanner;

public class VideoRentalDriver {

    public static void main(String[] args){
		char cChoice;
		int num;
		String text1, text2;
		
    	VideoRentalShop shop = new VideoRentalShop("XYZ");
		
		Scanner input = new Scanner(System.in);
		
		do{
			System.out.println("\nWhat do you wish to do now? ");
			System.out.println("Choose the appropriate letter of the next action");
			System.out.println("[C]-Register customer");
			System.out.println("[A]-Add video");
			System.out.println("[L]-Lend video");
			System.out.println("[R]-Receive video");
			System.out.println("[S]-Show reports");
			System.out.println("[E]-Exit");
			System.out.print("\nEnter choice: ");
			cChoice = input.next().charAt(0);
			input.nextLine();
			
			switch(cChoice){
				case 'C':
				case 'c': System.out.println("\nRegister Customer:\n");
						  System.out.print("Name : ");
						  text1 = input.nextLine();
						  System.out.print("Age  : ");
						  num = input.nextInt();
						  shop.registerCustomer(text1, num);
						  break;
				case 'A':
				case 'a': System.out.println("\nAdd Video:\n");
						  System.out.print("Title        : ");
						  text1 = input.nextLine();
						  System.out.print("Reference ID : ");
						  text2 = input.nextLine();
						  shop.addVideo(text1, text2);
						  break;
				case 'L':
				case 'l': System.out.println("\nLend Video:\n");
						  System.out.print("Customer name : ");
						  text1 = input.nextLine();
						  System.out.print("Reference ID  : ");
						  text2 = input.nextLine();
						  if(shop.lendVideo(text1, text2))
						      System.out.println("\nVideo lent!\n");
						  else System.out.println("\nCustomer/Video not found!\n");
						  break;
				case 'R':
				case 'r': System.out.println("\nReceive Video:\n");
						  System.out.print("Customer name : ");
						  text1 = input.nextLine();
						  System.out.print("Reference ID  : ");
						  text2 = input.nextLine();
						  if(shop.receiveVideo(text1, text2))
						      System.out.println("\nVideo received!\n");
						  else System.out.println("Customer/Video not found!\n");
						  break;
				case 'S':
				case 's': do{
						      System.out.println("[1]-All videos");
							  System.out.println("[2]-Available videos");
							  System.out.println("[3]-Rented videos");
							  System.out.println("[4]-Customers' videos");
							  System.out.println("[5]-Transaction history");
							  System.out.println("[X]-Exit");
							  System.out.print("\nEnter choice: ");
							  cChoice = input.next().charAt(0);
							  input.nextLine();
								
							  switch(cChoice){
						  	      case '1': shop.displayAllVids();
											System.out.println();
											break;
								  case '2': shop.displayAvailable();
											System.out.println();
								            break;
								  case '3': shop.displayRented();
											System.out.println();
											break;
								  case '4': shop.displayCustomerVids();
											System.out.println();
											break;
								  case '5': shop.displayTransactions();
											System.out.println();
											break;
								  default: System.out.println("\nPlease enter a valid choice!");
							  }
						  }while(cChoice != 'X' && cChoice != 'x');
				case 'E':
				case 'e': System.out.println("\nClosing Program...");
				          break;
				case 'f': System.out.print("\nFind Video: ");
						  text1 = input.nextLine();
						  num = shop.findVideo(text1);
						  System.out.println(num);
						  break;
				default: System.out.println("\nPlease enter a valid choice!");
			}
		}while(cChoice != 'e' && cChoice != 'E');
	}	
 }