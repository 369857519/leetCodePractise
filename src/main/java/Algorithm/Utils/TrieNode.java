package Algorithm.Utils;

public class TrieNode {

	public TrieNode[] children;

	public boolean isEnd;

	private static final int NUM_COUNT = 26;

	public TrieNode() {
		children = new TrieNode[NUM_COUNT];
	}

}
