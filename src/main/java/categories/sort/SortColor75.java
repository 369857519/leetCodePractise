package categories.sort;

public class SortColor75 {

	public static void main(String[] args) {
		SortColor75 sortColor = new SortColor75();
		sortColor.sortColorsWithSwap(new int[]{2, 0, 2, 1, 1, 0});
	}

	public void sortColorsWithSwap(int[] nums) {
		int i = 0, j = nums.length - 1;
		for (int k = 0; k <= j; k++) {
			if (nums[k] == 2) {
				while (k < j && nums[j] == 2) {
					j--;
				}
				swap(k, j, nums);
			}
			if (nums[k] == 0) {
				while (i < k && nums[i] == 0) {
					i++;
				}
				swap(k, i, nums);
			}
		}
	}

	public void swap(int left, int right, int[] nums) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}

	public void sortColors(int[] nums) {
		int red = 0, blue = 0, white = 0;
		for (int i = 0; i < nums.length; i++) {
			switch (nums[i]) {
				case 0:
					red++;
					break;
				case 1:
					blue++;
					break;
				case 2:
					white++;
					break;
			}
		}
		int blueStart = red + 1;
		int whiteStart = red + blue + 1;
		int end = nums.length;
		for (int i = 0; i < nums.length; i++) {
			if (i >= 0 && i < blueStart) {
				nums[i] = 0;
			} else if (i >= blueStart && i < whiteStart) {
				nums[i] = 1;
			} else {
				nums[i] = 2;
			}
		}
	}


}
