package Algorithm.categories.math;

public class MultiplyStrings43 {
    public String multiply(String num1, String num2) {
        int Carry=0;
        int max=Math.max(num1.length(),num2.length());

        StringBuilder stringBuilder=new StringBuilder();
        for(int i=1;i<max;i++){
            int digit2=0;
            if(i>num2.length()){
                digit2=0;
            }else{

            }
            if(i>num1.length()){
                break;
            }
            int currentNum=num2.charAt(num2.length()-i);

        }
        return "";
    }
}
