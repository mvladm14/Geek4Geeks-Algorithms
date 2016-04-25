package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import trees.nodes.BinaryNode;

//TODO not done
// http://www.geeksforgeeks.org/reverse-alternate-levels-binary-tree/
public class ReverseAlternateLevelsOfPerfectBinaryTree {

	private static Map<Integer, List<BinaryNode>> nodes;
	
	public static void main(String[] args) {
		BinaryNode root = createTree();
		root.inorderPrint();
		nodes = new HashMap<>();
		
		reverseAlternateTreeLevels(root);
		root.inorderPrint();
	}
	
	private static void reverseAlternateTreeLevels(BinaryNode root) {
		reverseAlternateLevels(root, 0);
	}

	private static void reverseAlternateLevels(BinaryNode n, int level) {
		if (n == null) return;
		
		reverseAlternateLevels(n.left, level + 1);
		reverseAlternateLevels(n.right, level + 1);
		
		if (level % 2 == 1) {
			if (nodes.get(level) == null) 
				nodes.put(level, new ArrayList<BinaryNode>());
			nodes.get(level).add(n);
		}
	}

	private static BinaryNode createTree() {
		BinaryNode root = new BinaryNode('a');
		
		root.left = new BinaryNode('b');
		root.right = new BinaryNode('c');
		
		root.left.left = new BinaryNode('d');
		root.left.right = new BinaryNode('e');
		root.right.left = new BinaryNode('f');
		root.right.right = new BinaryNode('g');
		
		root.left.left.left = new BinaryNode('h');
		root.left.left.right = new BinaryNode('i');
		root.left.right.left = new BinaryNode('j');
		root.left.right.right = new BinaryNode('k');
		root.right.left.left = new BinaryNode('l');
		root.right.left.right = new BinaryNode('m');
		root.right.right.left = new BinaryNode('n');
		root.right.right.right = new BinaryNode('o');
		
		return root;
	}
}