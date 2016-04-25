package trees;

import trees.nodes.BinaryNode;
import java.util.LinkedList;
import java.util.Queue;

public class PrintNodesBetweenTwoGivenLevelsInBinaryTree {

	public static void main(String[] args) {
		BinaryNode root = createTree();
		printNodesBetweenLevels(root, 2, 4);
	}

	private static void printNodesBetweenLevels(BinaryNode n, int low, int high) {

		if (n == null)
			return;

		Queue<BinaryNode> q = new LinkedList<>();
		q.add(n);
		BinaryNode marker = new BinaryNode(-1);
		q.add(marker);

		int currentLevel = 1;

		while (!q.isEmpty()) {

			BinaryNode node = q.remove();

			if (node.value == marker.value) {
				System.out.println();
				currentLevel++;

				if (currentLevel > high)
					break;

				q.add(marker);
				continue;
			}

			if (low <= currentLevel && currentLevel <= high)
				System.out.print(node.value + " ");

			if (node.left != null)
				q.add(node.left);
			if (node.right != null)
				q.add(node.right);
		}
	}

	private static BinaryNode createTree() {
		BinaryNode root = new BinaryNode(20);

		root.left = new BinaryNode(8);
		root.right = new BinaryNode(22);

		root.left.left = new BinaryNode(4);
		root.left.right = new BinaryNode(12);

		root.left.right.left = new BinaryNode(10);
		root.left.right.right = new BinaryNode(14);

		return root;
	}
}