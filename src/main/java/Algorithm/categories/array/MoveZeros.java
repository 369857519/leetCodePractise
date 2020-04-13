package Algorithm.categories.array;

public class MoveZeros {
    public static void main(String[] args) {
        MoveZeros moveZeros=new MoveZeros();
        moveZeros.moveZeroes(new int[]{0,1,0,3,12});
    }
    public void moveZeroes(int[] nums) {
        //第一个非0的位置
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                int k=i;
                while(nums[k]!=0){
                    if(k-1>=0&&nums[k-1]==0){
                        nums[k-1]=nums[k];
                        nums[k]=0;
                    }
                }
            }
        }
    }
}
