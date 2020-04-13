package Algorithm.categories.string;



public class LongestPalindromicSubString5 {



    public static void main(String[] args) {
        LongestPalindromicSubString5 longestPalindromicSubString5 = new LongestPalindromicSubString5();
        String test = longestPalindromicSubString5.longestPalindrome("cbbd");
        test = longestPalindromicSubString5.longestPalindrome("babad");
        test = longestPalindromicSubString5.longestPalindrome("abb");
        test = longestPalindromicSubString5.longestPalindrome("");

    }

    //manacher
    public String longestPalindrome(String s) {
        s = "@#" + String.join("#", s.split("")) + "#$";

        int[] record = new int[s.length()];
        int right = 0;
        int rightCenter = 0;
        for (int i = 1; i < s.length(); i++) {
            if (i < right) {
                //利用对称性性
                int symmetryPoint = rightCenter - (i - rightCenter);
                int starter = Math.min(right - i, record[symmetryPoint]);
                record[i] = starter;
            } else {
                //朴素办法
                record[i] = 0;
            }
            while (s.charAt(i + 1 + record[i]) == s.charAt(i - 1 - record[i])) {
                record[i]++;
            }
            if (i + record[i] > right) {
                rightCenter = i;
                right = i + record[i];
            }
        }
        int maxIndex = 0;
        int max = 0;
        for (int i = 1; i < record.length; i++) {
            if (record[i] > max) {
                max = record[i];
                maxIndex = i;
            }
        }
        return s.substring(maxIndex - record[maxIndex] + 1, maxIndex + record[maxIndex])
            .replace("#", "");
    }

    //n^2的方式
    public String longestPalindromeNsquare(String s) {
        //奇数
        String resString = "";
        for (int i = 0; i < s.length(); i++) {
            int j = 0;

            int length = 0;
            while (i + j < s.length() && i - j >= 0 && s.charAt(i + j) == s.charAt(i - j)) {
                length += 2;
                if (length > resString.length()) {
                    resString = s.substring(i - j, i + j + 1);
                }
                j++;
            }

            j = 0;
            length = 0;
            while (i + j + 1 < s.length() && i - j >= 0 && s.charAt(i + j + 1) == s.charAt(i - j)) {
                length += 2;
                if (length > resString.length()) {
                    resString = s.substring(i - j, i + j + 2);
                }
                j++;
            }
        }
        return resString;
    }

}
