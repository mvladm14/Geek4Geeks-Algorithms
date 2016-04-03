import java.util.ArrayList;
import java.util.List;

// http://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-tree-set-2-using-parent-pointer/
public class LowestCommonAncestor {

	public static void main(String[] args) {
		LcaNode root = new LowestCommonAncestor().new LcaNode(20);
		root.left = new LowestCommonAncestor().new LcaNode(8);
		root.right = new LowestCommonAncestor().new LcaNode(22);
		root.left.left = new LowestCommonAncestor().new LcaNode(4);
		root.left.right = new LowestCommonAncestor().new LcaNode(12);
		root.left.right.left = new LowestCommonAncestor().new LcaNode(10);
		root.left.right.right = new LowestCommonAncestor().new LcaNode(14);

		LcaNode n1 = root.left.left;
		LcaNode n2 = root.left.right.left;

		findAncestors(root, new ArrayList<LcaNode>());
		LcaNode lca = LCA(n1, n2);

		System.out.println("LCA of " + n1.value + " and " + n2.value + " is: " + lca.value);
	}

	private static LcaNode LCA(LcaNode n1, LcaNode n2) {
		LcaNode smallestParent = null;
		for (LcaNode parent : n1.ancestors) {
			if (n2.ancestors.contains(parent)) {
				smallestParent = parent;
			}
		}
		return smallestParent;
	}

	private static void findAncestors(LcaNode n, List<LcaNode> ancestors) {
		if (n == null)
			return;
		n.ancestors.addAll(ancestors);
		List<LcaNode> newAncestors = new ArrayList<>(n.ancestors);
		newAncestors.add(n);
		findAncestors(n.left, newAncestors);
		findAncestors(n.right, newAncestors);
	}

	private class LcaNode {
		int value;
		LcaNode left, right;

		// TODO change this with queue so that we don't need to reverse when it
		// when looking for smallest parent
		List<LcaNode> ancestors;

		public LcaNode(int value) {
			this.value = value;
			ancestors = new ArrayList<LcaNode>();
		}
	}

}
