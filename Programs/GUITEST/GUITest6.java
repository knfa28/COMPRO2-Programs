import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GUITest6 extends JFrame
{
   JPanel panel;
   JButton check;
   JList<String> movies, books; //list component
   DefaultListModel<String> dlm; //manipulable list
   
   public static void main( String[] args )
   {
      new GUITest6();
   }
   
   public GUITest6()
   {
      setTitle( "Books and Film" );
      setLocationRelativeTo( null );
	  setResizable( false );
	  setDefaultCloseOperation( EXIT_ON_CLOSE );
	  
	  panel = new JPanel();
	  add( panel );
	  
	  //adding button
	  check = new JButton( "Check" );
	  PressL pl = new PressL();
	  check.addActionListener( pl );
	  panel.add( check );
	  
	  //array to add to list component
	  String[] films = { "Fight Club", "Reservoir Dogs", "Back to the Future",
	                     "The Lord of the Rings" };
	  
	  //creates list
	  movies = new JList<String>( films );
	  
	  //sets dimensions
	  movies.setFixedCellWidth( 150 );
	  movies.setFixedCellHeight( 30 );
	  
	  //sets selection mode. Right now, any set of items can be chosen
	  movies.setSelectionMode( ListSelectionModel.
	                            MULTIPLE_INTERVAL_SELECTION );
	  
	  //adds to frame
	  panel.add( movies );
	  
	  /*note that the above list is not very manipulable. Check the JList API
	    for what you can do with this*/
	  
	  
	  //another array to convert to list
	  String[] lit = { "A Storm of Swords", "Les Miserables", "Nineteen Eight" +
	                   "y-Four", "The Great Gatsby", "A Game of Thrones",
                       "Invisible Monsters", "Anna Karenina"  };
	  
	  //alternative way to add Objects to a list
	  dlm = new DefaultListModel<String>();
	  
	  //for each string in array, add to dlm
	  for( String s: lit )
	     dlm.add( dlm.size(), s );
		 
	  //adds dlm to books list
	  books = new JList<String>( dlm );
	  
	  //sets dimensions and selection style
	  books.setFixedCellWidth( 150 );
	  books.setFixedCellHeight( 30 );
	  
	  //only a set of adjacent elements can be chosen using this mode
	  books.setSelectionMode( ListSelectionModel.
	                            SINGLE_INTERVAL_SELECTION );
								
	  //only 5 elements at a time
	  books.setVisibleRowCount( 5 );
	  
	  //scroller for 2nd list
	  JScrollPane scroll = new JScrollPane( books, JScrollPane.
	                                      VERTICAL_SCROLLBAR_AS_NEEDED,
										  JScrollPane.
										  HORIZONTAL_SCROLLBAR_AS_NEEDED );
										  
	  //adds 2nd list to panel (note that the scroller is added, not the list)
	  panel.add( scroll );
	  
	  //sets ideal size for frame
	  pack();
	  
	  setVisible( true );
   }
   
   private class PressL implements ActionListener
   {
      public void actionPerformed( ActionEvent e )
	  {
	     if( e.getSource() == check )
		 {
		    //checks if "Titanic" is in dlm, which is 2nd list
		    String s = "\"Titanic\" is in the list: " + dlm.
			           contains( "Titanic" ) + "\nSecond List is empty: " + 
					   
					   //checks if 2nd list is empty      gets size of list
					   dlm.isEmpty() + "\nThere are " + dlm.size() + " elemen" +
					   "ts in the second list\n\nElements:\n";
			
			//converts dlm to array
			Object[] o = dlm.toArray();
			
			//for each string, print string
			for( Object s2: o )
			   s += s2 + "\n";
			   
			//show details
			JOptionPane.showMessageDialog( GUITest6.this, s, "Info", 
			                               JOptionPane.INFORMATION_MESSAGE );
		 }
	  }
   }
}