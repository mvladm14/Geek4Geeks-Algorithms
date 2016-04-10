package trees.nodes;

import java.util.Stack;

public class TernaryNode {
	
	// Getters and setters omitted
	public int value;
	public Stack<TernaryNode> ancestors;
	public TernaryNode left, middle, right;
	
	public TernaryNode(int value) {
		this.value = value;
		this.ancestors = new Stack<>();
	}
}