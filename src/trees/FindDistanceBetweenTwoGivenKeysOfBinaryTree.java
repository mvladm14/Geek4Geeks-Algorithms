package trees;

import trees.nodes.BinaryNode;

// http://www.geeksforgeeks.org/find-distance-two-given-nodes/
public class FindDistanceBetweenTwoGivenKeysOfBinaryTree {

	public static void main(String[] args) {
		BinaryNode root = createTree();

		BinaryNode x = root.left.left;
		BinaryNode y = root.left.right;
		System.out.println("Distance = " + findMinDistance(root, x, y));
		
		x = root.left.left;
		y = root.right.left;
		System.out.println("Distance = " + findMinDistance(root, x, y));
		
		x = root.right;
		y = root.left.left;
		System.out.println("Distance = " + findMinDistance(root, x, y));
	}

	private static int findMinDistance(BinaryNode root, BinaryNode x, BinaryNode y) {
		BinaryNode lca = findLCA(root, x, y);
		int distanceX = getDistance(lca, x);
		int distanceY = getDistance(lca, y);
		return distanceX + distanceY;
	}

	private static BinaryNode findLCA(BinaryNode root, BinaryNode x, BinaryNode y) {

		if (root == null)
			return null;

		if (root == x || root == y)
			return root;

		BinaryNode left = findLCA(root.left, x, y);
		BinaryNode right = findLCA(root.right, x, y);

		if (left != null && right != null)
			return root;

		return left != null ? left : right;
	}

	private static int getDistance(BinaryNode lca, BinaryNode n) {
		if (lca == null) return Integer.MIN_VALUE;
		if (lca == n) return 0;
		
		int left = getDistance(lca.left, n);
		int right = getDistance(lca.right, n);
		
		if (left == right) return Integer.MIN_VALUE;
		
		int max = Math.max(left, right) + 1;
		return max;		
	}

	private static BinaryNode createTree() {
		BinaryNode root = new BinaryNode(1);

		root.left = new BinaryNode(2);
		root.right = new BinaryNode(3);

		root.left.left = new BinaryNode(4);
		root.left.right = new BinaryNode(5);
		root.right.left = new BinaryNode(6);
		root.right.right = new BinaryNode(7);

		root.right.left.right = new BinaryNode(8);

		return root;
	}
}