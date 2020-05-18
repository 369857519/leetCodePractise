package algorithm.categories.string;

public class MinimumWindowSubstring76 {

    public static void main(String[] args) {
        MinimumWindowSubstring76 minimumWindowSubstring76 = new MinimumWindowSubstring76();
        minimumWindowSubstring76.minWindow("ADOBECODEBANC", "ABC");
    }

    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return s;
        }
        int start = "A".charAt(0);
        int length="z".charAt(0)-start+1;
        int[] hash = new int[length];
        for (int i = 0; i < t.length(); i++) {
            hash[t.charAt(i) - start]++;
        }
        int[] record = new int[length];

        int left = 0;
        String resString = s;
        boolean succeed=false;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - start;
            record[index]++;
            while (coveredBy(hash, record)) {
                succeed=true;
                if (resString.length() > i + 1 - left) {
                    resString = s.substring(left, i + 1);
                }
                record[s.charAt(left) - start]--;
                left++;
            }
        }
        //没成功过
        if(!succeed){
            return "";
        }
        return resString;
    }

    public boolean coveredBy(int[] hash, int[] record) {
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > record[i]) {
                return false;
            }
        }
        return true;
    }

}
