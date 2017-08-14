import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;


/*
 * This class is a binary tree class.
 * It creates a height method and reverse tree method and a BFS algorithm and an in-order iterator
 * 
 * @author: Kexin Huang
 */





public class BinaryTree<E> implements Iterable<E>{
	
	BinaryTreeNode<E> root;
	
	public BinaryTree (BinaryTreeNode<E> root1){
		root=root1;
	}
	
	public int height(){
		int maxDepth=-1;
		Stack<BinaryTreeNode<E>> stack=new Stack<BinaryTreeNode<E>>();
		stack.push(root);
		//I store a variable in every node, depth to trace the depth of each node
		while(!stack.isEmpty()){
			BinaryTreeNode<E> a =  stack.pop();
			if(a.getDepth()>maxDepth){
				maxDepth=a.getDepth();
			}
			if(a.leftChild!=null){
				a.leftChild.setDepth(a.getDepth()+1);
				stack.push(a.leftChild);
			}
			if(a.rightChild!=null){
				a.rightChild.setDepth(a.getDepth()+1);
				stack.push(a.rightChild);
			}
		}
		return maxDepth+1;
		// including depth 0
		
	}
	
	public void reverseTree(){
		Stack<BinaryTreeNode<E>> stack=new Stack<BinaryTreeNode<E>>();
		stack.push(root);
		while(!stack.isEmpty()){
			BinaryTreeNode<E> a=stack.pop();
			BinaryTreeNode<E> temp=a.leftChild;
			BinaryTreeNode<E> tempb=a.rightChild;
			
				a.setRightChild(temp);
				a.setLeftChild(tempb);
				//swap
				if(a.rightChild!=null)
					stack.push(a.rightChild);
				if(a.leftChild!=null)
					stack.push(a.leftChild);
					
		}	
	}
	

	public void BFSLayers(){
		Queue<BinaryTreeNode<E>> queue=new LinkedList<BinaryTreeNode<E>>();
		BinaryTreeNode<E> current;
		BinaryTreeNode<E> EOL=new BinaryTreeNode<E>(null);
		//EOL means End Of Layer, a divider divides each layer 
		int countEOL=1;
		//EOL counter
		queue.add(root);
		queue.add(EOL);
		System.out.print("Layer 0"+" :");
		while(!queue.isEmpty()){
			current=queue.poll();
			if(current.equals(EOL)){
				if(queue.size()==0){
					//after all the iteration, there will be a EOL left in the queue, causing stack overflow
					//therefore, check if the size=0 then don't add more EOL make the queue empty
				}else{
					System.out.println(" ");
					System.out.print("Layer "+countEOL+" :");
					queue.add(EOL);
					countEOL++;
				}
			}else{
				System.out.print(current.getData()+" ");
				if(current.leftChild!=null){
					queue.add(current.leftChild);
				}
				if(current.rightChild!=null){
					queue.add(current.rightChild);
				}

			}
			
		
		}
		
		
	}
	
	
	public Iterator<E> iterator() {
		return new InOrderIterator();
	}
	
	
	public class InOrderIterator implements Iterator<E>{
		Stack<BinaryTreeNode<E>> stack;
		BinaryTreeNode<E> top;
		//constructor
		public InOrderIterator(){
			stack=new Stack<BinaryTreeNode<E>>();
			if(root!=null)
				stack.push(root);
		}

		/* (non-Javadoc)
		 * @see java.util.Iterator#hasNext()
		 */
		public boolean hasNext() {
			return (!stack.isEmpty());
		}
		
		/* (non-Javadoc)
		 * @see java.util.Iterator#next()
		 */
		public E next() {
			if(!hasNext()){
				throw new NoSuchElementException("no element");
			}
			E temp=null;
			boolean judge=true;
			// judge if there is an output, if not go on
			while(judge){
				top=stack.pop();
				//isJudge  check if this is the data we want
				if(top.isJudge1()){
					temp=top.getData();
					judge=false;
				}else{
				if (top.getRightChild() != null)
					stack.push(top.getRightChild());
				BinaryTreeNode<E> temp1=new BinaryTreeNode<E>(top.data);
				temp1.setJudge1(true);
				//this temp1 is the data we want, so set it as true
				stack.push(temp1);
				if (top.getLeftChild() != null)
					stack.push(top.getLeftChild());
				}
		}		
			return temp;
		}
		
	}
	
	
	
	
	
}
