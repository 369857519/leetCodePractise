package categories.search.partition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class IP93 {

	//Input: "25525511135"
	//Output: ["255.255.11.135", "255.255.111.35"]

	public static void main(String[] args) {
		IP93 ip93 = new IP93();
		ip93.restoreIpAddresses("1111");
		ip93.restoreIpAddresses("25525511135");
		ip93.restoreIpAddresses("0000");
		ip93.restoreIpAddresses("010010");
	}

	public List<String> restoreIpAddresses(String s) {
		res.clear();
		if (s.length() < 4) {
			return res;
		}
		int[] groups = new int[]{1, 1, 1};
		search(new ArrayList<>(), groups, s, 0);
		return res;
	}

	List<String> res = new ArrayList<>();

	public void search(List<String> record, int[] groups, String s,
		int currentSeperator) {
		if (currentSeperator == 3) {
			if (groups[2] >= s.length()) {
				return;
			}
			String subStr = s.substring(groups[2], s.length());
			record.add(subStr);
			if (legal(subStr)) {
				res.add(String.join(".", record));
			}
			record.remove(record.size() - 1);
			return;
		}
		for (int i = 0; i < 3; i++) {
			groups[currentSeperator] += i;
			if (currentSeperator + 1 < 3) {
				groups[currentSeperator + 1] = groups[currentSeperator] + 1;
			}
			int lastSperatorIndex = currentSeperator == 0 ? 0 : groups[currentSeperator - 1];
			if (groups[currentSeperator] == s.length()) {
				break;
			}
			String subStr = s.substring(lastSperatorIndex, groups[currentSeperator]);
			record.add(subStr);
			//在目前这个值付合规则
			if (legal(subStr) &&
				//余下的位数不超过最大长度
				((s.length() - groups[currentSeperator]) <= (4 - (currentSeperator + 1)) * 3)) {
				search(record, groups, s, currentSeperator + 1);
			}
			record.remove(record.size() - 1);
			groups[currentSeperator] -= i;
		}
	}

	public boolean legal(String s) {
		if (s.length() == 0) {
			return false;
		}
		if (s.charAt(0) == '0' && s.length() > 1) {
			return false;
		}
		int currentInt = Integer.parseInt(s);
		if (currentInt < 0 || currentInt > 255) {
			return false;
		}
		return true;
	}
}
