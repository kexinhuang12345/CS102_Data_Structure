import java.util.ArrayList;
import java.util.Random;

public class Assignment2 {
	
	public static <E extends Comparable<E>> void quickSort(ArrayList<E> array){
		
		quickSort(array,0,array.size()-1);
		
	}

	
	//private helper method
	private static <E extends Comparable<E>> void quickSort(ArrayList<E> array, int low,int high){

		int leftPointer = low;
		int rightPointer = high;

		Random rand = new Random();
		
		int pivotIndex=rand.nextInt(high-low)+low;
		//to get the length 
		
		E pivot = array.get(pivotIndex);
		//easier to compare later
		E temp = array.get(0);
		array.set(0, array.get(pivotIndex));
		array.set(pivotIndex,temp);
		//swap pivot with 0 position number 
		
		while(rightPointer>=leftPointer){
			
			
			while(array.get(leftPointer).compareTo(pivot)<0){
				if(leftPointer!=array.size()-1)
					leftPointer++;
			}
			//only when left pointer number <pivot then it is the number I need to swap
			while( array.get(rightPointer).compareTo(pivot)>0 ){
				if(rightPointer!=0)
					rightPointer--;
			}
			//only when right pointer number >pivot then it is the number I need to swap

			if(leftPointer<=rightPointer){
				E temp1 = array.get(rightPointer);
				array.set(rightPointer, array.get(leftPointer));
				array.set(leftPointer,temp1);
				if(rightPointer!=0)
					rightPointer--;
				//there is a chance rightPointer can be -1 which would cause error
				if(leftPointer!=array.size()-1)
				leftPointer++;
			}
			//swap these two numbers
		}
		
		E temp2 = array.get(0);
		array.set(0, array.get(rightPointer));
		array.set(rightPointer,temp2);
		//swap the pivot back
		
		//if low> right pointer, then there is no element left in this array
		if(low<rightPointer)
			quickSort(array,low,rightPointer);
		if(high>leftPointer)
			quickSort(array,leftPointer,high);
		
			
	}
	
	
	
	public static <E>ArrayList<E> removeRepetitions(ArrayList<E> array){
		
		for(int i=0;i<array.size();i++){
			
			for(int j=i+1; j<array.size();j++){
				//compare each element and if it is the same, remove it 
				if(array.get(i).equals(array.get(j))){
					
					array.remove(j);
					j--;
					//the remove method change the size and the index
				}
				
			}
		}
		
		return array;
		
	}
	
	public static int printIncreasingSequences(int n, int k)throws IllegalArgumentException{
		if(n<k){
			System.out.println("n<k");
			throw new IllegalArgumentException();
		}
		
		int[] array = new int[k];
		int count=0;//count the number
		
		for(int i=0;i<k;i++){
			array[i]=1;
		}
		
		while(true){
			boolean judge=true;
			for(int i=1;i<k;i++){
				if(array[i-1]>=array[i])
					judge=false;
			}
			//to filter elements that does not increase in order
			if(judge==true){
				for(int i=0;i<k;i++){
					System.out.print(array[i]);	
					System.out.print(" ");
					if(i==k-1){
						System.out.println("");
						count++;
					}
				}
			}
			//if there is no next array which means n,n,n,n,n...n then, it ends
			//if there is, continue printing
			if(getNext(array,n,k)==false){
				break;
			}
			
		} 
		return count;
	}
	//to decide if there is a next array
	public static Boolean getNext(int[] array, int n,int k){
		int trace=k-1;
		
		while(array[trace]==n){
			trace--;// to see the next rightest element 
			if(trace<0){
				return false;
			}
		}
		//
		array[trace]=array[trace]+1;
		//make 1,1,1,1,2,n,n,n..
		for(int i=trace+1;i<k;i++){
			array[i]=1;
			// make 1,1,1,1,2,1,1,1..
		}
		return true;
	}
}
