import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileIterator implements IntegerIterator {
	
	private int[] array;
	private int index;
	private int count;//number of how many numbers a file has
	
	public FileIterator(File file, int n) throws FileNotFoundException{

		Scanner input= new Scanner(file);
		count = n;
		array = new int[count];
		
		for(int i=0;i<count;i++){
			if(input.hasNext()){
				array[i]=input.nextInt();
				
			}else{
				break;
			}
		}
		
		index=0;
		
		input.close();
	}
	
	
	public boolean hasNext(){
		if(index<count){
			
			return true;
			
		}else{
			
			return false;
		}
		
		
	}
	
	public int getNext(){
		index++;//to get the next int
		return array[index-1];
		
	
	}
	
	public void reset(){
		index=0;
		// this set the beginning of the sequence
		
	}
	
	
}
