package trees;

import java.util.Arrays;
import java.util.Comparator;

import trees.nodes.NAryNode;

// TODO
// http://www.geeksforgeeks.org/minimum-iterations-pass-information-nodes-tree/
public class MinNoOfIterationsToPassInformationToAllNodesInTree {

	public static void main(String[] args) {
		NAryNode root = createTree();

	}

	private static void getMinIterations(NAryNode n) {
		
		int minItr = n.children.length;
		
		for (int i = 0; i < n.children.length; i++) {
			getMinIterations(n.children[i]);
		}
		
		Arrays.sort(n.children, new Comparator<NAryNode>() {       
			@Override
			public int compare(NAryNode o1, NAryNode o2) {
				if (o1.value < o2.value) return -1;
				if (o2.value > o2.value) return 1;
				return 0;
			}
		});
		
		for (int i = 0; i < n.children.length; i++) {
			
		}
		
	}

	private static NAryNode createTree() {
		NAryNode root = new NAryNode('A', 6);

		root.children[0] = new NAryNode('B', 3);
		root.children[1] = new NAryNode('C', 0);
		root.children[2] = new NAryNode('D', 0);
		root.children[3] = new NAryNode('E', 2);
		root.children[4] = new NAryNode('F', 0);
		root.children[5] = new NAryNode('G', 1);

		root.children[0].children[0] = new NAryNode('H', 2);
		root.children[0].children[1] = new NAryNode('I', 0);
		root.children[0].children[2] = new NAryNode('J', 0);
		root.children[3].children[0] = new NAryNode('K', 1);
		root.children[3].children[1] = new NAryNode('L', 1);
		root.children[5].children[0] = new NAryNode('M', 0);

		root.children[0].children[0].children[0] = new NAryNode('N', 0);
		root.children[0].children[0].children[1] = new NAryNode('O', 0);
		root.children[3].children[0].children[0] = new NAryNode('P', 0);
		root.children[3].children[1].children[0] = new NAryNode('Q', 0);

		return root;
	}
}