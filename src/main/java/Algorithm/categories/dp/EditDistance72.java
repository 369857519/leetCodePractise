package Algorithm.categories.dp;

import java.util.Arrays;

/**
 * Created by 祁连山 on 2019/4/12.
 */
public class EditDistance72 {
    public static void main(String[] args) {
        EditDistance72 editDistance72=new EditDistance72();
        int res=editDistance72.minDistance("plasma","altruism");
    }
    public int minDistance(String word1, String word2) {
        int len1=word1.length()+1;
        int len2=word2.length()+1;
        int[][] record=new int[len1][len2];
        //initialize
        for(int i=1;i<len1;i++){
            record[i][0]=i;
        }
        for(int j=1;j<len2;j++){
            record[0][j]=j;
        }
        for(int i=1;i<len1;i++){
           for(int j=1;j<len2;j++){
               int leftTop=record[i-1][j-1];
               int left=record[i][j-1]+1;
               int top=record[i-1][j]+1;
               if(word1.charAt(i-1)!=word2.charAt(j-1)){
                   leftTop++;
               }
               record[i][j]=Math.min(Math.min(leftTop,left),top);
               System.out.println(Arrays.deepToString(record));
           }
        }
        return record[len1-1][len2-1];
    }
    public int commonLen(String word1, String word2) {
        int len1=word1.length()+1;
        int len2=word2.length()+1;
        int[][] record=new int[len1][len2];
        //initialize
        int maxLen=0;
        for(int i=1;i<len1;i++){
            for(int j=1;j<len2;j++){
                record[i][j]=Math.max(record[i-1][j],record[i][j-1]);
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    record[i][j]=Math.max(record[i-1][j-1]+1,record[i][j]);
                }
                maxLen=Math.max(record[i][j],maxLen);
                System.out.println(Arrays.deepToString(record));
            }
        }
        return Math.max(len1-1,len2-1)-maxLen;
    }
}
