import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*; 
import java.text.*; //for number format
import javax.swing.border.*; 

public class GUITest4 extends JFrame
{
   private JPanel mainPanel;
   private JButton calc;
   private JLabel num1, num2, count;
   private JTextField input1, input2;
   private JCheckBox dollar, comma; 
   private JRadioButton add, sub, mult, div;
   private JSlider slide;
   private double d1, d2, result;
   
   public static void main( String[] args )
   {
      new GUITest4();
   }
   
   public GUITest4()
   {
      setSize( 400, 400 );
	  
	  setLocationRelativeTo( null );
	  
	  setResizable( false );
	  
	  setTitle( "Now You're Thinking With Sliders, Checkboxes, Radio Shit 'n " +
	            "shit! =)");
	  
	  setDefaultCloseOperation( EXIT_ON_CLOSE );
	  
	  mainPanel = new JPanel();
	  add(mainPanel);
	  
	  calc = new JButton();
	  calc.setText( "Calculate" );
	  
	  //makes action listener for button
	  LButton lb = new LButton();
	  
	  //adds action listener
	  calc.addActionListener( lb );
	  
	  mainPanel.add( calc );
	  
	  num1 = new JLabel("Number 1 ");
	  
	  mainPanel.add( num1 );
	  
	  input1 = new JTextField( "", 5 );
	  
	  mainPanel.add( input1 );
	  
	  num2 = new JLabel("Number 2 ");
	  
	  mainPanel.add( num2 );
	  
	  input2 = new JTextField( "", 5 );
	  
	  mainPanel.add( input2 );
	  
	  dollar = new JCheckBox("Dollar Sign");
	  
	  mainPanel.add( dollar );
	  
	  comma = new JCheckBox( "Comma Separator" );
	  
	  mainPanel.add( comma, true );
	  
	  add = new JRadioButton( "Add" );
	  sub = new JRadioButton( "Subtract" );
	  mult = new JRadioButton( "Multiply" );
	  div = new JRadioButton( "Divide" );
	  
	  ButtonGroup bg = new ButtonGroup();
	  
	  bg.add( add );
	  bg.add( sub );
	  bg.add( mult );
	  bg.add( div );
	  
	  JPanel subPan = new JPanel();
	  
	  Border subBorder = BorderFactory.createTitledBorder( "What to do with " + 
	                                                       "numbers?");
	  
	  subPan.setBorder( subBorder );
	  
	  subPan.add( add );
	  subPan.add( sub );
	  subPan.add( mult );
	  subPan.add( div );
	  
	  mainPanel.add( subPan );
	  
	  add.setSelected( true );
	  
	  count = new JLabel( "Perform How Many Times? ");
	  
	  mainPanel.add( count );
	  
	  slide = new JSlider( 0, 99, 1 );
	  
	  slide.setMinorTickSpacing( 1 );
	  
	  slide.setMajorTickSpacing( 15 );
	  
	  slide.setPaintTicks( true );
	  
	  slide.setPaintLabels( true );
	  
	  SlideListen sl = new SlideListen();
	  
	  slide.addChangeListener( sl );
	  
	  mainPanel.add( slide );
	  
	  setVisible( true );
	  
	  input1.requestFocus();
   }
   
   //action listener
   private class LButton implements ActionListener
   {
      //when button is clicked
      public void actionPerformed( ActionEvent e )
	  {
	     //if it comes from calculate button
	     if( e.getSource() == calc )
		 {
		    try
			{
			   //try parsing current text fields' contents
		       d1 = Double.parseDouble( input1.getText() );
			   d2 = Double.parseDouble( input2.getText() );
			}
			catch( NumberFormatException nfe )
			{
			   //display error for incorrect input
			   JOptionPane.showMessageDialog( GUITest4.this, "Invalid Input", 
			                                  "ERROR!", 
											  JOptionPane.ERROR_MESSAGE );
			  
			  //close everything
			  System.exit(0);
			}
			
			//calls appropriate function
			if( add.isSelected() )
			   result = addNums( d1, d2, slide.getValue() );
			else if( sub.isSelected() )
			   result = subNums( d1, d2, slide.getValue() );
			else if( mult.isSelected() )
			   result = multNums( d1, d2, slide.getValue() );
			else if( d2 == 0 ) //if dividing by zero
			{
			   JOptionPane.showMessageDialog( GUITest4.this, "Cannot Divide " +
			                                  "by Zero!", "DIVIDE BY ZERO!?!",
											  JOptionPane.WARNING_MESSAGE );
			}
			else result = divNums( d1, d2, slide.getValue() );
			
			if( !div.isSelected() || d2 != 0 )
			   //chooses proper display
			   if( comma.isSelected() )
			   {
			      //formats with commas
			      NumberFormat nf = NumberFormat.getNumberInstance();
			      String disp = nf.format( result );
			   
			      //adds dollar sign
			      if( dollar.isSelected() )
			         disp = "$" + disp;
			      JOptionPane.showMessageDialog( GUITest4.this, disp, "TA-DA!", 
			                                     JOptionPane.
					   						     INFORMATION_MESSAGE );
			   }
			
			   //if with dollar sign only
			   else if( dollar.isSelected() )
			      //displays with dollar sign
			      JOptionPane.showMessageDialog( GUITest4.this, "$" + result,
			                                     "TA-DA!", 
			                                     JOptionPane.
											     INFORMATION_MESSAGE );
			
			   //shows plain number
			   else JOptionPane.showMessageDialog( GUITest4.this, result, 
			                                       "TA-DA!", 
												   JOptionPane.
												   INFORMATION_MESSAGE );
		 }
	  }
   }
   
   //change listener
   private class SlideListen implements ChangeListener
   {
      //when slider is moved
      public void stateChanged( ChangeEvent e )
	  {
	     //if slider being moved is slide (in case of many sliders)
	     if( e.getSource() == slide )
		    //reset label
	        count.setText( "Perform How Many Times? " + slide.getValue() );
	  }
   }
   
   //arithmetic functions. Basic stuff
    private double addNums( double d1, double d2, int count )
	{
	   double res = d1;
	   for( int i = 0; i < count; i++ )
	      res += d2;
		 
	   return res;
	}
	  
	private double subNums( double d1, double d2, int count )
	{
	   double res = d1;
	   for( int i = 0; i < count; i++ )
		 res -= d2;
		 
	   return res;
	}
	  
	private double multNums( double d1, double d2, int count )
	{
	   double res = d1;
	   for( int i = 0; i < count; i++ )
	      res *= d2;
	 
	   return res;
    }
	  
   private double divNums( double d1, double d2, int count )
   {
	    double res = d1;
	    for( int i = 0; i < count; i++ )
	    res /= d2;
	 
	 return res;
   }
}