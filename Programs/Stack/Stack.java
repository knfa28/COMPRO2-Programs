public class Stack{

	private final int MAX_SIZE;
	private int[] arr;
	private int nElem =  0;
	
	public Stack(int maxSize){
		MAX_SIZE = maxSize;
		arr = new int[maxSize];
	}
	
	public int getStackSize(){
		return arr.length;
	}
	
	public void Push(int Num){
		if(nElem < MAX_SIZE){
			arr[nElem] = Num;
			nElem++;
			System.out.println("\n" + Num + " Successfully Pushed into the Stack");
		}
		
		else System.out.println("\nSTACK FULL!");
	}
	
	public int Pop(){
		int nTemp;
		
		if(nElem == 0)
			return -999;
		
		else{
			nTemp = arr[nElem - 1];
			arr[nElem - 1] = 0;
			nElem--;
			
			return nTemp;
		}
	}
	
	public int getTop(){
		return arr[nElem - 1];
	}
	
	public void printStack(){
		int i;
		
		if(nElem == 0)
			System.out.println("\nSTACK EMPTY!");
		
		else{
			System.out.println("\nContent of Stack from Top to Bottom:");
			for(i = nElem - 1; i >= 0; i--){
				System.out.println(arr[i]);
			}
		}
	}
}