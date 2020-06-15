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
        boolean[][] record = new boolean[p.length() + 1][s.length() + 1];
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        record[0][0] = true;
        for (int i = 1; i < pc.length + 1; i++) {
            record[0][i] = pc[i] == '*' && (i - 2 < 0 || record[0][i - 2]);

        }
        for (int i = 0; i < pc.length; i++) {
            for (int j = 0; j < sc.length; j++) {
                if (pc[i] == '*') {
                    //两种情况，一种是要前一位，一种是不要
                }else{
                    //如果是.的话true
                    //如果是字母的话比较一下
                }

            }
            ArrayPrintUtil.printArr(record);
        }
        return record[pc.length][sc.length];
    }

}
