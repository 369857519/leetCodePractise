package categories.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TopKFrequentElement347 {

	public static void main(String[] args) {
		TopKFrequentElement347 topKFrequentElement347 = new TopKFrequentElement347();
		topKFrequentElement347.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
		topKFrequentElement347.topKFrequent(new int[]{1, 2, 3, 4, 5}, 1);
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
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() >= k) {
				list.add(entry.getKey());
			}
		}
		return list;
	}
}
