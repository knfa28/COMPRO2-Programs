public class Page
{
   private String content;
   private final int maxLen;
   
   public Page( int maxLen )
   {
      this.maxLen = maxLen;
	  content = "";
   }
   
   public void display()
   {
      System.out.println( content );
   }
   
   public String write( String text )
   {
      
      if( content.length() + text.length() <= maxLen )
	  {
	     content += text;
		 return null;
	  }
	  else
	  {
	     int remainder = maxLen - content.length();
	     content += text.substring( 0, remainder );
		 return text.substring( remainder );
	  }
   }
   
   public int getTextLen()
   {
      return content.length();
   }
   
   public void erase( int start, int end )
   {
     String spaces = "";
	 
	 for( int i = start; i < end; i++ )
	    spaces += " ";
	 
	 content = ( content.substring( 0, start ) + spaces + 
	             content.substring( end ) );
   }
}