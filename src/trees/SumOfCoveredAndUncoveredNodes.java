package trees;

public class SumOfCoveredAndUncoveredNodes {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(8);
	    root.left = new TreeNode(3);
	 
	    root.left.left = new TreeNode(1);
	    root.left.right = new TreeNode(6);
	    root.left.right.left = new TreeNode(4);
	    root.left.right.left.left = new TreeNode(30);
	    root.left.right.left.left.left = new TreeNode(2);
	    root.left.right.right = new TreeNode(7);
	 
	    root.right = new TreeNode(10);
	    root.right.right = new TreeNode(14);
	    root.right.right.left = new TreeNode(13);
	    
	    System.out.println(checkSum(root) ? "Equal" : "Not equal");
	}
	
	private static boolean checkSum(TreeNode n) {
		int uncovered = computeLeftMostPath(n) + computeRightMostPath(n) - n.value;
		int covered = computeCoveredNodes(n);
		return uncovered == covered;
	}

	private static int computeLeftMostPath(TreeNode n) {
		if (n == null) return 0;
		n.visited = true;
		if (n.left == null)
			return n.value + computeLeftMostPath(n.right);
		return n.value + computeLeftMostPath(n.left);
	}
	
	private static int computeRightMostPath(TreeNode n) {
		if (n == null) return 0;
		n.visited = true;
		if (n.right == null)
			return n.value + computeLeftMostPath(n.left);
		return n.value + computeLeftMostPath(n.right);
	}
	
	private static int computeCoveredNodes(TreeNode n) {
		if (n == null) return 0;
		int value = n.visited ? 0 : n.value;
		return value + computeCoveredNodes(n.left) + computeCoveredNodes(n.right);
	}
}

class TreeNode {
	int value;
	boolean visited;
	TreeNode left;
	TreeNode right;

	public TreeNode(int value) {
		this.value = value;
	}
}
