package Utils;

public class TrieNode {

	public TrieNode[] children;

	public boolean isEnd;

	private static final int NUM_COUNT = 26;

	public TrieNode(char c) {
		children = new TrieNode[NUM_COUNT];
		children[c-'a'] = new TrieNode();
	}

	public TrieNode() {
		children = new TrieNode[NUM_COUNT];
	}

}
