package ppp;

public class SingleNumberIII {

	public static void main(String[] args) {
			SingleNumberIII singleNumberIII=new SingleNumberIII();
			int[] res=singleNumberIII.singleNumber(new int[]{1,2,1,3,2,5});
	}

	public int[] singleNumber(int[] nums) {
		//获取高位
		int length = nums.length;
		int position = 0;
		int mark = 0;
		for (int i = 0; i < nums.length; i++) {
			mark ^= nums[i];
		}

		while (((mark >> position) & 1) == 0) {
			//可以找到最高的一位两个数字不同的情况
			position++;
		}

		int num1 = 0;
		int num2 = 0;
		for (int i = 0; i < nums.length; i++) {
			if (((nums[i] >> position) & 1) == 0) {
				num1 ^= nums[i];
			} else {
				num2 ^= nums[i];
			}
		}
		return new int[]{num1, num2};
	}
}
