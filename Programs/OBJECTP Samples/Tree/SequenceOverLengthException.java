import java.*;

public class SequenceOverLengthException extends Exception
{
   public SequenceOverLengthException()
   {
   }
   
   public void display()
   {
      System.out.println( "Sequence is too long" );
   }
}