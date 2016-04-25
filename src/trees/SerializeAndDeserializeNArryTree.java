package trees;

import trees.nodes.NAryNode;

public class SerializeAndDeserializeNArryTree {

	public static void main(String[] args) {
		
		NAryNode root = createTree();
		String serialized = serialize(root);
		System.out.println(serialized);
	}
	
	private static String serialize(NAryNode n) {
		
		if (n == null) return "";
		
		String result = n.charValue + "";
		
		for (int i = 0; i < n.children.length; i++) {
			result = result + serialize(n.children[i]);
		}
		
		result += ")";
		
		return result;
	}
	
	private static NAryNode createTree() {
		NAryNode root = new NAryNode('A', 3);
		
		root.children[0] = new NAryNode('B', 2);
		root.children[1] = new NAryNode('C', 0);
		root.children[2] = new NAryNode('D', 4);
		
		root.children[0].children[0] = new NAryNode('E', 0);
		root.children[0].children[1] = new NAryNode('F', 1);
		root.children[2].children[0] = new NAryNode('G', 0);
		root.children[2].children[1] = new NAryNode('H', 0);
		root.children[2].children[2] = new NAryNode('I', 0);
		root.children[2].children[3] = new NAryNode('J', 0);
		
		root.children[0].children[1].children[0] = new NAryNode('K', 0);
		
		return root;
	}
}