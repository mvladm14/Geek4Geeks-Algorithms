package trees;

import trees.nodes.BinaryNode;

public class CheckIfBinaryTreeIsSymmetric {

	public static void main(String[] args) {
		BinaryNode root = createTree();
		System.out.println(isSymmetric(root.left, root.right) ? "yes" : "no");
		
		BinaryNode notSymmetric = createTree2();
		System.out.println(isSymmetric(notSymmetric.left, notSymmetric.right) ? "yes" : "no");
	}

	private static boolean isSymmetric(BinaryNode n1, BinaryNode n2) {

		if (n1 == null && n2 == null)
			return true;
		
		if (n1 == null || n2 == null)
			return false;
		
		if (n1.value == n2.value)
			return isSymmetric(n1.left, n2.right) && isSymmetric(n1.right, n2.left);
		else
			return false;
	}

	private static BinaryNode createTree() {
		BinaryNode root = new BinaryNode(1);

		root.left = new BinaryNode(2);
		root.right = new BinaryNode(2);

		root.left.left = new BinaryNode(3);
		root.left.right = new BinaryNode(4);
		root.right.left = new BinaryNode(4);
		root.right.right = new BinaryNode(3);

		return root;
	}
	
	private static BinaryNode createTree2() {
		BinaryNode root = new BinaryNode(1);

		root.left = new BinaryNode(2);
		root.right = new BinaryNode(2);

		root.left.right = new BinaryNode(3);
		root.right.right = new BinaryNode(3);

		return root;
	}
}