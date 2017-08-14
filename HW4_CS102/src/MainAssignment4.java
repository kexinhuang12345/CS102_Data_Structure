import java.util.Iterator;


public class MainAssignment4 {
	
	public static <E> BinarySearchTree createRandomBSTree(int n, int k){
		int randomNum =1 + (int)(Math.random() * k); 
		BinaryTreeNode root=new BinaryTreeNode(randomNum);
		BinarySearchTree bst = new BinarySearchTree(root);

		for(int i=1;i<n;i++){
			randomNum =1 + (int)(Math.random() * k); 
			bst.addElement(randomNum);
			
		}
		return bst;
			
	}
	
	public static void testBinaryTree(){
		
		BinarySearchTree bst=createRandomBSTree(20,200);
		bst.BFSLayers();
		System.out.println(" ");
		System.out.println("The height of the tree is "+ bst.height());
		System.out.println("___________________Reverse the tree____________________");
		bst.reverseTree();
		bst.BFSLayers();
		System.out.println(" ");
		System.out.println("The height of the tree after reversal is "+ bst.height());

		
		
	}
	
	public static void testIterator(){
		int randomNum;
		BinarySearchTree bst=createRandomBSTree(20,200);
		Iterator x=bst.iterator();
		System.out.println("The next 1 time result is " + x.next());
		System.out.println("The next 2 times result is " + x.next());
		System.out.println("The next 3 times result is " + x.next());
		System.out.println("The next 4 times result is " + x.next());
		System.out.println("The next 5 times result is " + x.next());
		for(int i=0;i<19;i++){
			randomNum =201 + (int)(Math.random() * 400); 
			bst.addElement(randomNum);
		}
		while(x.hasNext()){
			System.out.println("The next() returns " + x.next());
			
		}

		
	}
	
	public static void testHeightOfRandomBSTree(){
		BinarySearchTree bst=createRandomBSTree(100,1000);
		System.out.println("The height of the tree is "+ bst.height());
		
	}
	


	public static void main(String[] args){
		
		testBinaryTree();
		System.out.println("______Test the Iterator_____ ");
		testIterator();
		System.out.println("______The height of the tree of 100 elements_____ ");
		testHeightOfRandomBSTree();
		
	}
	
}
