import java.util.*;

/**
* represents a study session
*/
public class Session
{
   private String course; //course focused on
   private String topics; //coverage of session
   private List<Member> members; //members attending session
   private List<Tutor> tutors; //tutors presiding session
   private final int MAX_PEOPLE; //maximum number of people
    
   /**
   * constructor for session
   * @param course course focused on
   * @param topics coverage of session
   * @param maxPeople maximum number of people allowed in session
   */
   public Session( String course, String topics, int maxPeople )
   {
      this.course = course;
	  this.topics = topics;
	  MAX_PEOPLE = maxPeople;
	  members = new ArrayList<Member>();
	  tutors = new ArrayList<Tutor>();
   }
    
   /**
   * returns course the session is about
   * @return course the session is about
   */
   public String getCourse()
   {
      return course;
   }
    
   /**
   * returns the first tutor added to this session
   * @return the first tutor added to this session
   */
   public Tutor getLeadTutor()
   {
      return tutors.get(0);
   }
   
   /**
   * returns the coverage of this session
   * @return coverage of this session
   */
   public String getTopics()
   {
      return topics;
   }
    
   /**
   * returns number of members attending the session
   * @return number of members attending the session
   */
   public int getMemberCnt()
   {
      return members.size();
   }
    
   /**
   * returns number of tutors presiding over the session
   * @return number of tutors presiding over the session
   */
   public int getTutorCnt()
   {
      return tutors.size();
   }
    
   /**
   * returns maximum number of people allowed in session
   * @return maximum number of people allowed in session
   */
   public int getMaxPeople()
   {
      return MAX_PEOPLE;
   }
    
   /**
   * adds a member to the session
   * @param member Member Object to be added
   * @return true if there was still space, false otherwise
   */
   public boolean addMember( Member member )
   {
      //if there is still space
      if( getTutorCnt() + getMemberCnt() < MAX_PEOPLE )
	  {
	     members.add( member );
		 return true;
	  }
	  else return false;
   }
    
   /**
   * adds a member to the session
   * @param tutor Tutor Object to be added
   * @return true if there was still space, false otherwise
   */
   public boolean addTutor( Tutor tutor )
   {
      //if there is still space
      if( getTutorCnt() + getMemberCnt() < MAX_PEOPLE )
	  {
	     tutors.add( tutor );
		 return true;
	  }
	  else return false;
   }
    
   /**
   * returns string representation of this session
   * @return string representation of this session
   */
   public String toString()
   {
      //gets main details
      String temp = " Course: " + course + "\n  Topics: " + topics + "\n  Tut" +
	                "ors: \n";
	  
	  //adds names of tutors
	  for( int i = 0; i < getTutorCnt(); i++ )
	     temp += ( "   " + tutors.get(i).getName() + "\n" );
	  
	  temp += "\n  Members: \n";
	  
	  //adds names of members
	  for( int i = 0; i < getMemberCnt(); i++ )
	     temp += ( "   " + members.get(i).getName() + "\n" );
	  
	  return temp;
   }
}