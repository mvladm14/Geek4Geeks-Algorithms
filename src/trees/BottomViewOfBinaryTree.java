package trees;

import trees.nodes.BinaryNode;

public class BottomViewOfBinaryTree {

	private static int[] bottomArr = new int[20];

	public static void main(String[] args) {

		BinaryNode root = createTree();

		int middle = bottomArr.length / 2;

		createButtomView(root, middle);
		printButtomView();
	}

	private static void createButtomView(BinaryNode root, int index) {

		if (root == null)
			return;

		createButtomView(root.left, index - 1);
		createButtomView(root.right, index + 1);

		if (bottomArr[index] == 0)
			bottomArr[index] = root.value;
	}

	private static void printButtomView() {
		for (int i = 0; i < bottomArr.length; i++)
			if (bottomArr[i] > 0)
				System.out.println(bottomArr[i]);
	}

	private static BinaryNode createTree() {
		BinaryNode root = new BinaryNode(20);

		root.left = new BinaryNode(8);
		root.right = new BinaryNode(22);

		root.left.left = new BinaryNode(5);
		root.left.right = new BinaryNode(3);
		root.right.right = new BinaryNode(25);
		root.right.left = new BinaryNode(4);

		root.left.right.left = new BinaryNode(10);
		root.left.right.right = new BinaryNode(14);

		return root;
	}
}