package trees;

import trees.nodes.BinaryNode;

public class FindTheClosestLeafInBinaryTree {

	private static int minDistance = Integer.MAX_VALUE;
	private static BinaryNode closestNode;

	public static void main(String[] args) {

		BinaryNode root = createTree();
		BinaryNode x = root.right;

		//closestNode(root, x);
		//System.out.println(closestNode.value);

		BinaryNode y = root.right.right;
		closestNode(root, y);
		System.out.println(closestNode.value);
	}

	private static void closestNode(BinaryNode tree, BinaryNode node) {
		findClosestNodeFromBelow(node, 0);
		findClosestNodeThroughParent(tree, node);
	}

	private static int findClosestNodeThroughParent(BinaryNode tree, BinaryNode node) {

		if (tree == null)
			return -1;
		if (tree == node)
			return 0;

		int left = findClosestNodeThroughParent(tree.left, node);
		if (left != -1) {
			findClosestNodeFromBelow(tree.right, left + 2);
			return left + 1;
		}

		int right = findClosestNodeThroughParent(tree.right, node);
		if (right != -1) {
			findClosestNodeFromBelow(tree.left, right + 2);
			return right + 1;
		}

		return -1;
	}

	private static void findClosestNodeFromBelow(BinaryNode node, int distance) {

		if (node == null)
			return;

		if (node.isLeaf())
			if (minDistance > distance) {
				minDistance = distance;
				closestNode = node;
			}

		findClosestNodeFromBelow(node.left, distance + 1);
		findClosestNodeFromBelow(node.right, distance + 1);
	}

	private static BinaryNode createTree() {
		BinaryNode root = new BinaryNode(1);

		root.left = new BinaryNode(2);
		root.right = new BinaryNode(3);

		root.right.left = new BinaryNode(4);
		root.right.right = new BinaryNode(5);

		root.right.left.left = new BinaryNode(6);
		root.right.right.left = new BinaryNode(7);

		root.right.left.left.left = new BinaryNode(8);
		root.right.left.left.right = new BinaryNode(9);
		root.right.right.left.left = new BinaryNode(10);

		return root;
	}
}