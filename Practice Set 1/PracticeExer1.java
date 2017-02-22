/*IMPORTS*/
import java.util.Scanner;

public class PracticeExer1 {

    public static void main(String[] args){
    	
    	Scanner sc = new Scanner(System.in);
    	
    	/*#1
    	double dGrade = 0;
    	
    	do{
    		System.out.print("Enter final grade: ");
    		dGrade = sc.nextDouble();
    		
    		if(dGrade < 0 || dGrade > 100)
    			System.out.printf("\nPlease enter a valid grade!\n");
    		
    		else{
    			if(dGrade > 94)
    				System.out.print("GPE: 4.0\n");
    			else if(dGrade > 89)
    				System.out.print("GPE: 3.5\n");
    			else if(dGrade > 83)
    				System.out.print("GPE: 3.0\n");
    			else if(dGrade > 78)
    				System.out.print("GPE: 2.5\n");
    			else if(dGrade > 72)
    				System.out.print("GPE: 2.0\n");
    			else if(dGrade > 66)
    				System.out.print("GPE: 1.5\n");
    			else if(dGrade > 60)
    				System.out.print("GPE: 1.0");
    			else
    				System.out.print("GPE: 0.0");
    		}
 	
    	}while(dGrade < 0 || dGrade > 100);
    	*/
    	
    	/*#2
    	int nInput, nTemp, i;
    	
    	do{
    		System.out.print("Please enter a number from 1-99: ");
    		nInput = sc.nextInt();
    		
    		if(nInput <= 0 || nInput > 99)
    			System.out.print("\nPlease input a valid number!\n");
    			
    		else{
    			nTemp = nInput / 10;  
    			nInput %= 10;
    			
    			if( nTemp == 9 )
      				System.out.print("XC");
    			else if( nTemp >= 5 )
    			{
    				System.out.print("L");
    				for( i = 0; i < nTemp - 5; i++)
    	   				System.out.print("X");
    			}
    			else if( nTemp == 4 )
					System.out.print("XL");
    			else
    				for( i = 0; i < nTemp; i++ )
    	   				System.out.print("X");
    	   				
    	   		if( nInput == 9 )
      				System.out.print("IX");
    			else if( nInput >= 5 )
    			{
    				System.out.print("V");
    				for( i = 0; i < nInput - 5; i++)
    	   				System.out.print("I");
    			}
    			else if( nInput == 4 )
					System.out.print("IV");
    			else
    				for( i = 0; i < nInput; i++ )
    	   				System.out.print("I");		
    		}		
    	}while(nInput <= 0 || nInput > 99);
    	*/
    	
    	//#3
    	int n1, n2, i;
    	
		System.out.print("Input n1: ");
    	n1 = sc.nextInt();
    	
    	System.out.print("Input n2: ");
    	n2 = sc.nextInt();
    	
    	System.out.println("GCD: " + findGCD(n1,n2));
    	
    	
    	/*#4
    	int nInput, nFactorial = 1, i;
    	
    	System.out.print("Find factorial for: ");
    	nInput = sc.nextInt();
    	
    	for(i = 2; i <= nInput; i++)
    		nFactorial *= i;
    		
    	System.out.print(nInput + "! = " + nFactorial);
    	*/
    	
    	/*#5
    	int nInput, nTemp, i;
    	
    	do{
    		System.out.print("Input any number: ");
    		nInput = sc.nextInt();
    		
    		if(nInput <= 0)
    			System.out.print("\nPlease input a postive integer\n");
    		
    		else{
    			nTemp = nInput;
    			
    			while(nTemp > 0){
    				for(i = 0; i < nTemp - 1; i++)
    					System.out.print(" ");
    					
    				for(i = 0; i < nInput; i++)
    					System.out.print("#");
    					
    				System.out.print("\n");
    				nTemp--;
    			}	
    		}
    	}while(nInput <= 0);
    	*/
    }
    
    private static int findGCD(int number1, int number2) {
        
        if(number2 == 0){
            return number1;
        }
        return findGCD(number2, number1%number2);
    }  
}