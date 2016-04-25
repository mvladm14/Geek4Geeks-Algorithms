package trees;

import trees.nodes.BinaryNode;

public class PrintTopViewOfBinaryTree {

	private static int[] topArr = new int[10];

	public static void main(String[] args) {

		BinaryNode root = createTree();
		int middle = 5;
		createTopView(root, middle);
		printTopView();
	}

	private static void createTopView(BinaryNode n, int distance) {
		if (n == null)
			return;

		if (topArr[distance] == 0)
			topArr[distance] = n.value;

		createTopView(n.left, distance - 1);
		createTopView(n.right, distance + 1);
	}

	private static void printTopView() {
		for (int i = 0; i < topArr.length; i++) {
			if (topArr[i] != 0) System.out.print(topArr[i] + " ");
		}		
	}

	private static BinaryNode createTree() {
		BinaryNode root = new BinaryNode(1);

		root.left = new BinaryNode(2);
		root.right = new BinaryNode(3);

		root.left.left = new BinaryNode(4);
		root.left.right = new BinaryNode(5);
		root.right.left = new BinaryNode(6);
		root.right.right = new BinaryNode(7);

		return root;
	}
}