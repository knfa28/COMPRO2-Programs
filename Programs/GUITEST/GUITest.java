import java.awt.*; //for Toolkit and Dimension
import javax.swing.*; //for Swing components

public class GUITest extends JFrame
{
   public static void main( String[] args )
   {
      new GUITest(); //instantiates this frame
   }
   
   public GUITest()
   {
      setDefaultCloseOperation( EXIT_ON_CLOSE ); //allows closing via clicking 
	                                             //the close button
	  setTitle( "GUI Test, Bitch!"); //setting title
	  
	  setSize( 500, 275 ); //500 units wide, 250 units tall
	  
	  //gets a toolkit
	  Toolkit t = Toolkit.getDefaultToolkit();
	  Dimension d = t.getScreenSize(); //uses toolkit to store screen size
	  
	  //places frame in the middle of the screen
	  setLocation( ( d.width - getWidth() ) / 2, 
	               ( d.height - getHeight() ) / 2 );

      //forbids user from resizing screen
      setResizable( false );				   
		
	  //new panel for storing components (Frames are only "windows")
	  JPanel panel1 = new JPanel();
	  
	  //adds panel to frame
	  add( panel1 );
	  
	  //new label
	  JLabel label1 = new JLabel( "Testing GUI " );
	  
	  //new text to display while hovering over label
	  label1.setToolTipText( "Testing Tool Tip Text" );
	  
	  //adds label to panel
	  panel1.add( label1 );
	  
	  //new button
	  JButton button1 = new JButton( "Click me, bitch!" );
	  
	  //this would remove button's border
	  //button1.setBorderPainted( false );
	  
	  //this would remove button's unique color
	  //button1.setContentAreaFilled( false );
	  
	  //buttons can also have tips when hovering over them
	  button1.setToolTipText( "Testing button's tip" );
	  
	  //adds button to panel
	  panel1.add( button1 );
	   
	  //new text field, 30 units wide
	  JTextField text1 = new JTextField( "Type on me, bitch!", 30 );
	  
	  //adds textfield to panel
	  panel1.add( text1 );
	  
	  //this would resize the text field
	  //text1.setColumns( 20 );
	  
	  //textfields can also have tips while hovering
	  text1.setToolTipText( "Testing text field's tips" );
	  
	  //new text area, which is a larger text fields, 10x20 units
	  JTextArea area1 = new JTextArea( 10, 20 );
	   
	  //set default text
	  area1.setText( "Type more crap here!!!\nP.S. Adding \", bitch!\" to eve" +
	                 "rything is \ncompletely natural and appropriate,\nespec" +
					 "ially since Jesse from \"Breaking\nBad\" is awesome." +
					 "\n\n");
	  
	  //allows line wrap
	  area1.setLineWrap( true );
	  
	  //only wraps before/after whole words
	  area1.setWrapStyleWord( true );
	  
	  //adds at the end, the line count (which only counts \n characters)
	  area1.append( "Line Count: " + area1.getLineCount() );
	  
	  //scroll bar for the text area
	  JScrollPane scroll1 = new JScrollPane( area1, 
	                                         JScrollPane.
											 VERTICAL_SCROLLBAR_AS_NEEDED, 
											 JScrollPane.
											 HORIZONTAL_SCROLLBAR_AS_NEEDED );
	  
	  //adding the scrollbar will also add the text area
	  panel1.add( scroll1 );
	  
	  //lets the user see the frame
	  setVisible( true );
	  
	  //highlights the text area when frame opens (you cna do this with other 
	  //components)
	  area1.requestFocus();
   }
}