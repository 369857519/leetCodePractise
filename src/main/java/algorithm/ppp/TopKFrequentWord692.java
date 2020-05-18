package algorithm.ppp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import javafx.util.Pair;

public class TopKFrequentWord692 {

	public static void main(String[] args) {
		TopKFrequentWord692 topKFrequentWord692 = new TopKFrequentWord692();
		topKFrequentWord692
			.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2);
	}

	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> hash = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			if (hash.get(words[i]) != null) {
				hash.put(words[i], hash.get(words[i]) + 1);
			} else {
				hash.put(words[i], 1);
			}
		}
		PriorityQueue<Pair<String, Integer>> priorityQueue = new PriorityQueue<>(k,
			new Comparator<Pair<String, Integer>>() {
				@Override
				public int compare(Pair<String, Integer> o1, Pair<String, Integer> o2) {
					int val = o2.getValue() - o1.getValue();
					if (val == 0) {
						return o1.getKey().compareTo(o2.getKey());
					} else {
						return val;
					}
				}
			});
		for (Entry<String, Integer> entry : hash.entrySet()) {
			priorityQueue.add(new Pair<>(entry.getKey(), entry.getValue()));
		}
		List<String> strList = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			strList.add(priorityQueue.poll().getKey());
		}
		return strList;
	}
}
