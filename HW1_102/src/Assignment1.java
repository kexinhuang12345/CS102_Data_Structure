import java.io.File;
import java.io.FileNotFoundException;


public class Assignment1 {

	public static void printSequence(IntegerIterator it, int n){
		
		
		for(int i=0;i<n;i++){
			if(it.hasNext()){
				System.out.println(it.getNext());
			}else{
				break;
			}

		}
		
		
	}
	
	public static int getQsequence(int n){
		
		if(n==0){
			return 0;
		}else{
			
			return n-getQsequence(getQsequence(n-1));
		
		}
	
		
	}
	
	
	public static void main (String[] args) throws FileNotFoundException{
		
		File file = new File(args[0]);
		
		SquaresIterator si = new SquaresIterator();
		FibonacciIterator fi = new FibonacciIterator();
		QIterator qi = new QIterator(10);
		FileIterator fileI = new FileIterator(file,10);
		
		System.out.println("_____________SquareIterator__________");
		printSequence(si,10);
		System.out.println("__________FibonnaciIterator__________");
		printSequence(fi,10);
		System.out.println("_________________QIterator___________");
		printSequence(qi,10);
		System.out.println("_________Qiterator Recursive_________");
		for(int i=0;i<10;i++){
			System.out.println(getQsequence(i));
		}
		System.out.println("___________FileIterator______________");
		printSequence(fileI,10);
		
		}
}
	
	
	
	


