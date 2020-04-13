package Algorithm.Utils;

public class Trie {

	public static void main(String[] args) {
		boolean test = false;
		Trie trie = new Trie();
		trie.insert("apple");
		test = trie.search("apple");
		test = trie.startsWith("app");
		test = trie.search("app");
		trie.insert("app");
		test = trie.search("app");
	}

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
		TrieNode pointer = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			int index = getIndex(word.charAt(i));
			if (pointer.children[index] == null) {
				pointer.children[getIndex(c)] = new TrieNode();
			}
			pointer = pointer.children[index];
		}
		pointer.isEnd = true;
	}

	/**
	 * Returns if the word is in the trie.
	 */
	public boolean search(String word) {
		TrieNode pointer = root;
		for (int i = 0; i < word.length(); i++) {
			int index = getIndex(word.charAt(i));
			if (pointer.children[index] != null) {
				pointer = pointer.children[index];
			} else {
				return false;
			}
		}
		return pointer.isEnd;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		TrieNode pointer = root;
		boolean res = true;
		for (int i = 0; i < prefix.length(); i++) {
			int index = getIndex(prefix.charAt(i));
			if (pointer.children[index] != null) {
				pointer = pointer.children[index];
			} else {
				res = false;
			}
		}
		return res;
	}

	private int getIndex(char c) {
		return c - 'a';
	}
}
