package Algorithm.categories.math;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        HappyNumber happyNumber=new HappyNumber();
        happyNumber.isHappy(19);
    }
    public boolean isHappy(int n) {
        Set<Integer> hashSet=new HashSet();
        while(!hashSet.contains(n)){
            hashSet.add(n);
            int nextNum=0;
            while(n>0){
                int intDigit=n%10;
                n/=10;
                nextNum+=intDigit*intDigit;
            }
            n=nextNum;
            if(n==1){
                return true;
            }
        }
        return false;
    }
}
