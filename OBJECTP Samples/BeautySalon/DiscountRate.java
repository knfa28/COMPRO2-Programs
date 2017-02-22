public class DiscountRate
{
   private static double serviceDiscountPremium = 0.2;
   private static double serviceDiscountGold = 0.15;
   private static double serviceDiscountSilver = 0.1;
   private static double productDiscountPremium = 0.1;
   private static double productDiscountSilver = 0.1;
   private static double productDiscountGold = 0.1;
   
   public static double getServiceDiscountRate( String type )
   {
      if( type.toLowerCase().equals( "premium" ) )
	     return serviceDiscountPremium;
	  else if( type.toLowerCase().equals( "gold" ) )
	     return serviceDiscountGold;
	  else return serviceDiscountSilver;
   }
   
   public static double getProductDiscountRate( String type )
   {
      if( type.toLowerCase().equals( "premium" ) )
	     return productDiscountPremium;
	  else if( type.toLowerCase().equals( "gold" ) )
	     return productDiscountGold;
	  else return productDiscountSilver;
   }
}