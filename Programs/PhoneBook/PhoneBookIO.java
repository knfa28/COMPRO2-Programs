import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookIO{
	public void writeContactsToFile(String filename, List<Contact> contacts){
		FileWriter writer;
		
		try{
			writer = new FileWriter(filename);
			BufferedWriter bw = new BufferedWriter(writer);
			
			for(int i = 0; i < contacts.size(); i++){
				bw.write(contacts.get(i).getName() +"#"+ contacts.get(i).getNum());
				if(i != contacts.size() - 1)
					bw.newLine();
			}
				
			bw.close();	
		}catch(IOException ioe){
			System.out.println("Cannot access file");
		}
	}
	
	public List<Contact> readContactsFromFile(String filename){
		List<Contact> toRead = new ArrayList<Contact>();
		BufferedReader br = null;
 
		try {
			String sCurrentLine, name, num;
			br = new BufferedReader(new FileReader(filename));
 
			while ((sCurrentLine = br.readLine()) != null) {
				String[] split = sCurrentLine.split("#");
				name = split[0];
				num = split[1];
				toRead.add(new Contact(name,num));
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		return toRead;
	}
}