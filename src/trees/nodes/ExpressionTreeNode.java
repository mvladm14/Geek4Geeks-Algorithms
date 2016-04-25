package trees.nodes;

public class ExpressionTreeNode {
	
	public int value;
	public char operation;
	
	public ExpressionTreeNode left, right;
	
	public ExpressionTreeNode(int value) {
		this.value = value;
	}
	
	public ExpressionTreeNode(char operation) {
		this.operation = operation;
	}	
}