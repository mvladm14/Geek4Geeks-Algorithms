package trees;

import trees.nodes.BinaryNode;

// http://www.geeksforgeeks.org/sum-numbers-formed-root-leaf-paths/
public class SumOfAllTheNumbersThatAreFormedFromRootToLeafPaths {

	private static long sum;

	public static void main(String[] args) {
		BinaryNode root = createTree();
		computeSum(root, 0);
		System.out.println(sum);
	}

	private static void computeSum(BinaryNode n, int number) {

		if (n == null)
			return;

		int newNumber = number * 10 + n.value;

		if (n.isLeaf()) {
			sum += newNumber;
			return;
		}

		computeSum(n.left, newNumber);
		computeSum(n.right, newNumber);
	}

	private static BinaryNode createTree() {
		BinaryNode root = new BinaryNode(6);

		root.left = new BinaryNode(3);
		root.right = new BinaryNode(5);

		root.left.left = new BinaryNode(2);
		root.left.right = new BinaryNode(5);
		root.right.right = new BinaryNode(4);

		root.left.right.left = new BinaryNode(7);
		root.left.right.right = new BinaryNode(4);

		return root;
	}
}