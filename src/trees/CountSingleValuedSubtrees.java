package trees;

public class CountSingleValuedSubtrees {

	private static int total = 0;

	public static void main(String[] args) {
		Node root = createTree();
		sameValueInTree(root);
		System.out.println(total);
	}

	private static boolean sameValueInTree(Node root) {

		if (root == null)
			return true;

		boolean left = sameValueInTree(root.left);
		boolean right = sameValueInTree(root.right);

		if (!(left && right))
			return false;

		if (root.left != null && root.left.value != root.value)
			return false;

		if (root.right != null && root.right.value != root.value)
			return false;

		total++;

		return true;
	}

	private static Node createTree() {
		Node root = new CountSingleValuedSubtrees().new Node(5);
		root.left = new CountSingleValuedSubtrees().new Node(4);
		root.right = new CountSingleValuedSubtrees().new Node(5);

		root.left.left = new CountSingleValuedSubtrees().new Node(4);
		root.left.right = new CountSingleValuedSubtrees().new Node(4);
		root.right.right = new CountSingleValuedSubtrees().new Node(5);

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