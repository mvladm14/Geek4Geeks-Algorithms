package trees;

import trees.nodes.BinaryNode;

public class RemoveAllHalfNodesFromBinaryTree {

	public static void main(String[] args) {
		
		BinaryNode root = createTree();
		
		BinaryNode finalTree = removeHalfNodes(root);
		
		finalTree.preorderPrint();		
	}

	private static BinaryNode removeHalfNodes(BinaryNode n) {

		if (n == null)
			return null;
		
		if (n.left == null && n.right == null) return n;
		
		if (n.left != null && n.right == null) return removeHalfNodes(n.left);
		
		if (n.right != null && n.left == null) return removeHalfNodes(n.right);
		
		n.left = removeHalfNodes(n.left);
		n.right = removeHalfNodes(n.right);
		
		return n;
	}

	private static BinaryNode createTree() {
		BinaryNode root = new BinaryNode(2);

		root.left = new BinaryNode(7);
		root.right = new BinaryNode(5);

		root.left.right = new BinaryNode(6);
		root.right.right = new BinaryNode(9);

		root.left.right.left = new BinaryNode(1);
		root.left.right.right = new BinaryNode(11);
		root.right.right.left = new BinaryNode(4);

		return root;
	}
}