
public class SquaresIterator implements IntegerIterator {
	private int index=0;
	
	
	public boolean hasNext(){
		
		return true;
		
	}
	
	
	public int getNext(){
		index++;//in order to get next one getNext() is called
		return (int) Math.pow(index,2);
		
	}
	
	public void reset(){
		
		index=0; 
		//sets to the beginning 
		
	}


	
}
