package trees;

public class CheckIfArrayCanRepresentPreorderTraversalOfBST {

	public static void main(String[] args) {
		int[] arr = { 40, 30, 35, 20, 80, 100 };
		
		boolean result = checkIfArrayCanBePreorderTraversalOfBST(arr, 0, arr.length - 1);
		
		System.out.println(result == true? "true" : "false");
	}

	private static boolean checkIfArrayCanBePreorderTraversalOfBST(int[] arr, int start, int end) {

		if (start >= end) return true;
		
		int j = indexOfFirstGreaterElement(arr, start, end);

		// check that all elements after j are greater than i
		boolean condition1 = checkAllElementsAfterJareGreaterThanFirstElement(arr, j, start, end);

		// check for array from i + 1 to j - 1 and j + 1 to n - 1
		boolean condition2 = checkIfArrayCanBePreorderTraversalOfBST(arr, start + 1, j - 1)
				&& checkIfArrayCanBePreorderTraversalOfBST(arr, j + 1, end);

		return condition1 && condition2;
	}

	private static int indexOfFirstGreaterElement(int[] arr, int start, int end) {
		for (int index = start; index <= end; index++) {
			if (arr[index] > arr[start])
				return index;
		}
		return -1;
	}

	private static boolean checkAllElementsAfterJareGreaterThanFirstElement(int[] arr, int j, int start, int end) {
		for (int index = j + 1; index <= end; index++) {
			if (arr[start] > arr[index])
				return false;
		}
		return true;
	}
}