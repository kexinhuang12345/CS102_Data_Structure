
public class MainAssignment5 {
	
	
	public static int[] createArray(){
		
		int[] array=new int[100];
	
		for(int i=0;i<100;i++){
		
			array[i]=(int) (1+Math.random()*100);
			
		}

		return array;

	}
	
	
	public static void printTheHeap(int[] array){
		
		int index=0;
		int n=1;
		int num1=0;
		while(index<array.length){
			System.out.print(array[index]+" ");
			int num=index/3;
			int remainder=index-num*3;
			if(index==0){
				System.out.println(" ");
			}
			if(remainder==0&&index-num1==Math.pow(3, n)){
				num1+=Math.pow(3, n);
				n++;
				System.out.println(" ");
			}
			index++;
		}
	}
	
	
	public static void testAddElement(int x){
		int[] array;
		array=createArray();
		BoundedTernaryMinHeap TernaryMinHeap=new BoundedTernaryMinHeap(array);
		TernaryMinHeap.createMinHeap();
		System.out.println("____________The original heap_______________");
		printTheHeap(TernaryMinHeap.getMinHeap());
		System.out.println(" ");
		System.out.println("____________After Adding_______________");
		TernaryMinHeap.addElement(x);
		printTheHeap(TernaryMinHeap.getMinHeap());
		
	}
	
	public static void testGetMin(){
		int[] array;
		array=createArray();
		BoundedTernaryMinHeap TernaryMinHeap=new BoundedTernaryMinHeap(array);
		TernaryMinHeap.createMinHeap();
		System.out.println("____________The original heap_______________");
		printTheHeap(TernaryMinHeap.getMinHeap());
		System.out.println(" ");
		System.out.println("The min value is "+TernaryMinHeap.getMin());
	
	}
	
	public static void testRemoveMin(){
		int[] array;
		array=createArray();
		BoundedTernaryMinHeap TernaryMinHeap=new BoundedTernaryMinHeap(array);
		TernaryMinHeap.createMinHeap();
		System.out.println("____________The original heap_______________");
		printTheHeap(TernaryMinHeap.getMinHeap());
		System.out.println(" ");
		System.out.println("____________After Removing_______________");
		TernaryMinHeap.removeMin();
		printTheHeap(TernaryMinHeap.getMinHeap());
	}
	
	public static void testGetSmallerThanK(int k){
		int[] array;
		array=createArray();
		BoundedTernaryMinHeap TernaryMinHeap=new BoundedTernaryMinHeap(array);
		TernaryMinHeap.createMinHeap();
		System.out.println("____________The original heap_______________");
		printTheHeap(TernaryMinHeap.getMinHeap());
		System.out.println(" ");
		System.out.println("____________The smaller than "+k +" array_______________");
		int[] newArray=TernaryMinHeap.getSmallerThanK(k);
		printTheHeap(newArray);
	}
	
	public static void main(String[] args){
		
		System.out.println("____________Test Add Element_______________");
		testAddElement(5);
		System.out.println(" ");
		System.out.println("____________Test Get Min_______________");
		testGetMin();
		System.out.println("____________Test Remove Min_______________");
		testRemoveMin();
		System.out.println(" ");
		System.out.println("____________Test Get smaller Than K _______________");
		testGetSmallerThanK(30);
		
	}
	
}
