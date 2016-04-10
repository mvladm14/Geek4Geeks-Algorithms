package trees;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

// http://www.geeksforgeeks.org/find-multiplication-of-sums-of-data-of-all-leaves-at-sane-levels/
public class MultiplicationOfSumsOfDataOfLeavesAtSameLevels {
	
	private static Map<Integer, Integer> sumPerLevel;

	public static void main(String[] args) {
		
		sumPerLevel = new HashMap<>();
		Node root = createTree();
		
		computeSums(root, 0);

		System.out.println(computeMultiplicationOfSum(sumPerLevel));		
	}
	
	private static int computeMultiplicationOfSum(Map<Integer, Integer> sumPerLevel2) {
		int total = 1;
		for (Entry<Integer, Integer> entry : sumPerLevel2.entrySet()) {
			total *= entry.getValue();
		}
		return total;		
	}

	private static void computeSums(Node n, int level) {
		if (n == null) return;
		if (isLeaf(n)) {
			int currentValue = sumPerLevel.get(level) == null ? 0 : sumPerLevel.get(level);
			sumPerLevel.put(level, currentValue + n.value);
		}
		computeSums(n.left, level + 1);
		computeSums(n.right, level + 1);
	}
	
	private static boolean isLeaf(Node n) {
		return n.left == null && n.right == null;
	}

	private static Node createTree() {
		Node root = new MultiplicationOfSumsOfDataOfLeavesAtSameLevels().new Node(2);
		root.left = new MultiplicationOfSumsOfDataOfLeavesAtSameLevels().new Node(7);
		root.right = new MultiplicationOfSumsOfDataOfLeavesAtSameLevels().new Node(5);
		
		root.left.left = new MultiplicationOfSumsOfDataOfLeavesAtSameLevels().new Node(8);
		root.left.right = new MultiplicationOfSumsOfDataOfLeavesAtSameLevels().new Node(6);
		root.right.right = new MultiplicationOfSumsOfDataOfLeavesAtSameLevels().new Node(9);
		
		root.left.right.left = new MultiplicationOfSumsOfDataOfLeavesAtSameLevels().new Node(1);
		root.left.right.right = new MultiplicationOfSumsOfDataOfLeavesAtSameLevels().new Node(11);
		root.right.right.left = new MultiplicationOfSumsOfDataOfLeavesAtSameLevels().new Node(4);
		root.right.right.right = new MultiplicationOfSumsOfDataOfLeavesAtSameLevels().new Node(10);
		
		return root;
	}
	
	private class Node {
		int value;
		Node left, right;
		
		public Node(int value) {
			this.value = value;
		}
	}
}