package trees;

import trees.nodes.BinaryNode;

public class ConstructTreeFromInorderAndLevelOrderTraversals {

	public static void main(String[] args) {
		int[] in = new int[] { 4, 8, 10, 12, 14, 20, 22 };
		int[] level = new int[] { 20, 8, 22, 4, 12, 10, 14 };

		BinaryNode root = constructTree(in, level);
		root.inorderPrint();
	}

	private static BinaryNode constructTree(int[] in, int[] level) {

		if (level.length == 0 || in.length == 0)
			return null;

		BinaryNode root = new BinaryNode(level[0]);

		int index = getIndexOfNodeInInorderList(in, root.value);
		int[] leftInorder = getLeftSideOfTree(in, index);
		int[] rightInorder = getRightSideOfTree(in, index + 1);
		int[] leftLevel = getLeftLevel(leftInorder, level);
		int[] rightLevel = getRightLevel(rightInorder, level);
		root.left = constructTree(leftInorder, leftLevel);
		root.right = constructTree(rightInorder, rightLevel);

		return root;
	}

	private static int getIndexOfNodeInInorderList(int[] in, int value) {
		for (int i = 0; i < in.length; i++)
			if (in[i] == value)
				return i;
		return -1;
	}

	private static int[] getLeftSideOfTree(int[] in, int index) {
		int[] left = new int[index];
		for (int i = 0; i < index; i++)
			left[i] = in[i];
		return left;
	}

	private static int[] getRightSideOfTree(int[] in, int index) {
		int[] right = new int[in.length - index];
		for (int i = index; i < in.length; i++)
			right[i - index] = in[i];
		return right;
	}

	private static int[] getLeftLevel(int[] leftInorder, int[] level) {
		int[] leftLevel = new int[leftInorder.length];
		int counter = 0;
		for (int i = 0; i < level.length; i++)
			if (arrayContainsElement(leftInorder, level[i]))
				leftLevel[counter++] = level[i];
		return leftLevel;
	}
	
	private static int[] getRightLevel(int[] rightInorder, int[] level) {
		int[] rightLevel = new int[rightInorder.length];
		int counter = 0;
		for (int i = 0; i < level.length; i++)
			if (arrayContainsElement(rightInorder, level[i]))
				rightLevel[counter++] = level[i];
		return rightLevel;
	}

	private static boolean arrayContainsElement(int[] arr, int el) {
		for (int i = 0; i < arr.length; i++)
			if (arr[i] == el)
				return true;
		return false;
	}

	private static String getStringFromArray(int[] arr) {
		String result = "";
		for (int i = 0; i < arr.length; i++)
			result += arr[i] + " ";
		return result;
	}
}
