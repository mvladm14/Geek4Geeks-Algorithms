package trees;

import trees.nodes.BinaryNode;

public class DiagonalSumOfBinaryTree {

	private static int[] sums = new int[10];;

	public static void main(String[] args) {

		BinaryNode root = createTree();

		computeDiagonalSum(root, 0);

		printDiagonalSums();
	}

	private static void printDiagonalSums() {
		for (int i = 0; i < sums.length; i++)
			if (sums[i] != 0)
				System.out.println(sums[i]);
	}

	private static void computeDiagonalSum(BinaryNode root, int level) {

		if (root == null)
			return;

		computeDiagonalSum(root.left, level + 1);
		computeDiagonalSum(root.right, level);

		sums[level] += root.value;
	}

	private static BinaryNode createTree() {
		BinaryNode root = new BinaryNode(1);

		root.left = new BinaryNode(2);
		root.right = new BinaryNode(3);

		root.left.left = new BinaryNode(9);
		root.left.right = new BinaryNode(6);
		root.right.left = new BinaryNode(4);
		root.right.right = new BinaryNode(5);

		root.left.left.right = new BinaryNode(10);
		root.left.right.left = new BinaryNode(11);
		root.right.left.left = new BinaryNode(12);
		root.right.left.right = new BinaryNode(7);

		return root;
	}
}