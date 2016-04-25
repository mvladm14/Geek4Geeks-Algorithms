package trees;

import trees.nodes.BinaryNode;

public class CheckIfTwoNodesAreCousinsInBinaryTree {

	public static void main(String[] args) {
		BinaryNode root = createTree();
		
		System.out.println(areCousins(root, root.left.left, root.right.left) ? "true" : "false");
		System.out.println(areCousins(root, root.left, root.right) ? "true" : "false");
		System.out.println(areCousins(root, root.left.right, root.right.left) ? "true" : "false");

	}
	
	private static boolean areCousins(BinaryNode root, BinaryNode x, BinaryNode y) {
		int levelX = getLevelOfCousin(root, x);
		int levelY = getLevelOfCousin(root, y);
		
		return levelX == levelY && x.parent != y.parent;
	}
	
	private static int getLevelOfCousin(BinaryNode root, BinaryNode x) {
		if (root == null) return 100;
		if (root == x) return 1;
		
		int left = getLevelOfCousin(root.left, x);
		int right = getLevelOfCousin(root.right, x);
		
		return Math.min(left, right) + 1;
	}

	private static BinaryNode createTree() {
		BinaryNode root = new BinaryNode(6);
		
		root.left = new BinaryNode(3, root);
		root.right = new BinaryNode(5, root);
		
		root.left.left = new BinaryNode(7, root.left);
		root.left.right = new BinaryNode(8, root.left);
		root.right.left = new BinaryNode(1, root.right);
		root.right.right = new BinaryNode(3, root.right);
		
		return root;
	}
}