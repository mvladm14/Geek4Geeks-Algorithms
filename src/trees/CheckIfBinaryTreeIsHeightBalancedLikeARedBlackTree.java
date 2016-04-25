package trees;

import trees.nodes.BinaryNode;

public class CheckIfBinaryTreeIsHeightBalancedLikeARedBlackTree {

	private class ResultHolder {
		int minH;
		int maxH;
		boolean isRBT;

		public ResultHolder(int minH, int maxH, boolean isRBT) {
			this.minH = minH;
			this.maxH = maxH;
			this.isRBT = isRBT;
		}
	}

	public static void main(String[] args) {
		BinaryNode root1 = createTree1();
		BinaryNode root2 = createTree2();
		BinaryNode root3 = createTree3();

		ResultHolder rh1 = checkRBTCondition(root1);
		System.out.println(rh1.isRBT ? "yes" : "no");
		ResultHolder rh2 = checkRBTCondition(root2);
		System.out.println(rh2.isRBT ? "yes" : "no");
		ResultHolder rh3 = checkRBTCondition(root3);
		System.out.println(rh3.isRBT ? "yes" : "no");
	}

	private static ResultHolder checkRBTCondition(BinaryNode n) {

		if (n == null)
			return null;
		if (n.isLeaf())
			return new CheckIfBinaryTreeIsHeightBalancedLikeARedBlackTree().new ResultHolder(1, 1, true);

		ResultHolder left = checkRBTCondition(n.left);
		ResultHolder right = checkRBTCondition(n.right);
		int min = 0, max = 0;
		boolean isRBT = false;

		if (left == null || right == null) {
			if (left == null) {
				min = 1;
				max = right.maxH + 1;
				isRBT = right.isRBT && max <= 2 * min;
			}
			if (right == null) {
				min = 1;
				max = left.maxH + 1;
				isRBT = left.isRBT && max <= 2 * min;
			}
		} else {
			min = Math.min(left.minH, right.minH) + 1;
			max = Math.max(left.maxH, right.maxH) + 1;
			isRBT = left.isRBT && right.isRBT && max <= 2 * min;
		}
		return new CheckIfBinaryTreeIsHeightBalancedLikeARedBlackTree().new ResultHolder(min, max, isRBT);
	}

	private static BinaryNode createTree1() {
		BinaryNode root = new BinaryNode(12);
		root.right = new BinaryNode(14);
		root.right.right = new BinaryNode(16);
		return root;
	}

	private static BinaryNode createTree2() {
		BinaryNode root = new BinaryNode(40);

		root.left = new BinaryNode(10);
		root.right = new BinaryNode(100);

		root.right.left = new BinaryNode(60);
		root.right.right = new BinaryNode(150);

		return root;
	}

	private static BinaryNode createTree3() {
		BinaryNode root = new BinaryNode(10);

		root.left = new BinaryNode(5);
		root.right = new BinaryNode(100);

		root.right.left = new BinaryNode(50);
		root.right.right = new BinaryNode(150);

		root.right.left.left = new BinaryNode(40);

		return root;
	}
}