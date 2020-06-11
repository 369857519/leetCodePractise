package algorithm.hard;

import algorithm.Utils.ArrayPrintUtil;

public class Regx10 {

    public static void main(String[] args) {
        Regx10 regx10 = new Regx10();
//        regx10.isMatch("aa", "a*");
//        regx10.isMatch("ab", ".*");
        regx10.isMatch("aab","c*a*b");
    }

    public boolean isMatch(String s, String p) {
        int[][] record = new int[s.length()][p.length()];
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        for (int i = 0; i < pc.length; i++) {
            for (int j = 0; j < sc.length; j++) {
                if (record[i][j] == 0) {
                    //判断是否需要补位
                    //如果p-1,s-1，两个字符串各加一位，看加的是否能匹配
                    if ((i - 1 < 0 && j - 1 < 0) ||
                            (j - 1 > 0 && i - 1 > 0 && (record[i - 1][j - 1] == 1))) {
                        if (pc[i] == '*') {
                            //需要在判断前一位
                            while (pc[i - 1] == sc[j]) {
                                record[i][j] = 1;
                                j++;
                                if (j == sc.length) {
                                    break;
                                }
                            }
                        } else if (pc[j] == '.') {
                            record[i][j] = 1;
                        } else if (pc[i] == sc[j]) {
                            record[i][j] = 1;
                        }
                    }

                    //p-1长度的可以被匹配，目前要加一位p，判断是否能匹配
                    if (i - 1 < 0 || (i - 1 > 0 && record[i - 1][j] == 1)) {
                        if (pc[i] == '*') {
                            record[i][j] = 1;
                            //需要在判断前一位
                            while (pc[i - 1] == sc[j] || pc[i - 1] == '.') {
                                record[i][j] = 1;
                                j++;
                                if (j == sc.length) {
                                    break;
                                }
                            }
                        }
                    }

                    //s-1长度可以被匹配，目前要加一位s，判断是否能匹配
                    if (j - 1 < 0 || (j - 1 > 0 && record[i][j - 1] == 1)) {
                        if (pc[i] == '*') {
                            while (sc[j] == pc[i - 1] || pc[i - 1] == '.') {
                                record[i][j] = 1;
                                j++;
                                if (j == sc.length) {
                                    break;
                                }
                            }
                        }
                    }
                }
                ArrayPrintUtil.printArr(record);
            }
        }
        return record[sc.length - 1][pc.length - 1] == 1;
    }

}
