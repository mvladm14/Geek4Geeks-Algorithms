package trees;

import trees.nodes.BinaryNode;

// http://www.geeksforgeeks.org/find-maximum-path-sum-two-leaves-binary-tree/
public class FindMaximumPathSumBetweenTwoLeavesOfBinaryTree {

	private static int maxSol1 = 0;

	public static void main(String[] args) {
		BinaryNode root = createTree();
		computeMaxSol1(root);
		System.out.println(maxSol1);
	}

	private static void computeMaxSol1(BinaryNode n) {
		if (n == null)
			return;
		
		computeMaxSol1(n.left);
		computeMaxSol1(n.right);

		int maxSumleft = computeMaxSumPathFromRootToLeaf(n.left);
		int maxSumRight = computeMaxSumPathFromRootToLeaf(n.right);
		int sum = maxSumleft + maxSumRight + n.value;

		if (sum > maxSol1)
			maxSol1 = sum;
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
		BinaryNode root = new BinaryNode(-15);

		root.left = new BinaryNode(5);
		root.right = new BinaryNode(6);

		root.left.left = new BinaryNode(-8);
		root.left.right = new BinaryNode(1);
		root.right.left = new BinaryNode(3);
		root.right.right = new BinaryNode(9);

		root.left.left.left = new BinaryNode(2);
		root.left.left.right = new BinaryNode(6);
		root.right.right.right = new BinaryNode(0);

		root.right.right.right.left = new BinaryNode(4);
		root.right.right.right.right = new BinaryNode(-1);

		root.right.right.right.right.left = new BinaryNode(10);

		return root;
	}
}