

public class BinaryTreeNode<E> {
	E data;
	BinaryTreeNode<E> leftChild;
	BinaryTreeNode<E> rightChild;
	int depth;
	boolean judge1=false;
	
	public BinaryTreeNode (E data1){
		
		data=data1;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public BinaryTreeNode<E> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BinaryTreeNode<E> leftChild) {
		this.leftChild = leftChild;
	}

	public BinaryTreeNode<E> getRightChild() {
		return rightChild;
	}

	public void setRightChild(BinaryTreeNode<E> rightChild) {
		this.rightChild = rightChild;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public boolean isJudge1() {
		return judge1;
	}

	public void setJudge1(boolean judge1) {
		this.judge1 = judge1;
	}
	
	
}
