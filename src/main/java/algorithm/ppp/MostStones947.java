package algorithm.ppp;

import algorithm.Utils.DSU;

import java.util.*;

public class MostStones947 {

	//[[3,2],[0,0],[3,3],[2,1],[2,3],[2,2],[0,2]]
	//	Example 1:
//
//	Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
//	Output: 5
//	Example 2:
//
//	Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
//	Output: 3
//	Example 3:
//
//	Input: stones = [[0,0]]
//	Output: 0

	public static void main(String[] args) {
		MostStones947 mostStones947 = new MostStones947();
		int i = mostStones947.removeStones(new int[][]{
				{3, 2}, {3, 1}, {4, 4}, {1, 1}, {0, 2}, {4, 0}
		});
	}

	public int removeStones(int[][] stones) {
		DSU dsu=new DSU(20000);
		for(int[] stone:stones){
			dsu.union(stone[0],stone[1]+10000);
		}
		Set<Integer> set=new HashSet<>();
		for(int[] stone:stones){
			set.add(dsu.find(stone[0]));
		}
		return stones.length-set.size();
	}
}
