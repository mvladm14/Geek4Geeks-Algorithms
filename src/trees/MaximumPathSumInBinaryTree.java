package trees;

import trees.nodes.BinaryNode;

// http://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
public class MaximumPathSumInBinaryTree {

	private static int maxPathSum = 0;

	public static void main(String[] args) {
		BinaryNode root = createTree();
		getMaxPathSum(root);
		System.out.println(maxPathSum);

		maxPathSum = 0;

		BinaryNode root2 = createTree2();
		getMaxPathSum(root2);
		System.out.println(maxPathSum);
	}

	private static int getMaxPathSum(BinaryNode n) {
		if (n == null)
			return 0;

		int maxOfBothBranches = Math.max(getMaxPathSum(n.left), getMaxPathSum(n.right));
		int maxOfOtherBranch = Math.min(getMaxPathSum(n.left), getMaxPathSum(n.right));

		int maxSumPath = maxOfBothBranches + n.value;
		if (maxSumPath + maxOfOtherBranch > maxPathSum)
			maxPathSum = maxSumPath + maxOfOtherBranch;

		return maxSumPath > 0 ? maxSumPath : 0;
	}

	private static BinaryNode createTree() {
		BinaryNode root = new BinaryNode(10);

		root.left = new BinaryNode(2);
		root.right = new BinaryNode(10);

		root.left.left = new BinaryNode(20);
		root.left.right = new BinaryNode(1);
		root.right.right = new BinaryNode(-25);

		root.right.right.left = new BinaryNode(3);
		root.right.right.right = new BinaryNode(4);

		return root;
	}

	private static BinaryNode createTree2() {
		BinaryNode root = new BinaryNode(1);

		root.left = new BinaryNode(2);
		root.right = new BinaryNode(3);

		return root;
	}
}