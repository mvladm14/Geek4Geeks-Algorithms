package trees.nodes;

public class BinaryNode {

	public int value;
	public char charValue;
	public BinaryNode left, right;
	public BinaryNode parent;

	public BinaryNode(int value) {
		this.value = value;
	}
	
	public BinaryNode(char charValue) {
		this.charValue = charValue;
	}
	
	public BinaryNode(int value, BinaryNode parent) {
		this.value = value;
		this.parent = parent;
	}
	
	public boolean isLeaf() {
		return left == null && right == null;
	}

	public void preorderPrint() {
		System.out.println(this.value);
		if (left != null)
			left.preorderPrint();
		if (right != null)
			right.preorderPrint();
	}
	
	public void preorderCharPrint() {
		System.out.print(this.charValue + " ");
		if (left != null)
			left.preorderCharPrint();
		if (right != null)
			right.preorderCharPrint();
	}
	
	public void postorderPrint() {
		if (left != null) left.postorderPrint();
		if (right != null) right.postorderPrint();
		System.out.println(this.value);
	}
	
	public void inorderPrint() {
		if (left != null) left.inorderPrint();
		System.out.print(this.value + " ");
		if (right != null) right.inorderPrint();
	}
}