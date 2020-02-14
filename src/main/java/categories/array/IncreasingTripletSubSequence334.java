package categories.array;

public class IncreasingTripletSubSequence334 {

	public static void main(String[] args) {
		IncreasingTripletSubSequence334 increasingTripletSubSequence334 = new IncreasingTripletSubSequence334();
		boolean res = increasingTripletSubSequence334.increasingTriplet(new int[]{1, 2, 3, 4, 5});
		res = increasingTripletSubSequence334.increasingTriplet(new int[]{5, 4, 3, 2, 1});
		res = increasingTripletSubSequence334.increasingTriplet(new int[]{5, 4, 6, 9, 2, 1});
	}

	public boolean increasingTriplet(int[] nums) {
		if (nums.length < 3) {
			return false;
		}
		int min = Integer.MAX_VALUE, middle = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int now = nums[i];
			if (now <= min) {
				min = now;
			} else if (now < middle) {
				middle = now;
			} else if (now > middle) {
				return true;
			}
		}
		return false;
	}
}
