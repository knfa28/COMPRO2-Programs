import java.util.*;

public class Complex
{
   private double real;
   private double imaginary;
   
   public Complex( double real, double imaginary )
   {
      this.real = real;
	  this.imaginary = imaginary;
   }
   
   public double getReal()
   {
      return real;
   }
   
   public double getImaginary()
   {
      return imaginary;
   }
   
   public void setReal( double real )
   {
      this.real = real;
   }
   
   public void setImaginary( double imaginary )
   {
      this.imaginary = imaginary;
   }
   
   public Complex add( Complex complex )
   {
      return ( new Complex( real + complex.getReal(), imaginary + 
	                        complex.getImaginary() ) );
   }
   
   public Complex subtract( Complex complex )
   {
      return add( complex.multiply( new Complex( -1, 0 ) ) );
   }
   
   public Complex multiply( Complex complex )
   {
      return ( new Complex( real * complex.getReal() - imaginary * 
	                        complex.getImaginary(), imaginary * complex.
							getReal() + real * complex.getImaginary() ) );
   }
   
   public Complex divide( Complex complex )
   {
      double d = Math.pow( complex.getReal(), 2 ) + Math.pow( complex.
	             getImaginary(), 2 );
	  
	  Complex temp = multiply( new Complex( complex.getReal(), -complex.
	                getImaginary() ) );
	  
	  temp.setReal( temp.getReal() / d );
	  temp.setImaginary( temp.getImaginary() / d );
	  
	  return temp;
   }
   
   public String toString()
   {
      String temp = "";
	  
	  if( real != 0 )
	     temp = real + " ";
	  
	  if( imaginary < 0 )
	     temp += "- ";
	  else if( imaginary > 0 )
	     temp += "+ ";
	  
	  if( imaginary == 1 || imaginary == -1 )
	     temp += "i";
	  else if( imaginary < 0 )
	     temp += -imaginary + "i";
	  else if( imaginary > 0 )
	     temp += imaginary + "i";
		 
	  return temp;
   }
}