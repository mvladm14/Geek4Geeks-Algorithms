package trees;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import trees.nodes.BinaryNode;

public class PrintBinaryTreeInVerticalOrder {

	private static Map<Integer, List<BinaryNode>> nodes;
	
	public static void main(String[] args) {
		BinaryNode root = createTree();
		nodes = new HashMap<>();
		fillInArray(root, 5);
		printArray();
	}

	private static void fillInArray(BinaryNode root, int index) {
		if (root == null) return;
		
		if (nodes.get(index) == null)
			nodes.put(index, new ArrayList<BinaryNode>());
		nodes.get(index).add(root);
		fillInArray(root.left, index - 1);
		fillInArray(root.right, index + 1);
	}
	
	private static void printArray() {
		for (Entry<Integer, List<BinaryNode>> node : nodes.entrySet()) {
			for (BinaryNode n : node.getValue()) 
				System.out.print(n.value + " ");
			System.out.println();
		}		
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
		root.right.right.right = new BinaryNode(9);
		
		return root;		
	}
}