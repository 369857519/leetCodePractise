package ppp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 祁连山 on 2019/3/16.
 */
public class PhoneNumber17 {
    public static void main(String[] args) {
        PhoneNumber17 phoneNumber17 = new PhoneNumber17();
        List<String> res = phoneNumber17.letterCombinations("");
    }

    public List<String> letterCombinations(String digits) {
        Map<String, String[]> map = new HashMap<>();
        map.put("2", new String[]{"a", "b", "c"});
        map.put("3", new String[]{"d", "e", "f"});
        map.put("4", new String[]{"g", "h", "i"});
        map.put("5", new String[]{"j", "k", "l"});
        map.put("6", new String[]{"m", "n", "o"});
        map.put("7", new String[]{"p", "q", "r", "s"});
        map.put("8", new String[]{"t", "u", "v"});
        map.put("9", new String[]{"w", "x", "y", "z"});
        combinate(map, digits, 0, "");
        return resArr;
    }

    List<String> resArr = new ArrayList<>();

    public void combinate(Map<String, String[]> map, String digits, int currentIndex, String res) {
        if(res.equals("")){
            return;
        }
        if (currentIndex == digits.length()) {
            resArr.add(res);
            return;
        }
        String[] currentArr = map.get(String.valueOf(digits.charAt(currentIndex)));
        for (int i = 0; i < currentArr.length; i++) {
            combinate(map, digits, currentIndex + 1, res + currentArr[i]);
        }
    }
}
