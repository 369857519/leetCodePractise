package categories.string;


public class LongestPalindromicSubString5 {

	public static void main(String[] args) {
		LongestPalindromicSubString5 longestPalindromicSubString5 = new LongestPalindromicSubString5();
		String test = longestPalindromicSubString5.longestPalindrome("cbbd");
		test = longestPalindromicSubString5.longestPalindrome("babad");
		test=longestPalindromicSubString5.longestPalindrome("abb");

	}

	public String longestPalindrome(String s) {
		if (s.length() == 1 || s.length() == 0) {
			return s;
		}
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append('#');
		for(int i=0;i<s.length();i++){
			stringBuilder.append(s.charAt(i));
			stringBuilder.append('#');
		}
		s=stringBuilder.toString();
		int[] lens = new int[s.length()];
		int symetryi;
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
		return s.substring(maxIndex - lens[maxIndex] + 1, maxIndex + lens[maxIndex])
			.replaceAll("#", "");
	}

	public int calPalindromicLen(String s, int center, int startlen) {
		int i = 1;
		while (true) {
			int left = center - startlen - i;
			int right = center + startlen + i;
			if (left < 0 || right >= s.length() || s.charAt(left) != s.charAt(right)) {
				break;
			}
			i++;
		}
		return startlen + i;
	}
}
