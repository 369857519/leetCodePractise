package ppp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 祁连山 on 2019/3/16.
 */
public class WordLoadder127 {

	/**
	 * beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
	 */
	public static void main(String[] args) {
		List<String> wordList = new ArrayList<>();
		wordList.add("hot");
		wordList.add("dog");
		wordList.add("dot");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		WordLoadder127 wordLoadder127 = new WordLoadder127();
		wordLoadder127.ladderLength("hit", "cog", wordList);
	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord)) {
			return 0;
		}
		wordList.remove(endWord);
		boolean[] used = new boolean[wordList.size()];
		int[] distanceStart = new int[wordList.size()];
		int[] distanceEnd = new int[wordList.size()];
		getDistance(wordList, used, distanceEnd, endWord, 1);
		getDistance(wordList, used, distanceStart, beginWord, 1);
		int res = 0;
		for (int i = 0; i < distanceEnd.length; i++) {
			if (distanceStart[i] != 0 && distanceEnd[i] != 0) {
				res += distanceEnd[i] + distanceStart[i];
			}
		}
		return res;
	}

	private int size = Integer.MAX_VALUE;

	public void getDistance(List<String> wordList, boolean[] used, int[] distance,
		String currentWord, int depth) {
		if (depth > wordList.size() / 2) {
			return;
		}
		for (int i = 0; i < wordList.size(); i++) {
			if (ifOneLetterDif(currentWord, wordList.get(i)) && !used[i]) {
				used[i] = true;
				distance[i] = Math.min(depth, distance[i]);
				used[i] = false;
			}
		}
	}

	public boolean ifOneLetterDif(String a, String b) {
		int count = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == b.charAt(i)) {
				count++;
			}
		}
		return count == a.length() - 1;
	}
}
