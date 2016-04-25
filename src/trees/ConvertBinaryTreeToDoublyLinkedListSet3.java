package trees;

import list.elements.DLinkedListElement;
import trees.nodes.BinaryNode;

public class ConvertBinaryTreeToDoublyLinkedListSet3 {
	
	public static void main(String[] args) {
		BinaryNode root = createTree();
		DLinkedListElement list = new DLinkedListElement(root.value);
		convertBinaryTreeToDoublyLinkedList(root, list);
		list.printList();
	}

	private static void convertBinaryTreeToDoublyLinkedList(BinaryNode root, DLinkedListElement list) {
		if (root == null) return;
		
		if (root.left != null) {
			DLinkedListElement newElement = new DLinkedListElement(root.left.value);
			list.addElementToLeft(newElement);
			convertBinaryTreeToDoublyLinkedList(root.left, newElement);
		}
		if (root.right != null) {
			DLinkedListElement newElement = new DLinkedListElement(root.right.value);
			list.addElementToRight(newElement);
			convertBinaryTreeToDoublyLinkedList(root.right, newElement);
		}		
	}

	private static BinaryNode createTree() {
		BinaryNode root = new BinaryNode(10);

		root.left = new BinaryNode(12);
		root.right = new BinaryNode(15);

		root.left.left = new BinaryNode(25);
		root.left.right = new BinaryNode(30);
		root.right.left = new BinaryNode(36);

		return root;
	}
}