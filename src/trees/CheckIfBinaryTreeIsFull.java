package trees;

import trees.nodes.BinaryNode;

// http://www.geeksforgeeks.org/check-whether-binary-tree-full-binary-tree-not/
public class CheckIfBinaryTreeIsFull {

	public static void main(String[] args) {
		BinaryNode root = createTree();
		System.out.println(isFull(root) ? "yes" : "no");


		BinaryNode root2 = createTree2();
		System.out.println(isFull(root2) ? "yes" : "no");
		

		BinaryNode root3 = createTree3();
		System.out.println(isFull(root3) ? "yes" : "no");
	}
	
	private static boolean isFull(BinaryNode n) {
		
		if (n == null) return true;
		
		if (n.left != null && n.right == null) return false;
		if (n.right != null && n.left == null) return false;
		
		return isFull(n.left) && isFull(n.right);
	}

	private static BinaryNode createTree3() {

		BinaryNode root = new BinaryNode(1);

		root.left = new BinaryNode(2);
		root.right = new BinaryNode(3);
		
		root.left.left = new BinaryNode(4);

		return root;
	}

	private static BinaryNode createTree2() {

		BinaryNode root = new BinaryNode(1);

		root.left = new BinaryNode(2);

		root.left.left = new BinaryNode(4);

		return root;
	}

	private static BinaryNode createTree() {

		BinaryNode root = new BinaryNode(1);

		root.left = new BinaryNode(2);
		root.right = new BinaryNode(3);

		root.left.left = new BinaryNode(4);
		root.left.right = new BinaryNode(5);

		return root;
	}
}