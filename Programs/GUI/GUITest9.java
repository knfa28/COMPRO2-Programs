import javax.swing.*;
import java.awt.*;

public class GUITest9 extends JFrame
{
   private JPanel panel, flow, border; //main panel and sub panels
   private Box box; //for box layout
   private JButton next1, next2, next3, north, south, east, west, center,
                   box1, box2, box3, box4;
   
   public static void main( String[] args )
   {
      new GUITest9();
   }
   
   public GUITest9()
   {
      setTitle( "Westeros" );
      setDefaultCloseOperation( EXIT_ON_CLOSE );
	  setResizable( false );
	  setLocationRelativeTo( null );
	  
	  panel = new JPanel();
	  add( panel );
	  
	  flow = new JPanel();
	  
	  //this sets the layout such that each new component is placed to the right
	  //of the last component. The constructor parameters are how to align the
	  //components( LEFT, RIGHT, or CENTER), the horizontal space, and vertical
	  //space. The last two arguments can be removed. Just so you know, this is
	  //what you've been using since the beginning so you should be a master
	  //of this already =)
	  flow.setLayout( new FlowLayout( FlowLayout.CENTER, 40, 40 ) );
	  
	  //create buttons and add to panel
	  next1 = new JButton( "First" );
	  next2 = new JButton( "Second" );
	  next3 = new JButton( "Last" );
	  flow.add( next1 );
	  flow.add( next2 );
	  flow.add( next3 );
	  
	  //create border
	  flow.setBorder( BorderFactory.createTitledBorder( "Flow Layout" ) );
	  
	  //add to main panel
	  panel.add( flow );
	  
	  //Border Layout only allows you to place components on the north, south
	  //east, west, and center of the panel.
	  border = new JPanel();
	  border.setLayout( new BorderLayout());
	  
	  //create buttons
	  north = new JButton( "N" );
	  south = new JButton( "S" );
	  east = new JButton( "E" );
	  west = new JButton( "W" );
	  center = new JButton( "X" );
	  
	  //add buttons to each direction. note that if I added another component to 
	  //an occupied direction, it would be placed on top of the old component
	  border.add( north, BorderLayout.NORTH );
	  border.add( south, BorderLayout.SOUTH );
	  border.add( east, BorderLayout.EAST );
	  border.add( west, BorderLayout.WEST );
	  border.add( center, BorderLayout.CENTER );
	  
	  border.setBorder( BorderFactory.createTitledBorder( "Border Layout" ) );
	  panel.add( border );
	  
	  //box layout lays the components out depending on the orientation. Here
	  //I made a vertical box which lays them out vertically. You can do 
	  //Box.createHorizontalBox() if you want
	  box = Box.createVerticalBox();
	  
	  //new buttons
	  box1 = new JButton( "Top" );
	  box2 = new JButton( "Middle 1" );
	  box3 = new JButton( "Middle 2" );
	  box4 = new JButton( "Bottom" );
	  
	  //add buttons
	  box.add( box1 );
	  
	  //you can add a small jump (here, 3 pixels) using this method. Also works
	  //for horizontal
	  box.add( Box.createVerticalStrut( 3 ) );
	  box.add( box2 );
	  
	  //you can also, like flow layout, create a specified area around the next 
	  //component
	  box.add( Box.createRigidArea( new Dimension( 15, 15 ) ) );
	  box.add( box3 );
	  
	  //you can also flush a component to the edge using this methos
	  box.add( Box.createVerticalGlue() );
	  box.add( box4 );
	  
	  box.setBorder( BorderFactory.createTitledBorder( "Box Layout" ) );
	  
	  panel.add( box );
	  
	  setSize( 600, 350 );
      setVisible( true );
   }
}