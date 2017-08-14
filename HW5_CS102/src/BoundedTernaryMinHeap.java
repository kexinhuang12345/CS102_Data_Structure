import java.util.Stack;
/*
 * @author: Kexin Huang
 * 
 */

public class BoundedTernaryMinHeap {
	final int MAX_SIZE=1000;
	private int[] minHeap;
	
	public BoundedTernaryMinHeap(int[] x){
		minHeap=x;
	}
	
	public boolean isEmpty(){
		
		return minHeap.length==0;
	}
	
	//heapify the array MinHeap
	public void createMinHeap(){
		if(minHeap.length>MAX_SIZE){
			throw new IllegalArgumentException("Size larger than 1000");
		}else{
			
			minHeap=createArray(minHeap);
			
		}
	
	}
	/*@return an array which is heapified
	*@param a raw array
	*private helper method to return a heapify array 
	*/
	private int[] createArray(int[] array){
		for(int i=array.length-1;i>=0;i--){
			int min=array[0];
			int minIndex=0;
			for(int j=1;j<i+1;j++){
				if(array[j]<min){
					min=array[j];
					minIndex=j;
				}	
			}
		int temp=array[i];
		array[i]=min;
		array[minIndex]=temp;
			
		}
		
		
		int[] reverse=new int[array.length];
		for(int i=0;i<array.length;i++){
			reverse[i]=array[array.length-1-i];
		}
		
		array=reverse;
		return array;
		
	}
	
	
	public void addElement(int i){
		
		int[] newArray=new int[minHeap.length+1];
		for(int j=0;j<minHeap.length;j++){
			newArray[j]=minHeap[j];
		}
		newArray[minHeap.length]=i;
		minHeap=newArray;
		//copy the array into new size
		siftUp(minHeap.length-1);
		
	}
	/*
	 * @return the minimum
	 */
	public int getMin(){
		
		return minHeap[0];
		//the first element is the minimum 
		
	}
	 
	public void removeMin(){
		swap(0,minHeap.length-1);
		int[] newArray=new int[minHeap.length-1];
		for(int i=0;i<minHeap.length-1;i++){
			newArray[i]=minHeap[i];
		}
		minHeap=newArray;
		siftDown(0);
		
	}
	
	
	
	public int[] getSmallerThanK(int k){
		int index=0;
		int top=0;
		int count=0;
		Stack<Integer> st1=new Stack<Integer>();
		Stack<Integer> st2=new Stack<Integer>();
		//stack 1 to trace the movement of index of array and stack 2 to store the variable smaller than k
		st1.push(index);
		while(!st1.isEmpty()){
			top=st1.pop();
			if(minHeap[top]<k){
				st2.push(minHeap[top]);
				count++;
				if(3*top+3<minHeap.length){
					st1.push(3*top+3);
				}
				if(3*top+2<minHeap.length){
					st1.push(3*top+2);
				}
				
				if(3*top+1<minHeap.length){
					st1.push(3*top+1);
				}
			}
			if(minHeap[top]>=k){
				
				
			}
			
		}
		//output the stack2 into an array
		int[] array=new int[count];
		for(int i=count-1;i>-1;i--){
			array[i]=st2.pop();
			
		}
		//to heapify the array
		array=createArray(array);
		return array;
	}
	
	
	//private helper method
	private void siftDown(int i){
		int index=3*i+1;
		int temp=0;
		while(index<minHeap.length){
			if(minHeap[i]>minHeap[3*i+1]){
				swap(i,3*i+1);
				temp=3*i+1;
				i=temp;
			}else if(minHeap[i]>minHeap[3*i+2]){
				swap(i,3*i+2);
				temp=3*i+2;
				i=temp;
			}else if(minHeap[i]>minHeap[3*i+3]){
				swap(i,3*i+3);
				temp=3*i+3;
				i=temp;
			}else{
				temp=minHeap.length;
				//to stop the while loop
				
			}
			index=3*temp+1;
			
			
		}
		
	}
	
	private void siftUp(int i){
		
		int remain=i%3;
		int index=(i-remain)/3;
		while(index>=0){
			if(minHeap[i]<minHeap[index]){
				swap(i,index);
				i=index;
				remain=index%3;
				index=(index-remain)/3;
			}else{
				index=-1;
				//to stop the while loop
				
			}
			
		
		}
		
		
	}
	
	private void swap(int a, int b){
		int temp;
		temp=minHeap[a];
		minHeap[a]=minHeap[b];
		minHeap[b]=temp;
		
	}

	public int[] getMinHeap() {
		return minHeap;
	}

	public void setMinHeap(int[] minHeap) {
		this.minHeap = minHeap;
	}
	
	
}
