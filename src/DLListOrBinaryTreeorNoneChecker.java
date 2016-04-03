// Checks whether a given structure is binary tree,
// a double linked list or none of these
public class DLListOrBinaryTreeorNoneChecker {

	public static void main(String[] args) {

		System.out.println(detectStructure(createNone()));
		System.out.println(detectStructure(createDLList()));
		System.out.println(detectStructure(createBinaryTree()));
	}	

	private static String detectStructure(Node n) {

		boolean cycleExists = checkForCycle(n, n);

		boolean isDLList = !cycleExists && checkIsDLList(n);
		boolean isTree = !cycleExists && checkIsTree(n);

		return isTree || isDLList ? (isTree == true ? "Tree" : "DLList") : "None";
	}

	private static boolean checkIsTree(Node n) {

		if (n == null)
			return true;

		if (n.visited)
			return false;

		n.visited = true;

		return checkIsTree(n.left) && checkIsTree(n.right);
	}

	private static boolean checkIsDLList(Node n) {
		if (n == null)
			return true;

		if (n.left != null && n.left.right != n)
			return false;
		if (n.right != null && n.right.left != n)
			return false;

		return checkIsDLList(n.right);
	}

	private static boolean checkForCycle(Node tortoise, Node hare) {

		if (hare.right == null || hare.right.right == null)
			return false;

		hare = hare.right.right;
		tortoise = tortoise.right;

		if (tortoise == hare)
			return true;
		return checkForCycle(tortoise, hare);
	}

	private static Node createBinaryTree() {
		Node root = new DLListOrBinaryTreeorNoneChecker().new Node(1);
		root.left = new DLListOrBinaryTreeorNoneChecker().new Node(2);
		root.right = new DLListOrBinaryTreeorNoneChecker().new Node(3);
		root.right.left = new DLListOrBinaryTreeorNoneChecker().new Node(6);
		root.left.left = new DLListOrBinaryTreeorNoneChecker().new Node(4);
		root.left.right = new DLListOrBinaryTreeorNoneChecker().new Node(5);
		root.left.right.right = new DLListOrBinaryTreeorNoneChecker().new Node(7);
		return root;
	}

	private static Node createDLList() {
		Node root = new DLListOrBinaryTreeorNoneChecker().new Node(1);
		root.right = new DLListOrBinaryTreeorNoneChecker().new Node(2);
		root.right.left = root;
		root.right.right = new DLListOrBinaryTreeorNoneChecker().new Node(3);
		root.right.right.left = root.right;
		root.right.right.right = new DLListOrBinaryTreeorNoneChecker().new Node(4);
		root.right.right.right.left = root.right.right;
		root.right.right.right.right = new DLListOrBinaryTreeorNoneChecker().new Node(5);
		root.right.right.right.right.left = root.right.right.right;
		root.right.right.right.right.right = new DLListOrBinaryTreeorNoneChecker().new Node(6);
		root.right.right.right.right.right.left = root.right.right.right.right;
		root.right.right.right.right.right.right = new DLListOrBinaryTreeorNoneChecker().new Node(7);
		root.right.right.right.right.right.right.left = root.right.right.right.right.right;
		root.right.right.right.right.right.right.right = new DLListOrBinaryTreeorNoneChecker().new Node(8);
		root.right.right.right.right.right.right.right.left = root.right.right.right.right.right.right;

		return root;
	}

	private static Node createNone() {
		Node root = createBinaryTree();
		root.left.right.right.left = root; // introduce cycle	
		return root;
	}
	
	private class Node {
		int value;
		boolean visited;
		Node left, right;

		public Node(int value) {
			this.value = value;
		}
	}
}