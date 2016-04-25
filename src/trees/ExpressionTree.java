package trees;

import trees.nodes.ExpressionTreeNode;

public class ExpressionTree {

	public static void main(String[] args) {
		ExpressionTreeNode root = createTree();
		
		System.out.println(computeExpressionTree(root));

	}
	
	private static int computeExpressionTree(ExpressionTreeNode node) {
		
		if (node == null) return 0;

		if (node.operation == '+') return computeExpressionTree(node.left) + computeExpressionTree(node.right);
		if (node.operation == '*') return computeExpressionTree(node.left) * computeExpressionTree(node.right);
		
		return node.value;		
	}

	private static ExpressionTreeNode createTree() {
		ExpressionTreeNode root = new ExpressionTreeNode('+');
		
		root.left = new ExpressionTreeNode(3);
		root.right = new ExpressionTreeNode('*');
		
		root.right.left = new ExpressionTreeNode('+');
		root.right.right = new ExpressionTreeNode(2);
		
		root.right.left.left = new ExpressionTreeNode(5);
		root.right.left.right = new ExpressionTreeNode(9);
		
		return root;
	}
}
