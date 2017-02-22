public class LibraryDriver {

    public static void main(String[] args){
		Book b1 = new Book("The Notebook", "Nicholas Sparks", 2001);
    	Book b2 = new Book("Harry Potter and the Order of the Phoenix", "J.K. Rowling", 2005);
    	Book b3 = new Book("The Calculus 7", "Leithold", 1992);
    	Book b4 = new Book("Java: How to Program", "Deitel and Deitel", 2005);
    	Book b5 = new Book("Michael Jordan: A biography", "David L. Prter", 2007);
		
    	BookShelf bs1 = new BookShelf("Fiction", 10, "North 305A");
    	BookShelf bs2 = new BookShelf("Science and Mathematics", 5, "East 305A");
    	BookShelf bs3 = new BookShelf("Sports", 5, "South 305A");
    	
    	bs1.addBook(b1);
    	bs1.addBook(b2);
    	bs2.addBook(b3);
    	bs2.addBook(b4);
    	bs3.addBook(b5);
		
       	bs1.displayAllBooks();
    	bs2.displayAllBooks();
    	bs3.displayAllBooks();
    	
    	int cnt1 = bs1.findYear('>', 2000);
    	System.out.println("Total number of books: " + cnt1 + "\n");
    	
		int cnt2 = bs2.findYear('>', 2000);
    	System.out.println("Total number of books: " + cnt2 + "\n");
    	
		int cnt3 = bs3.findYear('>', 2000);
    	System.out.println("Total number of books: " + cnt3 + "\n");
    	
    	if(cnt1 >= 2) bs1.displayShelfDetails();
    	if(cnt2 >= 2) bs2.displayShelfDetails();
    	if(cnt3 >= 2) bs3.displayShelfDetails();	
    }
}