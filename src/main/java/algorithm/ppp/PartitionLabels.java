package algorithm.ppp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class PartitionLabels {

	public List<Integer> partionLabels(String S) {
		Map<Character, int[]> rangeMap = new HashMap<Character, int[]>();
		for (int i = 0; i < S.length(); i++) {
			if (rangeMap.get(S.charAt(i)) == null) {
				rangeMap.put(S.charAt(i), new int[]{i, i + 1});
			} else {
				rangeMap.get(S.charAt(i))[1] = i + 1;
			}
		}
		List<String> list = new ArrayList<String>();
		for (Entry<Character, int[]> entry : rangeMap.entrySet()) {
			list.add(String.valueOf(entry.getValue()[0]) + ",s");
			list.add(String.valueOf(entry.getValue()[1]) + ",e");
		}
		Collections.sort(list, new Comparator<String>() {
			public int compare(String o1, String o2) {
				int o1Index = Integer.parseInt(o1.split(",")[0]);
				int o2Index = Integer.parseInt(o2.split(",")[0]);
				if (o1Index == o2Index) {
					return o1.split(",")[1].compareTo(o2.split(",")[1]);
				}
				return o1Index - o2Index;
			}
		});

		List<Integer> resList = new ArrayList<Integer>();
		int pivot = 0;
		int stk = 0;
		for (int i = 0; i < list.size(); i++) {
			String[] currentVal = list.get(i).split(",");
			if (currentVal[1].equals("s")) {
				stk++;
			} else {
				stk--;
			}
			if (stk == 0) {
				resList.add(Integer.parseInt(currentVal[0]) - pivot);
				pivot = Integer.parseInt(currentVal[0]);
			}
		}
		return resList;
	}
}
