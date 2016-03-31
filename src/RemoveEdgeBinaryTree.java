// http://www.geeksforgeeks.org/check-if-removing-an-edge-can-divide-a-binary-tree-in-two-halves/
public class RemoveEdgeBinaryTree {

	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(1);
		root.right = new Node(6);
		root.left.left = new Node(3);
		root.right.left = new Node(7);
		root.right.right = new Node(4);

		computeChildCount(root);
		boolean exists = checkForEdge(root.childCount, root);
		if (exists)
			System.out.println("YES");
		else {
			System.out.println("NO");
		}
	}

	public static boolean checkForEdge(int rootSize, Node n) {

		if (n == null)
			return false;

		if (rootSize - n.childCount == n.childCount) {
			return true;
		}

		return checkForEdge(rootSize, n.left) || checkForEdge(rootSize, n.right);
	}

	public static int computeChildCount(Node n) {
		if (n == null)
			return 0;
		n.childCount = 1 + computeChildCount(n.left) + computeChildCount(n.right);
		return n.childCount;
	}
}

class Node {
	int value;
	int childCount;
	Node left;
	Node right;

	public Node(int value) {
		this.value = value;
		childCount = 0;
	}
}