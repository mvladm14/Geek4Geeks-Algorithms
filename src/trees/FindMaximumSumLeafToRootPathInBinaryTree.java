package trees;

import trees.nodes.BinaryNode;

public class FindMaximumSumLeafToRootPathInBinaryTree {

	public static void main(String[] args) {
		BinaryNode root = createTree();
		System.out.println(computeMaxSumPathFromRootToLeaf(root));
	}

	private static int computeMaxSumPathFromRootToLeaf(BinaryNode n) {
		if (n == null)
			return 0;

		int left = computeMaxSumPathFromRootToLeaf(n.left);
		int right = computeMaxSumPathFromRootToLeaf(n.right);
		int max = Math.max(left, right);
		int sum = max + n.value;
		return sum;
	}

	private static BinaryNode createTree() {
		BinaryNode root = new BinaryNode(10);

		root.left = new BinaryNode(-2);
		root.right = new BinaryNode(7);

		root.left.left = new BinaryNode(8);
		root.left.right = new BinaryNode(-4);

		return root;
	}
}