import java.util.*;

/**
* represents a tutor of a study group
*/
public class Tutor extends Member
{
   private List<String> specialties; //specialties of a tutor
   private int sessionsHeld; //number of sessions held by this tutor
   
   /**
   * constructor for a tutor
   * @param name name of tutor
   */
   public Tutor( String name )
   {
      super( name );
	  specialties = new ArrayList<String>();
	  sessionsHeld = 0;
   }
   
   /**
   * constructor for tutor who was promoted and has already attended sessions
   * @param name name of tutor
   * @param sessionCtr previous session count
   */
   public Tutor( String name, int sessionCtr )
   {
      super( name, sessionCtr );
	  specialties = new ArrayList<String>();
	  sessionsHeld = 0;
   }
   
   /**
   * returns number of sessions held by this tutor
   * @return number of sessions held by this tutor
   */
   public int getSessionsHeld()
   {
      return sessionsHeld;
   }
    
   /**
   * holds a session
   * @param course subject of the session
   * @param topics coverage of the session
   * @param maxPeople maximum number of people in session
   * @return Session object based on above information
   */
   public Session holdSession( String course, String topics, int maxPeople )
   {
      //creates new session
      Session newSess = new Session( course, topics,maxPeople );
	  
	  //add this tutor as lead tutor
	  newSess.addTutor( this );
	  
	  //increments sessions held by this tutor
	  sessionsHeld++;
	  
	  return newSess;
   }
    
   /**
   * adds a specialty to this tutor
   * @param course new specialty
   */
   public void addSpecialty( String course )
   {
      specialties.add( course );
   }
    
   /**
   * displays all specialties of this tutor
   */
   public void displaySpecialties()
   {
      System.out.println( "Specialties:\n" );
      for( int i = 0; i < specialties.size(); i++ )
	     System.out.println( specialties.get(i) );
   }
    
   /**
   * returns a string representation of this tutor
   * @return a string representation of this tutor
   */
   public String toString()
   {
      //gets the string representation of the member part of the tutor
      String temp = super.toString() + "\n  Sessions Held: " + sessionsHeld;
	  
	  //if this tutor has specialties listed
	  if( specialties.size() > 0 )
	  {
	     temp += "\n\n  Specialties: \n";
	     
		 //adds specialties to string
	     for( int i = 0; i < specialties.size(); i++ )
	        temp += ( "   " + specialties.get(i) + "\n" );
	  }
	  
	  return temp;
   }
   
   /**
   * accepts a session request
   * @param request session to accept
   * @return session held
   */
   public Session acceptRequest( Session request )
   {
      sessionsHeld++;
	  
	  return request;
   }
}
