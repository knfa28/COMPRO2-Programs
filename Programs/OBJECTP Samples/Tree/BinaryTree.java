public class BinaryTree extends Tree
{
   private BinaryTreeNode head;
   
   public BinaryTree()
   {
      super( 2 );
   }
   
   public BinaryTreeNode getHead()
   {
      return head;
   }
   
   public void addNode( int x, int sequence[] ) throws 
                                                     SequenceOverLengthException
   {
      if( head == null )
	     head = new BinaryTreeNode( x );
	  else
	  {
	     BinaryTreeNode temp = head;
		 int i;
	     for( i = 0; temp != null && i < sequence.length - 1; i++ )
		    if( sequence[i] == 0 )
			   temp = temp.getLeft();
			else temp = temp.getRight();
		 
		 if( temp == null )
		    throw new SequenceOverLengthException();
		 else if( sequence[i] == 0 )
		    temp.setLeft( new BinaryTreeNode( x ) );
		 else temp.setRight( new BinaryTreeNode( x ) );
	  }
   }
   
   public void deleteNode( int sequence[] ) throws SequenceOverLengthException
   {
      if( head == null )
         throw new SequenceOverLengthException();
	  else
	  {
	     BinaryTreeNode temp = head;
		 int i;
	     for( i = 0; temp != null && i < sequence.length - 1; i++ )
		    if( sequence[i] == 0 )
			   temp = temp.getLeft();
			else temp = temp.getRight();
		 
		 if( temp == null )
		    throw new SequenceOverLengthException();
		 else if( sequence[i] == 0 )
		    temp.setLeft( null );
		 else temp.setRight( null );
	  }
   }
   
}