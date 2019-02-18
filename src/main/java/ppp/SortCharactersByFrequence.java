package ppp;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortCharactersByFrequence {

	public static void main(String[] args) {
		SortCharactersByFrequence sortCharactersByFrequence = new SortCharactersByFrequence();
		String s = sortCharactersByFrequence.frequencySort(
			"Mymommaalwayssaid,\"Lifewaslikeaboxofchocolates.Youneverknowwhatyou'regonnaget.");
	}

	public String frequencySort(String s) {
		if (s.length() == 0 || s.length() == 1) {
			return s;
		}
		Map<Character, Integer> count = new HashMap<>();
		Queue<String> que = new PriorityQueue<>(
			(a, b) -> Integer.parseInt(b.split("擦")[1]) - Integer.parseInt(a.split("擦")[1]));
		for (int i = 0; i < s.length(); i++) {
			char currentChar = s.charAt(i);
			if (count.get(currentChar) == null) {
				count.put(currentChar, 1);
			} else {
				count.put(currentChar, count.get(currentChar) + 1);
			}
		}

		for (Entry<Character, Integer> entry : count.entrySet()) {
			que.offer(entry.getKey() + "擦" + String.valueOf(entry.getValue()));
		}
		String res = "";
		while (!que.isEmpty()) {
			String[] record = que.poll().split("擦");
			String character = record[0];
			int size = Integer.parseInt(record[1]);
			for (int i = 0; i < size; i++) {
				res += character;
			}
		}
		return res;
	}
}
