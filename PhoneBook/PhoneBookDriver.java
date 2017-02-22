import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookDriver{
	public static void main(String[] args){
		PhoneBookIO io = new PhoneBookIO();
		List<Contact> toWrite = new ArrayList<Contact>();
		List<Contact> toRead = new ArrayList<Contact>();
		
		Contact mcdo = new Contact("McDo", "86239");
		Contact jollibee = new Contact("Jollibee", "87000");
		Contact greenwich = new Contact("Greenwich", "55555");
		
		toWrite.add(mcdo);
		toWrite.add(jollibee);
		toWrite.add(greenwich);
		
		io.writeContactsToFile("contacts.txt", toWrite);
		toRead = io.readContactsFromFile("contacts2.txt");
		
		for(int i = 0; i < toRead.size(); i++)
			System.out.println(toRead.get(i).toString());
	}
}