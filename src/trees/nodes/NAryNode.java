package trees.nodes;

public class NAryNode {

	public char charValue;
	public int value;
	public NAryNode[] children;
	
	public NAryNode(char charValue, int noOfChildren) {
		this.charValue = charValue;
		children = new NAryNode[noOfChildren];
	}
	
	public NAryNode(int value, int noOfChildren) {
		this.value = value;
		children = new NAryNode[noOfChildren];
	}	
	
	public void printTree() {
		if (this == null) return;
		for (int i = 0; i < this.children.length; i++) {
			this.children[i].printTree();
		}
		System.out.println(this.value);
	}
}