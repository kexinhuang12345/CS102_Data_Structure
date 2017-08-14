
public class QIterator implements IntegerIterator{

	private int[] array;
	private int index=0;
	private int count=0;
	
	// get the length of the sequence from constructor
	public QIterator(int n){
		
		count = n;
		array = new int[count];
		//this is the Q sequence
		//Q(0)=0
		array[0]=0;
		
		//in O(n)
		for(int i=1;i<count;i++){
		
			array[i]=i-array[array[i-1]];
		
		}
		
	}

	public boolean hasNext(){
		
		return true;
		
	}
	
	public int getNext(){
		
		index++;
		return array[index-1];
	}
	
	
	public void reset(){
		index=0;// sets to the beginning 
		
	}
	
	
}
	
