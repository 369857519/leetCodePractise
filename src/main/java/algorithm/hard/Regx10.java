package algorithm.hard;

import algorithm.Utils.ArrayPrintUtil;

public class Regx10 {

    public static void main(String[] args) {
        Regx10 regx10 = new Regx10();
//        regx10.isMatch("aa", "a*");
//        regx10.isMatch("ab", ".*");
        regx10.isMatch("aab", "c*a*b");
    }

    public boolean isMatch(String s, String p) {
        boolean[][] record = new boolean[s.length() + 1][p.length() + 1];
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        record[0][0] = true;
        for (int j = 2; j < pc.length + 1; j++) {
            record[0][j] = pc[j-1] == '*' && record[0][j - 2];
        }
        for (int i = 0; i < pc.length; i++) {
            for (int j = 0; j < sc.length; j++) {
                if (pc[i] == '*') {

                }else{

                }

            }
            ArrayPrintUtil.printArr(record);
        }
        return record[pc.length][sc.length];
    }

}
