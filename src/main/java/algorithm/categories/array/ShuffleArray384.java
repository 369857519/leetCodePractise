package algorithm.categories.array;

public class ShuffleArray384 {

	public static void main(String[] args) {
		ShuffleArray384 shuffleArray384 = new ShuffleArray384(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
		int[] res = shuffleArray384.shuffle();
		res = shuffleArray384.reset();
	}

	public ShuffleArray384(int[] nums) {
		this.nums = nums;
	}

	private int[] nums;

	/**
	 * Resets the array to its original configuration and return it.
	 */
	public int[] reset() {
		return nums;
	}

	/**
	 * Returns a random shuffling of the array.
	 */
	public int[] shuffle() {
		int[] shuffled = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			shuffled[i] = nums[i];
		}
		for (int i = 0; i < shuffled.length; i++) {
			swap(shuffled, i, i + (int) (Math.random() * (shuffled.length - i)));
		}
		return shuffled;
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
