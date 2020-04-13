package Algorithm.categories.array;

public class MergeSortedArray88 {

    public static void main(String[] args) {
        MergeSortedArray88 mergeSortedArray88 = new MergeSortedArray88();
        mergeSortedArray88.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{4, 5, 6}, 3);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[nums1.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (k < m + n) {
            if (i == m) {
                res[k++] = nums2[j++];
                continue;
            }
            if (j == n) {
                res[k++] = nums1[i++];
                continue;
            }
            if (nums1[i] <= nums2[j]) {
                res[k++] = nums1[i++];
            } else {
                res[k++] = nums2[j++];
            }
        }
        for (i = 0; i < m + n; i++) {
            nums1[i] = res[i];
        }
    }

}
