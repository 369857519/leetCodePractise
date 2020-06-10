package Algorithm.hard;

public class Regx10 {

    public static void main(String[] args) {
        Regx10 regx10 = new Regx10();
        regx10.isMatch("aa", "a*");
    }

    public boolean isMatch(String s, String p) {
        int[][] record = new int[s.length()][p.length()];
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        for (int i = 0; i < pc.length; i++) {
            for (int j = 0; j < sc.length; i++) {
                if (record[i][j] == 0) {
                    //判断是否需要补位
                    //如果p-1,s-1可以匹配的话
                    //前一位如果是点
                    if ((i - 1 < 0 && j - 1 < 0) ||
                        (record[i - 1][j - 1] == 1)) {
                        if (pc[i] == '*') {
                            //需要在判断前一位
                            while (pc[i - 1] == sc[j]) {
                                record[i][j] = 1;
                                j++;
                            }
                        } else if (sc[j] == '.') {
                            record[i][j] = 1;
                        } else if (pc[i] == sc[j]) {
                            record[i][j] = 1;
                        }
                    }

                    //p-1长度的可以被匹配
                    if (pc[i] == '*') {
                        record[i][j] = 1;
                    }
                    //s-1长度可以被匹配
                    int jMinorsOne = record[i][j - 1];
                    if(j-1<0||record[i][j-1]==1){
                        if (pc[i] == '*') {
                            if (sc[j] == pc[i - 1] || pc[i - 1] == '.') {
                                record[i][j] = 1;
                            }
                        }
                    }
                }
            }
        }
        return record[sc.length - 1][pc.length - 1] == 1;
    }

}
