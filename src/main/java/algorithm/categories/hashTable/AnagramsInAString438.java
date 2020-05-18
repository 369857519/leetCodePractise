package algorithm.categories.hashTable;

import java.util.ArrayList;
import java.util.List;

public class AnagramsInAString438 {

    public static void main(String[] args) {
        AnagramsInAString438 anagramsInAString438 = new AnagramsInAString438();
        anagramsInAString438.findAnagrams("cbaebabacd", "abc");
    }

    public List<Integer> findAnagrams(String s, String p) {
        int[] tempateSet = new int[26];
        for (int i = 0; i < p.length(); i++) {
            tempateSet[p.charAt(i) - 97]++;
        }
        int[] recordSet = new int[26];
        int start = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            recordSet[s.charAt(i) - 97]++;
            while (isCoveredBy(tempateSet, recordSet)) {
                if (isAnagram(tempateSet, recordSet)) {
                    list.add(start);
                }
                //record
                recordSet[s.charAt(start) - 97]--;
                start++;
            }
        }
        return list;
    }

    public boolean isCoveredBy(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] > b[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
