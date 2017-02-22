public class BookShelf {

	private Book arrBooks[];
	private String category;
	private String location;
	private final int maxBooks;
	private int bookCnt;
	
    public BookShelf( String category, int maxBooks, String location){
    	
    	this.category = category;
    	this.location = location;
    	
    	this.maxBooks = maxBooks;
    	arrBooks = new Book[maxBooks];
    	bookCnt = 0;
    }
    
    private boolean checkFull(){
    	if(bookCnt == maxBooks)
    		return true;
    	else
    		return false;
    }
    
    public void addBook(Book b){
    	if(!checkFull()){
    		arrBooks[bookCnt] = b;
    		bookCnt++;
    	}
    	else
    		System.out.println("Shelf Full!");
    }
    
    public void removeBook(String title){
    	boolean found = false;
		
    	for(int i = 0; i < bookCnt && !found; i++){
    		if(arrBooks[i].getTitle().equals(title)){
    			found = true;
    			for(int j = i; j < bookCnt - 1; j++)
    				arrBooks[j] = arrBooks[j + 1];
    				
    			bookCnt--;
    		}	
    	}
    	
    	if(found)
    		System.out.println(title + " has been successfully removed from the shelf!");
    	else
    		System.out.println(title + " cannot be found in the shelf!");
    }
    
    private boolean checkYear(int bookYear, char mode, int compYear){
    	switch(mode){
    		case '<': if(bookYear < compYear)
    				      return true;
    			      else return false;
    			
    		case '>': if(bookYear > compYear)
    				      return true;
    			      else return false;
    			
    		case '=': if(bookYear == compYear)
    				      return true;
    			      else return false;
					  
    		default: return false;	
    	}
    }

	public void displayShelfDetails(){
    	System.out.println(category + "\t" + location);
    }
	
    public int findYear(char mode, int year){
    	int cnt = 0;
		
		displayShelfDetails();
    	System.out.println("Books published " + mode + " " + year);
		
    	for(int i = 0; i < bookCnt; i++){
    		if(checkYear(arrBooks[i].getYear(), mode, year)){
    			arrBooks[i].displayDetails();
    			cnt++;
    		}
    	}
 
    	return cnt;
    }
    
    public void displayAllBooks(){
    	displayShelfDetails();
		
    	for(int i = 0; i < bookCnt; i++)
    		arrBooks[i].displayDetails();
		
    	System.out.println();
    }
}