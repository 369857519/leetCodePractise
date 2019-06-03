package categories.dp;

public class RangeSumQuery307SegmentTree {

	public static void main(String[] args) {
		RangeSumQuery307SegmentTree numArray = new RangeSumQuery307SegmentTree(new int[]{1, 3, 5});
		int res = numArray.sumRange(0, 2);
		numArray.update(1, 2);
		res = numArray.sumRange(0, 2);
	}

	int[] tree;
	int n;

	public RangeSumQuery307SegmentTree(int[] nums) {
		if (nums.length > 0) {
			tree = new int[nums.length * 2];
			buildTree(nums);
		}
	}

	private void buildTree(int[] nums) {
		for (int i = n, j = 0; i < 2 * n; i++, j++) {
			tree[i] = nums[j];
		}
		for (int i = n - 1; i >= 0; i--) {
			tree[i] = tree[2 * n] + tree[2 * n - 1];
		}
	}

	public void update(int i, int val) {
		int ptr = i + n;
		int sub = val - tree[ptr];
		while (ptr > 0) {
			tree[i] += sub;
			i = i >>> 1;
		}
	}

	public int sumRange(int i, int j) {
		int l = i + n, r = j + n, sum = 0;
		while (l <= r) {
			//右节点
			if (l % 2 == 1) {
				sum += tree[l];
				l++;
			}
			if (r % 2 == 0) {
				sum += tree[r];
				r--;
			}
			l /= 2;
			r /= 2;
		}
		return sum;
	}
}
