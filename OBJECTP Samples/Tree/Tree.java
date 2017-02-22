public abstract class Tree
{
   private TreeNode head;
   private int k;
   
   public Tree( int k )
   {
      this.k = k;
   }
   
   public TreeNode getHead()
   {
      return head;
   }
   
   public void setHead( int x )
   {
      head = new TreeNode( x, k );
   }
   
   public int getK()
   {
      return k;
   }
   
   public abstract void addNode( int x, int sequence[] ) throws 
                                                    SequenceOverLengthException;
   
   public abstract void deleteNode( int sequence[] ) throws 
                                                    SequenceOverLengthException;
}