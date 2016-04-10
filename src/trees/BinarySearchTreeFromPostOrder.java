package trees;

//http://www.geeksforgeeks.org/construct-a-binary-search-tree-from-given-postorder/
public class BinarySearchTreeFromPostOrder {

	public static void main(String[] args) {
		int[] numbers = { 1, 7, 5, 50, 40, 10 };
		
		BinarySearchTreeFromPostOrder.Node root = createBST(numbers);
		printPostOrder(root);
	}

	private static Node createBST(int[] numbers) {
		if (numbers.length == 0) return null;
		
		BinarySearchTreeFromPostOrder.Node root = new BinarySearchTreeFromPostOrder().new Node(numbers[numbers.length - 1]);
		int lastSmallerElementIndex = getIndexForLastElementSmallerThanRoot(numbers, root.value);
		int[] left = getSmallerElements(numbers, lastSmallerElementIndex);
		root.left = createBST(left);		
		
		int firstBiggerElementIndex = getIndexForFirstElementBiggerThanRoot(numbers, root.value);
		int[] right = getRightSideOfArray(numbers, firstBiggerElementIndex);
		root.right= createBST(right);
		return root;
	}	

	private static int[] getSmallerElements(int[] numbers, int index) {
		int[] left = new int[index + 1];
		for (int i = 0; i <= index; i++) {
			left[i] = numbers[i];
		}
		return left;
	}

	private static int[] getRightSideOfArray(int[] numbers, int index) {
		int[] right = new int[numbers.length - index - 1];
		for (int i = 0; i < right.length; i++) {
			right[i] = numbers[i + index];
		}
		return right;
	}

	private static int getIndexForFirstElementBiggerThanRoot(int[] numbers, int rootValue) {
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] > rootValue) {
				return i;
			}
		}
		return 0;
	}

	private static int getIndexForLastElementSmallerThanRoot(int[] numbers, int rootValue) {
		int lastSmallerElementIndex = -1;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] < rootValue) {
				lastSmallerElementIndex = i;
			}
		}
		return lastSmallerElementIndex;
	}

	private static void printPostOrder(Node n) {
		if (n == null)
			return;
		printPostOrder(n.left);
		printPostOrder(n.right);
		System.out.println(n.value);
	}

	private class Node {
		int value;
		Node left, right;

		public Node(int value) {
			this.value = value;
		}
	}
}