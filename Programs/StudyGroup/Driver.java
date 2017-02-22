public class Driver
{
   public static void main( String[] args )
   {
      //instantiate new StudyGroup named JNM
      StudyGroup JNM = new StudyGroup( "JNM" );
	  
	  //add Austin as tutor
	  JNM.addTutor( "Austin" );
	  
	  //add members
	  JNM.addMember( "Kurt" );
	  JNM.addMember( "Beelzebub" ); //outlier
	  JNM.addMember( "Alds" );
	  JNM.addMember( "AJ" );
	  JNM.addMember( "Seaver" );
	  JNM.addMember( "Marc" );
	  JNM.addMember( "Johan" );
	  JNM.addMember( "Winona" );
	  JNM.addMember( "Stanley" );
	  JNM.addMember( "Clarisse" );
	  JNM.addMember( "Avril" );
	  JNM.addMember( "Hillary" );
	  JNM.addMember( "Cheng" );
	  
	  //print details
	  System.out.println( JNM.toString() );
	  
	  //delete outlier demonic gluttonous bastard of hell
	  JNM.deleteMember( "Beelzebub" );
	  
	  //promotes 8 members to tutors
	  JNM.promoteMember( "Marc" );
	  JNM.promoteMember( "Johan" );
	  JNM.promoteMember( "Winona" );
	  JNM.promoteMember( "Stanley" );
	  JNM.promoteMember( "Clarisse" );
	  JNM.promoteMember( "Avril" );
	  JNM.promoteMember( "Hillary" );
	  JNM.promoteMember( "Cheng" );
	  
	  //adds specialty to tutors
	  JNM.getTutor( "Austin" ).addSpecialty( "DASALGO" );
	  JNM.getTutor( "Johan" ).addSpecialty( "DISCTRU" );
	  JNM.getTutor( "Marc" ).addSpecialty( "OBJECTP" );
	  JNM.getTutor( "Marc" ).addSpecialty( "TREDONE" ); //Trolling Marc
	  JNM.getTutor( "Clarisse" ).addSpecialty( "OBJECTP" );
	  JNM.getTutor( "Avril" ).addSpecialty( "CCSCAL1" );
	  JNM.getTutor( "Winona" ).addSpecialty( "CCSTRIG" );
	  JNM.getTutor( "Stanley" ).addSpecialty( "COMPRO2" );
	  
	  //adds a session for Austin
	  JNM.addSession( "Austin", "DASALGO", "Frequency Count", 8 );
	  
	  //assigns session to temporary variable
	  Session temp = JNM.getSession( "Austin", "DASALGO" );
	  
	  //if session was not found
	  if( temp == null )
	     System.out.println( "No such session" );
	  else
	  {
	     //lets three members attend
	     JNM.getMember( "Kurt" ).attend( temp );
		 JNM.getMember( "Alds" ).attend( temp );
		 JNM.getMember( "AJ" ).attend( temp );
	  }
	  
	  System.out.println( "\n\nAfter promoting tutors, removing Beelzebub and" +
	                      " adding DASALGO Session:\n" + JNM.toString() );
	  
	  //lets Alds request an OBJECTP session for five people
	  JNM.addRequest( "Alds", "Marc", "OBJECTP", "Inheritance", 5 );
	  
	  //Marc accepts request
	  JNM.acceptRequest( "Marc", "OBJECTP" );
	  
	  //assigns session to temp variable
	  temp = JNM.getSession( "Marc", "OBJECTP" );
	  
	  //lets 2 more people attend session
	  JNM.getMember( "AJ" ).attend( temp );
	  JNM.getMember( "Seaver" ).attend( temp );
	  
	  //displaying stats
	  System.out.println( "\n\nAfter Alds requesting OBJECTP session from Mar" +
	                      "c, Marc accepting, and AJ and Seaver joining OBJEC" +
						  "TP Session:\n" + JNM.toString() );
   }
}