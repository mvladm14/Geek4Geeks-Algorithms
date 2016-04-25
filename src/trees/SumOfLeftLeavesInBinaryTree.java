package trees;

import trees.nodes.BinaryNode;

public class SumOfLeftLeavesInBinaryTree {

	public static void main(String[] args) {
		BinaryNode root = createTree();
		System.out.println(sumOfLeftLeaves(root));
	}
	
	private static int sumOfLeftLeaves(BinaryNode n) {
		
		if (n == null) return 0;
		
		if (n.left != null && n.left.isLeaf()) return n.left.value + sumOfLeftLeaves(n.right);
		
		return sumOfLeftLeaves(n.left) + sumOfLeftLeaves(n.right);
	}
	
	private static BinaryNode createTree() {

		BinaryNode root = new BinaryNode(20);

		root.left = new BinaryNode(9);
		root.right = new BinaryNode(49);

		root.left.left = new BinaryNode(5);
		root.left.right = new BinaryNode(12);
		root.right.left = new BinaryNode(23);
		root.right.right = new BinaryNode(52);
		
		root.left.right.right = new BinaryNode(15);
		root.right.right.left = new BinaryNode(50);
		
		return root;
	}
}