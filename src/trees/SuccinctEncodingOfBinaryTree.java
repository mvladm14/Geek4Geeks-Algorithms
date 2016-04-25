package trees;

import java.util.LinkedList;
import java.util.Queue;

import trees.nodes.BinaryNode;

public class SuccinctEncodingOfBinaryTree {

	private static Queue<Integer> bits;
	private static Queue<Integer> values;

	public static void main(String[] args) {
		bits = new LinkedList<>();
		values = new LinkedList<>();
		BinaryNode root = createTree();
		EncodeTree(root);
		printEncodedData(new LinkedList<>(bits));
		printDecodedData(new LinkedList<>(bits), new LinkedList<>(values));
	}

	private static void EncodeTree(BinaryNode n) {

		if (n == null)
			bits.add(0);
		else {
			bits.add(1);
			values.add(n.value);
			EncodeTree(n.left);
			EncodeTree(n.right);
		}
	}

	private static BinaryNode createTree() {
		BinaryNode root = new BinaryNode(10);

		root.left = new BinaryNode(20);
		root.right = new BinaryNode(30);

		root.left.left = new BinaryNode(40);
		root.left.right = new BinaryNode(50);
		root.right.right = new BinaryNode(70);

		return root;
	}

	private static void printTree(BinaryNode node) {
		if (node == null)
			return;
		System.out.println(node.value);
		printTree(node.left);
		printTree(node.right);
	}	

	private static void printEncodedData(Queue<Integer> bits) {
		String result = "";
		while (!bits.isEmpty()) {
			result = result + bits.poll();
		}
		System.out.println(result);
	}
	
	private static void printDecodedData(Queue<Integer> bits, Queue<Integer> values) {
		String result = "";
		while (!bits.isEmpty()) {
			if (bits.poll() == 1) {
				result += values.poll() + " ";
			}
		}
		System.out.println(result);
	}
}