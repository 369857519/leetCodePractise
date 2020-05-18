package algorithm.ppp;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by 祁连山 on 2019/3/16.
 */
public class GenerateParentheses22 {
    public static void main(String[] args) {
        GenerateParentheses22 generateParentheses22 = new GenerateParentheses22();
        generateParentheses22.generateParenthesis(3);
    }

    public List<String> generateParenthesis(int n) {
        Stack<String> stk = new Stack<>();
        List<String> record = new ArrayList<>();
        gen(record, "", n * 2);
        return record;
    }

    public void gen(List<String> record, String temp, int n) {
        if (temp.length() == n) {
            if (isLegal(temp)) {
                record.add(temp);
            }
            return;
        }
        String[] strings = new String[]{"(", ")"};
        for (int i = 0; i < strings.length; i++) {
            temp += strings[i];
            gen(record, temp, n);
            temp = temp.substring(0, temp.length() - 1);
        }
    }

    public boolean isLegal(String sample) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < sample.length(); i++) {
            if (sample.charAt(i) == '(') {
                stack.push(sample.charAt(i));
            } else {
                if(stack.empty()){
                    return false;
                }
                if (stack.peek() == '(') {
                    stack.pop();
                }
            }
        }
        return stack.empty();
    }
}
