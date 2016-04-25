package trees;

import trees.nodes.BinaryNode;

// http://www.geeksforgeeks.org/connect-leaves-doubly-linked-list/
public class ExtractLeavesfOfABinaryTreeInADoublyLinkedList {

	private static BinaryNode dLList;

	public static void main(String[] args) {
		BinaryNode root = createTree();
		createDLListFromTree(root);
		
		root.inorderPrint();
		System.out.println();
		printDLLIst();
	}

	private static void createDLListFromTree(BinaryNode n) {

		if (n == null)
			return;

		if (n.left != null && n.left.isLeaf()) {
			constructDLList(n.left);
			n.left = null;
		}
		if (n.right != null && n.right.isLeaf()) {
			constructDLList(n.right);
			n.right = null;
		}

		createDLListFromTree(n.left);
		createDLListFromTree(n.right);
	}

	private static void constructDLList(BinaryNode n) {
		if (dLList == null)
			dLList = new BinaryNode(n.value);
		else
			addToDLList(n);
	}

	private static void printDLLIst() {
		BinaryNode current = dLList;
		while (current.right != null) {
			System.out.print(current.value + " ");
			current = current.right;
		}
		System.out.print(current.value);
		System.out.println();
		while (current.left != null) {
			System.out.print(current.value + " ");
			current = current.left;
		}
		System.out.print(current.value);
	}

	private static void addToDLList(BinaryNode n) {
		BinaryNode newNode = new BinaryNode(n.value);
		BinaryNode current = dLList;
		while (current.right != null)
			current = current.right;
		current.right = newNode;
		newNode.left = current;
	}

	private static BinaryNode createTree() {
		BinaryNode root = new BinaryNode(1);

		root.left = new BinaryNode(2);
		root.right = new BinaryNode(3);

		root.left.left = new BinaryNode(4);
		root.left.right = new BinaryNode(5);
		root.right.right = new BinaryNode(6);

		root.left.left.left = new BinaryNode(7);
		root.left.left.right = new BinaryNode(8);
		root.right.right.left = new BinaryNode(9);
		root.right.right.right = new BinaryNode(10);

		return root;
	}
}