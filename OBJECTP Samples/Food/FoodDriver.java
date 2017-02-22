public class FoodDriver
{
   public static void main( String[] args )
   {
      Food chicken = new Food( "Chicken", "Yummy", 250, 30 );
	  
	  chicken.display();
	  chicken.addSalt();
	  chicken.cook();
	  chicken.addJalapeno();
	  chicken.setName( "Fried Salty and Spicy Chicken");
	  
	  System.out.println( "\nAfter adding salt, cooking, and adding jalapeno: " +
	                      "\n" + chicken.toString() );
						  
	  System.out.println( "1 kg of chicken is " + 
	                      (float)chicken.getServings( 1000 ) + " servings" );
   }
}