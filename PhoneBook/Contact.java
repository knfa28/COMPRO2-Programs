public class Contact{
	private String name;
	private String num;
	
	public Contact(String name, String num){
		this.name = name;
		this.num = num;
	}
	
	public String getName(){
		return name;
	}
	
	public String getNum(){
		return num;
	}
	
	public String toString(){
		return "Name:\t" + name + "\t, Num:\t" + num;
	}
}