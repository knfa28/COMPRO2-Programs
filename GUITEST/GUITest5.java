import java.awt.event.*;
import javax.swing.*;

public class GUITest5 extends JFrame
{
   JPanel panel;
   JLabel current;
   JComboBox<String> houses; //drop down list of strings<put type in brackets>
   JTextField text;
   JButton add, view, lock;
   
   public static void main( String[] args )
   {
      new GUITest5();
   }
   
   public GUITest5()
   {
      //fields for JFrame
      setTitle( "Houses" );
	  setSize( 210, 200 );
	  setLocationRelativeTo( null );
	  setResizable( false );
	  setDefaultCloseOperation( EXIT_ON_CLOSE );
	  
	  //panel
	  panel = new JPanel();
	  add( panel );
	  
	  current = new JLabel("Current Houses: ");
	  panel.add( current );
	  
	  //array of strings
	  String[] houseList = { "Lannister", "Stark", "Baratheon", 
	                                     "Targaryen", "Tyrell", "Martell", 
										 "Greyjoy" };
	  
	  //constructs new combo box of Strings 
	  //<put type of your choice in brackets>
	  houses = new JComboBox<String>( houseList );
	  
	  //combo box is editable now
	  houses.setEditable( true );
	  
	  //add combo box to panel
	  panel.add( houses );
	  
	  //button for viewing details
	  BListen bl = new BListen();
	  view = new JButton("View Details");
	  view.addActionListener( bl );
	  panel.add( view );
	  
	  
	  text = new JTextField( "New House Here", 15 );
	  panel.add( text );
	  
	  //button for adding a house to list
	  add = new JButton("Add House");
	  add.addActionListener( bl );
	  panel.add( add );
	  
	  
	  lock = new JButton( "Lock Combo Box" );
	  lock.addActionListener( bl );
	  panel.add( lock );
	  
	  setVisible( true );
   }
   
   private class BListen implements ActionListener
   {
      public void actionPerformed( ActionEvent e )
	  {
	     //if adding house
	     if( e.getSource() == add )
		 {
		    //if editable
		    if( houses.isEditable() )
			{
		       //add house in text field
		       houses.addItem( text.getText() );
			
			   //shows house added
			   JOptionPane.showMessageDialog( GUITest5.this, "House " + 
			                                  text.getText() + " added", 
					   					      "Successfully Added!", 
										      JOptionPane.INFORMATION_MESSAGE );
			
			   //resets default text of text field
			   text.setText( "New House Here" );
			}
			
			//shows error
			else JOptionPane.showMessageDialog( GUITest5.this, "Combo Box is " +
			                                    "locked.", "LOCKED COMBO BOX",
												JOptionPane.ERROR_MESSAGE );
		 }
		 else if( e.getSource() == view )
		 {
		    //gets item at index corresponding to value of parameter
		    String temp = "Item at 0: " + houses.getItemAt( 0 ) + "\nItem Cou" +
			
			                       //gets number of items in combo box
			              "nt: " + houses.getItemCount() + "\nSelected Item: " + 
						  
						  //gets index of selected item
					      houses.getSelectedIndex() + " : " + 
						  
						  //gets selected item
						  houses.getSelectedItem() + "\nAre Editable: " + 
						  
						  //whether combo box is editable
						  houses.isEditable() + "\n";
			
			//shows details
			JOptionPane.showMessageDialog( GUITest5.this, temp, "Info", 
			                               JOptionPane.PLAIN_MESSAGE );
		 }
		 else if( e.getSource() == lock )
		 {
		    //if editable
		    if( houses.isEditable() )
			{
			   //lock editing
			   houses.setEditable( false );
			   
			   //alter button text
			   lock.setText( "Unlock Combo Box" );
			}
			else
			{
			   //enable editing
			   houses.setEditable( true );
			   
			   //alter button text
			   lock.setText( "Lock Combo Box" );
			}
		 }
	  }
   }
   
}