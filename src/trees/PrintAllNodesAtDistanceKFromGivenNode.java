package trees;

import trees.nodes.BinaryNode;

// http://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/
public class PrintAllNodesAtDistanceKFromGivenNode {

	public static void main(String[] args) {
		BinaryNode root = createTree();
		BinaryNode x = root.left;
		int distance = 2;

		printAllNodesAtDistance(root, x, distance);
	}

	private static void printAllNodesAtDistance(BinaryNode root, BinaryNode x, int distance) {
		printAllNodesFromBelow(x, distance, 0);
		printNodesFromAbove(root, x, distance);
	}

	private static void printAllNodesFromBelow(BinaryNode x, int distance, int currentDistance) {
		if (x == null)
			return;
		if (distance == currentDistance)
			System.out.print(x.value + " ");
		printAllNodesFromBelow(x.left, distance, currentDistance + 1);
		printAllNodesFromBelow(x.right, distance, currentDistance + 1);
	}

	private static int printNodesFromAbove(BinaryNode root, BinaryNode x, int distance) {

		if (root == null) return -1;
		if (root == x) return 0;

		int leftDistance = printNodesFromAbove(root.left, x, distance);
		// Check if target node was found in left subtree
		if (leftDistance != -1) {
			// If root is at distance k from target, print root
            // Note that leftDistance is Distance of root's left child from target
            if (leftDistance + 1 == distance) 
                System.out.print(root.value + " ");
            // Else go to right subtree and print all k-dl-2 distant nodes
            // Note that the right child is 2 edges away from left child
            else 
            	printAllNodesFromBelow(root.right, distance - leftDistance - 2, 0);           
 
            // Add 1 to the distance and return value for parent calls
            return 1 + leftDistance;            
		}
		
		// MIRROR OF ABOVE CODE FOR RIGHT SUBTREE
        // Note that we reach here only when node was not found in left subtree
		int rightDistance = printNodesFromAbove(root.right, x, distance);
        if (rightDistance != -1) {
            if (rightDistance + 1 == distance) 
                System.out.print(root.value + " ");
             else 
            	 printAllNodesFromBelow(root.left, distance - rightDistance - 2, 0);
            
            return 1 + rightDistance;
        }
 
        // If target was neither present in left nor in right subtree
        return -1;
	}

	private static BinaryNode createTree() {
		BinaryNode root = new BinaryNode(20);

		root.left = new BinaryNode(8);
		root.right = new BinaryNode(22);

		root.left.left = new BinaryNode(4);
		root.left.right = new BinaryNode(12);

		root.left.right.left = new BinaryNode(10);
		root.left.right.right = new BinaryNode(14);

		return root;
	}
}