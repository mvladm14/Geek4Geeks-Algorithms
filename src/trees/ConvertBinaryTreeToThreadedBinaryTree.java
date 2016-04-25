package trees;

import java.util.LinkedList;
import java.util.Queue;

public class ConvertBinaryTreeToThreadedBinaryTree {

	public static void main(String[] args) {
		Node root = createTree();
		Queue<Node> q = new LinkedList<>();
		root.inorderPrint();
		System.out.println();

		createQueue(root, q);
		createThreadedBinaryTree(q);
		root.inorderPrint();
	}

	private static void createThreadedBinaryTree(Queue<Node> q) {
		while (!q.isEmpty()) {
			Node current = q.remove();
			if (current.right == null) {
				current.right = q.poll();
				if (current.right != null)
					current.isThreaded = true;
			}
		}
	}

	private static void createQueue(Node n, Queue<Node> q) {

		if (n == null)
			return;

		createQueue(n.left, q);
		q.add(n);
		createQueue(n.right, q);
	}

	private static Node createTree() {
		Node root = new ConvertBinaryTreeToThreadedBinaryTree().new Node(6);

		root.left = new ConvertBinaryTreeToThreadedBinaryTree().new Node(3);
		root.right = new ConvertBinaryTreeToThreadedBinaryTree().new Node(8);

		root.left.left = new ConvertBinaryTreeToThreadedBinaryTree().new Node(1);
		root.left.right = new ConvertBinaryTreeToThreadedBinaryTree().new Node(5);
		root.right.left = new ConvertBinaryTreeToThreadedBinaryTree().new Node(7);
		root.right.right = new ConvertBinaryTreeToThreadedBinaryTree().new Node(11);

		root.right.right.left = new ConvertBinaryTreeToThreadedBinaryTree().new Node(9);
		root.right.right.right = new ConvertBinaryTreeToThreadedBinaryTree().new Node(13);

		return root;
	}

	private class Node {
		int value;
		boolean isThreaded;

		Node left, right;

		public Node(int value) {
			this.value = value;
		}

		public void inorderPrint() {
			if (left != null && !left.isThreaded)
				left.inorderPrint();
			System.out.print(this.value + " ");
			if (right != null && !right.isThreaded)
				right.inorderPrint();
		}
	}
}