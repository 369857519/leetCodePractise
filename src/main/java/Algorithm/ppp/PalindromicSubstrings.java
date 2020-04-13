package Algorithm.ppp;

public class PalindromicSubstrings {

	public static void main(String[] args) {
		PalindromicSubstrings palindromicSubstrings = new PalindromicSubstrings();
		System.out.println(palindromicSubstrings.countSubstrings("abc"));
	}

	public int countSubstrings(String s) {
		//预处理，处理后；原文回文长度为半径减1
		//@为了处理边界情况
		Character[] characters = new Character[s.length() * 2 + 2];
		characters[0] = '@';
		for (int i = 0; i < s.length(); i++) {
			characters[(i + 1) * 2 - 1] = '#';
			characters[(i + 1) * 2] = s.charAt(i);
		}
		characters[characters.length - 1] = '#';
		int right = 1;
		int center = 1;
		int[] lenRecord = new int[characters.length];
		for (int i = 1; i < characters.length; i++) {
			int curLen = 0;
			//两种情况，在目前的搜索过的最大范围之内
			if (i >= right) {
				//以目前位置距离right的大小和镜像位置的记录的较小的值为起始记录
				lenRecord[i] = Math.min(lenRecord[center * 2 - i], right - i + 1);
				//不在目前的范围内
			} else {
				lenRecord[i] = 1;
			}
			//计算目前位置的长度
			while (i - lenRecord[i] >= 0 && i + lenRecord[i] < characters.length &&
				characters[i - lenRecord[i]] == characters[i + lenRecord[i]]) {
				lenRecord[i]++;
			}
			//更新坐标轴
			if (i + lenRecord[i] > right) {
				right = i + lenRecord[i] - 1;
				center = i;
			}
		}
		int res = 0;
		for (int i = 0; i < characters.length; ++i) {
			if (characters[i] == '#') {
				res += (lenRecord[i] - 1) / 2;
			} else {
				res += (lenRecord[i]) / 2;
			}
		}
		return res;
	}

}
