import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GUITest10 extends JFrame
{
   private JPanel panel, gLayout, gbLayout; //panels
   private JButton[] keypad, keypadv2; //keys
   private JButton bPlus, bMinus, bMult, bDiv, bEquals, bPeriod,
                   bPlus2, bMinus2, bMult2, bDiv2, bEquals2, bPeriod2,
				   bClear, bClear2, bCA, bCA2; 
				   //operations
   private JTextField screen, screen2; //display screen
   private double d1 = 0; //result
   
   //operator
   private static final int NONE = 0, ADD = 1, SUB = 2, MULT = 3, DIV = 4;
   
   //current operation
   private int operation = NONE;
   
   //whether next input is new
   private boolean newInput = true;
   
   public static void main( String[] args )
   {
      new GUITest10();
   }
   
   public GUITest10()
   {
      setTitle( "Grid Layouts" );
      setDefaultCloseOperation( EXIT_ON_CLOSE );
	  setResizable( false );
	  
	  panel = new JPanel();
	  add( panel );
	  
	  //grid layout places elements in a grid. The constructor needs a number of
	  //rows, no. of cols, horizontal spacing, and vertical spacing. Placing 0
	  //as one of the first arguments tells Java to put as many rows as needed
	  gLayout = new JPanel( new GridLayout( 0, 4, 2, 2 ) );
	  
	  //initializes keypad
	  keypad = new JButton[10];
	  for( int i = 0; i < 10; i++ )
	  {
	     Integer conv = new Integer( i );
	     String temp = conv.toString();
	     keypad[i] = new JButton( temp );
	  }
	  
	  bPlus = new JButton( "+" );
	  bMinus = new JButton( "-" );
	  bMult = new JButton( "x" );
	  bDiv = new JButton( "/" );
	  bEquals = new JButton( "=" );
	  bPeriod = new JButton( "." );
	  bClear = new JButton( "C" );
	  bCA = new JButton( "CA" );
	  
	  screen = new JTextField( 20 );
	  screen.setEditable( false );
	  
	  //adding elements
	  gLayout.add( screen );
	  
	  for( JButton k: keypad )
	     gLayout.add( k );
	  
	  gLayout.add( bPlus );
	  gLayout.add( bMinus );
	  gLayout.add( bMult );
	  gLayout.add( bDiv );
	  gLayout.add( bEquals );
	  gLayout.add( bPeriod );
	  gLayout.add( bClear );
	  gLayout.add( bCA );
	  
	  gLayout.setBorder( BorderFactory.createTitledBorder( "Grid Layout" ) );
	  //panel to be added later
	  
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
	  
	  screen2 = new JTextField( 20 );
	  screen2.setEditable( false );
	  screen2.setText( "0" );
	  
	  //add screen with given constraints. DO NOT FORGET to pass the constraints
	  //as a parameter
	  gbLayout.add( screen2, gc );
	  
	  //next components have width 1
	  gc.gridwidth = 1;
	  
	  
	  CalcListen cl = new CalcListen();
	  KeyListen kl = new KeyListen();
	  
	  keypadv2 = new JButton[10];
	  for( int i = 0; i < 10; i++ )
	  {
	     Integer conv = new Integer( i );
	     String temp = conv.toString();
	     keypadv2[i] = new JButton( temp );
		 keypadv2[i].addActionListener( cl );
		 keypadv2[i].addKeyListener( kl );
	  }
	  
	  //lay out keypad
	  for( int i = 0; i < 3; i++ )
	     for( int j = 0; j < 3; j++ )
		 {
	        gc.gridx = j;
	        gc.gridy = i + 1;
			gbLayout.add( keypadv2[ 3 * i + j + 1 ], gc );
	     }
	  
	  bPlus2 = new JButton( "+" );
	  bMinus2 = new JButton( "-" );
	  bMult2 = new JButton( "x" );
	  bDiv2 = new JButton( "/" );
	  bEquals2 = new JButton( "=" );
	  bPeriod2 = new JButton( "." );
	  bClear2 = new JButton( "C" );
	  bCA2 = new JButton( "CA" );
	  
	  bPlus2.addActionListener( cl );
	  bPlus2.addKeyListener( kl );
	  bMinus2.addActionListener( cl );
	  bMinus2.addKeyListener( kl );
	  bMult2.addActionListener( cl );
	  bMult2.addKeyListener( kl );
	  bDiv2.addActionListener( cl );
	  bDiv2.addKeyListener( kl );
	  bEquals2.addActionListener( cl );
	  bEquals2.addKeyListener( kl );
	  bPeriod2.addActionListener( cl );
	  bPeriod2.addKeyListener( kl );
	  bClear2.addActionListener( cl );
	  bClear2.addKeyListener( kl );
	  bCA2.addActionListener( cl );
	  bCA2.addKeyListener( kl );
	  
	  //lay out operator buttons
	  gc.gridx = 3;
	  
	  gc.gridy = 1;
	  gbLayout.add( bPlus2, gc );
	  gc.gridy = 2;
	  gbLayout.add( bMinus2, gc );
	  gc.gridy = 3;
	  gbLayout.add( bMult2, gc );
	  gc.gridy = 4;
	  gbLayout.add( bDiv2, gc );
	  
	  //lay out other buttons
	  gc.gridx = 0;
	  gbLayout.add( keypadv2[0], gc );
	  gc.gridx = 1;
	  gbLayout.add( bPeriod2, gc );
	  gc.gridx = 2;
	  gbLayout.add( bEquals2, gc );
	  
	  gc.gridx = 0;
	  gc.gridy = 5;
	  gc.gridwidth = 2;
	  gbLayout.add( bClear2, gc );
	  gc.gridx = 2;
	  gbLayout.add( bCA2, gc );
	  
	  screen2.addKeyListener( kl );
	  
	  gbLayout.
	     setBorder( BorderFactory.createTitledBorder( "Grid Bag Layout" ) );
		 
	  //add both panels
	  panel.add( gbLayout );
	  panel.add( gLayout );
	  
	  setLocation( 80, 200 );
	  
	  //setSize( 700, 700 );
	  pack();
	  
	  setVisible( true );
   }
   
   //the remainder of this code is for making the grid bag calculator work. 
   //I suggest you try this out yourself. I will NOT comment on this segment.
   //actually, ktmd lng. =) :-P :-D
   private int getButton( Object o )
   {
      for( int i = 0; i < 10; i++ )
	     if( o == keypadv2[i] )
		    return i;
	  
	  return -1;
   }
   
   private void processOperation()
   {
      if( operation == ADD )
	     d1 += Double.parseDouble( screen2.getText() );
      else if( operation == SUB )
	     d1 -= Double.parseDouble( screen2.getText() );
	  else if( operation == MULT )
	     d1 *= Double.parseDouble( screen2.getText() );
	  else if( operation == DIV )
      {
	     double d = Double.parseDouble( screen2.getText() );
			   
		 if( d == 0 )
		    JOptionPane.showMessageDialog( GUITest10.this, "Cannot Divide by " +
			                               "Zero", "Error", 
										   JOptionPane.ERROR_MESSAGE );
         else d1 /= d;
      }
	  else d1 = Double.parseDouble( screen2.getText() );
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
			   screen2.setText( "" );
			   newInput = false;
			}
			   
			if( c != '0' )
			   screen2.setText( screen2.getText() + c );
			else if( screen2.getText().length() == 0 )
			      screen2.setText( "0" );
			else screen2.setText( screen2.getText() + "0" );
		 }
		 
		 else if( c == '.' && !screen2.getText().contains( "." ) )
   		    screen2.setText( screen2.getText() + "." );
	     else if( c == '+' || c == '-' || c == '*' || c == 'x' || c == '/' )
		 {
		    processOperation();
			Double d = new Double( d1 );
			
			screen2.setText( d.toString() );
			
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
			
			screen2.setText( d.toString() );
			
			newInput = true;
		 }
		 else if( c == 8 )
		 {
		    if( screen2.getText().length() == 1 )
			{
			   screen2.setText( "0" );
			   newInput = true;
			}
			else screen2.setText( screen2.getText().substring( 0, screen2.
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
			   screen2.setText( "" );
			   newInput = false;
			}
			   
			if( index != 0 )
			   screen2.setText( screen2.getText() + index );
			else if( screen2.getText().length() == 0 )
			      screen2.setText( "0" );
			else screen2.setText( screen2.getText() + "0" );
		 }
		 else if( o == bPeriod2 && !screen2.getText().contains( "." ) )
   		    screen2.setText( screen2.getText() + "." );
	     else if( o == bClear2 )
		 {
		    if( screen2.getText().length() == 1 )
			{
			   screen2.setText( "0" );
			   newInput = true;
			}else screen2.setText( screen2.getText().substring( 0, screen2.
			                      getText().length() - 1 ) );
		 }
		 else if( o == bCA2 )
		 {
		    newInput = true;
			screen2.setText( "0" );
			operation = NONE;
		 }
	     else if( o != bEquals2 && o != bPeriod2 )
		 {
		    processOperation();
			Double d = new Double( d1 );
			
			screen2.setText( d.toString() );
			
			if( o == bPlus2 )
			   operation = ADD;
			else if( o == bMinus2 )
			   operation = SUB;
			else if( o == bMult2 )
			   operation = MULT;
			else if( o == bDiv2 )
			   operation = DIV;
			
			newInput = true;
		 }
		 else if( o == bEquals2 )
		 {
		    processOperation();
			operation = NONE;
			Double d = new Double( d1 );
			
			screen2.setText( d.toString() );
			
			newInput = true;
		 }
	  } 
   }
}