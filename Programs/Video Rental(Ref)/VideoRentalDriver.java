/**
 * @(#)VideoRentalDriver.java
 *
 *
 * @author 
 * @version 1.00 2014/2/9
 */
import java.util.Scanner;

public class VideoRentalDriver {

    public static void main(String[] args){
	
	Customer[] custs = new Customer[3];
	custs[0] = new Customer("Kurt Aquino", 17);
	custs[1] = new SilverCustomer("Aquino Kurt", 17);
	custs[2] = new GoldCustomer("Neil Aquino", 17);
	
	System.out.println(custs[0].toString());
	System.out.println(custs[1].toString());
	System.out.println(custs[2].toString());
	
	/*
    	VideoRentalShop shop = new VideoRentalShop("XYZ");
		
		shop.registerCustomer("Bruce Wayne", 42);
		shop.registerCustomer("Clark Kent", 29);
		
		shop.addVideo("TDK", "The Dark Knight");
		shop.addVideo("ASM", "Amazing Spiderman");
		shop.addVideo("MOS", "Man of Steel");
		shop.addVideo("TH", "Thor");
		shop.addVideo("IM", "Iron Man");
		
		shop.lend(shop.findCustomer("Bruce Wayne"), shop.findVideo("TDK"));
		shop.lend(shop.findCustomer("Bruce Wayne"), shop.findVideo("IM"));		
		shop.lend(shop.findCustomer("Clark Kent"), shop.findVideo("MOS"));
		shop.lend(shop.findCustomer("Clark Kent"), shop.findVideo("TH"));
		
		Scanner sc = new Scanner(System.in);
		String opt, name, refID, title;
		int age, receiptNum;
		do {
			System.out.println("R - Register Customer, A - Add video, L - Lend Video, E - Receive video, S - Show reports, X - Exit");
			opt = sc.next().toUpperCase();
			sc.nextLine();
			switch(opt.charAt(0)){
				case 'R':
					System.out.print("Enter name: ");
					name = sc.nextLine();
					System.out.print("Enter age: ");
					age = sc.nextInt();
					shop.registerCustomer(name, age);
					break;
				case 'A':
					System.out.print("Enter RefID: ");
					refID = sc.next();
					System.out.print("Enter Title: ");
					title = sc.nextLine();
					shop.addVideo(refID, title);
					break;
				case 'L':
					System.out.print("Enter customer name: ");
					name = sc.nextLine();
					System.out.print("Enter video refID: ");
					refID = sc.next();
					shop.lend(shop.findCustomer(name), shop.findVideo(refID));
					break;
				case 'E':
					System.out.print("Enter receipt number: ");
					receiptNum = sc.nextInt();
					shop.receiveVideo(receiptNum);
					break;
				case 'S':
					System.out.println("Choose report:");
					System.out.println("[1] - All videos, [2] - Customer videos, [3] - Rented videos, [4] - Available videos, [5] - All transactions");
					int reportOpt = sc.nextInt();
					switch(reportOpt){
						case 1: shop.displayAllVideos(); break;
						case 2: shop.displayAllCustomerVideos(); break;
						case 3: shop.displayAllRentedVideos(); break;
						case 4: shop.displayAllAvailableVideos(); break;
						case 5: shop.displayAllRentalTransactions(); break;
					}
					break;
			}
		} while(!opt.equalsIgnoreCase("X"));
	*/
    }
}