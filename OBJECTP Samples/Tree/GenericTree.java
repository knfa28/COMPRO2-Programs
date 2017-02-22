public class GenericTree extends Tree
{  
   public GenericTree( int k )
   {
      super( k );
   }
   
   public void addNode( int x, int sequence[] ) throws 
                                                     SequenceOverLengthException
   {  
	  if( getHead() == null )
	     setHead( new TreeNode( x, getK() ) );
	  else
	  {
	     TreeNode temp = getHead();
	     int i;
         for( i = 0; temp != null && i < sequence.length - 1; i++ )
		    temp = temp.getChild( sequence[i] );
	     
		 if( temp == null )
		    throw new SequenceOverLengthException();
		 else temp.setChild( sequence[i], new TreeNode( x, getK() ) );
	  }
   }
   
   public void deleteNode( int sequence[] ) throws SequenceOverLengthException
   {
       if( getHead() != null )
	   {
	     int i;
		 TreeNode temp = getHead();
		 
         for( i = 0; temp != null && i < sequence.length - 1; i++ )
		    temp = temp.getChild( sequence[i] );
		 
		 if( temp == null )
		    throw new SequenceOverLengthException();
		 else temp.setChild( sequence[i], null );
	   }
   }
}