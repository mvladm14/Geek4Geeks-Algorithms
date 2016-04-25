package trees;

import trees.nodes.BinaryNode;

public class PrintRightViewOfBinaryTree {

	public static void main(String[] args) {
		BinaryNode root = createTree();
		printRightView(root);
	}

	private static void printRightView(BinaryNode n) {
		if (n == null) return;
		System.out.println(n.value);
		if (n.right == null) printRightView(n.left);
		printRightView(n.right);
	}

	private static BinaryNode createTree() {
		BinaryNode root = new BinaryNode(1);

		root.left = new BinaryNode(2);
		root.right = new BinaryNode(3);

		root.left.left = new BinaryNode(4);
		root.left.right = new BinaryNode(5);
		root.right.left = new BinaryNode(6);
		root.right.right = new BinaryNode(7);

		root.right.right.right = new BinaryNode(8);

		return root;
	}
}