
public class FibonacciIterator implements IntegerIterator{

	private int index=0;
	
	
	public boolean hasNext(){
		
		return true;
		
	}
	
	public int getNext(){
		
		double x = (Math.pow(((1+Math.sqrt(5))/2),(index+1))-Math.pow(((1-Math.sqrt(5))/2),(index+1)))/Math.sqrt(5);
		//fibonnaci formula to run O(1)
		index++;
		return (int)x;
	
	}
	
	public void reset(){
		
		index=0;
		//sets to the beginning
		
	}
	
	
	
	
}
