package trees;

import java.util.HashMap;
import java.util.Map;

import trees.nodes.BinaryNode;

// http://www.geeksforgeeks.org/construct-a-binary-tree-from-parent-array-representation/
public class ConstructBinaryTreeFromParentArray {

	public static void main(String[] args) {
		int[] parent = { 1, 5, 5, 2, 2, -1, 3 };
		BinaryNode root = createTree(parent);
		printPreorder(root);
	}

	private static BinaryNode createTree(int[] parent) {

		Map<Integer, BinaryNode> nodes = new HashMap<>(parent.length);
		BinaryNode root = null;

		for (int i = 0; i < parent.length; i++) {
			BinaryNode node = nodes.get(i) == null ? new BinaryNode(i) : nodes.get(i);
			BinaryNode parentNode = nodes.get(parent[i]) == null ? new BinaryNode(parent[i]) : nodes.get(parent[i]);
			if (parent[i] == -1) {
				root = node;
			}
			if (parentNode.left == null)
				parentNode.left = node;
			else
				parentNode.right = node;
			
			nodes.put(i, node);
			nodes.put(parent[i], parentNode);
		}

		return root;
	}
	
	private static void printPreorder(BinaryNode n) {
		if (n == null) return;
		System.out.println(n.value);
		printPreorder(n.left);
		printPreorder(n.right);
	}
}