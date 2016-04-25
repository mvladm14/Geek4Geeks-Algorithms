package trees;

public class ClosestLeafToAGivenNodeInBinaryTree {

	private static int minDistance = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Node root = createTree();
		Node x = root.right;

		getMinDistanceFromNodeToLeaves(root, x);
	}

	private static void getMinDistanceFromNodeToLeaves(Node root, Node x) {
		findLeafDown(x, 0);
		findDistanceThroughParent(root, x);
		System.out.println(minDistance);
	}

	private static void findLeafDown(Node root, int lev) {
		// base case
		if (root == null)
			return;

		// If this is a leaf node, then check if it is closer
		// than the closest so far
		if (root.left == null && root.right == null) {
			if (lev < minDistance)
				minDistance = lev;
			return;
		}

		// Recur for left and right subtrees
		findLeafDown(root.left, lev + 1);
		findLeafDown(root.right, lev + 1);
	}

	private static int findDistanceThroughParent(Node root, Node x) {

		if (root == null)
			return -1;
		if (root == x)
			return 0;

		int levelLeft = findDistanceThroughParent(root.left, x);
		if (levelLeft != -1) {
			findLeafDown(root.right, levelLeft + 2);
			return levelLeft + 1;
		}

		int levelRight = findDistanceThroughParent(root.right, x);
		if (levelRight != -1) {
			findLeafDown(root.left, levelRight + 2);
			return levelRight + 1;
		}

		return -1;
	}

	private static int getMinDistanceFromRootToLeaves(Node root) {
		if (root == null)
			return Integer.MAX_VALUE;
		if (root.left == null && root.right == null)
			return 0;

		int minLeft = getMinDistanceFromRootToLeaves(root.left);
		int minRight = getMinDistanceFromRootToLeaves(root.right);

		int min = Math.min(minLeft, minRight);
		return min + 1;
	}

	private static Node createTree() {
		Node root = new ClosestLeafToAGivenNodeInBinaryTree().new Node(1);
		root.left = new ClosestLeafToAGivenNodeInBinaryTree().new Node(12);
		root.right = new ClosestLeafToAGivenNodeInBinaryTree().new Node(13);

		root.right.left = new ClosestLeafToAGivenNodeInBinaryTree().new Node(14);
		root.right.right = new ClosestLeafToAGivenNodeInBinaryTree().new Node(15);

		root.right.left.left = new ClosestLeafToAGivenNodeInBinaryTree().new Node(21);
		root.right.left.right = new ClosestLeafToAGivenNodeInBinaryTree().new Node(22);
		root.right.right.left = new ClosestLeafToAGivenNodeInBinaryTree().new Node(23);
		root.right.right.right = new ClosestLeafToAGivenNodeInBinaryTree().new Node(24);

		root.right.left.left.left = new ClosestLeafToAGivenNodeInBinaryTree().new Node(1);
		root.right.left.left.right = new ClosestLeafToAGivenNodeInBinaryTree().new Node(2);
		root.right.left.right.left = new ClosestLeafToAGivenNodeInBinaryTree().new Node(3);
		root.right.left.right.right = new ClosestLeafToAGivenNodeInBinaryTree().new Node(4);
		root.right.right.left.left = new ClosestLeafToAGivenNodeInBinaryTree().new Node(5);
		root.right.right.left.right = new ClosestLeafToAGivenNodeInBinaryTree().new Node(6);
		root.right.right.right.left = new ClosestLeafToAGivenNodeInBinaryTree().new Node(7);
		root.right.right.right.right = new ClosestLeafToAGivenNodeInBinaryTree().new Node(8);

		return root;
	}

	private class Node {
		int value;
		Node left, right;

		public Node(int value) {
			this.value = value;
		}
	}
}