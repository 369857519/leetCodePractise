package categories.search.partition;

import java.util.ArrayList;
import java.util.List;

public class IP93 {

	//Input: "25525511135"
	//Output: ["255.255.11.135", "255.255.111.35"]

	public static void main(String[] args) {
		IP93 ip93 = new IP93();
		ip93.restoreIpAddresses("25525511135");
	}

	public List<String> restoreIpAddresses(String s) {
		int[] groups = new int[]{1, 2, 3};
		List<String> res = new ArrayList<>();
		search(res, new ArrayList<>(), groups, s, 0);
		return res;
	}

	public void search(List<String> res, List<Integer> pivot, int[] groups, String s,
		int currentSeperator) {
		if (currentSeperator == 3) {
			int currentInt = Integer.parseInt(s.substring(groups[2], s.length()));
			if (currentInt > 0 && currentInt < 256) {
				for (int i = 0; i < pivot.size(); i++) {

				}
			}
		}
		for (int i = 0; i < 3; i++) {
			groups[currentSeperator] += i;
			pivot.add(groups[currentSeperator]);
			int lastSeperator = currentSeperator == 0 ? 0 : currentSeperator - 1;
			int currentValue = Integer
				.parseInt(s.substring(groups[lastSeperator], groups[currentSeperator]));
			if (currentValue > 0 && currentValue < 256) {
				search(res, pivot, groups, s, currentSeperator + 1);
			}
			groups[currentSeperator] -= i;
			pivot.remove(pivot.size() - 1);
		}
	}
}
