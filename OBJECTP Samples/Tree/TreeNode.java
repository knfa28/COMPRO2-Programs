public class TreeNode
{
   private int val;
   private TreeNode parent;
   private TreeNode[] children;
   
   public TreeNode( int val, int k )
   {
      this.val = val;
	  parent = null;
	  children = new TreeNode[k];
   }
   
   public int getVal()
   {
      return val;
   }
   
   public TreeNode getChild( int k )
   {
      return children[k];
   }
   
   public TreeNode getParent()
   {
      return parent;
   }
   
   public void setChild( int k, TreeNode t )
   {
      children[k] = t;
	  
	  if( t != null )
	     children[k].setParent(this);
   }
   
   public void setParent( TreeNode parent )
   {
      this.parent = parent;
   }
}