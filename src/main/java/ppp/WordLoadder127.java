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
        Map<String,List<String>> map= new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            List<String> currentList=new ArrayList<>();
            for (int j = 0; j < wordList.size(); j++) {
                if (ifOneDif(wordList.get(i), wordList.get(j))) {
                    currentList.add(wordList.get(j));
                }
            }
            map.put(wordList.get(i),currentList);
        }
        return 0;
    }

    public boolean ifOneDif(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                count++;
            }
        }
        return count == a.length() - 1;
    }
}
