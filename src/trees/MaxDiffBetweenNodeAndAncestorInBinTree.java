package trees;

public class MaxDiffBetweenNodeAndAncestorInBinTree {

	private static int difference = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Node root = createTree();
		computeMaxDifference(root);
		System.out.println(difference);
	}

	private static int computeMaxDifference(Node n) {
		if (n == null)
			return Integer.MAX_VALUE;

		if (n.left == null && n.right == null)
			return n.value;

		int minNode = Math.min(computeMaxDifference(n.left), computeMaxDifference(n.right));

		difference = Math.max(difference, n.value - minNode);

		return Math.min(minNode, n.value);
	}

	private static Node createTree() {
		Node root = new MaxDiffBetweenNodeAndAncestorInBinTree().new Node(8);
		root.left = new MaxDiffBetweenNodeAndAncestorInBinTree().new Node(3);
		root.left.left = new MaxDiffBetweenNodeAndAncestorInBinTree().new Node(1);
		root.left.right = new MaxDiffBetweenNodeAndAncestorInBinTree().new Node(6);
		root.left.right.left = new MaxDiffBetweenNodeAndAncestorInBinTree().new Node(4);
		root.left.right.right = new MaxDiffBetweenNodeAndAncestorInBinTree().new Node(7);
		root.right = new MaxDiffBetweenNodeAndAncestorInBinTree().new Node(10);
		root.right.right = new MaxDiffBetweenNodeAndAncestorInBinTree().new Node(14);
		root.right.right.left = new MaxDiffBetweenNodeAndAncestorInBinTree().new Node(13);
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