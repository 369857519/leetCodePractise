package ppp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 祁连山 on 2019/3/16.
 */
public class WordLoadder127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean[] used=new boolean[]{};

        return 0;
    }

    public boolean find(String a,String b){
        return true;
    }

    public boolean ifOneLetterDif(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                count++;
            }
        }
        return count == a.length() - 1;
    }
}
