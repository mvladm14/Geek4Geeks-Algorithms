package trees.nodes;

public class Trie {
	
	// getters and setters are omitted
	public char value;
	public boolean isLeaf;
	public Trie parent;
	public Trie[] children;
	
	public Trie(){
		children = new Trie[26];
	}
	
	public Trie(char value, Trie parent) {
		this();
		this.value = value;
		this.parent = parent;
	}
}