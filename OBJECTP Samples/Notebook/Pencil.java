public class Pencil
{
   public static void write( Notebook nb, String text )
   {
      nb.write( text );
   }
   
   public static void erase( Notebook nb, int pageNo, int start, int end )
   {
      Page temp = nb.turnPage( pageNo );
	  
	  if( temp != null )
	  {
	     temp.erase( start, end );
	  }
   }
}