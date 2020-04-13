package Algorithm.categories.binarySearch;

/**
 * Created by 祁连山 on 2019/5/12.
 */
public class SearchRotetedArray33 {

    public static void main(String[] args) {
        SearchRotetedArray33 searchRotetedArray33 = new SearchRotetedArray33();
        searchRotetedArray33.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
        searchRotetedArray33.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 8);
    }

    public int search(int[] nums, int target) {
        //找到中心点
        int start = 0, end = nums.length - 1, mid;
        while (true) {
            mid = start + end >> 1;
            if (nums[mid] > nums[start] && nums[mid] > nums[end]) {
                start = mid;
            } else if (nums[mid] < nums[start] && nums[mid] < nums[end]) {
                end = mid;
            } else {
                break;
            }
        }
        if (target > nums[0]) {
            return binarySearch(nums, 0, mid, target);
        } else {
            return binarySearch(nums, mid + 1, nums.length - 1, target);
        }
    }

    public int binarySearch(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = start + end >> 1;
            if (target > nums[mid]) {
                start = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
