package Algorithm.categories.dp;

import Algorithm.ppp.WordSearch79;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by 祁连山 on 2019/4/3.
 */
public class WordBreak139 {

    public static void main(String[] args) {
        WordBreak139 wordBreak139=new WordBreak139();
        List<String> wordDic=new ArrayList<>();
        wordDic.add("cat");
        wordDic.add("dog");
        wordDic.add("sand");
        wordDic.add("and");
        wordDic.add("cat");
        boolean a=wordBreak139.wordBreak("catsandog",wordDic);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Map<Integer,Integer> list=new ConcurrentHashMap<>();
        list.put(0,1);
        for(int i=1;i<=s.length();i++){
            for(Integer j:list.keySet()){
                if(wordDict.contains(s.substring(j,i))&&!list.containsKey(i)){
                    list.put(i,1);
                }
            }
        }
        return list.containsKey(s.length());
    }
}
