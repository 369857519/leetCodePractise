package algorithm.ppp;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams groupAnagrams=new GroupAnagrams();
        groupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> recordMap=new HashMap();
        for(int i=0;i<strs.length;i++){
            char[] charArray=strs[i].toCharArray();
            Arrays.sort(charArray);
            String hashValue=String.valueOf(charArray);
            if(!recordMap.containsKey(hashValue)){
                recordMap.put(hashValue,new ArrayList<>());
            }
            recordMap.get(hashValue).add(strs[i]);
        }
        return new ArrayList<>(recordMap.values());
    }
}
