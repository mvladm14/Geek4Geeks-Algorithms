package trees;

public class FindHeightOfBinaryTreeRepresentedByParentArray {

	private static int[] depth;

	public static void main(String[] args) {

		int[] parent = { 1, 5, 5, 2, 2, -1, 3 };
		depth = new int[parent.length];

		for (int i = 0; i < parent.length; i++)
			depth[i] = computeDepth(parent, i);

		int max = 0;
		for (int i = 0; i < depth.length; i++)
			if (max < depth[i])
				max = depth[i];

		System.out.println(max);
	}

	private static int computeDepth(int[] parent, int nodeIndex) {

		if (parent[nodeIndex] == -1)
			return 1;
		if (depth[parent[nodeIndex]] != 0)
			return 1 + depth[parent[nodeIndex]];
		return 1 + computeDepth(parent, parent[nodeIndex]);
	}
}