package trees;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import trees.nodes.BinaryNode;

public class PrintAllNodesThatAreAtDistanceKFromALeafNode {

	public static void main(String[] args) {
		BinaryNode root = createTree();
		int distance = 2;
		Map<Integer, Set<BinaryNode>> map = new HashMap<>();

		populateMapWithNodesPerDistance(root, map);

		Set<BinaryNode> nodesAtDistance = map.get(distance);

		for (BinaryNode bn : nodesAtDistance) {
			System.out.print(bn.value + " ");
		}
	}

	private static Set<Integer> populateMapWithNodesPerDistance(BinaryNode n, Map<Integer, Set<BinaryNode>> map) {
		if (n == null)
			return null;

		if (n.isLeaf()) {
			if (map.get(0) == null)
				map.put(0, new HashSet<BinaryNode>());
			map.get(0).add(n);
			HashSet<Integer> set = new HashSet<>();
			set.add(0);
			return set;
		}

		Set<Integer> left = populateMapWithNodesPerDistance(n.left, map);
		Set<Integer> right = populateMapWithNodesPerDistance(n.right, map);
		Set<Integer> finalValues = new HashSet<>();

		if (left != null)
			for (Integer integer : left)
				finalValues.add(integer + 1);

		if (right != null)
			for (Integer integer : right)
				finalValues.add(integer + 1);

		if (finalValues.size() > 0)
			for (Integer integer : finalValues) {
				if (map.get(integer) == null)
					map.put(integer, new HashSet<BinaryNode>());
				map.get(integer).add(n);
			}

		return finalValues;
	}

	private static BinaryNode createTree() {
		BinaryNode root = new BinaryNode(1);

		root.left = new BinaryNode(2);
		root.right = new BinaryNode(3);

		root.left.left = new BinaryNode(4);
		root.left.right = new BinaryNode(5);
		root.right.left = new BinaryNode(6);
		root.right.right = new BinaryNode(7);

		root.right.left.right = new BinaryNode(8);

		return root;
	}

}