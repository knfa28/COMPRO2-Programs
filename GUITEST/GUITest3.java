import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*; //for change event listener
import javax.swing.border.*; //for border

public class GUITest3 extends JFrame
{
   private JPanel mainPanel;
   private JButton calc;
   private JLabel num1, num2, count;
   private JTextField input1, input2;
   private JCheckBox dollar, comma; //boxes that can be chacked or unchecked 
                                    //simultaneously
   private JRadioButton add, sub, mult, div; //buttons wherein only one can be 
                                             //checked
   private JSlider slide; //slider
   private double d1, d2, result;
   
   public static void main( String[] args )
   {
      new GUITest3();
   }
   
   public GUITest3()
   {
      //set frame attributes
      setSize( 400, 400 );
	  
	  //center
	  setLocationRelativeTo( null );
	  
	  setResizable( false );
	  
	  setTitle( "Now You're Thinking With Sliders, Checkboxes, Radio Shit 'n " +
	            "shit! =)");
	  
	  setDefaultCloseOperation( EXIT_ON_CLOSE );
	  
	  //set panel attributes
      mainPanel = new JPanel();
	  add(mainPanel);
	  
	  //create buttons and labels, you know this already
	  calc = new JButton();
	  calc.setText( "Calculate" );
	  
	  mainPanel.add( calc );
	  
	  num1 = new JLabel("Number 1 ");
	  
	  mainPanel.add( num1 );
	  
	  input1 = new JTextField( "", 5 );
	  
	  mainPanel.add( input1 );
	  
	  num2 = new JLabel("Number 2 ");
	  
	  mainPanel.add( num2 );
	  
	  input2 = new JTextField( "", 5 );
	  
	  mainPanel.add( input2 );
	  
	  //parameter for checkbox constructor is the text displayed beside it
	  dollar = new JCheckBox("Dollar Sign");
	  
	  mainPanel.add( dollar );
	  
	  comma = new JCheckBox( "Comma Separator" );
	  
	  //you can specify the initial value of a checkbox while adding
	  mainPanel.add( comma, true );
	  
	  //same constructor parameters for radio buttons
	  add = new JRadioButton( "Add" );
	  sub = new JRadioButton( "Subtract" );
	  mult = new JRadioButton( "Multiply" );
	  div = new JRadioButton( "Divide" );
	  
	  //group of radio buttons that are exclusively selectable
	  ButtonGroup bg = new ButtonGroup();
	  
	  //add buttons to group
	  bg.add( add );
	  bg.add( sub );
	  bg.add( mult );
	  bg.add( div );
	  
	  //create mini-panel
	  JPanel subPan = new JPanel();
	  
	  //create border for mini-panel
	  Border subBorder = BorderFactory.createTitledBorder( "What to do with " + 
	                                                       "numbers?");
	  
	  //add border to mini-panel
	  subPan.setBorder( subBorder );
	  
	  //add buttons to mini-panel
	  subPan.add( add );
	  subPan.add( sub );
	  subPan.add( mult );
	  subPan.add( div );
	  
	  //add mini-panel to main panel
	  mainPanel.add( subPan );
	  
	  //set add as default
	  add.setSelected( true );
	  
	  count = new JLabel( "Perform How Many Times? ");
	  
	  mainPanel.add( count );
	  
	  //new slider. 0/99 is the min/max value. 1 is the default value
	  slide = new JSlider( 0, 99, 1 );
	  
	  //tick appears every 1 unit
	  slide.setMinorTickSpacing( 1 );
	  
	  //big tick appears every 15 units
	  slide.setMajorTickSpacing( 15 );
	  
	  //show ticks
	  slide.setPaintTicks( true );
	  
	  //show numbers
	  slide.setPaintLabels( true );
	  
	  //new listener for slider
	  SlideListen sl = new SlideListen();
	  
	  //add listener to slider
	  slide.addChangeListener( sl );
	  
	  //add slider to main panel
	  mainPanel.add( slide );
	  
	  setVisible( true );
	  
	  //focus on first num
	  input1.requestFocus();
   }
   
   //code to be added
   private class SlideListen implements ChangeListener
   {
      public void stateChanged( ChangeEvent e )
	  {
	  }
   }
}