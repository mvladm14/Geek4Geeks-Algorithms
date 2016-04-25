package trees;

import trees.nodes.BinaryNode;

public class FindMinimumDepthOfBinaryTree {

	public static void main(String[] args) {
		BinaryNode root = createTree();
		System.out.println(findMinimumDepth(root));
	}

	private static int findMinimumDepth(BinaryNode n) {

		if (n == null)
			return 0;

		if (n.left == null)
			return findMinimumDepth(n.right) + 1;

		if (n.right == null)
			return findMinimumDepth(n.left) + 1;

		int min = Math.min(findMinimumDepth(n.left), findMinimumDepth(n.right));

		return min + 1;
	}

	private static BinaryNode createTree() {
		BinaryNode root = new BinaryNode(1);

		root.left = new BinaryNode(2);
		root.right = new BinaryNode(3);

		root.left.left = new BinaryNode(4);
		root.left.right = new BinaryNode(5);

		// root.right.left = new BinaryNode(6);

		return root;
	}
}