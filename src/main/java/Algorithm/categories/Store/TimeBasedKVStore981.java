package Algorithm.categories.Store;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKVStore981 {

	public static void main(String[] args) {
		TimeBasedKVStore981 timeBasedKVStore981 = new TimeBasedKVStore981();
		timeBasedKVStore981.get("hahaha", 123);
		timeBasedKVStore981.set("hahaha", "lala", 22);
		timeBasedKVStore981.set("hahaha", "leilei", 44);
		timeBasedKVStore981.get("hahaha", 123);
	}

	Map<String, TreeMap> map;

	/**
	 * Initialize your data structure here.
	 */
	public TimeBasedKVStore981() {
		map = new HashMap<>();
	}

	public void set(String key, String value, int timestamp) {
		TreeMap<Integer, String> sortedMap = map.get(key);
		if (sortedMap != null) {
			sortedMap.put(timestamp, value);
		} else {
			sortedMap = new TreeMap<>();
			sortedMap.put(timestamp, value);
			map.put(key, sortedMap);
		}
	}

	public String get(String key, int timestamp) {
		TreeMap<Integer, String> sortedMap = map.get(key);
		if (sortedMap != null) {
			String value = sortedMap.get(timestamp);
			if (value != null) {
				return value;
			}
			Integer lowerKey = sortedMap.lowerKey(timestamp);
			if (lowerKey != null) {
				return sortedMap.get(lowerKey);
			}
			return "";
		}
		return null;
	}

}
