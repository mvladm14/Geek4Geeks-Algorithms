package interviews;

import java.util.HashSet;
import java.util.Set;

import trees.nodes.Trie;

// only done for small case letters
public class PhoneContacts {
	
	private static Set<String> contactsSet;

	public static void main(String[] args) {

		contactsSet = new HashSet<>();		
		Trie trie = new Trie();
		String[] contacts = { "vlad", "ana", "vlada", "sid", "ikvlxg" };
		insertContacts(contacts, trie);
		searchContact(trie, "vl", 0);
		printDiscoveredContacts(contactsSet);
	}

	private static void searchContact(Trie trie, String searchString, int counter) {

		// searched string was found among contacts		
		if (counter == searchString.length()) {
			String discovered = getDiscoveredPartOfContacts(trie);
			getDiscoveredContacts(trie, discovered);
			counter = 0;
		}
		
        if (searchString.length() == 0) return;
        
		for (int i = 0; i < trie.children.length; i++) {
			if (trie.children[i] != null) {
				if (trie.children[i].value == searchString.charAt(counter)) {
					searchContact(trie.children[i], searchString, counter + 1);
				} else {
					searchContact(trie.children[i], searchString, 0);
				}				
			}
		}
	}

	private static void insertContacts(String[] contacts, Trie trie) {
		for (String contact : contacts) {
			Trie currentTrie = new Trie();
			currentTrie = trie;
			insertContact(contact, currentTrie);
		}
	}

	private static void insertContact(String contact, Trie currentTrie) {
		for (int i = 0; i < contact.length(); i++) {
			char c = contact.charAt(i);
			int index = c - 'a';

			if (currentTrie.children[index] == null) {
				currentTrie.children[index] = new Trie(c, currentTrie);
			}
			currentTrie = currentTrie.children[index];
			if (i == contact.length() - 1)
				currentTrie.isLeaf = true;
		}
	}

	private static String getDiscoveredPartOfContacts(Trie trie) {
		String discovered = "";
		while (trie.parent != null) {
			discovered = trie.value + discovered;
			trie = trie.parent;
		}
		return discovered;
	}

	private static void getDiscoveredContacts(Trie trie, String discoveredString) {
		if (trie == null)
			return;

		for (int i = 0; i < trie.children.length; i++) {
			if (trie.children[i] != null) {
				getDiscoveredContacts(trie.children[i], discoveredString + trie.children[i].value);
			}
		}

		if (trie.isLeaf) {
			contactsSet.add(discoveredString);
		}
	}

	private static void printDiscoveredContacts(Set<String> contacts) {
		for (String contact : contacts) {
			System.out.println(contact);
		}		
	}	
}