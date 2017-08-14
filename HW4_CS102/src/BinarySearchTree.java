import java.util.Stack;


public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

	public BinarySearchTree(BinaryTreeNode<E> root1) {
		super(root1);
	}
	
	public void addElement(E e){
		BinaryTreeNode<E> node=new BinaryTreeNode<E>(e);
		Stack<BinaryTreeNode<E>> stack=new Stack<BinaryTreeNode<E>>();
		BinaryTreeNode<E> current;
		stack.push(root);
		while(!stack.isEmpty()){
			current=stack.pop();
			if(e.compareTo(current.getData())>0){
				if(current.rightChild!=null)
					stack.push(current.rightChild);
				else{
					current.setRightChild(node);
				}
			}else{
				if(current.leftChild!=null)
					stack.push(current.leftChild);
				else{
					current.setLeftChild(node);
				}
			}
			
		}
		
	}
	
}
