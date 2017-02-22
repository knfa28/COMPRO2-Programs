import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.tree.*;
import java.util.*;

public class GUITest8 extends JFrame
{
   private JPanel panel;
   private JButton check;
   private JTree myTree; //tree
   private JScrollPane scroll; //scrollbar for tree
   
   public static void main( String[] args )
   {
      new GUITest8();
   }
   
   public GUITest8()
   {
      setTitle( "Westeros" );
      setDefaultCloseOperation( EXIT_ON_CLOSE );
	  setResizable( false );
	  setLocationRelativeTo( null );
	  
	  panel = new JPanel();
	  add( panel );
	  
	  check = new JButton( "Check" );
	  L4P push = new L4P();
	  check.addActionListener( push );
	  panel.add( check );
	  
	  //declare node references
	  DefaultMutableTreeNode westeros, lannisters, stark, targaryen, bitches;
	  
	  //create instance of tree node
	  westeros = new DefaultMutableTreeNode( "Westeros" );
	  
	  //set westeros as root node of myTree
	  myTree = new JTree( westeros );
	  
	  //allow user to choose any number of nodes
	  //SINGLE_TREE_SELECTION only allows one node to be selected
	  //CONTIGUOUG_TREE_SELECTION allows multiple selecion iff the elements 
	  //are adjacent
	  myTree.getSelectionModel().setSelectionMode( TreeSelectionModel.
	                                             DISCONTIGUOUS_TREE_SELECTION );
												 
	  //only seven nodes visible in window
	  myTree.setVisibleRowCount( 7 );
	  
	  //addNode is defines below main code
	  
	  //adds children of westeros
	  lannisters = addNode( "Lannisters", westeros );
	  stark = addNode( "Starks", westeros );
	  targaryen = addNode( "Targaryens", westeros );
	  bitches = addNode( "Bitches", westeros );
	  
	  //adds children of lannisters
	  addNode( "Tyrion", lannisters );
	  addNode( "Tywin", lannisters );
	  addNode( "Lancel", lannisters );
	  addNode( "Kevan", lannisters );
	  
	  //create subtree in lannisters folder
	  DefaultMutableTreeNode incest = addNode( "Incest",  lannisters );
	  
	  //add nodes to subtree
	  addNode( "Cersei", incest );
	  addNode( "Jaime", incest );
	  
	  //adding children of stark node
	  addNode( "Eddard", stark );
	  addNode( "Catelyn", stark );
	  addNode( "Arya", stark );
	  addNode( "Sansa", stark );
	  addNode( "Robb", stark );
	  addNode( "Bran", stark );
	  
	  //creating two subtrees of stark node and adding nodes
	  DefaultMutableTreeNode boring = addNode( "Boring...", stark );
	  addNode( "Rickon", boring );
	  DefaultMutableTreeNode missing = addNode( "Missing =(", stark );
	  addNode( "Benjen", missing );
	  
	  //adding children of targaryen node
	  addNode( "Aerys", targaryen );
	  addNode( "Daenerys", targaryen );
	  addNode( "Jaeherys", targaryen );
	  addNode( "Rhaegar", targaryen );
	  
	  //adding subtrees to targaryen node
	  DefaultMutableTreeNode dragons = addNode( "Dragons", targaryen );
	  addNode( "Balerion", dragons );
	  addNode( "Rhaegal", dragons );
	  addNode( "Viserion", dragons );
	  addNode( "Drogon", dragons );
	  DefaultMutableTreeNode bitch = addNode( "Bitch", targaryen );
	  addNode( "Viserys", bitch );
	  
	  //adding children of bitches node
	  addNode( "Joffrey", bitches );
	  addNode( "Alliser", bitches );
	  addNode( "Janos Slynt", bitches );
	  addNode( "Walder Frey", bitches );
	  addNode( "Ramsay Snow", bitches );
	  addNode( "Roose Bolton", bitches );
	  
	  //create scrollpane for tree
	  scroll = new JScrollPane( myTree, JScrollPane.
	                            VERTICAL_SCROLLBAR_AS_NEEDED, 
								JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
	  
	  //adjust dimensions
	  Dimension d = scroll.getPreferredSize();
	  d.width = 250;
	  scroll.setPreferredSize( d );
	  
	  //remember to add the scrollpane, NOT the tree
	  panel.add( scroll );
	  
      setSize( 375, 275 );  
      setVisible( true );
   }
   
   private class L4P implements ActionListener
   {
      public void actionPerformed( ActionEvent e )
	  {
	     if( e.getSource() == check )
		 {
		    String s = "";
			//get the selected node and cast as Tree Node
			DefaultMutableTreeNode d = (DefaultMutableTreeNode)myTree.
			                                     getLastSelectedPathComponent();
			
			//just in case d is null
			try
			{
			   //cast node as string
			   s =  "You selected " + (String)d.getUserObject();
			   
			        //gets number of children
			   s += " which has " + d.getChildCount() + 
			
			     //gets number of siblings (including self so deduct 1)
			     " child(ren) and " + ( d.getSiblingCount() - 1 ) + " sibling" +
				 
				 //                       gets parent node
				 "(s).\nIts parent is " + d.getParent() + "\nNext Node: " + 
				 
				 //gets adjacent nodes
				 d.getNextNode() + "\nPrevious Node: " + d.getPreviousNode() + 
				 "\n\nChild(ren): \n";
				 
		       //gets children (import java.util.Enumeration;)
			   for( Enumeration en = d.children(); en.hasMoreElements(); )
			      s += en.nextElement() + "\n";
			   
			    s += "\nPath from root: \n";
			 
			    //gets the path from root
			    TreeNode[] path = d.getPath();
			 
			    //print each
			    for( TreeNode t: path )
			       s += t + "\n";
			
			   //display results
		       JOptionPane.showMessageDialog( GUITest8.this, s, "Checking", 
			                                  JOptionPane.INFORMATION_MESSAGE );
			}
			
			//it's better to use an if statement here, but I just wanted to 
			//play with exception handling =)
			catch( NullPointerException n )
			{
			   JOptionPane.showMessageDialog( GUITest8.this, "Nothing Selected",
			                                  "Error", JOptionPane.
											  ERROR_MESSAGE );
			}
		 }
	  }
   }
   
   /**
   * adds a node as another node's child
   * @param s name of node
   * @param p parent node
   * @return new node
   */
   private DefaultMutableTreeNode addNode( String s, DefaultMutableTreeNode p )
   {
      //instantiate new node with given name
      DefaultMutableTreeNode d = new DefaultMutableTreeNode( s );
	  
	  //add to parent node
	  p.add( d );
	  
	  //return node
	  return d;
   }
}