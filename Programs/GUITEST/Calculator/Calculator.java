import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Calculator extends JFrame
{
   private JPanel panel, gLayout, gbLayout; //panels
   private JButton[] keypad; //keys
   private JButton bPlus, bMinus, bMult, bDiv, bEquals, bPeriod,
				   bClear, bCA;
				   //operations
   private JTextField screen; //display screen
   private double d1 = 0; //result
   
   //operator
   private static final int NONE = 0, ADD = 1, SUB = 2, MULT = 3, DIV = 4;
   
   //current operation
   private int operation = NONE;
   
   //whether next input is new
   private boolean newInput = true;
   
   public static void main( String[] args )
   {
      new Calculator();
   }
   
   public Calculator()
   {
      setTitle( "Calculator" );
      setDefaultCloseOperation( EXIT_ON_CLOSE );
	  setResizable( false );
	  
	  //grid bag layout allows you to determine where to place the components in
	  //the panel
	  gbLayout = new JPanel();
	  gbLayout.setLayout( new GridBagLayout() );
	  
	  //declare a constraint holder
	  GridBagConstraints gc = new GridBagConstraints();
	  
	  gc.gridx = 0; //x-position of next component
	  gc.gridy = 0; //y-position of next component
	  
	  //size of next component
	  gc.gridwidth = 4; 
	  gc.gridheight = 1;
	  
	  //determines which components to prioritze when arranging components 
	  //onscreen
	  gc.weightx = 50;
	  gc.weighty = 50;
	  
	  gc.insets = new Insets( 2, 2, 2, 2 ); //surrounding spacing
	  gc.anchor = GridBagConstraints.CENTER; //where to push component in case 
	                                         //it doesn't fill the allotted 
											 //space completely
	  gc.fill = GridBagConstraints.BOTH; //where to stretch a component that 
	                                     //doesn't fill a space completely
										 //NONE means do not stretch
										 //VERTICAL means stretch vertically
										 //HORIZONTAL, guess...
										 //or BOTH as used here
	  
	  screen = new JTextField( 20 );
	  screen.setEditable( false );
	  screen.setText( "0" );
	  
	  //add screen with given constraints. DO NOT FORGET to pass the constraints
	  //as a parameter
	  gbLayout.add( screen, gc );
	  
	  //next components have width 1
	  gc.gridwidth = 1;
	  
	  CalcListen cl = new CalcListen();
	  KeyListen kl = new KeyListen();
	  
	  keypad = new JButton[10];
	  for( int i = 0; i < 10; i++ )
	  {
	     Integer conv = new Integer( i );
	     String temp = conv.toString();
	     keypad[i] = new JButton( temp );
		 keypad[i].addActionListener( cl );
		 keypad[i].addKeyListener( kl );
	  }
	  
	  //lay out keypad
	  for( int i = 0; i < 3; i++ )
	     for( int j = 0; j < 3; j++ )
		 {
	        gc.gridx = j;
	        gc.gridy = i + 1;
			gbLayout.add( keypad[ 3 * i + j + 1 ], gc );
	     }
	  
	  bPlus = new JButton( "+" );
	  bMinus = new JButton( "-" );
	  bMult = new JButton( "x" );
	  bDiv = new JButton( "/" );
	  bEquals = new JButton( "=" );
	  bPeriod = new JButton( "." );
	  bClear = new JButton( "C" );
	  bCA = new JButton( "CA" );
	  
	  bPlus.addActionListener( cl );
	  bPlus.addKeyListener( kl );
	  bMinus.addActionListener( cl );
	  bMinus.addKeyListener( kl );
	  bMult.addActionListener( cl );
	  bMult.addKeyListener( kl );
	  bDiv.addActionListener( cl );
	  bDiv.addKeyListener( kl );
	  bEquals.addActionListener( cl );
	  bEquals.addKeyListener( kl );
	  bPeriod.addActionListener( cl );
	  bPeriod.addKeyListener( kl );
	  bClear.addActionListener( cl );
	  bClear.addKeyListener( kl );
	  bCA.addActionListener( cl );
	  bCA.addKeyListener( kl );
	  
	  //lay out operator buttons
	  gc.gridx = 3;
	  
	  gc.gridy = 1;
	  gbLayout.add( bPlus, gc );
	  gc.gridy = 2;
	  gbLayout.add( bMinus, gc );
	  gc.gridy = 3;
	  gbLayout.add( bMult, gc );
	  gc.gridy = 4;
	  gbLayout.add( bDiv, gc );
	  
	  //lay out other buttons
	  gc.gridx = 0;
	  gbLayout.add( keypad[0], gc );
	  gc.gridx = 1;
	  gbLayout.add( bPeriod, gc );
	  gc.gridx = 2;
	  gbLayout.add( bEquals, gc );
	  
	  gc.gridx = 0;
	  gc.gridy = 5;
	  gc.gridwidth = 2;
	  gbLayout.add( bClear, gc );
	  gc.gridx = 2;
	  gbLayout.add( bCA, gc );
	  
	  screen.addKeyListener( kl );
	  
	  //add both panels
	  add( gbLayout );
	  
	  setLocation( 80, 200 );
	  
	  //setSize( 700, 700 );
	  pack();
	  
	  setLocationRelativeTo( null );
	  setVisible( true );
   }
   
   //the remainder of this code is for making the grid bag calculator work. 
   //I suggest you try this out yourself. I will NOT comment on this segment.
   //actually, ktmd lng. =) :-P :-D
   private int getButton( Object o )
   {
      for( int i = 0; i < 10; i++ )
	     if( o == keypad[i] )
		    return i;
	  
	  return -1;
   }
   
   private void processOperation()
   {
      if( operation == ADD )
	     d1 += Double.parseDouble( screen.getText() );
      else if( operation == SUB )
	     d1 -= Double.parseDouble( screen.getText() );
	  else if( operation == MULT )
	     d1 *= Double.parseDouble( screen.getText() );
	  else if( operation == DIV )
      {
	     double d = Double.parseDouble( screen.getText() );
			   
		 if( d == 0 )
		    JOptionPane.showMessageDialog( Calculator.this, "Cannot Divide by" +
			                               " Zero", "Error", 
										   JOptionPane.ERROR_MESSAGE );
         else d1 /= d;
      }
	  else d1 = Double.parseDouble( screen.getText() );
   }
   
   private class KeyListen implements KeyListener
   {
      public void keyPressed( KeyEvent k )
	  {
	     char c = k.getKeyChar();
		 
		 if( c >= '0' && c <= '9' )
		 {
		    if( newInput )
			{
			   screen.setText( "" );
			   newInput = false;
			}
			   
			if( c != '0' )
			   screen.setText( screen.getText() + c );
			else if( screen.getText().length() == 0 )
			      screen.setText( "0" );
			else screen.setText( screen.getText() + "0" );
		 }
		 else if( c == '.' )
		 {
		    if( newInput )
			{
			   screen.setText("0.");
			   newInput = false;
			}
   		    else if ( !screen.getText().contains( "." ) )
			   screen.setText( screen.getText() + "." );
	     }
	     else if( c == '+' || c == '-' || c == '*' || c == 'x' || c == '/' )
		 {
		    processOperation();
			Double d = new Double( d1 );
			
			screen.setText( d.toString() );
			
			if( c == '+' )
			   operation = ADD;
			else if( c == '-' )
			   operation = SUB;
			else if( c == '*' || c == 'x' )
			   operation = MULT;
			else if( c == '/' )
			   operation = DIV;
			
			newInput = true;
		 }
		 else if( c == '=' || c == '\n' )
		 {
		    processOperation();
			operation = NONE;
			Double d = new Double( d1 );
			
			screen.setText( d.toString() );
			
			newInput = true;
		 }
		 else if( c == 8 )
		 {
		    if( screen.getText().length() == 1 )
			{
			   screen.setText( "0" );
			   newInput = true;
			}
			else screen.setText( screen.getText().substring( 0, screen.
			                      getText().length() - 1 ) );
		 }
	  }
	  
	  public void keyReleased( KeyEvent k )
	  {
	  }
	  
	  public void keyTyped( KeyEvent k )
	  {
	  }
   }
   
   private class CalcListen implements ActionListener
   {
      public void actionPerformed( ActionEvent e )
	  {
	     Object o = e.getSource();
		 
		 int index = getButton( o );
		 
		 if( index != -1 )
		 {
		    if( newInput )
			{
			   screen.setText( "" );
			   newInput = false;
			}
			   
			if( index != 0 )
			   screen.setText( screen.getText() + index );
			else if( screen.getText().length() == 0 )
			      screen.setText( "0" );
			else screen.setText( screen.getText() + "0" );
		 }
		 else if( o == bPeriod )
   		 {
		    if( newInput )
			{
			   screen.setText("0.");
			   newInput = false;
			}
   		    else if ( !screen.getText().contains( "." ) )
			   screen.setText( screen.getText() + "." );
	     }
	     else if( o == bClear )
		 {
		    if( screen.getText().length() == 1 )
			{
			   screen.setText( "0" );
			   newInput = true;
			}else screen.setText( screen.getText().substring( 0, screen.
			                      getText().length() - 1 ) );
		 }
		 else if( o == bCA )
		 {
		    newInput = true;
			screen.setText( "0" );
			operation = NONE;
		 }
	     else if( o != bEquals && o != bPeriod )
		 {
		    processOperation();
			Double d = new Double( d1 );
			
			screen.setText( d.toString() );
			
			if( o == bPlus )
			   operation = ADD;
			else if( o == bMinus )
			   operation = SUB;
			else if( o == bMult )
			   operation = MULT;
			else if( o == bDiv )
			   operation = DIV;
			
			newInput = true;
		 }
		 else if( o == bEquals )
		 {
		    processOperation();
			operation = NONE;
			Double d = new Double( d1 );
			
			screen.setText( d.toString() );
			
			newInput = true;
		 }
	  } 
   }
}