/**
* represents a food item
*/
public class Food
{
   private String name; //name of dish
   private String flavor; //dish's flavor
   private double calories; //number of calories
   private double servSize; //serving size
   private boolean isCooked; //whether food is cooked or not
   
   /**
   * constructor for food item object
   * @param name name of dish
   * @param flavor dish's flavor
   * @param cals number of calories
   * @param servSize serving size
   */
   public Food( String name, String flavor, double cals, double servSize )
   {
      this.name = name;
	  this.flavor = flavor;
	  calories = cals;
	  this.servSize = servSize;
	  isCooked = false;
   }
   
   /**
   * returns name of dish
   * @return name of dish
   */
   public String getName()
   {
      return name;
   }
   
   /**
   * returns flavor of dish
   * @return flavor of dish
   */
   public String getFlavor()
   {
      return flavor;
   }
   
   /**
   * returns calories in dish
   * @return calories in dish
   */
   public double getCalories()
   {
      return calories;
   }
   
   /**
   * returns dish's serving size
   * @return dish's serving size
   */
   public double getServSize()
   {
      return servSize;
   }
   
   /**
   * returns whether dish is cooked or not
   * @return whether dish is cooked or not
   */
   public boolean getIsCooked()
   {
      return isCooked;
   }
   
   /**
   * allows user to change name of dish
   * @param name new name of dish
   */
   public void setName( String name )
   {
      this.name = name;
   }
   
   /**
   * allows user to change serving size of dish
   * @param newSize new serving size of dish
   */
   public void setServSize( double newSize )
   {
      servSize = newSize;
   }
   
   /**
   * adds sugar to dish
   */
   public void addSugar()
   {
      flavor += ", Sweet";
   }
   
   /**
   * adds vinegar to dish
   */
   public void addVinegar()
   {
      flavor += ", Sour";
   }
   
   /**
   * adds salt to dish
   */
   public void addSalt()
   {
      flavor += ", Salty";
   }
   
   /**
   * adds jalapenos to dish
   */
   public void addJalapeno()
   {
      flavor += ", Spicy";
   }
   
   /**
   * cooks dish if not cooked yet; decreases calories
   */
   public void cook()
   {
      if( !isCooked )
	  {
	     calories *= 0.75;
		 isCooked = true;
	  }
   }
   
   /**
   * returns number of servings of food
   * @param quantity quantity of food
   * @return number of servings of food
   */
   public double getServings( double quantity )
   {
      return ( quantity / servSize );
   }
   
   /**
   * returns string representation of food item 
   * @return string representation of food item 
   */
   public String toString()
   {
      return ( "Name: " + name + "\nFlavor: " + flavor + "\nCalories: " + 
	           calories + " cals\nServing Size: " + servSize + " g" );
   }
   
   /**
   * displays details of food item
   */
   public void display()
   {
      System.out.println( toString() );
   }
}