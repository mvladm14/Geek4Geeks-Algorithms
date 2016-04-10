package trees;

import java.util.Vector;

// http://www.geeksforgeeks.org/find-all-possible-trees-with-given-inorder-traversal/
public class FindAllPossibleBinTreesWithGivenInorderTraversal {

	public static void main(String[] args) {
		int in[] = { 4, 5, 7 };
		int n = in.length;
		Vector<Node> trees = getTrees(in, 0, n - 1);
		System.out.println("Preorder traversal of different " + " binary trees are:");
		for (int i = 0; i < trees.size(); i++) {
			printPreoder(trees.get(i));
			System.out.println("");
		}
	}

	private static Vector<Node> getTrees(int arr[], int start, int end) {

		Vector<Node> trees = new Vector<>();

		/*
		 * if start > end then subtree will be empty so returning NULL in the
		 * list
		 */
		if (start > end) {
			trees.add(null);
			return trees;
		}

		for (int i = start; i <= end; i++) {

			Vector<Node> left = getTrees(arr, start, i - 1);
			Vector<Node> right = getTrees(arr, i + 1, end);

			for (int j = 0; j < left.size(); j++) {
				for (int k = 0; k < right.size(); k++) {

					// Making arr[i] as root
					Node node = new FindAllPossibleBinTreesWithGivenInorderTraversal().new Node(arr[i]);

					// Connecting left subtree
					node.left = left.get(j);

					// Connecting right subtree
					node.right = right.get(k);

					// Adding this tree to list
					trees.add(node);
				}
			}
		}

		return trees;
	}

	private static void printPreoder(Node n) {
		if (n == null)
			return;
		System.out.println(n.value);
		printPreoder(n.left);
		printPreoder(n.right);
	}

	private class Node {
		int value;
		Node left, right;

		public Node(int value) {
			this.value = value;
		}
	}
}
