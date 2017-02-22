public class TestMyPoint
{
   public static void main( String[] args )
   {
      MyPoint p1 = new MyPoint();
	  MyPoint p2 = new MyPoint( 3, 4 );
	  
	  System.out.println( "Point 1: (" + p1.getX() + "," + p1.getY() + ")" );
	  
	  p1.setX( 5 );
	  p1.setY( 5 );
	  System.out.println( "Point 1: (" + p1.getX() + "," + p1.getY() + ")" );
	  System.out.println( "Point 2: (" + p2.getX() + "," + p2.getY() + ")" );
	  
	  p2.setXY( 8, 9 );
	  
	  System.out.println( "Point 1: " + p1.toString() + "\nPoint 2: " + 
	                      p2.toString() );
	  
	  System.out.println( "Point 1's distance from origin: " + 
	                      p1.distance( 0, 0 ) + "\nPoint 1's distance from Po" +
						  "int 2: " + p1.distance( p2 ) );
	  
	  MyPoint[] points = new MyPoint[10];
	  
	  for( int i = 0; i < 10; i++ )
	     points[i] = new MyPoint( i + 1, i + 1 );
		 
	  for( int i = 0; i < 10; i++ )
	     System.out.println( points[i].toString() );
	  
	  
   }
}