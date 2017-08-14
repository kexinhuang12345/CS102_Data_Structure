import java.util.ArrayList;
import java.util.Random;

public class MainAssignment2 extends Assignment2 {
	
	
	public static void testQuickSort(){
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		Random rand = new Random();
		
		for(int i=0;i<20;i++){
			
			array.add(rand.nextInt(100));
			//create a random array
			System.out.println(array.get(i));
			//print the array
		}	
			quickSort(array);
			
					
		boolean test=true;
		//return false if it 
		for(int i=0;i<19;i++){
			if(array.get(i).compareTo(array.get(i+1))>0){
				
				test=false;
				
			}
		}
			
	
		System.out.println("........Print Sorting Result.........");	

		if(test==false){
			System.out.println("Not Sorted");
		}else{	
			System.out.println("Sorted");
			for(int i=0;i<20;i++){
				System.out.println(array.get(i));
				//print the array
			}	
		}
	}
	


	public static void testRemoveRepetitions(){
		ArrayList<Integer> array = new ArrayList<Integer>();
		
		Random rand = new Random();
		
		for(int i=0;i<40;i++){
			
			array.add(rand.nextInt(10));
			//create a random array
			System.out.println(array.get(i));
			//print the array
		}					
		
		removeRepetitions(array);

		System.out.println("........Print Result.........");	

			for(int i=0;i<array.size();i++){
				System.out.println(array.get(i));
				//print the array
			}	
				
	}
	
	public static void testIncreasingSequences(){
		Random rand = new Random();
		int k = rand.nextInt(2)+2;
		int n = rand.nextInt(20);

		int total = printIncreasingSequences(n,k);
		
		int total1=1;
		
		if(k==2){
			total1=n*(n-1)/2;
		}if(k==3){
			total1=n*(n-1)*(n-2)/6;
		}if(k==4){
			total1=n*(n-1)*(n-2)*(n-3)/24;
		}
		
		
		
		System.out.println("The total number should be "+total1);
		System.out.println("The total number is "+total);
		if(total==total1){
			System.out.println("it matches");	
		}else{
			System.out.println("it doesn't match");
		}
			
	}
	

	
	public static void main(String[] args){
		System.out.println("........QuickSort.........");	

		testQuickSort();
		
		System.out.println("........Remove Repetition.........");	

		testRemoveRepetitions();
		
		System.out.println("........Print Increasing Sequences.........");	

		testIncreasingSequences();
		
		
		
	}
	
	
	
	
}

