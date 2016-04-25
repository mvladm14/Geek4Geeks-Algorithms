package trees;

import trees.nodes.NAryNode;

public class MirrorOfNaryTree {

	public static void main(String[] args) {
		NAryNode root = createTree();
		mirrorTree(root);
		root.printTree();
	}

	private static void mirrorTree(NAryNode n) {
		if (n == null)
			return;

		for (int i = 0; i < n.children.length; i++) {
			mirrorTree(n.children[i]);
		}

		for (int i = 0; i < n.children.length / 2; i++) {
			int indexOfElementFromRight = n.children.length - (i + 1);
			NAryNode aux = n.children[i];
			n.children[i] = n.children[indexOfElementFromRight];
			n.children[indexOfElementFromRight] = aux;
		}
	}

	private static NAryNode createTree() {
		NAryNode root = new NAryNode(10, 4);

		root.children[0] = new NAryNode(2, 0);
		root.children[1] = new NAryNode(34, 1);
		root.children[2] = new NAryNode(56, 0);
		root.children[3] = new NAryNode(100, 3);

		root.children[1].children[0] = new NAryNode(1, 0);
		root.children[3].children[0] = new NAryNode(7, 0);
		root.children[3].children[1] = new NAryNode(8, 0);
		root.children[3].children[2] = new NAryNode(9, 0);

		return root;
	}
}