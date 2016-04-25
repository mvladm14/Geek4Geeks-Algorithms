package trees;

import trees.nodes.BinaryNode;

// http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
public class LowestCommonAncestorBinaryTreeVersion2 {

	public static void main(String[] args) {
		BinaryNode root = createTree();

		BinaryNode x = root.left.left;
		BinaryNode y = root.left.right;
		System.out.println("LCA = " + findLCA(root, x, y).value);

		x = root.left.left;
		y = root.right.left;
		System.out.println("LCA = " + findLCA(root, x, y).value);

		x = root.right;
		y = root.left.left;
		System.out.println("LCA = " + findLCA(root, x, y).value);
	}

	private static BinaryNode findLCA(BinaryNode root, BinaryNode x, BinaryNode y) {

		if (root == null)
			return null;

		if (root == x || root == y)
			return root;
		
		BinaryNode left = findLCA(root.left, x, y);
		BinaryNode right = findLCA(root.right, x, y);
		
		if (left != null && right != null) return root;
		
		return left != null ? left : right;
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
