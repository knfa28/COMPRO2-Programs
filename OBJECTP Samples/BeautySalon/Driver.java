import java.util.*;

public class Driver
{
   public static void main( String[] args )
   { 
      Customer c = new Customer( "Hermione" );
      Visit v = new Visit( c, new Date() );
	  v.setServiceExpense( 1000 );
	  v.setProductExpense( 250 );
	  
	  System.out.println( v.getTotalExpense() );
	  
	  c.setMember( true );
	  c.setMemberType( "Premium" );
	  
	  System.out.println( v.getTotalExpense() );
	  
	  
	  
   }
}