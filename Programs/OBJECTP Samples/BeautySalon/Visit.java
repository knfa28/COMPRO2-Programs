import java.util.*;

public class Visit
{
   private Customer customer;
   private Date date;
   private double serviceExpense;
   private double productExpense;
   
   public Visit( Customer customer, Date date )
   {
      this.customer = customer;
	  this.date = date;
   }
   
   public String getName()
   {
      return customer.getName();
   }
   
   public double getServiceExpense()
   {
      return serviceExpense;
   }
   
   public void setServiceExpense( double ex )
   {
      serviceExpense = ex;
   }
   
   public double getProductExpense()
   {
      return productExpense;
   }
   
   public void setProductExpense( double ex)
   {
      productExpense = ex;
   }
   
   public double getTotalExpense()
   {
      double ex =  productExpense + serviceExpense;
      if( customer.isMember() )
         ex -= serviceExpense * DiscountRate.getServiceDiscountRate( 
		       customer.getMemberType() ) + productExpense * DiscountRate.
			   getProductDiscountRate( customer.getMemberType() );
	
	   return ex;
   }
   
   public String toString()
   {
      return ( "Name: " + getName() + "\nService Expense: " + serviceExpense + 
	           "\nProduct Expense: " + productExpense + "\nTotal Expense: " + 
			   getTotalExpense() );
   }
}