package trees;

import java.util.ArrayList;
import java.util.List;

public class LockUnlockResourcesInNArryTree {

	public static void main(String[] args) {
		Node root = createTree();
		lock(root.children.get(0));
		lock(root.children.get(0).children.get(1).children.get(0));
	}
	
	private static boolean isLocked(Node n) {
		return n.isLocked;
	}
	
	private static void unLock(Node n) {
		if (n.isLocked) {
			n.isLocked = false;
		}
	}
	
	private static void lock(Node n) {
		if (!n.isLocked) {
			if (canBeLocked(n)) {
				System.out.println(n.value + " can be locked");
				n.isLocked = true;
			} else {
				System.out.println("Cannot lock");
			}
		}
	}
	
	private static boolean canBeLocked(Node n) {
		return !anyChildIsLocked(n) && !anyParentIsLocked(n);
	}	

	private static boolean anyChildIsLocked(Node n) {
		
		if (n.children.size() == 0) return n.isLocked;
		
		boolean result = false;
		for (int i = 0; i < n.children.size(); i++) {
			result |= anyChildIsLocked(n.children.get(i));
		}		
		return result;
	}
	
	private static boolean anyParentIsLocked(Node n) {
		if (n == null) return false;
		
		if (n.isLocked) return true;
		
		return anyParentIsLocked(n.parent);
	}
	
	private static Node createTree() {
		Node root = new LockUnlockResourcesInNArryTree().new Node(1, null);
		Node rootLeft = new LockUnlockResourcesInNArryTree().new Node(2, root);
		Node rootRight = new LockUnlockResourcesInNArryTree().new Node(3, root);
		Node four = new LockUnlockResourcesInNArryTree().new Node(4, rootLeft);
		Node five = new LockUnlockResourcesInNArryTree().new Node(5, rootLeft);
		Node seven = new LockUnlockResourcesInNArryTree().new Node(7, rootLeft);
		Node six = new LockUnlockResourcesInNArryTree().new Node(6, five);
		
		return root;
	}

	private class Node {
		int value;
		boolean isLocked;
		
		Node parent;
		List<Node> children;

		public Node(int value, Node parent) {			
			this.value = value;
			this.parent = parent;
			children = new ArrayList<>();
			
			if (parent != null) parent.children.add(this);
		}
	}
}