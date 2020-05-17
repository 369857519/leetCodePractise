package algorithm.categories.array;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class RevealCardsInIncreasingOrder950 {

	//Input: [17,13,11,2,3,5,7]
	//Output: [2,13,3,11,5,17,7]
	public static void main(String[] args) {
		RevealCardsInIncreasingOrder950 revealCardsInIncreasingOrder950 = new RevealCardsInIncreasingOrder950();
		revealCardsInIncreasingOrder950.deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7});

	}

	public int[] deckRevealedIncreasing(int[] deck) {
		int N = deck.length;
		Arrays.sort(deck);
		Deque<Integer> index = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			index.add(i);
		}
		int[] ans = new int[N];
		for (Integer card : deck) {
			ans[index.pollFirst()] = card;
			if (!index.isEmpty()) {
				index.add(index.pollFirst());
			}
		}
		return ans;
	}
}
