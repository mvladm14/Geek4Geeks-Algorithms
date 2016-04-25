package trees;

import trees.nodes.BinaryNode;

// http://www.geeksforgeeks.org/check-whether-binary-tree-complete-not-set-2-recursive-solution/
public class CheckIfBinaryTreeIsComplete {

	private static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		BinaryNode root = createTree();
		System.out.println(isComplete(root, 0) ? "yes" : "no");

		max = Integer.MIN_VALUE;

		BinaryNode root2 = createTree2();
		System.out.println(isComplete(root2, 0) ? "yes" : "no");
		
		max = Integer.MIN_VALUE;

		BinaryNode root3 = createTree3();
		System.out.println(isComplete(root3, 0) ? "yes" : "no");
	}

	private static boolean isComplete(BinaryNode n, int level) {

		if (n == null)
			if (level == max)
				return true;
			else
				return false;

		if (level > max)
			max = level;

		boolean leftAndRight = isComplete(n.left, level + 1) && isComplete(n.right, level + 1);

		if (level == max - 1)
			return n.left != null || (n.left == null && n.right == null);
		else
			return leftAndRight;
	}
	
	private static BinaryNode createTree3() {

		BinaryNode root = new BinaryNode(1);

		root.left = new BinaryNode(2);
		root.right = new BinaryNode(3);
		
		root.left.left = new BinaryNode(4);
		root.left.right = new BinaryNode(5);
		
		root.right.right = new BinaryNode(6);

		return root;
	}

	private static BinaryNode createTree2() {

		BinaryNode root = new BinaryNode(1);

		root.left = new BinaryNode(2);

		root.left.left = new BinaryNode(4);

		return root;
	}

	private static BinaryNode createTree() {

		BinaryNode root = new BinaryNode(1);

		root.left = new BinaryNode(2);
		root.right = new BinaryNode(3);

		root.left.left = new BinaryNode(4);
		root.left.right = new BinaryNode(5);

		return root;
	}
}