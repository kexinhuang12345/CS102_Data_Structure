package printPermutation;

public class print {
	public static int[] nextPermutation(int[] a){
		
		int lastInc=0;
		
		for(int i=a.length-1; i>0;i--){
		if(a[i]>a[i-1]){
		
			lastInc=i-1;
			break;
			
		}
		
		
		}
		
		int n[]= new int[a.length];
		for(int i=0;i<lastInc;i++){
			
			n[i]=a[i];
			
		}
		
		n[lastInc]=//of the values in a bigger than a[lastInc] and appear after lastInc, the smallest one
		n[lastInc+1--->end]= // be everything else, but in sorted order
	}
	
	public static void printPermutation1(int n){
		
		int a[] = new int[n];
		
		int L = fac(n);
		
		for(int i=0;i<n;i++){
			
			
			a[i]=i+1;
			
		}
		
		for(int i=0;i<L;i++){
			
			
			print(a);
			a=nextPermutation(a);
			
		}
		
	}
	
	
}
