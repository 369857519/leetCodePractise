package algorithm.categories.array;

public class FindTheDuplicateNumber {

	public static void main(String[] args) {
		FindTheDuplicateNumber findTheDuplicateNumber = new FindTheDuplicateNumber();
		findTheDuplicateNumber.findDuplicate(new int[]{2, 6, 4, 1, 3, 1, 5});
	}

	public int findDuplicate(int[] nums) {
		int slow = nums[0];
		int quick = nums[0];
		do {
			slow = nums[slow];
			quick = nums[nums[quick]];
		} while (slow != quick);

		int ptr1 = nums[0];
		int ptr2 = slow;
		while (ptr1 != ptr2) {
			ptr1 = nums[ptr1];
			ptr2 = nums[ptr2];
		}
		return ptr2;
	}

}
