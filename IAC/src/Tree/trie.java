package Tree;

import java.util.HashMap;

class TrieNode{
	char c;
	HashMap<Character, TrieNode> children = new HashMap<Character,TrieNode>();
	boolean isLeaf;
	
	public TrieNode(){}
	
	public TrieNode(char c){
		this.c= c;
	}
}

public class trie {

	private TrieNode root;
	
	public trie() {
		root = new TrieNode();
	}
	
	// Insert a word in trie
	public void insert(String word) {
	HashMap<Character, TrieNode> children = root.children;
	for(int i=0; i< word.length(); i++) {
		char c = word.charAt(i);
		TrieNode t;
		if(children.containsKey(c)) {
			t=children.get(c);
		}
		else {
			t= new TrieNode(c);
			children.put(c,t);
		}
		
		children = t.children;
		
		if(i==word.length()-1) {
			t.isLeaf=true;
		}
	}
	}
	
	
	// returns if a word is in trie
	public boolean search(String word) {
		TrieNode t = searchNode(word);
		if(t!=null && t.isLeaf) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	// Returns if there is any word in the trie
    // that starts with the given prefix.
	public boolean searchPre(String c) {
		if(searchNode(c)==null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public TrieNode searchNode(String str) {
		HashMap<Character, TrieNode> children = root.children;
		TrieNode t = null;
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(children.containsKey(c)) {
				t = children.get(c);
				children= t.children;
			}
			else {
				return null;
			}
		}
		return t;
	}
	
}
