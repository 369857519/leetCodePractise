package algorithm.categories.string;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22 {

    public static void main(String[] args) {
        GenerateParentheses22 generateParentheses22 = new GenerateParentheses22();
        generateParentheses22.generateParenthesis(3);
    }

    public List<String> generateParenthesis(int n) {
        this.count = n;
        List<String> list = new ArrayList<>();
        traverse(list, "", '(', 1);
        return list;
    }

    private int count;

    public void traverse(List<String> res, String curRecord, Character cur, int value) {
        curRecord += cur;
        if (value < 0 || value > count) {
            return;
        }
        if (curRecord.length() == this.count * 2) {
            if (value == 0) {
                res.add(curRecord);
            }
            return;
        }
        traverse(res, curRecord, '(', value + 1);
        traverse(res, curRecord, ')', value - 1);
    }

}
