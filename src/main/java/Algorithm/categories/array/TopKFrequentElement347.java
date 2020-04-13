package Algorithm.categories.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TopKFrequentElement347 {

	public static void main(String[] args) {
		TopKFrequentElement347 topKFrequentElement347 = new TopKFrequentElement347();
		topKFrequentElement347.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 1);
		topKFrequentElement347.topKFrequent(new int[]{1, 2, 3, 4, 5}, 1);
		topKFrequentElement347.topKFrequent(new int[]{1}, 1);
		topKFrequentElement347.topKFrequent(new int[]{1, 2, 3, 3}, 1);
	}

	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> list = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			Integer store = map.get(nums[i]);
			if (store == null) {
				map.put(nums[i], 1);
			} else {
				map.put(nums[i], store + 1);
			}
		}
		Map<Integer, List<Integer>> sortedMap = new TreeMap<>(Collections.reverseOrder());
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			int newKey = entry.getValue();
			int newValue = entry.getKey();
			if (sortedMap.get(newKey) == null) {
				List<Integer> storeList = new ArrayList<>();
				storeList.add(newValue);
				sortedMap.put(newKey, storeList);
			} else {
				sortedMap.get(newKey).add(newValue);
			}
		}

		for (Entry<Integer, List<Integer>> entry : sortedMap.entrySet()) {
			if (list.size() == k) {
				break;
			}
			for (Integer num : entry.getValue()) {
				if (list.size() == k) {
					break;
				}
				list.add(num);
			}
		}
		return list;
	}
}
