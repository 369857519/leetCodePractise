package Algorithm.categories.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams49 {

	public static void main(String[] args) {
		GroupAnagrams49 groupAnagrams49 = new GroupAnagrams49();
		groupAnagrams49.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
	}

	Map<Character, Integer> characterIntegerMap = new HashMap<>();

	public List<List<String>> groupAnagrams(String[] strs) {
		Map<Integer, List<String>> resList = new HashMap<>();
		for (int i = 0; i < 26; i++) {
			int cur = 'a' + i;
			characterIntegerMap.put((char) cur, cur * cur * cur);
		}
		for (int i = 0; i < strs.length; i++) {
			List<String> list = resList.get(myHashCode(strs[i]));
			if (list == null) {
				list = new ArrayList<>();
				resList.put(myHashCode(strs[i]), list);
			}
			list.add(strs[i]);
		}
		return new ArrayList<>(resList.values());
	}

	public int myHashCode(String str) {
		//int[] prime=new int[]{2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101};
		//还可以使用素数相乘设计hash函数
		int res = 0;
		for (int i = 0; i < str.length(); i++) {
			res += characterIntegerMap.get(str.charAt(i));
		}
		return res;
	}
}
