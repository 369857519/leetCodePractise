package algorithm.ppp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAndReplacePattern {

	public List<String> findAndReplacePattern(String[] words, String pattern) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < words.length; i++) {
			if (verify(words[i], pattern)) {
				list.add(words[i]);
			}
		}
		return list;
	}

	public boolean verify(String word, String pattern) {
		HashMap<Character, Character> wordHashMap = new HashMap<Character, Character>();
		HashMap<Character, Character> patternHashMap = new HashMap<Character, Character>();
		for (int i = 0; i < word.length(); i++) {
			//正向映射
			if (wordHashMap.get(word.charAt(i)) == null) {
				wordHashMap.put(word.charAt(i), pattern.charAt(i));
			} else if (wordHashMap.get(word.charAt(i)) != pattern.charAt(i)) {
				return false;
			}
			//反向映射
			if (patternHashMap.get(pattern.charAt(i)) == null) {
				patternHashMap.put(pattern.charAt(i), word.charAt(i));
			} else if (patternHashMap.get(pattern.charAt(i)) != word.charAt(i)) {
				return false;
			}
		}
		return true;
	}

}
