import java.awt.*; 
import java.awt.event.*; //for event listeners
import javax.swing.*; 

public class GUITest2 extends JFrame
{
   //variables declared as local before are now declared as attributes of the 
   //class
   private JPanel panel1;
   private JLabel label1;
   private JButton button1;
   private JTextField text1;
   private JTextArea area1;
   private JScrollPane scroll1;
   private int nClicks = 0;
   
   public static void main( String[] args )
   {
      new GUITest2(); 
   }
   
   public GUITest2()
   {
      setDefaultCloseOperation( EXIT_ON_CLOSE );
	  setTitle( "GUI Test, Bitch!");
	  
	  setSize( 400, 275 );
	  
	  
	  Toolkit t = Toolkit.getDefaultToolkit();
	  Dimension d = t.getScreenSize();
	  
	  setLocation( ( d.width - getWidth() ) / 2, 
	               ( d.height - getHeight() ) / 2 );

      setResizable( false );				   
		
	  panel1 = new JPanel();
	  
	  add( panel1 );
	  
	  label1 = new JLabel( "Testing GUI " );
	  
	  label1.setToolTipText( "Testing Tool Tip Text" );
	  
	  panel1.add( label1 );
	  
	  button1 = new JButton( "Click me, bitch!" );
	  
	  //creates an action listener for this button. MoanListen is a private 
	  //class. Code can be found below
	  MoanListen ml = new MoanListen();
	  
	  //adds above instance as an action listener for button1
	  button1.addActionListener( ml );
	  
	  //Focus is a focus listener (code below)
	  Focus dontLeave = new Focus( "HEY BABY, DON'T PUT ME IN THE CORNER!");
	  
	  //adds dontLeave as button1's focus listener
	  button1.addFocusListener( dontLeave );
	  
	  button1.setToolTipText( "Testing button's tip" );
	  
	  panel1.add( button1 );
	   
	  text1 = new JTextField( "Type on me, bitch!", 30 );
	  
	  panel1.add( text1 );
	  
	  text1.setToolTipText( "Testing text field's tips" );
	  
	  //new key listener class TextL(code below)
	  TextL tl = new TextL();
	  
	  //adds t1 as key listener for text field
	  text1.addKeyListener( tl );
	  
	  //focus listener with different message
	  Focus f = new Focus( "COME BAAAAAACK!!!!!!!!!!!");
	  
	  //adds f as focus listener
	  text1.addFocusListener( f );
	  
	  area1 = new JTextArea( 10, 20 );
	   
	  area1.setText( "Type more crap here!!!\nP.S. Adding \", bitch!\" to eve" +
	                 "rything is \ncompletely natural and appropriate,\nespec" +
					 "ially since Jesse from \"Breaking\nBad\" is awesome." +
					 "\n\n");
	  
	  area1.setLineWrap( true );
	  
	  area1.setWrapStyleWord( true );
	  
	  area1.append( "Line Count: " + area1.getLineCount() + "\n" );
	  
	  scroll1 = new JScrollPane( area1, 
	                                         JScrollPane.
											 VERTICAL_SCROLLBAR_AS_NEEDED, 
											 JScrollPane.
											 HORIZONTAL_SCROLLBAR_AS_NEEDED );
	  
	  panel1.add( scroll1 );
	  
	  setVisible( true );
	 
      //MListen is a mouse listener (code below)	 
	  MListen l4M = new MListen();
	  
	  //adds l4M as mouse listener to panel1
	  panel1.addMouseListener( l4M );
	  
	  area1.requestFocus();
	  
	  //WListen is a window listener (code below)
	  WListen wl = new WListen();
	  
	  //adds w1 as window listener for frame
	  addWindowListener( wl );
   }
   
   //mouse listener
   private class MListen implements MouseListener
   {
      //when button is pressed and released
      public void mouseClicked( MouseEvent e )
	  {
	     //displays position (note the methods for MouseEvent class)
	     area1.append( "Position: (" + e.getX() + "," + e.getY() +" )\n");
	  }
	  
	  //when mouse enters area
	  public void mouseEntered( MouseEvent e )
	  {
	     //displays screen position
	     area1.append( "Mouse Entered at (" + e.getXOnScreen() + "," + 
		               e.getYOnScreen() + ")\n" );
	  }
	  
	  //when mouse exits area
	  public void mouseExited( MouseEvent e )
	  {
	     area1.append( "Mouse Exited at (" + e.getXOnScreen() + "," + 
		               e.getYOnScreen() + ")\n" );
	  }
	  
	  //when a button is pressed
	  public void mousePressed( MouseEvent e )
	  {
	  }
	  
	  //when a button is released
	  public void mouseReleased( MouseEvent e )
	  {
	  }
   }
   
   //listens for button push
   private class MoanListen implements ActionListener
   {
      //when button is pushed
      public void actionPerformed( ActionEvent e )
	  {
	     //if button was button 1
	     if( e.getSource() == button1 )
		 {
		    nClicks++; //increment clicks
			
			//set text to appropriate message in cycle
			button1.setText( moaning[nClicks % moaning.length]);
		 }
	  }
   }
   
   //checks for key presses
   private class TextL implements KeyListener
   {
      //key is released
      public void keyReleased( KeyEvent e )
	  {
	  }
	  
	  //key is pressed
	  public void keyPressed( KeyEvent e )
	  {
	  }
	  
	  //key is pressed and released
	  public void keyTyped( KeyEvent e )
	  {
	     area1.append( "Typed: " + e.getKeyChar() + "\n" );
	  }
   }
   
   //checks for window operations
   private class WListen implements   WindowListener
   {
      //window is not active (in background)
      public void windowDeactivated( WindowEvent e )
	  {
	  
	  }
	  
	  //window is being used
	  public void windowActivated( WindowEvent e )
	  {
	     area1.setText( "WINDOW HERE!!!\n" + area1.getText() );
	  }
	  
	  //window is minimized
	  public void windowIconified( WindowEvent e )
	  {
	  
	  }
	  
	  //window is no longer minimized
	  public void windowDeiconified( WindowEvent e )
	  {
	  
	  }
	  
	  //window is closed
	  public void windowClosed( WindowEvent e )
	  {
	  
	  }
	  
	  //while closing
	  public void windowClosing( WindowEvent e )
	  {
	  
	  }
	  
	  //window is opened
	  public void windowOpened( WindowEvent e )
	  {
	  
	  }
   }
   
   //when field is the one focused on by keyboard (all key pressed are directed 
   //there)
   private class Focus implements FocusListener
   {
      String plea; //message
	  
	  //constructor initializes message
	  public Focus( String plea )
	  {
	     this.plea = plea;
	  }
      
	  //source gains focus 
	  public void focusGained( FocusEvent e )
	  {
	     //if not button
	     if( e.getSource() != button1 )
	        text1.setText( "YAYYYYYYY!!!\n");
	  }
	  
	  //source loses focus
	  public void focusLost( FocusEvent e )
	  {
	     //sets text to plea
		 if( e.getSource() instanceof JButton )
		 {
	        JButton b = (JButton)e.getSource();
			b.setText( plea );
		 }
	     else 
		 {
		    JTextField t = (JTextField)e.getSource();
			t.setText( plea );
		 }
	  }
   }
   
   //for viewers 18 and above only
   private String[] moaning = new String[]{ "Click Me, Bitch!", 
                                            "Oh yeah, click me more", 
											"Yes! Yes! Click me harder!!!", 
											" Click me, fuck!", 
											"OH! FUCK! CLICK ME!!!!",
											"YES! RIGHT THERE! CLICK ME TWICE" +
											"FUCK! FUCK!!",
											"YOU SEXY FUCKING BEAST WITH YOUR" +
											" FUCKING CLICKING, OH YEAH!",
											"I WANT YOUR MOUSE INSIDE ME!"};
}