package list.elements;

public class DLinkedListElement {
	int value;
	DLinkedListElement left, right;
	public static DLinkedListElement head;
	
	public DLinkedListElement(int value) {
		this.value = value;
	}
	
	public void addElementToLeft(DLinkedListElement element) {
		element.right = this;
		element.left = this.left;
		if (this.left != null)
			this.left.right = element;
		else 
			head = element;
		this.left = element;
	}
	
	public void addElementToRight(DLinkedListElement element) {
		element.left = this;
		element.right = this.right;
		if (this.right != null)
			this.right.left = element;
		this.right = element;
		
		if (head == null) head = this;
	}
	
	public void printList() {
		DLinkedListElement current = head;
		while (current != null) {
			System.out.print(current.value + " ");
			current = current.right;
		}
	}
}