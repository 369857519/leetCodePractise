package Algorithm.categories.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargestNumber179 {

	public static void main(String[] args) {
		LargestNumber179 largestNumber179 = new LargestNumber179();
		largestNumber179.largestNumber(new int[]{3, 30, 34, 5, 9});
		largestNumber179.largestNumber(new int[]{10, 2});
		largestNumber179.largestNumber(new int[]{});
		largestNumber179.largestNumber(new int[]{100});
		largestNumber179.largestNumber(new int[]{0, 0});
	}

	public String largestNumber(int[] nums) {
		List<Integer> strList = new ArrayList<>();
		for (int i : nums) {
			strList.add(i);
		}
		Collections.sort(strList, (a, b) -> {
			int aSize = String.valueOf(a).length();
			int bSize = String.valueOf(b).length();
			int left = (int) (a * Math.pow(10, bSize) + b);
			int right = (int) (a + b * Math.pow(10, aSize));
			return right-left;
		});
		StringBuilder sb=new StringBuilder();

		return "";
	}
}
