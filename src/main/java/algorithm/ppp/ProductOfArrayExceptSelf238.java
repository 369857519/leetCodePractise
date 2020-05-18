package algorithm.ppp;

public class ProductOfArrayExceptSelf238 {

	public static void main(String[] args) {
		ProductOfArrayExceptSelf238 productOfArrayExceptSelf238 = new ProductOfArrayExceptSelf238();
		productOfArrayExceptSelf238.productExceptSelf(new int[]{1, 2, 3});
	}

	public int[] productExceptSelf(int[] nums) {
		if (nums.length == 1) {
			return new int[]{1};
		}
		int[] preMutiple = new int[nums.length];
		preMutiple[0] = 1;
		int[] postMutiple = new int[nums.length];
		postMutiple[nums.length - 1] = 1;
		for (int i = 1; i < nums.length; i++) {
			preMutiple[i] = preMutiple[i - 1] * nums[i-1];
		}
		for (int i = nums.length - 2; i >= 0; i--) {
			postMutiple[i] = postMutiple[i + 1] * nums[i + 1];
		}
		for (int i = 0; i < nums.length; i++) {
			preMutiple[i] = postMutiple[i] * preMutiple[i];
		}
		return preMutiple;
	}
}
