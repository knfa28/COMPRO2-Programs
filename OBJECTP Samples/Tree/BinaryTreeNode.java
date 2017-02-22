public class BinaryTreeNode extends TreeNode
{
   public BinaryTreeNode( int val )
   {
      super( val, 2 );
   }
   
   public BinaryTreeNode getLeft()
   {
      return (BinaryTreeNode)getChild(0);
   }
   
   public BinaryTreeNode getRight()
   {
      return (BinaryTreeNode)getChild(1);
   }
   
   public void setLeft( BinaryTreeNode left )
   {
      setChild( 0, left );
   }
   
   public void setRight( BinaryTreeNode right )
   {
      setChild( 1, right );
   }
}