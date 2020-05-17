package algorithm.ppp;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class RevealCardsInIncreaseOrder {

	public static void main(String[] args) {
		RevealCardsInIncreaseOrder revealCardsInIncreaseOrder=new RevealCardsInIncreaseOrder();
		revealCardsInIncreaseOrder.deckRevealedIncreasing(new int[]{17,13,11,2,3,5,7});
	}

	public int[] deckRevealedIncreasing(int[] deck) {
		int N = deck.length;
		Deque<Integer> index=new LinkedList<Integer>();
		for(int i=0;i<N;++i){
			index.add(i);
		}

		int[] ans=new int[N];
		Arrays.sort(deck);

		for(int card:deck){
			ans[index.pollFirst()]=card;
			if(!index.isEmpty())
				index.add(index.pollFirst());
		}

		return ans;
	}
}
