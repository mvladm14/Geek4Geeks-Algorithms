package trees;

import trees.nodes.BinaryNode;

// http://www.geeksforgeeks.org/print-nodes-dont-sibling-binary-tree/
public class PrintAllNodesThatDoNotHaveSibling {

	public static void main(String[] args) {
		BinaryNode root = createTree();
		printAllNodesThatDoNotHaveSiblings(root);
	}
	
	private static void printAllNodesThatDoNotHaveSiblings(BinaryNode root) {

		if (root == null) return;
		
		if (root.left != null && root.right == null) 
			System.out.print(root.left.value + " ");
		if (root.left == null && root.right != null)
			System.out.print(root.right.value + " ");
		
		printAllNodesThatDoNotHaveSiblings(root.left);
		printAllNodesThatDoNotHaveSiblings(root.right);
	}

	private static BinaryNode createTree() {
		BinaryNode root = new BinaryNode(1);
		
		root.left = new BinaryNode(2);
		root.right = new BinaryNode(3);
		
		root.left.right = new BinaryNode(4);
		root.right.left = new BinaryNode(5);
		
		root.right.left.left = new BinaryNode(6);
		
		return root;
	}
}