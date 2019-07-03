package categories.string;


import org.apache.commons.lang.StringUtils;

public class longestPalindromicSubString5 {

	public static void main(String[] args) {

	}

	public String longestPalindrome(String s) {
		int[] lens = new int[s.length()];
		s = StringUtils.join(s.split(""), "#");
		int symetryi = 0;
		int p = 0, pCenter = 0;
		int maxIndex = 0;
		for (int i = 0; i < lens.length; i++) {
			if (i < p) {
				//找对称位置
				symetryi = 2 * pCenter - i;
				if ((lens[symetryi] + i) >= p) {
					//从p开始扩展len[i]，并更新p
					lens[i] = calPalindromicLen(s, i, lens[symetryi]);
				} else {
					lens[i] = lens[symetryi];
				}
			} else {
				//重新计算长度并更新p
				lens[i] = calPalindromicLen(s, i, 0);
			}
			if (lens[maxIndex] < lens[i]) {
				maxIndex = i;
			}
		}
		return s.substring(maxIndex - lens[maxIndex], maxIndex + lens[maxIndex]);

	}

	public int calPalindromicLen(String s, int center, int startlen) {
		int i = 1;
		while (s.charAt(center + startlen + i) == s.charAt(center - startlen - i)) {
			i++;
		}
		return startlen + i;
	}
}
