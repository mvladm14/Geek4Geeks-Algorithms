package trees;

import java.util.LinkedList;
import java.util.Queue;

import trees.nodes.BinaryNode;

// http://www.geeksforgeeks.org/find-next-right-node-of-a-given-key/
public class FindNextRightNodeOfAGivenKey {

	public static void main(String[] args) {
		BinaryNode root = createTree();
		BinaryNode x = root.left;

		BinaryNode rightOfX = retrieveRightNode(root, x);
		System.out.println(rightOfX.value);

		x = root.left.right;
		rightOfX = retrieveRightNode(root, x);
		System.out.println(rightOfX.value);

		x = root.left.left;
		rightOfX = retrieveRightNode(root, x);
		System.out.println(rightOfX.value);

		x = root.right;
		rightOfX = retrieveRightNode(root, x);
		System.out.println(rightOfX == null ? "null" : rightOfX.value);
	}

	private static BinaryNode retrieveRightNode(BinaryNode n, BinaryNode x) {

		if (n == null || x == null)
			return null;

		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(n);

		Queue<BinaryNode> newLevelQueue = new LinkedList<>();

		while (!queue.isEmpty()) {
			BinaryNode current = queue.poll();
			if (current == x)
				return queue.poll();

			if (current.left != null)
				newLevelQueue.add(current.left);
			if (current.right != null)
				newLevelQueue.add(current.right);

			if (queue.isEmpty()) {
				queue.addAll(newLevelQueue);
				newLevelQueue = new LinkedList<>();
			}
		}

		return null;
	}

	private static BinaryNode createTree() {
		BinaryNode root = new BinaryNode(10);

		root.left = new BinaryNode(2);
		root.right = new BinaryNode(6);

		root.left.left = new BinaryNode(8);
		root.left.right = new BinaryNode(4);
		root.right.right = new BinaryNode(5);

		return root;
	}
}