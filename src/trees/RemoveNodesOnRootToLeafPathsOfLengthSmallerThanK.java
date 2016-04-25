package trees;

import trees.nodes.BinaryNode;

public class RemoveNodesOnRootToLeafPathsOfLengthSmallerThanK {

	public static void main(String[] args) {
		
		BinaryNode root = createTree();
		
		int pathLength = 4;
		BinaryNode newTree = removeNodes(root, 1, pathLength);
		newTree.preorderPrint();
	}
	
	private static BinaryNode removeNodes(BinaryNode n, int level, int pathLength) {

		if (n == null) return null;
		
		n.left = removeNodes(n.left, level + 1, pathLength);
		n.right = removeNodes(n.right, level + 1, pathLength);
		
		if (n.left == null && n.right == null && level < pathLength) 
			return null;
		return n;
	}

	private static BinaryNode createTree() {

		BinaryNode root = new BinaryNode(1);

		root.left = new BinaryNode(2);
		root.right = new BinaryNode(3);

		root.left.left = new BinaryNode(4);
		root.left.right = new BinaryNode(5);
		root.right.right = new BinaryNode(6);
		
		root.left.left.left = new BinaryNode(7);
		root.right.right.left = new BinaryNode(8);
		
		return root;
	}
}