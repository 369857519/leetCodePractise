package Utils;

public class Trie {

	private TrieNode root;

	/**
	 * Initialize your data structure here.
	 */
	public Trie() {
		root = new TrieNode();
	}

	/**
	 * Inserts a word into the trie.
	 */
	public void insert(String word) {
		TrieNode pointer=root;
		for (int i = 0; i < word.length(); i++) {
			char c=word.charAt(i);
			int index=getIndex(word.charAt(i));
			if(pointer.children[index]==null){
				pointer.children[getIndex(c)]=new TrieNode();
			}
			pointer=pointer.children[index];
		}
		pointer.isEnd=true;
	}

	/**
	 * Returns if the word is in the trie.
	 */
	public boolean search(String word) {

	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {

	}

	public int getIndex(char c) {
		return c - 'a';
	}
}
