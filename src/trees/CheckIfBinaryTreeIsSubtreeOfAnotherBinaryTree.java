package trees;

import trees.nodes.BinaryNode;

public class CheckIfBinaryTreeIsSubtreeOfAnotherBinaryTree {

	public static void main(String[] args) {
		BinaryNode x = createTree2();
		BinaryNode y = createTree1();

		System.out.println(isSubTree(x, y) ? "yes" : "no");
	}

	private static boolean isSubTree(BinaryNode x, BinaryNode y) {
		Passing p = new CheckIfBinaryTreeIsSubtreeOfAnotherBinaryTree().new Passing();
		
		char[] s1x = new char[100];
		p.i = 0;
		inorder(x, s1x, p);
		s1x[p.i] = '\0';
		String xInorder = getStringFromChars(s1x);

		char[] s1y = new char[100];
		p.i = 0;
		inorder(y, s1y, p);
		s1x[p.i] = '\0';		
		String yInorder = getStringFromChars(s1y);

		char[] s2x = new char[100];
		p.i = 0;
		preorder(x, s2x, p);
		s2x[p.i] = '\0';
		String xPreorder = getStringFromChars(s2x);

		char[] s2y = new char[100];
		p.i = 0;
		preorder(y, s2y, p);
		s2y[p.i] = '\0';
		String yPreorder = getStringFromChars(s2y);

		return (xInorder.contains(yInorder) || yInorder.contains(xInorder))
				&& (xPreorder.contains(yPreorder) || yPreorder.contains(xPreorder));
	}

	private static String getStringFromChars(char[] arr) {
		String result = "";
		int i = 0;
		while (arr[i] != '\0')
			result += arr[i++];
		return result;
	}

	private static void inorder(BinaryNode x, char[] s, Passing p) {
		if (x == null)
			return;
		inorder(x.left, s, p);
		s[p.i++] = x.charValue;
		inorder(x.right, s, p);
	}

	private static void preorder(BinaryNode x, char[] s, Passing p) {
		if (x == null)
			return;
		s[p.i++] = x.charValue;
		preorder(x.left, s, p);
		preorder(x.right, s, p);
	}

	private static BinaryNode createTree2() {
		BinaryNode root = new BinaryNode('z');

		root.left = createTree1();
		root.right = new BinaryNode('e');

		root.right.right = new BinaryNode('k');

		return root;
	}

	private static BinaryNode createTree1() {

		BinaryNode root = new BinaryNode('x');

		root.left = new BinaryNode('a');
		root.right = new BinaryNode('b');

		root.left.right = new BinaryNode('c');

		return root;
	}

	private class Passing {
		int i;
	}
}