package algorithm.ppp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Created by 祁连山 on 2019/3/16.
 */
public class WordLadder127 {

	/**
	 * beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
	 */
	public static void main(String[] args) {
		WordLadder127 wordLadder127 = new WordLadder127();
		List<String> list = new ArrayList<>();
		list.add("hot");
		list.add("dot");
		list.add("lot");
		list.add("log");
		list.add("cog");
		int res = wordLadder127.ladderLength("hit", "cog", list);
	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord)) {
			return 0;
		}
		return levelOrderTraverse(beginWord, endWord, wordList);
	}

	public int levelOrderTraverse(String beginWord, String endWord, List<String> wordList) {
		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		Map<String, Integer> depth = new HashMap<>();
		depth.put(beginWord, 1);
		int[] visited = new int[wordList.size()];
		while (!queue.isEmpty()) {
			String currentWord = queue.poll();
			int currentWordDepth = depth.get(currentWord);
			for (int i = 0; i < wordList.size(); i++) {
				String nextWord = wordList.get(i);
				if (visited[i] == 0 && oneLetterDist(currentWord, nextWord)) {
					if (nextWord.equals(endWord)) {
						return currentWordDepth + 1;
					}
					depth.put(nextWord, currentWordDepth + 1);
					queue.offer(nextWord);
					visited[i] = 1;
				}
			}
		}
		return 0;
	}


	public boolean oneLetterDist(String a, String b) {
		int count = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) {
				count++;
			}
		}
		return count == 1;
	}
}
