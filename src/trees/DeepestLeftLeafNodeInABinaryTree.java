package trees;

import trees.nodes.BinaryNode;

// http://www.geeksforgeeks.org/deepest-left-leaf-node-in-a-binary-tree/
public class DeepestLeftLeafNodeInABinaryTree {

	private static BinaryNode deepestLeftLeaf;
	private static int maxLevel;

	public static void main(String[] args) {
		BinaryNode root = createTree();
		findDeepestLeftLeaf(root, 0);
		System.out.println(deepestLeftLeaf.value);
	}

	private static void findDeepestLeftLeaf(BinaryNode n, int level) {
		if (n == null)
			return;

		if (n.left != null && n.left.isLeaf())
			if (level + 1 > maxLevel) {
				maxLevel = level + 1;
				deepestLeftLeaf = n.left;
			}

		findDeepestLeftLeaf(n.left, level + 1);
		findDeepestLeftLeaf(n.right, level + 1);
	}

	private static BinaryNode createTree() {
		BinaryNode root = new BinaryNode(1);

		root.left = new BinaryNode(2);
		root.right = new BinaryNode(3);

		root.left.left = new BinaryNode(4);
		root.right.left = new BinaryNode(5);
		root.right.right = new BinaryNode(6);

		root.right.left.right = new BinaryNode(7);
		root.right.right.right = new BinaryNode(8);

		root.right.left.right.left = new BinaryNode(9);
		root.right.right.right.right = new BinaryNode(10);

		return root;
	}
}