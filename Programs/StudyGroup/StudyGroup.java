import java.util.*;

/**
* represents a study group
*/
public class StudyGroup
{
   private String name; //name of study group
   private List<Member> members; //list of members
   private List<Tutor> tutors; //list of tutors
   private List<Session> sessions; //list of sessions
   private List<Session> requests; //list of unapproved requests
    
   /**
   * constructor for group
   * @param name name of group
   */
   public StudyGroup( String name )
   {
      this.name = name;
	  
	  //initializes all lists
	  members = new ArrayList<Member>();
	  tutors = new ArrayList<Tutor>();
	  sessions = new ArrayList<Session>();
	  requests = new ArrayList<Session>();
   }
    
   /**
   * returns name of study group
   * @return name of study group
   */
   public String getName()
   {
      return name;
   }
    
   /**
   * returns member with given name
   * @param name name of member
   * @return member object if found, null otherwise
   */
   public Member getMember( String name )
   {
      for( int i = 0; i < getMemberCtr(); i++ )
	     if( name.equals( members.get(i).getName() ) )
		    return members.get(i);
	  
	  return null;
   }
    
   /**
   * returns tutor with given name
   * @param name name of tutor
   * @return tutor object if found, null otherwise
   */
   public Tutor getTutor( String name )
   {
      for( int i = 0; i < getTutorCtr(); i++ )
	     if( name.equals( tutors.get(i).getName() ) )
		    return tutors.get(i);
	  
	  return null;
   }
    
   /**
   * returns number of members
   * @return number of members
   */
   public int getMemberCtr()
   {
      return members.size();
   }
    
   /**
   * returns number of tutors
   * @return number of tutors
   */
   public int getTutorCtr()
   {
      return tutors.size();
   }
    
   /**
   * returns number of sessions so far
   * @return number of sessions so far
   */
   public int getSessionCtr()
   {
      return sessions.size();
   }
    
   /**
   * adds a member to the study group
   * @param name name of member
   */
   public void addMember( String name )
   {
      members.add( new Member( name ) );
   }
    
   /**
   * adds a tutor to the study group
   * @param name name of tutor
   */
   public void addTutor( String name )
   {
      tutors.add( new Tutor( name ) );
   }
    
   /**
   * promotes a member to tutor
   * @param name name of member
   * @return true if successful, false otherwise
   */
   public boolean promoteMember( String name )
   {
      //searches for member
      for( int i = 0; i < getMemberCtr(); i++ )
	     //if match
	     if( name.equals( members.get(i).getName() ) )
		 {
		    //add to tutors
		    tutors.add( new Tutor( members.get(i).getName(), 
			            members.get(i).getSessionCtr() ) );
			//remove from members
			members.remove(i);
			return true;
		 }
	  
	  return false;
   }
   
   /**
   * adds a session to the list
   * @param name name of tutor
   * @param course course to be covered
   * @param topics coverage of session
   * @param maxPeople maximum number of people allowed
   * @return true if successful add, false if tutor does not exist
   */
   public boolean addSession( String name, String course, String topics, 
                             int maxPeople )
   {
      //find tutor
      Tutor temp = getTutor( name );
	  
	  //if tutor exists
	  if( temp != null )
	  {
	     //adds new session
	     sessions.add( temp.holdSession( course, topics, maxPeople ) );
		 return true;
	  }
	  else return false;
   }
    
   /**
   * returns session with tutor and course given
   * @param name name of tutor in-charge
   * @param course course covered
   * @return session with tutor and course given
   */
   public Session getSession( String name, String course )
   {
      //search from the end to get latest
      for( int i = getSessionCtr() - 1; i >= 0; i-- )
	  
	     //if match is found
	     if( name.equals( sessions.get(i).getLeadTutor().getName() ) && 
			 course.equals( sessions.get(i).getCourse() ) )
			 
			 //return session
		    return sessions.get(i);
	
	  return null;
   }   

   /**
   * deletes a member from the group
   * @param name name of member
   * @return true if successful, false if there is no such member
   */
   public boolean deleteMember( String name )
   {
      for( int i = 0; i < getMemberCtr(); i++ )
	     if( name.equals( members.get(i).getName() ) )
		 {
		    members.remove( i );
			return true;
		 }
	  
	  return false;
   }
    
   /**
   * deletes a tutor from the group
   * @param name name of tutor
   * @return true if successful, false if there is no such tutor
   */
   public boolean deleteTutor( String name )
   {
      for( int i = 0; i < getTutorCtr(); i++ )
	     if( name.equals( tutors.get(i).getName() ) )
		 {
		    tutors.remove( i );
			return true;
		 }
	  
	  return false;
   }
    
   /**
   * returns a string representation of this study group
   * @return string representation of this study group
   */
   public String toString()
   {
      //basic details
      String temp = "Name : " + name + "\nTutors: \n";
	  
	  //adds tutors' details
	  for( int i = 0; i < getTutorCtr(); i++ )
	     temp += ( tutors.get(i).toString() + "\n\n" );
	  
	  temp += "\nMembers: \n";
	  
	  //adds members' details
	  for( int i = 0; i < getMemberCtr(); i++ )
	     temp += ( members.get(i).toString() + "\n\n" );
		 
	  temp += "\nSessions: \n";
	  
	  //adds sessions' details
	  for( int i = 0; i < getSessionCtr(); i++ )
	     temp += ( sessions.get(i).toString() + "\n\n" );
      
	  temp += "\nRequests: \n";
	  
	  //adds requests' details
	  for( int i = 0; i < getRequestCtr(); i++ )
	     temp += ( requests.get(i).toString() + "\n\n" );
      
	  return temp;
   }
   
   /**
   * adds a session request
   * @param name name of requester
   * @param tutor name of tutor
   * @param course course covered
   * @param topics coverage
   * @param maxPeople maximum number of people in session
   * @return true if successful, false otherwise
   */
   public boolean addRequest( String name, String tutor, String course, 
                           String topics, int maxPeople )
   {
      //gets member and tutor instance
      Member temp = getMember( name );
	  Tutor t = getTutor( tutor );
	  
	  //if both exist
	  if( temp != null && t != null )
	  {
	     requests.add( temp.requestSession( t, course, topics, maxPeople ) );
		 return true;
	  }
	  return false;
   }
   
   /**
   * returns number of requests
   * @return number of requests
   */
   public int getRequestCtr()
   {
      return requests.size();
   }
   
   /**
   * gets index of request with given name and course
   * @param name name of lead tutors
   * @param course course covered
   * @return index of request
   */
   private int getRequestIndex( String name, String course )
   {
      for( int i = getRequestCtr() - 1; i >= 0; i-- )
	     if( name.equals( requests.get(i).getLeadTutor().getName() ) && 
		     course.equals( requests.get(i).getCourse() ) )
			 return i;
	  
	  return -1;
   }
   
   /**
   * gets request object with given name and course
   * @param name name of lead tutors
   * @param course course covered
   * @return request with given details
   */
   public Session getRequest( String name, String course )
   {
      for( int i = getRequestCtr() - 1; i >= 0; i-- )
	     if( name.equals( requests.get(i).getLeadTutor().getName() ) && 
		     course.equals( requests.get(i).getCourse() ) )
			 return requests.get(i);
	  
	  return null;
   }
   
   /**
   * transfers a request from request list to session list
   * @param tutor name of tutor
   * @param course course covered
   * @return true if successful
   */
   public boolean acceptRequest( String tutor, String course )
   {
      //gets index of request
      int i = getRequestIndex( tutor, course );
	  
	  //gets tutor object
	  Tutor tut = getTutor( tutor );
	  
	  //if both exist
	  if( i != -1 && tut != null )
	  {
	     //add session to main sessions
		 sessions.add( tut.acceptRequest( requests.get(i) ) );
		 
		 //remove it from requests
		 requests.remove(i);
		 return true;
	  }
	  else return false;
   }
   
   /**
   * decline request
   * @param tutor name of tutor
   * @param course course covered
   * @return true if successful
   */
   public boolean declineRequest( String tutor, String course )
   {
      //gets index
      int i = getRequestIndex( tutor, course );
	  
	  //if request exists
	  if( i != -1  )
	  {
	     //remove request
	     requests.remove(i);
		 return true;
	  }
	  else return false;
   }
}