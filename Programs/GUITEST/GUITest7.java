import java.util.*;
import java.text.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GUITest7 extends JFrame
{
   JPanel panel;
   JButton check;
   JSpinner spinBasic, spinRange, spinString, spinDate; //spinners
   
   public static void main( String[] args )
   {
      new GUITest7();
   }
   
   public GUITest7()
   {
      setTitle( "You Spin My Head Right Round" );
      setLocationRelativeTo( null );
	  setDefaultCloseOperation( EXIT_ON_CLOSE );
	  
	  panel = new JPanel();
	  add( panel );
	  
	  //adding button
	  check = new JButton( "Check" );
	  PressL pl = new PressL();
	  check.addActionListener( pl );
	  panel.add( check );
	  
	  //basic spinner only cycles through integers
	  spinBasic = new JSpinner();
	  panel.add( spinBasic );
	  
	  //spinner's size is automatically set to size of first element. You may
	  //adjust this as follows
	  Dimension d = spinBasic.getPreferredSize();
	  d.width = 40;
	  spinBasic.setPreferredSize( d );
	  
	  //spinner can have range. The SpinnerNumberModel constructor needs
	  //the initial value, minimum value, maximum value, and increment per but-
	  //ton press for its constructor
	  spinRange = new JSpinner( new SpinnerNumberModel( 1, 1, 100, 1 ) );
      panel.add( spinRange );
	  
	  //strings to use for next spinner
	  String[] majors = { "BASICON", "COMPRO1", "COMPRO2", "DISCTRU", "OBJECTP", 
	                      "DASALGO" };
						  
	  //list spinner cycles through elements of a list
	  spinString = new JSpinner( new SpinnerListModel( majors ) );
	  panel.add( spinString );
	  
	  //adjusting size
	  d = spinString.getPreferredSize();
	  d.width = 75; //set your width
	  spinString.setPreferredSize( d );
	  
	  //you can make a date spinner too. Constructor requires default date, 
	  //minimum date, maximum date, and increment per button press
	  spinDate = new JSpinner( new SpinnerDateModel( new Date(), null, null, 
	                                                  Calendar.DAY_OF_MONTH ) );
	  //you can set the default format by instantiating the nested class
	  //DateEditor
	  JSpinner.DateEditor de = new JSpinner.DateEditor( spinDate, "MM/dd/yy");
	  
	  //then set the spinner's editor to the one you made
	  spinDate.setEditor( de );
	  panel.add(spinDate);
	  
	  setSize( 300, 150 );
	  setVisible( true );
   }
   
   private class PressL implements ActionListener
   {
      public void actionPerformed( ActionEvent e )
	  {
	     if( e.getSource() == check )
		 {
		    DateFormat df = new SimpleDateFormat( "MM/dd/yy" );
			
			//to get values, simply use the getValue() method
		    String s = "SpinBasic: " + spinBasic.getValue() + "\nSpinRange: " + 
			           spinRange.getValue() + "\nSpinString: " + spinString.
					   getValue() + "\nSpinDate: " + df.format( spinDate.
					   getValue() );

            //show details
			JOptionPane.showMessageDialog( GUITest7.this, s, "Info", 
			                               JOptionPane.INFORMATION_MESSAGE );
		 }
	  }
   }
}