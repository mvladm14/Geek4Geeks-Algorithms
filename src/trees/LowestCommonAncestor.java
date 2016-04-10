package trees;

import java.util.Stack;

import trees.nodes.TernaryNode;

// http://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-tree-set-2-using-parent-pointer/
public class LowestCommonAncestor {

	public static void main(String[] args) {
		TernaryNode root = createTree();
		TernaryNode n1 = root.left.left;
		TernaryNode n2 = root.left.right;

		findAncestors(root, new Stack<TernaryNode>());
		TernaryNode lca = LCA(n1, n2);

		System.out.println("LCA of " + n1.value + " and " + n2.value + " is: " + lca.value);
	}

	private static TernaryNode LCA(TernaryNode n1, TernaryNode n2) {
		while (!n1.ancestors.isEmpty()) {
			if (n2.ancestors.contains(n1.ancestors.peek())) {
				return n1.ancestors.peek();
			}
			n1.ancestors.pop();
		}
		return null;
	}

	private static void findAncestors(TernaryNode n, Stack<TernaryNode> ancestors) {
		if (n == null)
			return;
		n.ancestors.addAll(ancestors);
		Stack<TernaryNode> newAncestors = new Stack<TernaryNode>();
		newAncestors.addAll(n.ancestors);
		newAncestors.add(n);
		findAncestors(n.left, newAncestors);
		findAncestors(n.right, newAncestors);
	}

	private static TernaryNode createTree() {
		TernaryNode root = new TernaryNode(1);

		root.left = new TernaryNode(2);
		root.middle = new TernaryNode(3);
		root.right = new TernaryNode(4);

		root.left.left = new TernaryNode(5);
		root.left.right = new TernaryNode(6);
		root.right.left = new TernaryNode(8);
		root.right.right = new TernaryNode(9);

		return root;
	}
}