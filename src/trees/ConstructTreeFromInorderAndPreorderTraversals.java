package trees;

import java.util.LinkedList;
import java.util.Queue;

import trees.nodes.BinaryNode;

public class ConstructTreeFromInorderAndPreorderTraversals {

	public static void main(String[] args) {
		char[] inorder = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' };
		char[] preorder = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' };
		Queue<Character> preorderQ = new LinkedList<>();
		for (int i = 0; i < preorder.length; i++) 
			preorderQ.add(preorder[i]);
		
		BinaryNode root = constructTree(inorder, preorderQ);
		root.inorderPrint();
		System.out.println();
		root.preorderCharPrint();
	}

	private static BinaryNode constructTree(char[] inorder, Queue<Character> preorderQ) {
		
		if (preorderQ.isEmpty() || inorder.length == 0)
			return null;
		
		BinaryNode root = new BinaryNode(preorderQ.poll());
		
		
		System.out.println("looking for " + root.charValue + " in " + getStringFromChars(inorder));
		if (inorder.length == 0) return root;
		
		int index = getIndexOfChar(root.charValue, inorder);
		char[] leftInorder = getLeftSideInorder(inorder, index);
		char[] rightInorder = getRightSideInorder(inorder, index + 1);

		root.left = constructTree(leftInorder, preorderQ);
		root.right = constructTree(rightInorder, preorderQ);

		return root;
	}

	private static char[] getRightSideInorder(char[] inorder, int index) {
		char[] right = new char[inorder.length - index];

		for (int i = 0; i < right.length; i++)
			right[i] = inorder[i + index];

		return right;
	}

	private static char[] getLeftSideInorder(char[] inorder, int index) {
		char[] left = new char[index];

		for (int i = 0; i < index; i++)
			left[i] = inorder[i];

		return left;
	}

	private static int getIndexOfChar(char c, char[] arr) {
		for (int i = 0; i < arr.length; i++)
			if (arr[i] == c)
				return i;
		return -1;
	}

	private static String getStringFromChars(char[] arr) {
		String result = "";
		for (int i = 0; i < arr.length; i++)
			result += arr[i];
		return result;
	}
}