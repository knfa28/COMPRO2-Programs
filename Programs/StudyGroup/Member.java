/**
* represents a study group member
*/
public class Member
{
   private String name; //name of member
   private int sessionCtr; //number of sessions attended
    
   /**
   * constructor for member
   * @param name name of member
   */
   public Member( String name )
   {
      this.name = name;
	  sessionCtr = 0;
   }
    
   /**
   * constructor for member who has already attended sessions before
   * @param name name of member
   * @param sessionCtr previous attended sessions
   */
   public Member( String name, int sessionCtr )
   {
      this.name = name;
	  this.sessionCtr = sessionCtr;
   }
    
   /**
   * returns name of member
   * @return name of member
   */
   public String getName()
   {
      return name;
   }
    
   /**
   * returns number of sessions attended by this member
   * @return number of sessions attended by this member
   */
   public int getSessionCtr()
   {
      return sessionCtr;
   }
    
   /**
   * lets this member attend a session
   * @param session session to attend
   * @return true if session exists and still has space, false otherwise
   */
   public boolean attend( Session session )
   {
      //if session exists and still has space
      if( session.addMember( this ) == true )
	  {
	     sessionCtr++;
		 return true;
	  }
	  else return false;
   }
    
   /**
   * returns string representation of this member
   * @return string representation of this member
   */
   public String toString()
   {
      return ( " Name: " + name + "\n  Sessions Attended: " + sessionCtr );
   }
   
   /**
   * lets this member request a session
   * @param tutor tutor to hold the session
   * @param course course to focus on
   * @param topics session coverage
   * @param maxPeople maximum number of people
   * @return session object requested
   */
   public Session requestSession( Tutor tutor, String course, String topics,
                                  int maxPeople )
   {
      //creates new session
      Session temp = new Session( course, topics, maxPeople );
	  
	  //adds requested tutor as lead
	  temp.addTutor( tutor );
	  
	  return temp;
   }
}