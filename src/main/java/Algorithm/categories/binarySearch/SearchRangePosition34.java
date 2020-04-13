package Algorithm.categories.binarySearch;

public class SearchRangePosition34 {

    public static void main(String[] args) {
        SearchRangePosition34 searchRangePosition35 = new SearchRangePosition34();
        int[] test = searchRangePosition35.searchRange(new int[]{1, 1, 2}, 1);
        test = searchRangePosition35.searchRange(new int[]{1, 3, 5, 6}, 5);
        test = searchRangePosition35.searchRange(new int[]{1, 3, 5, 6}, 6);
        test = searchRangePosition35.searchRange(new int[]{1}, 0);
        test = searchRangePosition35.searchRange(new int[]{1, 3}, 0);
        test = searchRangePosition35.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);

    }

    public int[] searchRange(int[] nums, int target) {
        int firstOne = binarySearch(nums, 0, nums.length, target);
        if (firstOne == -1) {
            return new int[]{-1, -1};
        }
        int left = 0;
        int right = firstOne;
        while (left < right) {
            int mid = left + right >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                if (mid - 1 < 0 || nums[mid - 1] < target) {
                    left = mid;
                    break;
                } else {
                    right = mid - 1;
                }
            }
        }
        int resLeft = left;
        left = firstOne;
        right = nums.length - 1;
        while (left < right) {
            int mid = left + right >>> 1;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                if (mid + 1 >= nums.length || nums[mid + 1] > target) {
                    right = mid;
                    break;
                } else {
                    left = mid + 1;
                }
            }
        }
        int resRight = right;
        return new int[]{resLeft, resRight};
    }

    public int binarySearch(int[] nums, int start, int end, int target) {
        end = end - 1;
        while (start <= end) {
            int mid = start + end >>> 1;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
