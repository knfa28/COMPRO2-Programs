public class Customer
{
   private String name;
   private boolean member;
   private String memberType;
   
   public Customer( String name )
   {
      this.name = name;
	  member = false;
   }
   
   public String getName()
   {
      return name;
   }
   
   public boolean isMember()
   {
      return member;
   }
   
   public void setMember( boolean member )
   {
      this.member = member;	  
	  
	  if( member )
	     memberType = "Silver";
   }
   
   public String getMemberType()
   {
      return memberType;
   }
   
   public void setMemberType( String type )
   {
      memberType = type;
   }
   
   public String toString()
   {
      String temp = ( "Name: " + name + "\nIs Member? " + member );
	  
	  if( member )
	     temp += ( "Member Type: " + memberType );
	  
	  return temp;
   }
}