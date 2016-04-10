package trees;

import java.util.Stack;

public class CheckIfLeafTraversalOfTwoBinaryTreesIsSame {

	public static void main(String[] args) {
		Node root1 = createTree1();
		Node root2 = createTree2();
		
		Stack<Integer> leaves1 = new Stack<>();
		Stack<Integer> leaves2 = new Stack<>();
		
		computeLeaves(root1, leaves1);
		computeLeaves(root2, leaves2);
		
		System.out.println(compareLeaves(leaves1, leaves2) ? "same" : "different");		
	}
	
	private static boolean compareLeaves(Stack<Integer> leaves1, Stack<Integer> leaves2) {
		if (leaves1.size() != leaves2.size()) return false;
		while (!leaves1.empty() && leaves2.empty()) {
			if (leaves1.pop() != leaves2.pop()) {
				return false;
			}
		}
		return true;
		
	}

	private static void computeLeaves(Node n, Stack<Integer> leaves) {
		if (n == null) return;
		if (n.right == null && n.left == null) leaves.push(n.value);
		computeLeaves(n.left, leaves);
		computeLeaves(n.right, leaves);
	}

	private static Node createTree1() {
		Node root1 = new CheckIfLeafTraversalOfTwoBinaryTreesIsSame().new Node(1);
		root1.left = new CheckIfLeafTraversalOfTwoBinaryTreesIsSame().new Node(2);
		root1.right = new CheckIfLeafTraversalOfTwoBinaryTreesIsSame().new Node(3);
		root1.left.left = new CheckIfLeafTraversalOfTwoBinaryTreesIsSame().new Node(4);
		root1.right.left = new CheckIfLeafTraversalOfTwoBinaryTreesIsSame().new Node(6);
		root1.right.right = new CheckIfLeafTraversalOfTwoBinaryTreesIsSame().new Node(7);
		return root1;
	}
	
	private static Node createTree2() {
		Node root2 = new CheckIfLeafTraversalOfTwoBinaryTreesIsSame().new Node(0);
		root2.left = new CheckIfLeafTraversalOfTwoBinaryTreesIsSame().new Node(1);
		root2.right = new CheckIfLeafTraversalOfTwoBinaryTreesIsSame().new Node(5);
		root2.left.right = new CheckIfLeafTraversalOfTwoBinaryTreesIsSame().new Node(4);
		root2.right.left = new CheckIfLeafTraversalOfTwoBinaryTreesIsSame().new Node(6);
		root2.right.right = new CheckIfLeafTraversalOfTwoBinaryTreesIsSame().new Node(7);
		return root2;
	}

	private class Node {
		int value;
		Node left, right;

		public Node(int value) {
			this.value = value;
		}
	}
}