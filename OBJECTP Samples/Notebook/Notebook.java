public class Notebook
{
   private String color;
   private Page[] pages;
   private int pageCtr;
   private final int PAGE_MAX_LEN;
   
   public Notebook( String color, int numPages, int pageMaxLen )
   {
      this.color = color;
	  pages = new Page[numPages];
	  pageCtr = 0;
	  PAGE_MAX_LEN = pageMaxLen;
	  
	  for( int i = 0; i < numPages; i++ )
	     pages[i] = new Page( PAGE_MAX_LEN );
   }
   
   public void write( String text )
   {
      String leftover = text;
	  
      do
	  {
	     leftover = pages[pageCtr].write(leftover);
	     if( leftover != null )
		   pageCtr++;
	  }while( leftover != null && pageCtr < pages.length );
   }
   
   public void readPage( int pageNo )
   {
      if( pageNo >= 1 && pageNo <= pageCtr )
	     pages[pageNo - 1].display();
	  else System.out.println( "No such page" );
   }
   
   public Page turnPage( int pageNo )
   {
      if( pageNo >= 1 && pageNo <= pageCtr )
	     return pages[ pageNo - 1 ];
	  else return null;
   }
}