package trees;

import java.util.LinkedList;
import java.util.Queue;

import trees.nodes.BinaryNode;

public class PerfectBinaryTreeSpecificLevelOrderTraversal {

	public static void main(String[] args) {
		BinaryNode root = createTree();
		doSpecificicLevelOrderTraversal(root);
	}

	private static void doSpecificicLevelOrderTraversal(BinaryNode node) {
		if (node == null) {
            return;
        }
 
        // Let us print root and next level first
        System.out.print(node.value);
 
        //  Since it is perfect Binary Tree, right is not checked
        if (node.left != null) {
            System.out.print(" " + node.left.value + " " + node.right.value);
        }
 
        // Do anything more if there are nodes at next level in
        // given perfect Binary Tree
        if (node.left.left == null) {
            return;
        }
 
        // Create a queue and enqueue left and right children of root
        Queue<BinaryNode> q = new LinkedList<BinaryNode>();
        q.add(node.left);
        q.add(node.right);
 
        // We process two nodes at a time, so we need two variables
        // to store two front items of queue
        BinaryNode first = null, second = null;
 
        // traversal loop
        while (!q.isEmpty()) {
            // Pop two items from queue
            first = q.peek();
            q.remove();
            second = q.peek();
            q.remove();
 
            // Print children of first and second in reverse order
            System.out.print(" " + first.left.value + " " + second.right.value);
            System.out.print(" " + first.right.value + " " + second.left.value);
 
            // If first and second have grandchildren, enqueue them
            // in reverse order
            if (first.left.left != null) {
                q.add(first.left);
                q.add(second.right);
                q.add(first.right);
                q.add(second.left);
            }
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

		 root.left.left.left = new BinaryNode(8);
		 root.left.left.right = new BinaryNode(9);
		 root.left.right.left = new BinaryNode(10);
		 root.left.right.right = new BinaryNode(11);
		 root.right.left.left = new BinaryNode(12);
		 root.right.left.right = new BinaryNode(13);
		 root.right.right.left = new BinaryNode(14);
		 root.right.right.right = new BinaryNode(15);

		return root;
	}
}